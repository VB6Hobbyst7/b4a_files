B4A=true
Group=Libraries
ModulesStructureVersion=1
Type=StaticCode
Version=7.8
@EndOfDesignText@
'Code module
'Subs in this code module will be accessible from all modules.
Private Sub Process_Globals

End Sub

Sub GetCurrentActivity As Activity
	Dim r As Reflector
	r.Target = r.GetActivityBA
	Return r.GetField("vg")
End Sub

Sub CloseActivities
	Dim jo As JavaObject
	jo.InitializeContext
	jo.RunMethod("finishAffinity", Null)
End Sub

Sub StartAnotherAppService(PackageName As String,Servicename As String)
	
	Dim int1 As Intent
	int1.Initialize("","")
	int1.SetComponent(PackageName & "/." & Servicename)
	StartService(int1)
	
End Sub

Sub StartActivityIntent(PackageName As String,ActiviyName As String,ExtraData As Map)
	
	Dim intent2 As Intent
	intent2.Initialize(intent2.ACTION_Main,"")
	intent2.SetComponent(PackageName & "/." & ActiviyName)
	
	For Each v1 As String In ExtraData.Keys
		intent2.PutExtra(v1,ExtraData.Get(v1))
	Next
	
	StartActivity(intent2)
	
End Sub

Public Sub SettingIntent
	Dim In As Intent
	In.Initialize("android.settings.WIFI_SETTINGS", "")
	StartActivity(In)
End Sub

Sub RequestSearchBar
	Dim ref As Reflector
	ref.Target = ref.GetActivity
	ref.RunPublicmethod("onSearchRequested", Null, Null)
End Sub

'show home screen force
Sub ShowHomeScreen
	Dim i As Intent
	i.Initialize(i.ACTION_MAIN, "")
	i.AddCategory("android.intent.category.HOME")
	i.Flags = 0x10000000
	StartActivity(i)
End Sub

'#If Java
'    import android.graphics.Rect;
'    public int getActivityWidth  () { Rect rectangle = new Rect (); getWindow ().getDecorView ().getWindowVisibleDisplayFrame (rectangle); return rectangle.right  - rectangle.left; }
'    public int getActivityHeight () { Rect rectangle = new Rect (); getWindow ().getDecorView ().getWindowVisibleDisplayFrame (rectangle); return rectangle.bottom - rectangle.top;  }
'    public int correctLayout () { mostCurrent.layout.getLayoutParams ().height = getActivityHeight (); mostCurrent.layout.getLayoutParams().width = getActivityWidth (); return 0; }
'#End If
Sub GetActivityWidth As Int

	Dim javaobjectInstance                                                      As JavaObject

	javaobjectInstance.InitializeContext
	Return javaobjectInstance.RunMethod ("getActivityWidth", Null)

End Sub

'#If Java
'    import android.graphics.Rect;
'    public int getActivityWidth  () { Rect rectangle = new Rect (); getWindow ().getDecorView ().getWindowVisibleDisplayFrame (rectangle); return rectangle.right  - rectangle.left; }
'    public int getActivityHeight () { Rect rectangle = new Rect (); getWindow ().getDecorView ().getWindowVisibleDisplayFrame (rectangle); return rectangle.bottom - rectangle.top;  }
'    public int correctLayout () { mostCurrent.layout.getLayoutParams ().height = getActivityHeight (); mostCurrent.layout.getLayoutParams().width = getActivityWidth (); return 0; }
'#End If
Sub GetActivityHeight As Int

	Dim javaobjectInstance                                                      As JavaObject

	javaobjectInstance.InitializeContext
	Return javaobjectInstance.RunMethod ("getActivityHeight", Null)

End Sub