Type=Class
Version=6.5
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
'Class module
Sub Class_Globals
	
End Sub

'Initializes the object. You can add parameters to this method if needed.
Public Sub Initialize

End Sub

'share string
Sub ShareString(sInfo As String,sBody As String,sSubject As String)
	Dim share As Intent
	share.Initialize(share.ACTION_SEND,"")
	share.SetType("text/plain")
	share.PutExtra("android.intent.extra.TEXT",sBody)
	share.PutExtra("android.intent.extra.SUBJECT", sSubject)
	share.WrapAsIntentChooser(sInfo)
	StartActivity(share)
End Sub

'share file in instagram
Sub ShareInstagram(sDir As String,sFileName As String,sSubject As String)
	Dim u As Uri 'ContentResolver library
	u.Parse("file://" & File.Combine(sDir, sFileName))
	Dim inten As Intent
	Dim tmpt As String = sSubject
	inten.Initialize(inten.ACTION_SEND,"")
	inten.SetType("image/*")
	inten.PutExtra("android.intent.extra.STREAM",u)
	inten.PutExtra("android.intent.extra.TEXT",tmpt)
	inten.SetComponent("com.instagram.android/.activity.MainTabActivity")
	StartActivity(inten)
End Sub

'share file in twitter
Sub ShareTwitter(sDir As String,sFileName As String,sSubject As String)
	Dim u As Uri 'ContentResolver library
	u.Parse("file://" & File.Combine(sDir, sFileName))
	Dim inten As Intent
	Dim tmpt As String = sSubject
	inten.Initialize(inten.ACTION_SEND,"")
	inten.SetType("image/*")
	inten.PutExtra("android.intent.extra.STREAM",u)
	inten.PutExtra("android.intent.extra.TEXT",tmpt)
	inten.SetComponent("com.twitter.android/.composer.ComposerActivity")
	StartActivity(inten)
End Sub