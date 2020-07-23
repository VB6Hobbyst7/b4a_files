B4A=true
Group=Libraries
ModulesStructureVersion=1
Type=StaticCode
Version=7.8
@EndOfDesignText@
'Libraries: RuntimePermissions,AHLocale,ByteConvertor
'Modules: DateUtil

#IgnoreWarnings: 9

Sub Process_Globals
	Public Permissions As RuntimePermissions
End Sub

Sub GetAndroidID As String
	
	Dim nativeMe As JavaObject
	nativeMe.InitializeContext
	Return nativeMe.RunMethod("getAndroidID", Null)
	
	#if Java
	import android.content.Context;
	import android.provider.Settings;
	import java.io.IOException;
	import java.util.UUID;

	private String initialVal = "";

	  public String getAndroidID() {
	    String result = initialVal;
	    try {
	      result = Settings.Secure.getString(BA.applicationContext.getContentResolver(), Settings.Secure.ANDROID_ID);
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    if (result == null || result.length() == 0) {
	      result = initialVal;
	    }
	    return result;
	  } 
	#End If
	
End Sub

'add resource for notification builder
Sub Notify(Title As String,Body As String,sType As String,NotifyID As Int,Picture As Bitmap)
	
	#if notificationbuilder
	Dim sT As NotificationBigTextStyle
	sT.Initialize
	sT.BigContentTitle = Title
	sT.BigText = Body
	sT.SummaryText = DateTime.Time(DateTime.Now)
	
	Dim nb As NotificationBuilder
	nb.Initialize
	nb.AutoCancel		= 	True
	nb.DefaultLight 	= 	True
	nb.DefaultSound		= 	True
	nb.DefaultVibrate	= 	True
	
	Dim ph As Phone
	If ph.SdkVersion >= 22 Then
		nb.SmallIcon		= "notification_icon"
	Else
		nb.SmallIcon		= "icon"
	End If
	
	nb.ContentTitle 	= 	Title
	nb.ContentText 		= 	Body
	nb.Tag				= 	DateTime.Time(DateTime.Now)
	
	If sType = "link" Then
		Dim int1 As Intent
		int1.Initialize(int1.ACTION_VIEW,Title)
		nb.setIntent(int1)
	
	Else if sType = "picture" Then
		Dim big_bmp As NotificationBigPictureStyle
		big_bmp.Initialize
		big_bmp.BigPicture	=	Picture
		big_bmp.SummaryText	=	Body
		big_bmp.BigContentTitle	=	Title
		
		nb.SetStyle(big_bmp)
		nb.Notify(NotifyID)
		
		Return
		
	End If
	
	nb.SetStyle(sT)
	nb.Notify(NotifyID)
	#end if
	
End Sub

Sub EncodeBase64(Data As String) As String
	
	Dim su As StringUtils
	Return su.EncodeBase64(Data.GetBytes("UTF8"))
	
End Sub

Sub DisableStrictMode
	Dim jo As JavaObject
	jo.InitializeStatic("android.os.Build.VERSION")
	If jo.GetField("SDK_INT") > 9 Then
		Dim policy As JavaObject
		policy = policy.InitializeNewInstance("android.os.StrictMode.ThreadPolicy.Builder", Null)
		policy = policy.RunMethodJO("permitAll", Null).RunMethodJO("build", Null)
		Dim sm As JavaObject
		sm.InitializeStatic("android.os.StrictMode").RunMethod("setThreadPolicy", Array(policy))
	End If
End Sub

'install app intent
Sub Intent_InstallApp(sDir As String,sFilename As String)
	Dim Uri As String
	Dim i2 As Intent
	Uri = "file://" & File.Combine(sDir, sFilename)
	i2.Initialize(i2.ACTION_VIEW, Uri)
	i2.SetType("application/vnd.android.package-archive")
	StartActivity(i2)
End Sub

Sub ConvertSecond2Day(Seconds As Long) As Int
	Return Seconds / 59 / 59 / 24
End Sub

Sub CheckLocation As Boolean
	Dim p As Phone
	Dim gps As String
	gps = p.GetSettings("location_providers_allowed")
	If gps.IndexOf("gps") > -1 Or gps.IndexOf("network") > -1 Then
		Return True
	Else
		Return False
	End If
End Sub

#Region Intent
Sub Intent_InstallGooglePlayService
	Dim In As Intent
	In.Initialize(In.ACTION_VIEW, "market://details?id=com.google.android.gms")
	StartActivity(In)
End Sub

Sub Intent_Call(Phone As String)
	
	Try
		Dim ph As PhoneCalls
		StartActivity(ph.Call(Phone))
	Catch
		Log(LastException)
	End Try
	
End Sub

Sub Intent_OpenApp(PackageName As String)
	
	Dim pk As PackageManager
	StartActivity(pk.GetApplicationIntent(PackageName))
		
End Sub

'add <code>SetActivityAttribute(activityOrservicen,android:exported,true)</code> to manifest
Sub Intent_OpenActivityService(PackageName As String,ObjectName As String)
  
	Dim int1 As Intent
	int1.Initialize("","")
	int1.SetComponent(PackageName & "/." & ObjectName)
	StartService(int1)
  
End Sub

Sub Intent_OpenUrl(Url As String)
	
	Dim in As Intent
	in.Initialize(in.ACTION_VIEW,Url)
	StartActivity(in)
	
End Sub

Sub Intent_OpenPdf(Dir As String,Filename As String)
	
	Dim i As Intent
	i.Initialize(i.ACTION_VIEW, File.Combine(Dir & "/", Filename))
	i.SetComponent("android/com.android.internal.app.ResolverActivity")
	i.SetType("application/pdf")
	StartActivity(i)

End Sub

Sub Intent_SendMail(sTo As String,sBody As String,sSubject As String)
	
	Try
		Dim p1 As Email
		p1.To.add(sTo)
		p1.Subject = sSubject
		p1.Body    = sBody
		StartActivity(p1.GetIntent)
	Catch
		Log(LastException.Message)
	End Try
	
End Sub

Sub Intent_SendSMS(sTo As String,sBody As String)
	
	Try
		Dim In As Intent
		In.Initialize(In.ACTION_VIEW, "sms:" & sTo)
		In.PutExtra("sms_body", sBody)
		StartActivity(In)
	Catch
		Log(LastException.Message)
	End Try
	
End Sub

'uninstall intent app
Sub Intent_UninstallApp(sPackageName As String)
	Dim i As Intent
	i.Initialize("android.intent.action.DELETE", "package:" & sPackageName)
	StartActivity(i)
End Sub
#end region

Sub ChangeNullValue(Map As Map) As Map 
	
	For i = 0 To Map.Size - 1
		If Map.GetValueAt(i) = Null Or Map.GetValueAt(i) = "null" Then
			Map.Put(Map.GetKeyAt(i),"")
		End If
	Next
	
	Return Map
	
End Sub

'<code><uses-permission android:name="com.android.launcher.permission.INSTALL_SHORTCUT"/>
'AddActivityText("main",<action android:name="android.intent.action.CREATE_SHORTCUT" />)</code>
Sub AddShortcut(ActivityName As String,Title As String,Icon As Bitmap)
	
	Dim shortcutIntent As Intent
	shortcutIntent.Initialize("", "")
	shortcutIntent.SetComponent(Application.PackageName & "/." & ActivityName)

	Dim in As Intent
	in.Initialize("", "")
	in.PutExtra("android.intent.extra.shortcut.INTENT", shortcutIntent)
	in.PutExtra("android.intent.extra.shortcut.NAME", Title)
	in.PutExtra("android.intent.extra.shortcut.ICON", Icon)
	in.Action = "com.android.launcher.action.INSTALL_SHORTCUT"

	Dim p As Phone
	p.SendBroadcastIntent(in)
	Sleep(0)
	
End Sub

Sub CheckConnection As Boolean
	
	Dim r As Reflector
   
	r.Target = r.GetContext
	r.Target = r.RunMethod2("getSystemService", "connectivity", "java.lang.String")
	r.Target = r.RunMethod("getActiveNetworkInfo")
   
	If r.Target <> Null Then
		Return r.RunMethod("isConnected")
	End If
   
	Return False
	
End Sub

'add #AdditionalJar: com.google.android.gms:play-services-base to Project Attribute
Sub CheckForGooglePlayServices As Boolean
   Dim GoogleApiAvailablity As JavaObject
   GoogleApiAvailablity = GoogleApiAvailablity.InitializeStatic("com.google.android.gms.common.GoogleApiAvailability").RunMethod("getInstance", Null)
   Dim context As JavaObject
   context.InitializeContext
   If GoogleApiAvailablity.RunMethod("isGooglePlayServicesAvailable", Array(context)) <> 0 Then
     GoogleApiAvailablity.RunMethod("makeGooglePlayServicesAvailable", Array(context))
     Return False
   End If
   Return True
End Sub

'Description: Sort a map by its keys in ascending order
Sub SortMapKeys(m As Map,Ascending As Boolean)
	Private KeysList As List
	Private m2 As Map
	Private key As String
	Private mVal As Object
	Private i As Int
	KeysList.Initialize
	m2.Initialize

	' get all the keys
	KeysList = m.Keys
	KeysList.Sort(Ascending)
  
	For i= 0 To KeysList.Size - 1
		key = KeysList.Get(i)
		mVal = m.Get(key)
		m2.Put(key, mVal)
	Next
	
	m.Clear
	
	For Each m2Key As String In m2.Keys
		m.Put(m2Key, m2.Get(m2Key))
	Next
	
End Sub

'ResultsType is Report or Summary for get result instead of status
Sub Ping(Url As String, ResultsType As String, Attempts As Int, Timeout As Int) As Boolean

	Dim sb As StringBuilder
	Dim p As Phone
	Dim Option As String
	
	sb.Initialize

	If ResultsType = "Report" Then	Option = " -v "
	If ResultsType = "Summary" Or ResultsType = "Status" Then Option = " -q "
	
	Try
		p.Shell("ping -c " & Attempts & " -W " & Timeout & Option & Url, Null, sb, Null)
	Catch
		Return True
	End Try
	
	If sb.Length = 0 Or sb.ToString.Contains("Unreachable") Then
		Return False
	End If
	
	Return True

End Sub

Sub ProviderLocationStatus As Boolean
	
	Dim r As Reflector
	r.Target = r.GetContext
	r.Target =r.RunMethod2 ("getSystemService", "location", "java.lang.String")
	Return r.RunMethod2("isProviderEnabled", r.GetField("NETWORK_PROVIDER"), "java.lang.String")
	
End Sub

#IgnoreWarnings: 12
Sub ApiVersion As Int
	Dim ph As Phone
	Return ph.SdkVersion
End Sub

Sub UTS(codepoint As Int) As String
	Dim bc As ByteConverter
	Dim b() As Byte = bc.IntsToBytes(Array As Int(codepoint))
	Return BytesToString(b, 0, 4, "UTF32")
End Sub

'convert string to int and convert to emoji
Public Sub UTS2(code As String) As String
	Dim jo,jo1,jo2 As JavaObject
	jo.InitializeStatic("java.lang.String")
	jo1.InitializeStatic("java.lang.Character")
	jo2.InitializeStatic("java.lang.Integer")
	Return jo.RunMethod("valueOf",Array(jo1.RunMethod("toChars",Array(jo2.RunMethod("parseInt",Array(code,16))))))
End Sub

Private Sub ConvertUTSToInt(code As String) As Int
	Dim jo2 As JavaObject
	jo2.InitializeStatic("java.lang.Integer")
	Return jo2.RunMethod("parseInt",Array(code,16))
End Sub

Sub Intent_OpenFile(Dir As String,Filename As String) As Boolean
	
	Try
		Dim in As Intent
		in.Initialize(in.ACTION_VIEW, CreateFileProviderUri(Dir,Filename))
		in.Flags = 1
		StartActivity(in)
		Return True
	Catch
		Return False
	End Try
	
End Sub

Sub RandomNumber(Lowest As Double, Highest As Double, DecimalPlaces As Int, PreventZero As Boolean) As Double
	Lowest  = Round(Lowest)
	Highest = Round(Highest)
	Dim Decimal As Double
	If DecimalPlaces > 0 Then Decimal = (Rnd(0, Power(10, DecimalPlaces))) / Power(10, DecimalPlaces)
	If Lowest = Highest Then
		Return Lowest
	Else
		If Lowest > Highest Then
			Dim TempValue = Lowest As Double
			Lowest   = Highest
			Highest  = TempValue
		End If
		Dim ReturnValue = Lowest + Rnd(0, Highest - Lowest) + Decimal As Double
		If ReturnValue = 0 And PreventZero Then
			Return RandomNumber(Lowest, Highest, DecimalPlaces, PreventZero)
		Else
			Return ReturnValue
		End If
	End If
End Sub

Sub GetMapValue(Map As Map,Key As String) As Object
	
	If Map.IsInitialized Then
		If Map.ContainsKey(Key) Then
			Return Map.Get(Key)	
		End If
	End If
	
	Return Null
	
End Sub

Sub MarkPatternCSbuilder(Input As String, Pattern As String, GroupNumber As Int) As CSBuilder
	Dim cs As CSBuilder
	cs.Initialize
	Dim lastMatchEnd As Int = 0
	Dim m As Matcher = Regex.Matcher(Pattern, Input)
	Do While m.Find
		Dim currentStart As Int = m.GetStart(GroupNumber)
		cs.Append(Input.SubString2(lastMatchEnd, currentStart))
		lastMatchEnd = m.GetEnd(GroupNumber)
		'apply styling here
		cs.Bold.Underline
		cs.Color(0xFF03FFFF)
		cs.Clickable("cs", m.Group(GroupNumber))
		cs.Append(m.Group(GroupNumber))
		cs.Pop.Pop.Pop.Pop 'number should match number of stylings set.
	Loop
	If lastMatchEnd < Input.Length Then cs.Append(Input.SubString(lastMatchEnd))
	Return cs
End Sub

Sub CreateFileProviderUri (Dir As String, FileName As String) As Object
	Dim FileProvider As JavaObject
	Dim context As JavaObject
	context.InitializeContext
	FileProvider.InitializeStatic("android.support.v4.content.FileProvider")
	Dim f As JavaObject
	f.InitializeNewInstance("java.io.File", Array(Dir, FileName))
	Return FileProvider.RunMethod("getUriForFile", Array(context, Application.PackageName & ".provider", f))
End Sub

'example : AddApplicationText(<meta-data android:name="my_api_key" android:value="132bca45189df6g24mocc7b12341234abcde-2222-1313-5678-abcd" />)
Sub GetValueFromManifest(key As String) As String
	Dim ctxt As JavaObject
	ctxt.InitializeContext
	Dim ApplicationInfo As JavaObject = ctxt.RunMethodJO("getPackageManager", Null).RunMethod("getApplicationInfo", _
       Array(Application.PackageName, 0x00000080))
	Dim bundle As JavaObject = ApplicationInfo.GetField("metaData")
	Return bundle.RunMethod("getString", Array(key))
End Sub

Public Sub ExtractNumber(Str As String) As String
	
	Dim output As String
	
	For i = 0 To Str.Length - 1
		If IsNumber(Str.SubString2(i,i+1)) Then
			output	=	output & Str.SubString2(i,i+1)
		End If
	Next
	
	Return output
	
End Sub

Sub ForceRefreshGallery(Dir As String,Filename As String)

	Dim Phone As Phone
	If Phone.SdkVersion<19 Then
		Dim i As Intent
		i.Initialize("android.intent.action.MEDIA_MOUNTED", "file://" & File.Combine(Dir, Filename))
		Phone.SendBroadcastIntent(i)
	Else
		Dim context As JavaObject
		context = context.InitializeStatic("anywheresoftware.b4a.BA").GetField("applicationContext")
		Dim paths() As String = Array As String(File.Combine(Dir,Filename)) 'files to scan
		Dim mediaScanner As JavaObject
		mediaScanner.InitializeStatic("android.media.MediaScannerConnection")
		mediaScanner.RunMethod("scanFile", Array As Object(context, paths, Null, Null))
	End If

End Sub

Sub GetSDKVersion As Int
	Dim ph As Phone
	Return ph.SdkVersion
End Sub

Sub CollapseNotificationbar As Intent
	Dim i As Intent
	i.Initialize("android.intent.action.CLOSE_SYSTEM_DIALOGS", "")
	Return i
End Sub

Sub CreateBadge(Color As Int,Text As String,Radius As Int) As Bitmap
	
	Dim mut As Bitmap
	mut.InitializeMutable(100dip,100dip)
	
	Dim font_size As Int
	font_size	=	40
	
	Dim c As Canvas
	c.Initialize2(mut)
	c.DrawCircle(50dip,50dip,Radius,Color,True,0)
	
	Dim w,h,left As Int
	w = c.MeasureStringWidth(Text,Typeface.LoadFromAssets("font.ttf"),font_size)
	h = c.MeasureStringHeight(Text,Typeface.LoadFromAssets("font.ttf"),font_size)
	left	=	150dip / 2 - w / 2
	
	c.DrawText(Text,c.Bitmap.Height/2,50dip+h/2,Typeface.LoadFromAssets("font.ttf"),font_size,Colors.White,"CENTER")
	
	Return c.Bitmap
	
End Sub

Sub SplitStringToList(Str As String,Separator As String) As List
	
	Dim ls As List
	ls.Initialize
	
	Dim Str2() As String
	Str2	=	Regex.Split(Separator,Str)
	
	If Str2.Length = 0 Then Return ls
	
	For i = 0 To Str2.Length - 1
		ls.Add(Str2(i).Trim)	
	Next
	
	Return ls
	
End Sub

Sub SearchInList(Ls As List,Item As Object) As Boolean
	
	For i = 0 To Ls.Size - 1
		
		Dim t1,t2 As String
		t1 = Ls.Get(i)
		t2 = Item
		
		If t1 = t2 Then
			Return True
		End If
		
	Next
	
	Return False
	
End Sub

Sub CombineMap(Map1 As Map,Map2 As Map) As Map
	
	Dim temp As Map
	temp.Initialize
	
	For Each key As String In Map1.Keys
		temp.Put(key,Map1.Get(key))
	Next
	
	For Each key As String In Map2.Keys
		temp.Put(key,Map2.Get(key))
	Next
	
	Return temp
	
End Sub