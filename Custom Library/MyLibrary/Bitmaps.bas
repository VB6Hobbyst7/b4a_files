B4A=true
Group=Libraries
ModulesStructureVersion=1
Type=StaticCode
Version=7.8
@EndOfDesignText@
'Needed libraries: XUI,XmlLayoutBuilder

Sub Process_Globals

End Sub

Sub SetWallPaper(myBmp As Bitmap) As Boolean
	Try
		Dim r As Reflector
		r.Target = r.RunStaticMethod("android.app.WallpaperManager", "getInstance", _
	        Array As Object(r.GetContext), Array As String("android.content.Context"))
		r.RunMethod4("setBitmap", Array As Object(myBmp), Array As String("android.graphics.Bitmap"))
		r.RunMethod4("suggestDesiredDimensions", Array As Object(360, 640), _
	 Array As String("java.lang.int", "java.lang.int"))
	 	Return True
	 Catch
	 	Return False
	 End Try
End Sub

'remove color from panel and round it
Sub CreateMask (pnl As Panel, radius As Float, BackgroundColor As Int) As ImageView
	Dim bmp As Bitmap
	bmp.InitializeMutable(pnl.Width, pnl.Height)
	Dim cvs As Canvas
	cvs.Initialize2(bmp)
	cvs.DrawColor(BackgroundColor)
	Dim p As Path
	p.Initialize(0, 0)
	Dim jo As JavaObject = p
	Dim left = 0, top = 0, right = pnl.Width, bottom = pnl.Height As Float
	jo.RunMethod("addRoundRect", Array(left, top, right, bottom, radius, radius, "CW"))
	cvs.ClipPath(p)
	cvs.DrawColor(Colors.Transparent)
	Dim iv As ImageView
	iv.Initialize("")
	iv.Bitmap = bmp
	Return iv
End Sub

#If Java
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.os.Build;

    public void setPanelRadii(View view,int color1,int color2,float[] radii){
        GradientDrawable drawable = new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT,new int[]{color1,color2});
        drawable.setCornerRadii(radii);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            view.setBackground(drawable);
        }else {
            view.setBackgroundDrawable(drawable);
        }
    }
#End If

Sub SetPanelRadii(p As Panel,bgColor1 As Int, bgColor2 As Int,radii() As Float)
	Dim jo3 As JavaObject
	jo3.InitializeContext
	jo3.RunMethod("setPanelRadii",Array(p,bgColor1,bgColor2,radii))
End Sub

Sub DrawFont(MyText As String,FontFilename As String) As Bitmap
	Dim MyFont As Typeface
	MyFont = Typeface.LoadFromAssets(FontFilename)
	Dim Canvas As Canvas
	Dim imgCC As Bitmap
	imgCC.InitializeMutable(40dip,16dip) 'sample size
	Canvas.Initialize2(imgCC)
	Canvas.DrawText(MyText, 0, 0, MyFont, 16, Colors.Blue, "LEFT")
	Return Canvas.Bitmap
End Sub

Sub setCornerRadii(v As View, Rx_TopLeft As Float, Ry_TopLeft As Float, Rx_TopRight As Float, Ry_TopRight As Float, Rx_BottomRight As Float, Ry_BottomRight As Float, Rx_BottomLeft As Float, Ry_BottomLeft As Float)
	Dim jo As JavaObject = v.Background
	If v.Background Is ColorDrawable Or v.Background Is GradientDrawable Then
		jo.RunMethod("setCornerRadii", Array As Object(Array As Float(Rx_TopLeft, Ry_TopLeft, Rx_TopRight, Ry_TopRight, Rx_BottomRight, Ry_BottomRight, Rx_BottomLeft, Ry_BottomLeft)))
	End If
End Sub

Sub SetBitmapDensity(b As Bitmap) As Bitmap
	Dim jo As JavaObject = b
	Dim den As Int = Density * 160
	jo.RunMethod("setDensity", Array(den))
	Return b
End Sub

Sub RotateBitmap(original As Bitmap, degree As Float) As Bitmap
	Dim matrix As JavaObject
	matrix.InitializeNewInstance("android.graphics.Matrix", Null)
	matrix.RunMethod("postRotate", Array(degree))
	Dim bmp As JavaObject
	bmp.InitializeStatic("android.graphics.Bitmap")
	Dim NewImage As Bitmap = bmp.RunMethod("createBitmap", Array(original, 0, 0, original.Width, original.Height, _
     matrix, True))
	Return NewImage
