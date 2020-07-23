package b4a.exampleddd;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class picturechooser_subs_0 {


public static RemoteObject  _btncancel_click(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("btncancel_Click (picturechooser) ","picturechooser",1,__ref.getField(false, "ba"),__ref,460);
if (RapidSub.canDelegate("btncancel_click")) { return __ref.runUserSub(false, "picturechooser","btncancel_click", __ref);}
 BA.debugLineNum = 460;BA.debugLine="Private Sub btncancel_Click";
Debug.ShouldStop(2048);
 BA.debugLineNum = 462;BA.debugLine="p2.Visible = False";
Debug.ShouldStop(8192);
__ref.getField(false,"_p2").runMethod(true,"setVisible",picturechooser.__c.getField(true,"False"));
 BA.debugLineNum = 464;BA.debugLine="If SubExists(modue,evt & \"_error\") Then";
Debug.ShouldStop(32768);
if (picturechooser.__c.runMethod(true,"SubExists",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_modue")),(Object)(RemoteObject.concat(__ref.getField(true,"_evt"),RemoteObject.createImmutable("_error")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 465;BA.debugLine="CallSubDelayed(modue,evt & \"_error\")";
Debug.ShouldStop(65536);
picturechooser.__c.runVoidMethod ("CallSubDelayed",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_modue")),(Object)(RemoteObject.concat(__ref.getField(true,"_evt"),RemoteObject.createImmutable("_error"))));
 };
 BA.debugLineNum = 468;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btncrop_click(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("btncrop_Click (picturechooser) ","picturechooser",1,__ref.getField(false, "ba"),__ref,440);
if (RapidSub.canDelegate("btncrop_click")) { return __ref.runUserSub(false, "picturechooser","btncrop_click", __ref);}
 BA.debugLineNum = 440;BA.debugLine="Private Sub btncrop_Click";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 442;BA.debugLine="p2.Visible	=	False";
Debug.ShouldStop(33554432);
__ref.getField(false,"_p2").runMethod(true,"setVisible",picturechooser.__c.getField(true,"False"));
 BA.debugLineNum = 444;BA.debugLine="SaveBitmap(CV.CroppedImage,File.DirInternal,tempI";
Debug.ShouldStop(134217728);
__ref.runClassMethod (b4a.exampleddd.picturechooser.class, "_savebitmap",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), __ref.getField(false,"_cv").runMethod(false,"getCroppedImage")),(Object)(picturechooser.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(__ref.getField(true,"_tempimagefile")),(Object)(__ref.getField(true,"_quality2")));
 BA.debugLineNum = 446;BA.debugLine="If SubExists(modue,evt & \"_Result2\") Then";
Debug.ShouldStop(536870912);
if (picturechooser.__c.runMethod(true,"SubExists",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_modue")),(Object)(RemoteObject.concat(__ref.getField(true,"_evt"),RemoteObject.createImmutable("_Result2")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 447;BA.debugLine="CallSub3(modue,evt & \"_Result2\",File.DirInternal";
Debug.ShouldStop(1073741824);
picturechooser.__c.runMethodAndSync(false,"CallSubNew3",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_modue")),(Object)(RemoteObject.concat(__ref.getField(true,"_evt"),RemoteObject.createImmutable("_Result2"))),(Object)((picturechooser.__c.getField(false,"File").runMethod(true,"getDirInternal"))),(Object)((__ref.getField(true,"_tempimagefile"))));
 }else {
 BA.debugLineNum = 450;BA.debugLine="CallSubDelayed2(modue,evt & \"_result\",FixOrienta";
Debug.ShouldStop(2);
picturechooser.__c.runVoidMethod ("CallSubDelayed2",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_modue")),(Object)(RemoteObject.concat(__ref.getField(true,"_evt"),RemoteObject.createImmutable("_result"))),(Object)((__ref.runClassMethod (b4a.exampleddd.picturechooser.class, "_fixorientation",(Object)(picturechooser.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(__ref.getField(true,"_tempimagefile"))))));
 };
 BA.debugLineNum = 454;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnmodecamera_click(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("btnmodeCamera_Click (picturechooser) ","picturechooser",1,__ref.getField(false, "ba"),__ref,128);
if (RapidSub.canDelegate("btnmodecamera_click")) { return __ref.runUserSub(false, "picturechooser","btnmodecamera_click", __ref);}
 BA.debugLineNum = 128;BA.debugLine="Private Sub btnmodeCamera_Click";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 129;BA.debugLine="IsFrontCamera	=	Not(IsFrontCamera)";
Debug.ShouldStop(1);
__ref.setField ("_isfrontcamera",picturechooser.__c.runMethod(true,"Not",(Object)(__ref.getField(true,"_isfrontcamera"))));
 BA.debugLineNum = 130;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnrotate_click(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("btnrotate_Click (picturechooser) ","picturechooser",1,__ref.getField(false, "ba"),__ref,156);
if (RapidSub.canDelegate("btnrotate_click")) { return __ref.runUserSub(false, "picturechooser","btnrotate_click", __ref);}
 BA.debugLineNum = 156;BA.debugLine="Private Sub btnrotate_Click";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 157;BA.debugLine="CurrentUserBitmap	=	RotateBitmap(CurrentUserBitma";
Debug.ShouldStop(268435456);
__ref.setField ("_currentuserbitmap",__ref.runClassMethod (b4a.exampleddd.picturechooser.class, "_rotatebitmap",(Object)(__ref.getField(false,"_currentuserbitmap")),(Object)(BA.numberCast(float.class, 90))));
 BA.debugLineNum = 158;BA.debugLine="CV.ImageBitmap		=	CurrentUserBitmap";
Debug.ShouldStop(536870912);
__ref.getField(false,"_cv").runVoidMethod ("setImageBitmap",(__ref.getField(false,"_currentuserbitmap").getObject()));
 BA.debugLineNum = 159;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btntake_click(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("btntake_Click (picturechooser) ","picturechooser",1,__ref.getField(false, "ba"),__ref,152);
if (RapidSub.canDelegate("btntake_click")) { return __ref.runUserSub(false, "picturechooser","btntake_click", __ref);}
 BA.debugLineNum = 152;BA.debugLine="Private Sub btntake_Click";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 154;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _cc_result(RemoteObject __ref,RemoteObject _success,RemoteObject _dir,RemoteObject _filename) throws Exception{
try {
		Debug.PushSubsStack("cc_Result (picturechooser) ","picturechooser",1,__ref.getField(false, "ba"),__ref,391);
if (RapidSub.canDelegate("cc_result")) { return __ref.runUserSub(false, "picturechooser","cc_result", __ref, _success, _dir, _filename);}
RemoteObject _ou = RemoteObject.declareNull("anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper");
RemoteObject _temp = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
Debug.locals.put("Success", _success);
Debug.locals.put("Dir", _dir);
Debug.locals.put("FileName", _filename);
 BA.debugLineNum = 391;BA.debugLine="Private Sub cc_Result (Success As Boolean, Dir As";
Debug.ShouldStop(64);
 BA.debugLineNum = 393;BA.debugLine="If Success Then";
Debug.ShouldStop(256);
if (_success.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 395;BA.debugLine="sDir		=	Dir";
Debug.ShouldStop(1024);
__ref.setField ("_sdir",_dir);
 BA.debugLineNum = 396;BA.debugLine="sFilename	=	FileName";
Debug.ShouldStop(2048);
__ref.setField ("_sfilename",_filename);
 BA.debugLineNum = 398;BA.debugLine="If is_crop Then";
Debug.ShouldStop(8192);
if (__ref.getField(true,"_is_crop").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 402;BA.debugLine="Try";
Debug.ShouldStop(131072);
try { BA.debugLineNum = 403;BA.debugLine="SaveBitmap2(LoadBitmap(Dir,FileName),imageFold";
Debug.ShouldStop(262144);
__ref.runClassMethod (b4a.exampleddd.picturechooser.class, "_savebitmap2",(Object)(picturechooser.__c.runMethod(false,"LoadBitmap",(Object)(_dir),(Object)(_filename))),(Object)(__ref.getField(true,"_imagefolder")),(Object)(RemoteObject.createImmutable("temp.jpg")));
 BA.debugLineNum = 404;BA.debugLine="Crop2(imageFolder,\"temp.jpg\")";
Debug.ShouldStop(524288);
__ref.runClassMethod (b4a.exampleddd.picturechooser.class, "_crop2",(Object)(__ref.getField(true,"_imagefolder")),(Object)(RemoteObject.createImmutable("temp.jpg")));
 BA.debugLineNum = 405;BA.debugLine="Return";
Debug.ShouldStop(1048576);
Debug.CheckDeviceExceptions();if (true) return RemoteObject.createImmutable("");
 BA.debugLineNum = 406;BA.debugLine="CV.ImageBitmap		=	LoadBitmapResize(Dir,FileNam";
Debug.ShouldStop(2097152);
__ref.getField(false,"_cv").runVoidMethod ("setImageBitmap",(picturechooser.__c.runMethod(false,"LoadBitmapResize",(Object)(_dir),(Object)(_filename),(Object)(picturechooser.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 150)),__ref.getField(false, "ba"))),(Object)(picturechooser.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 150)),__ref.getField(false, "ba"))),(Object)(picturechooser.__c.getField(true,"True"))).getObject()));
 BA.debugLineNum = 407;BA.debugLine="CurrentUserBitmap	=	LoadBitmapResize(Dir,FileN";
Debug.ShouldStop(4194304);
__ref.setField ("_currentuserbitmap",picturechooser.__c.runMethod(false,"LoadBitmapResize",(Object)(_dir),(Object)(_filename),(Object)(picturechooser.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 150)),__ref.getField(false, "ba"))),(Object)(picturechooser.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 150)),__ref.getField(false, "ba"))),(Object)(picturechooser.__c.getField(true,"True"))));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e12) {
			BA.rdebugUtils.runVoidMethod("setLastException",__ref.getField(false, "ba"), e12.toString()); };
 BA.debugLineNum = 411;BA.debugLine="Return";
Debug.ShouldStop(67108864);
Debug.CheckDeviceExceptions();if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 414;BA.debugLine="Dim ou As OutputStream";
Debug.ShouldStop(536870912);
_ou = RemoteObject.createNew ("anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper");Debug.locals.put("ou", _ou);
 BA.debugLineNum = 415;BA.debugLine="ou = File.OpenOutput(File.DirInternal,\"temp.jpg\"";
Debug.ShouldStop(1073741824);
_ou = picturechooser.__c.getField(false,"File").runMethod(false,"OpenOutput",(Object)(picturechooser.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("temp.jpg")),(Object)(picturechooser.__c.getField(true,"False")));Debug.locals.put("ou", _ou);
 BA.debugLineNum = 417;BA.debugLine="Try";
Debug.ShouldStop(1);
try { BA.debugLineNum = 418;BA.debugLine="File.Copy2(File.OpenInput(Dir,FileName),ou)";
Debug.ShouldStop(2);
picturechooser.__c.getField(false,"File").runVoidMethod ("Copy2",(Object)((picturechooser.__c.getField(false,"File").runMethod(false,"OpenInput",(Object)(_dir),(Object)(_filename)).getObject())),(Object)((_ou.getObject())));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e20) {
			BA.rdebugUtils.runVoidMethod("setLastException",__ref.getField(false, "ba"), e20.toString()); BA.debugLineNum = 420;BA.debugLine="Log(\"not exist file\")";
Debug.ShouldStop(8);
picturechooser.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("not exist file")));
 BA.debugLineNum = 421;BA.debugLine="Return";
Debug.ShouldStop(16);
Debug.CheckDeviceExceptions();if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 424;BA.debugLine="ou.Close";
Debug.ShouldStop(128);
_ou.runVoidMethod ("Close");
 BA.debugLineNum = 426;BA.debugLine="Dim temp As Bitmap";
Debug.ShouldStop(512);
_temp = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("temp", _temp);
 BA.debugLineNum = 427;BA.debugLine="temp = FixOrientation(File.DirInternal,\"temp.jpg";
Debug.ShouldStop(1024);
_temp = __ref.runClassMethod (b4a.exampleddd.picturechooser.class, "_fixorientation",(Object)(picturechooser.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("temp.jpg")));Debug.locals.put("temp", _temp);
 BA.debugLineNum = 429;BA.debugLine="If SubExists(modue,evt & \"_result2\") Then";
Debug.ShouldStop(4096);
if (picturechooser.__c.runMethod(true,"SubExists",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_modue")),(Object)(RemoteObject.concat(__ref.getField(true,"_evt"),RemoteObject.createImmutable("_result2")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 430;BA.debugLine="SaveBitmap(temp,File.DirInternal,\"temp.jpg\",70)";
Debug.ShouldStop(8192);
__ref.runClassMethod (b4a.exampleddd.picturechooser.class, "_savebitmap",(Object)(_temp),(Object)(picturechooser.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("temp.jpg")),(Object)(BA.numberCast(int.class, 70)));
 BA.debugLineNum = 431;BA.debugLine="CallSubDelayed3(modue,evt & \"_Result2\",File.Dir";
Debug.ShouldStop(16384);
picturechooser.__c.runVoidMethod ("CallSubDelayed3",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_modue")),(Object)(RemoteObject.concat(__ref.getField(true,"_evt"),RemoteObject.createImmutable("_Result2"))),(Object)((picturechooser.__c.getField(false,"File").runMethod(true,"getDirInternal"))),(Object)((RemoteObject.createImmutable("temp.jpg"))));
 }else {
 BA.debugLineNum = 433;BA.debugLine="CallSubDelayed2(modue,evt & \"_result\",temp)";
Debug.ShouldStop(65536);
picturechooser.__c.runVoidMethod ("CallSubDelayed2",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_modue")),(Object)(RemoteObject.concat(__ref.getField(true,"_evt"),RemoteObject.createImmutable("_result"))),(Object)((_temp)));
 };
 };
 BA.debugLineNum = 438;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _checkpermissioncamera(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("CheckPermissionCamera (picturechooser) ","picturechooser",1,__ref.getField(false, "ba"),__ref,132);
if (RapidSub.canDelegate("checkpermissioncamera")) { return __ref.runUserSub(false, "picturechooser","checkpermissioncamera", __ref);}
RemoteObject _r = RemoteObject.declareNull("anywheresoftware.b4a.objects.RuntimePermissions");
 BA.debugLineNum = 132;BA.debugLine="Public Sub CheckPermissionCamera As Boolean";
Debug.ShouldStop(8);
 BA.debugLineNum = 134;BA.debugLine="Dim r As RuntimePermissions";
Debug.ShouldStop(32);
_r = RemoteObject.createNew ("anywheresoftware.b4a.objects.RuntimePermissions");Debug.locals.put("r", _r);
 BA.debugLineNum = 135;BA.debugLine="Return r.Check(r.PERMISSION_CAMERA)";
Debug.ShouldStop(64);
Debug.CheckDeviceExceptions();if (true) return _r.runMethod(true,"Check",(Object)(_r.getField(true,"PERMISSION_CAMERA")));
 BA.debugLineNum = 137;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _choosefromcamera(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("ChooseFromCamera (picturechooser) ","picturechooser",1,__ref.getField(false, "ba"),__ref,243);
if (RapidSub.canDelegate("choosefromcamera")) { return __ref.runUserSub(false, "picturechooser","choosefromcamera", __ref);}
RemoteObject _i = RemoteObject.declareNull("anywheresoftware.b4a.objects.IntentWrapper");
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone");
RemoteObject _u = RemoteObject.declareNull("Object");
RemoteObject _uri = RemoteObject.declareNull("anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper");
 BA.debugLineNum = 243;BA.debugLine="Public Sub ChooseFromCamera";
Debug.ShouldStop(262144);
 BA.debugLineNum = 245;BA.debugLine="Dim i As Intent";
Debug.ShouldStop(1048576);
_i = RemoteObject.createNew ("anywheresoftware.b4a.objects.IntentWrapper");Debug.locals.put("i", _i);
 BA.debugLineNum = 246;BA.debugLine="i.Initialize(\"android.media.action.IMAGE_CAPTURE\"";
Debug.ShouldStop(2097152);
_i.runVoidMethod ("Initialize",(Object)(BA.ObjectToString("android.media.action.IMAGE_CAPTURE")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 247;BA.debugLine="File.Delete(imageFolder, tempImageFile)";
Debug.ShouldStop(4194304);
picturechooser.__c.getField(false,"File").runVoidMethod ("Delete",(Object)(__ref.getField(true,"_imagefolder")),(Object)(__ref.getField(true,"_tempimagefile")));
 BA.debugLineNum = 248;BA.debugLine="Dim p As Phone";
Debug.ShouldStop(8388608);
_p = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone");Debug.locals.put("p", _p);
 BA.debugLineNum = 249;BA.debugLine="Dim u As Object";
Debug.ShouldStop(16777216);
_u = RemoteObject.createNew ("Object");Debug.locals.put("u", _u);
 BA.debugLineNum = 250;BA.debugLine="If p.SdkVersion < 24 Then";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("<",_p.runMethod(true,"getSdkVersion"),BA.numberCast(double.class, 24))) { 
 BA.debugLineNum = 251;BA.debugLine="Dim uri As Uri";
Debug.ShouldStop(67108864);
_uri = RemoteObject.createNew ("anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper");Debug.locals.put("uri", _uri);
 BA.debugLineNum = 252;BA.debugLine="uri.Parse(\"file://\" & File.Combine(imageFolder,";
Debug.ShouldStop(134217728);
_uri.runVoidMethod ("Parse",(Object)(RemoteObject.concat(RemoteObject.createImmutable("file://"),picturechooser.__c.getField(false,"File").runMethod(true,"Combine",(Object)(__ref.getField(true,"_imagefolder")),(Object)(__ref.getField(true,"_tempimagefile"))))));
 BA.debugLineNum = 253;BA.debugLine="u = uri";
Debug.ShouldStop(268435456);
_u = (_uri.getObject());Debug.locals.put("u", _u);
 }else {
 BA.debugLineNum = 255;BA.debugLine="u = CreateFileProviderUri(imageFolder, tempImage";
Debug.ShouldStop(1073741824);
_u = __ref.runClassMethod (b4a.exampleddd.picturechooser.class, "_createfileprovideruri",(Object)(__ref.getField(true,"_imagefolder")),(Object)(__ref.getField(true,"_tempimagefile")));Debug.locals.put("u", _u);
 };
 BA.debugLineNum = 257;BA.debugLine="i.PutExtra(\"output\", u) 'the image will be saved";
Debug.ShouldStop(1);
_i.runVoidMethod ("PutExtra",(Object)(BA.ObjectToString("output")),(Object)(_u));
 BA.debugLineNum = 258;BA.debugLine="Try";
Debug.ShouldStop(2);
try { BA.debugLineNum = 259;BA.debugLine="StartActivityForResult(i,\"ion\")";
Debug.ShouldStop(4);
__ref.runClassMethod (b4a.exampleddd.picturechooser.class, "_startactivityforresult",(Object)(_i),(Object)(RemoteObject.createImmutable("ion")));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e17) {
			BA.rdebugUtils.runVoidMethod("setLastException",__ref.getField(false, "ba"), e17.toString()); BA.debugLineNum = 261;BA.debugLine="ToastMessageShow(\"Camera is not available.\", Tru";
Debug.ShouldStop(16);
picturechooser.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Camera is not available.")),(Object)(picturechooser.__c.getField(true,"True")));
 BA.debugLineNum = 262;BA.debugLine="Log(LastException)";
Debug.ShouldStop(32);
picturechooser.__c.runVoidMethod ("Log",(Object)(BA.ObjectToString(picturechooser.__c.runMethod(false,"LastException",__ref.getField(false, "ba")))));
 };
 BA.debugLineNum = 265;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _choosefromgallery(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("ChooseFromGallery (picturechooser) ","picturechooser",1,__ref.getField(false, "ba"),__ref,196);
if (RapidSub.canDelegate("choosefromgallery")) { return __ref.runUserSub(false, "picturechooser","choosefromgallery", __ref);}
 BA.debugLineNum = 196;BA.debugLine="Public Sub ChooseFromGallery";
Debug.ShouldStop(8);
 BA.debugLineNum = 197;BA.debugLine="chooser.Show(\"image/*\",Chooser_Title)";
Debug.ShouldStop(16);
__ref.getField(false,"_chooser").runVoidMethod ("Show",__ref.getField(false, "ba"),(Object)(BA.ObjectToString("image/*")),(Object)(__ref.getField(true,"_chooser_title")));
 BA.debugLineNum = 198;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _class_globals(RemoteObject __ref) throws Exception{
 //BA.debugLineNum = 5;BA.debugLine="Private Sub Class_Globals";
 //BA.debugLineNum = 6;BA.debugLine="Private ion As Object";
picturechooser._ion = RemoteObject.createNew ("Object");__ref.setField("_ion",picturechooser._ion);
 //BA.debugLineNum = 7;BA.debugLine="Private imageFolder As String";
picturechooser._imagefolder = RemoteObject.createImmutable("");__ref.setField("_imagefolder",picturechooser._imagefolder);
 //BA.debugLineNum = 8;BA.debugLine="Private IsFrontCamera As Boolean";
picturechooser._isfrontcamera = RemoteObject.createImmutable(false);__ref.setField("_isfrontcamera",picturechooser._isfrontcamera);
 //BA.debugLineNum = 9;BA.debugLine="Private tempImageFile As String";
picturechooser._tempimagefile = RemoteObject.createImmutable("");__ref.setField("_tempimagefile",picturechooser._tempimagefile);
 //BA.debugLineNum = 10;BA.debugLine="Private chooser As ContentChooser";
picturechooser._chooser = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone.ContentChooser");__ref.setField("_chooser",picturechooser._chooser);
 //BA.debugLineNum = 11;BA.debugLine="Private modue As Object";
picturechooser._modue = RemoteObject.createNew ("Object");__ref.setField("_modue",picturechooser._modue);
 //BA.debugLineNum = 12;BA.debugLine="Private evt As String";
picturechooser._evt = RemoteObject.createImmutable("");__ref.setField("_evt",picturechooser._evt);
 //BA.debugLineNum = 13;BA.debugLine="Private sDir,sFilename As String";
picturechooser._sdir = RemoteObject.createImmutable("");__ref.setField("_sdir",picturechooser._sdir);
picturechooser._sfilename = RemoteObject.createImmutable("");__ref.setField("_sfilename",picturechooser._sfilename);
 //BA.debugLineNum = 14;BA.debugLine="Private is_crop As Boolean";
picturechooser._is_crop = RemoteObject.createImmutable(false);__ref.setField("_is_crop",picturechooser._is_crop);
 //BA.debugLineNum = 15;BA.debugLine="Private p2 As Panel";
picturechooser._p2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");__ref.setField("_p2",picturechooser._p2);
 //BA.debugLineNum = 16;BA.debugLine="Private CV As CropImageView";
picturechooser._cv = RemoteObject.createNew ("de.donmanfred.CropImageViewWrapper");__ref.setField("_cv",picturechooser._cv);
 //BA.debugLineNum = 17;BA.debugLine="Private btnrotate As Button";
picturechooser._btnrotate = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");__ref.setField("_btnrotate",picturechooser._btnrotate);
 //BA.debugLineNum = 18;BA.debugLine="Private rotate_title As String : rotate_title = \"";
picturechooser._rotate_title = RemoteObject.createImmutable("");__ref.setField("_rotate_title",picturechooser._rotate_title);
 //BA.debugLineNum = 18;BA.debugLine="Private rotate_title As String : rotate_title = \"";
__ref.setField ("_rotate_title",BA.ObjectToString("بچرخون"));
 //BA.debugLineNum = 19;BA.debugLine="Private crop_title As String : crop_title = \"کراپ";
picturechooser._crop_title = RemoteObject.createImmutable("");__ref.setField("_crop_title",picturechooser._crop_title);
 //BA.debugLineNum = 19;BA.debugLine="Private crop_title As String : crop_title = \"کراپ";
__ref.setField ("_crop_title",BA.ObjectToString("کراپ"));
 //BA.debugLineNum = 20;BA.debugLine="Private cancel_title As String : cancel_title = \"";
picturechooser._cancel_title = RemoteObject.createImmutable("");__ref.setField("_cancel_title",picturechooser._cancel_title);
 //BA.debugLineNum = 20;BA.debugLine="Private cancel_title As String : cancel_title = \"";
__ref.setField ("_cancel_title",BA.ObjectToString("بیخیال"));
 //BA.debugLineNum = 21;BA.debugLine="Private b As Button";
picturechooser._b = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");__ref.setField("_b",picturechooser._b);
 //BA.debugLineNum = 22;BA.debugLine="Private quality2 As Int : quality2 = 60";
picturechooser._quality2 = RemoteObject.createImmutable(0);__ref.setField("_quality2",picturechooser._quality2);
 //BA.debugLineNum = 22;BA.debugLine="Private quality2 As Int : quality2 = 60";
__ref.setField ("_quality2",BA.numberCast(int.class, 60));
 //BA.debugLineNum = 23;BA.debugLine="Private cancel As Button";
picturechooser._cancel = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");__ref.setField("_cancel",picturechooser._cancel);
 //BA.debugLineNum = 24;BA.debugLine="Private Chooser_Title As String : Chooser_Title	=";
picturechooser._chooser_title = RemoteObject.createImmutable("");__ref.setField("_chooser_title",picturechooser._chooser_title);
 //BA.debugLineNum = 24;BA.debugLine="Private Chooser_Title As String : Chooser_Title	=";
__ref.setField ("_chooser_title",BA.ObjectToString("انتخاب تصویر"));
 //BA.debugLineNum = 25;BA.debugLine="Private CurrentUserBitmap As Bitmap";
picturechooser._currentuserbitmap = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");__ref.setField("_currentuserbitmap",picturechooser._currentuserbitmap);
 //BA.debugLineNum = 26;BA.debugLine="Private rp As RuntimePermissions";
picturechooser._rp = RemoteObject.createNew ("anywheresoftware.b4a.objects.RuntimePermissions");__ref.setField("_rp",picturechooser._rp);
 //BA.debugLineNum = 27;BA.debugLine="Private CurrentDirCrop,CurrentFilenameCrop As Str";
picturechooser._currentdircrop = RemoteObject.createImmutable("");__ref.setField("_currentdircrop",picturechooser._currentdircrop);
picturechooser._currentfilenamecrop = RemoteObject.createImmutable("");__ref.setField("_currentfilenamecrop",picturechooser._currentfilenamecrop);
 //BA.debugLineNum = 28;BA.debugLine="Private AspectRatioWidth,AspectRatioHeight As Int";
picturechooser._aspectratiowidth = RemoteObject.createImmutable(0);__ref.setField("_aspectratiowidth",picturechooser._aspectratiowidth);
picturechooser._aspectratioheight = RemoteObject.createImmutable(0);__ref.setField("_aspectratioheight",picturechooser._aspectratioheight);
 //BA.debugLineNum = 29;BA.debugLine="Private IsScale as Boolean";
picturechooser._isscale = RemoteObject.createImmutable(false);__ref.setField("_isscale",picturechooser._isscale);
 //BA.debugLineNum = 30;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _close(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("Close (picturechooser) ","picturechooser",1,__ref.getField(false, "ba"),__ref,91);
if (RapidSub.canDelegate("close")) { return __ref.runUserSub(false, "picturechooser","close", __ref);}
 BA.debugLineNum = 91;BA.debugLine="Public Sub Close";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 92;BA.debugLine="btncancel_Click";
Debug.ShouldStop(134217728);
__ref.runClassMethod (b4a.exampleddd.picturechooser.class, "_btncancel_click");
 BA.debugLineNum = 93;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _createbitmap(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("CreateBitmap (picturechooser) ","picturechooser",1,__ref.getField(false, "ba"),__ref,557);
if (RapidSub.canDelegate("createbitmap")) { return __ref.runUserSub(false, "picturechooser","createbitmap", __ref);}
RemoteObject _bmp = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
RemoteObject _cvs = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper");
RemoteObject _r = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper");
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.PathWrapper");
RemoteObject _jo = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _x = RemoteObject.createImmutable(0f);
RemoteObject _y = RemoteObject.createImmutable(0f);
RemoteObject _radius = RemoteObject.createImmutable(0f);
 BA.debugLineNum = 557;BA.debugLine="Private Sub CreateBitmap As Canvas";
Debug.ShouldStop(4096);
 BA.debugLineNum = 558;BA.debugLine="Dim bmp As Bitmap";
Debug.ShouldStop(8192);
_bmp = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("bmp", _bmp);
 BA.debugLineNum = 559;BA.debugLine="bmp.InitializeMutable(200dip, 200dip)";
Debug.ShouldStop(16384);
_bmp.runVoidMethod ("InitializeMutable",(Object)(picturechooser.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 200)))),(Object)(picturechooser.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 200)))));
 BA.debugLineNum = 560;BA.debugLine="Dim cvs As Canvas";
Debug.ShouldStop(32768);
_cvs = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper");Debug.locals.put("cvs", _cvs);
 BA.debugLineNum = 561;BA.debugLine="cvs.Initialize2(bmp)";
Debug.ShouldStop(65536);
_cvs.runVoidMethod ("Initialize2",(Object)((_bmp.getObject())));
 BA.debugLineNum = 562;BA.debugLine="Dim r As Rect";
Debug.ShouldStop(131072);
_r = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper");Debug.locals.put("r", _r);
 BA.debugLineNum = 563;BA.debugLine="r.Initialize(0, 0, bmp.Width, bmp.Height)";
Debug.ShouldStop(262144);
_r.runVoidMethod ("Initialize",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(_bmp.runMethod(true,"getWidth")),(Object)(_bmp.runMethod(true,"getHeight")));
 BA.debugLineNum = 564;BA.debugLine="cvs.DrawRect(r, Colors.Transparent, True, 0)";
Debug.ShouldStop(524288);
_cvs.runVoidMethod ("DrawRect",(Object)((_r.getObject())),(Object)(picturechooser.__c.getField(false,"Colors").getField(true,"Transparent")),(Object)(picturechooser.__c.getField(true,"True")),(Object)(BA.numberCast(float.class, 0)));
 BA.debugLineNum = 565;BA.debugLine="Dim p As Path";
Debug.ShouldStop(1048576);
_p = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.PathWrapper");Debug.locals.put("p", _p);
 BA.debugLineNum = 566;BA.debugLine="p.Initialize(0, 0)";
Debug.ShouldStop(2097152);
_p.runVoidMethod ("Initialize",(Object)(BA.numberCast(float.class, 0)),(Object)(BA.numberCast(float.class, 0)));
 BA.debugLineNum = 567;BA.debugLine="Dim jo As JavaObject = p";
Debug.ShouldStop(4194304);
_jo = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
_jo.setObject(_p.getObject());Debug.locals.put("jo", _jo);
 BA.debugLineNum = 568;BA.debugLine="Dim x = 100dip, y = 100dip, radius = 100dip As Fl";
Debug.ShouldStop(8388608);
_x = BA.numberCast(float.class, picturechooser.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100))));Debug.locals.put("x", _x);Debug.locals.put("x", _x);
_y = BA.numberCast(float.class, picturechooser.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100))));Debug.locals.put("y", _y);Debug.locals.put("y", _y);
_radius = BA.numberCast(float.class, picturechooser.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100))));Debug.locals.put("radius", _radius);Debug.locals.put("radius", _radius);
 BA.debugLineNum = 569;BA.debugLine="jo.RunMethod(\"addCircle\", Array As Object(x, y, r";
