package b4a.exampleddd;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_click() throws Exception{
try {
		Debug.PushSubsStack("Activity_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,46);
if (RapidSub.canDelegate("activity_click")) { return b4a.exampleddd.main.remoteMe.runUserSub(false, "main","activity_click");}
 BA.debugLineNum = 46;BA.debugLine="Sub Activity_Click";
Debug.ShouldStop(8192);
 BA.debugLineNum = 47;BA.debugLine="k.ChooseFromGallery";
Debug.ShouldStop(16384);
main.mostCurrent._k.runClassMethod (b4a.exampleddd.picturechooser.class, "_choosefromgallery");
 BA.debugLineNum = 48;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,32);
if (RapidSub.canDelegate("activity_create")) { return b4a.exampleddd.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 32;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 34;BA.debugLine="Activity.LoadLayout(\"f1\")";
Debug.ShouldStop(2);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("f1")),main.mostCurrent.activityBA);
 BA.debugLineNum = 35;BA.debugLine="k.Initialize(Activity,Me,\"result2\")";
Debug.ShouldStop(4);
main.mostCurrent._k.runClassMethod (b4a.exampleddd.picturechooser.class, "_initialize",main.mostCurrent.activityBA,RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.PanelWrapper"), main.mostCurrent._activity.getObject()),(Object)(main.getObject()),(Object)(RemoteObject.createImmutable("result2")));
 BA.debugLineNum = 36;BA.debugLine="k.Crop	=	True";
Debug.ShouldStop(8);
main.mostCurrent._k.runClassMethod (b4a.exampleddd.picturechooser.class, "_setcrop",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 39;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,60);
if (RapidSub.canDelegate("activity_pause")) { return b4a.exampleddd.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 60;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 62;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_permissionresult(RemoteObject _permission,RemoteObject _result) throws Exception{
try {
		Debug.PushSubsStack("Activity_PermissionResult (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,50);
if (RapidSub.canDelegate("activity_permissionresult")) { return b4a.exampleddd.main.remoteMe.runUserSub(false, "main","activity_permissionresult", _permission, _result);}
Debug.locals.put("Permission", _permission);
Debug.locals.put("Result", _result);
 BA.debugLineNum = 50;BA.debugLine="Sub Activity_PermissionResult (Permission As Strin";
Debug.ShouldStop(131072);
 BA.debugLineNum = 52;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,56);
if (RapidSub.canDelegate("activity_resume")) { return b4a.exampleddd.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 56;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 58;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 25;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 28;BA.debugLine="Dim k As PictureChooser";
main.mostCurrent._k = RemoteObject.createNew ("b4a.exampleddd.picturechooser");
 //BA.debugLineNum = 29;BA.debugLine="Private ImageView1 As ImageView";
main.mostCurrent._imageview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 30;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
starter_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("b4a.exampleddd.main");
picturechooser.myClass = BA.getDeviceClass ("b4a.exampleddd.picturechooser");
starter.myClass = BA.getDeviceClass ("b4a.exampleddd.starter");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 19;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 23;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _result2_error() throws Exception{
try {
		Debug.PushSubsStack("result2_Error (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,53);
if (RapidSub.canDelegate("result2_error")) { return b4a.exampleddd.main.remoteMe.runUserSub(false, "main","result2_error");}
 BA.debugLineNum = 53;BA.debugLine="Sub result2_Error";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 54;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _result2_result2(RemoteObject _dir,RemoteObject _filename) throws Exception{
try {
		Debug.PushSubsStack("result2_Result2 (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,41);
if (RapidSub.canDelegate("result2_result2")) { return b4a.exampleddd.main.remoteMe.runUserSub(false, "main","result2_result2", _dir, _filename);}
Debug.locals.put("Dir", _dir);
Debug.locals.put("Filename", _filename);
 BA.debugLineNum = 41;BA.debugLine="Sub result2_Result2(Dir As String,Filename As Stri";
Debug.ShouldStop(256);
 BA.debugLineNum = 42;BA.debugLine="ImageView1.Bitmap = LoadBitmap(Dir,Filename)";
Debug.ShouldStop(512);
main.mostCurrent._imageview1.runMethod(false,"setBitmap",(main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(_dir),(Object)(_filename)).getObject()));
 BA.debugLineNum = 43;BA.debugLine="Log(LoadBitmap(Dir,Filename).Width)";
Debug.ShouldStop(1024);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(BA.NumberToString(main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(_dir),(Object)(_filename)).runMethod(true,"getWidth"))));
 BA.debugLineNum = 44;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}