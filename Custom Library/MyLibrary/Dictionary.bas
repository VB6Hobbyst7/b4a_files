B4A=true
Group=Libraries\Main
ModulesStructureVersion=1
Type=Class
Version=7.8
@EndOfDesignText@
Private Sub Class_Globals
	Private sql2 As SQL	
End Sub

'Initializes the object. You can add parameters to this method if needed.
Public Sub Initialize(Filename As String)
	
	If File.Exists(File.DirInternal,Filename) = False Then
		sql2.Initialize(File.DirInternal,Filename,True)
		sql2.ExecNonQuery("CREATE TABLE dictionary (sKey TEXT,sValue TEXT,sCategory TEXT,sType TEXT)")
	Else
		sql2.Initialize(File.DirInternal,Filename,False)
	End If
	
End Sub

Sub Add(sKey As String,sValue As Object,sCategory As String)
	
	Dim Value As String
	Dim sType As String
	
	If sValue Is List Then
		sType 	=	"list"
		Value	=	List2Json(sValue)
	Else if sValue Is Map Then
		sType 	=	"map"
		Value	=	Map2Json(sValue)
	Else
		sType	=	"other"
		Value	=	sValue
	End If
	
	sql2.ExecNonQuery2("INSERT INTO dictionary VALUES(?,?,?,?)",Array As Object(sKey,Value,sCategory,sType))
	
End Sub

Sub ConstainKey(sKey As String) As Object
	
	Dim res As Cursor
	res	=	sql2.ExecQuery("SELECT * FROM dictionary WHERE sKey = '" & sKey & "'")
	
	If res.RowCount = 0 Then
		res.Close
		Return Null
	End If
	
	res.Position = 0
	
	If res.GetString("sType") = "list" Then
		res.Close
		Return Json2List(res.GetString("sValue"))
	End If
	
	If res.GetString("sType") = "map" Then
		res.Close
		Return Json2Map(res.GetString("sValue"))
	End If
	
	Dim temp As String
	temp	=	res.GetString("sValue")
	
	res.Close
	
	Return temp
	
End Sub

Sub ConstainCategory(sCategory As String) As Boolean
	
	Dim res As Cursor
	res	=	sql2.ExecQuery("SELECT * FROM dictionary WHERE sCategory = '" & sCategory & "'")
	
	If res.RowCount = 0 Then
		res.Close
		Return False
	Else
		res.Close
		Return True
	End If
	
End Sub

Sub GetRecords(sKey As String,sValue As String,sCategory As String) As List
	
	Dim res As Cursor
	res	=	sql2.ExecQuery("SELECT * FROM dictionary WHERE sKey = '" & sValue & "' AND sCategory = '" & sCategory & "'")
	
	If res.RowCount = 0 Then
		res.Close
		Return Null
	Else
		
		Dim ls As List
		ls.Initialize
		
		For i = 0 To res.RowCount - 1
			res.Position = i
			ls.Add(CreateMap("sKey":res.GetString("sKey"),"sValue":res.GetString("sValue"),"sType":res.GetString("sType")))
		Next
		
		res.Close
		
		Return ls
		
	End If
	
End Sub

Sub GetCountries(Str As String) As List
	
	Dim res As Cursor
	
	If Str <> "" Then
		res	=	sql2.ExecQuery("SELECT * FROM country WHERE LOWER(sName) LIKE '%" & Str & "%' OR sCode = '" & Str & "'")
	Else
		res	=	sql2.ExecQuery("SELECT * FROM country")
	End If
	
	If res.RowCount = 0 Then
		res.Close
		Return Null
	Else
		
		Dim ls As List
		ls.Initialize
		
		For i = 0 To res.RowCount - 1
			res.Position = i
			ls.Add(CreateMap("sID":res.GetString("sID"),"sCode":res.GetString("sCode"),"sName":res.GetString("sName"),"sCallingCode":res.GetString("sCallingCode"),"sAlphaCode":res.GetString("sAlphaCode"),"sNationality":res.GetString("sNationality")))
		Next
		
		res.Close
		
		Return ls
		
	End If
	
End Sub

Sub GetProvinces(CountryCode As String,Str As String) As List
	
	Dim res As Cursor
	If Str <> "" Then
		res	=	sql2.ExecQuery2("SELECT * FROM province WHERE sCountryCode = ? AND LOWER(sName) LIKE '%?%'",Array As String(CountryCode,Str))
	Else
		res	=	sql2.ExecQuery2("SELECT * FROM province WHERE sCountryCode = ?",Array As String(CountryCode))
	End If
	
	If res.RowCount = 0 Then
		res.Close
		Return Null
	Else
		
		Dim ls As List
		ls.Initialize
		
		For i = 0 To res.RowCount - 1
			res.Position = i
			ls.Add(CreateMap("sID":res.GetString("sID"),"sName":res.GetString("sName"),"sCountryCode":res.GetString("sCountryCode")))
		Next
		
		res.Close
		
		Return ls
		
	End If
	
End Sub

Sub GetNationality(Str As String) As List
	
	Dim res As Cursor
	If Str <> "" Then
		res	=	sql2.ExecQuery("SELECT * FROM nationality WHERE LOWER(sNationality) LIKE '%" & Str & "%' OR sCode = '" & Str & "'")
	Else
		res	=	sql2.ExecQuery("SELECT * FROM nationality")
	End If
	
	If res.RowCount = 0 Then
		res.Close
		Return Null
	Else
		
		Dim ls As List
		ls.Initialize
		
		For i = 0 To res.RowCount - 1
			res.Position = i
			ls.Add(CreateMap("sCode":res.GetString("sCode"),"sTitle":res.GetString("sNationality")))
		Next
		
		res.Close
		
		Return ls
		
	End If
	
End Sub

Sub GetLanguage(Str As String) As List
	
	Dim res As Cursor
	If Str <> "" Then
		res	=	sql2.ExecQuery("SELECT * FROM language WHERE LOWER(sTitle) LIKE '%" & Str & "%'")
	Else
		res	=	sql2.ExecQuery("SELECT * FROM language")
	End If
	
	If res.RowCount = 0 Then
		res.Close
		Return Null
	Else
		
		Dim ls As List
		ls.Initialize
		
		For i = 0 To res.RowCount - 1
			res.Position = i
			ls.Add(CreateMap("sID":res.GetString("sID"),"sTitle":res.GetString("sTitle"),"sCode":res.GetString("sCode")))
		Next
		
		res.Close
		
		Return ls
		
	End If
	
End Sub

Private Sub List2Json(List As List) As String
	
	Dim Js As JSONGenerator
	Js.Initialize2(List)
	Return Js.ToString
	
End Sub

Private Sub Map2Json(Map As Map) As String
	
	Dim Js As JSONGenerator
	Js.Initialize(Map)
	Return Js.ToString
	
End Sub

Private Sub Json2List(Json As String) As List
	
	Dim Js As JSONParser
	Js.Initialize(Json)
	Return Js.NextArray
	
End Sub

Private Sub Json2Map(Json As String) As Map
	
	Dim Js As JSONParser
	Js.Initialize(Json)
	Return Js.NextObject
	
End Sub