End Sub

Sub RoundBitmap(Input As Bitmap,Corner As Int) As Bitmap
	
	Dim xui As XUI
	Dim BorderColor As Int = xui.Color_Black
	Dim BorderWidth As Int = 0
	Dim c As B4XCanvas
	Dim xview As B4XView = xui.CreatePanel("")
	xview.SetLayoutAnimated(0, 0, 0, Input.Width, Input.Height)
	c.Initialize(xview)
	Dim path As B4XPath
	path.InitializeRoundedRect(c.TargetRect, Corner)
	c.ClipPath(path)
	c.DrawRect(c.TargetRect, BorderColor, True, BorderWidth) 'border
	c.RemoveClip
	Dim r As B4XRect
	r.Initialize(BorderWidth, BorderWidth, c.TargetRect.Width - BorderWidth, c.TargetRect.Height - BorderWidth)
	path.InitializeRoundedRect(r, Corner)
	c.ClipPath(path)
	c.DrawBitmap(Input, r)
	c.RemoveClip
	c.Invalidate
	Dim res As B4XBitmap = c.CreateBitmap
	c.Release
	Return res
	
End Sub

Sub SaveBitmap(bitmap1 As Bitmap,Dir As String,Filename As String,Format As String)
	Dim b1 As Bitmap
	Dim out As OutputStream
	b1 = bitmap1
	out = File.OpenOutput(Dir,Filename,False)
	b1.WriteToStream(out,70,Format)
	out.Close
End Sub

Sub Hex2RGB(Hex As String) As Int
	Hex = Hex.Replace("###","#").Replace("##","#")
	If Hex.SubString2(0,1) <> "#" Then Hex = "#" & Hex
	Dim m As Map
	m.Initialize
	Dim r,g,b As Int
	' #E3E2E1
	'Log(hex.SubString2(1,3))
	r = Bit.ParseInt(Hex.SubString2(1,3), 16)
	g = Bit.ParseInt(Hex.SubString2(3,5), 16)
	b = Bit.ParseInt(Hex.SubString2(5,7), 16)
	m.Put("r",r)
	m.put("g",g)
	m.Put("b", b)
	Return Colors.RGB(r,g,b)
End Sub

Sub Rgb2Hex(r As Int, g As Int, b As Int) As String
	Dim intC As Int
	intC = Colors.RGB(r,g,b)
	Return Bit.ToHexString(intC)
End Sub

'type is : color,drawable,string
Sub GetObjectResource(KeyName As String,TypeName As String) As Object
	
	Dim xml As XmlLayoutBuilder
	Dim res As String
	res = xml.GetResourceId(TypeName,KeyName)
	
	If TypeName.ToLowerCase = "string" Then 
		Return xml.GetString(KeyName)
	End If
	
	Dim r As Reflector
	r.Target = r.GetContext
	r.Target = r.RunMethod("getResources")
	
	If TypeName.ToLowerCase = "color" Then
		Return r.RunMethod2("getColor", res, "java.lang.int")
		
	Else If TypeName.ToLowerCase = "drawable" Then
		Return r.RunMethod2("getDrawable", res, "java.lang.int")
	End If
	
	Return ""
	
End Sub

#IgnoreWarnings: 12
Sub CreateScaledBitmap(Original As Bitmap, Width As Int, Height As Int, Filter As Boolean) As Bitmap
	Dim r As Reflector
	Dim b As Bitmap
	b = r.RunStaticMethod("android.graphics.Bitmap", "createScaledBitmap", _
    Array As Object(Original, Width, Height, Filter), _ 
    Array As String("android.graphics.Bitmap", "java.lang.int", "java.lang.int", "java.lang.boolean")) 
	Return b
End Sub

Sub Bitmap2Drawable(Bitmap As Bitmap) As BitmapDrawable
	Dim b1 As BitmapDrawable
	b1.Initialize(Bitmap)
	Return b1
End Sub

'Format: jpeg,png
Sub Bitmap2File(Bitmap2 As Bitmap,Dir As String,Filename As String,Format As String,Quality As Int)
	
	Dim out As OutputStream
	out = File.OpenOutput(Dir,Filename, False)
	Bitmap2.WriteToStream(out, Quality, Format.ToUpperCase)
	out.Close
	
End Sub

