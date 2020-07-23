package b4a.exampleaa;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class lib2 {
private static lib2 mostCurrent = new lib2();
public static Object getObject() {
    throw new RuntimeException("Code module does not support this method.");
}
 
public anywheresoftware.b4a.keywords.Common __c = null;
public b4a.exampleaa.main _main = null;
public b4a.exampleaa.lib _lib = null;
public static String  _get(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="lib2";
if (Debug.shouldDelegate(null, "get"))
	 {return ((String) Debug.delegate(null, "get", new Object[] {_ba}));}
RDebugUtils.currentLine=655360;
 //BA.debugLineNum = 655360;BA.debugLine="Sub get";
RDebugUtils.currentLine=655362;
 //BA.debugLineNum = 655362;BA.debugLine="End Sub";
return "";
}
}