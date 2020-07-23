Type=Class
Version=6.5
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
'Class module
Sub Class_Globals
	
End Sub

'Initializes the object. You can add parameters to this method if needed.
Public Sub Initialize

End Sub

'displays or hides the VerticalScrollBar of the ScrollView
Sub setVerticalScrollBarEnabled(v As View, Enabled As Boolean)
    Dim jo = v As JavaObject
    jo.RunMethod("setVerticalScrollBarEnabled", Array As Object (Enabled))
End Sub

'enables the VerticalFadingEdge of the SvrollView
'the VerticalFadingEdges are the 'shadows' on top and bottom of the ScrollView
Sub setVerticalFadingEdgeEnabled(v As View, Enabled As Boolean)
   Dim jo = v As JavaObject
   jo.RunMethod("setVerticalFadingEdgeEnabled", Array As Object (Enabled))
End Sub

'Gets the vertical Scrollbar position of the ScrollView
'    SCROLLBAR_POSITION_DEFAULT    = 0  position defined by the operating system
'    SCROLLBAR_POSITION_LEFT        = 1
'    SCROLLBAR_POSITION_RIGHT        = 2
Sub getVerticalScrollbarPosition(v As View) As Int
    Dim jo = v As JavaObject
    Return jo.RunMethod("getVerticalScrollbarPosition", Null)
End Sub

'Sets the vertical Scrollbar position of the ScrollView
'    SCROLLBAR_POSITION_DEFAULT    = 0  position defined by the operating system
'    SCROLLBAR_POSITION_LEFT        = 1
'    SCROLLBAR_POSITION_RIGHT        = 2
Sub setVerticalScrollbarPosition(v As View, Position As Int)
    Dim jo = v As JavaObject
    jo.RunMethod("setVerticalScrollbarPosition", Array As Object (Position))
End Sub

'Gets the ScrollBar style
'    SCROLLBARS_INSIDE_OVERLAY    = 0  (0x00000000)
'    SCROLLBARS_INSIDE_INSET          = 16777216 (0x01000000)
'    SCROLLBARS_OUTSIDE_INSET        = 50331648 (0x03000000)
'    SCROLLBARS_OUTSIDE_OVERLAY  = 33554432 (0x02000000)
Sub getScrollBarStyle(v As View) As Int
    Dim jo = v As JavaObject
    Return jo.RunMethod("getScrollBarStyle", Null)
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

'gets the OverScrollMode mode of the SvrollView
'    OVER_SCROLL_ALWAYS                        = 0
'    OVER_SCROLL_IF_CONTENT_SCROLLS = 1
'    OVER_SCROLL_NEVER                            = 2
Sub getOverScrollMode(v As View) As Int
    Dim jo = v As JavaObject
    Return jo.RunMethod("getOverScrollMode", Null)
End Sub

'sets the OverScrollMode mode of the SvrollView
'    OVER_SCROLL_ALWAYS                        = 0
'    OVER_SCROLL_IF_CONTENT_SCROLLS = 1
'    OVER_SCROLL_NEVER                            = 2
Sub setOverScrollMode(v As View, Mode As Int)
    Dim jo = v As JavaObject
    jo.RunMethod("setOverScrollMode", Array As Object (Mode))
End Sub

'sets the ScrollBarDefaultDelayBeforeFade of the SvrollView in milliseconds
'DelayBeforeFade is the time before the ScrollBar disappears
Sub getScrollBarDefaultDelayBeforeFade(v As View) As Int
    Dim jo = v As JavaObject
    Return jo.RunMethod("getScrollBarDefaultDelayBeforeFade", Null)
End Sub

'sets the ScrollBarDefaultDelayBeforeFade of the SvrollView in milliseconds
'DelayBeforeFade is the time before the ScrollBar disappears
Sub setScrollBarDefaultDelayBeforeFade(v As View, Duration As Int)
    Dim jo = v As JavaObject
    jo.RunMethod("setScrollBarDefaultDelayBeforeFade", Array As Object (Duration))
End Sub

'gets the ScrollBarFadeDuration of the SvrollView in milliseconds
'ScrollBarFadeDuration is the fading duration (slowly disappearing)
Sub getScrollBarFadeDuration(v As View) As Int
    Dim jo = v As JavaObject
    Return jo.RunMethod("getScrollBarFadeDuration", Null)
End Sub

'sets the ScrollBarFadeDuration of the SvrollView in milliseconds
'ScrollBarFadeDuration is the fading duration (slowly disappearing)
Sub setScrollBarFadeDuration(v As View, FadeDuration As Int)
    Dim jo = v As JavaObject
    jo.RunMethod("setScrollBarFadeDuration", Array As Object (FadeDuration))
End Sub

'Gets the ScrollBar size in pixels
'    unfortunately this seem not worfink, no effect on my devices
Sub getScrollBarSize(v As View) As Int
    Dim jo = v As JavaObject
    jo.RunMethod("getScrollBarSize", Null)
End Sub

'Sets the ScrollBar size in pixels
'    unfortunately this seem not worfink, no effect on my devices
Sub setScrollBarSize(v As View, Size As Int)
    Dim jo = v As JavaObject
    jo.RunMethod("setScrollBarSize", Array As Object (Size))
End Sub

'Gets the length, in pixels, of the fading edge (the shadows on top and bottom of the ScrollView
Sub getVerticalFadingEdgeLength(v As View) As Int
    Dim jo = v As JavaObject
    Return jo.RunMethod("getVerticalFadingEdgeLength", Null)
End Sub

'hide scrollview scollbar
Sub HideScrollbar(ScrollView1 As ScrollView)
	Dim r As Reflector
	r.Target = ScrollView1
	r.RunMethod2("setVerticalScrollBarEnabled", False, "java.lang.boolean")
End Sub