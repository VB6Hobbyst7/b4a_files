B4A=true
Group=Libraries
ModulesStructureVersion=1
Type=Service
Version=7.3
@EndOfDesignText@
#if b4a
#Region  Service Attributes 
	#StartAtBoot: False
	#IgnoreWarnings: 25
#End Region
#end if

'Event: Sub Result(Result As Map,Status As Boolean)

'If job is fail,I raise event JobError(Error As Map)

'Job raise event with below argument
'Event _Result(Data As Map,Status As Boolean)
'If interface couldn't receive result,it return null data and false status

Sub Process_Globals
	Public StoreData	As Map
	Public Queue2		As Map
End Sub

Sub Service_Create
	StoreData.Initialize
	Queue2.Initialize
End Sub

#if b4a
Sub Service_Start (StartingIntent As Intent)
	
End Sub

Sub Service_Destroy

End Sub
#end if

'Add below field to Map
'dir 		: for save file in directory
'filename	: for save file with filename
'url		: url of file for download
'store		: save output in cache
Public Sub Download(Fields As Map)
	
	Dim OutputDir,OutputFilename,Url As String
	
	OutputDir		=	Fields.Get("dir")
	OutputFilename	=	Fields.Get("filename")
	Url				=	Fields.Get("url")
	
	Dim tags As Map
	tags.Initialize
	tags.Put("dir",OutputDir)
	tags.Put("filename",OutputFilename)
	tags.Put("url",Url)
	
	If Fields.ContainsKey("store") Then
		tags.Put("store",Fields.Get("store"))
	End If
	
	download_file(Url,Fields)

End Sub

Private Sub download_file(Url As Object,Fields As Object)
	
	Dim job As HttpJob
	job.Initialize("download",Me)
	job.Download(Url)
	job.Tag		=	Fields
	job.GetRequest.SetHeader("Cache-Control","no-store, no-cache, must-revalidate, max-age=0")
	job.GetRequest.Timeout	=	50000
	
End Sub

Sub thread_Ended(fail As Boolean, error As String) 'An error or Exception has occurred in the Thread
	Log(error)
End Sub

Sub exeucute_request_Ended(fail As Boolean, error As String) 'An error or Exception has occurred in the Thread
	Log(error)
End Sub

'Arg contain below key
'Method  : Type of Request(POST,PUT,DELETE,GET) 
'Segment : Name of method that have to execute
'Fields  : Key of query that have to send to Segment
'Module  : The module that call this event
'Event   : Event name that interface have to call it
'Force   : If it exist so save request and resend it again after connected internet
'
'If method is FILE so we have to add FileItem to list example here
'Dim ft As MultipartFileData
'ft.Initialize
'ft.KeyName		= "upload"
'ft.Dir			= FileDir
'ft.FileName	= FileName
'
'Dim lst as List
'lst.Initialize
'lst.Add(ft)

Public Sub ExecuteRequest(Arg As Map,Headers As Map)
	exeucute_request(Arg,Headers)
End Sub

