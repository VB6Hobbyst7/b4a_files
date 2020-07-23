B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=7.01
@EndOfDesignText@
#DesignerProperty: Key: filename, DisplayName: Filename in DirAsset, FieldType: String,, DefaultValue:  ,Description: filename of svg file in asset folder.
#DesignerProperty: Key: fit, DisplayName: Fit Mode, FieldType: Boolean, DefaultValue: True, Description: show fit picture in parent view.

Sub Class_Globals
	Private mEventName As String 'ignore
	Private mCallBack As Object 'ignore
	Private mBase As Panel
	Private Const DefaultColorConstant As Int = -984833 'ignore
	Private svg As SVG
End Sub

Public Sub Initialize (Callback As Object, EventName As String)
	mEventName = EventName
	mCallBack = Callback
End Sub

Public Sub DesignerCreateView (Base As Panel, Lbl As Label, Props As Map)

	mBase = Base
	Base.Color = Colors.Transparent
	svg.Initialize(File.DirAssets,Props.Get("filename"))
	
	Dim canvas1 As Canvas
	Dim rect1 As Rect
 
	If Props.Get("fit") = False Then
		rect1.Initialize(0, 0, Base.Width, Base.Height)
		canvas1.Initialize(Base)
		svg.DrawPicture(canvas1, rect1)
		Log("no fit")

	Else
		
		If svg.Width > Base.Width Then
			rect1.Initialize(0, 0, Base.Width, svg.Height * Base.Width / svg.Width)
			canvas1.Initialize(Base)
			svg.DrawPicture(canvas1, rect1)
			Log("width > height")
		Else
			rect1.Initialize(0, 0, Base.Width, svg.Height * Base.Width / svg.Width)
			canvas1.Initialize(Base)
			svg.DrawPicture(canvas1, rect1)
			Log("width < height")
		End If
		
	End If
	
End Sub

Public Sub GetBase As Panel
	Return mBase
End Sub
