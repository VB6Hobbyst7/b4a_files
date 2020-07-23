Type=Class
Version=3.15
@EndOfDesignText@
'Class module
Sub Class_Globals
	
End Sub

'Initializes the object. You can add parameters to this method if needed.
Public Sub Initialize

End Sub

Sub InstallAPK(sDir As String,sFilename As String)
Dim uri As String
Dim i2 As Intent
uri = "file://" & File.Combine(sDir, sFilename)
i2.Initialize(i2.ACTION_VIEW, uri)
i2.SetType("application/vnd.android.package-archive")
StartActivity(i2)
End Sub

Sub OpenFolder
Dim i As Intent
i.Initialize(i.ACTION_VIEW, "file://" &  File.DirRootExternal&"/myFolder/" )
StartActivity(i)
end sub

Sub RunApp(sIntent As String)
Dim In As Intent
Dim pm As PackageManager
In = pm.GetApplicationIntent(sIntent)
If In.IsInitialized Then StartActivity(In)
StartActivity(In)
End Sub

Sub exitApp
Dim i As Int
i = Msgbox2("آیا مایل به خروج هستید؟","خروج","آری","خیر","",LoadBitmap(File.DirAssets,"exit.png"))
If i = DialogResponse.POSITIVE Then
 ExitApplication
End If
End Sub

Sub showMessagebox(sTitle As String,sCaption As String,blnError As Boolean,sIsAlert As Boolean) As Int
Dim i As Int
Dim yes,no As String
If sIsAlert = True Then
 yes = "قبول"
 no = ""
Else
 yes = "بله"
 no = "خیر"
End If
If blnError = True Then
 i = Msgbox2(sCaption,sTitle,yes,no,"",LoadBitmap(File.DirAssets,"alert.png"))
Else
 i = Msgbox2(sCaption,sTitle,yes,no,"",LoadBitmap(File.DirAssets,"success.png"))
End If
Return i
End Sub

'Create Shortcut in Home Android
Sub CreateShortCut(act1 As Activity,icon As Bitmap,sTitle As String,sPackageName As String)
 Dim shortcutIntent As Intent
 shortcutIntent.Initialize("", "")
 shortcutIntent.SetComponent(sPackageName & "/.main")
 shortcutIntent.PutExtra("from_shortcut", True)
 Dim In As Intent
 In.Initialize("", "")
 In.PutExtra("android.intent.extra.shortcut.INTENT", shortcutIntent)
 In.PutExtra("android.intent.extra.shortcut.NAME", sTitle)
 In.PutExtra("android.intent.extra.shortcut.ICON", icon)
 act1.SetActivityResult(-1, In)
End Sub