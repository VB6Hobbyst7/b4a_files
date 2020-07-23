B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=7.3
@EndOfDesignText@
#Event: ContactChooser(contact As Contact)

Private Sub Class_Globals
	Private ion As Object
	Private meObject As Object
	Type Contact(Name As String,Phones As List,ID As String)
	Private evt As String
End Sub

'Add below permission to manifest
'<code>AddPermission(android.permission.READ_CONTACTS)</code>
'
'Return it Contact Type
Public Sub Initialize(Module As Object,Event As String)
	meObject = Module
	evt		 = Event & "_contactchooser"
End Sub

Public Sub ShowPicker
	Dim i As Intent
	i.Initialize(i.ACTION_PICK, "content://com.android.contacts/contacts")
	StartActivityForResult(i)
End Sub

Private Sub StartActivityForResult(i As Intent)
	Dim jo As JavaObject = GetBA
	ion = jo.CreateEvent("anywheresoftware.b4a.IOnActivityResult", "ion", Null)
	jo.RunMethod("startActivityForResult", Array As Object(ion, i))
End Sub

Private Sub GetBA As Object
	Dim jo As JavaObject
	Dim cls As String = meObject
	cls = cls.SubString("class ".Length)
	jo.InitializeStatic(cls)
	Return jo.GetField("processBA")
End Sub

Private Sub ion_Event (MethodName As String, Args() As Object) As Object
	
	If Args(0) = -1 Then 'resultCode = RESULT_OK
		Dim i As Intent = Args(1)
		Dim id As String = i.GetData.SubString(i.GetData.LastIndexOf("/") + 1)
		Dim cu As ContactsUtils
		cu.Initialize
		
		Dim Contact As Contact
		Contact.Initialize
		Contact.ID		=	id
		Contact.Name	=	cu.GetNameFromId(id)
		Contact.Phones	=	cu.GetPhones(id)
		
		CallSub2(meObject,evt.ToLowerCase,Contact)
		
	End If
	
	Return Null
	
End Sub