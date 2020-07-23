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
	Private tmr1 As Timer
End Sub

Sub Globals
	Private hc As HardwareClass
	Private lbldegress As Label
End Sub

Sub Activity_Create(FirstTime As Boolean)
	
	Activity.LoadLayout("frm1")
	hc.Initialize(Me,"DeviceData")
	Activity.Title = "تست سنسور نور"
	tmr1.Initialize("tmr1",1000)
	
End Sub

Sub DeviceData_ReceiveResult(Data As String)
	
	Data = Data.Replace("<","").Replace(">","")
	
	If IsNumber(Data) Then
		Dim degress As Float
		degress = Data
		degress = degress * 100 / 1024
		lbldegress.Text = NumberFormat(degress,0,1) & " %"
	Else
		Log(Data)
	End If
	
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)
	hc.Logout
	Activity.Finish
End Sub

Sub btndo_Click
	
	hc.ChoosePairDevice
	hc.ConnectToDevice
	tmr1.Enabled = True
End Sub

Sub tmr1_Tick
	hc.ReadSensor("1")
End Sub

Sub btnlogin_Click
	hc.Login("IRAN")
End Sub

Sub btnlogout_Click
	hc.Logout
End Sub