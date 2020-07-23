Type=Class
Version=6.5
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@

Sub Class_Globals
	Dim Ellipsize_END As String = "END"
	Dim Ellipsize_START As String = "START"
	Dim sl As StudentLibrary
End Sub

Public Sub Initialize

End Sub

'Private minDistance As Int = 150
'Private x1,x2 As Float
Sub pnlPhoto_Touch (Action As Int, X As Float, Y As Float)
  Select    Action
    Case 0
      x1 = x
    Case 1
      x2 = x
      Private deltaX = x2 - x1
      If Abs(deltaX) > minDistance Then
        If x2 > x1 Then
          ToastMessageShow("Left to right",False)
        Else
          ToastMessageShow("Right to left",False)
        End If
      End If
  End Select
End Sub

Private Sub getTextWidth(TargetView As Label,TP As Typeface,TextSize As Float) As Float
	'measure width of text
	Dim bounds As Rect
	Dim paint As Canvas
    bounds.Initialize(0,0,0,0)
    paint.InitializeNewInstance("android.graphics.Paint",Null)
        paint.RunMethod("setTextSize",Array(TextSize))
        paint.RunMethod("setTypeface",Array(TP))
        paint.RunMethod("getTextBounds",Array(TargetView.Text,0,TargetView.Text.Length,bounds))
		
		Dim r As Reflector
		r.Target=TargetView
   		r.Target = r.GetContext
   		r.Target = r.RunMethod("getResources")
    	r.Target = r.RunMethod("getDisplayMetrics")
		Return((bounds.Right - bounds.Left)* r.GetField("xdpi")/ 160)
End Sub

Private Sub getTextHeight(TargetView As Label) As Float
	Private MeasureHeightOfText As StringUtils 
	Return MeasureHeightOfText.MeasureMultilineTextHeight(TargetView,TargetView.Text)
End Sub

Private Sub getLineCount(TargetView As Object) As Int
	Dim jo As JavaObject
	jo = TargetView
	Return jo.RunMethod("getLineCount",Null)
End Sub

Sub EnableSlideMenu(smWrapper1 As slidepanel)
	Dim jo As JavaObject = smWrapper1
	jo.RunMethod("setSlidingEnabled", Array(True)) 'or false
End Sub

'add SetActivityAttribute(main, android:theme, @android:style/Theme.Translucent.NoTitleBar) to manifest for create form example viber
Sub CreateDialog(activity As Activity)
 activity.Color = Colors.Transparent
End Sub

Sub SearchableEdittext(Edittext1 As EditText)
	Dim JO As JavaObject = Edittext1
    JO.RunMethod("setImeOptions",Array As Object(3))
End Sub

Sub SetTiledBackground(v As View, b As Bitmap)
  Dim bd As BitmapDrawable
  bd.Initialize(b)

  Dim r As Reflector
  r.Target = bd
  r.RunMethod3("setTileModeXY","REPEAT", "android.graphics.Shader$TileMode", _
                        "REPEAT", "android.graphics.Shader$TileMode")
  v.Background = bd
End Sub

'get cookie of webview
Sub GetCookieWebView(URL As String) As String
Dim r As Reflector
    r.Target = r.RunStaticMethod("android.webkit.CookieManager", "getInstance", Null, Null)
    Return r.RunMethod2("getCookie", URL, "java.lang.String")
End Sub

'add border to panel
Sub BorderPanel(pnl As Panel,BorderWidth As Float, FillColor As Int, BorderColor As Int)
	Dim Rec As Rect
	Dim Canvas1 As Canvas
	Dim BorderWidth_2 As Float
	
	BorderWidth_2=BorderWidth/2
	Rec.Initialize(BorderWidth_2,BorderWidth_2,pnl.Width-BorderWidth_2,pnl.Height-BorderWidth_2)
	Canvas1.Initialize(pnl)
	Canvas1.DrawRect(Rec,FillColor,True,FillColor)
	Canvas1.DrawRect(Rec,BorderColor,False,BorderWidth)
