Type=Class
Version=3.15
@EndOfDesignText@

Sub Class_Globals
	
End Sub

Public Sub Initialize

End Sub

Sub sendMail(sTo As String,sBody As String,sSubject As String)
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

Sub SendSms(PhoneNumber As String, Text As String)
    Dim r As Reflector
    r.Target = r.RunStaticMethod("android.telephony.SmsManager", "getDefault", Null, Null)
    r.RunMethod4("sendTextMessage", Array As Object(PhoneNumber, Null, Text, Null, Null), _
        Array As String("java.lang.String", "java.lang.String", "java.lang.String", _
            "android.app.PendingIntent", "android.app.PendingIntent"))
End Sub

'If return True Then Internet is active
Sub checkInternet As Boolean 
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
Sub getPhoneNumber As String
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

Sub checkGPS As Boolean
Dim p As Phone
Dim gps As String
gps = p.GetSettings("location_providers_allowed")
If gps.IndexOf("gps") > -1 Then
 Return True
Else
 Return False
End If
End Sub