Debug.ShouldStop(16777216);
_jo.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("addCircle")),(Object)(RemoteObject.createNewArray("Object",new int[] {4},new Object[] {(_x),(_y),(_radius),(RemoteObject.createImmutable("CW"))})));
 BA.debugLineNum = 570;BA.debugLine="cvs.ClipPath(p)";
Debug.ShouldStop(33554432);
_cvs.runVoidMethod ("ClipPath",(Object)((_p.getObject())));
 BA.debugLineNum = 571;BA.debugLine="Return cvs";
Debug.ShouldStop(67108864);
Debug.CheckDeviceExceptions();if (true) return _cvs;
 BA.debugLineNum = 572;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _createfileprovideruri(RemoteObject __ref,RemoteObject _dir,RemoteObject _filename) throws Exception{
try {
		Debug.PushSubsStack("CreateFileProviderUri (picturechooser) ","picturechooser",1,__ref.getField(false, "ba"),__ref,367);
if (RapidSub.canDelegate("createfileprovideruri")) { return __ref.runUserSub(false, "picturechooser","createfileprovideruri", __ref, _dir, _filename);}
RemoteObject _fileprovider = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _context = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _f = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
Debug.locals.put("Dir", _dir);
Debug.locals.put("FileName", _filename);
 BA.debugLineNum = 367;BA.debugLine="Private Sub CreateFileProviderUri (Dir As String,";
Debug.ShouldStop(16384);
 BA.debugLineNum = 368;BA.debugLine="Dim FileProvider As JavaObject";
Debug.ShouldStop(32768);
_fileprovider = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("FileProvider", _fileprovider);
 BA.debugLineNum = 369;BA.debugLine="Dim context As JavaObject";
Debug.ShouldStop(65536);
_context = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("context", _context);
 BA.debugLineNum = 370;BA.debugLine="context.InitializeContext";
Debug.ShouldStop(131072);
_context.runVoidMethod ("InitializeContext",__ref.getField(false, "ba"));
 BA.debugLineNum = 371;BA.debugLine="FileProvider.InitializeStatic(\"android.support.v4";
Debug.ShouldStop(262144);
_fileprovider.runVoidMethod ("InitializeStatic",(Object)(RemoteObject.createImmutable("android.support.v4.content.FileProvider")));
 BA.debugLineNum = 372;BA.debugLine="Dim f As JavaObject";
Debug.ShouldStop(524288);
_f = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("f", _f);
 BA.debugLineNum = 373;BA.debugLine="f.InitializeNewInstance(\"java.io.File\", Array(Dir";
Debug.ShouldStop(1048576);
_f.runVoidMethod ("InitializeNewInstance",(Object)(BA.ObjectToString("java.io.File")),(Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {(_dir),(_filename)})));
 BA.debugLineNum = 374;BA.debugLine="Return FileProvider.RunMethod(\"getUriForFile\", Ar";
Debug.ShouldStop(2097152);
Debug.CheckDeviceExceptions();if (true) return _fileprovider.runMethod(false,"RunMethod",(Object)(BA.ObjectToString("getUriForFile")),(Object)(RemoteObject.createNewArray("Object",new int[] {3},new Object[] {(_context.getObject()),(RemoteObject.concat(picturechooser.__c.getField(false,"Application").runMethod(true,"getPackageName"),RemoteObject.createImmutable(".provider"))),(_f.getObject())})));
 BA.debugLineNum = 375;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _crop_event(RemoteObject __ref,RemoteObject _methodname,RemoteObject _args) throws Exception{
try {
		Debug.PushSubsStack("crop_Event (picturechooser) ","picturechooser",1,__ref.getField(false, "ba"),__ref,348);
if (RapidSub.canDelegate("crop_event")) { return __ref.runUserSub(false, "picturechooser","crop_event", __ref, _methodname, _args);}
Debug.locals.put("MethodName", _methodname);
Debug.locals.put("Args", _args);
 BA.debugLineNum = 348;BA.debugLine="Private Sub crop_Event (MethodName As String, Args";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 350;BA.debugLine="If Args = Null Then Return Null";
Debug.ShouldStop(536870912);
if (RemoteObject.solveBoolean("n",_args)) { 
Debug.CheckDeviceExceptions();if (true) return picturechooser.__c.getField(false,"Null");};
 BA.debugLineNum = 351;BA.debugLine="If Args.Length = 0 Then Return Null";
Debug.ShouldStop(1073741824);
if (RemoteObject.solveBoolean("=",_args.getField(true,"length"),BA.numberCast(double.class, 0))) { 
Debug.CheckDeviceExceptions();if (true) return picturechooser.__c.getField(false,"Null");};
 BA.debugLineNum = 353;BA.debugLine="If Args(0) = -1 Then";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean("=",_args.getArrayElement(false,BA.numberCast(int.class, 0)),RemoteObject.createImmutable((-(double) (0 + 1))))) { 
 BA.debugLineNum = 354;BA.debugLine="If SubExists(modue,evt & \"_Result2\") Then";
Debug.ShouldStop(2);
if (picturechooser.__c.runMethod(true,"SubExists",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_modue")),(Object)(RemoteObject.concat(__ref.getField(true,"_evt"),RemoteObject.createImmutable("_Result2")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 355;BA.debugLine="CallSub3(modue,evt & \"_Result2\",CurrentDirCrop,";
Debug.ShouldStop(4);
picturechooser.__c.runMethodAndSync(false,"CallSubNew3",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_modue")),(Object)(RemoteObject.concat(__ref.getField(true,"_evt"),RemoteObject.createImmutable("_Result2"))),(Object)((__ref.getField(true,"_currentdircrop"))),(Object)((__ref.getField(true,"_currentfilenamecrop"))));
 }else {
 BA.debugLineNum = 358;BA.debugLine="CallSubDelayed2(modue,evt & \"_result\",FixOrient";
Debug.ShouldStop(32);
picturechooser.__c.runVoidMethod ("CallSubDelayed2",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_modue")),(Object)(RemoteObject.concat(__ref.getField(true,"_evt"),RemoteObject.createImmutable("_result"))),(Object)((__ref.runClassMethod (b4a.exampleddd.picturechooser.class, "_fixorientation",(Object)(__ref.getField(true,"_currentdircrop")),(Object)(__ref.getField(true,"_currentfilenamecrop"))))));
 };
 };
 BA.debugLineNum = 363;BA.debugLine="Return Null";
Debug.ShouldStop(1024);
Debug.CheckDeviceExceptions();if (true) return picturechooser.__c.getField(false,"Null");
 BA.debugLineNum = 365;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _crop2(RemoteObject __ref,RemoteObject _dir,RemoteObject _filename) throws Exception{
try {
		Debug.PushSubsStack("Crop2 (picturechooser) ","picturechooser",1,__ref.getField(false, "ba"),__ref,307);
if (RapidSub.canDelegate("crop2")) { return __ref.runUserSub(false, "picturechooser","crop2", __ref, _dir, _filename);}
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone");
RemoteObject _u = RemoteObject.declareNull("Object");
RemoteObject _uri = RemoteObject.declareNull("anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper");
RemoteObject _i = RemoteObject.declareNull("anywheresoftware.b4a.objects.IntentWrapper");
Debug.locals.put("Dir", _dir);
Debug.locals.put("Filename", _filename);
 BA.debugLineNum = 307;BA.debugLine="Public Sub Crop2(Dir As String, Filename As String";
Debug.ShouldStop(262144);
 BA.debugLineNum = 309;BA.debugLine="CurrentDirCrop		=	Dir";
Debug.ShouldStop(1048576);
__ref.setField ("_currentdircrop",_dir);
 BA.debugLineNum = 310;BA.debugLine="CurrentFilenameCrop	=	Filename";
Debug.ShouldStop(2097152);
__ref.setField ("_currentfilenamecrop",_filename);
 BA.debugLineNum = 312;BA.debugLine="Dim p As Phone";
Debug.ShouldStop(8388608);
_p = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone");Debug.locals.put("p", _p);
 BA.debugLineNum = 313;BA.debugLine="Dim u As Object";
Debug.ShouldStop(16777216);
_u = RemoteObject.createNew ("Object");Debug.locals.put("u", _u);
 BA.debugLineNum = 314;BA.debugLine="If p.SdkVersion < 24 Then";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("<",_p.runMethod(true,"getSdkVersion"),BA.numberCast(double.class, 24))) { 
 BA.debugLineNum = 315;BA.debugLine="Dim uri As Uri";
Debug.ShouldStop(67108864);
_uri = RemoteObject.createNew ("anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper");Debug.locals.put("uri", _uri);
 BA.debugLineNum = 316;BA.debugLine="uri.Parse(\"file://\" & File.Combine(Dir, Filename";
Debug.ShouldStop(134217728);
_uri.runVoidMethod ("Parse",(Object)(RemoteObject.concat(RemoteObject.createImmutable("file://"),picturechooser.__c.getField(false,"File").runMethod(true,"Combine",(Object)(_dir),(Object)(_filename)))));
 BA.debugLineNum = 317;BA.debugLine="u = uri";
Debug.ShouldStop(268435456);
_u = (_uri.getObject());Debug.locals.put("u", _u);
 }else {
 BA.debugLineNum = 319;BA.debugLine="u = CreateFileProviderUri(Dir, Filename)";
Debug.ShouldStop(1073741824);
_u = __ref.runClassMethod (b4a.exampleddd.picturechooser.class, "_createfileprovideruri",(Object)(_dir),(Object)(_filename));Debug.locals.put("u", _u);
 };
 BA.debugLineNum = 322;BA.debugLine="Dim i As Intent";
Debug.ShouldStop(2);
_i = RemoteObject.createNew ("anywheresoftware.b4a.objects.IntentWrapper");Debug.locals.put("i", _i);
 BA.debugLineNum = 323;BA.debugLine="i.Initialize(\"com.android.camera.action.CROP\",u)";
Debug.ShouldStop(4);
_i.runVoidMethod ("Initialize",(Object)(BA.ObjectToString("com.android.camera.action.CROP")),(Object)(BA.ObjectToString(_u)));
 BA.debugLineNum = 324;BA.debugLine="i.SetType(\"image/*\")";
Debug.ShouldStop(8);
_i.runVoidMethod ("SetType",(Object)(RemoteObject.createImmutable("image/*")));
 BA.debugLineNum = 325;BA.debugLine="i.PutExtra(\"crop\", \"true\")";
Debug.ShouldStop(16);
_i.runVoidMethod ("PutExtra",(Object)(BA.ObjectToString("crop")),(Object)((RemoteObject.createImmutable("true"))));
 BA.debugLineNum = 327;BA.debugLine="If IsScale Then";
Debug.ShouldStop(64);
if (__ref.getField(true,"_isscale").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 328;BA.debugLine="i.PutExtra(\"aspectX\", 1)";
Debug.ShouldStop(128);
_i.runVoidMethod ("PutExtra",(Object)(BA.ObjectToString("aspectX")),(Object)(RemoteObject.createImmutable((1))));
 BA.debugLineNum = 329;BA.debugLine="i.PutExtra(\"aspectY\", 1)";
Debug.ShouldStop(256);
_i.runVoidMethod ("PutExtra",(Object)(BA.ObjectToString("aspectY")),(Object)(RemoteObject.createImmutable((1))));
 }else {
 BA.debugLineNum = 331;BA.debugLine="i.PutExtra(\"aspectX\", AspectRatioWidth)";
Debug.ShouldStop(1024);
_i.runVoidMethod ("PutExtra",(Object)(BA.ObjectToString("aspectX")),(Object)((__ref.getField(true,"_aspectratiowidth"))));
 BA.debugLineNum = 332;BA.debugLine="i.PutExtra(\"aspectY\", AspectRatioHeight)";
Debug.ShouldStop(2048);
_i.runVoidMethod ("PutExtra",(Object)(BA.ObjectToString("aspectY")),(Object)((__ref.getField(true,"_aspectratioheight"))));
 };
 BA.debugLineNum = 335;BA.debugLine="If IsScale Then";
Debug.ShouldStop(16384);
if (__ref.getField(true,"_isscale").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 336;BA.debugLine="i.PutExtra(\"scale\", \"true\")";
Debug.ShouldStop(32768);
_i.runVoidMethod ("PutExtra",(Object)(BA.ObjectToString("scale")),(Object)((RemoteObject.createImmutable("true"))));
 }else {
 BA.debugLineNum = 338;BA.debugLine="i.PutExtra(\"scale\", \"false\")";
Debug.ShouldStop(131072);
_i.runVoidMethod ("PutExtra",(Object)(BA.ObjectToString("scale")),(Object)((RemoteObject.createImmutable("false"))));
 };
 BA.debugLineNum = 341;BA.debugLine="i.PutExtra(\"outputX\", AspectRatioWidth)";
Debug.ShouldStop(1048576);
_i.runVoidMethod ("PutExtra",(Object)(BA.ObjectToString("outputX")),(Object)((__ref.getField(true,"_aspectratiowidth"))));
 BA.debugLineNum = 342;BA.debugLine="i.PutExtra(\"outputY\", AspectRatioHeight)";
Debug.ShouldStop(2097152);
_i.runVoidMethod ("PutExtra",(Object)(BA.ObjectToString("outputY")),(Object)((__ref.getField(true,"_aspectratioheight"))));
 BA.debugLineNum = 343;BA.debugLine="i.PutExtra(\"output\", u)";
Debug.ShouldStop(4194304);
_i.runVoidMethod ("PutExtra",(Object)(BA.ObjectToString("output")),(Object)(_u));
 BA.debugLineNum = 344;BA.debugLine="StartActivityForResult(i,\"crop\")";
Debug.ShouldStop(8388608);
__ref.runClassMethod (b4a.exampleddd.picturechooser.class, "_startactivityforresult",(Object)(_i),(Object)(RemoteObject.createImmutable("crop")));
 BA.debugLineNum = 346;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _drawroundbitmap(RemoteObject __ref,RemoteObject _cvs,RemoteObject _bmp) throws Exception{
try {
		Debug.PushSubsStack("DrawRoundBitmap (picturechooser) ","picturechooser",1,__ref.getField(false, "ba"),__ref,574);
if (RapidSub.canDelegate("drawroundbitmap")) { return __ref.runUserSub(false, "picturechooser","drawroundbitmap", __ref, _cvs, _bmp);}
RemoteObject _r = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper");
Debug.locals.put("cvs", _cvs);
Debug.locals.put("bmp", _bmp);
 BA.debugLineNum = 574;BA.debugLine="Private Sub DrawRoundBitmap (cvs As Canvas, bmp As";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 575;BA.debugLine="Dim r As Rect";
Debug.ShouldStop(1073741824);
_r = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper");Debug.locals.put("r", _r);
 BA.debugLineNum = 576;BA.debugLine="r.Initialize(0, 0, cvs.Bitmap.Width, cvs.Bitmap.H";
Debug.ShouldStop(-2147483648);
_r.runVoidMethod ("Initialize",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(_cvs.runMethod(false,"getBitmap").runMethod(true,"getWidth")),(Object)(_cvs.runMethod(false,"getBitmap").runMethod(true,"getHeight")));
 BA.debugLineNum = 577;BA.debugLine="cvs.DrawBitmap(bmp, Null, r)";
Debug.ShouldStop(1);
_cvs.runVoidMethod ("DrawBitmap",(Object)((_bmp.getObject())),(Object)((picturechooser.__c.getField(false,"Null"))),(Object)((_r.getObject())));
 BA.debugLineNum = 578;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _fixorientation(RemoteObject __ref,RemoteObject _dir,RemoteObject _filename) throws Exception{
try {
		Debug.PushSubsStack("FixOrientation (picturechooser) ","picturechooser",1,__ref.getField(false, "ba"),__ref,580);
if (RapidSub.canDelegate("fixorientation")) { return __ref.runUserSub(false, "picturechooser","fixorientation", __ref, _dir, _filename);}
RemoteObject _temp = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
RemoteObject _degree = RemoteObject.createImmutable(0f);
RemoteObject _exif = RemoteObject.declareNull("anywheresoftware.b4a.agraham.jpegutils.ExifUtils");
Debug.locals.put("Dir", _dir);
Debug.locals.put("Filename", _filename);
 BA.debugLineNum = 580;BA.debugLine="Private Sub FixOrientation(Dir As String,Filename";
Debug.ShouldStop(8);
 BA.debugLineNum = 582;BA.debugLine="Dim temp As Bitmap";
Debug.ShouldStop(32);
_temp = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("temp", _temp);
 BA.debugLineNum = 583;BA.debugLine="Dim degree As Float";
Debug.ShouldStop(64);
_degree = RemoteObject.createImmutable(0f);Debug.locals.put("degree", _degree);
 BA.debugLineNum = 585;BA.debugLine="Dim exif As ExifData";
Debug.ShouldStop(256);
_exif = RemoteObject.createNew ("anywheresoftware.b4a.agraham.jpegutils.ExifUtils");Debug.locals.put("exif", _exif);
 BA.debugLineNum = 586;BA.debugLine="exif.Initialize(Dir,Filename)";
Debug.ShouldStop(512);
_exif.runVoidMethod ("Initialize",(Object)(_dir),(Object)(_filename));
 BA.debugLineNum = 588;BA.debugLine="Select exif.getAttribute(exif.TAG_ORIENTATION)";
Debug.ShouldStop(2048);
switch (BA.switchObjectToInt(_exif.runMethod(true,"getAttribute",(Object)(_exif.getField(true,"TAG_ORIENTATION"))),BA.NumberToString(_exif.getField(true,"ORIENTATION_ROTATE_180")),BA.NumberToString(_exif.getField(true,"ORIENTATION_ROTATE_270")),BA.NumberToString(_exif.getField(true,"ORIENTATION_ROTATE_90")))) {
case 0: {
 BA.debugLineNum = 590;BA.debugLine="degree = 180";
Debug.ShouldStop(8192);
_degree = BA.numberCast(float.class, 180);Debug.locals.put("degree", _degree);
 break; }
case 1: {
 BA.debugLineNum = 593;BA.debugLine="degree = 270";
Debug.ShouldStop(65536);
_degree = BA.numberCast(float.class, 270);Debug.locals.put("degree", _degree);
 break; }
case 2: {
 BA.debugLineNum = 596;BA.debugLine="degree = 90";
Debug.ShouldStop(524288);
_degree = BA.numberCast(float.class, 90);Debug.locals.put("degree", _degree);
 break; }
}
;
 BA.debugLineNum = 600;BA.debugLine="temp = LoadBitmap(Dir,Filename)";
Debug.ShouldStop(8388608);
_temp = picturechooser.__c.runMethod(false,"LoadBitmap",(Object)(_dir),(Object)(_filename));Debug.locals.put("temp", _temp);
 BA.debugLineNum = 602;BA.debugLine="If degree <> 0 Then";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("!",_degree,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 603;BA.debugLine="temp = RotateBitmap(temp,degree)";
Debug.ShouldStop(67108864);
_temp = __ref.runClassMethod (b4a.exampleddd.picturechooser.class, "_rotatebitmap",(Object)(_temp),(Object)(_degree));Debug.locals.put("temp", _temp);
 };
 BA.debugLineNum = 606;BA.debugLine="Return temp";
Debug.ShouldStop(536870912);
Debug.CheckDeviceExceptions();if (true) return _temp;
 BA.debugLineNum = 608;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getba(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("GetBA (picturechooser) ","picturechooser",1,__ref.getField(false, "ba"),__ref,383);
if (RapidSub.canDelegate("getba")) { return __ref.runUserSub(false, "picturechooser","getba", __ref);}
RemoteObject _jo = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _cls = RemoteObject.createImmutable("");
 BA.debugLineNum = 383;BA.debugLine="Private Sub GetBA As Object";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 384;BA.debugLine="Dim jo As JavaObject";
Debug.ShouldStop(-2147483648);
_jo = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("jo", _jo);
 BA.debugLineNum = 385;BA.debugLine="Dim cls As String = Me";
Debug.ShouldStop(1);
_cls = BA.ObjectToString(__ref);Debug.locals.put("cls", _cls);Debug.locals.put("cls", _cls);
 BA.debugLineNum = 386;BA.debugLine="cls = cls.SubString(\"class \".Length)";
Debug.ShouldStop(2);
_cls = _cls.runMethod(true,"substring",(Object)(RemoteObject.createImmutable("class ").runMethod(true,"length")));Debug.locals.put("cls", _cls);
 BA.debugLineNum = 387;BA.debugLine="jo.InitializeContext";
Debug.ShouldStop(4);
_jo.runVoidMethod ("InitializeContext",__ref.getField(false, "ba"));
 BA.debugLineNum = 388;BA.debugLine="Return jo.GetField(\"processBA\")";
Debug.ShouldStop(8);
Debug.CheckDeviceExceptions();if (true) return _jo.runMethod(false,"GetField",(Object)(RemoteObject.createImmutable("processBA")));
 BA.debugLineNum = 389;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getdir(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("getDir (picturechooser) ","picturechooser",1,__ref.getField(false, "ba"),__ref,471);
if (RapidSub.canDelegate("getdir")) { return __ref.runUserSub(false, "picturechooser","getdir", __ref);}
 BA.debugLineNum = 471;BA.debugLine="Public Sub getDir As String";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 472;BA.debugLine="Return sDir";
Debug.ShouldStop(8388608);
Debug.CheckDeviceExceptions();if (true) return __ref.getField(true,"_sdir");
 BA.debugLineNum = 473;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getfilename(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("getFilename (picturechooser) ","picturechooser",1,__ref.getField(false, "ba"),__ref,476);
if (RapidSub.canDelegate("getfilename")) { return __ref.runUserSub(false, "picturechooser","getfilename", __ref);}
 BA.debugLineNum = 476;BA.debugLine="Public Sub getFilename As String";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 477;BA.debugLine="Return sFilename";
Debug.ShouldStop(268435456);
Debug.CheckDeviceExceptions();if (true) return __ref.getField(true,"_sfilename");
 BA.debugLineNum = 478;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getvisible(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("getVisible (picturechooser) ","picturechooser",1,__ref.getField(false, "ba"),__ref,103);
if (RapidSub.canDelegate("getvisible")) { return __ref.runUserSub(false, "picturechooser","getvisible", __ref);}
 BA.debugLineNum = 103;BA.debugLine="Public Sub getVisible As Boolean";
Debug.ShouldStop(64);
 BA.debugLineNum = 104;BA.debugLine="If p2.IsInitialized = False Then Return False";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean("=",__ref.getField(false,"_p2").runMethod(true,"IsInitialized"),picturechooser.__c.getField(true,"False"))) { 
Debug.CheckDeviceExceptions();if (true) return picturechooser.__c.getField(true,"False");};
 BA.debugLineNum = 105;BA.debugLine="Return p2.Visible";
Debug.ShouldStop(256);
Debug.CheckDeviceExceptions();if (true) return __ref.getField(false,"_p2").runMethod(true,"getVisible");
 BA.debugLineNum = 106;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _gpu_picturetaken(RemoteObject __ref,RemoteObject _data) throws Exception{
try {
		Debug.PushSubsStack("gpu_PictureTaken (picturechooser) ","picturechooser",1,__ref.getField(false, "ba"),__ref,161);
if (RapidSub.canDelegate("gpu_picturetaken")) { return __ref.runUserSub(false, "picturechooser","gpu_picturetaken", __ref, _data);}
RemoteObject _ou = RemoteObject.declareNull("anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper");
RemoteObject _b2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
Debug.locals.put("Data", _data);
 BA.debugLineNum = 161;BA.debugLine="Private Sub gpu_PictureTaken (Data() As Byte)";
Debug.ShouldStop(1);
 BA.debugLineNum = 163;BA.debugLine="Dim ou As OutputStream";
Debug.ShouldStop(4);
_ou = RemoteObject.createNew ("anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper");Debug.locals.put("ou", _ou);
 BA.debugLineNum = 164;BA.debugLine="ou = File.OpenOutput(File.DirInternal,\"temp.jpg\",";
Debug.ShouldStop(8);
_ou = picturechooser.__c.getField(false,"File").runMethod(false,"OpenOutput",(Object)(picturechooser.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("temp.jpg")),(Object)(picturechooser.__c.getField(true,"False")));Debug.locals.put("ou", _ou);
 BA.debugLineNum = 165;BA.debugLine="ou.WriteBytes(Data,0,Data.Length)";
Debug.ShouldStop(16);
_ou.runVoidMethod ("WriteBytes",(Object)(_data),(Object)(BA.numberCast(int.class, 0)),(Object)(_data.getField(true,"length")));
 BA.debugLineNum = 166;BA.debugLine="ou.Close";
Debug.ShouldStop(32);
_ou.runVoidMethod ("Close");
 BA.debugLineNum = 168;BA.debugLine="Dim b2 As Bitmap";
Debug.ShouldStop(128);
_b2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("b2", _b2);
 BA.debugLineNum = 169;BA.debugLine="b2.InitializeResize(File.DirInternal,\"temp.jpg\",1";
Debug.ShouldStop(256);
_b2.runVoidMethod ("InitializeResize",(Object)(picturechooser.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("temp.jpg")),(Object)(picturechooser.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 150)),__ref.getField(false, "ba"))),(Object)(picturechooser.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 150)),__ref.getField(false, "ba"))),(Object)(picturechooser.__c.getField(true,"True")));
 BA.debugLineNum = 171;BA.debugLine="If IsFrontCamera = False Then";
Debug.ShouldStop(1024);
if (RemoteObject.solveBoolean("=",__ref.getField(true,"_isfrontcamera"),picturechooser.__c.getField(true,"False"))) { 
 BA.debugLineNum = 172;BA.debugLine="b2	=	RotateBitmap(b2,90)";
Debug.ShouldStop(2048);
_b2 = __ref.runClassMethod (b4a.exampleddd.picturechooser.class, "_rotatebitmap",(Object)(_b2),(Object)(BA.numberCast(float.class, 90)));Debug.locals.put("b2", _b2);
 }else {
 BA.debugLineNum = 174;BA.debugLine="b2	=	RotateBitmap(b2,270)";
Debug.ShouldStop(8192);
_b2 = __ref.runClassMethod (b4a.exampleddd.picturechooser.class, "_rotatebitmap",(Object)(_b2),(Object)(BA.numberCast(float.class, 270)));Debug.locals.put("b2", _b2);
 };
 BA.debugLineNum = 177;BA.debugLine="If is_crop Then";
Debug.ShouldStop(65536);
if (__ref.getField(true,"_is_crop").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 179;BA.debugLine="p2.Visible = True";
Debug.ShouldStop(262144);
__ref.getField(false,"_p2").runMethod(true,"setVisible",picturechooser.__c.getField(true,"True"));
 BA.debugLineNum = 181;BA.debugLine="CurrentUserBitmap	=	b2";
Debug.ShouldStop(1048576);
__ref.setField ("_currentuserbitmap",_b2);
 BA.debugLineNum = 182;BA.debugLine="CV.ImageBitmap		=	b2";
Debug.ShouldStop(2097152);
__ref.getField(false,"_cv").runVoidMethod ("setImageBitmap",(_b2.getObject()));
 BA.debugLineNum = 184;BA.debugLine="Return";
Debug.ShouldStop(8388608);
Debug.CheckDeviceExceptions();if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 188;BA.debugLine="If SubExists(modue,evt & \"_result2\") Then";
Debug.ShouldStop(134217728);
if (picturechooser.__c.runMethod(true,"SubExists",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_modue")),(Object)(RemoteObject.concat(__ref.getField(true,"_evt"),RemoteObject.createImmutable("_result2")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 189;BA.debugLine="CallSubDelayed3(modue,evt & \"_Result2\",File.DirI";
Debug.ShouldStop(268435456);
picturechooser.__c.runVoidMethod ("CallSubDelayed3",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_modue")),(Object)(RemoteObject.concat(__ref.getField(true,"_evt"),RemoteObject.createImmutable("_Result2"))),(Object)((picturechooser.__c.getField(false,"File").runMethod(true,"getDirInternal"))),(Object)((RemoteObject.createImmutable("temp.jpg"))));
 }else {
 BA.debugLineNum = 191;BA.debugLine="CallSubDelayed2(modue,evt & \"_result\",LoadBitmap";
Debug.ShouldStop(1073741824);
picturechooser.__c.runVoidMethod ("CallSubDelayed2",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_modue")),(Object)(RemoteObject.concat(__ref.getField(true,"_evt"),RemoteObject.createImmutable("_result"))),(Object)((picturechooser.__c.runMethod(false,"LoadBitmap",(Object)(picturechooser.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("temp.jpg"))))));
 };
 BA.debugLineNum = 194;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _initialize(RemoteObject __ref,RemoteObject _ba,RemoteObject _parent,RemoteObject _module,RemoteObject _eventresult) throws Exception{
try {
		Debug.PushSubsStack("Initialize (picturechooser) ","picturechooser",1,__ref.getField(false, "ba"),__ref,43);
if (RapidSub.canDelegate("initialize")) { return __ref.runUserSub(false, "picturechooser","initialize", __ref, _ba, _parent, _module, _eventresult);}
__ref.runVoidMethodAndSync("innerInitializeHelper", _ba);
Debug.locals.put("ba", _ba);
Debug.locals.put("Parent", _parent);
Debug.locals.put("Module", _module);
Debug.locals.put("EventResult", _eventresult);
 BA.debugLineNum = 43;BA.debugLine="Public Sub Initialize(Parent As Panel,Module As Ob";
Debug.ShouldStop(1024);
 BA.debugLineNum = 45;BA.debugLine="modue	= Module";
Debug.ShouldStop(4096);
__ref.setField ("_modue",_module);
 BA.debugLineNum = 46;BA.debugLine="evt		= EventResult";
Debug.ShouldStop(8192);
__ref.setField ("_evt",_eventresult);
 BA.debugLineNum = 48;BA.debugLine="chooser.Initialize(\"cc\")";
Debug.ShouldStop(32768);
__ref.getField(false,"_chooser").runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("cc")));
 BA.debugLineNum = 50;BA.debugLine="tempImageFile	= \"temp.jpg\"";
Debug.ShouldStop(131072);
__ref.setField ("_tempimagefile",BA.ObjectToString("temp.jpg"));
 BA.debugLineNum = 51;BA.debugLine="imageFolder 	= rp.GetSafeDirDefaultExternal(\"cach";
Debug.ShouldStop(262144);
__ref.setField ("_imagefolder",__ref.getField(false,"_rp").runMethod(true,"GetSafeDirDefaultExternal",(Object)(RemoteObject.createImmutable("cache"))));
 BA.debugLineNum = 53;BA.debugLine="If Parent = Null Then Return";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean("n",_parent)) { 
Debug.CheckDeviceExceptions();if (true) return RemoteObject.createImmutable("");};
 BA.debugLineNum = 54;BA.debugLine="If Parent.IsInitialized = False Then Return";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("=",_parent.runMethod(true,"IsInitialized"),picturechooser.__c.getField(true,"False"))) { 
Debug.CheckDeviceExceptions();if (true) return RemoteObject.createImmutable("");};
 BA.debugLineNum = 56;BA.debugLine="p2.Initialize(\"p2Panel\")";
Debug.ShouldStop(8388608);
__ref.getField(false,"_p2").runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("p2Panel")));
 BA.debugLineNum = 57;BA.debugLine="p2.Visible = False";
Debug.ShouldStop(16777216);
__ref.getField(false,"_p2").runMethod(true,"setVisible",picturechooser.__c.getField(true,"False"));
 BA.debugLineNum = 58;BA.debugLine="p2.Color = Colors.RGB(30, 30, 30)";
Debug.ShouldStop(33554432);
__ref.getField(false,"_p2").runVoidMethod ("setColor",picturechooser.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 30)),(Object)(BA.numberCast(int.class, 30)),(Object)(BA.numberCast(int.class, 30))));
 BA.debugLineNum = 59;BA.debugLine="Parent.AddView(p2,0,0,Parent.Width,Parent.Height)";
Debug.ShouldStop(67108864);
_parent.runVoidMethod ("AddView",(Object)((__ref.getField(false,"_p2").getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(_parent.runMethod(true,"getWidth")),(Object)(_parent.runMethod(true,"getHeight")));
 BA.debugLineNum = 61;BA.debugLine="CV.Initialize(\"SCV\")";
Debug.ShouldStop(268435456);
__ref.getField(false,"_cv").runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("SCV")));
 BA.debugLineNum = 62;BA.debugLine="p2.AddView(CV,0,0,p2.Width,p2.Height)";
Debug.ShouldStop(536870912);
__ref.getField(false,"_p2").runVoidMethod ("AddView",(Object)((__ref.getField(false,"_cv").getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(__ref.getField(false,"_p2").runMethod(true,"getWidth")),(Object)(__ref.getField(false,"_p2").runMethod(true,"getHeight")));
 BA.debugLineNum = 64;BA.debugLine="b.Initialize(\"btncrop\")";
Debug.ShouldStop(-2147483648);
__ref.getField(false,"_b").runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("btncrop")));
 BA.debugLineNum = 65;BA.debugLine="b.Text		= crop_title";
Debug.ShouldStop(1);
__ref.getField(false,"_b").runMethod(true,"setText",BA.ObjectToCharSequence(__ref.getField(true,"_crop_title")));
 BA.debugLineNum = 66;BA.debugLine="b.TextColor = Colors.White";
Debug.ShouldStop(2);
__ref.getField(false,"_b").runMethod(true,"setTextColor",picturechooser.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 67;BA.debugLine="b.TextSize	= 13";
Debug.ShouldStop(4);
__ref.getField(false,"_b").runMethod(true,"setTextSize",BA.numberCast(float.class, 13));
 BA.debugLineNum = 68;BA.debugLine="b.Color		= Colors.RGB(51, 51, 55)";
Debug.ShouldStop(8);
__ref.getField(false,"_b").runVoidMethod ("setColor",picturechooser.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 51)),(Object)(BA.numberCast(int.class, 51)),(Object)(BA.numberCast(int.class, 55))));
 BA.debugLineNum = 69;BA.debugLine="p2.AddView(b,0,p2.Height - 40dip,p2.Width/3,40dip";
Debug.ShouldStop(16);
__ref.getField(false,"_p2").runVoidMethod ("AddView",(Object)((__ref.getField(false,"_b").getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_p2").runMethod(true,"getHeight"),picturechooser.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))}, "-",1, 1)),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_p2").runMethod(true,"getWidth"),RemoteObject.createImmutable(3)}, "/",0, 0))),(Object)(picturechooser.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))));
 BA.debugLineNum = 71;BA.debugLine="btnrotate.Initialize(\"btnrotate\")";
Debug.ShouldStop(64);
__ref.getField(false,"_btnrotate").runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("btnrotate")));
 BA.debugLineNum = 72;BA.debugLine="btnrotate.Text = rotate_title";
