B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=8.3
@EndOfDesignText@
Private Sub Class_Globals
	Private telMgr As JavaObject
End Sub

'Initializes the object. You can add parameters to this method if needed.
Public Sub Initialize
	telMgr = GetContext.RunMethod("getSystemService", Array("phone"))
End Sub

Public Sub GetCountryIso As String
	Return telMgr.RunMethod("getSimCountryIso", Null)
End Sub

Private Sub GetContext As JavaObject
	Return GetBA.GetField("context")
End Sub

Private Sub GetBA As JavaObject
	Dim jo As JavaObject
	Dim cls As String = Me
	cls = cls.SubString("class ".Length)
	jo.InitializeStatic(cls)
	Return jo.GetFieldJO("processBA")
End Sub