Type=Class
Version=6.8
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
'Modified version of CustomListView with support for "pull to refresh" feature
'v1.01
Sub Class_Globals
	Private sv As ScrollView
	Private items As List
	Private panels As List
	Private dividerHeight As Float
	Private pressedDrawable As Object
	Private EventName As String
	Private CallBack As Object
	Private su As StringUtils
	Public DefaultTextSize As Int
	Public DefaultTextColor As Int
	Public DefaultTextBackgroundColor As Int
	Private TopPanel As Panel
	Private TopPanelHeight As Int
	Private timer1 As Timer
	Private TopPanelVisible As Boolean
	Private TopPanelRefreshing As Boolean
End Sub

Public Sub Initialize (vCallback As Object, vEventName As String)
	sv.Initialize2(0, "sv")
	items.Initialize
	panels.Initialize
	dividerHeight = 0
	EventName = vEventName
	CallBack = vCallback
	sv.Color = Colors.Transparent
	Dim r As Reflector
	Dim idPressed As Int
   	idPressed = r.GetStaticField("android.R$drawable", "list_selector_background")
    r.Target = r.GetContext
    r.Target = r.RunMethod("getResources")
	pressedDrawable = r.RunMethod2("getDrawable", idPressed, "java.lang.int")
	DefaultTextColor = Colors.White
	DefaultTextSize = 16
	DefaultTextBackgroundColor = Colors.Black
	timer1.Initialize("timer1", 200)
End Sub

Public Sub AddTopPanel(Pnl As Panel, ItemHeight As Int)
	TopPanel = Pnl
	TopPanelHeight = ItemHeight
	If sv.Panel.Height < sv.Height + ItemHeight + 5dip Then
		Dim p As Panel
		p.Initialize("")
		p.Color = DefaultTextBackgroundColor
		Add(p, sv.Height + ItemHeight + 5dip - sv.Panel.Height, "")
	End If
End Sub

Private Sub SV_ScrollChanged(Position As Int)
	If timer1.Enabled = True Then Return
	If Position = 0 And timer1.Enabled = False And TopPanelVisible = False Then
		timer1.Enabled = True
	Else If TopPanelVisible And Position < TopPanelHeight / 2 And TopPanelRefreshing = False Then
		Refresh
	Else If TopPanelVisible And Position > TopPanelHeight + 2dip And TopPanelRefreshing = False Then
		StopRefresh
	End If
End Sub

Sub setColor(Color As Int)
	sv.Color = Color
	sv.Panel.Color = Color
End Sub

Private Sub Refresh
	CallSub(CallBack, EventName & "_Refresh")
	TopPanelRefreshing = True
End Sub

Public Sub StopRefresh
	TopPanelRefreshing = False
	TopPanelVisible = False
	If panels.Size > 0 Then
		Dim p As Panel = panels.Get(0)
		If p.GetView(0) = TopPanel Then RemoveAt(0)
	End If
End Sub

#IgnoreWarnings: 5
Private Sub Timer1_Tick
	If TopPanelVisible = False And sv.ScrollPosition = 0 Then
		Dim pos = sv.ScrollPosition + TopPanelHeight + dividerHeight
		InsertAt(0, TopPanel, TopPanelHeight, "")
		ScrollTo(pos)
		TopPanelVisible = True
	End If
	timer1.Enabled = False
End Sub

Private Sub ScrollTo(pos As Int)
	'sv.ScrollTo smoothly scrolls to the position. In this case we want to immediately change the scroll position
	'so we use Reflection to call the native scrollTo method.
	Dim r As Reflector
	r.Target = sv
	r.RunMethod3("scrollTo", 0, "java.lang.int", pos, "java.lang.int")
End Sub

'Clears all items.
Public Sub Clear
	StopRefresh
	items.Clear
	panels.Clear
	sv.Panel.RemoveAllViews
	sv.Panel.Height = 0
End Sub

'Returns a view object that holds the list.
Public Sub AsView As View
	Return sv
End Sub

'Returns the number of items.
Public Sub GetSize As Int
	Return items.Size
End Sub

'Returns the Panel stored at the specified index.
Public Sub GetPanel(Index As Int) As Panel
	Dim p As Panel
	p = panels.Get(Index) 'this is the parent panel
	Return p.GetView(0)
End Sub

'Returns the value stored at the specified index.
Public Sub GetValue(Index As Int) As Object
	Return items.Get(Index)
End Sub

