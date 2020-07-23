B4A=true
Group=Libraries\Main
ModulesStructureVersion=1
Type=Class
Version=7.3
@EndOfDesignText@
'Class module
'~1.8 seconds
Private Sub Class_Globals
 	Private Ti As Timer
	Private Timr As Timer
	Private I As Float
	Private TT As String

End Sub

'Initializes the Class
'ToastText = The text that will be displayed when the back button is clicked once
Public Sub Initialize (ToastText As String)
	I = 0
	Ti.Initialize ("Ti",1000)
	Ti.Enabled = True
	Timr.Initialize ("Timr",100)
	Timr.Enabled = True
	TT = ToastText
End Sub
Private Sub Ti_Tick

	If I > 0 Then
		I = I-0.49
	End If

End Sub
Private Sub Timr_Tick
	
	If I >= 2 Then
		Ti.Enabled = False
		Timr.Enabled = False
		Views.CloseActivities
	End If

End Sub
'Add this to the Activity_Keypress method
Public Sub TapToClose

	ToastMessageShow (TT,False)
	
	I = I+1.3
		
End Sub