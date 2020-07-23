package b4a.exampleaa;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class lib2_subs_0 {


public static RemoteObject  _get(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("get (lib2) ","lib2",2,_ba,lib2.mostCurrent,7);
if (RapidSub.canDelegate("get")) { return b4a.exampleaa.lib2.remoteMe.runUserSub(false, "lib2","get", _ba);}
;
 BA.debugLineNum = 7;BA.debugLine="Sub get";
Debug.ShouldStop(64);
 BA.debugLineNum = 9;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 3;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 5;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}