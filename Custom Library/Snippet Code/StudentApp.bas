Type=Class
Version=6.5
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
'Class module
Sub Class_Globals
Dim  not1 As Notification
Dim mp As MediaPlayer
End Sub

'Initializes the object. You can add parameters to this method if needed.
Public Sub Initialize

End Sub

Private Sub LoadResourceDrawable(id As Int) As Object
	Dim r As Reflector
    r.Target = r.GetContext
    r.Target = r.RunMethod("getResources")
	Return r.RunMethod2("getDrawable", id, "java.lang.int")
End Sub

'event
'Sub ion_Event (MethodName As String, Args() As Object) As Object
'	If Args(0) = -1 Then 'resultCode = RESULT_OK
'		Dim i As Intent = args(1)
'		Log(i)
'   End If
'   Return Null
'End Sub

Sub StartActivityForResult(i As Intent)
	Dim ion As Object
	Dim jo As JavaObject = GetBA
	ion = jo.CreateEvent("anywheresoftware.b4a.IOnActivityResult", "ion", Null)
	jo.RunMethod("startActivityForResult", Array As Object(ion, i))
End Sub

Sub GetBA As Object
   Dim jo As JavaObject
   Dim cls As String = Me
   cls = cls.SubString("class ".Length)
   jo.InitializeStatic(cls)
   Return jo.GetField("processBA")
End Sub

Sub ShowFullScreenWindow(Activity1 As Activity,Panel1 As Panel)
	
  Dim r As Reflector
  r.Target = r.GetContext
  Dim cwm As Object = r.RunMethod2("getSystemService", "window", "java.lang.String")
  
  Dim lp As Object
  Dim i As String = "java.lang.int"
	lp = r.CreateObject2("android.view.WindowManager$LayoutParams", Array As Object(Activity1.Width,Activity1.Height,0, 50dip, 2010, 65832, 1), Array As String(i,i, i, i, i, i, i, i))
  r.Target = cwm
  r.RunMethod4("addView", Array As Object(Panel1, lp), _
    Array As String("android.view.View", "android.view.ViewGroup$LayoutParams"))

	
End Sub

Sub GetActivitiesInfo(package As String) As Object
   Dim r As Reflector
   r.Target = r.GetContext
   r.Target = r.RunMethod("getPackageManager")
   r.Target = r.RunMethod3("getPackageInfo", package, "java.lang.String", 0x00000001, "java.lang.int")
   Return r.GetField("applicationInfo")
End Sub

Sub GetSourceDir(AppInfo As Object) As String
	
    Try
        Dim r As Reflector      
        r.Target = AppInfo
        Return r.GetField("sourceDir")     
    Catch
        Return ""
    End Try
	
End Sub

'install app intent
Sub InstallApp(sDir As String,sFilename As String)
	Dim Uri As String
	Dim i2 As Intent
	Uri = "file://" & File.Combine(sDir, sFilename)
	i2.Initialize(i2.ACTION_VIEW, Uri)
	i2.SetType("application/vnd.android.package-archive")
	StartActivity(i2)
End Sub

'get package type (system,non-system)
Sub isSystemapp(app As String) As Boolean
    Dim Obj1, Obj2, Obj3 As Reflector
  Dim size, i, flags As Int
  Dim result As Boolean = False

    Obj1.Target = Obj1.GetContext
  Obj1.Target = Obj1.RunMethod("getPackageManager") ' PackageManager
  Obj1.Target = Obj1.RunMethod2("getInstalledPackages", 0, "java.lang.int") ' List<PackageInfo>
  For i = 0 To Obj1.RunMethod("size") -1
      Obj2.Target = Obj1.RunMethod2("get", i, "java.lang.int") ' PackageInfo
    Dim name As String = Obj2.GetField("packageName")
        If app.ToLowerCase = name.ToLowerCase Then
            Obj3.Target = Obj2.GetField("applicationInfo") ' ApplicationInfo 
        flags = Obj3.GetField("flags")
        If Bit.And(flags, 1)  = 0 Then
            'app is not in the system image
        Else
                ' Systemapp
                result = True
            End If 
        End If
  Next
    Return result
End Sub

'play current ringtone default
Sub PlayRinger
   Dim r As Reflector
   r.Target = "ContentDir"
   r.Target = r.RunMethod("intern")   
   mp.Load(r.Target, "content://settings/system/ringtone")
   mp.Play
End Sub

'get free memory
Sub GetFreeMemory As Long
   Dim jo As JavaObject
   Return jo.InitializeStatic("java.lang.Runtime").RunMethodJO("getRuntime", Null).RunMethod("totalMemory", Null)
End Sub

'get cell id
Sub GetCellID As String()
Dim Obj1 As Reflector
Dim s1(2) As String
Dim cid, lac As Int
Obj1.Target = Obj1.GetContext
Obj1.Target = Obj1.RunMethod2("getSystemService", "phone", "java.lang.String")
Obj1.Target = Obj1.RunMethod("getCellLocation") ' get a GsmCellLocation 
cid = Obj1.RunMethod("getCid") ' gsm cell id
lac = Obj1.RunMethod("getLac") ' gsm location area code
Return Array As String(cid,lac)
End Sub

