package b4a.exampleddd;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class picturechooser extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new anywheresoftware.b4a.ShellBA(_ba, this, htSubs, "b4a.exampleddd.picturechooser");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", b4a.exampleddd.picturechooser.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 
    public void  innerInitializeHelper(anywheresoftware.b4a.BA _ba) throws Exception{
        innerInitialize(_ba);
    }
    public Object callSub(String sub, Object sender, Object[] args) throws Exception {
        return BA.SubDelegator.SubNotFound;
    }
public anywheresoftware.b4a.keywords.Common __c = null;
public Object _ion = null;
public String _imagefolder = "";
public boolean _isfrontcamera = false;
public String _tempimagefile = "";
public anywheresoftware.b4a.phone.Phone.ContentChooser _chooser = null;
public Object _modue = null;
public String _evt = "";
public String _sdir = "";
public String _sfilename = "";
public boolean _is_crop = false;
public anywheresoftware.b4a.objects.PanelWrapper _p2 = null;
public de.donmanfred.CropImageViewWrapper _cv = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnrotate = null;
public String _rotate_title = "";
public String _crop_title = "";
public String _cancel_title = "";
public anywheresoftware.b4a.objects.ButtonWrapper _b = null;
public int _quality2 = 0;
public anywheresoftware.b4a.objects.ButtonWrapper _cancel = null;
public String _chooser_title = "";
public anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _currentuserbitmap = null;
public anywheresoftware.b4a.objects.RuntimePermissions _rp = null;
public String _currentdircrop = "";
public String _currentfilenamecrop = "";
public int _aspectratiowidth = 0;
public int _aspectratioheight = 0;
public boolean _isscale = false;
public b4a.exampleddd.main _main = null;
public b4a.exampleddd.starter _starter = null;
public String  _choosefromgallery(b4a.exampleddd.picturechooser __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="picturechooser";
if (Debug.shouldDelegate(ba, "choosefromgallery"))
	 {return ((String) Debug.delegate(ba, "choosefromgallery", null));}
RDebugUtils.currentLine=1769472;
 //BA.debugLineNum = 1769472;BA.debugLine="Public Sub ChooseFromGallery";
RDebugUtils.currentLine=1769473;
 //BA.debugLineNum = 1769473;BA.debugLine="chooser.Show(\"image/*\",Chooser_Title)";
__ref._chooser.Show(ba,"image/*",__ref._chooser_title);
RDebugUtils.currentLine=1769474;
 //BA.debugLineNum = 1769474;BA.debugLine="End Sub";
return "";
}
public String  _initialize(b4a.exampleddd.picturechooser __ref,anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.PanelWrapper _parent,Object _module,String _eventresult) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="picturechooser";
if (Debug.shouldDelegate(ba, "initialize"))
	 {return ((String) Debug.delegate(ba, "initialize", new Object[] {_ba,_parent,_module,_eventresult}));}
RDebugUtils.currentLine=655360;
 //BA.debugLineNum = 655360;BA.debugLine="Public Sub Initialize(Parent As Panel,Module As Ob";
RDebugUtils.currentLine=655362;
 //BA.debugLineNum = 655362;BA.debugLine="modue	= Module";
__ref._modue = _module;
RDebugUtils.currentLine=655363;
 //BA.debugLineNum = 655363;BA.debugLine="evt		= EventResult";
__ref._evt = _eventresult;
RDebugUtils.currentLine=655365;
 //BA.debugLineNum = 655365;BA.debugLine="chooser.Initialize(\"cc\")";
__ref._chooser.Initialize("cc");
RDebugUtils.currentLine=655367;
 //BA.debugLineNum = 655367;BA.debugLine="tempImageFile	= \"temp.jpg\"";
__ref._tempimagefile = "temp.jpg";
RDebugUtils.currentLine=655368;
 //BA.debugLineNum = 655368;BA.debugLine="imageFolder 	= rp.GetSafeDirDefaultExternal(\"cach";
__ref._imagefolder = __ref._rp.GetSafeDirDefaultExternal("cache");
RDebugUtils.currentLine=655370;
 //BA.debugLineNum = 655370;BA.debugLine="If Parent = Null Then Return";
if (_parent== null) { 
if (true) return "";};
RDebugUtils.currentLine=655371;
 //BA.debugLineNum = 655371;BA.debugLine="If Parent.IsInitialized = False Then Return";
if (_parent.IsInitialized()==__c.False) { 
if (true) return "";};
RDebugUtils.currentLine=655373;
 //BA.debugLineNum = 655373;BA.debugLine="p2.Initialize(\"p2Panel\")";
__ref._p2.Initialize(ba,"p2Panel");
RDebugUtils.currentLine=655374;
 //BA.debugLineNum = 655374;BA.debugLine="p2.Visible = False";
__ref._p2.setVisible(__c.False);
RDebugUtils.currentLine=655375;
 //BA.debugLineNum = 655375;BA.debugLine="p2.Color = Colors.RGB(30, 30, 30)";
__ref._p2.setColor(__c.Colors.RGB((int) (30),(int) (30),(int) (30)));
RDebugUtils.currentLine=655376;
 //BA.debugLineNum = 655376;BA.debugLine="Parent.AddView(p2,0,0,Parent.Width,Parent.Height)";
_parent.AddView((android.view.View)(__ref._p2.getObject()),(int) (0),(int) (0),_parent.getWidth(),_parent.getHeight());
RDebugUtils.currentLine=655378;
 //BA.debugLineNum = 655378;BA.debugLine="CV.Initialize(\"SCV\")";
__ref._cv.Initialize(ba,"SCV");
RDebugUtils.currentLine=655379;
 //BA.debugLineNum = 655379;BA.debugLine="p2.AddView(CV,0,0,p2.Width,p2.Height)";
__ref._p2.AddView((android.view.View)(__ref._cv.getObject()),(int) (0),(int) (0),__ref._p2.getWidth(),__ref._p2.getHeight());
RDebugUtils.currentLine=655381;
 //BA.debugLineNum = 655381;BA.debugLine="b.Initialize(\"btncrop\")";
__ref._b.Initialize(ba,"btncrop");
RDebugUtils.currentLine=655382;
 //BA.debugLineNum = 655382;BA.debugLine="b.Text		= crop_title";
__ref._b.setText(BA.ObjectToCharSequence(__ref._crop_title));
RDebugUtils.currentLine=655383;
 //BA.debugLineNum = 655383;BA.debugLine="b.TextColor = Colors.White";
__ref._b.setTextColor(__c.Colors.White);
RDebugUtils.currentLine=655384;
 //BA.debugLineNum = 655384;BA.debugLine="b.TextSize	= 13";
__ref._b.setTextSize((float) (13));
RDebugUtils.currentLine=655385;
 //BA.debugLineNum = 655385;BA.debugLine="b.Color		= Colors.RGB(51, 51, 55)";
__ref._b.setColor(__c.Colors.RGB((int) (51),(int) (51),(int) (55)));
RDebugUtils.currentLine=655386;
 //BA.debugLineNum = 655386;BA.debugLine="p2.AddView(b,0,p2.Height - 40dip,p2.Width/3,40dip";
__ref._p2.AddView((android.view.View)(__ref._b.getObject()),(int) (0),(int) (__ref._p2.getHeight()-__c.DipToCurrent((int) (40))),(int) (__ref._p2.getWidth()/(double)3),__c.DipToCurrent((int) (40)));
RDebugUtils.currentLine=655388;
 //BA.debugLineNum = 655388;BA.debugLine="btnrotate.Initialize(\"btnrotate\")";
__ref._btnrotate.Initialize(ba,"btnrotate");
RDebugUtils.currentLine=655389;
 //BA.debugLineNum = 655389;BA.debugLine="btnrotate.Text = rotate_title";
__ref._btnrotate.setText(BA.ObjectToCharSequence(__ref._rotate_title));
RDebugUtils.currentLine=655390;
 //BA.debugLineNum = 655390;BA.debugLine="btnrotate.TextColor = Colors.White";
__ref._btnrotate.setTextColor(__c.Colors.White);
RDebugUtils.currentLine=655391;
 //BA.debugLineNum = 655391;BA.debugLine="btnrotate.TextSize = 13";
__ref._btnrotate.setTextSize((float) (13));
RDebugUtils.currentLine=655392;
 //BA.debugLineNum = 655392;BA.debugLine="btnrotate.Color = Colors.RGB(51, 51, 55)";
__ref._btnrotate.setColor(__c.Colors.RGB((int) (51),(int) (51),(int) (55)));
RDebugUtils.currentLine=655393;
 //BA.debugLineNum = 655393;BA.debugLine="p2.AddView(btnrotate,b.Width,Parent.Height - 40di";
__ref._p2.AddView((android.view.View)(__ref._btnrotate.getObject()),__ref._b.getWidth(),(int) (_parent.getHeight()-__c.DipToCurrent((int) (40))),(int) (_parent.getWidth()/(double)3),__c.DipToCurrent((int) (40)));
RDebugUtils.currentLine=655395;
 //BA.debugLineNum = 655395;BA.debugLine="cancel.Initialize(\"btncancel\")";
__ref._cancel.Initialize(ba,"btncancel");
RDebugUtils.currentLine=655396;
 //BA.debugLineNum = 655396;BA.debugLine="cancel.Text = cancel_title";
__ref._cancel.setText(BA.ObjectToCharSequence(__ref._cancel_title));
RDebugUtils.currentLine=655397;
 //BA.debugLineNum = 655397;BA.debugLine="cancel.TextSize = 13";
__ref._cancel.setTextSize((float) (13));
RDebugUtils.currentLine=655398;
 //BA.debugLineNum = 655398;BA.debugLine="cancel.TextColor = Colors.White";
__ref._cancel.setTextColor(__c.Colors.White);
RDebugUtils.currentLine=655399;
 //BA.debugLineNum = 655399;BA.debugLine="cancel.Color = Colors.RGB(51, 51, 55)";
__ref._cancel.setColor(__c.Colors.RGB((int) (51),(int) (51),(int) (55)));
RDebugUtils.currentLine=655400;
 //BA.debugLineNum = 655400;BA.debugLine="p2.AddView(cancel,p2.Width - (p2.Width/3),p2.Heig";
__ref._p2.AddView((android.view.View)(__ref._cancel.getObject()),(int) (__ref._p2.getWidth()-(__ref._p2.getWidth()/(double)3)),(int) (__ref._p2.getHeight()-__c.DipToCurrent((int) (40))),(int) (__ref._p2.getWidth()/(double)3),__c.DipToCurrent((int) (40)));
RDebugUtils.currentLine=655402;
 //BA.debugLineNum = 655402;BA.debugLine="End Sub";
