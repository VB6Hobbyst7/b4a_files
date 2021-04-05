B4A=true
Group=Libraries
ModulesStructureVersion=1
Type=StaticCode
Version=7.8
@EndOfDesignText@
#IgnoreWarnings: 10,9,34,19,12,2
'Libraries: IME,JavaObject,Phone,Reflecation,StringUtils

Sub Process_Globals

End Sub

Sub CenterView(v As View, parent As View)
	v.Left = parent.Width / 2 - v.Width / 2
	v.Top = parent.Height / 2 - v.Height / 2
End Sub

Sub CenterViewTop(v As View, parent As View)
	v.Top = parent.Height / 2 - v.Height / 2
End Sub

Sub CenterViewLeft(v As View, parent As View)
	v.Left = parent.Width / 2 - v.Width / 2
End Sub

Sub SetBorder(Panel As Panel,Radius As Int,BorderWidth As Int,BorderColor As Int)
	
	Dim cd As ColorDrawable
	cd.Initialize2(Colors.Transparent,Radius,BorderWidth,BorderColor)
	Panel.Background	=	cd
	
End Sub

Sub ChangeFont(Panel As Panel,FontName As String)
	
End Sub

'0:Done | 1:Enter | 2:Go | 3:Search | 4:Send | 5:Next
Sub SetKeyboardIMEOption(EditText As Object,  Action As Int)
	Dim jo = EditText As JavaObject
	jo.RunMethod("setImeOptions",Array(Action))
End Sub

Sub SetElevation(v As View, e As Float)
	Dim jo As JavaObject
	Dim p As Phone
   
	If p.SdkVersion >= 21 Then
		jo = v
		jo.RunMethod("setElevation", Array As Object(e))
	End If
End Sub

'sample:
'slide from left to right
'<code>Views.SetAnimation("slide_in_left","slide_out_right")</code>
'
'add animation files into project
'<code>#AdditionalRes: ../animation</code>
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

Sub SetAnimation2(Animation As String)
	
	Dim r As Reflector
	Dim package As String
	Dim In As Int
	
	package = r.GetStaticField("anywheresoftware.b4a.BA", "packageName")
	In = r.GetStaticField(package & ".R$anim", Animation)
	r.Target = r.GetActivity
	r.RunMethod4("overridePendingTransition", Array As Object(In, 0), Array As String("java.lang.int", "java.lang.int"))
	
End Sub

Sub ChangePadding(View As View,Left As Int,Top As Int,Right As Int,Bottom As Int)
	Dim refl As Reflector
	refl.Target=View
	refl.RunMethod4("setPadding", Array As Object(Left, Top, Right, Bottom), _
	    Array As String("java.lang.int", "java.lang.int", "java.lang.int","java.lang.int"))
End Sub

Sub ChangeStatusColor(Color As Int)
	
	Dim jObj As JavaObject
	jObj.InitializeContext
	
	Dim ph As Phone
	If ph.SdkVersion >= 21 Then
		Dim window As JavaObject = jObj.RunMethodJO("getWindow", Null)
		window.RunMethod("addFlags", Array (0x80000000))
		window.RunMethod("clearFlags", Array (0x04000000))
		window.RunMethod("setStatusBarColor", Array(Color))
	End If
		
End Sub

Sub SetPanelRadii(p As Panel,bgColor1 As Int, bgColor2 As Int,radii() As Float)
	Dim jo3 As JavaObject
	jo3.InitializeContext
	jo3.RunMethod("setPanelRadii",Array(p,bgColor1,bgColor2,radii))
End Sub

'hide scrollview or listview scrollbar
Sub HideScroll(sv As View)
	Dim r As Reflector
	r.Target = sv
	r.RunMethod2("setVerticalScrollBarEnabled", False, "java.lang.boolean")
	r.RunMethod2("setHorizontalScrollBarEnabled", False, "java.lang.boolean")
End Sub

Sub ForseRtlSupported
	Dim j,jo As JavaObject
	jo.InitializeStatic  ("android.view.View")
	If j.InitializeStatic  ("android.os.Build$VERSION").GetField ("SDK_INT") > 16 Then
		j.InitializeContext.RunMethodJO("getWindow",Null).RunMethodJO("getDecorView",Null) _
