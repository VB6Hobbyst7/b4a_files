Type=Class
Version=7.28
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
'version 2.62
'Class module
Sub Class_Globals
	Public JobName As String
	Public Success As Boolean
	Public Username, Password As String
	Public ErrorMessage As String
	Private target As Object
#if B4A or B4J
	Private taskId As String
	Private req As OkHttpRequest
#Else
	Private req As HttpRequest
	Private res As HttpResponse
#End If
	Public Tag As Object
	Type MultipartFileData (Dir As String, FileName As String, KeyName As String, ContentType As String)
#If B4J AND UI
	Private fx As JFX
#End If
End Sub

'Initializes the Job.
'Name - The job's name. Note that the name doesn't need to be unique.
'TargetModule - The activity or service that will handle the JobDone event.
Public Sub Initialize (Name As String, TargetModule As Object)
	JobName = Name
	target = TargetModule
End Sub
'Sends a POST request with the given data as the post data.
Public Sub PostString(Link As String, Text As String)
	PostBytes(Link, Text.GetBytes("UTF8"))
End Sub

'Sends a POST request with the given string as the post data
Public Sub PostBytes(Link As String, Data() As Byte)
	req.InitializePost2(Link, Data)
	CallSubDelayed2(HttpUtils2Service, "SubmitJob", Me)
End Sub

'Sends a PUT request with the given data as the post data.
Public Sub PutString(Link As String, Text As String)
	PutBytes(Link, Text.GetBytes("UTF8"))
End Sub

'Sends a PUT request with the given string as the post data
Public Sub PutBytes(Link As String, Data() As Byte)
	req.InitializePut2(Link, Data)
	CallSubDelayed2(HttpUtils2Service, "SubmitJob", Me)
End Sub

'Sends a PATCH request with the given string as the request payload.
Public Sub PatchString(Link As String, Text As String)
	PatchBytes(Link, Text.GetBytes("UTF8"))
End Sub

'Sends a PATCH request with the given data as the request payload.
Public Sub PatchBytes(Link As String, Data() As Byte)
#If B4i
	req.InitializeGet(Link)
	Dim no As NativeObject = req
	no = no.GetField("object")
	no.RunMethod("setHTTPMethod:", Array("PATCH"))
	no.RunMethod("setHTTPBody:", Array(no.ArrayToNSData(Data)))
#Else
	req.InitializePatch2(Link, Data)

#End If
	CallSubDelayed2(HttpUtils2Service, "SubmitJob", Me)
End Sub


'Sends a HEAD request.
Public Sub Head(Link As String)
	req.InitializeHead(Link)
	CallSubDelayed2(HttpUtils2Service, "SubmitJob", Me)
End Sub

'Sends a multipart POST request.
'NameValues - A map with the keys and values. Pass Null if not needed.
'Files - List of MultipartFileData items. Pass Null if not needed.
Public Sub PostMultipart(Link As String, NameValues As Map, Files As List)
	Dim boundary As String = "---------------------------1461124740692"
	Dim stream As OutputStream
	stream.InitializeToBytesArray(0)
	Dim b() As Byte
	Dim eol As String = Chr(13) & Chr(10)
	Dim empty As Boolean = True
	If NameValues <> Null And NameValues.IsInitialized Then
		For Each key As String In NameValues.Keys
			Dim value As String = NameValues.Get(key)
			empty = MultipartStartSection (stream, empty)
			Dim s As String = _
$"--${boundary}
Content-Disposition: form-data; name="${key}"

${value}"$
			b = s.Replace(CRLF, eol).GetBytes("UTF8")
			stream.WriteBytes(b, 0, b.Length)
		Next
	End If
	If Files <> Null And Files.IsInitialized Then
		For Each fd As MultipartFileData In Files
			empty = MultipartStartSection (stream, empty)
			Dim s As String = _
$"--${boundary}
Content-Disposition: form-data; name="${fd.KeyName}"; filename="${fd.FileName}"
Content-Type: ${fd.ContentType}

"$
			b = s.Replace(CRLF, eol).GetBytes("UTF8")
			stream.WriteBytes(b, 0, b.Length)
			Dim in As InputStream = File.OpenInput(fd.Dir, fd.FileName)
			File.Copy2(in, stream)
		Next
	End If
	empty = MultipartStartSection (stream, empty)
	s = _
$"--${boundary}--
"$
	b = s.Replace(CRLF, eol).GetBytes("UTF8")
	stream.WriteBytes(b, 0, b.Length)
	PostBytes(Link, stream.ToBytesArray)
	req.SetContentType("multipart/form-data; boundary=" & boundary)
	req.SetContentEncoding("UTF8")
End Sub

Private Sub MultipartStartSection (stream As OutputStream, empty As Boolean) As Boolean
	If empty = False Then
		stream.WriteBytes(Array As Byte(13, 10), 0, 2)
	Else
		empty = False
	End If
	Return empty
End Sub

'Sends a POST request with the given file as the post data.
'This method doesn't work with assets files.
Public Sub PostFile(Link As String, Dir As String, FileName As String)
#if B4i
	req.InitializePost(Link, Dir, FileName)
	CallSubDelayed2(HttpUtils2Service, "SubmitJob", Me)