Debug.ShouldStop(128);
__ref.getField(false,"_btnrotate").runMethod(true,"setText",BA.ObjectToCharSequence(__ref.getField(true,"_rotate_title")));
 BA.debugLineNum = 73;BA.debugLine="btnrotate.TextColor = Colors.White";
Debug.ShouldStop(256);
__ref.getField(false,"_btnrotate").runMethod(true,"setTextColor",picturechooser.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 74;BA.debugLine="btnrotate.TextSize = 13";
Debug.ShouldStop(512);
__ref.getField(false,"_btnrotate").runMethod(true,"setTextSize",BA.numberCast(float.class, 13));
 BA.debugLineNum = 75;BA.debugLine="btnrotate.Color = Colors.RGB(51, 51, 55)";
Debug.ShouldStop(1024);
__ref.getField(false,"_btnrotate").runVoidMethod ("setColor",picturechooser.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 51)),(Object)(BA.numberCast(int.class, 51)),(Object)(BA.numberCast(int.class, 55))));
 BA.debugLineNum = 76;BA.debugLine="p2.AddView(btnrotate,b.Width,Parent.Height - 40di";
Debug.ShouldStop(2048);
__ref.getField(false,"_p2").runVoidMethod ("AddView",(Object)((__ref.getField(false,"_btnrotate").getObject())),(Object)(__ref.getField(false,"_b").runMethod(true,"getWidth")),(Object)(RemoteObject.solve(new RemoteObject[] {_parent.runMethod(true,"getHeight"),picturechooser.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))}, "-",1, 1)),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_parent.runMethod(true,"getWidth"),RemoteObject.createImmutable(3)}, "/",0, 0))),(Object)(picturechooser.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))));
 BA.debugLineNum = 78;BA.debugLine="cancel.Initialize(\"btncancel\")";
