
package b4a.exampleaa;

import java.io.IOException;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RDebug;
import anywheresoftware.b4a.pc.RemoteObject;
import anywheresoftware.b4a.pc.RDebug.IRemote;
import anywheresoftware.b4a.pc.Debug;
import anywheresoftware.b4a.pc.B4XTypes.B4XClass;
import anywheresoftware.b4a.pc.B4XTypes.DeviceClass;

public class lib implements IRemote{
	public static lib mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public lib() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
public boolean isSingleton() {
		return true;
	}
     private static PCBA pcBA = new PCBA(null, lib.class);
    static {
		mostCurrent = new lib();
        remoteMe = RemoteObject.declareNull("b4a.exampleaa.lib");
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("lib"), "b4a.exampleaa.lib");
        RDebug.INSTANCE.eventTargets.put(new DeviceClass("b4a.exampleaa.lib"), new java.lang.ref.WeakReference<PCBA> (pcBA));
	}
   
	public static RemoteObject runMethod(boolean notUsed, String method, Object... args) throws Exception{
		return (RemoteObject) pcBA.raiseEvent(method.substring(1), args);
	}
    public static void runVoidMethod(String method, Object... args) throws Exception{
		runMethod(false, method, args);
	}
	public PCBA create(Object[] args) throws ClassNotFoundException{
        throw new RuntimeException("CREATE is not supported.");
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static b4a.exampleaa.main _main = null;
public static b4a.exampleaa.lib2 _lib2 = null;
  public Object[] GetGlobals() {
		return new Object[] {"Lib2",Debug.moduleToString(b4a.exampleaa.lib2.class),"Main",Debug.moduleToString(b4a.exampleaa.main.class)};
}
}