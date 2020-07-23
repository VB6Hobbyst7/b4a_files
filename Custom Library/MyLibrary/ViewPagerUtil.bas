B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=8.3
@EndOfDesignText@
Private Sub Class_Globals
	
End Sub

'Initializes the object. You can add parameters to this method if needed.
Public Sub Initialize (VP As TabStrip)
	'	this code is for ViewPager
'	Dim Jo As JavaObject = Me
'	Dim VPJo As JavaObject = VP
'	VPJo.RunMethod("setPageTransformer",Array(True,Jo.RunMethod("newPageTransformer",Null)))
	Dim Jo As JavaObject = Me
	Dim VPJo As JavaObject = VP
	VPJo = VPJo.GetField("vp")
	VPJo.RunMethod("clearOnPageChangeListeners",Null)
	VPJo.RunMethod("setPageTransformer",Array(True,Jo.RunMethod("newPageTransformer",Null)))
End Sub

Public Sub TransformPage (View As Object,Position As Float) 'ZoomOutPageTransformer

  Dim ViewJO As JavaObject = View
  Dim MIN_SCALE = 0.85f As Float
  Dim MIN_ALPHA = 0.5f As Float
  Dim pageWidth  As Int= ViewJO.RunMethod("getWidth",Null)
  Dim pageHeight As Int = ViewJO.RunMethod("getHeight",Null)
  Dim Alpha As Float = 0
  
  If Position < -1 Then '[-Infinity,-1)
    ' This page Is way off-screen To the left.
    ViewJO.RunMethod("setAlpha",Array(Alpha))
  else if Position <= 1 Then '  [-1,1]
    ' Modify the default slide transition To shrink the page As well
    Dim scaleFactor = Max(MIN_SCALE, 1 - Abs(Position)) As Float
    Dim vertMargin = pageHeight * (1 - scaleFactor) / 2 As Float
    Dim horzMargin = pageWidth * (1 - scaleFactor) / 2 As Float
    Dim X As Float
    If Position < 0 Then
      X=horzMargin - vertMargin / 2
      ViewJO.RunMethod("setTranslationX",Array(X))
    Else
      X=-horzMargin + vertMargin / 2
      ViewJO.RunMethod("setTranslationX",Array(X))
    End If
    
    'Scale the page down (between MIN_SCALE And 1)
    ViewJO.RunMethod("setScaleX",Array(scaleFactor))
    ViewJO.RunMethod("setScaleY",Array(scaleFactor))

    ' Fade the page relative To its size.
    Alpha= MIN_ALPHA +(scaleFactor - MIN_SCALE) _
     /(1 - MIN_SCALE) * (1 - MIN_ALPHA)
    ViewJO.RunMethod("setAlpha",Array(Alpha))
     
   Else ' (1,+Infinity]
    ' This page Is way off-screen To the right.
    ViewJO.RunMethod("setAlpha",Array(Alpha))
  End If
End Sub

#if java
import android.support.v4.view.ViewPager;
import android.view.View;
public PageTransformer newPageTransformer(){
return new PageTransformer();
}
public class PageTransformer implements ViewPager.PageTransformer {
    public void transformPage(View view, float position) {
    ba.raiseEvent(view,"transformpage",view,position);
    }
}
#end if