'open your app in bazaar
Sub OpenBazaarApp(sPackageName As String,blnView As Boolean)
	Dim market As Intent, Uri As String
	Uri="bazaar://details?id=" & sPackageName
	If blnView = False Then
	 market.Initialize(market.ACTION_EDIT,Uri)
	Else
	 market.Initialize(market.ACTION_VIEW,Uri)
	End If
	StartActivity(market)
End Sub


'uninstall intent app
Sub UninstallApp(sPackageName As String)
	Dim i As Intent
	i.Initialize("android.intent.action.DELETE", "package:" & sPackageName)
	StartActivity(i)
End Sub

'show home screen force
Sub ShowHomeScreen
  Dim i As Intent
  i.Initialize(i.ACTION_MAIN, "")
  i.AddCategory("android.intent.category.HOME")
  i.Flags = 0x10000000
  StartActivity(i)
End Sub

'run app intent
Sub RunApp(sPackageName As String)
  Dim In As Intent
  Dim pm As PackageManager
  In = pm.GetApplicationIntent(sPackageName)
  If In.IsInitialized Then StartActivity(In)
  StartActivity(In)
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


'get current package name
Sub GetPackageName As String
	Dim r As Reflector
	Return r.GetStaticField("anywheresoftware.b4a.BA", "packageName")
End Sub

'notify icon
Sub NotifyIcon(sTitle As String,sInfo As String,sSound As Boolean,sVibrate As Boolean)
	not1.Initialize
	not1.AutoCancel = True
	not1.Insistent = True
	not1.Icon = "icon"
	not1.Sound = sSound
	not1.Vibrate = sVibrate
	not1.SetInfo(sTitle,sInfo,Me)
	not1.Notify(1)
End Sub

'find default app
Sub FindDefaultApp(In As Intent) As String
    Dim r As Reflector
    r.Target = r.GetContext
    Dim pm As Object
    pm = r.RunMethod("getPackageManager")
    r.Target = pm
    Dim mInfo As Object
    mInfo = r.RunMethod4("resolveActivity", Array As Object(In, 0), _
        Array As String("android.content.Intent", "java.lang.int"))
    If mInfo = Null Then Return "" 'no activity found
    r.Target = mInfo
    r.Target = r.GetField("activityInfo")
    r.Target = r.GetField("applicationInfo")
    Return r.GetField("packageName")
End Sub


'AddPermission("android.permission.WRITE_SETTINGS")
'WritePhoneSetting("screen_brightness", Value) => for absolute change setting for all
'p.SetScreenBrightness(Value/255)
Sub WritePhoneSetting(Setting As String, Value As Int)
   Dim r1 As Reflector
   Dim args(3) As Object
   Dim types(3) As String

   r1.Target = r1.GetContext
   
   args(0) = r1.RunMethod("getContentResolver")
   types(0) = "android.content.ContentResolver"
   args(1) = Setting
   types(1) = "java.lang.String"
   args(2) = Value
   types(2) = "java.lang.int"
   r1.RunStaticMethod("android.provider.Settings$System", "putInt", args, types) 
End Sub

'get current language of android
Sub GetDefaultLanguage As String
   Dim r As Reflector
   r.Target = r.RunStaticMethod("java.util.Locale", "getDefault", Null, Null)
   Return r.RunMethod("getDisplayName")
End Sub

'open googlemap in android
Sub OpenGoogleMap(sLatitude As String,sLongitude As String)
	Dim MapIntent As Intent
	Dim location As String
	location = "geo:0,0?q=" & sLatitude & "," & sLongitude
	Try
	 MapIntent.Initialize(MapIntent.ACTION_VIEW, location)
	 MapIntent.SetComponent("com.navitel")
	 StartActivity(MapIntent)
	Catch
	End Try
End Sub

'run calculator of android
Sub Calculator
	Dim i As Intent
	i.Initialize("", "")
	i.SetComponent("com.android.calculator2/.Calculator")
	Try
	StartActivity(i)
	Catch
	ToastMessageShow("Calculator app not found.", True)
	End Try
End Sub

'play video in mxplayer(online and ofline)
Sub MXPlayer(sUrl As String)
Dim Intent1 As Intent
Intent1.Initialize(Intent1.ACTION_VIEW,sUrl)
Intent1.SetComponent("com.mxtech.videoplayer.ad/.ActivityScreen")
StartActivity(Intent1)
End Sub


Sub GetPermissions(Package As String) As String()
   Dim r As Reflector
   r.Target = r.GetContext
   r.Target = r.RunMethod("getPackageManager")
   'get PacakgeInfo
   r.Target = r.RunMethod4("getPackageInfo", Array As Object(Package, 0x00001000), _
      Array As String("java.lang.String", "java.lang.int"))
   Dim permissions() As String
   permissions = r.GetField("requestedPermissions")
   If permissions = Null Then
      Dim permissions(0) As String
   End If
   Return permissions
End Sub