End Sub

Sub WebViewAssetFile (FileName As String) As String
   Dim jo As JavaObject
   jo.InitializeStatic("anywheresoftware.b4a.objects.streams.File")
   If jo.GetField("virtualAssetsFolder") = Null Then
     Return "file:///android_asset/" & FileName.ToLowerCase
   Else
     Return "file://" & File.Combine(jo.GetField("virtualAssetsFolder"), _
       jo.RunMethod("getUnpackedVirtualAssetFile", Array As Object(FileName)))
   End If
End Sub


'Capture Panel To ImageView
Sub PanelCapture(pnl As Panel, Img2 As ImageView)

Dim Obj1, Obj2 As Reflector
Dim bmp As Bitmap
Dim c As Canvas
Obj1.Target = Obj1.GetActivityBA
Obj1.Target = Obj1.GetField("vg")
bmp.InitializeMutable(pnl.left + pnl.Width, pnl.Top + pnl.Height) 
c.Initialize2(bmp)
Dim args(1) As Object
Dim types(1) As String
Obj2.Target = c
Obj2.Target = Obj2.GetField("canvas")
args(0) = Obj2.Target
types(0) = "android.graphics.Canvas"
Obj1.RunMethod4("draw", args, types)

'draw from image to canavas
Dim canvas1 As Canvas
canvas1.Initialize(Img2)
Dim scrt As Rect
scrt.Initialize(pnl.left, pnl.top, pnl.left + pnl.Width, pnl.Top + pnl.Height)
Dim rectPanel1 As Rect
rectPanel1.Initialize(0, 0,Img2.Width, Img2.Height)
canvas1.DrawBitmap(bmp, scrt , rectPanel1)
Img2.Invalidate

End Sub

'get picture from res folder
'you can save pictrue in any dip
'drawable-hdpi or drawable-mdpi or drawable-xhdpi
Sub GetNPDrawable(Name As String) As Object
    Dim r As Reflector
    Dim package As String
    Dim id As Int
    package = r.GetStaticField("anywheresoftware.b4a.BA", "packageName")
    id = r.GetStaticField(package & ".R$drawable", Name)
    r.Target = r.GetContext
    r.Target = r.RunMethod("getResources")
    Return r.RunMethod2("getDrawable", id, "java.lang.int")
End Sub

'show cursor of editext
Sub setCursorVisible(edt As EditText, Visible As Boolean)
    Dim jo = edt As JavaObject
    jo.RunMethod("setCursorVisible", Array As Object(Visible))
End Sub

'set selectable for editext
Sub setTextIsSelectable(edt As EditText, Selectable As Boolean)
    Dim jo = edt As JavaObject
    jo.RunMethod("setTextIsSelectable", Array As Object(Selectable))
End Sub

'add searchable option for editext
Sub EditTextSearch(EditTxt As EditText)
    Dim AR As AndroidResources
    Dim ETxt As JavaObject = EditTxt
    ETxt.RunMethod("setCompoundDrawablesWithIntrinsicBounds",Array As Object(AR.GetAndroidDrawable("ic_menu_search"),Null,Null,Null))
End Sub

'change opacity of view
Sub setShadowLayer(lbl As View, Radius As Float, dx As Float, dy As Float, Color As Int)
    Dim jo = lbl As JavaObject
    jo.RunMethod("setShadowLayer", Array(Radius, dx, dy , Color))
End Sub

'fit label height
Sub FitLabelHeight(lbl As Label)
	Dim StrUtil As StringUtils
	Dim Obj1 As Reflector
	Dim before, after,ht As Float
	ht = StrUtil.MeasureMultilineTextHeight(lbl, lbl.Text)
	Obj1.Target = lbl 
	before = Obj1.RunMethod("getLineHeight")    'Get the height of line BEFORE you change it
	Obj1.Target = lbl
	Obj1.RunMethod3("setLineSpacing", .10, "java.lang.float", 1.2, "java.lang.float")  'Change the space between lines
	Obj1.Target = lbl 
	after = Obj1.RunMethod("getLineHeight")    'Get the height of line AFTER  you change it
	ht = ((after * ht)/before) 
	lbl.Height = ht
