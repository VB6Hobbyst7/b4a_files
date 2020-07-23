B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=7.3
@EndOfDesignText@
#Event: MenuItemClick(ItemID as Int)
#Event: Hide
#Event: Show

Private Sub Class_Globals
	Private ev As String
	Private ob As Object
	Private parentPanel,MePanel As Panel
	Private ls1 As ListView
	Private pchild As Panel
	Private ItemHeight As Int : ItemHeight = 50dip
	Private MainColor As Int : MainColor = 0
End Sub

'Initializes the object. You can add parameters to this method if needed.
'Add font to Files asset(filename is font.ttf)
'Author: www.iranapp.org
Public Sub Initialize(Event As String,Mobule As Object,Parent As Panel,CountItem As Int)
	
	ev	=	Event
	ob	=	Mobule
	parentPanel	=	Parent
	CountItem	=	CountItem + 1
	
	MePanel.Initialize("pnlitems")
	Parent.AddView(MePanel,0,0,Parent.Width,Parent.Height)
	MePanel.Color = Colors.ARGB(140,48,48,48)
	MePanel.Visible = False
	
	pchild.Initialize("child")
	pchild.Color = Colors.White
	MePanel.AddView(pchild,0,Parent.Height - CountItem * ItemHeight,Parent.Width,CountItem * ItemHeight + 60dip)
	
	Dim divider As Label
	divider.Initialize("")
	divider.Color	=	Colors.ARGB(50,30, 30, 30)
	pchild.AddView(divider,0,0,pchild.Width,1dip)
	
	Dim lbltitle As Label
	lbltitle.Initialize("")
	lbltitle.Typeface = Typeface.LoadFromAssets("font.ttf")
	lbltitle.TextColor = 0xFFA6A6A6
	lbltitle.TextSize = 14
	lbltitle.Padding = Array As Int(5dip,10dip,15dip,10dip)
	lbltitle.Text = "گزینه مناسب را انتخاب کنید"
	pchild.AddView(lbltitle,0,0,pchild.Width,50dip)
	
	Dim lbldown As Label
	lbldown.Initialize("")
	lbldown.Typeface = Typeface.MATERIALICONS
	lbldown.TextColor = 0xFFA6A6A6
	lbldown.TextSize = 30
	lbldown.Padding = Array As Int(5dip,10dip,15dip,10dip)
	lbldown.Text = Chr(0xE5C5)
	pchild.AddView(lbldown,0,0,50dip,50dip)
	
	ls1.Initialize("ls")
	pchild.AddView(ls1,0,50dip,pchild.Width,pchild.Height)
	
	ls1.SingleLineLayout.ItemHeight 		= ItemHeight
	ls1.SingleLineLayout.Label.Typeface		= Typeface.LoadFromAssets("font.ttf")
	ls1.SingleLineLayout.Label.TextSize		= 15
	ls1.SingleLineLayout.Label.TextColor	= Colors.Black
	ls1.SingleLineLayout.Label.Width		= pchild.Width-20dip
	ls1.SingleLineLayout.Label.Top			= ls1.SingleLineLayout.Label.Top
 	
	ls1.TwoLinesAndBitmap.ItemHeight 		= ItemHeight
	ls1.TwoLinesAndBitmap.Label.Typeface	= Typeface.LoadFromAssets("font.ttf")
	ls1.TwoLinesAndBitmap.Label.TextSize	= 15
	ls1.TwoLinesAndBitmap.Label.TextColor	= Colors.Black
	ls1.TwoLinesAndBitmap.Label.Color = Colors.Red
	ls1.TwoLinesAndBitmap.Label.Width		= pchild.Width-20dip
	ls1.TwoLinesAndBitmap.Label.Top			= ls1.SingleLineLayout.Label.Top
	ls1.TwoLinesAndBitmap.Label.Height		= ls1.SingleLineLayout.Label.Height
	ls1.TwoLinesAndBitmap.Label.Width		= ls1.SingleLineLayout.Label.Width - 52dip
	
	ls1.TwoLinesAndBitmap.SecondLabel.Typeface	= Typeface.MATERIALICONS
	ls1.TwoLinesAndBitmap.SecondLabel.TextSize	= 24
	ls1.TwoLinesAndBitmap.SecondLabel.TextColor	= Colors.Black
	ls1.TwoLinesAndBitmap.SecondLabel.Width		= 50dip
	ls1.TwoLinesAndBitmap.SecondLabel.Height	= ls1.SingleLineLayout.Label.Height
	ls1.TwoLinesAndBitmap.SecondLabel.Left		= ls1.TwoLinesAndBitmap.Label.Width
	
	SetDivider(ls1,Colors.ARGB(20,48,48,48),1)
	
	divider.BringToFront
	
