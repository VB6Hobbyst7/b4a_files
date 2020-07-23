Type=Class
Version=6.8
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
#Event: GetFrame(Frame As Bitmap)

Private Sub Class_Globals
	Private gif As GifDecoder
	Private FrameCount As Int
	Private Width,Height As Int
	Private LoopCount As Int
	Private Frames() As Bitmap
	Private Delays() As Int
	Private temp As ImageView
	Private tmr As Timer
	Private offset As Int : offset = 0
	Private LoopGif As Boolean
	Private ob As Object
	Private evt As String
	Private ShowWithImage As Boolean
	Private ScaleBitmapState As Boolean
	Private raise_event_on_special_frame As List
	Private is_cache As Boolean
End Sub

'Use parameter <code>#DebuggerForceStandardAssets: True</code> in Project Attribute in main activity
'autho www.iranapp.org
Public Sub Initialize(Dir As String,Filename As String)
	
	'LogColor("Start loading gif file: " & DateTime.Time(DateTime.Now),Colors.Green)
'	is_cache = Cache
	
	gif.Load(Dir,Filename)
	'LogColor("End of loading gif file: " & DateTime.Time(DateTime.Now),Colors.Green)
	
	FrameCount	= gif.FrameCount
	Height		= gif.FrameHeight
	Width		= gif.FrameWidth
	LoopCount	= gif.LoopCount
	
	Dim Frames(FrameCount) As Bitmap
	Dim Delays(FrameCount) As Int
	
	If (FrameCount = 0) Then
		LogColor("Gif no have any frame",Colors.Red)
		Return
	End If
	
	Frames = GetFrames
	
	tmr.Initialize("timer",gif.Delay(0))
	
End Sub

Private Sub SaveBitmap(bitmap1 As Bitmap,Dir As String,Filename As String)
	Dim b1 As Bitmap
	Dim out As OutputStream
	b1 = bitmap1
	out = File.OpenOutput(Dir,Filename,False)
	b1.WriteToStream(out,100,"PNG")
	out.Close
End Sub

#Region Frame Attribute
Sub getFrameWidth As Int
	Return Width
End Sub

Sub getFrameHeight As Int
	Return Height
End Sub

Sub getLoopCount As Int
	Return LoopCount
End Sub

Sub getFramesCount As Int
	Return FrameCount
End Sub

Sub GetFrames As Bitmap()
	
	For i = 0 To FrameCount - 1
		Frames(i)	= gif.Frame(i)
	Next
	
	Return Frames
	
End Sub

Sub GetDelays As Int()
	
	For i = 0 To FrameCount - 1
		Delays(i)	= gif.Delay(i)
	Next
	
	Return Delays
	
End Sub

'return millisecond duration
Sub getDuration As Int
	
	Dim sum As Int
	
	For i = 0 To FrameCount - 1
		Delays(i)	= gif.Delay(i)
		sum = sum + gif.Delay(i)
	Next
	
	Return sum
	
End Sub

Sub setDuration(Duration As Int)
	tmr.Interval = Duration
End Sub

'Format : p for png and j for jpg
Sub SaveFrame(Position As Int,Dir As String,Filename As String,Format As String,Quailty As Int)
	
	Dim p As Int
	
	If Position < 0 Then
		p = 0
	Else if Position > FrameCount Then
		p = FrameCount
	Else
		p = Position
	End If
	
	gif.SaveFrame(Position,Dir,Filename,Format,Quailty)
	
End Sub

Sub SaveFrames(Dir As String,Filename As String,Format As String,Quailty As Int)

	For i = 0 To FrameCount - 1
		SaveFrame(i,Dir,i & "_" & Filename,Format,Quailty)
	Next
	
End Sub

#End Region

'play gif directly in imageview
Sub Play(Imageview1 As ImageView,Looping As Boolean,ScaleBitmap As Boolean)
	
	ScaleBitmapState= ScaleBitmap
	ShowWithImage	= True
	temp			= Imageview1
	LoopGif			= Looping
	
	offset			= 0
	tmr.Enabled		= True
	
End Sub

'Get frames of gif in event with bitmap format
Sub Play2(Module As Object,Event As String,Looping As Boolean)
	
	ShowWithImage	= False
	ob				= Module
	evt				= Event
	
	LoopGif			= Looping
	
	offset			= 0
	tmr.Enabled 	= True
	
End Sub

Sub Stop
	
	offset = 0
	tmr.Enabled = False
	
End Sub

Sub Pause
	tmr.Enabled = False
End Sub

'play gif from where pause
Sub Resume
	tmr.Enabled = True
End Sub

Private Sub timer_Tick
	
	If offset > FrameCount-1 Then
		
		If LoopGif = False Then
			tmr.Enabled = False
			Return
		End If
		
		offset = 0
		
	End If
	
	If ShowWithImage Then
		If ScaleBitmapState = False Then
			temp.Bitmap = Frames(offset)
		Else
			temp.Bitmap = CreateScaledBitmap(Frames(offset),temp.Width,temp.Width,False)
'			temp.Bitmap = CreateScaledBitmap(gif.Frame(offset),temp.Width,temp.Width,False)
		End If
	Else
		If SubExists(ob,evt & "_getframe") Then
			Dim b As Bitmap
			b = Frames(offset)
			CallSubDelayed2(ob,evt & "_getframe",b)
		End If
	End If
	
	offset = offset + 1
	
End Sub

Private Sub CreateScaledBitmap(Original As Bitmap, sWidth As Int, sHeight As Int, Filter As Boolean) As Bitmap
	Dim jo As JavaObject
	jo.InitializeStatic("android.graphics.Bitmap")
	Return jo.RunMethod("createScaledBitmap", Array (Original, sWidth, sHeight, Filter))
End Sub