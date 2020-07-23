package b4a.exampleaa;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class lib_subs_0 {


public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 3;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 7;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _show(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("show (lib) ","lib",1,_ba,lib.mostCurrent,9);
if (RapidSub.canDelegate("show")) { return b4a.exampleaa.lib.remoteMe.runUserSub(false, "lib","show", _ba);}
;
 BA.debugLineNum = 9;BA.debugLine="Sub show";
Debug.ShouldStop(256);
 BA.debugLineNum = 10;BA.debugLine="Log(\"aaa2222222222\")";
Debug.ShouldStop(512);
lib.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("aaa2222222222")));
 BA.debugLineNum = 11;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}