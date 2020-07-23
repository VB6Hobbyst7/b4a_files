Type=Activity
Version=7.3
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: False
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

End Sub

Sub Globals
	Private btndontsend As Button
	Private btnsend As Button
End Sub

'SetActivityAttribute(reporterror, android:theme, @android:style/Theme.Translucent.NoTitleBar)
'SetActivityAttribute(reporterror, android:excludeFromRecents, "true")
Sub Activity_Create(FirstTime As Boolean)
	
	Activity.LoadLayout("frmerror_report")
	Activity.Color = Colors.Transparent
	
	SetColorStateList(btnsend,Colors.RGB(13,86,154),Colors.RGB(31,126,212),Colors.RGB(164,164,164))
	SetColorStateList(btndontsend,Colors.RGB(13,86,154),Colors.RGB(31,126,212),Colors.RGB(164,164,164))
	ChangeStatusColor(Colors.ARGB(100,79,79,79))
	
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub btnsend_Click
	
End Sub

Sub btndontsend_Click
	Activity.Finish
End Sub

Sub SetColorStateList(Btn As Button,Pressed As Int,Enabled As Int,Disabled As Int)

	Dim States(3,1) As Int
	States(0,0) = 16842919    'Pressed
	States(1,0) = 16842910    'Enabled
	States(2,0) = -16842910 'Disabled

	Dim Color(3) As Int = Array As Int(Pressed,Enabled,Disabled)

	Dim CSL As JavaObject
	CSL.InitializeNewInstance("android.content.res.ColorStateList",Array As Object(States,Color))
	Dim B1 As JavaObject = Btn
	B1.RunMethod("setTextColor",Array As Object(CSL))

End Sub

Sub ChangeStatusColor(Color As Int)
	
	Dim phoneinfo As Phone
	If phoneinfo.SdkVersion >= 21 Then
		Dim jo As JavaObject
		jo.InitializeContext
		Dim window As JavaObject = jo.RunMethodJO("getWindow", Null)
		window.RunMethod("addFlags", Array (0x80000000))
		window.RunMethod("clearFlags", Array (0x04000000))
		window.RunMethod("setStatusBarColor", Array(Color))
	End If
		
End Sub
