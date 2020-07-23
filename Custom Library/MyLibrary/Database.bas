B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=StaticCode
Version=7.8
@EndOfDesignText@
'Code module
'Subs in this code module will be accessible from all modules.
Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

End Sub

Public Sub DBTableExists(DB As SQL, TableName As String) As Boolean
	Dim Result As Boolean = False
	Dim Cur As Cursor

	Try
		Cur = DB.ExecQuery("SELECT name FROM sqlite_master WHERE type='table' AND name = '" & TableName & "'")
		Result = (Cur.IsInitialized And Cur.RowCount = 1)
	Catch
		Log("DBTableExists failed." & CRLF & LastException.Message)
	End Try
 
	Return Result
End Sub
