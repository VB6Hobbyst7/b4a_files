Type=Class
Version=6.5
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@

Sub Class_Globals
 Dim ht As HttpClient
 Dim hr As HttpRequest
 Dim sl As StudentLibrary
End Sub

Public Sub Initialize

End Sub

'use 10.0.2.2 to connect localhost server(for phpmyadmin and other server)
Sub UseLocalhost
	ToastMessageShow("enter 10.0.2.2",False)
End Sub

'AddPermission(android.permission.WRITE_SMS)
'AddPermission(android.permission.READ_SMS)
Sub AddMessageToLogs(body As String, address As String)
   Dim r As Reflector
   r.Target = r.CreateObject("android.content.ContentValues")
   r.RunMethod3("put", "address", "java.lang.String", address, "java.lang.String")
   r.RunMethod3("put", "body", "java.lang.String", body, "java.lang.String")
   Dim ContentValues As Object = r.Target
   r.Target = r.GetContext
   r.Target = r.RunMethod("getContentResolver")
   r.RunMethod4("insert", Array As Object( _
      r.RunStaticMethod("android.net.Uri", "parse", Array As Object("content://sms/sent"), _
         Array As String("java.lang.String")), _
      ContentValues), Array As String("android.net.Uri", "android.content.ContentValues"))
End Sub


'get current email active in android.Permission android.permission.GET_ACCOUNTS
Sub GetCurrentMail
Dim r As Reflector
   r.Target = r.RunStaticMethod("android.accounts.AccountManager", "get", _
      Array As Object(r.GetContext), Array As String("android.content.Context"))
   Dim accounts() As Object
   accounts = r.RunMethod2("getAccountsByType","com.google", "java.lang.String")
   For i = 0 To accounts.Length - 1
      r.Target = accounts(i)
      Dim accountName As String
      accountName = r.GetField("name")
      Log(accountName)
   Next
End Sub

'get register account in android
Sub GetUserAccounts As List
    Dim r As Reflector
    Dim accounts() As Object
    Dim l As List
    l.Initialize
    r.Target = r.RunStaticMethod("android.accounts.AccountManager", "get", _
        Array As Object(r.GetContext), Array As String("android.content.Context"))
    accounts = r.RunMethod2("getAccountsByType", "com.google", "java.lang.String")
    For i = 0 To accounts.Length - 1
        r.Target = accounts(i)
        l.Add(r.GetField("name"))
    Next
    Return l
End Sub

'send email intent
Sub SendMail(sTo As String,sBody As String,sSubject As String)
 Try
   Dim p1 As Email
   p1.To.add(sTo)
   p1.Subject = sSubject
   p1.Body    = sBody
   ProgressDialogShow2("در حال ارسال",True)
   StartActivity(p1.GetIntent)
   ProgressDialogHide
 Catch
  ProgressDialogHide
  Log(LastException.Message)
 End Try   
End Sub

'send sms
Sub SendSms(PhoneNumber As String, Text As String)
    Dim r As Reflector
    r.Target = r.RunStaticMethod("android.telephony.SmsManager", "getDefault", Null, Null)
    r.RunMethod4("sendTextMessage", Array As Object(PhoneNumber, Null, Text, Null, Null), _
        Array As String("java.lang.String", "java.lang.String", "java.lang.String", _
            "android.app.PendingIntent", "android.app.PendingIntent"))
End Sub

'send sms intent
Sub SendSmsIntent(PhoneNumber As String, Text As String)
Dim In As Intent
    In.Initialize(In.ACTION_VIEW, "sms:" & PhoneNumber)
    In.PutExtra("sms_body", Text)
    StartActivity(In)
End Sub

'If return True Then Internet is active
Sub CheckInternet As Boolean 
   Dim p As Phone
   Dim connected As Boolean
   connected = False
   
   If (p.GetDataState == "CONNECTED") Then
      connected = True
   End If
   
   If (p.GetSettings ("wifi_on") == 1) Then
      connected = True
   End If
   
   Return connected
End Sub

'Get Simcard Number
Sub GetPhoneNumber As String
	Dim p1 As PhoneId
	Dim s1 As String
	Try
	 s1 = p1.GetLine1Number
	Catch
	 s1 = p1.GetDeviceId
	End Try
	If s1.Length = 0 Then
	 s1 = p1.GetDeviceId
	End If
End Sub

'check gps is enable
Sub CheckGPS As Boolean
	Dim p As Phone
	Dim gps As String
	gps = p.GetSettings("location_providers_allowed")
	If gps.IndexOf("gps") > -1 Then
		Return True
	Else
		Return False
	End If
End Sub

'post data to url
 Sub SendRequest2Server (   strUrl As String ,  strRequest As String ) As Boolean 
  If strUrl <> "" Then
   Dim bytUserdata() As Byte 
   ht.Initialize("ht")
   bytUserdata = strRequest.GetBytes("UTF8")
   hr.InitializePost2(strUrl,bytUserdata)
   hr.Timeout = 17000 
     If ht.Execute( hr , 1) = True Then
	  Return True
	 Else
	  Return False
	 End If
  Else
   Return False
  End If
End Sub

'kill call(incoming and outcoming call
Sub KillCall
   Dim r As Reflector
   r.Target = r.GetContext
   Dim TelephonyManager, TelephonyInterface As Object
   TelephonyManager = r.RunMethod2("getSystemService", "phone", "java.lang.String")
   r.Target = TelephonyManager
   TelephonyInterface = r.RunMethod("getITelephony")
   r.Target = TelephonyInterface
   r.RunMethod("endCall")
End Sub

'get persian date
Sub GetPersianDate(Year As Int,Month As Int,Day As Int,Separetor As String)
sl.GetPersianDate(Year,Month,Day,Separetor)
End Sub

'get gregoriandate
Sub GetGregorianDate(Year As Int,Month As Int,Day As Int,Separetor As String)
sl.GetGregorianDate(Year,Month,Day,Separetor)
End Sub


'call intent
Sub Call(Command As String)
    Dim i As Intent
    i.Initialize(i.ACTION_CALL, "tel:" & Command.Replace("#", "%23"))
    StartActivity(i)
End Sub