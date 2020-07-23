Type=Class
Version=6.8
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
#Event: SelectedNode(Node As Map)

Private Sub Class_Globals
	Private Categories As List
	Private sv1 As CustomListView
	Private lbltitle As Label
	Private lblicon As Label
	Private OpenedItem As Map
	Private Indent As Int
	Private ob As Object
	Private evt As String
	Private ItemHeight As Int
	Private ParentText,ChildText,OpenParentText,CloseParentText As String
End Sub

'Author: www.iranapp.org
'
'Example:
'<code>
'Dim nodes As List
'nodes.Initialize
'nodes.Add(CreateMap("sID":"1","sName":"Main","sParent":"0"))
'nodes.Add(CreateMap("sID":"2","sName":"Sub Main","sParent":"1"))
'nodes.Add(CreateMap("sID":"3","sName":"Iranapp.org","sParent":"1"))
'
'Dim tv As TreeView
'tv.Initialize(Activity,Me,"SelectedNode",nodes)
'tv.SetListColor(Colors.White)
'tv.Build
'</code>
Public Sub Initialize(Panel As Panel,Module As Object,Event As String,Nodes As List)
	
	Categories	= Nodes
	Indent		= 20dip
	ob			= Module
	evt			= Event
	
	sv1.Initialize(Me,"ScrollCategory")
	OpenedItem.Initialize
	
	Panel.AddView(sv1.AsView,0,0,Panel.Width,Panel.Height)
	
	If File.Exists(File.DirAssets,"frmtemplate_category.bal") = False Then
		LogColor("Please add frmtemplate_category.bal file to your asset",Colors.Red)
		Return
	End If
	
	ParentText		= ""
	ChildText		= ""
	OpenParentText	= ""
	CloseParentText	= ""
	
	Dim p As Panel
	p.Initialize("")
	p.LoadLayout("frmtemplate_category")
	ItemHeight = p.GetView(0).Height
	
End Sub

'Choose icon from Desinger in FontAwsome section
Sub SetParentIcon(Icon As String)
	ParentText = Icon	
End Sub

'Choose icon from Desinger in FontAwsome section
Sub SetOpenParentIcon(Icon As String)
	OpenParentText = Icon
End Sub

'Choose icon from Desinger in FontAwsome section
Sub SetChildIcon(Icon As String)
	ChildText = Icon
End Sub

Sub SetListColor(Color As Int)
	sv1.Color = Color
End Sub

Sub Build
	
	For i = 0 To Categories.Size - 1
		
		Dim data As Map
		data = Categories.Get(i)
		
		If data.Get("sParent") = "0" Then
			AddItem(data.Get("sName"),data.Get("sID"),data.Get("sParent"))
		End If
		
	Next
	
End Sub

Private Sub AddItem(Title As String,ID As String,Parent As String)

	Dim p1 As Panel
	p1.Initialize("")
	sv1.Add(p1,ItemHeight,Null)
	p1.LoadLayout("frmtemplate_category")
	lblicon.Text = ParentText
	lbltitle.Text = Title
	lbltitle.Tag = CreateMap("parent":Parent,"id":ID,"name":Title)
	
End Sub

Private Sub lbltitle_Click
	
	Dim lb As Label
	lb = Sender
	lb.SetColorAnimated(500,Colors.Gray,Colors.Transparent)
	
	If lb.Tag Is List Then
		
		Dim arr As List
		arr = lb.Tag
		
		CallSubDelayed2(ob,evt & "_selectednode",CreateMap("sID":arr.Get(0),"sName":arr.Get(1),"sParent":arr.Get(2)))
		
		Return
		
	End If
	
	Dim data As Map
	data = lb.Tag
	
	If OpenedItem.ContainsKey(data.Get("id")) = True Then
		
		Return
		
	End If
	
	Dim ls As List
	ls = FindIDSubCategories(data.Get("id"))
	
	Dim parent As Panel
	parent = lb.Parent
	parent = parent.Parent

	Dim index As Int
	index = parent.Tag
	
	If ls.IsInitialized Then
		
		Dim OpenedSubItems As List
		OpenedSubItems.Initialize
		
		For i = 0 To ls.Size - 1
			
			Dim row As Map
			
			row = ls.Get(i)
			
			Dim p1 As Panel
			p1.Initialize("")
			
			If index = 0 Then
				sv1.InsertAt(index+i+1,p1,ItemHeight,Null)
			Else
				sv1.InsertAt(index+i+1,p1,ItemHeight,Null)
			End If
			
			Dim blnIsLastItem As Boolean
			Dim exist As List
			
			exist = FindIDSubCategories(row.Get("sID"))
			If exist.IsInitialized Then
				If exist.Size = 0 Then
					blnIsLastItem = True
				End If
			End If
			
			p1.Width = 100%x-Indent
			p1.LoadLayout("frmtemplate_category")
			
			lbltitle.Text = row.Get("sName")
			lbltitle.Tag = CreateMap("parent":row.Get("sParent"),"id":row.Get("sID"),"name":row.Get("sName"))
			
			If blnIsLastItem = True Then
				lblicon.Text = ChildText
				Dim ls As List
				ls.Initialize
				ls.Add(row.Get("sID"))
				ls.Add(row.Get("sName"))
				ls.Add(row.Get("sParent"))
				lbltitle.Tag = ls
			Else
				lblicon.Text = ParentText
			End If
			
		Next
		
		OpenedItem.Put(data.Get("id"),OpenedSubItems)
		
		Indent = Indent + 20dip
		
		Dim panel As Panel
		Dim lbico As Label
		
		panel = lb.Parent
		lbico = panel.GetView(1)
		
		lbico.Text = OpenParentText
		
		If index <> 0 Then
			parent.Tag = index + ls.Size + 1
		End If
		
	End If
	
End Sub

Private Sub lbltitle_LongClick
	
	Dim lb As Label
	lb = Sender
	lb.SetColorAnimated(500,Colors.Gray,Colors.Transparent)
	
	If lb.Tag Is List Then Return
	
	Dim data As Map
	data = lb.Tag
	
	If data.ContainsKey("id") Then
		
		CallSubDelayed2(ob,evt & "_selectednode",CreateMap("sID":data.Get("id"),"sName":data.Get("name"),"sParent":data.Get("parent")))
		
	End If
	
End Sub

Private Sub FindIDSubCategories(ID As String) As List
	
	Dim ls As List
	ls.Initialize
	
	For i = 0 To Categories.Size - 1
		Dim data As Map
		data = Categories.Get(i)
		If data.Get("sParent") = ID Then ls.Add(data)
	Next
	
	Return ls
	
End Sub