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
	Private tmr As Timer
End Sub

Sub Globals
	Private lblstate As Label
	Private hc As HardwareClass
End Sub

Sub Activity_Create(FirstTime As Boolean)
 	Activity.LoadLayout("frmreleh")
	hc.Initialize(Me,"DeviceData")
	hc.ChoosePairDevice
	hc.ConnectToDevice
	tmr.Initialize("tmr1",200)
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)
	hc.Logout
	Activity.Finish
End Sub

Sub btnon_Click
	lblstate.Text = "در باز شد"
	hc.TurnOnRelay
	tmr.Enabled = True
End Sub

Sub tmr1_Tick
	tmr.Enabled = False
	hc.TurnOffRelay
End Sub
