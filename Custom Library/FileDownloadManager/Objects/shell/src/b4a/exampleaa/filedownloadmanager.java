
package b4a.exampleaa;

import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RemoteObject;

public class filedownloadmanager {
    public static RemoteObject myClass;
	public filedownloadmanager() {
	}
    public static PCBA staticBA = new PCBA(null, filedownloadmanager.class);

public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _downloadmanager1 = RemoteObject.declareNull("uk.co.martinpearman.b4a.downloadmanager.B4ADownloadManager");
public static RemoteObject _reasontextmap = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
public static RemoteObject _statustextmap = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
public static RemoteObject _isinitialized = RemoteObject.createImmutable(false);
public static RemoteObject _url2 = RemoteObject.createImmutable("");
public static RemoteObject _downloadid = RemoteObject.createImmutable(0L);
public static RemoteObject _downloadmanagerrequest1 = RemoteObject.declareNull("uk.co.martinpearman.b4a.downloadmanager.RequestWrapper");
public static RemoteObject _my_module = RemoteObject.declareNull("Object");
public static RemoteObject _my_event = RemoteObject.createImmutable("");
public static b4a.exampleaa.main _main = null;
public static b4a.exampleaa.lib _lib = null;
public static b4a.exampleaa.lib2 _lib2 = null;
public static Object[] GetGlobals(RemoteObject _ref) throws Exception {
		return new Object[] {"DownloadId",_ref.getField(false, "_downloadid"),"DownloadManager1",_ref.getField(false, "_downloadmanager1"),"DownloadManagerRequest1",_ref.getField(false, "_downloadmanagerrequest1"),"IsInitialized",_ref.getField(false, "_isinitialized"),"my_event",_ref.getField(false, "_my_event"),"my_module",_ref.getField(false, "_my_module"),"ReasonTextMap",_ref.getField(false, "_reasontextmap"),"StatusTextMap",_ref.getField(false, "_statustextmap"),"url2",_ref.getField(false, "_url2")};
}
}