Debug.ShouldStop(8192);
__ref.getField(false,"_cancel").runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("btncancel")));
 BA.debugLineNum = 79;BA.debugLine="cancel.Text = cancel_title";
Debug.ShouldStop(16384);
__ref.getField(false,"_cancel").runMethod(true,"setText",BA.ObjectToCharSequence(__ref.getField(true,"_cancel_title")));
 BA.debugLineNum = 80;BA.debugLine="cancel.TextSize = 13";
Debug.ShouldStop(32768);
__ref.getField(false,"_cancel").runMethod(true,"setTextSize",BA.numberCast(float.class, 13));
 BA.debugLineNum = 81;BA.debugLine="cancel.TextColor = Colors.White";
Debug.ShouldStop(65536);
__ref.getField(false,"_cancel").runMethod(true,"setTextColor",picturechooser.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 82;BA.debugLine="cancel.Color = Colors.RGB(51, 51, 55)";
Debug.ShouldStop(131072);
__ref.getField(false,"_cancel").runVoidMethod ("setColor",picturechooser.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 51)),(Object)(BA.numberCast(int.class, 51)),(Object)(BA.numberCast(int.class, 55))));
 BA.debugLineNum = 83;BA.debugLine="p2.AddView(cancel,p2.Width - (p2.Width/3),p2.Heig";