.RunMethod ("setLayoutDirection",Array(jo.GetField ("LAYOUT_DIRECTION_RTL")))
	End If
End Sub

Sub SetVisibleAnimated(View As View,Duration As Int,Visible As Boolean)
	View.SetVisibleAnimated(Duration,Visible)
End Sub

Sub LoadNinePatchDrawable(ImageName As String) As Object
	'Gets a 9-patch drawable from the application resources
	Dim r As Reflector
	Dim package As String
	package = r.GetStaticField("anywheresoftware.b4a.BA", "packageName")
	Dim ID_Drawable As Int
	ID_Drawable = r.GetStaticField(package & ".R$drawable", ImageName)
	r.Target = r.GetContext
	r.Target = r.RunMethod("getResources")
	Return r.RunMethod2("getDrawable", ID_Drawable, "java.lang.int")
End Sub

'change space of line in view
Sub LabelSpace(view1 As View,Space As Float)
	Dim Obj1 As Reflector
	Obj1.Target = view1
	Obj1.RunMethod3("setLineSpacing", 1, "java.lang.float", Space, "java.lang.float")
End Sub

Sub SetColorTintList(CB As View,Checked As Int,Enabled As Int,Disabled As Int)

	Dim sdk As Phone
	If sdk.SdkVersion < 21 Then Return
	
	Dim States(3,1) As Int

	States(0,0) = 16842912   'Checked
	States(1,0) = 16842910    'Enabled
	States(2,0) = -16842910 'Disabled

	Dim Color(3) As Int = Array As Int(Checked,Enabled,Disabled)

	Dim CSL As JavaObject
	CSL.InitializeNewInstance("android.content.res.ColorStateList",Array As Object(States,Color))
	Dim CB1 As JavaObject = CB
	CB1.RunMethod("setButtonTintList",Array As Object(CSL))

End Sub

Sub SetMaximumProgressbar(Pb As ProgressBar,Value As Int)
	Dim CB1 As JavaObject = Pb
	CB1.RunMethod("setMax",Array(Value))
End Sub

Sub RemoveShadow(Button1 As Button)
	Try
		Dim sdk As Phone
		If sdk.SdkVersion < 21 Then Return
		Dim jo As Reflector
		jo.Target = Button1
		Sleep(0)
		jo.RunMethod4("setElevation", Array As Object(0),Array As String("java.lang.float"))
	Catch
	End Try
End Sub

Sub SetTextShadow(pView As View, pRadius As Float, pDx As Float, pDy As Float, pColor As Int)
	
	Dim ref As Reflector
	ref.Target = pView
	ref.RunMethod4("setShadowLayer", Array As Object(pRadius, pDx, pDy, pColor), Array As String("java.lang.float", "java.lang.float", "java.lang.float", "java.lang.int"))
	
End Sub

Sub ShowKeyboard(View1 As View)
	Sleep(20)
	Dim ime As IME
	ime.Initialize("")
	ime.ShowKeyboard(View1)
End Sub

Sub HideKeyboard(Object_ As Object)
	Dim ime As IME
	ime.Initialize("")
	ime.HideKeyboard
End Sub

Sub InputModeEmail(Edittext1 As EditText)
	Edittext1.InputType = 33
End Sub

Sub DisableAutoSuggest(Edittext1 As EditText)
	Dim j As JavaObject
	j.InitializeContext
	j = Edittext1
	j.RunMethod("setInputType",Array(524288))
End Sub

Sub LimitEdittextLenght(Limit As Int,EditText1 As EditText)
	Dim ime As IME
	ime.Initialize("")
	ime.SetLengthFilter(EditText1,Limit)
End Sub

Sub LimitEdittextNumbers(EditText1 As EditText)
	Dim ime As IME
	ime.Initialize("")
	ime.SetCustomFilter(EditText1,EditText1.INPUT_TYPE_PHONE,"0123456789")
End Sub

Sub ChangeProgressColor(ProgressBar1 As ProgressBar,Color As Int)
	
	Dim jo As JavaObject = ProgressBar1
	jo = jo.RunMethod("getIndeterminateDrawable", Null)
	jo.RunMethod("setColorFilter", Array (Color , "MULTIPLY"))
	
