B4A=true
Group=Libraries
ModulesStructureVersion=1
Type=StaticCode
Version=9.5
@EndOfDesignText@
'Code module
'Subs in this code module will be accessible from all modules.
Private Sub Process_Globals
End Sub

Sub ShowMessage(Title As String,Message As String)
	
	Dim cTitle,cMessage As CSBuilder
	cMessage.Initialize
	cTitle.Initialize
	cMessage.Size(12).Typeface(Typeface.LoadFromAssets("iransans.ttf")).Color(Colors.Black).Append(Message).Pop
	cTitle.Size(14).Typeface(Typeface.LoadFromAssets("iransans.ttf")).Color(Colors.Gray).Append(Title).Pop
	
	Msgbox(cMessage.PopAll,cTitle.PopAll)
	
End Sub

Sub ShowMessage2(Title As String,Message As String,Postive As String,Negative As String) As Int
	
	Dim cTitle,cMessage As CSBuilder
	cMessage.Initialize
	cTitle.Initialize
	cMessage.Size(12).Typeface(Typeface.LoadFromAssets("iransans.ttf")).Color(Colors.Black).Append(Message).Pop
	cTitle.Size(14).Typeface(Typeface.LoadFromAssets("iransans.ttf")).Color(Colors.Gray).Append(Title).Pop
	
	Dim result As Int
	result	=	Msgbox2(cMessage.PopAll,cTitle.PopAll,Postive,"",Negative,Null)
	
	Return result
	
End Sub

Sub ProgressDialogShow3(Message As String)
	
	Dim cTitle,cMessage As CSBuilder
	cMessage.Initialize
	cTitle.Initialize
	cMessage.Size(11).Typeface(Typeface.LoadFromAssets("iransans.ttf")).Color(Colors.Black).Append(Message).Pop
	
	ProgressDialogShow(cMessage.PopAll)
	
End Sub

Sub ToastMessageShow3(Message As String,BgColor As Int,TextColor As Int,LongDuration As Boolean)
	
	Dim width As Int
	width = 900dip
	
	Dim BackGround As ColorDrawable
	BackGround.Initialize(BgColor,width/2)
	
	Dim cMessage As CSBuilder
	cMessage.Initialize
	cMessage.Size(12).Typeface(Typeface.LoadFromAssets("iransans.ttf")).Color(TextColor).Append(Message).Pop
	
	Dim ctxt As JavaObject
	ctxt.InitializeContext
	Dim duration As Int
	If LongDuration Then duration = 1 Else duration = 0
	Dim toast As JavaObject
	toast = toast.InitializeStatic("android.widget.Toast").RunMethod("makeText", Array(ctxt, cMessage.PopAll, duration))
	Dim v As View = toast.RunMethod("getView", Null)
	v.Background = BackGround
	v.Padding	=	Array As Int(8dip,8dip,8dip,8dip)
	v.Width	=	width
	'uncomment to show toast in the center:
	toast.RunMethod("setGravity", Array(Bit.Or(Gravity.CENTER_HORIZONTAL, Gravity.BOTTOM), 0, 20dip))
	toast.RunMethod("show", Null)
	
End Sub

Sub ToastMessageShow4(Message As CSBuilder,BgColor As Int,LongDuration As Boolean)
	
	Dim width As Int
	width = 900dip
	
	Dim BackGround As ColorDrawable
	BackGround.Initialize(BgColor,width/2)
	
	Dim ctxt As JavaObject
	ctxt.InitializeContext
	Dim duration As Int
	If LongDuration Then duration = 1 Else duration = 0
	Dim toast As JavaObject
	toast = toast.InitializeStatic("android.widget.Toast").RunMethod("makeText", Array(ctxt, Message, duration))
	Dim v As View = toast.RunMethod("getView", Null)
	v.Background = BackGround
	v.Padding	=	Array As Int(8dip,8dip,8dip,8dip)
	v.Width	=	width
	'uncomment to show toast in the center:
	toast.RunMethod("setGravity", Array(Bit.Or(Gravity.CENTER_HORIZONTAL, Gravity.BOTTOM), 0, 20dip))
	toast.RunMethod("show", Null)
	
End Sub