Private Sub exeucute_request(Arg2 As Object,Headers2 As Object)

	Dim Arg,Headers As Map
	Arg		=	Arg2
	Headers	=	Headers2
	
	Dim Method,Segment,Url As String
	Dim Fields As Map
	
	Method 	= Arg.Get("method")
	Method 	= Method.ToUpperCase
	Segment	= Arg.Get("segment")
	Fields	= Arg.Get("fields")
	
	If Arg.ContainsKey("url") Then
		Url	=	Arg.Get("url")
	Else
		Url		= Configuration.URL_ & Segment
	End If
	
	#if debug
	Log(Url)
	#End If
	
	Dim job As HttpJob
	job.Initialize("request",Me)
	job.Tag	=	Arg
	
	#region Add Field to body
	Dim query As String
	
	If Fields <> Null And Fields.IsInitialized And Fields.Size > 0 Then
		For Each v1 As String In Fields.Keys
			query = query & v1 & "=" & Fields.Get(v1) & "&"
		Next
		query = query.SubString2(0,query.Length-1) & "&vc=" & Application.VersionCode & "&vn=" & Application.VersionName & "&pn=" & Application.PackageName & "&os=android"
	Else
		query	=	"vc=" & Application.VersionCode & "&vn=" & Application.VersionName & "&pn=" & Application.PackageName & "&os=android"
	End If
	#end region
	
	#region Detect Method(POST,DELETE or ...)
	If Method = "POST" Then
		job.PostString(Url,query)
		
	Else If Method = "PUT" Then
		job.PostString(Configuration.URL_ & Segment,"")
		job.GetRequest.InitializePut2(Url,query.GetBytes("UTF8"))
		job.GetRequest.SetContentType("x-www-form-urlencoded")
	
	Else If Method = "DELETE" Then
		job.PostString(Configuration.URL_ & Segment,query)
		job.GetRequest.SetContentType("x-www-form-urlencoded")
		job.GetRequest.InitializeDelete(Url)
	
	Else If Method = "GET" Then
		job.Download(Url & "?" & query)
	
	Else If Method = "FILE" Then
		Dim ListFiles As List
		ListFiles	=	Arg.Get("files")
		
		job.PostMultipart(Url,Fields,ListFiles)
		job.GetRequest.Timeout = 40000
	
	End If
	#end region
	
	#region Add Headers
	job.GetRequest.SetHeader("Cache-Control","no-store, no-cache, must-revalidate, max-age=0")
	job.GetRequest.SetHeader("user-agent","Custom user agent")
	If job.GetRequest.Timeout <> 40000 Then job.GetRequest.Timeout = 20000
	
	For Each Key As String In Headers.Keys
		job.GetRequest.SetHeader(Key,Headers.Get(Key))
	Next
	#end region
	
End Sub