End Sub

Sub SetBackgroundFromResource(View1 As View,Name As String)
	
	Dim r As Reflector
	Dim package As String
	Dim id As Int
	package = r.GetStaticField("anywheresoftware.b4a.BA", "packageName")
	id = r.GetStaticField(package & ".R$drawable", Name)
	r.Target = r.GetContext
	r.Target = r.RunMethod("getResources")
	View1.Background	=	 r.RunMethod2("getDrawable", id, "java.lang.int")

End Sub

Sub ChangeScrollbarState(ScrollView1 As View,State As Boolean)
	Dim r As Reflector
	r.Target = ScrollView1
	r.RunMethod2("setVerticalScrollBarEnabled", State, "java.lang.boolean")
	r.RunMethod2("setHorizontalScrollBarEnabled", State, "java.lang.boolean")
End Sub

public Sub SetButtonStateList(Btn As Button, cdPressed As ColorDrawable, cdEnabled As ColorDrawable, cdDisabled As ColorDrawable)
	Dim sld As StateListDrawable
	sld.Initialize
	sld.AddState(sld.State_Pressed, cdPressed)
	sld.AddState(sld.State_Enabled, cdEnabled)
	sld.AddState(sld.State_Disabled, cdDisabled)

	Btn.Background = sld
End Sub

'p can be Progressbar or Seekbar
Sub SetProgressDrawable(p As View, drawable As Object, backgroundDrawable As Object)
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

Public Sub CloseActivities
	Dim jo As JavaObject
	jo.InitializeContext
	jo.RunMethod("finishAffinity", Null)
End Sub

Sub GetLabelHeight(Label As Label) As Int
	Dim su As StringUtils
	Return su.MeasureMultilineTextHeight(Label,Label.Text)	
End Sub

Sub SearchableEdittext(Edittext1 As EditText)
	Dim JO As JavaObject = Edittext1
	JO.RunMethod("setImeOptions",Array As Object(3))
End Sub

Sub ChangeScrolling(sv As ScrollView,State As Boolean)
   Dim r As Reflector
   r.Target = sv
	r.RunMethod4("requestDisallowInterceptTouchEvent", Array As Object(State), Array As String("java.lang.boolean"))
End Sub

Sub ShowCustomToast(Text As Object, LongDuration As Boolean,X As Int,Y As Int,Background As ColorDrawable)
	Dim ctxt As JavaObject
	ctxt.InitializeContext
	Dim duration As Int
	If LongDuration Then duration = 1 Else duration = 0
	Dim toast As JavaObject
	toast = toast.InitializeStatic("android.widget.Toast").RunMethod("makeText", Array(ctxt, Text, duration))
	Dim v As View = toast.RunMethod("getView", Null)
	v.Background = Background
	v.Padding	=	Array As Int(8dip,8dip,8dip,8dip)
	v.Width	=	900dip
	'uncomment to show toast in the center:
	toast.RunMethod("setGravity", Array(Bit.Or(Gravity.CENTER_HORIZONTAL, Gravity.BOTTOM), x, y))
	toast.RunMethod("show", Null)
End Sub

'use <code>#AdditionalJar: com.android.support:support-compat</code>
Sub SetBackgroundTintList(View As View,Active As Int, Enabled As Int)
	Dim States(2,1) As Int
	States(0,0) = 16842908     'Active
	States(1,0) = 16842910    'Enabled
	Dim Color(2) As Int = Array As Int(Active,Enabled)
	Dim CSL As JavaObject
	CSL.InitializeNewInstance("android.content.res.ColorStateList",Array As Object(States,Color))
	Dim jo As JavaObject
	jo.InitializeStatic("android.support.v4.view.ViewCompat")
	jo.RunMethod("setBackgroundTintList", Array(View, CSL))
End Sub

Sub SetScrollbarColor(sv As ScrollView, clr As Int)
	Dim r As Reflector
	r.Target = sv
	r.Target = r.GetField("mScrollCache")
	r.Target = r.GetField("scrollBar")
	Dim cd As ColorDrawable
	cd.Initialize(clr, 5dip)
	r.RunMethod4("setVerticalThumbDrawable", Array(cd), Array As String("android.graphics.drawable.Drawable"))
