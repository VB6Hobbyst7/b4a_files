package b4a.exampleaa;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_click() throws Exception{
try {
		Debug.PushSubsStack("Activity_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,40);
if (RapidSub.canDelegate("activity_click")) { return b4a.exampleaa.main.remoteMe.runUserSub(false, "main","activity_click");}
 BA.debugLineNum = 40;BA.debugLine="Sub Activity_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 42;BA.debugLine="End Sub";
Debug.ShouldStop(512);
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
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,26);
if (RapidSub.canDelegate("activity_create")) { return b4a.exampleaa.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 26;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 28;BA.debugLine="down.Initialize(Me,\"omid\",\"https://iranapp.org/as";
Debug.ShouldStop(134217728);
main.mostCurrent._down.runClassMethod (b4a.exampleaa.filedownloadmanager.class, "_initialize",main.processBA,(Object)(main.getObject()),(Object)(BA.ObjectToString("omid")),(Object)(RemoteObject.createImmutable("https://iranapp.org/asset/update_abm.rar")));
 BA.debugLineNum = 29;BA.debugLine="down.SetDescription(\"hoooooooo\").SetHeader(\"aa\",\"";
Debug.ShouldStop(268435456);
main.mostCurrent._down.runClassMethod (b4a.exampleaa.filedownloadmanager.class, "_setdescription",(Object)(RemoteObject.createImmutable("hoooooooo"))).runClassMethod (b4a.exampleaa.filedownloadmanager.class, "_setheader",(Object)(BA.ObjectToString("aa")),(Object)(RemoteObject.createImmutable("aa"))).runClassMethod (b4a.exampleaa.filedownloadmanager.class, "_setoutputfilename",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirRootExternal")),(Object)(RemoteObject.createImmutable("a.rar"))).runClassMethod (b4a.exampleaa.filedownloadmanager.class, "_setshowui",(Object)(main.mostCurrent.__c.getField(true,"True"))).runClassMethod (b4a.exampleaa.filedownloadmanager.class, "_settitle",(Object)(RemoteObject.createImmutable("thanks"))).runClassMethod (b4a.exampleaa.filedownloadmanager.class, "_download");
 BA.debugLineNum = 30;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
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
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,48);
if (RapidSub.canDelegate("activity_pause")) { return b4a.exampleaa.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 48;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(32768);
 BA.debugLineNum = 50;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
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
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,44);
if (RapidSub.canDelegate("activity_resume")) { return b4a.exampleaa.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 44;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(2048);
 BA.debugLineNum = 46;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity2_keypress(RemoteObject _viewtag,RemoteObject _keycode,RemoteObject _keyevent) throws Exception{
try {
		Debug.PushSubsStack("Activity2_KeyPress (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,36);
if (RapidSub.canDelegate("activity2_keypress")) { return b4a.exampleaa.main.remoteMe.runUserSub(false, "main","activity2_keypress", _viewtag, _keycode, _keyevent);}
Debug.locals.put("ViewTag", _viewtag);
Debug.locals.put("KeyCode", _keycode);
Debug.locals.put("KeyEvent", _keyevent);
 BA.debugLineNum = 36;BA.debugLine="Private Sub Activity2_KeyPress (ViewTag As Object,";
Debug.ShouldStop(8);
 BA.debugLineNum = 37;BA.debugLine="Log(KeyCode)";
Debug.ShouldStop(16);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(BA.NumberToString(_keycode)));
 BA.debugLineNum = 38;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 22;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 23;BA.debugLine="Private down As FileDownloadManager";
main.mostCurrent._down = RemoteObject.createNew ("b4a.exampleaa.filedownloadmanager");
 //BA.debugLineNum = 24;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _omid_complete(RemoteObject _success) throws Exception{
try {
		Debug.PushSubsStack("omid_Complete (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,32);
if (RapidSub.canDelegate("omid_complete")) { return b4a.exampleaa.main.remoteMe.runUserSub(false, "main","omid_complete", _success);}
Debug.locals.put("Success", _success);
 BA.debugLineNum = 32;BA.debugLine="Sub omid_Complete(Success As Boolean)";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 33;BA.debugLine="Log(Success)";
Debug.ShouldStop(1);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(BA.ObjectToString(_success)));
 BA.debugLineNum = 34;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
lib_subs_0._process_globals();
lib2_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("b4a.exampleaa.main");
lib.myClass = BA.getDeviceClass ("b4a.exampleaa.lib");
lib2.myClass = BA.getDeviceClass ("b4a.exampleaa.lib2");
filedownloadmanager.myClass = BA.getDeviceClass ("b4a.exampleaa.filedownloadmanager");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 16;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 20;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}