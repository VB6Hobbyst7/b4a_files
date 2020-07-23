Type=Class
Version=6.5
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
'Class module
Sub Class_Globals
 Dim sl As StudentLibrary	
End Sub

'Initializes the object. You can add parameters to this method if needed.
Public Sub Initialize

End Sub

'convert english numbers to persian numbers
Sub ConvertNumbers2Persian(sNumber As String) As String
	
	Dim sNumbers(10) As String
	Dim res As String
	Dim j As Int
	res = sNumber
	sNumbers(0) = "٠"
	sNumbers(1) = "١"
	sNumbers(2) = "٢"
	sNumbers(3) = "٣"
	sNumbers(4) = "٤"
	sNumbers(5) = "٥"
	sNumbers(6) = "٦"
	sNumbers(7) = "٧"
	sNumbers(8) = "٨"
	sNumbers(9) = "٩"

	For i =0 To sNumber.Length - 1
	 j = sNumber.SubString2(i,i+1)
	 res = res.Replace(sNumber.CharAt(i),sNumbers(j))
	Next
	Return res
	
End Sub

'get md5 of string
Sub GetMD5(sStr As String,sOnlynumber As Boolean) As String
	Dim md As MessageDigest
	Dim ByteCon As ByteConverter
	Dim passwordhash() As Byte

	passwordhash = md.GetMessageDigest(sStr.GetBytes("UTF8"),"MD5")

	Dim md5string,res As String

	md5string = ByteCon.HexFromBytes(passwordhash)
	If sOnlynumber = False Then
	 Return md5string
	Else
	For i = 0 To md5string.Length - 1
	 If IsNumber(md5string.CharAt(i)) Then
	  res = res & md5string.CharAt(i)
	 End If
	Next
	Return res
	End If
End Sub

'sort map
Sub SortMap(m As Map)
   Dim list1 As List
   list1.Initialize
   Dim m2 As Map
   m2.Initialize
   For i = 0 To m.Size - 1
      Dim word As String
      Dim count As Int
      word = m.GetKeyAt(i)
      count = m.GetValueAt(i)
      Dim l As List
      l = m2.Get(count)
      If l.IsInitialized = False Then
         l.Initialize
         m2.Put(count, l)
         list1.Add(count)
      End If
      l.Add(word)
   Next
   list1.Sort(False) 'set to true for ascending sort.
   
   'print the sorted values:
   For i = 0 To list1.Size - 1
      Dim count As Int
      count = list1.Get(i)
      Dim l As List
      l = m2.Get(count)
      For c = 0 To l.Size - 1
         Log("Count = " & count & ", word = " & l.Get(c))
      Next
   Next
End Sub

'get sha1 of string
Sub GetSH1(st1 As String) As String
Return sl.EncrtyptString(st1)
End Sub

'get current persian date
Sub getDate(sDate As String) As String
Dim s1(),month As String
s1 = Regex.Split("/",sDate)
Select Case s1(1)
 Case 1
  month = "فروردین"
 Case 2
  month = "اردیبهشت"
 Case 3
  month = "خرداد"
 Case 4
  month = "تیر"
 Case 5
  month = "مرداد"
 Case 6
  month = "شهریور"
 Case 7
  month = "مهر"
 Case 8
  month = "آبان"
 Case 9
  month = "آذر"
 Case 10
  month = "دی"
 Case 11
  month = "بهمن"
 Case 12
  month = "اسفند"
End Select
Return " امروز " & ConvertNumbers2Persian(s1(2))  & " " & month & " " & ConvertNumbers2Persian(s1(0))
End Sub

'conver number to curreny format example 250000 to 250,000
Sub ConvertNumber2Currency(MyNumber As Double) As String
	Dim AHL As AHLocale   'need the AHlocale library
	Dim res As String
	AHL.InitializeUS
	Dim MyFrac As Int =AHL.CurrencyFractionDigits
	res = NumberFormat2(MyNumber,1,MyFrac,MyFrac,True)
	Return res.SubString2(0,res.LastIndexOf("."))
End Sub


'convert uri address to standard address
Sub GetPathFromContentResult(UriString As String) As String
   If UriString.StartsWith("/") Then Return UriString 'If the user used a file manager to choose the image
   Dim Proj() As String
   Proj = Array As String("_data")
   Dim Cursor As Cursor
   Dim r As Reflector
   Dim Uri As Object
   Uri = r.RunStaticMethod("android.net.Uri", "parse", _
      Array As Object(UriString), _
      Array As String("java.lang.String"))
   r.Target = r.GetContext
   r.Target = r.RunMethod("getContentResolver")
   Cursor = r.RunMethod4("query", _
   Array As Object(Uri, Proj, Null, Null, Null), _
   Array As String("android.net.Uri", _
      "[Ljava.lang.String;", "java.lang.String", _
      "[Ljava.lang.String;", "java.lang.String"))
 
   Cursor.Position = 0
   Dim res As String
   res = Cursor.GetString("_data")
   Cursor.Close
   Return res
End Sub