End Sub

Public Sub AnimateBorder(View As View)
	Dim n As Long = DateTime.Now
	Dim duration As Int = 500
	Dim start As Float = 0
	Dim tempValue As Float
	Dim cvs As Canvas
	cvs.Initialize(View)
	cvs.DrawColor(Colors.Transparent)
	Do While DateTime.Now < n + duration
		tempValue = ValueFromTimeLinear(DateTime.Now - n, start, 100 - start, duration)
		DrawValue(View, cvs, tempValue)
		Sleep(10)
	Loop
	DrawValue(View, cvs, 100)
End Sub

Private Sub DrawValue(View As View, cvs As Canvas, Value As Float)
	Dim clr As Int = Colors.White
	Dim strokewidth As Int = 4dip
	Dim cx = View.Width / 2 As Float
	Dim width As Float = View.Width / 50 * Min(50, Value)
	cvs.DrawLine(cx - width / 2, 0, cx + width / 2, 0, clr, strokewidth)
	cvs.DrawLine(cx - width / 2, View.Height, cx + width / 2, View.Height, clr, strokewidth)
	If Value > 50 Then
		Dim height As Float = View.Height / 50 * (Value - 50)
		cvs.DrawLine(0, 0, 0, height / 2, clr, strokewidth)
		cvs.DrawLine(0, View.Height, 0,  View.Height - height / 2, clr, strokewidth)
		cvs.DrawLine(View.Width, 0, View.Width, height / 2, clr, strokewidth)
		cvs.DrawLine(View.Width, View.Height, View.Width, View.Height - height / 2, clr, strokewidth)
	End If
	View.Invalidate
End Sub

Private Sub ValueFromTimeLinear(Time As Int, Start As Float, ChangeInValue As Float, Duration As Int) As Float 'ignore
	Return ChangeInValue * Time / Duration + Start
End Sub

Sub SelectItemSpinner(Sp As Spinner,Item As String)
	
	For i = 0 To Sp.Size - 1
		Dim Items As String
		Items	=	Sp.GetItem(i).ToLowerCase.Trim
		If Items = Item.ToLowerCase Then
			Sp.SelectedIndex = i	
		End If
	Next
	
End Sub

Sub GetTop(View As View) As Int
	Return View.Top
End Sub

Sub ForceNumberKeyboard(Edittext As EditText)
	
	Dim ime As IME
	ime.Initialize("")
	ime.SetCustomFilter(Edittext,Edittext.INPUT_TYPE_PHONE,"0123456789")
	
End Sub

Sub SetSingleLine(View2 As View)
	Dim mylblJO As JavaObject = View2
	mylblJO.RunMethod("setSingleLine",Array(True))
End Sub

Sub GetParent(View2 As View) As View
	Return View2.Parent
End Sub

Sub RotateView(v As View, Degrees As Float)
	Dim jo As JavaObject = v
	jo.RunMethod("setRotation", Array(Degrees))
End Sub

Sub GetActivityShot(act1 As Activity,sDir As String,sFilename As String) As Bitmap
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

Sub GetRelativeTop(V As JavaObject) As Int
	'I tried several methods to do this, this was the only one that worked across API's and devices
  
	'One of these will always be the last parent
	If GetType(V) = "android.view.ViewRoot" Or GetType(V) = "android.view.ViewRootImpl" Then
		Return 0
	Else
		'If V.Top is valid for this view returns a value then add it, else skip to the next parent
		Try
			Dim VW As View = V
			Return VW.Top + GetRelativeTop(V.RunMethod("getParent",Null))
		Catch
			Return GetRelativeTop(V.RunMethod("getParent",Null))
		End Try
	End If
End Sub

'Iterative sub to get the views Left relative to the activity window
Sub GetRelativeLeft(V As JavaObject) As Int
	'I tried several methods to do this, this was the only one that worked across API's and devices
  
	'One of these will always be the last parent
	If GetType(V) = "android.view.ViewRoot" Or GetType(V) = "android.view.ViewRootImpl" Then
		Return 0
	Else
		'If V.Left is valid for this view returns a value then add it, else skip to the next parent
		Try
			Dim VW As View = V
			Return VW.Left + GetRelativeLeft(V.RunMethod("getParent",Null))
		Catch
			Return GetRelativeLeft(V.RunMethod("getParent",Null))
		End Try
	End If