End Sub

'automatic set label textsize according to screen dpi
Sub SetTextSize(lbl As Label, txt As String)
  Dim dt As Float
  Dim limit = 0.5 As Float
  Dim h As Int
  Dim stu As StringUtils
  lbl.Text = txt
  lbl.TextSize = 72
  dt = lbl.TextSize
  h = stu.MeasureMultilineTextHeight(lbl, txt)
  Do While dt > limit Or h > lbl.Height
    dt = dt / 2
    h = stu.MeasureMultilineTextHeight(lbl, txt)
    If h > lbl.Height Then
      lbl.TextSize = lbl.TextSize - dt
    Else
      lbl.TextSize = lbl.TextSize + dt
    End If
  Loop
End Sub

'get device scale
Sub GetDevicePhysicalSize As Float
    Dim lv As LayoutValues
    lv = GetDeviceLayoutValues
    Return Sqrt(Power(lv.Height / lv.Scale / 160, 2) + Power(lv.Width / lv.Scale / 160, 2))
End Sub

'set shadow for view
Sub SetTextShadow(pView As View, pRadius As Float, pDx As Float, pDy As Float, pColor As Int)
   Dim ref As Reflector
   
   ref.Target = pView
   ref.RunMethod4("setShadowLayer", Array As Object(pRadius, pDx, pDy, pColor), Array As String("java.lang.float", "java.lang.float", "java.lang.float", "java.lang.int"))
End Sub

'change all view than have fontmaily properties in activity
Sub ChangeAllViewFont(act1 As Activity,sFontName As String)
For Each v As View In act1.GetAllViewsRecursive

 If v Is Label Then
  Dim l1 As Label
  l1 = v
  l1.Typeface  = Typeface.LoadFromAssets(sFontName)
 Else If v Is Button Then
  Dim b1 As Button
  b1 = v
  b1.Typeface  = Typeface.LoadFromAssets(sFontName)
 Else If v Is EditText Then
  Dim c1 As EditText
  c1 = v
  c1.Typeface  = Typeface.LoadFromAssets(sFontName)  
 End If
Next
End Sub

'set animation for activity.you must be download animation xml file from basic4android forum
Sub SetAnimation(InAnimation As String, OutAnimation As String)
    Dim r As Reflector
    Dim package As String
    Dim In, out As Int
   package = r.GetStaticField("anywheresoftware.b4a.BA", "packageName")
    In = r.GetStaticField(package & ".R$anim", InAnimation)
    out = r.GetStaticField(package & ".R$anim", OutAnimation)
    r.Target = r.GetActivity
    r.RunMethod4("overridePendingTransition", Array As Object(In, out), Array As String("java.lang.int", "java.lang.int"))
End Sub

'get parent of view
Sub GetParent(v As View) As View
   Dim r As Reflector
   r.Target = v
   Return r.RunMethod("getParent")
End Sub

'scroll srollview to postion
Private Sub ScrollTo(pos As Int,sv As ScrollView)
   'sv.ScrollTo smoothly scrolls to the position. In this case we want to immediately change the scroll position
   'so we use Reflection to call the native scrollTo method.
   Dim r As Reflector
   r.Target = sv
   r.RunMethod3("scrollTo", 0, "java.lang.int", pos, "java.lang.int")
End Sub

'Add Icon inside Edit Text
Sub AddImage2Edittext(EditText1 As EditText,bitmap1 As BitmapDrawable)
	Dim sT As String
	sT="android.graphics.drawable.Drawable"
	Dim R As Reflector
	R.Target=EditText1
	R.RunMethod4("setCompoundDrawablesWithIntrinsicBounds",Array As Object(bitmap1,Null,Null,Null),Array As String(sT,sT,sT,sT))
