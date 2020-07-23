B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=StaticCode
Version=9.8
@EndOfDesignText@
'Code module
'Subs in this code module will be accessible from all modules.
Private Sub Process_Globals

End Sub

Public Sub AddItem(Spinner As Spinner,Text As String,Font As Typeface,Size As Int,Color As Int)
	
	Dim cs As RichString
	cs.Initialize(Text)
	cs.Color(Color,0,Text.Length)
	
	cs.Color(Color).Typeface(Font).Size(Size).Append(Text).Pop
	Spinner.Add(cs.PopAll)
	
End Sub