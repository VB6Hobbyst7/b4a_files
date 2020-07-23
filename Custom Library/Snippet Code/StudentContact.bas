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

'check contact number in contacts
Sub CheckExistContact(sNumber As String) As Boolean
	Dim Contacts2 As Contacts2
	Dim sphone As String
	Dim listOfContacts As List
	listOfContacts = Contacts2.GetAll(True,False)

	For i = 0 To listOfContacts.Size - 1
	 Dim Contact As Contact
	 Contact = listOfContacts.Get(i)
	 Dim phones As Map
	 phones = Contact.GetPhones
	 For j = 0 To phones.Size - 1
	  sphone = phones.GetKeyAt(j)
	  If sphone.IndexOf(sNumber) <> -1 Then
	   Return True
	  End If
	 Next
	Next
	Return False
End Sub

'get contact information from phonenumber
Sub GetContactInformation(sNumber As String) As Contact
	Dim Contacts2 As Contacts2
	Dim sphone As String
	Dim listOfContacts As List
	listOfContacts = Contacts2.GetAll(True,False)

	For i = 0 To listOfContacts.Size - 1
	 Dim Contact As Contact
	 Contact = listOfContacts.Get(i)
	 Dim phones As Map
	 phones = Contact.GetPhones
	 For j = 0 To phones.Size - 1
	  sphone = phones.GetKeyAt(j)
	  If sphone.IndexOf(sNumber) <> -1 Then
	   Return Contact
	  End If
	 Next
	Next
End Sub

'get list of contact
Sub ListContact As Map

	Dim listphones1 As List
	Dim listOfNames As Map
	listphones1.Initialize
	listOfNames.Initialize
	'Create a list with the contacts names
	For i = 0 To listphones1.Size - 1
	    Dim c As Contact
	    c = listphones1.Get(i) 'fetch the Contact from the original list
	    listOfNames.Put(c.DisplayName,"False")
	Next
	
	Return  listOfNames

End Sub