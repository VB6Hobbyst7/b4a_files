Type=Class
Version=7.01
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@

#Event: AnimationComplete(State As Boolean)

Private Sub Class_Globals

	Private r As Reflector

	Private SlidingPanel As Panel
	Private downY As Int
	Private ACTION_UP, ACTION_DOWN, ACTION_MOVE As Int

	Private IsSheetOpen As Boolean

	Private cCallback As Object
	Private cEventName As String

End Sub

'Initializes the CustomBottomSheet library.
'Parent: Activity (Required).
'Callback: Me (Required).
'EventName: Prefix to be used on the event responses.
'LayoutContainer: The panel containing the layout.
Public Sub Initialize(Parent As Activity, Callback As Object, EventName As String,	LayoutContainer As Panel)

	cCallback = Callback
	cEventName = EventName

	ACTION_UP = Parent.ACTION_UP
	ACTION_DOWN = Parent.ACTION_DOWN
	ACTION_MOVE = Parent.ACTION_MOVE

	SlidingPanel = LayoutContainer

	'I know I HATE using Reflection but this code is cute.
	r.Target = SlidingPanel
	r.SetOnTouchListener("SlidingPanel_Touch")							

	'Here we add the panel (with the layout) to the Activity
	'GetView(0) means, grab the first view on the layout (Z-Order)
	'which will always be a PANEL, that's why you must create your
	'layouts on a panel for this class to work.
	Parent.AddView(LayoutContainer, 0dip, 100%y - 50dip, 100%x, LayoutContainer.GetView(0).Height)

End Sub

'Open the CustomBottomSheet.
Public Sub OpenBottomSheet

	IsSheetOpen = True

	SlidingPanel.Top = 100%y - SlidingPanel.Height

	If SubExists(cCallback, cEventName & "_AnimationComplete") Then

	CallSubDelayed2(cCallback, cEventName & "_AnimationComplete", IsSheetOpen)

	End If

End Sub

'Close the CustomBottomSheet.
Public Sub CloseBottomSheet

	IsSheetOpen = False

	SlidingPanel.Top = 100%y - 50dip

	If SubExists(cCallback, cEventName & "_AnimationComplete") Then

	CallSubDelayed2(cCallback, cEventName & "_AnimationComplete", IsSheetOpen)

	End If							

End Sub

'Returns the state of the CustomBottomSheet.
'True = Open, False = Closed.
Public Sub IsOpen As Boolean

	Return IsSheetOpen

End Sub

Private Sub SlidingPanel_Touch(Obj As Object, Action As Int, X As Float, Y As Float, Motion As Object) As Boolean

	'This subroutine will handle the display of the CustomBottomSheet
	'If the dragging goes beyond ~50% the height of the panel it will
	'either open or close depending on the direction you're dragging.
	If Action = ACTION_DOWN Then

	downY = Y

	End If

	If Action = ACTION_MOVE Then

	SlidingPanel.Top = SlidingPanel.Top + Y - downY

	'Here we make sure the panel doesn't "move" beyond its height
	'or dissapears completely, the CustomBottomSheet will be always
	'50dip from the bottom of the device's screen.
		If SlidingPanel.Top > 100%y - 50dip Then SlidingPanel.SetLayoutAnimated(400,SlidingPanel.Left,100%y-50dip,SlidingPanel.Width,SlidingPanel.Height) 'SlidingPanel.Top = 100%y - 50dip
		If SlidingPanel.Top < 100%y - SlidingPanel.Height Then SlidingPanel.SetLayoutAnimated(400,SlidingPanel.Left, 100%y - SlidingPanel.Height,SlidingPanel.Width,SlidingPanel.Height) 'SlidingPanel.Top = 100%y - SlidingPanel.Height

	End If

	If Action = ACTION_UP Then

		If SlidingPanel.Top + 50dip < 100%y - SlidingPanel.Height / 3 Then

			'SlidingPanel.Top = 100%y - SlidingPanel.Height 'Open
			SlidingPanel.SetLayoutAnimated(400,SlidingPanel.Left, 100%y - SlidingPanel.Height,SlidingPanel.Width,SlidingPanel.Height)
			
			IsSheetOpen = True

			If SubExists(cCallback, cEventName & "_AnimationComplete") Then

				CallSubDelayed2(cCallback, cEventName & "_AnimationComplete", IsSheetOpen)

			End If

		End If

		If SlidingPanel.Top + SlidingPanel.Height > 100%y Then

			'SlidingPanel.Top = 100%y - 50dip 'Close
			SlidingPanel.SetLayoutAnimated(400,SlidingPanel.Left, 100%y - 50dip,SlidingPanel.Width,SlidingPanel.Height)
			
			IsSheetOpen = False

			If SubExists(cCallback, cEventName & "_AnimationComplete") Then

				CallSubDelayed2(cCallback, cEventName & "_AnimationComplete", IsSheetOpen)

			End If														

		End If

	End If

	Return True

End Sub