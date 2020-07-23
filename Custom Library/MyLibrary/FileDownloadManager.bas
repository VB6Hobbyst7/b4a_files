B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=8.3
@EndOfDesignText@
#Event: Complete(Status As Boolean)
#Event: NotificationClick

Private Sub Class_Globals
	Private DownloadManager1 As DownloadManager
	Private ReasonTextMap As Map
	Private StatusTextMap As Map
	Private IsInitialized As Boolean=False
	Private url2 As String
	Private DownloadId As Long
	Private DownloadManagerRequest1 As DownloadManagerRequest
	Private my_module As Object
	Private my_event As String
End Sub

'Please enable WRITE_EXTERNAL_STORAGE permission
'<code>AddPermission(android.permission.WRITE_EXTERNAL_STORAGE)</code>
Public Sub Initialize(Module As Object,Event As String,Url As String)
	
	DownloadManager1.RegisterReceiver("DownloadManager1")
	
	ReasonTextMap.Initialize
	ReasonTextMap.Put(DownloadManager1.ERROR_CANNOT_RESUME, "ERROR_CANNOT_RESUME")
	ReasonTextMap.Put(DownloadManager1.ERROR_DEVICE_NOT_FOUND, "ERROR_DEVICE_NOT_FOUND")
	ReasonTextMap.Put(DownloadManager1.ERROR_FILE_ALREADY_EXISTS, "ERROR_FILE_ALREADY_EXISTS")
	ReasonTextMap.Put(DownloadManager1.ERROR_FILE_ERROR, "ERROR_FILE_ERROR")
	ReasonTextMap.Put(DownloadManager1.ERROR_HTTP_DATA_ERROR, "ERROR_HTTP_DATA_ERROR")
	ReasonTextMap.Put(DownloadManager1.ERROR_INSUFFICIENT_SPACE, "ERROR_INSUFFICIENT_SPACE")
	ReasonTextMap.Put(DownloadManager1.ERROR_TOO_MANY_REDIRECTS, "ERROR_TOO_MANY_REDIRECTS")
	ReasonTextMap.Put(DownloadManager1.ERROR_UNHANDLED_HTTP_CODE, "ERROR_UNHANDLED_HTTP_CODE")
	ReasonTextMap.Put(DownloadManager1.ERROR_UNKNOWN, "ERROR_UNKNOWN")
	ReasonTextMap.Put(DownloadManager1.PAUSED_QUEUED_FOR_WIFI, "PAUSED_QUEUED_FOR_WIFI")
	ReasonTextMap.Put(DownloadManager1.PAUSED_UNKNOWN, "PAUSED_UNKNOWN")
	ReasonTextMap.Put(DownloadManager1.PAUSED_WAITING_FOR_NETWORK, "PAUSED_WAITING_FOR_NETWORK")
	ReasonTextMap.Put(DownloadManager1.PAUSED_WAITING_TO_RETRY, "PAUSED_WAITING_TO_RETRY")
		
	StatusTextMap.Initialize
	StatusTextMap.Put(DownloadManager1.STATUS_FAILED, "STATUS_FAILED")
	StatusTextMap.Put(DownloadManager1.STATUS_PAUSED, "STATUS_PAUSED")
	StatusTextMap.Put(DownloadManager1.STATUS_PENDING, "STATUS_PENDING")
	StatusTextMap.Put(DownloadManager1.STATUS_RUNNING, "STATUS_RUNNING")
	StatusTextMap.Put(DownloadManager1.STATUS_SUCCESSFUL, "STATUS_SUCCESSFUL")
	
	url2		=	Url
	my_module	=	Module
	my_event	=	Event
	
	DownloadManagerRequest1.Initialize(Url)
	Return Me
	
End Sub

Private Sub GetReasonText(Index As Int) As String
	Return ReasonTextMap.Get(Index)
End Sub

Private Sub GetStatusText(Index As Int) As String
	Return StatusTextMap.Get(Index)
End Sub

Public Sub SetShowUI(Val As Boolean) As FileDownloadManager
	DownloadManagerRequest1.VisibleInDownloadsUi	=	Val
	Return Me
End Sub

Public Sub SetOutputFilename(Dir As String,Filename As String) As FileDownloadManager
	DownloadManagerRequest1.DestinationUri	=	"file://"	&	File.Combine(Dir, Filename)
	Return Me
End Sub

Public Sub SetTitle(Val As String) As FileDownloadManager
	DownloadManagerRequest1.Title	=	Val
	Return Me
End Sub

Public Sub SetDescription(Val As String) As FileDownloadManager
	DownloadManagerRequest1.Description	=	Val
	Return Me
End Sub

Public Sub SetHeader(Key As String,Value As String) As FileDownloadManager
	DownloadManagerRequest1.AddRequestHeader(Key,Value)
	Return Me
End Sub

Public Sub SetMimeType(sType As String) As FileDownloadManager
	DownloadManagerRequest1.MimeType	=	sType
	Return Me
End Sub

Public Sub Download
	DownloadId	=	DownloadManager1.Enqueue(DownloadManagerRequest1)
End Sub

Public Sub Cancel
	DownloadManager1.Remove(DownloadId)
End Sub

Private Sub DownloadManager1_DownloadComplete(DownloadId1 As Long)
	
	If DownloadId	=	DownloadId1 Then

		Dim DownloadManagerQuery1 As DownloadManagerQuery
		DownloadManagerQuery1.Initialize
		DownloadManagerQuery1.SetFilterById(DownloadId)
			
		Dim StatusCursor As Cursor
		StatusCursor	=	DownloadManager1.Query(DownloadManagerQuery1)
		
		If StatusCursor.RowCount > 0 Then
			
			StatusCursor.Position=0
				
			Dim StatusInt As Int
			StatusInt=StatusCursor.getInt(DownloadManager1.COLUMN_STATUS)

			If StatusInt=DownloadManager1.STATUS_FAILED Or StatusInt=DownloadManager1.STATUS_PAUSED Then
				If IsPaused(my_module) = False Then CallSubDelayed2(my_module,my_event.ToLowerCase & "_complete",False)
			Else
				If IsPaused(my_module) = False Then CallSubDelayed2(my_module,my_event.ToLowerCase & "_complete",True)
			End If

		Else
			If IsPaused(my_module) = False Then CallSubDelayed2(my_module,my_event.ToLowerCase & "_complete",False)
			Log("The DownloadManager has no trace of our request, it could have been cancelled by the user using the Android Downloads app or an unknown error has occurred.")
		End If
			
		'	free system resources
		StatusCursor.Close
		DownloadManager1.UnregisterReceiver
	
	End If
	
End Sub

Private Sub DownloadManager1_NotificationClicked(DownloadIds() As Long)
	If IsPaused(my_module) = False Then CallSubDelayed2(my_module,my_event.ToLowerCase & "_notificationclick",False)
End Sub