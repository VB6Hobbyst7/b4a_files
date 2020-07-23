Type=StaticCode
Version=3.15
@EndOfDesignText@
Sub Process_Globals

End Sub

Sub playAudio(FileDir As String,sFilename As String)
Dim media As MediaPlayer
media.Initialize2("mp2")
If FileDir <> "" Then
 media.Load(FileDir,sFilename)
Else
 media.Load(File.DirAssets,sFilename)
End If
media.Play
End Sub

Sub playAnimationComplete(obj1 As View,sAction As String,sSpeed As Int,sRepeatCount As Int)
Dim animation1 As AnimationPlus
    Select Case sAction
	 Case "rotate"
	  animation1.InitializeRotateCenter("",0,360,obj1)
	 Case "scale"
	  animation1.InitializeScaleCenter("",0,0,1,1,obj1)
	 Case "alpha"
	  animation1.InitializeAlpha("",0,100)
	 Case "translate"
	  animation1.InitializeTranslate("",-obj1.Width, 0, 0, 0)
	 Case "translate1"
	  animation1.InitializeTranslate("",0, 0, -obj1.Width, 0)	  
	End Select
	animation1.PersistAfter = True
	animation1.RepeatCount = sRepeatCount
	animation1.Duration = sSpeed
	animation1.SetInterpolator(animation1.INTERPOLATOR_LINEAR)
	animation1.Start(obj1)
End Sub