return "";
}
public String  _setcrop(b4a.exampleddd.picturechooser __ref,boolean _value) throws Exception{
__ref = this;
RDebugUtils.currentModule="picturechooser";
if (Debug.shouldDelegate(ba, "setcrop"))
	 {return ((String) Debug.delegate(ba, "setcrop", new Object[] {_value}));}
RDebugUtils.currentLine=1245184;
 //BA.debugLineNum = 1245184;BA.debugLine="Public Sub setCrop(Value As Boolean)";
RDebugUtils.currentLine=1245185;
 //BA.debugLineNum = 1245185;BA.debugLine="is_crop	=	Value";
__ref._is_crop = _value;
RDebugUtils.currentLine=1245186;
 //BA.debugLineNum = 1245186;BA.debugLine="End Sub";
return "";
}
public String  _btncancel_click(b4a.exampleddd.picturechooser __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="picturechooser";
if (Debug.shouldDelegate(ba, "btncancel_click"))
	 {return ((String) Debug.delegate(ba, "btncancel_click", null));}
RDebugUtils.currentLine=2359296;
 //BA.debugLineNum = 2359296;BA.debugLine="Private Sub btncancel_Click";
RDebugUtils.currentLine=2359298;
 //BA.debugLineNum = 2359298;BA.debugLine="p2.Visible = False";
__ref._p2.setVisible(__c.False);
RDebugUtils.currentLine=2359300;
 //BA.debugLineNum = 2359300;BA.debugLine="If SubExists(modue,evt & \"_error\") Then";
if (__c.SubExists(ba,__ref._modue,__ref._evt+"_error")) { 
RDebugUtils.currentLine=2359301;
 //BA.debugLineNum = 2359301;BA.debugLine="CallSubDelayed(modue,evt & \"_error\")";
__c.CallSubDelayed(ba,__ref._modue,__ref._evt+"_error");
 };
RDebugUtils.currentLine=2359304;
 //BA.debugLineNum = 2359304;BA.debugLine="End Sub";
return "";
}
public String  _btncrop_click(b4a.exampleddd.picturechooser __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="picturechooser";
if (Debug.shouldDelegate(ba, "btncrop_click"))
	 {return ((String) Debug.delegate(ba, "btncrop_click", null));}
RDebugUtils.currentLine=2228224;
 //BA.debugLineNum = 2228224;BA.debugLine="Private Sub btncrop_Click";
RDebugUtils.currentLine=2228226;
 //BA.debugLineNum = 2228226;BA.debugLine="p2.Visible	=	False";
__ref._p2.setVisible(__c.False);
RDebugUtils.currentLine=2228228;
 //BA.debugLineNum = 2228228;BA.debugLine="SaveBitmap(CV.CroppedImage,File.DirInternal,tempI";
__ref._savebitmap(null,(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(__ref._cv.getCroppedImage())),__c.File.getDirInternal(),__ref._tempimagefile,__ref._quality2);
RDebugUtils.currentLine=2228230;
 //BA.debugLineNum = 2228230;BA.debugLine="If SubExists(modue,evt & \"_Result2\") Then";
if (__c.SubExists(ba,__ref._modue,__ref._evt+"_Result2")) { 
RDebugUtils.currentLine=2228231;
 //BA.debugLineNum = 2228231;BA.debugLine="CallSub3(modue,evt & \"_Result2\",File.DirInternal";
__c.CallSubNew3(ba,__ref._modue,__ref._evt+"_Result2",(Object)(__c.File.getDirInternal()),(Object)(__ref._tempimagefile));
 }else {
RDebugUtils.currentLine=2228234;
 //BA.debugLineNum = 2228234;BA.debugLine="CallSubDelayed2(modue,evt & \"_result\",FixOrienta";
__c.CallSubDelayed2(ba,__ref._modue,__ref._evt+"_result",(Object)(__ref._fixorientation(null,__c.File.getDirInternal(),__ref._tempimagefile)));
 };
RDebugUtils.currentLine=2228238;
 //BA.debugLineNum = 2228238;BA.debugLine="End Sub";
return "";
}
public String  _savebitmap(b4a.exampleddd.picturechooser __ref,anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bitmap,String _dir,String _filename,int _quality) throws Exception{
__ref = this;
RDebugUtils.currentModule="picturechooser";
if (Debug.shouldDelegate(ba, "savebitmap"))
	 {return ((String) Debug.delegate(ba, "savebitmap", new Object[] {_bitmap,_dir,_filename,_quality}));}
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _b1 = null;
anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper _out = null;
RDebugUtils.currentLine=2752512;
 //BA.debugLineNum = 2752512;BA.debugLine="Public Sub SaveBitmap(Bitmap As Bitmap,Dir As Stri";
RDebugUtils.currentLine=2752513;
 //BA.debugLineNum = 2752513;BA.debugLine="Dim b1 As Bitmap";
_b1 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=2752514;
 //BA.debugLineNum = 2752514;BA.debugLine="Dim out As OutputStream";
_out = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
RDebugUtils.currentLine=2752515;
 //BA.debugLineNum = 2752515;BA.debugLine="b1 = Bitmap";
_b1 = _bitmap;
RDebugUtils.currentLine=2752516;
 //BA.debugLineNum = 2752516;BA.debugLine="out = File.OpenOutput(Dir,Filename,False)";
_out = __c.File.OpenOutput(_dir,_filename,__c.False);
RDebugUtils.currentLine=2752517;
 //BA.debugLineNum = 2752517;BA.debugLine="b1.WriteToStream(out,Quality,\"JPEG\")";
_b1.WriteToStream((java.io.OutputStream)(_out.getObject()),_quality,BA.getEnumFromString(android.graphics.Bitmap.CompressFormat.class,"JPEG"));
RDebugUtils.currentLine=2752518;
 //BA.debugLineNum = 2752518;BA.debugLine="out.Close";
_out.Close();
RDebugUtils.currentLine=2752519;
 //BA.debugLineNum = 2752519;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper  _fixorientation(b4a.exampleddd.picturechooser __ref,String _dir,String _filename) throws Exception{
__ref = this;
RDebugUtils.currentModule="picturechooser";
if (Debug.shouldDelegate(ba, "fixorientation"))
	 {return ((anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) Debug.delegate(ba, "fixorientation", new Object[] {_dir,_filename}));}
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _temp = null;
float _degree = 0f;
anywheresoftware.b4a.agraham.jpegutils.ExifUtils _exif = null;
RDebugUtils.currentLine=3211264;
 //BA.debugLineNum = 3211264;BA.debugLine="Private Sub FixOrientation(Dir As String,Filename";
RDebugUtils.currentLine=3211266;
 //BA.debugLineNum = 3211266;BA.debugLine="Dim temp As Bitmap";
_temp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=3211267;
 //BA.debugLineNum = 3211267;BA.debugLine="Dim degree As Float";
_degree = 0f;
RDebugUtils.currentLine=3211269;
 //BA.debugLineNum = 3211269;BA.debugLine="Dim exif As ExifData";
_exif = new anywheresoftware.b4a.agraham.jpegutils.ExifUtils();
RDebugUtils.currentLine=3211270;
 //BA.debugLineNum = 3211270;BA.debugLine="exif.Initialize(Dir,Filename)";
_exif.Initialize(_dir,_filename);
RDebugUtils.currentLine=3211272;
 //BA.debugLineNum = 3211272;BA.debugLine="Select exif.getAttribute(exif.TAG_ORIENTATION)";
switch (BA.switchObjectToInt(_exif.getAttribute(_exif.TAG_ORIENTATION),BA.NumberToString(_exif.ORIENTATION_ROTATE_180),BA.NumberToString(_exif.ORIENTATION_ROTATE_270),BA.NumberToString(_exif.ORIENTATION_ROTATE_90))) {
case 0: {
RDebugUtils.currentLine=3211274;
 //BA.debugLineNum = 3211274;BA.debugLine="degree = 180";
_degree = (float) (180);
 break; }
case 1: {
RDebugUtils.currentLine=3211277;
 //BA.debugLineNum = 3211277;BA.debugLine="degree = 270";
_degree = (float) (270);
 break; }
case 2: {
RDebugUtils.currentLine=3211280;
 //BA.debugLineNum = 3211280;BA.debugLine="degree = 90";
_degree = (float) (90);
 break; }
}
;
RDebugUtils.currentLine=3211284;
 //BA.debugLineNum = 3211284;BA.debugLine="temp = LoadBitmap(Dir,Filename)";
_temp = __c.LoadBitmap(_dir,_filename);
RDebugUtils.currentLine=3211286;
 //BA.debugLineNum = 3211286;BA.debugLine="If degree <> 0 Then";
if (_degree!=0) { 
RDebugUtils.currentLine=3211287;
 //BA.debugLineNum = 3211287;BA.debugLine="temp = RotateBitmap(temp,degree)";
_temp = __ref._rotatebitmap(null,_temp,_degree);
 };
RDebugUtils.currentLine=3211290;
 //BA.debugLineNum = 3211290;BA.debugLine="Return temp";
if (true) return _temp;
RDebugUtils.currentLine=3211292;
 //BA.debugLineNum = 3211292;BA.debugLine="End Sub";
return null;
}
public String  _btnmodecamera_click(b4a.exampleddd.picturechooser __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="picturechooser";
if (Debug.shouldDelegate(ba, "btnmodecamera_click"))
	 {return ((String) Debug.delegate(ba, "btnmodecamera_click", null));}
RDebugUtils.currentLine=1310720;
 //BA.debugLineNum = 1310720;BA.debugLine="Private Sub btnmodeCamera_Click";
RDebugUtils.currentLine=1310721;
 //BA.debugLineNum = 1310721;BA.debugLine="IsFrontCamera	=	Not(IsFrontCamera)";
__ref._isfrontcamera = __c.Not(__ref._isfrontcamera);
RDebugUtils.currentLine=1310722;
 //BA.debugLineNum = 1310722;BA.debugLine="End Sub";
return "";
}
public String  _btnrotate_click(b4a.exampleddd.picturechooser __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="picturechooser";
if (Debug.shouldDelegate(ba, "btnrotate_click"))
	 {return ((String) Debug.delegate(ba, "btnrotate_click", null));}
RDebugUtils.currentLine=1638400;
 //BA.debugLineNum = 1638400;BA.debugLine="Private Sub btnrotate_Click";
RDebugUtils.currentLine=1638401;
 //BA.debugLineNum = 1638401;BA.debugLine="CurrentUserBitmap	=	RotateBitmap(CurrentUserBitma";
__ref._currentuserbitmap = __ref._rotatebitmap(null,__ref._currentuserbitmap,(float) (90));
RDebugUtils.currentLine=1638402;
 //BA.debugLineNum = 1638402;BA.debugLine="CV.ImageBitmap		=	CurrentUserBitmap";
__ref._cv.setImageBitmap((android.graphics.Bitmap)(__ref._currentuserbitmap.getObject()));
RDebugUtils.currentLine=1638403;
 //BA.debugLineNum = 1638403;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper  _rotatebitmap(b4a.exampleddd.picturechooser __ref,anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _original,float _degree) throws Exception{
__ref = this;
RDebugUtils.currentModule="picturechooser";
if (Debug.shouldDelegate(ba, "rotatebitmap"))
	 {return ((anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) Debug.delegate(ba, "rotatebitmap", new Object[] {_original,_degree}));}
com.rootsoft.imageprocessing.RSImageProcessing _r = null;
RDebugUtils.currentLine=2555904;
 //BA.debugLineNum = 2555904;BA.debugLine="Public Sub RotateBitmap(Original As Bitmap, Degree";
RDebugUtils.currentLine=2555905;
 //BA.debugLineNum = 2555905;BA.debugLine="Dim r As RSImageProcessing";
_r = new com.rootsoft.imageprocessing.RSImageProcessing();
RDebugUtils.currentLine=2555906;
 //BA.debugLineNum = 2555906;BA.debugLine="r.Initialize";
_r.Initialize();
RDebugUtils.currentLine=2555907;
 //BA.debugLineNum = 2555907;BA.debugLine="Return r.rotate(Original,Degree)";
if (true) return (anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(_r.rotate((android.graphics.Bitmap)(_original.getObject()),_degree)));
RDebugUtils.currentLine=2555908;
 //BA.debugLineNum = 2555908;BA.debugLine="End Sub";
return null;
}
public String  _btntake_click(b4a.exampleddd.picturechooser __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="picturechooser";
if (Debug.shouldDelegate(ba, "btntake_click"))
	 {return ((String) Debug.delegate(ba, "btntake_click", null));}
RDebugUtils.currentLine=1572864;
 //BA.debugLineNum = 1572864;BA.debugLine="Private Sub btntake_Click";
RDebugUtils.currentLine=1572866;
 //BA.debugLineNum = 1572866;BA.debugLine="End Sub";
return "";
}
public String  _cc_result(b4a.exampleddd.picturechooser __ref,boolean _success,String _dir,String _filename) throws Exception{
__ref = this;
RDebugUtils.currentModule="picturechooser";
if (Debug.shouldDelegate(ba, "cc_result"))
	 {return ((String) Debug.delegate(ba, "cc_result", new Object[] {_success,_dir,_filename}));}
anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper _ou = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _temp = null;
RDebugUtils.currentLine=2162688;
 //BA.debugLineNum = 2162688;BA.debugLine="Private Sub cc_Result (Success As Boolean, Dir As";
RDebugUtils.currentLine=2162690;
 //BA.debugLineNum = 2162690;BA.debugLine="If Success Then";
if (_success) { 
RDebugUtils.currentLine=2162692;
 //BA.debugLineNum = 2162692;BA.debugLine="sDir		=	Dir";
__ref._sdir = _dir;
RDebugUtils.currentLine=2162693;
 //BA.debugLineNum = 2162693;BA.debugLine="sFilename	=	FileName";
__ref._sfilename = _filename;
RDebugUtils.currentLine=2162695;
 //BA.debugLineNum = 2162695;BA.debugLine="If is_crop Then";
if (__ref._is_crop) { 
RDebugUtils.currentLine=2162699;
 //BA.debugLineNum = 2162699;BA.debugLine="Try";
try {RDebugUtils.currentLine=2162700;
 //BA.debugLineNum = 2162700;BA.debugLine="SaveBitmap2(LoadBitmap(Dir,FileName),imageFold";
__ref._savebitmap2(null,__c.LoadBitmap(_dir,_filename),__ref._imagefolder,"temp.jpg");
RDebugUtils.currentLine=2162701;
 //BA.debugLineNum = 2162701;BA.debugLine="Crop2(imageFolder,\"temp.jpg\")";
__ref._crop2(null,__ref._imagefolder,"temp.jpg");
RDebugUtils.currentLine=2162702;
 //BA.debugLineNum = 2162702;BA.debugLine="Return";
if (true) return "";
RDebugUtils.currentLine=2162703;
 //BA.debugLineNum = 2162703;BA.debugLine="CV.ImageBitmap		=	LoadBitmapResize(Dir,FileNam";
__ref._cv.setImageBitmap((android.graphics.Bitmap)(__c.LoadBitmapResize(_dir,_filename,__c.PerXToCurrent((float) (150),ba),__c.PerYToCurrent((float) (150),ba),__c.True).getObject()));
RDebugUtils.currentLine=2162704;
 //BA.debugLineNum = 2162704;BA.debugLine="CurrentUserBitmap	=	LoadBitmapResize(Dir,FileN";
__ref._currentuserbitmap = __c.LoadBitmapResize(_dir,_filename,__c.PerXToCurrent((float) (150),ba),__c.PerYToCurrent((float) (150),ba),__c.True);
 } 
       catch (Exception e12) {
			ba.setLastException(e12); };
RDebugUtils.currentLine=2162708;
 //BA.debugLineNum = 2162708;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=2162711;
 //BA.debugLineNum = 2162711;BA.debugLine="Dim ou As OutputStream";
_ou = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
RDebugUtils.currentLine=2162712;
 //BA.debugLineNum = 2162712;BA.debugLine="ou = File.OpenOutput(File.DirInternal,\"temp.jpg\"";
_ou = __c.File.OpenOutput(__c.File.getDirInternal(),"temp.jpg",__c.False);
RDebugUtils.currentLine=2162714;
 //BA.debugLineNum = 2162714;BA.debugLine="Try";
try {RDebugUtils.currentLine=2162715;
 //BA.debugLineNum = 2162715;BA.debugLine="File.Copy2(File.OpenInput(Dir,FileName),ou)";
__c.File.Copy2((java.io.InputStream)(__c.File.OpenInput(_dir,_filename).getObject()),(java.io.OutputStream)(_ou.getObject()));
 } 
       catch (Exception e20) {
			ba.setLastException(e20);RDebugUtils.currentLine=2162717;
 //BA.debugLineNum = 2162717;BA.debugLine="Log(\"not exist file\")";
__c.Log("not exist file");
RDebugUtils.currentLine=2162718;
 //BA.debugLineNum = 2162718;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=2162721;
 //BA.debugLineNum = 2162721;BA.debugLine="ou.Close";
_ou.Close();
RDebugUtils.currentLine=2162723;
 //BA.debugLineNum = 2162723;BA.debugLine="Dim temp As Bitmap";
_temp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=2162724;
 //BA.debugLineNum = 2162724;BA.debugLine="temp = FixOrientation(File.DirInternal,\"temp.jpg";
_temp = __ref._fixorientation(null,__c.File.getDirInternal(),"temp.jpg");
RDebugUtils.currentLine=2162726;
 //BA.debugLineNum = 2162726;BA.debugLine="If SubExists(modue,evt & \"_result2\") Then";
if (__c.SubExists(ba,__ref._modue,__ref._evt+"_result2")) { 
RDebugUtils.currentLine=2162727;
 //BA.debugLineNum = 2162727;BA.debugLine="SaveBitmap(temp,File.DirInternal,\"temp.jpg\",70)";
__ref._savebitmap(null,_temp,__c.File.getDirInternal(),"temp.jpg",(int) (70));
RDebugUtils.currentLine=2162728;
 //BA.debugLineNum = 2162728;BA.debugLine="CallSubDelayed3(modue,evt & \"_Result2\",File.Dir";
__c.CallSubDelayed3(ba,__ref._modue,__ref._evt+"_Result2",(Object)(__c.File.getDirInternal()),(Object)("temp.jpg"));
 }else {
RDebugUtils.currentLine=2162730;
 //BA.debugLineNum = 2162730;BA.debugLine="CallSubDelayed2(modue,evt & \"_result\",temp)";
__c.CallSubDelayed2(ba,__ref._modue,__ref._evt+"_result",(Object)(_temp));
 };
 };
RDebugUtils.currentLine=2162735;
 //BA.debugLineNum = 2162735;BA.debugLine="End Sub";
return "";
}
public String  _savebitmap2(b4a.exampleddd.picturechooser __ref,anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bitmap,String _dir,String _filename) throws Exception{
__ref = this;
RDebugUtils.currentModule="picturechooser";
if (Debug.shouldDelegate(ba, "savebitmap2"))
	 {return ((String) Debug.delegate(ba, "savebitmap2", new Object[] {_bitmap,_dir,_filename}));}
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _b1 = null;
anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper _out = null;
RDebugUtils.currentLine=2883584;
 //BA.debugLineNum = 2883584;BA.debugLine="Public Sub SaveBitmap2(Bitmap As Bitmap,Dir As Str";
RDebugUtils.currentLine=2883585;
 //BA.debugLineNum = 2883585;BA.debugLine="Dim b1 As Bitmap";
_b1 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=2883586;
 //BA.debugLineNum = 2883586;BA.debugLine="Dim out As OutputStream";
_out = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
RDebugUtils.currentLine=2883587;
 //BA.debugLineNum = 2883587;BA.debugLine="b1 = Bitmap";
_b1 = _bitmap;
RDebugUtils.currentLine=2883588;
 //BA.debugLineNum = 2883588;BA.debugLine="out = File.OpenOutput(Dir,Filename,False)";
_out = __c.File.OpenOutput(_dir,_filename,__c.False);
RDebugUtils.currentLine=2883589;
 //BA.debugLineNum = 2883589;BA.debugLine="b1.WriteToStream(out,100,\"PNG\")";
_b1.WriteToStream((java.io.OutputStream)(_out.getObject()),(int) (100),BA.getEnumFromString(android.graphics.Bitmap.CompressFormat.class,"PNG"));
RDebugUtils.currentLine=2883590;
 //BA.debugLineNum = 2883590;BA.debugLine="out.Close";
_out.Close();
RDebugUtils.currentLine=2883591;
 //BA.debugLineNum = 2883591;BA.debugLine="End Sub";
return "";
}
public String  _crop2(b4a.exampleddd.picturechooser __ref,String _dir,String _filename) throws Exception{
__ref = this;
RDebugUtils.currentModule="picturechooser";
if (Debug.shouldDelegate(ba, "crop2"))
	 {return ((String) Debug.delegate(ba, "crop2", new Object[] {_dir,_filename}));}
anywheresoftware.b4a.phone.Phone _p = null;
Object _u = null;
anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper _uri = null;
anywheresoftware.b4a.objects.IntentWrapper _i = null;
RDebugUtils.currentLine=4653056;
 //BA.debugLineNum = 4653056;BA.debugLine="Public Sub Crop2(Dir As String, Filename As String";
RDebugUtils.currentLine=4653058;
 //BA.debugLineNum = 4653058;BA.debugLine="CurrentDirCrop		=	Dir";
__ref._currentdircrop = _dir;
RDebugUtils.currentLine=4653059;
 //BA.debugLineNum = 4653059;BA.debugLine="CurrentFilenameCrop	=	Filename";
__ref._currentfilenamecrop = _filename;
RDebugUtils.currentLine=4653061;
 //BA.debugLineNum = 4653061;BA.debugLine="Dim p As Phone";
_p = new anywheresoftware.b4a.phone.Phone();
RDebugUtils.currentLine=4653062;
 //BA.debugLineNum = 4653062;BA.debugLine="Dim u As Object";
_u = new Object();
RDebugUtils.currentLine=4653063;
 //BA.debugLineNum = 4653063;BA.debugLine="If p.SdkVersion < 24 Then";
if (_p.getSdkVersion()<24) { 
RDebugUtils.currentLine=4653064;
 //BA.debugLineNum = 4653064;BA.debugLine="Dim uri As Uri";
_uri = new anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper();
RDebugUtils.currentLine=4653065;
 //BA.debugLineNum = 4653065;BA.debugLine="uri.Parse(\"file://\" & File.Combine(Dir, Filename";
_uri.Parse("file://"+__c.File.Combine(_dir,_filename));
RDebugUtils.currentLine=4653066;
 //BA.debugLineNum = 4653066;BA.debugLine="u = uri";
_u = (Object)(_uri.getObject());
 }else {
RDebugUtils.currentLine=4653068;
 //BA.debugLineNum = 4653068;BA.debugLine="u = CreateFileProviderUri(Dir, Filename)";
_u = __ref._createfileprovideruri(null,_dir,_filename);
 };
RDebugUtils.currentLine=4653071;
 //BA.debugLineNum = 4653071;BA.debugLine="Dim i As Intent";
_i = new anywheresoftware.b4a.objects.IntentWrapper();
RDebugUtils.currentLine=4653072;
 //BA.debugLineNum = 4653072;BA.debugLine="i.Initialize(\"com.android.camera.action.CROP\",u)";
_i.Initialize("com.android.camera.action.CROP",BA.ObjectToString(_u));
RDebugUtils.currentLine=4653073;
 //BA.debugLineNum = 4653073;BA.debugLine="i.SetType(\"image/*\")";
_i.SetType("image/*");
RDebugUtils.currentLine=4653074;
 //BA.debugLineNum = 4653074;BA.debugLine="i.PutExtra(\"crop\", \"true\")";
_i.PutExtra("crop",(Object)("true"));
RDebugUtils.currentLine=4653076;
 //BA.debugLineNum = 4653076;BA.debugLine="If IsScale Then";
if (__ref._isscale) { 
RDebugUtils.currentLine=4653077;
 //BA.debugLineNum = 4653077;BA.debugLine="i.PutExtra(\"aspectX\", 1)";
_i.PutExtra("aspectX",(Object)(1));
RDebugUtils.currentLine=4653078;
 //BA.debugLineNum = 4653078;BA.debugLine="i.PutExtra(\"aspectY\", 1)";
_i.PutExtra("aspectY",(Object)(1));
 }else {
RDebugUtils.currentLine=4653080;
 //BA.debugLineNum = 4653080;BA.debugLine="i.PutExtra(\"aspectX\", AspectRatioWidth)";
_i.PutExtra("aspectX",(Object)(__ref._aspectratiowidth));
RDebugUtils.currentLine=4653081;
 //BA.debugLineNum = 4653081;BA.debugLine="i.PutExtra(\"aspectY\", AspectRatioHeight)";
_i.PutExtra("aspectY",(Object)(__ref._aspectratioheight));
 };
RDebugUtils.currentLine=4653084;
 //BA.debugLineNum = 4653084;BA.debugLine="If IsScale Then";
if (__ref._isscale) { 
RDebugUtils.currentLine=4653085;
 //BA.debugLineNum = 4653085;BA.debugLine="i.PutExtra(\"scale\", \"true\")";
_i.PutExtra("scale",(Object)("true"));
 }else {
RDebugUtils.currentLine=4653087;
 //BA.debugLineNum = 4653087;BA.debugLine="i.PutExtra(\"scale\", \"false\")";
_i.PutExtra("scale",(Object)("false"));
 };
RDebugUtils.currentLine=4653090;
 //BA.debugLineNum = 4653090;BA.debugLine="i.PutExtra(\"outputX\", AspectRatioWidth)";
_i.PutExtra("outputX",(Object)(__ref._aspectratiowidth));
RDebugUtils.currentLine=4653091;
 //BA.debugLineNum = 4653091;BA.debugLine="i.PutExtra(\"outputY\", AspectRatioHeight)";
_i.PutExtra("outputY",(Object)(__ref._aspectratioheight));
RDebugUtils.currentLine=4653092;
 //BA.debugLineNum = 4653092;BA.debugLine="i.PutExtra(\"output\", u)";
_i.PutExtra("output",_u);
RDebugUtils.currentLine=4653093;
 //BA.debugLineNum = 4653093;BA.debugLine="StartActivityForResult(i,\"crop\")";
__ref._startactivityforresult(null,_i,"crop");
RDebugUtils.currentLine=4653095;
 //BA.debugLineNum = 4653095;BA.debugLine="End Sub";
return "";
}
public boolean  _checkpermissioncamera(b4a.exampleddd.picturechooser __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="picturechooser";
if (Debug.shouldDelegate(ba, "checkpermissioncamera"))
	 {return ((Boolean) Debug.delegate(ba, "checkpermissioncamera", null));}
anywheresoftware.b4a.objects.RuntimePermissions _r = null;
RDebugUtils.currentLine=1376256;
 //BA.debugLineNum = 1376256;BA.debugLine="Public Sub CheckPermissionCamera As Boolean";
RDebugUtils.currentLine=1376258;
 //BA.debugLineNum = 1376258;BA.debugLine="Dim r As RuntimePermissions";
_r = new anywheresoftware.b4a.objects.RuntimePermissions();
RDebugUtils.currentLine=1376259;
 //BA.debugLineNum = 1376259;BA.debugLine="Return r.Check(r.PERMISSION_CAMERA)";
if (true) return _r.Check(_r.PERMISSION_CAMERA);
RDebugUtils.currentLine=1376261;
 //BA.debugLineNum = 1376261;BA.debugLine="End Sub";
return false;
}
public String  _choosefromcamera(b4a.exampleddd.picturechooser __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="picturechooser";
if (Debug.shouldDelegate(ba, "choosefromcamera"))
	 {return ((String) Debug.delegate(ba, "choosefromcamera", null));}
anywheresoftware.b4a.objects.IntentWrapper _i = null;
anywheresoftware.b4a.phone.Phone _p = null;
Object _u = null;
anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper _uri = null;
RDebugUtils.currentLine=1835008;
 //BA.debugLineNum = 1835008;BA.debugLine="Public Sub ChooseFromCamera";
RDebugUtils.currentLine=1835010;
 //BA.debugLineNum = 1835010;BA.debugLine="Dim i As Intent";
_i = new anywheresoftware.b4a.objects.IntentWrapper();
RDebugUtils.currentLine=1835011;
 //BA.debugLineNum = 1835011;BA.debugLine="i.Initialize(\"android.media.action.IMAGE_CAPTURE\"";
_i.Initialize("android.media.action.IMAGE_CAPTURE","");
RDebugUtils.currentLine=1835012;
 //BA.debugLineNum = 1835012;BA.debugLine="File.Delete(imageFolder, tempImageFile)";
__c.File.Delete(__ref._imagefolder,__ref._tempimagefile);
RDebugUtils.currentLine=1835013;
 //BA.debugLineNum = 1835013;BA.debugLine="Dim p As Phone";
_p = new anywheresoftware.b4a.phone.Phone();
RDebugUtils.currentLine=1835014;
 //BA.debugLineNum = 1835014;BA.debugLine="Dim u As Object";
_u = new Object();
RDebugUtils.currentLine=1835015;
 //BA.debugLineNum = 1835015;BA.debugLine="If p.SdkVersion < 24 Then";
if (_p.getSdkVersion()<24) { 
RDebugUtils.currentLine=1835016;
 //BA.debugLineNum = 1835016;BA.debugLine="Dim uri As Uri";
_uri = new anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper();
RDebugUtils.currentLine=1835017;
 //BA.debugLineNum = 1835017;BA.debugLine="uri.Parse(\"file://\" & File.Combine(imageFolder,";
_uri.Parse("file://"+__c.File.Combine(__ref._imagefolder,__ref._tempimagefile));
RDebugUtils.currentLine=1835018;
 //BA.debugLineNum = 1835018;BA.debugLine="u = uri";
_u = (Object)(_uri.getObject());
 }else {
RDebugUtils.currentLine=1835020;
 //BA.debugLineNum = 1835020;BA.debugLine="u = CreateFileProviderUri(imageFolder, tempImage";
_u = __ref._createfileprovideruri(null,__ref._imagefolder,__ref._tempimagefile);
 };
RDebugUtils.currentLine=1835022;
 //BA.debugLineNum = 1835022;BA.debugLine="i.PutExtra(\"output\", u) 'the image will be saved";
_i.PutExtra("output",_u);
RDebugUtils.currentLine=1835023;
 //BA.debugLineNum = 1835023;BA.debugLine="Try";
try {RDebugUtils.currentLine=1835024;
 //BA.debugLineNum = 1835024;BA.debugLine="StartActivityForResult(i,\"ion\")";
__ref._startactivityforresult(null,_i,"ion");
 } 
       catch (Exception e17) {
			ba.setLastException(e17);RDebugUtils.currentLine=1835026;
 //BA.debugLineNum = 1835026;BA.debugLine="ToastMessageShow(\"Camera is not available.\", Tru";
__c.ToastMessageShow(BA.ObjectToCharSequence("Camera is not available."),__c.True);
RDebugUtils.currentLine=1835027;
 //BA.debugLineNum = 1835027;BA.debugLine="Log(LastException)";
__c.Log(BA.ObjectToString(__c.LastException(ba)));
 };
RDebugUtils.currentLine=1835030;
 //BA.debugLineNum = 1835030;BA.debugLine="End Sub";
return "";
}
public Object  _createfileprovideruri(b4a.exampleddd.picturechooser __ref,String _dir,String _filename) throws Exception{
__ref = this;
RDebugUtils.currentModule="picturechooser";
if (Debug.shouldDelegate(ba, "createfileprovideruri"))
	 {return ((Object) Debug.delegate(ba, "createfileprovideruri", new Object[] {_dir,_filename}));}
anywheresoftware.b4j.object.JavaObject _fileprovider = null;
anywheresoftware.b4j.object.JavaObject _context = null;
anywheresoftware.b4j.object.JavaObject _f = null;
RDebugUtils.currentLine=1966080;
 //BA.debugLineNum = 1966080;BA.debugLine="Private Sub CreateFileProviderUri (Dir As String,";
RDebugUtils.currentLine=1966081;
 //BA.debugLineNum = 1966081;BA.debugLine="Dim FileProvider As JavaObject";
_fileprovider = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=1966082;
 //BA.debugLineNum = 1966082;BA.debugLine="Dim context As JavaObject";
_context = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=1966083;
 //BA.debugLineNum = 1966083;BA.debugLine="context.InitializeContext";
_context.InitializeContext(ba);
RDebugUtils.currentLine=1966084;
 //BA.debugLineNum = 1966084;BA.debugLine="FileProvider.InitializeStatic(\"android.support.v4";
_fileprovider.InitializeStatic("android.support.v4.content.FileProvider");
RDebugUtils.currentLine=1966085;
 //BA.debugLineNum = 1966085;BA.debugLine="Dim f As JavaObject";
_f = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=1966086;
 //BA.debugLineNum = 1966086;BA.debugLine="f.InitializeNewInstance(\"java.io.File\", Array(Dir";
_f.InitializeNewInstance("java.io.File",new Object[]{(Object)(_dir),(Object)(_filename)});
RDebugUtils.currentLine=1966087;
 //BA.debugLineNum = 1966087;BA.debugLine="Return FileProvider.RunMethod(\"getUriForFile\", Ar";
if (true) return _fileprovider.RunMethod("getUriForFile",new Object[]{(Object)(_context.getObject()),(Object)(__c.Application.getPackageName()+".provider"),(Object)(_f.getObject())});
RDebugUtils.currentLine=1966088;
 //BA.debugLineNum = 1966088;BA.debugLine="End Sub";
return null;
}
public String  _startactivityforresult(b4a.exampleddd.picturechooser __ref,anywheresoftware.b4a.objects.IntentWrapper _i,String _event) throws Exception{
__ref = this;
RDebugUtils.currentModule="picturechooser";
if (Debug.shouldDelegate(ba, "startactivityforresult"))
	 {return ((String) Debug.delegate(ba, "startactivityforresult", new Object[] {_i,_event}));}
anywheresoftware.b4j.object.JavaObject _jo = null;
RDebugUtils.currentLine=2031616;
 //BA.debugLineNum = 2031616;BA.debugLine="Private Sub StartActivityForResult(i As Intent,Eve";
RDebugUtils.currentLine=2031617;
 //BA.debugLineNum = 2031617;BA.debugLine="Dim jo As JavaObject = GetBA";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo.setObject((java.lang.Object)(__ref._getba(null)));
RDebugUtils.currentLine=2031618;
 //BA.debugLineNum = 2031618;BA.debugLine="ion = jo.CreateEvent(\"anywheresoftware.b4a.IOnAct";
__ref._ion = _jo.CreateEvent(ba,"anywheresoftware.b4a.IOnActivityResult",_event,__c.Null);
RDebugUtils.currentLine=2031619;
 //BA.debugLineNum = 2031619;BA.debugLine="jo.RunMethod(\"startActivityForResult\", Array As O";
_jo.RunMethod("startActivityForResult",new Object[]{__ref._ion,(Object)(_i.getObject())});
RDebugUtils.currentLine=2031620;
 //BA.debugLineNum = 2031620;BA.debugLine="End Sub";
return "";
}
public String  _class_globals(b4a.exampleddd.picturechooser __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="picturechooser";
RDebugUtils.currentLine=589824;
 //BA.debugLineNum = 589824;BA.debugLine="Private Sub Class_Globals";
RDebugUtils.currentLine=589825;
 //BA.debugLineNum = 589825;BA.debugLine="Private ion As Object";
_ion = new Object();
RDebugUtils.currentLine=589826;
 //BA.debugLineNum = 589826;BA.debugLine="Private imageFolder As String";
_imagefolder = "";
RDebugUtils.currentLine=589827;
 //BA.debugLineNum = 589827;BA.debugLine="Private IsFrontCamera As Boolean";
_isfrontcamera = false;
RDebugUtils.currentLine=589828;
 //BA.debugLineNum = 589828;BA.debugLine="Private tempImageFile As String";
_tempimagefile = "";
RDebugUtils.currentLine=589829;
 //BA.debugLineNum = 589829;BA.debugLine="Private chooser As ContentChooser";
_chooser = new anywheresoftware.b4a.phone.Phone.ContentChooser();
RDebugUtils.currentLine=589830;
 //BA.debugLineNum = 589830;BA.debugLine="Private modue As Object";
_modue = new Object();
RDebugUtils.currentLine=589831;
 //BA.debugLineNum = 589831;BA.debugLine="Private evt As String";
_evt = "";
RDebugUtils.currentLine=589832;
 //BA.debugLineNum = 589832;BA.debugLine="Private sDir,sFilename As String";
_sdir = "";
_sfilename = "";
RDebugUtils.currentLine=589833;
 //BA.debugLineNum = 589833;BA.debugLine="Private is_crop As Boolean";
_is_crop = false;
RDebugUtils.currentLine=589834;
 //BA.debugLineNum = 589834;BA.debugLine="Private p2 As Panel";
_p2 = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=589835;
 //BA.debugLineNum = 589835;BA.debugLine="Private CV As CropImageView";
_cv = new de.donmanfred.CropImageViewWrapper();
RDebugUtils.currentLine=589836;
 //BA.debugLineNum = 589836;BA.debugLine="Private btnrotate As Button";
_btnrotate = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=589837;
 //BA.debugLineNum = 589837;BA.debugLine="Private rotate_title As String : rotate_title = \"";
_rotate_title = "";
RDebugUtils.currentLine=589837;
 //BA.debugLineNum = 589837;BA.debugLine="Private rotate_title As String : rotate_title = \"";
__ref._rotate_title = "بچرخون";
RDebugUtils.currentLine=589838;
 //BA.debugLineNum = 589838;BA.debugLine="Private crop_title As String : crop_title = \"کراپ";
_crop_title = "";
RDebugUtils.currentLine=589838;
 //BA.debugLineNum = 589838;BA.debugLine="Private crop_title As String : crop_title = \"کراپ";
__ref._crop_title = "کراپ";
RDebugUtils.currentLine=589839;
 //BA.debugLineNum = 589839;BA.debugLine="Private cancel_title As String : cancel_title = \"";
_cancel_title = "";
RDebugUtils.currentLine=589839;
 //BA.debugLineNum = 589839;BA.debugLine="Private cancel_title As String : cancel_title = \"";
__ref._cancel_title = "بیخیال";
RDebugUtils.currentLine=589840;
 //BA.debugLineNum = 589840;BA.debugLine="Private b As Button";
_b = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=589841;
 //BA.debugLineNum = 589841;BA.debugLine="Private quality2 As Int : quality2 = 60";
_quality2 = 0;
RDebugUtils.currentLine=589841;
 //BA.debugLineNum = 589841;BA.debugLine="Private quality2 As Int : quality2 = 60";
__ref._quality2 = (int) (60);
RDebugUtils.currentLine=589842;
 //BA.debugLineNum = 589842;BA.debugLine="Private cancel As Button";
_cancel = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=589843;
 //BA.debugLineNum = 589843;BA.debugLine="Private Chooser_Title As String : Chooser_Title	=";
_chooser_title = "";
RDebugUtils.currentLine=589843;
 //BA.debugLineNum = 589843;BA.debugLine="Private Chooser_Title As String : Chooser_Title	=";
__ref._chooser_title = "انتخاب تصویر";
RDebugUtils.currentLine=589844;
 //BA.debugLineNum = 589844;BA.debugLine="Private CurrentUserBitmap As Bitmap";
_currentuserbitmap = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=589845;
 //BA.debugLineNum = 589845;BA.debugLine="Private rp As RuntimePermissions";
_rp = new anywheresoftware.b4a.objects.RuntimePermissions();
RDebugUtils.currentLine=589846;
 //BA.debugLineNum = 589846;BA.debugLine="Private CurrentDirCrop,CurrentFilenameCrop As Str";
_currentdircrop = "";
_currentfilenamecrop = "";
RDebugUtils.currentLine=589847;
 //BA.debugLineNum = 589847;BA.debugLine="Private AspectRatioWidth,AspectRatioHeight As Int";
_aspectratiowidth = 0;
_aspectratioheight = 0;
RDebugUtils.currentLine=589848;
 //BA.debugLineNum = 589848;BA.debugLine="Private IsScale as Boolean";
_isscale = false;
RDebugUtils.currentLine=589849;
 //BA.debugLineNum = 589849;BA.debugLine="End Sub";
return "";
}
public String  _close(b4a.exampleddd.picturechooser __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="picturechooser";
if (Debug.shouldDelegate(ba, "close"))
	 {return ((String) Debug.delegate(ba, "close", null));}
RDebugUtils.currentLine=786432;
 //BA.debugLineNum = 786432;BA.debugLine="Public Sub Close";
RDebugUtils.currentLine=786433;
 //BA.debugLineNum = 786433;BA.debugLine="btncancel_Click";
__ref._btncancel_click(null);
RDebugUtils.currentLine=786434;
 //BA.debugLineNum = 786434;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.drawable.CanvasWrapper  _createbitmap(b4a.exampleddd.picturechooser __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="picturechooser";
if (Debug.shouldDelegate(ba, "createbitmap"))
	 {return ((anywheresoftware.b4a.objects.drawable.CanvasWrapper) Debug.delegate(ba, "createbitmap", null));}
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bmp = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper _cvs = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper _r = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.PathWrapper _p = null;
anywheresoftware.b4j.object.JavaObject _jo = null;
float _x = 0f;
float _y = 0f;
float _radius = 0f;
RDebugUtils.currentLine=3080192;
 //BA.debugLineNum = 3080192;BA.debugLine="Private Sub CreateBitmap As Canvas";
RDebugUtils.currentLine=3080193;
 //BA.debugLineNum = 3080193;BA.debugLine="Dim bmp As Bitmap";
_bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=3080194;
 //BA.debugLineNum = 3080194;BA.debugLine="bmp.InitializeMutable(200dip, 200dip)";
_bmp.InitializeMutable(__c.DipToCurrent((int) (200)),__c.DipToCurrent((int) (200)));
RDebugUtils.currentLine=3080195;
 //BA.debugLineNum = 3080195;BA.debugLine="Dim cvs As Canvas";
_cvs = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
RDebugUtils.currentLine=3080196;
 //BA.debugLineNum = 3080196;BA.debugLine="cvs.Initialize2(bmp)";
_cvs.Initialize2((android.graphics.Bitmap)(_bmp.getObject()));
RDebugUtils.currentLine=3080197;
 //BA.debugLineNum = 3080197;BA.debugLine="Dim r As Rect";
_r = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper();
RDebugUtils.currentLine=3080198;
 //BA.debugLineNum = 3080198;BA.debugLine="r.Initialize(0, 0, bmp.Width, bmp.Height)";
_r.Initialize((int) (0),(int) (0),_bmp.getWidth(),_bmp.getHeight());
RDebugUtils.currentLine=3080199;
 //BA.debugLineNum = 3080199;BA.debugLine="cvs.DrawRect(r, Colors.Transparent, True, 0)";
_cvs.DrawRect((android.graphics.Rect)(_r.getObject()),__c.Colors.Transparent,__c.True,(float) (0));
RDebugUtils.currentLine=3080200;
 //BA.debugLineNum = 3080200;BA.debugLine="Dim p As Path";
_p = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.PathWrapper();
RDebugUtils.currentLine=3080201;
 //BA.debugLineNum = 3080201;BA.debugLine="p.Initialize(0, 0)";
_p.Initialize((float) (0),(float) (0));
RDebugUtils.currentLine=3080202;
 //BA.debugLineNum = 3080202;BA.debugLine="Dim jo As JavaObject = p";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo.setObject((java.lang.Object)(_p.getObject()));
RDebugUtils.currentLine=3080203;
 //BA.debugLineNum = 3080203;BA.debugLine="Dim x = 100dip, y = 100dip, radius = 100dip As Fl";
_x = (float) (__c.DipToCurrent((int) (100)));
_y = (float) (__c.DipToCurrent((int) (100)));
_radius = (float) (__c.DipToCurrent((int) (100)));
RDebugUtils.currentLine=3080204;
 //BA.debugLineNum = 3080204;BA.debugLine="jo.RunMethod(\"addCircle\", Array As Object(x, y, r";
_jo.RunMethod("addCircle",new Object[]{(Object)(_x),(Object)(_y),(Object)(_radius),(Object)("CW")});
RDebugUtils.currentLine=3080205;
 //BA.debugLineNum = 3080205;BA.debugLine="cvs.ClipPath(p)";
_cvs.ClipPath((android.graphics.Path)(_p.getObject()));
RDebugUtils.currentLine=3080206;
 //BA.debugLineNum = 3080206;BA.debugLine="Return cvs";
if (true) return _cvs;
RDebugUtils.currentLine=3080207;
 //BA.debugLineNum = 3080207;BA.debugLine="End Sub";
return null;
}
public Object  _crop_event(b4a.exampleddd.picturechooser __ref,String _methodname,Object[] _args) throws Exception{
__ref = this;
RDebugUtils.currentModule="picturechooser";
if (Debug.shouldDelegate(ba, "crop_event"))
	 {return ((Object) Debug.delegate(ba, "crop_event", new Object[] {_methodname,_args}));}
RDebugUtils.currentLine=4587520;
 //BA.debugLineNum = 4587520;BA.debugLine="Private Sub crop_Event (MethodName As String, Args";
RDebugUtils.currentLine=4587522;
 //BA.debugLineNum = 4587522;BA.debugLine="If Args = Null Then Return Null";
if (_args== null) { 
if (true) return __c.Null;};
RDebugUtils.currentLine=4587523;
 //BA.debugLineNum = 4587523;BA.debugLine="If Args.Length = 0 Then Return Null";
if (_args.length==0) { 
if (true) return __c.Null;};
RDebugUtils.currentLine=4587525;
 //BA.debugLineNum = 4587525;BA.debugLine="If Args(0) = -1 Then";
if ((_args[(int) (0)]).equals((Object)(-1))) { 
RDebugUtils.currentLine=4587526;
 //BA.debugLineNum = 4587526;BA.debugLine="If SubExists(modue,evt & \"_Result2\") Then";
if (__c.SubExists(ba,__ref._modue,__ref._evt+"_Result2")) { 
RDebugUtils.currentLine=4587527;
 //BA.debugLineNum = 4587527;BA.debugLine="CallSub3(modue,evt & \"_Result2\",CurrentDirCrop,";
__c.CallSubNew3(ba,__ref._modue,__ref._evt+"_Result2",(Object)(__ref._currentdircrop),(Object)(__ref._currentfilenamecrop));
 }else {
RDebugUtils.currentLine=4587530;
 //BA.debugLineNum = 4587530;BA.debugLine="CallSubDelayed2(modue,evt & \"_result\",FixOrient";
__c.CallSubDelayed2(ba,__ref._modue,__ref._evt+"_result",(Object)(__ref._fixorientation(null,__ref._currentdircrop,__ref._currentfilenamecrop)));
 };
 };
RDebugUtils.currentLine=4587535;
 //BA.debugLineNum = 4587535;BA.debugLine="Return Null";
if (true) return __c.Null;
RDebugUtils.currentLine=4587537;
 //BA.debugLineNum = 4587537;BA.debugLine="End Sub";
return null;
}
public String  _drawroundbitmap(b4a.exampleddd.picturechooser __ref,anywheresoftware.b4a.objects.drawable.CanvasWrapper _cvs,anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bmp) throws Exception{
__ref = this;
RDebugUtils.currentModule="picturechooser";
if (Debug.shouldDelegate(ba, "drawroundbitmap"))
	 {return ((String) Debug.delegate(ba, "drawroundbitmap", new Object[] {_cvs,_bmp}));}
anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper _r = null;
RDebugUtils.currentLine=3145728;
 //BA.debugLineNum = 3145728;BA.debugLine="Private Sub DrawRoundBitmap (cvs As Canvas, bmp As";
RDebugUtils.currentLine=3145729;
 //BA.debugLineNum = 3145729;BA.debugLine="Dim r As Rect";
_r = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper();
RDebugUtils.currentLine=3145730;
 //BA.debugLineNum = 3145730;BA.debugLine="r.Initialize(0, 0, cvs.Bitmap.Width, cvs.Bitmap.H";
_r.Initialize((int) (0),(int) (0),_cvs.getBitmap().getWidth(),_cvs.getBitmap().getHeight());
RDebugUtils.currentLine=3145731;
 //BA.debugLineNum = 3145731;BA.debugLine="cvs.DrawBitmap(bmp, Null, r)";
_cvs.DrawBitmap((android.graphics.Bitmap)(_bmp.getObject()),(android.graphics.Rect)(__c.Null),(android.graphics.Rect)(_r.getObject()));
RDebugUtils.currentLine=3145732;
 //BA.debugLineNum = 3145732;BA.debugLine="End Sub";
return "";
}
public Object  _getba(b4a.exampleddd.picturechooser __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="picturechooser";
if (Debug.shouldDelegate(ba, "getba"))
	 {return ((Object) Debug.delegate(ba, "getba", null));}
anywheresoftware.b4j.object.JavaObject _jo = null;
String _cls = "";
RDebugUtils.currentLine=2097152;
 //BA.debugLineNum = 2097152;BA.debugLine="Private Sub GetBA As Object";
RDebugUtils.currentLine=2097153;
 //BA.debugLineNum = 2097153;BA.debugLine="Dim jo As JavaObject";
_jo = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=2097154;
 //BA.debugLineNum = 2097154;BA.debugLine="Dim cls As String = Me";
_cls = BA.ObjectToString(this);
RDebugUtils.currentLine=2097155;
 //BA.debugLineNum = 2097155;BA.debugLine="cls = cls.SubString(\"class \".Length)";
_cls = _cls.substring("class ".length());
RDebugUtils.currentLine=2097156;
 //BA.debugLineNum = 2097156;BA.debugLine="jo.InitializeContext";
_jo.InitializeContext(ba);
RDebugUtils.currentLine=2097157;
 //BA.debugLineNum = 2097157;BA.debugLine="Return jo.GetField(\"processBA\")";
if (true) return _jo.GetField("processBA");
RDebugUtils.currentLine=2097158;
 //BA.debugLineNum = 2097158;BA.debugLine="End Sub";
return null;
}
public String  _getdir(b4a.exampleddd.picturechooser __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="picturechooser";
if (Debug.shouldDelegate(ba, "getdir"))
	 {return ((String) Debug.delegate(ba, "getdir", null));}
RDebugUtils.currentLine=2424832;
 //BA.debugLineNum = 2424832;BA.debugLine="Public Sub getDir As String";
RDebugUtils.currentLine=2424833;
 //BA.debugLineNum = 2424833;BA.debugLine="Return sDir";
if (true) return __ref._sdir;
RDebugUtils.currentLine=2424834;
 //BA.debugLineNum = 2424834;BA.debugLine="End Sub";
return "";
}
public String  _getfilename(b4a.exampleddd.picturechooser __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="picturechooser";
if (Debug.shouldDelegate(ba, "getfilename"))
	 {return ((String) Debug.delegate(ba, "getfilename", null));}
RDebugUtils.currentLine=2490368;
 //BA.debugLineNum = 2490368;BA.debugLine="Public Sub getFilename As String";
RDebugUtils.currentLine=2490369;
 //BA.debugLineNum = 2490369;BA.debugLine="Return sFilename";
if (true) return __ref._sfilename;
RDebugUtils.currentLine=2490370;
 //BA.debugLineNum = 2490370;BA.debugLine="End Sub";
return "";
}
public boolean  _getvisible(b4a.exampleddd.picturechooser __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="picturechooser";
if (Debug.shouldDelegate(ba, "getvisible"))
	 {return ((Boolean) Debug.delegate(ba, "getvisible", null));}
RDebugUtils.currentLine=983040;
 //BA.debugLineNum = 983040;BA.debugLine="Public Sub getVisible As Boolean";
RDebugUtils.currentLine=983041;
 //BA.debugLineNum = 983041;BA.debugLine="If p2.IsInitialized = False Then Return False";
if (__ref._p2.IsInitialized()==__c.False) { 
if (true) return __c.False;};
RDebugUtils.currentLine=983042;
 //BA.debugLineNum = 983042;BA.debugLine="Return p2.Visible";
if (true) return __ref._p2.getVisible();
RDebugUtils.currentLine=983043;
 //BA.debugLineNum = 983043;BA.debugLine="End Sub";
return false;
}
public String  _gpu_picturetaken(b4a.exampleddd.picturechooser __ref,byte[] _data) throws Exception{
__ref = this;
RDebugUtils.currentModule="picturechooser";
if (Debug.shouldDelegate(ba, "gpu_picturetaken"))
	 {return ((String) Debug.delegate(ba, "gpu_picturetaken", new Object[] {_data}));}
anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper _ou = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _b2 = null;
RDebugUtils.currentLine=1703936;
 //BA.debugLineNum = 1703936;BA.debugLine="Private Sub gpu_PictureTaken (Data() As Byte)";
RDebugUtils.currentLine=1703938;
 //BA.debugLineNum = 1703938;BA.debugLine="Dim ou As OutputStream";
_ou = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
RDebugUtils.currentLine=1703939;
 //BA.debugLineNum = 1703939;BA.debugLine="ou = File.OpenOutput(File.DirInternal,\"temp.jpg\",";
_ou = __c.File.OpenOutput(__c.File.getDirInternal(),"temp.jpg",__c.False);
RDebugUtils.currentLine=1703940;
 //BA.debugLineNum = 1703940;BA.debugLine="ou.WriteBytes(Data,0,Data.Length)";
_ou.WriteBytes(_data,(int) (0),_data.length);
RDebugUtils.currentLine=1703941;
 //BA.debugLineNum = 1703941;BA.debugLine="ou.Close";
_ou.Close();
RDebugUtils.currentLine=1703943;
 //BA.debugLineNum = 1703943;BA.debugLine="Dim b2 As Bitmap";
_b2 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=1703944;
 //BA.debugLineNum = 1703944;BA.debugLine="b2.InitializeResize(File.DirInternal,\"temp.jpg\",1";
_b2.InitializeResize(__c.File.getDirInternal(),"temp.jpg",__c.PerXToCurrent((float) (150),ba),__c.PerYToCurrent((float) (150),ba),__c.True);
RDebugUtils.currentLine=1703946;
 //BA.debugLineNum = 1703946;BA.debugLine="If IsFrontCamera = False Then";
if (__ref._isfrontcamera==__c.False) { 
RDebugUtils.currentLine=1703947;
 //BA.debugLineNum = 1703947;BA.debugLine="b2	=	RotateBitmap(b2,90)";
_b2 = __ref._rotatebitmap(null,_b2,(float) (90));
 }else {
RDebugUtils.currentLine=1703949;
 //BA.debugLineNum = 1703949;BA.debugLine="b2	=	RotateBitmap(b2,270)";
_b2 = __ref._rotatebitmap(null,_b2,(float) (270));
 };
RDebugUtils.currentLine=1703952;
 //BA.debugLineNum = 1703952;BA.debugLine="If is_crop Then";
if (__ref._is_crop) { 
RDebugUtils.currentLine=1703954;
 //BA.debugLineNum = 1703954;BA.debugLine="p2.Visible = True";
__ref._p2.setVisible(__c.True);
RDebugUtils.currentLine=1703956;
 //BA.debugLineNum = 1703956;BA.debugLine="CurrentUserBitmap	=	b2";
__ref._currentuserbitmap = _b2;
RDebugUtils.currentLine=1703957;
 //BA.debugLineNum = 1703957;BA.debugLine="CV.ImageBitmap		=	b2";
__ref._cv.setImageBitmap((android.graphics.Bitmap)(_b2.getObject()));
RDebugUtils.currentLine=1703959;
 //BA.debugLineNum = 1703959;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=1703963;
 //BA.debugLineNum = 1703963;BA.debugLine="If SubExists(modue,evt & \"_result2\") Then";
if (__c.SubExists(ba,__ref._modue,__ref._evt+"_result2")) { 
RDebugUtils.currentLine=1703964;
 //BA.debugLineNum = 1703964;BA.debugLine="CallSubDelayed3(modue,evt & \"_Result2\",File.DirI";
__c.CallSubDelayed3(ba,__ref._modue,__ref._evt+"_Result2",(Object)(__c.File.getDirInternal()),(Object)("temp.jpg"));
 }else {
RDebugUtils.currentLine=1703966;
 //BA.debugLineNum = 1703966;BA.debugLine="CallSubDelayed2(modue,evt & \"_result\",LoadBitmap";
__c.CallSubDelayed2(ba,__ref._modue,__ref._evt+"_result",(Object)(__c.LoadBitmap(__c.File.getDirInternal(),"temp.jpg")));
 };
RDebugUtils.currentLine=1703969;
 //BA.debugLineNum = 1703969;BA.debugLine="End Sub";
return "";
}
public Object  _ion_event(b4a.exampleddd.picturechooser __ref,String _methodname,Object[] _args) throws Exception{
__ref = this;
RDebugUtils.currentModule="picturechooser";
if (Debug.shouldDelegate(ba, "ion_event"))
	 {return ((Object) Debug.delegate(ba, "ion_event", new Object[] {_methodname,_args}));}
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _lastpicture = null;
anywheresoftware.b4a.objects.IntentWrapper _in = null;
anywheresoftware.b4j.object.JavaObject _jo = null;
RDebugUtils.currentLine=1900544;
 //BA.debugLineNum = 1900544;BA.debugLine="Private Sub ion_Event (MethodName As String, Args(";
RDebugUtils.currentLine=1900546;
 //BA.debugLineNum = 1900546;BA.debugLine="Dim lastPicture As Bitmap";
_lastpicture = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=1900548;
 //BA.debugLineNum = 1900548;BA.debugLine="If Args.Length > 0 Then";
if (_args.length>0) { 
RDebugUtils.currentLine=1900549;
 //BA.debugLineNum = 1900549;BA.debugLine="If Args(1) = Null Then Return Null";
if (_args[(int) (1)]== null) { 
if (true) return __c.Null;};
 };
RDebugUtils.currentLine=1900552;
 //BA.debugLineNum = 1900552;BA.debugLine="If Args.Length = 0 Then Return Null";
if (_args.length==0) { 
if (true) return __c.Null;};
RDebugUtils.currentLine=1900554;
 //BA.debugLineNum = 1900554;BA.debugLine="If Args(0) = -1 Then";
if ((_args[(int) (0)]).equals((Object)(-1))) { 
RDebugUtils.currentLine=1900555;
 //BA.debugLineNum = 1900555;BA.debugLine="Try";
try {RDebugUtils.currentLine=1900556;
 //BA.debugLineNum = 1900556;BA.debugLine="Dim in As Intent = Args(1)";
_in = new anywheresoftware.b4a.objects.IntentWrapper();
_in.setObject((android.content.Intent)(_args[(int) (1)]));
RDebugUtils.currentLine=1900557;
 //BA.debugLineNum = 1900557;BA.debugLine="If File.Exists(imageFolder, tempImageFile) Then";
if (__c.File.Exists(__ref._imagefolder,__ref._tempimagefile)) { 
RDebugUtils.currentLine=1900558;
 //BA.debugLineNum = 1900558;BA.debugLine="lastPicture = LoadBitmap(imageFolder, tempImag";
_lastpicture = __c.LoadBitmap(__ref._imagefolder,__ref._tempimagefile);
 }else 
{RDebugUtils.currentLine=1900559;
 //BA.debugLineNum = 1900559;BA.debugLine="Else If in.HasExtra(\"data\") Then 'try to get th";
if (_in.HasExtra("data")) { 
RDebugUtils.currentLine=1900560;
 //BA.debugLineNum = 1900560;BA.debugLine="Dim jo As JavaObject = in";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo.setObject((java.lang.Object)(_in.getObject()));
RDebugUtils.currentLine=1900561;
 //BA.debugLineNum = 1900561;BA.debugLine="lastPicture = jo.RunMethodJO(\"getExtras\", Null";
_lastpicture.setObject((android.graphics.Bitmap)(_jo.RunMethodJO("getExtras",(Object[])(__c.Null)).RunMethod("get",new Object[]{(Object)("data")})));
 }}
;
 } 
       catch (Exception e16) {
			ba.setLastException(e16);RDebugUtils.currentLine=1900564;
 //BA.debugLineNum = 1900564;BA.debugLine="Return Null";
if (true) return __c.Null;
 };
RDebugUtils.currentLine=1900567;
 //BA.debugLineNum = 1900567;BA.debugLine="If is_crop Then";
if (__ref._is_crop) { 
RDebugUtils.currentLine=1900569;
 //BA.debugLineNum = 1900569;BA.debugLine="p2.Visible = True";
__ref._p2.setVisible(__c.True);
RDebugUtils.currentLine=1900570;
 //BA.debugLineNum = 1900570;BA.debugLine="p2.BringToFront";
__ref._p2.BringToFront();
RDebugUtils.currentLine=1900571;
 //BA.debugLineNum = 1900571;BA.debugLine="Try";
try {RDebugUtils.currentLine=1900572;
 //BA.debugLineNum = 1900572;BA.debugLine="CV.ImageBitmap		=	lastPicture.Resize(150%x,150";
__ref._cv.setImageBitmap((android.graphics.Bitmap)(_lastpicture.Resize((float) (__c.PerXToCurrent((float) (150),ba)),(float) (__c.PerYToCurrent((float) (150),ba)),__c.True).getObject()));
RDebugUtils.currentLine=1900573;
 //BA.debugLineNum = 1900573;BA.debugLine="CurrentUserBitmap	=	lastPicture.Resize(150%x,1";
__ref._currentuserbitmap = _lastpicture.Resize((float) (__c.PerXToCurrent((float) (150),ba)),(float) (__c.PerYToCurrent((float) (150),ba)),__c.True);
 } 
       catch (Exception e25) {
			ba.setLastException(e25);RDebugUtils.currentLine=1900575;
 //BA.debugLineNum = 1900575;BA.debugLine="Return Null";
if (true) return __c.Null;
 };
RDebugUtils.currentLine=1900577;
 //BA.debugLineNum = 1900577;BA.debugLine="Return Null";
if (true) return __c.Null;
 };
 };
RDebugUtils.currentLine=1900581;
 //BA.debugLineNum = 1900581;BA.debugLine="Return Null";
if (true) return __c.Null;
RDebugUtils.currentLine=1900582;
 //BA.debugLineNum = 1900582;BA.debugLine="End Sub";
return null;
}
public String  _p2panel_click(b4a.exampleddd.picturechooser __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="picturechooser";
if (Debug.shouldDelegate(ba, "p2panel_click"))
	 {return ((String) Debug.delegate(ba, "p2panel_click", null));}
RDebugUtils.currentLine=720896;
 //BA.debugLineNum = 720896;BA.debugLine="Private Sub p2Panel_Click";
RDebugUtils.currentLine=720898;
 //BA.debugLineNum = 720898;BA.debugLine="End Sub";
return "";
}
public boolean  _requestpermissioncamera(b4a.exampleddd.picturechooser __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="picturechooser";
if (Debug.shouldDelegate(ba, "requestpermissioncamera"))
	 {return ((Boolean) Debug.delegate(ba, "requestpermissioncamera", null));}
anywheresoftware.b4a.objects.RuntimePermissions _r = null;
RDebugUtils.currentLine=1441792;
 //BA.debugLineNum = 1441792;BA.debugLine="Public Sub RequestPermissionCamera As Boolean";
RDebugUtils.currentLine=1441794;
 //BA.debugLineNum = 1441794;BA.debugLine="Dim r As RuntimePermissions";
_r = new anywheresoftware.b4a.objects.RuntimePermissions();
RDebugUtils.currentLine=1441795;
 //BA.debugLineNum = 1441795;BA.debugLine="r.CheckAndRequest(r.PERMISSION_CAMERA)";
_r.CheckAndRequest(ba,_r.PERMISSION_CAMERA);
RDebugUtils.currentLine=1441797;
 //BA.debugLineNum = 1441797;BA.debugLine="End Sub";
return false;
}
public anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper  _resizebitmap(b4a.exampleddd.picturechooser __ref,anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _original,int _width,int _height) throws Exception{
__ref = this;
RDebugUtils.currentModule="picturechooser";
if (Debug.shouldDelegate(ba, "resizebitmap"))
	 {return ((anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) Debug.delegate(ba, "resizebitmap", new Object[] {_original,_width,_height}));}
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _new = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper _c = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper _destrect = null;
RDebugUtils.currentLine=2621440;
 //BA.debugLineNum = 2621440;BA.debugLine="Public Sub ResizeBitmap(Original As Bitmap, Width";
RDebugUtils.currentLine=2621441;
 //BA.debugLineNum = 2621441;BA.debugLine="Dim new As Bitmap";
_new = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=2621442;
 //BA.debugLineNum = 2621442;BA.debugLine="new.InitializeMutable(Width, Height)";
_new.InitializeMutable(_width,_height);
RDebugUtils.currentLine=2621443;
 //BA.debugLineNum = 2621443;BA.debugLine="Dim c As Canvas";
_c = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
RDebugUtils.currentLine=2621444;
 //BA.debugLineNum = 2621444;BA.debugLine="c.Initialize2(new)";
_c.Initialize2((android.graphics.Bitmap)(_new.getObject()));
RDebugUtils.currentLine=2621445;
 //BA.debugLineNum = 2621445;BA.debugLine="Dim destRect As Rect";
_destrect = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper();
RDebugUtils.currentLine=2621446;
 //BA.debugLineNum = 2621446;BA.debugLine="destRect.Initialize(0, 0, Width, Height)";
_destrect.Initialize((int) (0),(int) (0),_width,_height);
RDebugUtils.currentLine=2621447;
 //BA.debugLineNum = 2621447;BA.debugLine="c.DrawBitmap(Original, Null, destRect)";
_c.DrawBitmap((android.graphics.Bitmap)(_original.getObject()),(android.graphics.Rect)(__c.Null),(android.graphics.Rect)(_destrect.getObject()));
RDebugUtils.currentLine=2621448;
 //BA.debugLineNum = 2621448;BA.debugLine="Return new";
if (true) return _new;
RDebugUtils.currentLine=2621449;
 //BA.debugLineNum = 2621449;BA.debugLine="End Sub";
return null;
}
public String  _resizepicture(b4a.exampleddd.picturechooser __ref,String _dir,String _filename,String _outputfilename,int _width,int _height) throws Exception{
__ref = this;
RDebugUtils.currentModule="picturechooser";
if (Debug.shouldDelegate(ba, "resizepicture"))
	 {return ((String) Debug.delegate(ba, "resizepicture", new Object[] {_dir,_filename,_outputfilename,_width,_height}));}
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _new = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _original = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper _c = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper _destrect = null;
RDebugUtils.currentLine=2686976;
 //BA.debugLineNum = 2686976;BA.debugLine="Public Sub ResizePicture(Dir As String, Filename A";
RDebugUtils.currentLine=2686977;
 //BA.debugLineNum = 2686977;BA.debugLine="Dim new,Original As Bitmap";
_new = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
_original = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=2686978;
 //BA.debugLineNum = 2686978;BA.debugLine="Original = LoadBitmap(Dir,Filename)";
_original = __c.LoadBitmap(_dir,_filename);
RDebugUtils.currentLine=2686979;
 //BA.debugLineNum = 2686979;BA.debugLine="new.InitializeMutable(Width, Height)";
_new.InitializeMutable(_width,_height);
RDebugUtils.currentLine=2686980;
 //BA.debugLineNum = 2686980;BA.debugLine="Dim c As Canvas";
_c = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
RDebugUtils.currentLine=2686981;
 //BA.debugLineNum = 2686981;BA.debugLine="c.Initialize2(new)";
_c.Initialize2((android.graphics.Bitmap)(_new.getObject()));
RDebugUtils.currentLine=2686982;
 //BA.debugLineNum = 2686982;BA.debugLine="Dim destRect As Rect";
_destrect = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper();
RDebugUtils.currentLine=2686983;
 //BA.debugLineNum = 2686983;BA.debugLine="destRect.Initialize(0, 0, Width, Height)";
_destrect.Initialize((int) (0),(int) (0),_width,_height);
RDebugUtils.currentLine=2686984;
 //BA.debugLineNum = 2686984;BA.debugLine="c.DrawBitmap(Original, Null, destRect)";
_c.DrawBitmap((android.graphics.Bitmap)(_original.getObject()),(android.graphics.Rect)(__c.Null),(android.graphics.Rect)(_destrect.getObject()));
RDebugUtils.currentLine=2686985;
 //BA.debugLineNum = 2686985;BA.debugLine="SaveBitmap(new,Dir,OutputFilename,70)";
__ref._savebitmap(null,_new,_dir,_outputfilename,(int) (70));
RDebugUtils.currentLine=2686986;
 //BA.debugLineNum = 2686986;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper  _roundbitmap(b4a.exampleddd.picturechooser __ref,anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bitmap) throws Exception{
__ref = this;
RDebugUtils.currentModule="picturechooser";
if (Debug.shouldDelegate(ba, "roundbitmap"))
	 {return ((anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) Debug.delegate(ba, "roundbitmap", new Object[] {_bitmap}));}
anywheresoftware.b4a.objects.drawable.CanvasWrapper _cvs = null;
RDebugUtils.currentLine=2949120;
 //BA.debugLineNum = 2949120;BA.debugLine="Public Sub RoundBitmap(Bitmap As Bitmap) As Bitmap";
RDebugUtils.currentLine=2949121;
 //BA.debugLineNum = 2949121;BA.debugLine="Dim cvs As Canvas = CreateBitmap";
_cvs = __ref._createbitmap(null);
RDebugUtils.currentLine=2949122;
 //BA.debugLineNum = 2949122;BA.debugLine="DrawRoundBitmap(cvs,Bitmap)";
__ref._drawroundbitmap(null,_cvs,_bitmap);
RDebugUtils.currentLine=2949123;
 //BA.debugLineNum = 2949123;BA.debugLine="Return cvs.Bitmap";
if (true) return _cvs.getBitmap();
RDebugUtils.currentLine=2949124;
 //BA.debugLineNum = 2949124;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper  _roundbitmap2(b4a.exampleddd.picturechooser __ref,anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bitmap,int _corner) throws Exception{
__ref = this;
RDebugUtils.currentModule="picturechooser";
if (Debug.shouldDelegate(ba, "roundbitmap2"))
	 {return ((anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) Debug.delegate(ba, "roundbitmap2", new Object[] {_bitmap,_corner}));}
com.rootsoft.imageprocessing.RSImageEffects _rsie = null;
com.rootsoft.imageprocessing.RSImageProcessing _rsip = null;
RDebugUtils.currentLine=3014656;
 //BA.debugLineNum = 3014656;BA.debugLine="Public Sub RoundBitmap2(Bitmap As Bitmap,Corner As";
RDebugUtils.currentLine=3014658;
 //BA.debugLineNum = 3014658;BA.debugLine="Dim rsie As RSImageEffects";
_rsie = new com.rootsoft.imageprocessing.RSImageEffects();
RDebugUtils.currentLine=3014659;
 //BA.debugLineNum = 3014659;BA.debugLine="Dim rsip As RSImageProcessing";
_rsip = new com.rootsoft.imageprocessing.RSImageProcessing();
RDebugUtils.currentLine=3014661;
 //BA.debugLineNum = 3014661;BA.debugLine="rsip.Initialize";
_rsip.Initialize();
RDebugUtils.currentLine=3014662;
 //BA.debugLineNum = 3014662;BA.debugLine="Bitmap = rsip.createScaledBitmap(Bitmap,Bitmap.Wi";
_bitmap.setObject((android.graphics.Bitmap)(_rsip.createScaledBitmap((android.graphics.Bitmap)(_bitmap.getObject()),_bitmap.getWidth(),_bitmap.getHeight(),__c.False)));
RDebugUtils.currentLine=3014663;
 //BA.debugLineNum = 3014663;BA.debugLine="Return rsie.RoundCorner(Bitmap, Corner)";
if (true) return (anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(_rsie.RoundCorner((android.graphics.Bitmap)(_bitmap.getObject()),(float) (_corner))));
RDebugUtils.currentLine=3014665;
 //BA.debugLineNum = 3014665;BA.debugLine="End Sub";
return null;
}
public String  _savebitmap3(b4a.exampleddd.picturechooser __ref,anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bitmap,String _dir,String _filename,String _format,int _quality) throws Exception{
__ref = this;
RDebugUtils.currentModule="picturechooser";
if (Debug.shouldDelegate(ba, "savebitmap3"))
	 {return ((String) Debug.delegate(ba, "savebitmap3", new Object[] {_bitmap,_dir,_filename,_format,_quality}));}
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _b1 = null;
anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper _out = null;
RDebugUtils.currentLine=2818048;
 //BA.debugLineNum = 2818048;BA.debugLine="Public Sub SaveBitmap3(Bitmap As Bitmap,Dir As Str";
RDebugUtils.currentLine=2818049;
 //BA.debugLineNum = 2818049;BA.debugLine="Dim b1 As Bitmap";
_b1 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=2818050;
 //BA.debugLineNum = 2818050;BA.debugLine="Dim out As OutputStream";
_out = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
RDebugUtils.currentLine=2818051;
 //BA.debugLineNum = 2818051;BA.debugLine="b1 = Bitmap";
_b1 = _bitmap;
RDebugUtils.currentLine=2818052;
 //BA.debugLineNum = 2818052;BA.debugLine="out = File.OpenOutput(Dir,Filename,False)";
_out = __c.File.OpenOutput(_dir,_filename,__c.False);
RDebugUtils.currentLine=2818053;
 //BA.debugLineNum = 2818053;BA.debugLine="b1.WriteToStream(out,quality,Format.ToUpperCase)";
_b1.WriteToStream((java.io.OutputStream)(_out.getObject()),_quality,BA.getEnumFromString(android.graphics.Bitmap.CompressFormat.class,_format.toUpperCase()));
RDebugUtils.currentLine=2818054;
 //BA.debugLineNum = 2818054;BA.debugLine="out.Close";
_out.Close();
RDebugUtils.currentLine=2818055;
 //BA.debugLineNum = 2818055;BA.debugLine="End Sub";
return "";
}
public String  _scv_oncroperror(b4a.exampleddd.picturechooser __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="picturechooser";
if (Debug.shouldDelegate(ba, "scv_oncroperror"))
	 {return ((String) Debug.delegate(ba, "scv_oncroperror", null));}
RDebugUtils.currentLine=2293760;
 //BA.debugLineNum = 2293760;BA.debugLine="Private Sub SCV_onCropError";
RDebugUtils.currentLine=2293761;
 //BA.debugLineNum = 2293761;BA.debugLine="Log(\"onCropError\")";
__c.Log("onCropError");
RDebugUtils.currentLine=2293762;
 //BA.debugLineNum = 2293762;BA.debugLine="End Sub";
return "";
}
public String  _setaspectratio(b4a.exampleddd.picturechooser __ref,int _width,int _height) throws Exception{
__ref = this;
RDebugUtils.currentModule="picturechooser";
if (Debug.shouldDelegate(ba, "setaspectratio"))
	 {return ((String) Debug.delegate(ba, "setaspectratio", new Object[] {_width,_height}));}
RDebugUtils.currentLine=1507328;
 //BA.debugLineNum = 1507328;BA.debugLine="Public Sub SetAspectRatio(Width As Int,Height As I";
RDebugUtils.currentLine=1507329;
 //BA.debugLineNum = 1507329;BA.debugLine="CV.setAspectRatio(Width,Height)";
__ref._cv.setAspectRatio(_width,_height);
RDebugUtils.currentLine=1507330;
 //BA.debugLineNum = 1507330;BA.debugLine="AspectRatioWidth	=	Width";
__ref._aspectratiowidth = _width;
RDebugUtils.currentLine=1507331;
 //BA.debugLineNum = 1507331;BA.debugLine="AspectRatioHeight	=	Height";
__ref._aspectratioheight = _height;
RDebugUtils.currentLine=1507332;
 //BA.debugLineNum = 1507332;BA.debugLine="End Sub";
return "";
}
public String  _setchoosertitle(b4a.exampleddd.picturechooser __ref,String _value) throws Exception{
__ref = this;
RDebugUtils.currentModule="picturechooser";
if (Debug.shouldDelegate(ba, "setchoosertitle"))
	 {return ((String) Debug.delegate(ba, "setchoosertitle", new Object[] {_value}));}
RDebugUtils.currentLine=851968;
 //BA.debugLineNum = 851968;BA.debugLine="Public Sub setChooserTitle(Value As String)";
RDebugUtils.currentLine=851969;
 //BA.debugLineNum = 851969;BA.debugLine="Chooser_Title	=	Value";
__ref._chooser_title = _value;
RDebugUtils.currentLine=851970;
 //BA.debugLineNum = 851970;BA.debugLine="End Sub";
return "";
}
public String  _setcroptitle(b4a.exampleddd.picturechooser __ref,String _value) throws Exception{
__ref = this;
RDebugUtils.currentModule="picturechooser";
if (Debug.shouldDelegate(ba, "setcroptitle"))
	 {return ((String) Debug.delegate(ba, "setcroptitle", new Object[] {_value}));}
RDebugUtils.currentLine=1114112;
 //BA.debugLineNum = 1114112;BA.debugLine="Public Sub setCropTitle(Value As String)";
RDebugUtils.currentLine=1114113;
 //BA.debugLineNum = 1114113;BA.debugLine="b.Text	=	Value";
__ref._b.setText(BA.ObjectToCharSequence(_value));
RDebugUtils.currentLine=1114114;
 //BA.debugLineNum = 1114114;BA.debugLine="End Sub";
return "";
}
public String  _setqualitycamerapicture(b4a.exampleddd.picturechooser __ref,int _value) throws Exception{
__ref = this;
RDebugUtils.currentModule="picturechooser";
if (Debug.shouldDelegate(ba, "setqualitycamerapicture"))
	 {return ((String) Debug.delegate(ba, "setqualitycamerapicture", new Object[] {_value}));}
RDebugUtils.currentLine=1048576;
 //BA.debugLineNum = 1048576;BA.debugLine="Public Sub setQualityCameraPicture(Value As Int)";
RDebugUtils.currentLine=1048577;
 //BA.debugLineNum = 1048577;BA.debugLine="quality2	=	Value";
__ref._quality2 = _value;
RDebugUtils.currentLine=1048578;
 //BA.debugLineNum = 1048578;BA.debugLine="End Sub";
return "";
}
public String  _setrotatetitle(b4a.exampleddd.picturechooser __ref,String _value) throws Exception{
__ref = this;
RDebugUtils.currentModule="picturechooser";
if (Debug.shouldDelegate(ba, "setrotatetitle"))
	 {return ((String) Debug.delegate(ba, "setrotatetitle", new Object[] {_value}));}
RDebugUtils.currentLine=917504;
 //BA.debugLineNum = 917504;BA.debugLine="Public Sub setRotateTitle(Value As String)";
RDebugUtils.currentLine=917505;
 //BA.debugLineNum = 917505;BA.debugLine="btnrotate.Text	=	Value";
__ref._btnrotate.setText(BA.ObjectToCharSequence(_value));
RDebugUtils.currentLine=917506;
 //BA.debugLineNum = 917506;BA.debugLine="End Sub";
return "";
}
public String  _setscalecrop(b4a.exampleddd.picturechooser __ref,boolean _value) throws Exception{
__ref = this;
RDebugUtils.currentModule="picturechooser";
if (Debug.shouldDelegate(ba, "setscalecrop"))
	 {return ((String) Debug.delegate(ba, "setscalecrop", new Object[] {_value}));}
RDebugUtils.currentLine=1179648;
 //BA.debugLineNum = 1179648;BA.debugLine="Sub setScaleCrop(Value As Boolean)";
RDebugUtils.currentLine=1179649;
 //BA.debugLineNum = 1179649;BA.debugLine="CV.FixedAspectRatio	=	True";
__ref._cv.setFixedAspectRatio(__c.True);
RDebugUtils.currentLine=1179650;
 //BA.debugLineNum = 1179650;BA.debugLine="IsScale	=	Value";
__ref._isscale = _value;
RDebugUtils.currentLine=1179651;
 //BA.debugLineNum = 1179651;BA.debugLine="End Sub";
return "";
}
}