Debug.ShouldStop(262144);
__ref.getField(false,"_p2").runVoidMethod ("AddView",(Object)((__ref.getField(false,"_cancel").getObject())),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_p2").runMethod(true,"getWidth"),(RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_p2").runMethod(true,"getWidth"),RemoteObject.createImmutable(3)}, "/",0, 0))}, "-",1, 0))),(Object)(RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_p2").runMethod(true,"getHeight"),picturechooser.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))}, "-",1, 1)),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_p2").runMethod(true,"getWidth"),RemoteObject.createImmutable(3)}, "/",0, 0))),(Object)(picturechooser.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))));
 BA.debugLineNum = 85;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _ion_event(RemoteObject __ref,RemoteObject _methodname,RemoteObject _args) throws Exception{
try {
		Debug.PushSubsStack("ion_Event (picturechooser) ","picturechooser",1,__ref.getField(false, "ba"),__ref,267);
if (RapidSub.canDelegate("ion_event")) { return __ref.runUserSub(false, "picturechooser","ion_event", __ref, _methodname, _args);}
RemoteObject _lastpicture = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
RemoteObject _in = RemoteObject.declareNull("anywheresoftware.b4a.objects.IntentWrapper");
RemoteObject _jo = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
Debug.locals.put("MethodName", _methodname);
Debug.locals.put("Args", _args);
 BA.debugLineNum = 267;BA.debugLine="Private Sub ion_Event (MethodName As String, Args(";
Debug.ShouldStop(1024);
 BA.debugLineNum = 269;BA.debugLine="Dim lastPicture As Bitmap";
Debug.ShouldStop(4096);
_lastpicture = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("lastPicture", _lastpicture);
 BA.debugLineNum = 271;BA.debugLine="If Args.Length > 0 Then";
Debug.ShouldStop(16384);
if (RemoteObject.solveBoolean(">",_args.getField(true,"length"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 272;BA.debugLine="If Args(1) = Null Then Return Null";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("n",_args.getArrayElement(false,BA.numberCast(int.class, 1)))) { 
Debug.CheckDeviceExceptions();if (true) return picturechooser.__c.getField(false,"Null");};
 };
 BA.debugLineNum = 275;BA.debugLine="If Args.Length = 0 Then Return Null";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean("=",_args.getField(true,"length"),BA.numberCast(double.class, 0))) { 
Debug.CheckDeviceExceptions();if (true) return picturechooser.__c.getField(false,"Null");};
 BA.debugLineNum = 277;BA.debugLine="If Args(0) = -1 Then";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean("=",_args.getArrayElement(false,BA.numberCast(int.class, 0)),RemoteObject.createImmutable((-(double) (0 + 1))))) { 
 BA.debugLineNum = 278;BA.debugLine="Try";
Debug.ShouldStop(2097152);
try { BA.debugLineNum = 279;BA.debugLine="Dim in As Intent = Args(1)";
Debug.ShouldStop(4194304);
_in = RemoteObject.createNew ("anywheresoftware.b4a.objects.IntentWrapper");
_in.setObject(_args.getArrayElement(false,BA.numberCast(int.class, 1)));Debug.locals.put("in", _in);
 BA.debugLineNum = 280;BA.debugLine="If File.Exists(imageFolder, tempImageFile) Then";
Debug.ShouldStop(8388608);
if (picturechooser.__c.getField(false,"File").runMethod(true,"Exists",(Object)(__ref.getField(true,"_imagefolder")),(Object)(__ref.getField(true,"_tempimagefile"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 281;BA.debugLine="lastPicture = LoadBitmap(imageFolder, tempImag";
Debug.ShouldStop(16777216);
_lastpicture = picturechooser.__c.runMethod(false,"LoadBitmap",(Object)(__ref.getField(true,"_imagefolder")),(Object)(__ref.getField(true,"_tempimagefile")));Debug.locals.put("lastPicture", _lastpicture);
 }else 
{ BA.debugLineNum = 282;BA.debugLine="Else If in.HasExtra(\"data\") Then 'try to get th";
Debug.ShouldStop(33554432);
if (_in.runMethod(true,"HasExtra",(Object)(RemoteObject.createImmutable("data"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 283;BA.debugLine="Dim jo As JavaObject = in";
Debug.ShouldStop(67108864);
_jo = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
_jo.setObject(_in.getObject());Debug.locals.put("jo", _jo);
 BA.debugLineNum = 284;BA.debugLine="lastPicture = jo.RunMethodJO(\"getExtras\", Null";
Debug.ShouldStop(134217728);
_lastpicture.setObject(_jo.runMethod(false,"RunMethodJO",(Object)(BA.ObjectToString("getExtras")),(Object)((picturechooser.__c.getField(false,"Null")))).runMethod(false,"RunMethod",(Object)(BA.ObjectToString("get")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(RemoteObject.createImmutable("data"))}))));
 }}
;
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e16) {
			BA.rdebugUtils.runVoidMethod("setLastException",__ref.getField(false, "ba"), e16.toString()); BA.debugLineNum = 287;BA.debugLine="Return Null";
Debug.ShouldStop(1073741824);
Debug.CheckDeviceExceptions();if (true) return picturechooser.__c.getField(false,"Null");
 };
 BA.debugLineNum = 290;BA.debugLine="If is_crop Then";
Debug.ShouldStop(2);
if (__ref.getField(true,"_is_crop").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 292;BA.debugLine="p2.Visible = True";
Debug.ShouldStop(8);
__ref.getField(false,"_p2").runMethod(true,"setVisible",picturechooser.__c.getField(true,"True"));
 BA.debugLineNum = 293;BA.debugLine="p2.BringToFront";
Debug.ShouldStop(16);
__ref.getField(false,"_p2").runVoidMethod ("BringToFront");
 BA.debugLineNum = 294;BA.debugLine="Try";
Debug.ShouldStop(32);
try { BA.debugLineNum = 295;BA.debugLine="CV.ImageBitmap		=	lastPicture.Resize(150%x,150";
Debug.ShouldStop(64);
__ref.getField(false,"_cv").runVoidMethod ("setImageBitmap",(_lastpicture.runMethod(false,"Resize",(Object)(BA.numberCast(float.class, picturechooser.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 150)),__ref.getField(false, "ba")))),(Object)(BA.numberCast(float.class, picturechooser.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 150)),__ref.getField(false, "ba")))),(Object)(picturechooser.__c.getField(true,"True"))).getObject()));
 BA.debugLineNum = 296;BA.debugLine="CurrentUserBitmap	=	lastPicture.Resize(150%x,1";
Debug.ShouldStop(128);
__ref.setField ("_currentuserbitmap",_lastpicture.runMethod(false,"Resize",(Object)(BA.numberCast(float.class, picturechooser.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 150)),__ref.getField(false, "ba")))),(Object)(BA.numberCast(float.class, picturechooser.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 150)),__ref.getField(false, "ba")))),(Object)(picturechooser.__c.getField(true,"True"))));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e25) {
			BA.rdebugUtils.runVoidMethod("setLastException",__ref.getField(false, "ba"), e25.toString()); BA.debugLineNum = 298;BA.debugLine="Return Null";
Debug.ShouldStop(512);
Debug.CheckDeviceExceptions();if (true) return picturechooser.__c.getField(false,"Null");
 };
 BA.debugLineNum = 300;BA.debugLine="Return Null";