#Else
	Dim length As Int
	If Dir = File.DirAssets Then
		Log("Cannot send files from the assets folder.")
		Return
	End If
	length = File.Size(Dir, FileName)
	Dim In As InputStream
	In = File.OpenInput(Dir, FileName)
	If length < 1000000 Then '1mb
		'There are advantages for sending the file as bytes array. It allows the Http library to resend the data
		'if it failed in the first time.
		Dim out As OutputStream
		out.InitializeToBytesArray(length)
		File.Copy2(In, out)
		PostBytes(Link, out.ToBytesArray)
	Else
		req.InitializePost(Link, In, length)
		CallSubDelayed2(HttpUtils2Service, "SubmitJob", Me)
	End If
#End If
End Sub
'Submits a HTTP GET request.
'Consider using Download2 if the parameters should be escaped.
Public Sub Download(Link As String)
	req.InitializeGet(Link)
	CallSubDelayed2(HttpUtils2Service, "SubmitJob", Me)
End Sub

'Submits a HTTP GET request.
'Encodes illegal parameter characters.
'<code>Example:
'job.Download2("http://www.example.com", _
'	Array As String("key1", "value1", "key2", "value2"))</code>
Public Sub Download2(Link As String, Parameters() As String)
	req.InitializeGet(escapeLink(Link, Parameters))
	CallSubDelayed2(HttpUtils2Service, "SubmitJob", Me)
End Sub

Private Sub escapeLink(Link As String, Parameters() As String) As String
	Dim sb As StringBuilder
	sb.Initialize
	sb.Append(Link)
	If Parameters.Length > 0 Then sb.Append("?")
	Dim su As StringUtils
	For i = 0 To Parameters.Length - 1 Step 2
		If i > 0 Then sb.Append("&")
		sb.Append(su.EncodeUrl(Parameters(i), "UTF8")).Append("=")
		sb.Append(su.EncodeUrl(Parameters(i + 1), "UTF8"))
	Next
	Return sb.ToString
End Sub


Public Sub Delete(Link As String)
	req.InitializeDelete(Link)
	CallSubDelayed2(HttpUtils2Service, "SubmitJob", Me)
End Sub

Public Sub Delete2(Link As String, Parameters() As String)
	req.InitializeDelete(escapeLink(Link, Parameters))
	CallSubDelayed2(HttpUtils2Service, "SubmitJob", Me)
End Sub

'Should be called to free resources held by this job.
Public Sub Release
#If B4A or B4J
	File.Delete(HttpUtils2Service.TempFolder, taskId)
#End If
End Sub

'Returns the response as a string encoded with UTF8.
Public Sub GetString As String
	Return GetString2("UTF8")
End Sub

'Returns the response as a string.
Public Sub GetString2(Encoding As String) As String
#if B4i
	Return res.GetString2(Encoding)
#else
	Dim tr As TextReader
	tr.Initialize2(File.OpenInput(HttpUtils2Service.TempFolder, taskId), Encoding)
	Dim res As String = tr.ReadAll
	tr.Close
	Return res
#End If
End Sub

#If B4J Or B4A
'Called by the service to get the request
Public Sub GetRequest As OkHttpRequest
	Return req
End Sub

'Called by the service when job completes
Public Sub Complete (id As Int)
	taskId = id
	CallSubDelayed2(target, "JobDone", Me)
End Sub

#If B4J AND UI
'Returns the response as a bitmap
Public Sub GetBitmap As Image
	Dim b As Image
	b = fx.LoadImage(HttpUtils2Service.TempFolder, taskId)
	Return b
End Sub

#Else If B4A
'Returns the response as a bitmap
Public Sub GetBitmap As Bitmap
	Dim b As Bitmap
	b = LoadBitmap(HttpUtils2Service.TempFolder, taskId)
	Return b
End Sub
'Returns the response as a bitmap loaded with LoadBitmapSample.
'<b>It is recommended to use GetBitmapResize instead.</b>
Public Sub GetBitmapSample(Width As Int, Height As Int) As Bitmap
	Return LoadBitmapSample(HttpUtils2Service.TempFolder, taskId, Width, Height)
End Sub
'Returns the response as a bitmap loaded LoadBitmapResize.
Public Sub GetBitmapResize(Width As Int, Height As Int, KeepAspectRatio As Boolean) As Bitmap
	Return LoadBitmapResize(HttpUtils2Service.TempFolder, taskId, Width, Height, KeepAspectRatio)
End Sub
#End If

'Returns the response input stream.
Public Sub GetInputStream As InputStream
	Dim In As InputStream
	In = File.OpenInput(HttpUtils2Service.TempFolder, taskId)
	Return In
End Sub
#Else If B4i
'Called by the service to get the request
Public Sub GetRequest As HttpRequest
	Return req
End Sub

'Called by the service when job completes
Public Sub Complete (res1 As HttpResponse)
	res = res1
	CallSub2(target, "JobDone", Me)
End Sub
	'Returns the response as a bitmap
Public Sub GetBitmap As Bitmap
	Dim b As Bitmap
	b.Initialize2(res.GetInputStream)
	Return b
End Sub

'Returns the response as a bitmap loaded LoadBitmapResize.
Public Sub GetBitmapResize(Width As Int, Height As Int, KeepAspectRatio As Boolean) As Bitmap
	Return GetBitmap.Resize(Width, Height, KeepAspectRatio)
End Sub

'Returns the response input stream.
Public Sub GetInputStream As InputStream
	Return res.GetInputStream
End Sub
#End If