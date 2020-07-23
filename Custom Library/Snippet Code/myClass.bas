Type=Class
Version=2.71
@EndOfDesignText@
'Class module
Sub Class_Globals
	
End Sub

Sub Process_Globals

End Sub

Sub sendMail(sTo As String,sBody As String,sSubject As String)
 Try
   Dim p1 As Email
   p1.To.Add(sTo)
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
Try
 Return p1.GetLine1Number
Catch
Log(LastException.Message)
Return ""
End Try
End Sub

'Create Shortcut in Home Android
Sub CreateShortCut(act1 As Activity)
 Dim shortcutIntent As Intent
 shortcutIntent.Initialize("", "")
 shortcutIntent.SetComponent("student.trick/.main")
 shortcutIntent.PutExtra("from_shortcut", True)
 Dim In As Intent
 In.Initialize("", "")
 In.PutExtra("android.intent.extra.shortcut.INTENT", shortcutIntent)
 In.PutExtra("android.intent.extra.shortcut.NAME", "ترفندستان")
 In.PutExtra("android.intent.extra.shortcut.ICON", LoadBitmap(File.DirAssets, "images.png"))
 act1.SetActivityResult(-1, In)
End Sub

'Add Icon inside Edit Text
Sub addImage2Edittext(EditText1 As EditText,bitmap1 As BitmapDrawable)
Dim sT As String
sT="android.graphics.drawable.Drawable"
Dim R As Reflector
R.Target=EditText1
R.RunMethod4("setCompoundDrawablesWithIntrinsicBounds",Array As Object(bitmap1,Null,Null,Null),Array As String(sT,sT,sT,sT))
End Sub

'Argument : Date example 2009/01/10 => 01/01/2009 is fail
Sub gregorian_to_jalali(dt As String) As String
  Dim g_y,g_m,g_d As String
  Dim gy,gm,gd,g_day_no As Int
  Dim k() As String 
  k = Regex.Split("/",dt)
  g_y = k(0)
  g_m = k(1)
  g_d = k(2)
  Dim g_days_in_month(12) As Int 
  Dim j_days_in_month(12) As Int
  g_days_in_month(0) = 31
  g_days_in_month(1) = 28
  g_days_in_month(2) = 31
  g_days_in_month(3) = 30
  g_days_in_month(4) = 31
  g_days_in_month(5) = 30
  g_days_in_month(6) = 31
  g_days_in_month(7) = 31
  g_days_in_month(8) = 30
  g_days_in_month(9) = 31
  g_days_in_month(10)= 30
  g_days_in_month(11)= 31
  
  j_days_in_month(0) = 31
  j_days_in_month(1) = 31
  j_days_in_month(2) = 31
  j_days_in_month(3) = 31
  j_days_in_month(4) = 31
  j_days_in_month(5) = 31
  j_days_in_month(6) = 30
  j_days_in_month(7) = 30
  j_days_in_month(8) = 30
  j_days_in_month(9) = 30
  j_days_in_month(10)= 30
  j_days_in_month(11)= 29
  
  gy = g_y - 1600
  gm = g_m - 1
  gd = g_d - 1
  
  g_day_no = 365 * gy + ((gy + 3) / 4) - ((gy + 99) / 100) + ((gy + 399) / 400)
  
  For i = 0 To gm - 1
    g_day_no = g_day_no + g_days_in_month(i)
  Next

  
  
  If gm > 1 AND ((gy Mod 4 = 0 AND gy Mod 100 <> 0) OR (gy Mod 400 = 0)) Then
    g_day_no = g_day_no + 1
  End If

 
  g_day_no = g_day_no + gd

  Dim j_day_no,j_np,jy As Int 
  
  j_day_no = g_day_no - 79
  
  j_np = (j_day_no / 12053)
  j_day_no = j_day_no Mod 12053
    
  jy = 979 + 33 * j_np + 4 * (j_day_no / 1461)
  
  j_day_no = j_day_no Mod 1461
  
  
  
  If (j_day_no >= 366) Then
    jy = jy + ((j_day_no - 1) / 365)
    j_day_no = (j_day_no - 1) Mod 365
  End If
  
 i = 0
 Do While (i < 11 AND j_day_no >= j_days_in_month(i))
    j_day_no = j_day_no - j_days_in_month(i)
    i = i + 1
 Loop
  
  Dim jm,jd As Int 
  jm = i + 1
  jd = j_day_no + 1
  Dim res As String 
  res = jy & "/" & jm & "/" & jd
  Return res
End Sub

Sub playAnimationObject(obj1 As View,sAction As String,sSpeed As Int,sRepeatCount As Int)
Dim animation1 As Animation
    Select Case sAction
	 Case "rotate"
	  animation1.InitializeRotateCenter("",0,360,obj1)
	 Case "scale"
	  animation1.InitializeScaleCenter("",0,0,1,1,obj1)
	 Case "alpha"
	  animation1.InitializeAlpha("",0,100)
	 Case "translate"
	  animation1.InitializeTranslate("",0,0,obj1.Left,obj1.Top)
	End Select
	animation1.RepeatCount = sRepeatCount
	animation1.Duration = sSpeed
	animation1.Start(obj1)
End Sub