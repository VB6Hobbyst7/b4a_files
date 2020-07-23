Type=Class
Version=3.15
@EndOfDesignText@
'Class module
Sub Class_Globals
 Dim sql1 As SQL
 Dim bc1 As ByteConverter
End Sub

Public Sub Initialize(sDir As String,sBank As String) As Boolean
If File.Exists(sDir,sBank) = False Then
 Return False
End If
Try
  sql1.Initialize(sDir,sBank,False)
Catch
 Return True
End Try
Return False
End Sub