End Sub

Sub PanelIndexOf(p As Panel, v As View) As Int
	For i = 0 To p.NumberOfViews - 1
		If p.GetView(i) = v Then Return i
	Next
	Return -1
End Sub

Sub CapturePanel(pnl As Panel) As Bitmap

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

	Dim Img2 As ImageView
	Img2.Initialize("")
	Img2.Visible	=	False
	pnl.AddView(Img2,0,0,pnl.Width,pnl.Height)
	
	'draw from image to canavas
	Dim canvas1 As Canvas
	canvas1.Initialize(Img2)
	Dim scrt As Rect
	scrt.Initialize(pnl.left, pnl.top, pnl.left + pnl.Width, pnl.Top + pnl.Height)
	Dim rectPanel1 As Rect
	rectPanel1.Initialize(0, 0,Img2.Width, Img2.Height)
	canvas1.DrawBitmap(bmp, scrt , rectPanel1)
	Img2.Invalidate
	
	Dim b As Bitmap
	b = Img2.Bitmap
	Img2.RemoveView
	
	Return b
	
End Sub

Sub SetAlpha(Control As View, Alpha As Int) 
    Dim r As Reflector 
    r.Target = Control.Background 
    r.RunMethod2("setAlpha", Alpha, "java.lang.int") 
End Sub

Sub SetDivider(lv As ListView, Color As Int, Height As Int)
	Dim R As Reflector
	R.Target = lv
	Dim CD As ColorDrawable
	CD.Initialize(Color, 0)
	R.RunMethod4("setDivider", Array As Object(CD), Array As String("android.graphics.drawable.Drawable"))
	R.RunMethod2("setDividerHeight", Height, "java.lang.int")
End Sub

Sub SetScale(View1 As View,PivotX As Float,PivotY As Float,ScaleX As Float,ScaleY As Float)
  Dim jo As JavaObject = View1
  jo.RunMethod("setPivotX",Array(PivotX))
  jo.RunMethod("setPivotY",Array(PivotY))
  jo.RunMethod("setScaleX",Array(ScaleX))
  jo.RunMethod("setScaleY",Array(ScaleY))
End Sub

Sub ForceLTRSupported(View As View,RTL As Boolean)
	
	Dim jA,jos As JavaObject
	jos.InitializeStatic  ("android.view.View")
	If jA.InitializeStatic  ("android.os.Build$VERSION").GetField ("SDK_INT") > 16 Then
		jA = View
		If RTL = False Then
				jA.RunMethod ("setLayoutDirection",Array(jos.GetField ("LAYOUT_DIRECTION_LTR")))
			Else
				jA.RunMethod ("setLayoutDirection",Array(jos.GetField ("LAYOUT_DIRECTION_RTL")))
		End If
	End If
	
End Sub

'change view's scale according to dip
Sub ScaleView(v As View, rate As Double) 
    Dim delta, scaleRate As Double 
    delta = (100%x + 100%y) / ((320 + 430) * 100dip / 100) - 1 
    scaleRate = 1 + rate * delta 
    v.SetLayout(v.Left * scaleRate, v.Top * scaleRate, v.Width * scaleRate, v.Height * scaleRate) 
    If v Is Label Then 'this will catch ALL views with text (EditText, Button, ...) 
        Dim lbl As Label = v 
        lbl.TextSize = lbl.TextSize * scaleRate 
    End If 
End Sub

'Returns the root view of the given view, it's mainly the Activity
Sub getRootView(v As View) As View
    Dim jo = v As JavaObject
    Return jo.RunMethod("getRootView", Null)
End Sub

Sub SetTextIsSelectable(edt As EditText, Selectable As Boolean)
    Dim jo = edt As JavaObject
    jo.RunMethod("setTextIsSelectable", Array As Object(Selectable))
End Sub