End Sub

'change space of line in view
Sub LabelSpace(view1 As View)
	Dim Obj1 As Reflector
	Obj1.Target = view1
	Obj1.RunMethod3("setLineSpacing", 1, "java.lang.float", 1.5, "java.lang.float")
End Sub

'set background statelist to label
Sub SetColorList (Label1 As Label, DefaultColor As Int,PressedColor As Int)
	Dim sd As StateListDrawable
	Dim clrs(2) As Int
	Dim states(2,1) As Int
	clrs(0) = DefaultColor
	clrs(1) = PressedColor
	states(0, 0) = sd.State_Pressed
	Dim r As Reflector
	Dim csl As Object
	csl = r.CreateObject2("android.content.res.ColorStateList", _
	Array As Object(states, clrs), Array As String("[[I", "[I"))
	r.Target = Label1
	r.RunMethod4("setTextColor", Array As Object(csl), _
	Array As String("android.content.res.ColorStateList"))
End Sub

'get text of selection text in edittext
Sub GetSelectionEnd(txt As EditText) As Int
	Dim r As Reflector
	r.Target = txt
	Return r.RunMethod("getSelectionEnd")
End Sub

'set margin of edittext
Sub MarginEditText(EditText1 As EditText,Left As Int,Top As Int,Right As Int,Bottom As Int)
	Dim refl As Reflector
	refl.Target= EditText1
	refl.RunMethod4("setPadding", Array As Object(Left, Top, Right, Bottom), _
	Array As String("java.lang.int", "java.lang.int", _
	"java.lang.int","java.lang.int"))
End Sub

'set opacity of view
Sub SetAlpha(Control As View, Alpha As Int)
	Dim r As Reflector
	r.Target = Control.Background
	r.RunMethod2("setAlpha", Alpha, "java.lang.int")
End Sub

'get index of view in panel
Sub PanelIndexOf(P As Panel, v As View) As Int
	For i = 0 To P.NumberOfViews - 1
	If P.GetView(i) = v Then Return i
	Next
	Return -1
End Sub

'set ellipsize of labe;
Sub SetEllipsize(TextView As Label, Mode As String)
	Dim r As Reflector
	r.Target = TextView
	r.RunMethod2("setSingleLine", True, "java.lang.boolean")
	r.RunMethod2("setEllipsize", Mode, "android.text.TextUtils$TruncateAt")
End Sub

'remove ellipsize of label
Sub RemoveEllipsize(TextView As Label)
	Dim r As Reflector
	r.Target = TextView
	r.RunMethod2("setSingleLine", False, "java.lang.boolean")
End Sub

'get orientation of screen
Sub GetOrientation As Int
	Dim r As Reflector
	r.Target = r.GetContext
	r.Target = r.RunMethod2("getSystemService", "window", "java.lang.String")
	r.Target = r.RunMethod("getDefaultDisplay")
	Return r.RunMethod("getOrientation")
End Sub

'get screenshot of view
Sub GetScreenShot(view1 As View,sPath As String) As Bitmap
Return sl.GetScreenShot(view1,sPath)
End Sub

'get screenshot with other way and save image in file
Sub GetScreenShot1(act1 As Activity,sDir As String,sFilename As String) As Bitmap
   Dim Obj1, Obj2 As Reflector
   Dim bmp As Bitmap
   Dim c As Canvas
   Dim now, i As Long
   Dim dt As String
   DateTime.DateFormat = "yyMMddHHmmss"
   now = DateTime.now
   dt = DateTime.Date(now) ' e.g.: "110812150355" is Aug.12, 2011, 3:03:55 p.m.
   Obj1.Target = Obj1.GetActivityBA
   Obj1.Target = Obj1.GetField("vg")
   bmp.InitializeMutable(act1.Width, act1.Height)
   c.Initialize2(bmp)
   Dim args(1) As Object
   Dim types(1) As String
   Obj2.Target = c
   Obj2.Target = Obj2.GetField("canvas")
   args(0) = Obj2.Target
   types(0) = "android.graphics.Canvas"
   Obj1.RunMethod4("draw", args, types)
   Dim Out As OutputStream
   Out = File.OpenOutput(sDir, sFilename, False)
   bmp.WriteToStream(Out, 100, "PNG")
   Out.Close
