package b4a.exampleaa;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class lib {
private static lib mostCurrent = new lib();
public static Object getObject() {
    throw new RuntimeException("Code module does not support this method.");
}
 
public anywheresoftware.b4a.keywords.Common __c = null;
public b4a.exampleaa.main _main = null;
public b4a.exampleaa.lib2 _lib2 = null;
public static String  _show(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="lib";
if (Debug.shouldDelegate(null, "show"))
	 {return ((String) Debug.delegate(null, "show", new Object[] {_ba}));}
RDebugUtils.currentLine=524288;
 //BA.debugLineNum = 524288;BA.debugLine="Sub show";
RDebugUtils.currentLine=524289;
 //BA.debugLineNum = 524289;BA.debugLine="Log(\"aaa2222222222\")";
anywheresoftware.b4a.keywords.Common.Log("aaa2222222222");
RDebugUtils.currentLine=524290;
 //BA.debugLineNum = 524290;BA.debugLine="End Sub";
return "";
}
}