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

Sub Encrypt(dataToEncrypt As String ) As String 

   Dim kg As KeyGenerator
   Dim c As Cipher
   Dim B64 As Base64
   Dim bconv As ByteConverter

   Dim data(0) As Byte
   Dim iv(0) As Byte
   iv = Array As Byte(211, 5, 233, 24, 55, 166, 7, 88) ' 16 bytes for AES
      
   c.Initialize("DESEDE/CBC/PKCS5Padding")    
   c.InitialisationVector = iv
   kg.Initialize("DESEDE") 
   
   kg.KeyFromBytes(bconv.StringToBytes("1234567890123456","ASCII"))
   data = bconv.StringToBytes(dataToEncrypt, "ASCII")      
   data = c.Encrypt(data, kg.Key, True)            

   Return B64.EncodeBtoS(data, 0, data.Length)
   
End Sub 

Sub Decrypt(encryptedData As String ) As String 

   Dim kg As KeyGenerator
   Dim c As Cipher
   Dim B64 As Base64
   Dim bconv As ByteConverter

   Dim data(0) As Byte
   Dim iv(0) As Byte
   iv = Array As Byte(211, 5, 233, 24, 55, 166, 7, 88) ' 16 bytes for AES
      
   c.Initialize("DESEDE/CBC/PKCS5Padding")    
   c.InitialisationVector = iv
   kg.Initialize("DESEDE")    
   kg.KeyFromBytes(bconv.StringToBytes("1234567890123456","ASCII"))
   
   
   data = B64.DecodeStoB(encryptedData)
   data = c.Decrypt(data, kg.Key, True)   

   Return bconv.StringFromBytes(data, "ASCII")

End Sub

Sub EncodeUrl(url As String)
	Dim b1 As StringUtils
	Return b1.EncodeUrl(url,"UTF8")
End Sub

Sub DecodeUrl(url As String)
	Dim b1 As StringUtils
	Return b1.DecodeUrl(url,"UTF8")
End Sub

Sub Encode64(str As String) As String
	Dim b1 As StringUtils
	Return b1.EncodeBase64(str.GetBytes("UTF8"))
End Sub

Sub Decode64(str As String)
	Dim b1 As StringUtils
	Dim b2 As ByteConverter
	Return b2.StringFromBytes(b1.DecodeBase64(str),"UTF8")
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

Sub EncryptAES(Data As String,Salt As String) As String

Dim kg As KeyGenerator
Dim md As MessageDigest
Dim c As Cipher
Dim Data1() As Byte
	
	Try
		kg.Initialize("AES")
		kg.KeyFromBytes(md.GetMessageDigest(Salt.GetBytes("UTF8"), "MD5"))
		c.Initialize("AES")
		Data1 = c.Encrypt(Data.GetBytes("UTF8"), kg.Key, False)
		Return BytesToString(Data1, 0, Data1.Length, "UTF8")
	Catch
		Return ""
	End Try
	
End Sub

Sub DecryptAES(Data As String,Pass As String) As String

Dim kg As KeyGenerator
Dim md As MessageDigest
Dim c As Cipher
Dim Data1() As Byte
	
	Try
		kg.Initialize("AES")
		kg.KeyFromBytes(md.GetMessageDigest(Pass.GetBytes("UTF8"), "MD5"))
		c.Initialize("AES")
		Data1 = c.Decrypt(Data.GetBytes("UTF8"), kg.Key, False)
		Return BytesToString(Data1, 0, Data1.Length, "UTF8")
	Catch
		Return ""
	End Try
	
End Sub