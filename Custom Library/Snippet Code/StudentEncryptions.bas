Type=Class
Version=4.3
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
'Class module
Sub Class_Globals
	
End Sub

'Initializes the object. You can add parameters to this method if needed.
Public Sub Initialize

End Sub

Sub EncryptAES
Dim kg As KeyGenerator
kg.Initialize("AES")
Dim md As MessageDigest
Dim p As String
p = "mypassword"
kg.KeyFromBytes(md.GetMessageDigest(p.GetBytes("UTF8"), "MD5"))
Dim c As Cipher
c.Initialize("AES")
Dim data() As Byte
data = c.Encrypt("some data".GetBytes("UTF8"), kg.Key, False)
Log(BytesToString(data, 0, data.Length, "UTF8"))
data = c.Decrypt(data, kg.Key, False)
Msgbox(BytesToString(data, 0, data.Length, "UTF8"), "")
End Sub