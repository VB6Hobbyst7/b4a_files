Type=Class
Version=7.3
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
'Class module
Sub Class_Globals
	Private lsheader As ListView
	Private sm As SlidingMenu
	Private imgLogo As ImageView
	Private font_name As String
	Private title_color,icon_color,divider_color,header_color,header_textcolor,list_bgcolor As Int
	Private tmr As Timer
End Sub

Public Sub Initialize(Module As Object)
	
	Dim offset As Int = 90dip
	
	sm.Initialize("Menu")
	
	sm.BehindOffset = offset
	sm.Mode = sm.RIGHT
	
	lsheader.Initialize("lsheader")
	
	imgLogo.Initialize("")

	sm.Menu.Color = Colors.White
	
	sm.Menu.AddView(imgLogo,0,0, 100%x-offset, 225dip)
	sm.Menu.AddView(lsheader,0,imgLogo.Height, 100%x-offset, 100%y - imgLogo.Height)
	
	imgLogo.Bitmap	=	LoadBitmapResize(File.DirAssets,"logo.jpg",imgLogo.Width,imgLogo.Height,True)
	
	Dim bt As Bitmap
	bt	=	imgLogo.Bitmap
	
	imgLogo.Height	=	bt.Height
	lsheader.Top	=	imgLogo.Height
	
End Sub

Sub BuildMenu
	
	ChangeListviewStyle(lsheader)
	SetDivider(lsheader,divider_color,1)
	
End Sub

Public Sub setBackgroundColor(Value As Int)
	list_bgcolor	=	Value
End Sub

Public Sub setHeaderColor(Value As Int)
	header_color	=	Value
End Sub

Public Sub setHeaderTextColor(Value As Int)
	header_textcolor	=	Value
End Sub

Public Sub	setDividerColor(Value As Int)
	divider_color	=	Value	
End Sub

Public Sub setFontName(Value As String)
	font_name	=	Value	
End Sub

Public Sub setTextColor(Value As Int)
	title_color	=	Value
End Sub

Public Sub setIconColor(Value As Int)
	icon_color	=	Value
End Sub

Public Sub ToggleMenu
	
	If sm.Visible = True Then
		sm.HideMenus
	Else
		sm.ShowMenu
	End If
	
End Sub

'Pick icon from MATERIALFONT
Public Sub AddMenu(Title As String,Icon As String,Tag As Object)
	
	lsheader.AddTwoLines2(Title,Icon,Tag)
	
End Sub

Public Sub AddHeader(Title As String)
	
	lsheader.AddSingleLine("  " & Title)
	
End Sub

Private Sub lsheader_ItemClick (Position As Int, Value1 As Object)
	
	sm.HideMenus
	tmr.Initialize("tmr",500)
	tmr.Enabled = True
	
End Sub

Private Sub tmr_Tick
	
	tmr.Enabled = False
	
End Sub

Public Sub GetVisible As Boolean
	Return sm.Visible
End Sub

Private Sub GetDevicePhysicalSize As Float
	Dim lv As LayoutValues
	lv = GetDeviceLayoutValues
	Return Sqrt(Power(lv.Height / lv.Scale / 160, 2) + Power(lv.Width / lv.Scale / 160, 2))
End Sub

Private Sub ChangeListviewStyle(lv1 As ListView)
	
	lv1.Color									= list_bgcolor
	sm.Menu.Color								= list_bgcolor
	
	If GetDevicePhysicalSize > 5 Then
		lv1.TwoLinesLayout.ItemHeight			= 130dip
	Else
		lv1.TwoLinesLayout.ItemHeight			= 50dip
		lv1.SingleLineLayout.ItemHeight			= 50dip
	End If
	
	If GetDevicePhysicalSize < 6 Then
		lv1.TwoLinesLayout.Label.TextSize		= 14
		lv1.SingleLineLayout.Label.TextSize		= 12
		lv1.TwoLinesLayout.SecondLabel.TextSize = 19
	Else
		lv1.TwoLinesLayout.Label.TextSize		= 16
		lv1.SingleLineLayout.Label.TextSize		= 19
		lv1.TwoLinesLayout.SecondLabel.TextSize = 22
	End If
	
	lv1.TwoLinesLayout.Label.Height			= lv1.TwoLinesLayout.ItemHeight
	lv1.TwoLinesLayout.SecondLabel.Height	= lv1.TwoLinesLayout.Label.Height
	
	lv1.TwoLinesLayout.Label.TextColor		= title_color
	lv1.SingleLineLayout.Label.TextColor 	= header_textcolor
	lv1.SingleLineLayout.Label.Color		= header_color
	lv1.TwoLinesLayout.SecondLabel.TextColor= icon_color
	
	lv1.TwoLinesLayout.Label.Typeface		= Typeface.LoadFromAssets(font_name)
	lv1.SingleLineLayout.Label.Typeface		= Typeface.LoadFromAssets(font_name)
	lv1.TwoLinesLayout.SecondLabel.Typeface	= Typeface.MATERIALICONS
	
	lv1.TwoLinesLayout.SecondLabel.Top		= lv1.TwoLinesLayout.Label.Top
	lv1.TwoLinesLayout.Label.Top			= lv1.TwoLinesLayout.Label.Top+2dip
	lv1.SingleLineLayout.Label.Left			= 0
	
	lv1.TwoLinesLayout.SecondLabel.Width	= lv1.Width-22dip
	lv1.TwoLinesLayout.Label.Width			= lv1.Width-50dip
	lv1.SingleLineLayout.Label.Width		= lv1.Width
	
	lv1.TwoLinesLayout.Label.Gravity 		= Bit.Or(Gravity.RIGHT,Gravity.CENTER_VERTICAL)
	lv1.TwoLinesLayout.SecondLabel.Gravity 	= Bit.Or(Gravity.RIGHT,Gravity.CENTER_VERTICAL)
	lv1.SingleLineLayout.Label.Gravity 		= Bit.Or(Gravity.RIGHT,Gravity.CENTER_VERTICAL)
	
End Sub

Private Sub SetDivider(lv As ListView, Color As Int, Height As Int)
	Dim R As Reflector
	R.Target = lv
	Dim CD As ColorDrawable
	CD.Initialize(Color, 0)
	R.RunMethod4("setDivider", Array As Object(CD), Array As String("android.graphics.drawable.Drawable"))
	R.RunMethod2("setDividerHeight", Height, "java.lang.int")
End Sub