End Sub

'turn on flashlight of camera
Sub TurnOnFlashLight
sl.TurnOnFlashLight
End Sub


'set space line of edittext
Sub SetHeightTextFont(sText As EditText)
   Dim r As Reflector
   r.Target = sText
   r.RunMethod3("setLineSpacing", 1, "java.lang.float", 1.3, "java.lang.float")  
End Sub

'add menu to activity
Sub AddMenu(activity1 As Activity,sTitle As String,sIcon As Bitmap,sEventName As String)
activity1.AddMenuItem3(sTitle,sEventName,sIcon,True)
End Sub



'conver label to link
Sub ConvertLabel2Link(Label1 As Label,Text As String)
	Dim Obj1 As Reflector
	Label1.Text = Text
	Obj1.Target = Obj1.CreateObject("android.text.util.Linkify")
	Dim args(2) As Object
	Dim types(2) As String 
	args(0) = Label1
	types(0) = "android.widget.TextView"
	args(1) = 15
	types(1) = "java.lang.int" 
	Obj1.RunMethod4("addLinks", args, types)
End Sub

'set style to porgressbar
Sub SetProgressDrawable(p As ProgressBar, drawable As Object, backgroundDrawable As Object)
	Dim r As Reflector
	Dim clipDrawable As Object
	clipDrawable = r.CreateObject2("android.graphics.drawable.ClipDrawable", _
      Array As Object(drawable, Gravity.LEFT, 1), _
      Array As String("android.graphics.drawable.Drawable", "java.lang.int", "java.lang.int"))
	r.Target = p
	r.Target = r.RunMethod("getProgressDrawable") 'Gets the layerDrawable
	r.RunMethod4("setDrawableByLayerId", _
      Array As Object(16908288, backgroundDrawable), _
      Array As String("java.lang.int", "android.graphics.drawable.Drawable"))
	r.RunMethod4("setDrawableByLayerId", _
      Array As Object(r.GetStaticField("android.R$id", "progress"), clipDrawable), _
      Array As String("java.lang.int", "android.graphics.drawable.Drawable"))
End Sub



'get argb of color
Sub GetARGB(Color As Int) As Int()
	Dim res(4) As Int
	res(0) = Bit.UnsignedShiftRight(Bit.And(Color, 0xff000000), 24)
	res(1) = Bit.UnsignedShiftRight(Bit.And(Color, 0xff0000), 16)
	res(2) = Bit.UnsignedShiftRight(Bit.And(Color, 0xff00), 8)
	res(3) = Bit.And(Color, 0xff)
	Return res
End Sub

'set press state for button
Sub SetPressed(cmd As Button, Pressed As Boolean)
	Dim ref As Reflector
	ref.Target = cmd
	ref.RunMethod2("setPressed", Pressed, "java.lang.boolean")
End Sub

Sub DisableClickableEdittext(cmd As Button, Pressed As Boolean)
	Dim ref As Reflector
	ref.Target = cmd
	ref.RunMethod2("setPressed", Pressed, "java.lang.boolean")
End Sub

'perform spinner to open list without click on spinner
Sub OpenSpinner(S As Spinner)
   Dim r As Reflector
   r.Target = S
   r.RunMethod("performClick")
End Sub

Sub CenterView(v As View, parent As View)
    v.Left = parent.Width / 2 - v.Width / 2
    v.Top = parent.Height / 2 - v.Height / 2
End Sub

#End Region