End Sub

Public Sub AddMenuItem(ItemID As String,Order As Int,Title As String)
	ls1.AddSingleLine2(Title,ItemID)
End Sub

Public Sub AddMenuItem2(ItemID As String,Order As Int,Title As String,Filename As String)
	Dim cb As CSBuilder
	cb.Initialize
	cb.Size(0).Image(LoadBitmap(File.DirAssets,Filename & ".png"),25dip,25dip,True).Pop
	cb.Alignment("ALIGN_RIGHT").Size(ls1.SingleLineLayout.Label.TextSize).Color(ls1.TwoLinesAndBitmap.Label.TextColor).Typeface(ls1.TwoLinesAndBitmap.Label.Typeface).Append("  " & Title).Pop
	ls1.AddSingleLine2(cb.PopAll,ItemID)
End Sub

Public Sub SetTransparentParentColor
	MePanel.Color	=	Colors.Transparent
End Sub

Public Sub setMainStatusbarColor(Color As Int)
	MainColor = Color
End Sub

Sub Show
	Dim ime As IME
	ime.Initialize("")
	ime.HideKeyboard
	MePanel.Visible = True
	If MainColor <> 0 Then ChangeStatusColorBase
	pchild.Top = parentPanel.Height
	pchild.SetLayoutAnimated(400,0,parentPanel.Height - pchild.Height,pchild.Width,pchild.Height)
	If SubExists(ob,ev & "_show") Then CallSubDelayed(ob,ev & "_show")
End Sub

Sub Hide
	pnlitems_Click
End Sub

Public Sub Clear
	ls1.Clear
End Sub

Private Sub pnlitems_Click
	If MainColor <> 0 Then
		ChangeStatusColor(MainColor)
	End If
	pchild.SetLayoutAnimated(400,0,parentPanel.Height + pchild.Height,pchild.Width,pchild.Height)
	Sleep(220)
	MePanel.Visible = False
	Sleep(0)
	If SubExists(ob,ev & "_hide") Then CallSubDelayed(ob,ev & "_hide")
End Sub

Private Sub ls_ItemClick (Position As Int, Value As Object) 
	
	Hide
	
	Dim temp As Int
	temp = Value
	
	If SubExists(ob,ev & "_menuitemclick") Then CallSubDelayed2(ob,ev & "_menuitemclick",temp)

End Sub

Private Sub SetDivider(lv As ListView, Color As Int, Height As Int)
	Dim R As Reflector
	R.Target = lv
	Dim CD As ColorDrawable
	CD.Initialize(Color, 0)
	R.RunMethod4("setDivider", Array As Object(CD), Array As String("android.graphics.drawable.Drawable"))
	R.RunMethod2("setDividerHeight", Height, "java.lang.int")
End Sub

Public Sub ChangeStatusColorBase
	ChangeStatusColor(Colors.ARGB(140,48,48,48))
End Sub

Public Sub ChangeStatusColor(Color As Int)
	
	Dim phoneinfo As Phone
	If phoneinfo.SdkVersion >= 21 Then
		Dim jo As JavaObject
		jo.InitializeContext
		Dim window As JavaObject = jo.RunMethodJO("getWindow", Null)
		window.RunMethod("addFlags", Array (0x80000000))
		window.RunMethod("clearFlags", Array (0x04000000))
		window.RunMethod("setStatusBarColor", Array(Color))
	End If
		
End Sub

Public Sub SetStateListView(NormalColor As ColorDrawable,PressColor As ColorDrawable)
	
	Dim SLD As StateListDrawable
	SLD.Initialize
	SLD.AddState(SLD.State_Pressed,PressColor)
	SLD.AddState(-SLD.State_Pressed,NormalColor)
	
	Dim LVO As JavaObject = ls1
	LVO.RunMethod("setSelector",Array As Object(SLD))
	
End Sub

Public Sub getStateMenu As Boolean
	Dim state As Boolean
	state = MePanel.Visible
	Return state
End Sub