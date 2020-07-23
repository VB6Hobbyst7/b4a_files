B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=7.8
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: False
#End Region

Sub Process_Globals
	Public Module As Object
	Public Event As String
	Public Dir,Filename As String
End Sub

Sub Globals
	Private SCV As Hitex_SimpleCropView
End Sub

Sub Activity_Create(FirstTime As Boolean)
	SCV.AddToActivity("SCV")
	Activity.Title	=	"Crop"
	SCV.setImageBitmap(Dir,Filename)
	SCV.
End Sub

Sub SCV_ButtonDoneClick
	SCV.StartCrop
End Sub

Sub SCV_onCropSuccess (Cropped As Bitmap)
	Log(Cropped)
End Sub

Sub SCV_onCropError
	Log("onCropError")
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub