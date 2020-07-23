Type=Class
Version=5.8
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
#Event: ReceiveResult As String

Private Sub Class_Globals
	Private s1 As Serial
	Private ChoosenDevice As Object
	Private wr As TextWriter
	Private rr As TextReader
	Private tmr1 As Timer
	Private modules As Object
	Private evt As String
	Private IsConnect As Boolean = False
	
	Public LED_BRIGHT_0 As String = "@"
	Public LED_BRIGHT_10 As String = "A"
	Public LED_BRIGHT_20 As String = "B"
	Public LED_BRIGHT_30 As String = "C"
	Public LED_BRIGHT_40 As String = "D"
	Public LED_BRIGHT_50 As String = "E"
	Public LED_BRIGHT_60 As String = "F"
	Public LED_BRIGHT_70 As String = "G"
	Public LED_BRIGHT_80 As String = "H"
	Public LED_BRIGHT_90 As String = "I"
	Public LED_BRIGHT_100 As String = "J"
	
	Public ERROR_LOGIN As String = "<ERROR>"
	Public ERROR_INVALID_COMMAND  As String = "<NC>"
	
End Sub

Public Sub Initialize(Module As Object,ReceiveEvent As String)
	
	modules = Module
	evt = ReceiveEvent
	
	s1.Initialize("serial1")
	
	If s1.IsEnabled = False Then
		ToastMessageShow("لطفا بلوتوث خود را فعال کنید",True)
		Return
	End If
	
	Dim m1 As Map
	m1.Initialize
	m1 = s1.GetPairedDevices

End Sub

Public Sub ChoosePairDevice
	
	Dim m1 As Map
	Dim l1 As List
	m1.Initialize
	l1.Initialize
	
	If s1.IsInitialized = False Then
		ToastMessageShow("لطفا کتابخانه را Initlize کنید",False)
		Return	
	End If
	
	m1 = s1.GetPairedDevices
	
	For i = 0 To m1.Size - 1
		l1.Add(m1.GetKeyAt(i))
	Next
	
	Dim j As Int
	j = InputList(l1,"لطفا دستگاه کنترل کننده را انتخاب کنید",-1)
	
	If j > -1 Then
		ChoosenDevice = m1.GetValueAt(j)	
	Else
		ChoosenDevice = Null
	End If
	
End Sub

Public Sub ConnectToDevice
	
	If ChoosenDevice = Null Then
		ToastMessageShow("لطفا دستگاه کنترل کننده را انتخاب سپس وصل شوید",False)
		Return
	End If
	
	s1.Connect(ChoosenDevice)
	
End Sub

Public Sub DisconnectDevice
	SendData("EXIT" & CRLF)
	s1.Disconnect
	tmr1.Enabled = False
End Sub

Private Sub serial1_Connected (Success As Boolean)
	
	If Success = True Then
		wr.Initialize(s1.OutputStream)
		rr.Initialize(s1.InputStream)
		IsConnect = True
		tmr1.Initialize("tmr1",500)
		tmr1.Enabled = True
		ToastMessageShow("گوشی با موفقیت به دستگاه وصل شد",False)
	Else
		IsConnect = False
		ToastMessageShow("اتصال با خطا مواجه شد",False)
	End If
	
End Sub

Private Sub tmr1_Tick
 
	If rr.Ready = True Then
		If SubExists(modules,evt & "_" & "ReceiveResult") Then
			CallSub2(modules,evt & "_" & "ReceiveResult",rr.ReadLine)
		End If
	End If
	
End Sub

Private Sub SendData(Data As String)
	
	If IsConnect = True Then
		wr.Write(Data)
		wr.Flush
	Else
		ToastMessageShow("لطفا به دستگاه وصل سپس دیتا ارسال کنید",False)	
	End If
	
End Sub

Public Sub TurnOnRelay
	SendData("RS" & CRLF)
End Sub

Public Sub TurnOffRelay
	SendData("RC" & CRLF)
End Sub

Public Sub ReadSensor(ChannelID As String)
	SendData("AD" & ChannelID & CRLF)
End Sub

Public Sub SetDevicePassword(Password As String)
	SendData("R" & Password & CRLF)
End Sub

Public Sub ChangeLEDBright(State As String)
	SendData("PO" & State & CRLF)
End Sub

Public Sub TurnOffLED
	SendData("PO@" & CRLF)
	SendData("PF" & CRLF)
End Sub

Public Sub Write(Arg As String)
	SendData(Arg & CRLF)
End Sub

Public Sub Login(Password As String)
	SendData(Password & CRLF)
End Sub

Public Sub Logout
	SendData("EXIT" & CRLF)
End Sub