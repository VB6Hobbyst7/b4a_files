Type=Activity
Version=5.8
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: True
#End Region

Sub Process_Globals
 
End Sub

Sub Globals
	Private lblstate As Label
	Private hc As HardwareClass
End Sub

Sub Activity_Create(FirstTime As Boolean)
 	Activity.LoadLayout("frmlamp")
	hc.Initialize(Me,"DeviceData")
	hc.ChoosePairDevice
	hc.ConnectToDevice
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)
	hc.Logout
	Activity.Finish
End Sub

Sub btnon_Click
	lblstate.Text = "لامپ روشن شد"
	hc.TurnOnRelay
End Sub

Sub btnoff_Click
	hc.TurnOffRelay
	lblstate.Text = "لامپ خاموش شد"
End Sub