'example
'<code>
'Dim header as Map
'header.Initialize
'header.Put("User-Agent","Mozilla/5.0 (Windows; U; Windows NT 6.1; zh_CN) AppleWebKit/534.7 (KHTML, like Gecko) Chrome/7.0 baidubrowser/1.x Safari/534.7")
Sub LoadUrlWithHeader(WebView2 As WebView, Link As String, Headers As Map)
	Dim r As Reflector
	r.Target = WebView2
	r.RunMethod4("loadUrl", Array As Object(Link, Headers), _
     Array As String("java.lang.String", "java.util.Map"))
End Sub

Sub SetStateListView(View1 As ListView,NormalColor As ColorDrawable,PressColor As ColorDrawable,SelectedColor As ColorDrawable)
	Dim SLD As StateListDrawable
	SLD.Initialize
	SLD.AddState(SLD.State_Selected,SelectedColor)
	SLD.AddState(SLD.State_Pressed,PressColor )
	SLD.AddState(-SLD.State_Pressed,NormalColor )
	Dim LVO As JavaObject = View1
	LVO.RunMethod("setSelector",Array As Object(SLD))
End Sub

Sub SetStateListView2(View1 As ListView,NormalColor As Int,PressColor As Int,SelectedColor As Int)
	Dim NormalColor2,PressColor2,SelectedColor2 As ColorDrawable
	NormalColor2.Initialize(NormalColor,0)
	PressColor2.Initialize(PressColor,0)
	SelectedColor2.Initialize(SelectedColor,0)
	Dim SLD As StateListDrawable
	SLD.Initialize
	SLD.AddState(SLD.State_Selected,SelectedColor2)
	SLD.AddState(SLD.State_Pressed,PressColor2)
	SLD.AddState(-SLD.State_Pressed,NormalColor2)
	Dim LVO As JavaObject = View1
	LVO.RunMethod("setSelector",Array As Object(SLD))
End Sub

' 0 = OVER_SCROLL_ALWAYS, 1 = OVER_SCROLL_IF_CONTENT_SCROLLS, 2 = OVER_SCROLL_NEVER
'send 2 for disable fade of scroll
Sub ChangeFadeScrollView(sv As ScrollView,State As Int)
	
	Dim r As Reflector
	r.Target = sv
	r.RunMethod2("setOverScrollMode", State, "java.lang.int" )
	
End Sub

'Sets the Ellipsizing of a TextView (Label, EditText)
'	original text 'This is a test text'
' Mode can be
'"START"		... This is a te
'"MIDDLE"		This is ... text
'"END"			This is a tes...
'"MARQUEE		This is a test t   scrolling text
Sub setEllipsize(TextView As View, Mode As String)
	Dim r As Reflector
	r.Target = TextView
	If Mode = "MARQUEE" Then
		r.RunMethod2("setHorizontallyScrolling", True, "java.lang.boolean")
	End If
	r.RunMethod2("setSelected", True, "java.lang.boolean")
	r.RunMethod2("setEllipsize", Mode, "android.text.TextUtils$TruncateAt")
End Sub

'Limits the line number to the given value
Sub setLines(TextView As View, LineNumber As Int)
	Dim jo = TextView As JavaObject
	jo.RunMethod("setLines", Array As Object(LineNumber))
End Sub

Sub setMultiLine(TextView As Label)
	Dim jo = TextView As JavaObject
	jo.RunMethod("setMultilines", Array As Object(True))
End Sub

Sub getLineCount(TargetView As Object) As Int
	Dim source = TargetView As JavaObject
	Return source.RunMethod("getLineCount", Null)
End Sub

Sub ChangeViewsEnable(Panel As Panel,State As Boolean)
	
	For Each v1 As View In Panel.GetAllViewsRecursive
		v1.Enabled = State
	Next
	
End Sub

'#AdditionalJar: com.android.support:support-compat
Sub SetSwitchTintColors (Switch As Object, OnColor As Int, OffColor As Int)
	Dim p As Phone
	If p.SdkVersion < 16 Then Return
	Dim DrawableCompat As JavaObject
	DrawableCompat.InitializeStatic("android.support.v4.graphics.drawable.DrawableCompat")
	Dim jo As JavaObject = Switch
	DrawableCompat.RunMethod("setTintList", Array(jo.RunMethod("getThumbDrawable", Null), CreateColorStateList(OnColor, OffColor)))
End Sub

