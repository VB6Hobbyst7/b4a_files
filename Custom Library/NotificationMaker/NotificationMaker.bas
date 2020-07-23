B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=7.8
@EndOfDesignText@
Private Sub Class_Globals
	Private NB As NotificationBuilder
End Sub

'Add resource folder in root
Public Sub Initialize As NotificationMaker
	
	NB.Initialize
	NB.ShowTime 	= False
	NB.AutoCancel	= False
	NB.DefaultLight	= False
	NB.DefaultSound = False
	NB.DefaultVibrate = False
	NB.OnlyAlertOnce  = False
	NB.Ticker		= ""
	NB.UsesChrono	= False
	NB.OnGoingEvent = False
	NB.When			= 0
	
	Return Me
	
End Sub

'add sound file to root dir
'not working in asset or internal
'<code>cn.CustomSound = "file:///sdcard/notification/ringer.mp3"</code>
Public Sub CustomSound(Path As String) As NotificationMaker
	NB.CustomSound		= Path
	Return Me
End Sub

'add custom vibrate to notification
'<code>
'Dim v() As Long
'v = Array As Long(0, 100, 200, 300, 400)
'</code>
Public Sub CustomVibrate(Vibrate() As Long) As NotificationMaker
	NB.CustomVibrate		= Vibrate
	Return Me
End Sub

Public Sub ShowTime As NotificationMaker
	NB.ShowTime		= True
	Return Me
End Sub

'the notification's priority
Public Sub Priority(Value As Int) As NotificationMaker
	NB.Priority		= Value
	Return Me
End Sub

Public Sub OnGoingEvent As NotificationMaker
	NB.OnGoingEvent		= True
	Return Me
End Sub

Public Sub AutoCancel As NotificationMaker
	NB.AutoCancel		= True
	Return Me
End Sub

Public Sub DefaultLight As NotificationMaker
	NB.DefaultLight		= True
	Return Me
End Sub

Public Sub DefaultSound As NotificationMaker
	NB.DefaultSound		= True
	Return Me
End Sub

Public Sub DefaultVibrate As NotificationMaker
	NB.DefaultVibrate	= True
	Return Me
End Sub

Public Sub OnlyAlertOnce As NotificationMaker
	NB.OnlyAlertOnce	= True
	Return Me
End Sub

'place icon file in res/drawable and set icon name in function
Public Sub SmallIcon(Value As String) As NotificationMaker
	NB.SmallIcon		= Value
	Return Me
End Sub

'place icon file in res/drawable and set icon name in function
Public Sub LargeIcon(Value As Bitmap) As NotificationMaker
	NB.LargeIcon		= Value
	Return Me
End Sub

Public Sub UsesChrono As NotificationMaker
	NB.UsesChrono		= True
	Return Me
End Sub

'when user click on notification,this intent started
Public Sub SetIntent(Intent As Intent) As NotificationMaker
	NB.setIntent(Intent)
	Return Me
End Sub

'when user click on notification,this activity started
Public Sub SetActivity(Activity As Object) As NotificationMaker
	NB.setActivity(Activity)
	Return Me
End Sub

Public Sub SetParentActivity(Activity As Object) As NotificationMaker
	NB.setParentActivity(Activity)
	Return Me
End Sub

'when notification deleted,this service starting
Public Sub SetDeleteService(Service As Object) As NotificationMaker
	NB.setDeleteService(Service)
	Return Me
End Sub

Public Sub When(StartDateTime As Long) As NotificationMaker
	NB.When	=	StartDateTime
	Return Me
End Sub

'add action button and connect button to activity
'add icon to res/drawable and use icon's name without extension
'for get tag when user click on notification and go to activity,use below code
'<code>
'
'</code>
Public Sub AddAction(Icon As String,Title As String,Tag As Object,Activity As Object) As NotificationMaker
	NB.AddAction(Icon,Title,Tag,Activity)
	Return Me
End Sub

'add action button and connect button to service
'add icon to res/drawable and use icon's name without extension
'for get tag when user click on notification and go to service,use below code
'<code>
'
'</code>
Public Sub AddAction2(Icon As String,Title As String,Tag As Object,Service As Object) As NotificationMaker
	NB.AddAction2(Icon,Title,Tag,Service)
	Return Me
End Sub

Public Sub AddProgress(MaxProgress As Int,Progress As Int,Indeterminate As Boolean) As NotificationMaker
	NB.setProgress(MaxProgress,Progress,Indeterminate)
	Return Me
End Sub

Sub ShowSimple(Title As String,Body As String,Summary As String,ContentInfo As String,Tag As Object,NotifyID As Int)
	
	Dim sT As NotificationBigTextStyle
	sT.Initialize
	sT.BigContentTitle = Title
	sT.BigText = Body
	
	NB.ContentTitle	= Title
	NB.ContentText	= Body
	
	If Summary.Length > 0 Then 		sT.SummaryText = Summary
	If ContentInfo.Length > 0 Then	NB.ContentInfo = ContentInfo

	NB.Tag	=	Tag
	NB.SetStyle(sT)
	NB.Notify(NotifyID)
 
End Sub

'maximum lines is 5
Sub ShowInbox(Title As String,Body As String,Summary As String,Lines() As String,Tag As Object,NotifyID As Int)
	
	Dim sT As NotificationInboxStyle
	sT.Initialize
	sT.BigContentTitle = Title
	
	For i = 0 To Lines.Length - 1
		sT.AddLine = Lines(i)
	Next
	
	NB.ContentTitle	= Title
	NB.ContentText	= Body
	
	If Summary.Length > 0 Then 		sT.SummaryText = Summary

	NB.Tag	=	Tag
	NB.SetStyle(sT)
	NB.Notify(NotifyID)
 
End Sub

Sub ShowPicture(Title As String,Body As String,Summary As String,BigPicture As Bitmap,Tag As Object,NotifyID As Int)
	
	Dim big_bmp As NotificationBigPictureStyle
	big_bmp.Initialize
	big_bmp.BigPicture		=	BigPicture
	big_bmp.SummaryText		=	Summary
	big_bmp.BigContentTitle	=	Title
	
	NB.ContentTitle	= Title
	NB.ContentText	= Body
	
	NB.SetStyle(big_bmp)
	
	If Summary.Length > 0 Then 		big_bmp.SummaryText = Summary

	NB.Tag	=	Tag
	NB.SetStyle(big_bmp)
	NB.Notify(NotifyID)
 
End Sub

Sub Cancel(NotifyID As Int)
	NB.Cancel(NotifyID)
End Sub

Sub GetNotification As Notification
	Return NB.GetNotification
End Sub

'auto detect Data type
'example if you enter http:\\google.com,intent open this url in browser
Sub MakeIntentView(Data As String) As Intent
	Dim int1 As Intent
	int1.Initialize(int1.ACTION_VIEW,Data)
	Return int1
End Sub