#if replace_color
Sub ReplaceColor(Bitmap2 As Bitmap,DestinationColor2 As Int,ReplaceColor2 As Int) As Bitmap
	
	Dim RSIE As RSImageEffects
	Return RSIE.ReplaceColor(Bitmap2,DestinationColor2,ReplaceColor2)
	
End Sub
#end if

Sub GetColorDrawable2(Color As Int,Radius As Int,BorderWidth As Int,BorderColor As Int) As ColorDrawable
	Dim c1 As ColorDrawable
	c1.Initialize2(Color,Radius,BorderWidth,BorderColor)
	Return c1
End Sub

Sub GetColorDrawable(Color As Int,Radius As Int) As ColorDrawable
	Dim c1 As ColorDrawable
	c1.Initialize(Color,Radius)
	Return c1
End Sub

Sub GetBytesFromBitmap(Image As Bitmap) As Byte()
    
	Private outStream As OutputStream
	Private Data() As Byte
      
	outStream.InitializeToBytesArray(1)
      
	Image.WriteToStream(outStream, 100, "PNG")
      
	Data = outStream.ToBytesArray
      
	outStream.Close
      
	Return Data
    
End Sub

Public Sub BytesToImage(bytes() As Byte) As Bitmap
	Dim In As InputStream
	In.InitializeFromBytesArray(bytes, 0, bytes.Length)
	Dim bmp As Bitmap
	bmp.Initialize2(In)
	Return bmp
End Sub

Sub FitCenterBitmap(Imv As ImageView,bmp As Bitmap)
	Private cvs As Canvas
	cvs.Initialize(Imv)
   
	Dim rectDest As Rect
	Dim delta As Int
	If bmp.Width / bmp.Height > Imv.Width / Imv.Height Then
		delta = (Imv.Height - bmp.Height / bmp.Width * Imv.Width) / 2
		rectDest.Initialize(0, delta,Imv.Width, Imv.Height - delta)
	Else
		delta = (Imv.Width - bmp.Width / bmp.Height * Imv.Height) / 2
		rectDest.Initialize(delta, 0, Imv.Width - delta, Imv.Height)
	End If
	cvs.DrawBitmap(bmp, Null, rectDest)
	Imv.Invalidate
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

Sub ShadeColor(clr As Int) As Int
	Dim argb() As Int = GetARGB(clr)
	Dim factor As Float = 0.75
	Return Colors.RGB(argb(1) * factor, argb(2) * factor, argb(3) * factor)
End Sub

Sub GetARGB(Color As Int) As Int()
	Private res(4) As Int
	res(0) = Bit.UnsignedShiftRight(Bit.And(Color, 0xff000000), 24)
	res(1) = Bit.UnsignedShiftRight(Bit.And(Color, 0xff0000), 16)
	res(2) = Bit.UnsignedShiftRight(Bit.And(Color, 0xff00), 8)
	res(3) = Bit.And(Color, 0xff)
	Return res
End Sub

Sub FillImageToView(bmp As B4XBitmap, ImageView As B4XView)
	Dim bmpRatio As Float = bmp.Width / bmp.Height
	Dim viewRatio As Float = ImageView.Width / ImageView.Height
	If viewRatio > bmpRatio Then
		Dim NewHeight As Int = bmp.Width / viewRatio
		bmp = bmp.Crop(0, bmp.Height / 2 - NewHeight / 2, bmp.Width, NewHeight)
	Else if viewRatio < bmpRatio Then
		Dim NewWidth As Int = bmp.Height * viewRatio
		bmp = bmp.Crop(bmp.Width / 2 - NewWidth / 2, 0, NewWidth, bmp.Height)
	End If
	ImageView.SetBitmap(bmp.Resize(ImageView.Width, ImageView.Height, True))
End Sub

Sub FillImage(bmp As B4XBitmap, ImageView As B4XView) As Bitmap
	Dim bmpRatio As Float = bmp.Width / bmp.Height
	Dim viewRatio As Float = ImageView.Width / ImageView.Height
	If viewRatio > bmpRatio Then
		Dim NewHeight As Int = bmp.Width / viewRatio
		bmp = bmp.Crop(0, bmp.Height / 2 - NewHeight / 2, bmp.Width, NewHeight)
	Else if viewRatio < bmpRatio Then
		Dim NewWidth As Int = bmp.Height * viewRatio
		bmp = bmp.Crop(bmp.Width / 2 - NewWidth / 2, 0, NewWidth, bmp.Height)
	End If
	Return (bmp.Resize(ImageView.Width, ImageView.Height, True))
End Sub