Debug.ShouldStop(2048);
Debug.CheckDeviceExceptions();if (true) return picturechooser.__c.getField(false,"Null");
 };
 };
 BA.debugLineNum = 304;BA.debugLine="Return Null";
Debug.ShouldStop(32768);
Debug.CheckDeviceExceptions();if (true) return picturechooser.__c.getField(false,"Null");
 BA.debugLineNum = 305;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _p2panel_click(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("p2Panel_Click (picturechooser) ","picturechooser",1,__ref.getField(false, "ba"),__ref,87);
if (RapidSub.canDelegate("p2panel_click")) { return __ref.runUserSub(false, "picturechooser","p2panel_click", __ref);}
 BA.debugLineNum = 87;BA.debugLine="Private Sub p2Panel_Click";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 89;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _requestpermissioncamera(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("RequestPermissionCamera (picturechooser) ","picturechooser",1,__ref.getField(false, "ba"),__ref,139);
if (RapidSub.canDelegate("requestpermissioncamera")) { return __ref.runUserSub(false, "picturechooser","requestpermissioncamera", __ref);}
RemoteObject _r = RemoteObject.declareNull("anywheresoftware.b4a.objects.RuntimePermissions");
 BA.debugLineNum = 139;BA.debugLine="Public Sub RequestPermissionCamera As Boolean";
Debug.ShouldStop(1024);
 BA.debugLineNum = 141;BA.debugLine="Dim r As RuntimePermissions";
Debug.ShouldStop(4096);
_r = RemoteObject.createNew ("anywheresoftware.b4a.objects.RuntimePermissions");Debug.locals.put("r", _r);
 BA.debugLineNum = 142;BA.debugLine="r.CheckAndRequest(r.PERMISSION_CAMERA)";
Debug.ShouldStop(8192);
_r.runVoidMethod ("CheckAndRequest",__ref.getField(false, "ba"),(Object)(_r.getField(true,"PERMISSION_CAMERA")));
 BA.debugLineNum = 144;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _resizebitmap(RemoteObject __ref,RemoteObject _original,RemoteObject _width,RemoteObject _height) throws Exception{
try {
		Debug.PushSubsStack("ResizeBitmap (picturechooser) ","picturechooser",1,__ref.getField(false, "ba"),__ref,486);
if (RapidSub.canDelegate("resizebitmap")) { return __ref.runUserSub(false, "picturechooser","resizebitmap", __ref, _original, _width, _height);}
RemoteObject _new = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
RemoteObject _c = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper");
RemoteObject _destrect = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper");
Debug.locals.put("Original", _original);
Debug.locals.put("Width", _width);
Debug.locals.put("Height", _height);
 BA.debugLineNum = 486;BA.debugLine="Public Sub ResizeBitmap(Original As Bitmap, Width";
Debug.ShouldStop(32);
 BA.debugLineNum = 487;BA.debugLine="Dim new As Bitmap";
Debug.ShouldStop(64);
_new = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("new", _new);
 BA.debugLineNum = 488;BA.debugLine="new.InitializeMutable(Width, Height)";
Debug.ShouldStop(128);
_new.runVoidMethod ("InitializeMutable",(Object)(_width),(Object)(_height));
 BA.debugLineNum = 489;BA.debugLine="Dim c As Canvas";
Debug.ShouldStop(256);
_c = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper");Debug.locals.put("c", _c);
 BA.debugLineNum = 490;BA.debugLine="c.Initialize2(new)";
Debug.ShouldStop(512);
_c.runVoidMethod ("Initialize2",(Object)((_new.getObject())));
 BA.debugLineNum = 491;BA.debugLine="Dim destRect As Rect";
Debug.ShouldStop(1024);
_destrect = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper");Debug.locals.put("destRect", _destrect);
 BA.debugLineNum = 492;BA.debugLine="destRect.Initialize(0, 0, Width, Height)";
Debug.ShouldStop(2048);
_destrect.runVoidMethod ("Initialize",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(_width),(Object)(_height));
 BA.debugLineNum = 493;BA.debugLine="c.DrawBitmap(Original, Null, destRect)";
Debug.ShouldStop(4096);
_c.runVoidMethod ("DrawBitmap",(Object)((_original.getObject())),(Object)((picturechooser.__c.getField(false,"Null"))),(Object)((_destrect.getObject())));
 BA.debugLineNum = 494;BA.debugLine="Return new";
Debug.ShouldStop(8192);
Debug.CheckDeviceExceptions();if (true) return _new;
 BA.debugLineNum = 495;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _resizepicture(RemoteObject __ref,RemoteObject _dir,RemoteObject _filename,RemoteObject _outputfilename,RemoteObject _width,RemoteObject _height) throws Exception{
try {
		Debug.PushSubsStack("ResizePicture (picturechooser) ","picturechooser",1,__ref.getField(false, "ba"),__ref,497);
if (RapidSub.canDelegate("resizepicture")) { return __ref.runUserSub(false, "picturechooser","resizepicture", __ref, _dir, _filename, _outputfilename, _width, _height);}
RemoteObject _new = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
RemoteObject _original = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
RemoteObject _c = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper");
RemoteObject _destrect = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper");
Debug.locals.put("Dir", _dir);
Debug.locals.put("Filename", _filename);
Debug.locals.put("OutputFilename", _outputfilename);
Debug.locals.put("Width", _width);
Debug.locals.put("Height", _height);
 BA.debugLineNum = 497;BA.debugLine="Public Sub ResizePicture(Dir As String, Filename A";
Debug.ShouldStop(65536);
 BA.debugLineNum = 498;BA.debugLine="Dim new,Original As Bitmap";
Debug.ShouldStop(131072);
_new = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("new", _new);
_original = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("Original", _original);
 BA.debugLineNum = 499;BA.debugLine="Original = LoadBitmap(Dir,Filename)";
Debug.ShouldStop(262144);
_original = picturechooser.__c.runMethod(false,"LoadBitmap",(Object)(_dir),(Object)(_filename));Debug.locals.put("Original", _original);
 BA.debugLineNum = 500;BA.debugLine="new.InitializeMutable(Width, Height)";
Debug.ShouldStop(524288);
_new.runVoidMethod ("InitializeMutable",(Object)(_width),(Object)(_height));
 BA.debugLineNum = 501;BA.debugLine="Dim c As Canvas";
Debug.ShouldStop(1048576);
_c = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper");Debug.locals.put("c", _c);
 BA.debugLineNum = 502;BA.debugLine="c.Initialize2(new)";
Debug.ShouldStop(2097152);
_c.runVoidMethod ("Initialize2",(Object)((_new.getObject())));
 BA.debugLineNum = 503;BA.debugLine="Dim destRect As Rect";
Debug.ShouldStop(4194304);
_destrect = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper");Debug.locals.put("destRect", _destrect);
 BA.debugLineNum = 504;BA.debugLine="destRect.Initialize(0, 0, Width, Height)";
Debug.ShouldStop(8388608);
_destrect.runVoidMethod ("Initialize",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(_width),(Object)(_height));
 BA.debugLineNum = 505;BA.debugLine="c.DrawBitmap(Original, Null, destRect)";
Debug.ShouldStop(16777216);
_c.runVoidMethod ("DrawBitmap",(Object)((_original.getObject())),(Object)((picturechooser.__c.getField(false,"Null"))),(Object)((_destrect.getObject())));
 BA.debugLineNum = 506;BA.debugLine="SaveBitmap(new,Dir,OutputFilename,70)";
Debug.ShouldStop(33554432);
__ref.runClassMethod (b4a.exampleddd.picturechooser.class, "_savebitmap",(Object)(_new),(Object)(_dir),(Object)(_outputfilename),(Object)(BA.numberCast(int.class, 70)));
 BA.debugLineNum = 507;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _rotatebitmap(RemoteObject __ref,RemoteObject _original,RemoteObject _degree) throws Exception{
try {
		Debug.PushSubsStack("RotateBitmap (picturechooser) ","picturechooser",1,__ref.getField(false, "ba"),__ref,480);
if (RapidSub.canDelegate("rotatebitmap")) { return __ref.runUserSub(false, "picturechooser","rotatebitmap", __ref, _original, _degree);}
RemoteObject _r = RemoteObject.declareNull("com.rootsoft.imageprocessing.RSImageProcessing");
Debug.locals.put("Original", _original);
Debug.locals.put("Degree", _degree);
 BA.debugLineNum = 480;BA.debugLine="Public Sub RotateBitmap(Original As Bitmap, Degree";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 481;BA.debugLine="Dim r As RSImageProcessing";
Debug.ShouldStop(1);
_r = RemoteObject.createNew ("com.rootsoft.imageprocessing.RSImageProcessing");Debug.locals.put("r", _r);
 BA.debugLineNum = 482;BA.debugLine="r.Initialize";
Debug.ShouldStop(2);
_r.runVoidMethod ("Initialize");
 BA.debugLineNum = 483;BA.debugLine="Return r.rotate(Original,Degree)";
Debug.ShouldStop(4);
Debug.CheckDeviceExceptions();if (true) return RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), _r.runMethod(false,"rotate",(Object)((_original.getObject())),(Object)(_degree)));
 BA.debugLineNum = 484;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _roundbitmap(RemoteObject __ref,RemoteObject _bitmap) throws Exception{
try {
		Debug.PushSubsStack("RoundBitmap (picturechooser) ","picturechooser",1,__ref.getField(false, "ba"),__ref,540);
if (RapidSub.canDelegate("roundbitmap")) { return __ref.runUserSub(false, "picturechooser","roundbitmap", __ref, _bitmap);}
RemoteObject _cvs = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper");
Debug.locals.put("Bitmap", _bitmap);
 BA.debugLineNum = 540;BA.debugLine="Public Sub RoundBitmap(Bitmap As Bitmap) As Bitmap";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 541;BA.debugLine="Dim cvs As Canvas = CreateBitmap";
Debug.ShouldStop(268435456);
_cvs = __ref.runClassMethod (b4a.exampleddd.picturechooser.class, "_createbitmap");Debug.locals.put("cvs", _cvs);Debug.locals.put("cvs", _cvs);
 BA.debugLineNum = 542;BA.debugLine="DrawRoundBitmap(cvs,Bitmap)";
Debug.ShouldStop(536870912);
__ref.runClassMethod (b4a.exampleddd.picturechooser.class, "_drawroundbitmap",(Object)(_cvs),(Object)(_bitmap));
 BA.debugLineNum = 543;BA.debugLine="Return cvs.Bitmap";
Debug.ShouldStop(1073741824);
Debug.CheckDeviceExceptions();if (true) return _cvs.runMethod(false,"getBitmap");
 BA.debugLineNum = 544;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _roundbitmap2(RemoteObject __ref,RemoteObject _bitmap,RemoteObject _corner) throws Exception{
try {
		Debug.PushSubsStack("RoundBitmap2 (picturechooser) ","picturechooser",1,__ref.getField(false, "ba"),__ref,546);
if (RapidSub.canDelegate("roundbitmap2")) { return __ref.runUserSub(false, "picturechooser","roundbitmap2", __ref, _bitmap, _corner);}
RemoteObject _rsie = RemoteObject.declareNull("com.rootsoft.imageprocessing.RSImageEffects");
RemoteObject _rsip = RemoteObject.declareNull("com.rootsoft.imageprocessing.RSImageProcessing");
Debug.locals.put("Bitmap", _bitmap);
Debug.locals.put("Corner", _corner);
 BA.debugLineNum = 546;BA.debugLine="Public Sub RoundBitmap2(Bitmap As Bitmap,Corner As";
Debug.ShouldStop(2);
 BA.debugLineNum = 548;BA.debugLine="Dim rsie As RSImageEffects";
Debug.ShouldStop(8);
_rsie = RemoteObject.createNew ("com.rootsoft.imageprocessing.RSImageEffects");Debug.locals.put("rsie", _rsie);
 BA.debugLineNum = 549;BA.debugLine="Dim rsip As RSImageProcessing";
Debug.ShouldStop(16);
_rsip = RemoteObject.createNew ("com.rootsoft.imageprocessing.RSImageProcessing");Debug.locals.put("rsip", _rsip);
 BA.debugLineNum = 551;BA.debugLine="rsip.Initialize";
Debug.ShouldStop(64);
_rsip.runVoidMethod ("Initialize");
 BA.debugLineNum = 552;BA.debugLine="Bitmap = rsip.createScaledBitmap(Bitmap,Bitmap.Wi";
Debug.ShouldStop(128);
_bitmap.setObject(_rsip.runMethod(false,"createScaledBitmap",(Object)((_bitmap.getObject())),(Object)(_bitmap.runMethod(true,"getWidth")),(Object)(_bitmap.runMethod(true,"getHeight")),(Object)(picturechooser.__c.getField(true,"False"))));
 BA.debugLineNum = 553;BA.debugLine="Return rsie.RoundCorner(Bitmap, Corner)";
Debug.ShouldStop(256);
Debug.CheckDeviceExceptions();if (true) return RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), _rsie.runMethod(false,"RoundCorner",(Object)((_bitmap.getObject())),(Object)(BA.numberCast(float.class, _corner))));
 BA.debugLineNum = 555;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _savebitmap(RemoteObject __ref,RemoteObject _bitmap,RemoteObject _dir,RemoteObject _filename,RemoteObject _quality) throws Exception{
try {
		Debug.PushSubsStack("SaveBitmap (picturechooser) ","picturechooser",1,__ref.getField(false, "ba"),__ref,510);
if (RapidSub.canDelegate("savebitmap")) { return __ref.runUserSub(false, "picturechooser","savebitmap", __ref, _bitmap, _dir, _filename, _quality);}
RemoteObject _b1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
RemoteObject _out = RemoteObject.declareNull("anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper");
Debug.locals.put("Bitmap", _bitmap);
Debug.locals.put("Dir", _dir);
Debug.locals.put("Filename", _filename);
Debug.locals.put("Quality", _quality);
 BA.debugLineNum = 510;BA.debugLine="Public Sub SaveBitmap(Bitmap As Bitmap,Dir As Stri";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 511;BA.debugLine="Dim b1 As Bitmap";
Debug.ShouldStop(1073741824);
_b1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("b1", _b1);
 BA.debugLineNum = 512;BA.debugLine="Dim out As OutputStream";
Debug.ShouldStop(-2147483648);
_out = RemoteObject.createNew ("anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper");Debug.locals.put("out", _out);
 BA.debugLineNum = 513;BA.debugLine="b1 = Bitmap";
Debug.ShouldStop(1);
_b1 = _bitmap;Debug.locals.put("b1", _b1);
 BA.debugLineNum = 514;BA.debugLine="out = File.OpenOutput(Dir,Filename,False)";
Debug.ShouldStop(2);
_out = picturechooser.__c.getField(false,"File").runMethod(false,"OpenOutput",(Object)(_dir),(Object)(_filename),(Object)(picturechooser.__c.getField(true,"False")));Debug.locals.put("out", _out);
 BA.debugLineNum = 515;BA.debugLine="b1.WriteToStream(out,Quality,\"JPEG\")";
Debug.ShouldStop(4);
_b1.runVoidMethod ("WriteToStream",(Object)((_out.getObject())),(Object)(_quality),(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.Bitmap.CompressFormat"),RemoteObject.createImmutable("JPEG"))));
 BA.debugLineNum = 516;BA.debugLine="out.Close";
Debug.ShouldStop(8);
_out.runVoidMethod ("Close");
 BA.debugLineNum = 517;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _savebitmap2(RemoteObject __ref,RemoteObject _bitmap,RemoteObject _dir,RemoteObject _filename) throws Exception{
try {
		Debug.PushSubsStack("SaveBitmap2 (picturechooser) ","picturechooser",1,__ref.getField(false, "ba"),__ref,531);
if (RapidSub.canDelegate("savebitmap2")) { return __ref.runUserSub(false, "picturechooser","savebitmap2", __ref, _bitmap, _dir, _filename);}
RemoteObject _b1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
RemoteObject _out = RemoteObject.declareNull("anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper");
Debug.locals.put("Bitmap", _bitmap);
Debug.locals.put("Dir", _dir);
Debug.locals.put("Filename", _filename);
 BA.debugLineNum = 531;BA.debugLine="Public Sub SaveBitmap2(Bitmap As Bitmap,Dir As Str";
Debug.ShouldStop(262144);
 BA.debugLineNum = 532;BA.debugLine="Dim b1 As Bitmap";
Debug.ShouldStop(524288);
_b1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("b1", _b1);
 BA.debugLineNum = 533;BA.debugLine="Dim out As OutputStream";
Debug.ShouldStop(1048576);
_out = RemoteObject.createNew ("anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper");Debug.locals.put("out", _out);
 BA.debugLineNum = 534;BA.debugLine="b1 = Bitmap";
Debug.ShouldStop(2097152);
_b1 = _bitmap;Debug.locals.put("b1", _b1);
 BA.debugLineNum = 535;BA.debugLine="out = File.OpenOutput(Dir,Filename,False)";
Debug.ShouldStop(4194304);
_out = picturechooser.__c.getField(false,"File").runMethod(false,"OpenOutput",(Object)(_dir),(Object)(_filename),(Object)(picturechooser.__c.getField(true,"False")));Debug.locals.put("out", _out);
 BA.debugLineNum = 536;BA.debugLine="b1.WriteToStream(out,100,\"PNG\")";
Debug.ShouldStop(8388608);
_b1.runVoidMethod ("WriteToStream",(Object)((_out.getObject())),(Object)(BA.numberCast(int.class, 100)),(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.Bitmap.CompressFormat"),RemoteObject.createImmutable("PNG"))));
 BA.debugLineNum = 537;BA.debugLine="out.Close";
Debug.ShouldStop(16777216);
_out.runVoidMethod ("Close");
 BA.debugLineNum = 538;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _savebitmap3(RemoteObject __ref,RemoteObject _bitmap,RemoteObject _dir,RemoteObject _filename,RemoteObject _format,RemoteObject _quality) throws Exception{
try {
		Debug.PushSubsStack("SaveBitmap3 (picturechooser) ","picturechooser",1,__ref.getField(false, "ba"),__ref,521);
if (RapidSub.canDelegate("savebitmap3")) { return __ref.runUserSub(false, "picturechooser","savebitmap3", __ref, _bitmap, _dir, _filename, _format, _quality);}
RemoteObject _b1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
RemoteObject _out = RemoteObject.declareNull("anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper");
Debug.locals.put("Bitmap", _bitmap);
Debug.locals.put("Dir", _dir);
Debug.locals.put("Filename", _filename);
Debug.locals.put("Format", _format);
Debug.locals.put("quality", _quality);
 BA.debugLineNum = 521;BA.debugLine="Public Sub SaveBitmap3(Bitmap As Bitmap,Dir As Str";
Debug.ShouldStop(256);
 BA.debugLineNum = 522;BA.debugLine="Dim b1 As Bitmap";
Debug.ShouldStop(512);
_b1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("b1", _b1);
 BA.debugLineNum = 523;BA.debugLine="Dim out As OutputStream";
Debug.ShouldStop(1024);
_out = RemoteObject.createNew ("anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper");Debug.locals.put("out", _out);
 BA.debugLineNum = 524;BA.debugLine="b1 = Bitmap";
Debug.ShouldStop(2048);
_b1 = _bitmap;Debug.locals.put("b1", _b1);
 BA.debugLineNum = 525;BA.debugLine="out = File.OpenOutput(Dir,Filename,False)";
Debug.ShouldStop(4096);
_out = picturechooser.__c.getField(false,"File").runMethod(false,"OpenOutput",(Object)(_dir),(Object)(_filename),(Object)(picturechooser.__c.getField(true,"False")));Debug.locals.put("out", _out);
 BA.debugLineNum = 526;BA.debugLine="b1.WriteToStream(out,quality,Format.ToUpperCase)";
Debug.ShouldStop(8192);
_b1.runVoidMethod ("WriteToStream",(Object)((_out.getObject())),(Object)(_quality),(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.Bitmap.CompressFormat"),_format.runMethod(true,"toUpperCase"))));
 BA.debugLineNum = 527;BA.debugLine="out.Close";
Debug.ShouldStop(16384);
_out.runVoidMethod ("Close");
 BA.debugLineNum = 528;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _scv_oncroperror(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("SCV_onCropError (picturechooser) ","picturechooser",1,__ref.getField(false, "ba"),__ref,456);
if (RapidSub.canDelegate("scv_oncroperror")) { return __ref.runUserSub(false, "picturechooser","scv_oncroperror", __ref);}
 BA.debugLineNum = 456;BA.debugLine="Private Sub SCV_onCropError";
Debug.ShouldStop(128);
 BA.debugLineNum = 457;BA.debugLine="Log(\"onCropError\")";
Debug.ShouldStop(256);
picturechooser.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("onCropError")));
 BA.debugLineNum = 458;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _setaspectratio(RemoteObject __ref,RemoteObject _width,RemoteObject _height) throws Exception{
try {
		Debug.PushSubsStack("SetAspectRatio (picturechooser) ","picturechooser",1,__ref.getField(false, "ba"),__ref,146);
if (RapidSub.canDelegate("setaspectratio")) { return __ref.runUserSub(false, "picturechooser","setaspectratio", __ref, _width, _height);}
Debug.locals.put("Width", _width);
Debug.locals.put("Height", _height);
 BA.debugLineNum = 146;BA.debugLine="Public Sub SetAspectRatio(Width As Int,Height As I";
Debug.ShouldStop(131072);
 BA.debugLineNum = 147;BA.debugLine="CV.setAspectRatio(Width,Height)";
Debug.ShouldStop(262144);
__ref.getField(false,"_cv").runVoidMethod ("setAspectRatio",(Object)(_width),(Object)(_height));
 BA.debugLineNum = 148;BA.debugLine="AspectRatioWidth	=	Width";
Debug.ShouldStop(524288);
__ref.setField ("_aspectratiowidth",_width);
 BA.debugLineNum = 149;BA.debugLine="AspectRatioHeight	=	Height";
Debug.ShouldStop(1048576);
__ref.setField ("_aspectratioheight",_height);
 BA.debugLineNum = 150;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _setchoosertitle(RemoteObject __ref,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("setChooserTitle (picturechooser) ","picturechooser",1,__ref.getField(false, "ba"),__ref,95);
if (RapidSub.canDelegate("setchoosertitle")) { return __ref.runUserSub(false, "picturechooser","setchoosertitle", __ref, _value);}
Debug.locals.put("Value", _value);
 BA.debugLineNum = 95;BA.debugLine="Public Sub setChooserTitle(Value As String)";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 96;BA.debugLine="Chooser_Title	=	Value";
Debug.ShouldStop(-2147483648);
__ref.setField ("_chooser_title",_value);
 BA.debugLineNum = 97;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _setcrop(RemoteObject __ref,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("setCrop (picturechooser) ","picturechooser",1,__ref.getField(false, "ba"),__ref,124);
if (RapidSub.canDelegate("setcrop")) { return __ref.runUserSub(false, "picturechooser","setcrop", __ref, _value);}
Debug.locals.put("Value", _value);
 BA.debugLineNum = 124;BA.debugLine="Public Sub setCrop(Value As Boolean)";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 125;BA.debugLine="is_crop	=	Value";
Debug.ShouldStop(268435456);
__ref.setField ("_is_crop",_value);
 BA.debugLineNum = 126;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _setcroptitle(RemoteObject __ref,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("setCropTitle (picturechooser) ","picturechooser",1,__ref.getField(false, "ba"),__ref,113);
if (RapidSub.canDelegate("setcroptitle")) { return __ref.runUserSub(false, "picturechooser","setcroptitle", __ref, _value);}
Debug.locals.put("Value", _value);
 BA.debugLineNum = 113;BA.debugLine="Public Sub setCropTitle(Value As String)";
Debug.ShouldStop(65536);
 BA.debugLineNum = 114;BA.debugLine="b.Text	=	Value";
Debug.ShouldStop(131072);
__ref.getField(false,"_b").runMethod(true,"setText",BA.ObjectToCharSequence(_value));
 BA.debugLineNum = 115;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _setqualitycamerapicture(RemoteObject __ref,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("setQualityCameraPicture (picturechooser) ","picturechooser",1,__ref.getField(false, "ba"),__ref,109);
if (RapidSub.canDelegate("setqualitycamerapicture")) { return __ref.runUserSub(false, "picturechooser","setqualitycamerapicture", __ref, _value);}
Debug.locals.put("Value", _value);
 BA.debugLineNum = 109;BA.debugLine="Public Sub setQualityCameraPicture(Value As Int)";
Debug.ShouldStop(4096);
 BA.debugLineNum = 110;BA.debugLine="quality2	=	Value";
Debug.ShouldStop(8192);
__ref.setField ("_quality2",_value);
 BA.debugLineNum = 111;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _setrotatetitle(RemoteObject __ref,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("setRotateTitle (picturechooser) ","picturechooser",1,__ref.getField(false, "ba"),__ref,99);
if (RapidSub.canDelegate("setrotatetitle")) { return __ref.runUserSub(false, "picturechooser","setrotatetitle", __ref, _value);}
Debug.locals.put("Value", _value);
 BA.debugLineNum = 99;BA.debugLine="Public Sub setRotateTitle(Value As String)";
Debug.ShouldStop(4);
 BA.debugLineNum = 100;BA.debugLine="btnrotate.Text	=	Value";
Debug.ShouldStop(8);
__ref.getField(false,"_btnrotate").runMethod(true,"setText",BA.ObjectToCharSequence(_value));
 BA.debugLineNum = 101;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _setscalecrop(RemoteObject __ref,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("setScaleCrop (picturechooser) ","picturechooser",1,__ref.getField(false, "ba"),__ref,118);
if (RapidSub.canDelegate("setscalecrop")) { return __ref.runUserSub(false, "picturechooser","setscalecrop", __ref, _value);}
Debug.locals.put("Value", _value);
 BA.debugLineNum = 118;BA.debugLine="Sub setScaleCrop(Value As Boolean)";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 119;BA.debugLine="CV.FixedAspectRatio	=	True";
Debug.ShouldStop(4194304);
__ref.getField(false,"_cv").runVoidMethod ("setFixedAspectRatio",picturechooser.__c.getField(true,"True"));
 BA.debugLineNum = 120;BA.debugLine="IsScale	=	Value";
Debug.ShouldStop(8388608);
__ref.setField ("_isscale",_value);
 BA.debugLineNum = 121;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _startactivityforresult(RemoteObject __ref,RemoteObject _i,RemoteObject _event) throws Exception{
try {
		Debug.PushSubsStack("StartActivityForResult (picturechooser) ","picturechooser",1,__ref.getField(false, "ba"),__ref,377);
if (RapidSub.canDelegate("startactivityforresult")) { return __ref.runUserSub(false, "picturechooser","startactivityforresult", __ref, _i, _event);}
RemoteObject _jo = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
Debug.locals.put("i", _i);
Debug.locals.put("Event", _event);
 BA.debugLineNum = 377;BA.debugLine="Private Sub StartActivityForResult(i As Intent,Eve";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 378;BA.debugLine="Dim jo As JavaObject = GetBA";
Debug.ShouldStop(33554432);
_jo = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
_jo.setObject(__ref.runClassMethod (b4a.exampleddd.picturechooser.class, "_getba"));Debug.locals.put("jo", _jo);
 BA.debugLineNum = 379;BA.debugLine="ion = jo.CreateEvent(\"anywheresoftware.b4a.IOnAct";
Debug.ShouldStop(67108864);
__ref.setField ("_ion",_jo.runMethod(false,"CreateEvent",__ref.getField(false, "ba"),(Object)(BA.ObjectToString("anywheresoftware.b4a.IOnActivityResult")),(Object)(_event),(Object)(picturechooser.__c.getField(false,"Null"))));
 BA.debugLineNum = 380;BA.debugLine="jo.RunMethod(\"startActivityForResult\", Array As O";
Debug.ShouldStop(134217728);
_jo.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("startActivityForResult")),(Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {__ref.getField(false,"_ion"),(_i.getObject())})));
 BA.debugLineNum = 381;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}