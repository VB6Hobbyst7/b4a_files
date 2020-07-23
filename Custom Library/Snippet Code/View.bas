Type=Class
Version=3.15
@EndOfDesignText@

Sub Class_Globals
Dim Ellipsize_END As String = "END"
Dim Ellipsize_START As String = "START"
End Sub

Public Sub Initialize

End Sub

'change all view font
Sub changeAllViewFont(act1 As Activity,sFontName As String)
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

'Add Icon inside Edit Text
Sub addImage2Edittext(EditText1 As EditText,bitmap1 As BitmapDrawable)
Dim sT As String
sT="android.graphics.drawable.Drawable"
Dim R As Reflector
R.Target=EditText1
R.RunMethod4("setCompoundDrawablesWithIntrinsicBounds",Array As Object(bitmap1,Null,Null,Null),Array As String(sT,sT,sT,sT))
End Sub

Sub LabelSpace(view1 As View)
Dim Obj1 As Reflector
Obj1.Target = view1
Obj1.RunMethod3("setLineSpacing", 1, "java.lang.float", 2, "java.lang.float")
End Sub

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

Sub GetSelectionEnd(txt As EditText) As Int
Dim r As Reflector
r.Target = txt
Return r.RunMethod("getSelectionEnd")
End Sub

Sub MarginEditText(EditText1 As EditText,Left As Int,Top As Int,Right As Int,Bottom As Int)
Dim refl As Reflector
refl.Target= EditText1
refl.RunMethod4("setPadding", Array As Object(Left, Top, Right, Bottom), _
Array As String("java.lang.int", "java.lang.int", _
"java.lang.int","java.lang.int"))
End Sub

Sub SetAlpha(Control As View, Alpha As Int)
Dim r As Reflector
r.Target = Control.Background
r.RunMethod2("setAlpha", Alpha, "java.lang.int")
End Sub

Sub PanelIndexOf(p As Panel, v As View) As Int
For i = 0 To p.NumberOfViews - 1
If p.GetView(i) = v Then Return i
Next
Return -1
End Sub

Sub HideScrollbar(ScrollView1 As ScrollView)
Dim r As Reflector
r.Target = ScrollView1
r.RunMethod2("setVerticalScrollBarEnabled", False, "java.lang.boolean")
End Sub

Sub SetDivider(lv As ListView, Color As Int, Height As Int)
  Dim r As Reflector
  r.Target = lv
  Dim CD As ColorDrawable
  CD.Initialize(Color, 0)
  r.RunMethod4("setDivider", Array As Object(CD), Array As String("android.graphics.drawable.Drawable"))
  r.RunMethod2("setDividerHeight", Height, "java.lang.int")
End Sub