'Based on: https://www.b4x.com/android/forum/threads/colorstatelist.40788/#content
Private Sub CreateColorStateList(On As Int,Off As Int) As Object
	Dim sd As StateListDrawable 'ignore
	Dim States(2,1) As Int
	States(0,0) = sd.State_Checked
	States(1,0) = sd.State_Enabled
	Dim CSL As JavaObject
	CSL.InitializeNewInstance("android.content.res.ColorStateList",Array(States, Array As Int(On, Off)))
	Return CSL
End Sub

Sub GetSimCardCountry As String
	Dim r As Reflector
	r.Target = r.GetContext
	r.Target = r.RunMethod2("getSystemService", "phone", "java.lang.String")
	Return r.RunMethod("getSimCountryIso")
End Sub

'Sets the ScrollBar style
'    SCROLLBARS_INSIDE_OVERLAY    = 0 (0x00000000)
'    SCROLLBARS_INSIDE_INSET          = 16777216 (0x01000000)
'    SCROLLBARS_OUTSIDE_INSET        = 50331648 (0x03000000)
'    SCROLLBARS_OUTSIDE_OVERLAY  = 33554432 (0x02000000)
Sub setScrollBarStyle(v As View, Style As Int)
	Dim jo = v As JavaObject
	jo.RunMethod("setScrollBarStyle", Array As Object (Style))
End Sub

'Note: use before set text to label
'For the given text view (e.g. label), turn on its "linkify" feature (auto-converts text to clickable links).
'After that, you can set the view's text property to the actual text, and the auto-linking will be done.
'Mask determines which types of text to look for:
'1 = web addresses only
'2 = email addresses only
'4 = phone numbers only
'8 = map addresses only (only works for addresses in USA - see Android's "findAddress" docs)
'15 = all (phone numbers, email addresses, web addresses, map addresses)
'You can combine two settings using bit.or (e.g. for web and email, use bit.or(1, 2))
Sub LinkifyTextView(textViewArg As View, maskArg As Int,LinksColor As Int)
	Dim r As Reflector
	r.Target = textViewArg
	r.RunMethod2("setAutoLinkMask", maskArg, "java.lang.int")
	r.RunMethod2("setLinkTextColor", LinksColor, "java.lang.int")
End Sub

'<code>#AdditionalJar: com.android.support:support-compat</code>
Sub SetAutoSizeBasedOnText(v As View)
	Dim jo As JavaObject
	jo.InitializeStatic("android.support.v4.widget.TextViewCompat")
	jo.RunMethod("setAutoSizeTextTypeWithDefaults", Array(v, 1))
End Sub

Sub ChangePanelViewsVisible(Panel As Panel,Status As Boolean)
	
	For Each v1 As View In Panel.GetAllViewsRecursive
		v1.Visible	=	Status
	Next
	
End Sub

Sub LoadTypefaceFromPath(path As String) As Typeface
	Dim typJo As JavaObject
	typJo.InitializeStatic("android.graphics.Typeface")
	Return typJo.RunMethod("createFromFile",Array(path))
End Sub

Public Sub GetTextWidth(Label As Label) As Float
	Private cvs As Canvas
	Dim bmp As Bitmap
	bmp.InitializeMutable(1,1) 'ignore
	cvs.Initialize2(bmp)
	Return cvs.MeasureStringWidth(Label.Text, Label.Typeface, Label.TextSize)
End Sub

#if tooltip
'Direction:
'0 => gravityTop
'1 => gravityBottom
'2 => gravityEnd
'3 => gravityStart
'
'Style contain : font,size,bgcolor,textcolor
Sub ShowTooltip(Font As Typeface,BackgroundColor As Int,TextColor As Int,Body As String,View As View,Direction As Int)

	Dim c As ColorDrawable
	c.Initialize2(BackgroundColor,20dip,0,0)
	
	Dim lb As Label
	lb.Initialize("")
	lb.Text			=	Body
	lb.Background	=	c
	lb.TextColor	=	TextColor
	lb.TextSize		=	12
	lb.Typeface		=	Font
	
	Dim tt As SimpleTooltipBuilder
	tt.Initialize("STT")
	tt.animated(True).animationDuration(500).arrowHeight(7dip)
	tt.backgroundColor(BackgroundColor).transparentOverlay(True)
	tt.contentView(lb)
	
	tt.arrowColor(BackgroundColor).dismissOnInsideTouch(True).dismissOnOutsideTouch(True)
	tt.modal(True).textColor(TextColor).text(Body).anchorView(View)

	If Direction = 0 Then
		tt.gravityTop
	Else if Direction = 1 Then
		tt.gravityBottom
	Else if Direction = 2 Then
		tt.gravityEnd
	Else if Direction = 3 Then
		tt.gravityStart
	End If
	
	tt.build
	tt.show
	