Private Sub JobDone(HttpJob2 As HttpJob)
	
	Dim tag As Map
	tag = HttpJob2.Tag
	
	Dim Modules As Object
	Dim Evt As String

	Modules	=	tag.Get("module")
	Evt		=	tag.Get("event") & "_Result"
	
	If HttpJob2.Success Then
		
		#if debug
		Log(HttpJob2.GetString)
		#end If
		
		If HttpJob2.JobName = "request" Then
			
			#region Request Job	
			Dim rs As String
			rs = HttpJob2.GetString
			rs = rs.Replace("</div>","")
			
			Dim js As JSONParser
			js.Initialize(rs)
			
			Try
				Dim temp As Map
				temp = js.NextObject
				
				Dim temp2 As Map
				temp2.Initialize
				
				#if b4a
				If SubExists(Starter,"RequestHttpResult_Event") Then
					CallSub2(Starter,"RequestHttpResult_Event",temp)
				End If
				#else
				If SubExists(Main,"RequestHttpResult_Event",1) Then
					CallSub2(Main,"RequestHttpResult_Event",temp)
				End If
				#end if
				
				#if b4a
				If IsPaused(Modules) = False Then
					CallSub3(Modules,Evt,temp,temp.Get("status"))
				End If
				#else
				Try
					CallSub3(Modules,Evt,temp,temp.Get("status"))
				Catch
				End Try
				#end if
				
			Catch
				#if b4a
				If IsPaused(Modules) = False Then CallSub3(Modules,Evt,CreateMap("code":"0","error":rs),False)
				#else
				CallSub3(Modules,Evt,CreateMap("code":"0","error":rs),False)
				#end if
			End Try
			
			If tag.ContainsKey("force") Then
				Dim queue_id As String
				queue_id	=	tag.Get("queue_id")
				Queue2.Remove(queue_id)
			End If
			
			#end region
			
		Else if HttpJob2.JobName = "download" Then
			
			#region Download File
			Dim tag As Map
			tag	=	HttpJob2.Tag
			
			If tag.ContainsKey("store") Then
				StoreData.Put(tag.Get("store"),Json2Map(HttpJob2.GetString))
			Else
				Dim ou As OutputStream
				ou	=	File.OpenOutput(tag.Get("dir"),tag.Get("filename"),False)
				File.Copy2(HttpJob2.GetInputStream,ou)
				ou.Close
			End If
			
			If tag.ContainsKey("module") And tag.ContainsKey("event") Then
				CallSub(tag.Get("module"),tag.Get("event"))
			End If
			
			#end region
			
		End If
	Else
		
		Try
			#if debug
			Log(HttpJob2.GetString)
			#end If
		Catch
		 
		End Try
		#region Manage error job

		Dim error As Map
		error.Initialize
		
		Dim job_error As String
		job_error = HttpJob2.ErrorMessage.ToLowerCase
		
		If job_error.IndexOf("ResponseError. Reason: Service unavailable, Response: Service unavailable".ToLowerCase) > -1 Then
			error.Put("error","SERVICE_UNAVAIALBE")
		
		Else if job_error.IndexOf("java.net.UnknownHostException: Unable to resolve host".ToLowerCase) > -1 Then
			error.Put("error","HOST_UNAVAILABLE")
		
		Else if job_error.IndexOf("java.net.SocketTimeoutException".ToLowerCase) > -1 Then
			error.Put("error","NETWORK_ERROR")
			
		Else if job_error.IndexOf("ResponseError. Reason: java.net.ConnectException: Failed To connect".ToLowerCase) > -1 Then
			error.Put("error","ERROR_CONNECT")
		
		Else if job_error.IndexOf("android.os.NetworkOnMainThreadException".ToLowerCase) > -1 Then
			error.Put("error","ERROR_MAIN_THREAD")
		
		Else if job_error.IndexOf("java.net.connectexception: failed to connect to") > -1 Then
			error.Put("error","NOT_EXIST_HOST")
		
		Else if job_error.IndexOf("invalid api key") > -1 Or job_error.IndexOf("does not have enough permissions") > -1 Or job_error = "unknown error" Then
			#if b4i
			If SubExists(Main,"OnInvalidKey_Event",0) Then
				CallSubDelayed(Main,"OnInvalidKey_Event")
				Return
			End If
			#else
			If SubExists(Main,"OnInvalidKey_Event") Then
				CallSubDelayed(Main,"OnInvalidKey_Event")
				Return
			End If
			#end if
			
		Else
			error.Put("error",job_error)
			
		End If
		
		error.Put("tag",tag)
		
		Try
			#if b4a
			If IsPaused(Modules) = False Then			
				CallSub3(Modules,Evt,CreateMap("result":error.Get("error")),False)
			End If
			#else
			CallSub3(Modules,Evt,CreateMap("result":error.Get("error")),False)
			#end if
		Catch
			#if b4a
			If IsPaused(Modules) = False Then
				Try
					CallSub3(Modules,Evt,error.Get("error"),False)
				Catch
				End Try
			End If
			#else
			Try
				CallSub3(Modules,Evt,error.Get("error"),False)
			Catch
			End Try
			#end if
		End Try
		
		Try
			#if b4a
			If SubExists(Starter,"RequestHttpResult_Event") Then
				Dim temp As Map
				temp.Initialize
				temp.Put("status",False)
				CallSub2(Starter,"RequestHttpResult_Event",temp)
			End If
			#else
			Dim temp As Map
			temp.Initialize
			temp.Put("status",False)
			CallSub2(Main,"RequestHttpResult_Event",temp)
			#end if
		Catch
		End Try
		
		#end region
		
	End If
	
	#if b4a
	Try
		Sleep(3000)
		StopService(Me)
		Service.StopAutomaticForeground
		HttpJob2.Release
	Catch
	End Try
	#end if
	
End Sub

Private Sub Json2Map(JSON2 As String) As Map
	
	Dim js As JSONParser
	js.Initialize(JSON2)
	Try
		Return js.NextObject
	Catch
		Return Null
	End Try
	
End Sub

#if b4a
Private Sub CheckConnection As Boolean
	Dim r As Reflector
   
	r.Target = r.GetContext
	r.Target = r.RunMethod2("getSystemService", "connectivity", "java.lang.String")
	r.Target = r.RunMethod("getActiveNetworkInfo")
   
	If r.Target <> Null Then
		Return r.RunMethod("isConnected")
	End If
   
	Return False
End Sub
#end if