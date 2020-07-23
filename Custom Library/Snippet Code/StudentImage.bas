Type=Class
Version=6.5
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
'Class module
Sub Class_Globals
	Dim sl As StudentLibrary
End Sub

'Initializes the object. You can add parameters to this method if needed.
Public Sub Initialize

End Sub

'resize the image
Sub ResizeBitmap(original As Bitmap, width As Int, height As Int) As Bitmap
    Dim new As Bitmap
    new.InitializeMutable(width, height)
    Dim c As Canvas
    c.Initialize2(new)
    Dim destRect As Rect
    destRect.Initialize(0, 0, width, height)
    c.DrawBitmap(original, Null, destRect)
    Return new
End Sub

Sub SaveBitmap(bitmap1 As Bitmap,Dir As String,Filename As String)
	Dim b1 As Bitmap
	Dim out As OutputStream
	b1 = bitmap1
	out = File.OpenOutput(Dir,Filename,False)
	b1.WriteToStream(out,100,"png")
	out.Close
End Sub

'open a filename image in gallery 
Sub OpenGallery(filename As String)
	
	Dim iIntent As Intent
	Dim Image As String

	Image = File.Combine(File.DirDefaultExternal, filename)
	iIntent.Initialize(iIntent.ACTION_VIEW, "file:///" & Image)
	iIntent.SetType("image/jpeg")
	StartActivity(iIntent)
	
End Sub

'get wallpaper of android 
Sub GetWallpaper As Bitmap
Return sl.GetWallpaper
End Sub

'set image to android wallpaper
Sub SetWallpaper(sBitmap As Bitmap) As Boolean
Return sl.SetWallpaper(sBitmap)
End Sub


'zoom of image with filter
Sub CreateScaledBitmap(Original As Bitmap, Width As Int, Height As Int, Filter As Boolean) As Bitmap
	Dim r As Reflector
	Dim b As Bitmap
	b = r.RunStaticMethod("android.graphics.Bitmap", "createScaledBitmap",Array As Object(Original, Width, Height, Filter),Array As String("android.graphics.Bitmap", "java.lang.int", "java.lang.int", "java.lang.Boolean"))
	Return b
End Sub

'load image from url to imageview
Sub LoadImageFromUrl(sLink As String,imgView As ImageView)
sl.LoadImageFromUrl(sLink,imgView)
End Sub

'crop image using any app and return result of crop for save
Sub CropImageInGallery(Directory As String, PictureName As String) As Intent
    Dim i As Intent
    Dim k As String
    
    Dim r As Reflector
    k = r.RunStaticMethod("android.net.Uri", "parse", Array As Object(("file://" & File.Combine(Directory, PictureName))), Array As String("java.lang.String"))

    i.Initialize(i.ACTION_PICK, "")
    i.SetType("image/*")
    i.PutExtra("output", k) 'output folder you set OpenCam(File.DirRootExternal, "1.jpg")
    i.PutExtra("crop", "true") 'crop ON
    i.PutExtra("aspectX", 0) 'crop aspects
    i.PutExtra("aspectY", 0) 'crop aspects
    i.PutExtra("outputX", 200) 'crop size
    i.PutExtra("outputY", 150) 'crop size
    Return i

End Sub

Sub FitCenterBitmap(Imv As ImageView, Dir As String, FileName As String)
    Private bmp As Bitmap = LoadBitmap(Dir, FileName)
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