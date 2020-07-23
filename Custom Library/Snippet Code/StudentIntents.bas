Type=Class
Version=6.5
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
'Class module
Sub Class_Globals
	
End Sub

Private Sub Initialize

End Sub

'show setting
Public Sub SettingIntent
	Dim In As Intent
	In.Initialize("android.settings.WIFI_SETTINGS", "")
	StartActivity(In)
End Sub