End Sub
#End If

#if richstring
Sub CreateSpinnerItem(Text As String,Font As Typeface,Size As Int,Color As Int) As RichString
	
	Dim rs As RichString
	rs.Initialize(Text)
	rs.TypefaceCustom(Font,0,rs.Length)
	rs.RelativeSize(Size/10,0,rs.Length)
	rs.Color(Color,0,rs.Length)
	
	Return rs
	
End Sub
#end if

'theme:
'0 is colorPrimary
'1 is colorPrimaryDark
'2 is colorAccent
Sub GetThemeColor(Theme As Int) As Int
	
	Dim name As String
	If Theme = 0 Then
		name = "colorPrimary"
	Else If Theme = 1 Then
		name = "colorPrimaryDark"
	Else if Theme = 2 Then
		name = "colorAccent"
	End If
		
	Dim app As AppCompat
	Return app.GetThemeAttribute(name)
	
End Sub

Sub Msgbox3(Message As String,Title As String,Fontname As String)
	
	Dim TitleCS As CSBuilder
	TitleCS.Initialize
	TitleCS.Size(13).Color(Colors.Black).Typeface(Typeface.LoadFromAssets(Fontname)).Append(Title).PopAll
	
	Dim MessageCS As CSBuilder
	MessageCS.Initialize
	MessageCS.Size(13).Color(Colors.Black).Typeface(Typeface.LoadFromAssets(Fontname)).Append(Message).PopAll
	
	Msgbox2(MessageCS,TitleCS,"باشه","","",Application.Icon.Resize(30dip,30dip,True))
	
End Sub

Sub OpenSpinner(Spinner As Spinner)
	Dim r As Reflector
	r.Target = Spinner
	r.RunMethod("performClick")
End Sub

Sub CreateCSBuilder(Text As String,Typefaces As Typeface,Color As Int,Size As Int) As CSBuilder
	
	Dim cs As CSBuilder
	cs.Initialize
	cs.Typeface(Typefaces).Color(Color).Alignment("ALIGN_NORMAL").Size(Size).Append(Text).Pop
	Return cs.PopAll
	
End Sub

'use below code in relate activity
'<code>
'#If JAVA
'import android.view.View;
'import android.view.MotionEvent;
'import android.widget.ScrollView;
'
'public void makeMyScrollSmart(View myScroll) {
'    myScroll.setOnTouchListener(new View.OnTouchListener() {
'        @Override
'        public boolean onTouch(View __v, MotionEvent __event) {
'            if (__event.getAction() == MotionEvent.ACTION_DOWN) {
'                //  Disallow the touch request for parent scroll on touch of child view
'                requestDisallowParentInterceptTouchEvent(__v, true);
'            } else if (__event.getAction() == MotionEvent.ACTION_UP || __event.getAction() == MotionEvent.ACTION_CANCEL) {
'                // Re-allows parent events
'                requestDisallowParentInterceptTouchEvent(__v, false);
'            }
'            return false;
'        }
'    });
'}
'
'private void requestDisallowParentInterceptTouchEvent(View __v, Boolean __disallowIntercept) {
'    while (__v.getParent() != null && __v.getParent() instanceof View) {
'        if (__v.getParent() instanceof ScrollView) {
'            __v.getParent().requestDisallowInterceptTouchEvent(__disallowIntercept);
'        }
'        __v = (View) __v.getParent();
'    }
'}
'#End If
'</code>
Sub EnableScrollInScrollview(Sv As ScrollView)
	
	Private java_object As JavaObject
	java_object.InitializeContext
	
	Dim java_view As View
	java_view = Sv
	java_object.RunMethod("makeMyScrollSmart", Array(java_view))

End Sub