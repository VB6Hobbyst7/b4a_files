Type=Class
Version=7.01
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
Private Sub Class_Globals
	Private module2 As Object
	Private evt As String
	Private ls1 As ListView
	Private parent2 As Panel
End Sub

'Initializes the object. You can add parameters to this method if needed.
Public Sub Initialize(Module As Object,Parent As Panel,Font As Typeface)
	
	module2 = Module
	parent2	= Parent
	
	Dim Width,Height As Int
	Width = 180dip
	Height = 0
	
	ls1.Initialize("ls")
	Parent.AddView(ls1,0,0,Width,Height)
	
	ls1.Visible									= False
	ls1.Color									= Colors.White
	ls1.SingleLineLayout.ItemHeight 			= 40dip
	ls1.SingleLineLayout.Label.Typeface			= Font
	ls1.SingleLineLayout.Label.TextSize			= 15
	ls1.SingleLineLayout.Label.TextColor		= Colors.Black
	ls1.SingleLineLayout.Label.Width			= Width-20dip
	ls1.SingleLineLayout.Label.Top				= ls1.SingleLineLayout.Label.Top
 	
	ls1.TwoLinesAndBitmap.ItemHeight 			= 40dip
	ls1.TwoLinesAndBitmap.Label.Typeface		= Font
	ls1.TwoLinesAndBitmap.Label.TextSize		= 15
	ls1.TwoLinesAndBitmap.Label.TextColor		= Colors.Black
	ls1.TwoLinesAndBitmap.Label.Color 			= Colors.Red
	ls1.TwoLinesAndBitmap.Label.Width			= Width-20dip
	ls1.TwoLinesAndBitmap.Label.Top				= ls1.SingleLineLayout.Label.Top
	ls1.TwoLinesAndBitmap.Label.Height			= ls1.SingleLineLayout.Label.Height
	ls1.TwoLinesAndBitmap.Label.Width			= ls1.SingleLineLayout.Label.Width - 52dip
	
	ls1.TwoLinesAndBitmap.SecondLabel.Typeface	= Typeface.MATERIALICONS
	ls1.TwoLinesAndBitmap.SecondLabel.TextSize	= 24
	ls1.TwoLinesAndBitmap.SecondLabel.TextColor	= Colors.Black
	ls1.TwoLinesAndBitmap.SecondLabel.Width		= 50dip
	ls1.TwoLinesAndBitmap.SecondLabel.Height	= ls1.SingleLineLayout.Label.Height
	ls1.TwoLinesAndBitmap.SecondLabel.Left		= ls1.TwoLinesAndBitmap.Label.Width
	
	SetDivider(ls1,Colors.ARGB(20,48,48,48),1)
	
	Dim c1,c2 As ColorDrawable
	c1.Initialize(Colors.White,0)
	c2.Initialize(Colors.Gray,0)
	SetStateListView(c1,c2)
	
End Sub

Public Sub AddMenuItem(ItemID As String,Order As Int,Title As String)
	ls1.AddSingleLine2(Title,ItemID)
	ls1.Height = ls1.Height + ls1.SingleLineLayout.ItemHeight
End Sub

Public Sub AddMenuItem2(ItemID As String,Order As Int,Title As String,Filename As String)
	Dim cb As CSBuilder
	cb.Initialize
	cb.Size(0).Image(LoadBitmap(File.DirAssets,Filename & ".png"),25dip,25dip,True).Pop
	cb.Alignment("ALIGN_RIGHT").Size(ls1.SingleLineLayout.Label.TextSize).Color(ls1.TwoLinesAndBitmap.Label.TextColor).Typeface(ls1.TwoLinesAndBitmap.Label.Typeface).Append("  " & Title).Pop
	ls1.AddSingleLine2(cb.PopAll,ItemID)
	ls1.Height = ls1.Height + ls1.SingleLineLayout.ItemHeight
End Sub


Private Sub SetDivider(lv As ListView, Color As Int, Height As Int)
	Dim R As Reflector
	R.Target = lv
	Dim CD As ColorDrawable
	CD.Initialize(Color, 0)
	R.RunMethod4("setDivider", Array As Object(CD), Array As String("android.graphics.drawable.Drawable"))
	R.RunMethod2("setDividerHeight", Height, "java.lang.int")
End Sub

Public Sub SetStateListView(NormalColor As ColorDrawable,PressColor As ColorDrawable)
	Dim SLD As StateListDrawable
	SLD.Initialize
	SLD.AddState(SLD.State_Pressed,PressColor)
	SLD.AddState(-SLD.State_Pressed,NormalColor)
	
	Dim LVO As JavaObject = ls1
	LVO.RunMethod("setSelector",Array As Object(SLD))
End Sub

Public Sub Show(View As View)
	
	If ls1.Visible Then
		ls1.SetVisibleAnimated(500,False)
		Return
	End If
	
	If ls1.Top + ls1.Height < parent2.Height Then
		ls1.Top = View.Top + View.Height
	Else
		ls1.Top = View.Top - View.Height - ls1.Height
	End If
	
	If parent2.Width - View.Left > ls1.Width Then
		ls1.Left = View.Left
	Else
		ls1.Left = View.Left - View.Width - ls1.Width
	End If
	
	ls1.BringToFront
	ls1.SetVisibleAnimated(800,True)
	
End Sub