'Removes the item at the specified index.
Public Sub RemoveAt(Index As Int)
	Dim removePanel, p As Panel
	removePanel = panels.Get(Index)
	For i = Index + 1 To items.Size - 1
		p = panels.Get(i)
		p.Tag = i - 1
		p.top = p.top - removePanel.Height - dividerHeight
	Next
	sv.Panel.Height = sv.Panel.Height - removePanel.Height - dividerHeight
	items.RemoveAt(Index)
	panels.RemoveAt(Index)
	removePanel.RemoveView
	Dim originalPnl As Panel = removePanel.GetView(0)
	originalPnl.Background = removePanel.Background
	originalPnl.RemoveView
End Sub

'Adds a text item. The item height will be adjusted based on the text.
Public Sub AddTextItem(Text As String, Value As Object)
	InsertAtTextItem(items.Size, Text, Value)
End Sub

'Inserts a text item at the specified index.
Public Sub InsertAtTextItem(Index As Int, Text As String, Value As Object)
	Dim pnl As Panel
	pnl.Initialize("")
	Dim lbl As Label
	lbl.Initialize("")
	lbl.Gravity = Bit.Or(Gravity.CENTER_VERTICAL, Gravity.LEFT)
	pnl.AddView(lbl, 5dip, 2dip, sv.Width - 5dip, 20dip)
	lbl.Text = Text
	lbl.TextSize = DefaultTextSize
	lbl.TextColor = DefaultTextColor
	pnl.Color = DefaultTextBackgroundColor
	Dim minHeight As Int
	minHeight = su.MeasureMultilineTextHeight(lbl, Text)
	lbl.Height = Max(50dip, minHeight)
	InsertAt(Index, pnl, lbl.Height + 2dip, Value)
End Sub

'Adds a custom item at the specified index.
Public Sub InsertAt(Index As Int, Pnl As Panel, ItemHeight As Int, Value As Object)
    
	Dim sd As StateListDrawable
    sd.Initialize
    sd.AddState(sd.State_Pressed, pressedDrawable)
    sd.AddCatchAllState(Pnl.Background)
	
	'create another panel to handle the click event
	Dim p As Panel
	p.Initialize("panel")
	p.Background = sd
	Dim cd As ColorDrawable
	cd.Initialize(Colors.Transparent, 0)
    Pnl.Background = cd
	p.AddView(Pnl, 0, 0, sv.Width, ItemHeight)
	p.Tag = Index
	
	If Index = items.Size Then
		items.Add(Value)
		panels.Add(p)
		Dim top As Int
		If Index = 0 Then top = dividerHeight Else top = sv.Panel.Height
		sv.Panel.AddView(p, 0, top, sv.Width, ItemHeight)
	Else
		Dim top As Int
		If Index = 0 Then
			top = dividerHeight
		Else
			Dim previousPanel As Panel
			previousPanel = panels.Get(Index - 1)
			top = previousPanel.top + previousPanel.Height + dividerHeight
		End If

		Dim p2 As Panel
		For i = Index To panels.Size - 1
			p2 = panels.Get(i)
			p2.top = p2.top + ItemHeight + dividerHeight
			p2.Tag = i + 1
		Next
		items.InsertAt(Index, Value)
		panels.InsertAt(Index, p)
		sv.Panel.AddView(p, 0, top, sv.Width, ItemHeight)
	End If
	sv.Panel.Height = sv.Panel.Height + ItemHeight + dividerHeight
	If items.Size = 1 Then sv.Panel.Height = sv.Panel.Height + dividerHeight
End Sub

'Adds a custom item.
Public Sub Add(Pnl As Panel, ItemHeight As Int, Value As Object)
	InsertAt(items.Size, Pnl, ItemHeight, Value)
End Sub

'Scrolls the list to the specified item.
Public Sub JumpToItem(Index As Int)
	Dim top As Int
	Dim p As Panel
	For i = 0 To Min(Index - 1, items.Size - 1)
		p = panels.Get(i)
		top = top + p.Height + dividerHeight
	Next
	sv.ScrollPosition = top
	'The scroll position doesn't always gets updated without two calls to DoEvents
	DoEvents
	sv.ScrollPosition = top
	DoEvents
End Sub

Private Sub Panel_Click
	If SubExists(CallBack, EventName & "_ItemClick") Then
		Dim v As View
		v = Sender
		CallSub3(CallBack, EventName & "_ItemClick", v.Tag, items.Get(v.Tag))
	End If
End Sub

#IgnoreWarnings: 3
'Returns the index of the item that holds the given view.
Public Sub GetItemFromView(v As View)
	Dim r As Reflector
	Dim parent, current As Object
	parent = v
	Do While (parent Is Panel) = False Or sv.Panel <> parent
		current = parent
		r.Target = current
		parent = r.RunMethod("getParent")
	Loop
	v = current
	Return v.Tag
	
End Sub
