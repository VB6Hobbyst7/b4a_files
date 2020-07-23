package b4a.exampleaa;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class filedownloadmanager_subs_0 {


public static RemoteObject  _class_globals(RemoteObject __ref) throws Exception{
 //BA.debugLineNum = 4;BA.debugLine="Private Sub Class_Globals";
 //BA.debugLineNum = 5;BA.debugLine="Private DownloadManager1 As DownloadManager";
filedownloadmanager._downloadmanager1 = RemoteObject.createNew ("uk.co.martinpearman.b4a.downloadmanager.B4ADownloadManager");__ref.setField("_downloadmanager1",filedownloadmanager._downloadmanager1);
 //BA.debugLineNum = 6;BA.debugLine="Private ReasonTextMap As Map";
filedownloadmanager._reasontextmap = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");__ref.setField("_reasontextmap",filedownloadmanager._reasontextmap);
 //BA.debugLineNum = 7;BA.debugLine="Private StatusTextMap As Map";
filedownloadmanager._statustextmap = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");__ref.setField("_statustextmap",filedownloadmanager._statustextmap);
 //BA.debugLineNum = 8;BA.debugLine="Private IsInitialized As Boolean=False";
filedownloadmanager._isinitialized = filedownloadmanager.__c.getField(true,"False");__ref.setField("_isinitialized",filedownloadmanager._isinitialized);
 //BA.debugLineNum = 9;BA.debugLine="Private url2 As String";
filedownloadmanager._url2 = RemoteObject.createImmutable("");__ref.setField("_url2",filedownloadmanager._url2);
 //BA.debugLineNum = 10;BA.debugLine="Private DownloadId As Long";
filedownloadmanager._downloadid = RemoteObject.createImmutable(0L);__ref.setField("_downloadid",filedownloadmanager._downloadid);
 //BA.debugLineNum = 11;BA.debugLine="Private DownloadManagerRequest1 As DownloadManage";
filedownloadmanager._downloadmanagerrequest1 = RemoteObject.createNew ("uk.co.martinpearman.b4a.downloadmanager.RequestWrapper");__ref.setField("_downloadmanagerrequest1",filedownloadmanager._downloadmanagerrequest1);
 //BA.debugLineNum = 12;BA.debugLine="Private my_module As Object";
filedownloadmanager._my_module = RemoteObject.createNew ("Object");__ref.setField("_my_module",filedownloadmanager._my_module);
 //BA.debugLineNum = 13;BA.debugLine="Private my_event As String";
filedownloadmanager._my_event = RemoteObject.createImmutable("");__ref.setField("_my_event",filedownloadmanager._my_event);
 //BA.debugLineNum = 14;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _download(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("Download (filedownloadmanager) ","filedownloadmanager",3,__ref.getField(false, "ba"),__ref,92);
if (RapidSub.canDelegate("download")) { return __ref.runUserSub(false, "filedownloadmanager","download", __ref);}
 BA.debugLineNum = 92;BA.debugLine="Public Sub Download";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 93;BA.debugLine="DownloadId	=	DownloadManager1.Enqueue(DownloadMan";
Debug.ShouldStop(268435456);
__ref.setField ("_downloadid",__ref.getField(false,"_downloadmanager1").runMethod(true,"Enqueue",__ref.getField(false, "ba"),(Object)((__ref.getField(false,"_downloadmanagerrequest1").getObject()))));
 BA.debugLineNum = 94;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _downloadmanager1_downloadcomplete(RemoteObject __ref,RemoteObject _downloadid1) throws Exception{
try {
		Debug.PushSubsStack("DownloadManager1_DownloadComplete (filedownloadmanager) ","filedownloadmanager",3,__ref.getField(false, "ba"),__ref,96);
if (RapidSub.canDelegate("downloadmanager1_downloadcomplete")) { return __ref.runUserSub(false, "filedownloadmanager","downloadmanager1_downloadcomplete", __ref, _downloadid1);}
RemoteObject _downloadmanagerquery1 = RemoteObject.declareNull("uk.co.martinpearman.b4a.downloadmanager.QueryWrapper");
RemoteObject _statuscursor = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
RemoteObject _statusint = RemoteObject.createImmutable(0);
Debug.locals.put("DownloadId1", _downloadid1);
 BA.debugLineNum = 96;BA.debugLine="Sub DownloadManager1_DownloadComplete(DownloadId1";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 98;BA.debugLine="If DownloadId	=	DownloadId1 Then";
Debug.ShouldStop(2);
if (RemoteObject.solveBoolean("=",__ref.getField(true,"_downloadid"),BA.numberCast(double.class, _downloadid1))) { 
 BA.debugLineNum = 100;BA.debugLine="Dim DownloadManagerQuery1 As DownloadManagerQuer";
Debug.ShouldStop(8);
_downloadmanagerquery1 = RemoteObject.createNew ("uk.co.martinpearman.b4a.downloadmanager.QueryWrapper");Debug.locals.put("DownloadManagerQuery1", _downloadmanagerquery1);
 BA.debugLineNum = 101;BA.debugLine="DownloadManagerQuery1.Initialize";
Debug.ShouldStop(16);
_downloadmanagerquery1.runVoidMethod ("Initialize");
 BA.debugLineNum = 102;BA.debugLine="DownloadManagerQuery1.SetFilterById(DownloadId)";
Debug.ShouldStop(32);
_downloadmanagerquery1.runVoidMethod ("SetFilterById",(Object)(__ref.getField(true,"_downloadid")));
 BA.debugLineNum = 104;BA.debugLine="Dim StatusCursor As Cursor";
Debug.ShouldStop(128);
_statuscursor = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");Debug.locals.put("StatusCursor", _statuscursor);
 BA.debugLineNum = 105;BA.debugLine="StatusCursor=DownloadManager1.Query(DownloadMana";
Debug.ShouldStop(256);
_statuscursor = __ref.getField(false,"_downloadmanager1").runMethod(false,"Query",__ref.getField(false, "ba"),(Object)((_downloadmanagerquery1.getObject())));Debug.locals.put("StatusCursor", _statuscursor);
 BA.debugLineNum = 107;BA.debugLine="If StatusCursor.RowCount > 0 Then";
Debug.ShouldStop(1024);
if (RemoteObject.solveBoolean(">",_statuscursor.runMethod(true,"getRowCount"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 109;BA.debugLine="StatusCursor.Position=0";
Debug.ShouldStop(4096);
_statuscursor.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 111;BA.debugLine="Dim StatusInt As Int";
Debug.ShouldStop(16384);
_statusint = RemoteObject.createImmutable(0);Debug.locals.put("StatusInt", _statusint);
 BA.debugLineNum = 112;BA.debugLine="StatusInt=StatusCursor.getInt(DownloadManager1.";
Debug.ShouldStop(32768);
_statusint = _statuscursor.runMethod(true,"GetInt",(Object)(__ref.getField(false,"_downloadmanager1").getField(true,"COLUMN_STATUS")));Debug.locals.put("StatusInt", _statusint);
 BA.debugLineNum = 114;BA.debugLine="If StatusInt=DownloadManager1.STATUS_FAILED Or";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean("=",_statusint,BA.numberCast(double.class, __ref.getField(false,"_downloadmanager1").getField(true,"STATUS_FAILED"))) || RemoteObject.solveBoolean("=",_statusint,BA.numberCast(double.class, __ref.getField(false,"_downloadmanager1").getField(true,"STATUS_PAUSED")))) { 
 BA.debugLineNum = 115;BA.debugLine="If IsPaused(my_module) = False Then CallSubDel";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean("=",filedownloadmanager.__c.runMethod(true,"IsPaused",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_my_module"))),filedownloadmanager.__c.getField(true,"False"))) { 
filedownloadmanager.__c.runVoidMethod ("CallSubDelayed2",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_my_module")),(Object)(RemoteObject.concat(__ref.getField(true,"_my_event").runMethod(true,"toLowerCase"),RemoteObject.createImmutable("_complete"))),(Object)((filedownloadmanager.__c.getField(true,"False"))));};
 }else {
 BA.debugLineNum = 117;BA.debugLine="If IsPaused(my_module) = False Then CallSubDel";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean("=",filedownloadmanager.__c.runMethod(true,"IsPaused",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_my_module"))),filedownloadmanager.__c.getField(true,"False"))) { 
filedownloadmanager.__c.runVoidMethod ("CallSubDelayed2",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_my_module")),(Object)(RemoteObject.concat(__ref.getField(true,"_my_event").runMethod(true,"toLowerCase"),RemoteObject.createImmutable("_complete"))),(Object)((filedownloadmanager.__c.getField(true,"True"))));};
 };
 }else {
 BA.debugLineNum = 121;BA.debugLine="If IsPaused(my_module) = False Then CallSubDela";
Debug.ShouldStop(16777216);
if (RemoteObject.solveBoolean("=",filedownloadmanager.__c.runMethod(true,"IsPaused",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_my_module"))),filedownloadmanager.__c.getField(true,"False"))) { 
filedownloadmanager.__c.runVoidMethod ("CallSubDelayed2",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_my_module")),(Object)(RemoteObject.concat(__ref.getField(true,"_my_event").runMethod(true,"toLowerCase"),RemoteObject.createImmutable("_complete"))),(Object)((filedownloadmanager.__c.getField(true,"False"))));};
 BA.debugLineNum = 122;BA.debugLine="Log(\"The DownloadManager has no trace of our re";
Debug.ShouldStop(33554432);
filedownloadmanager.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("The DownloadManager has no trace of our request, it could have been cancelled by the user using the Android Downloads app or an unknown error has occurred.")));
 };
 BA.debugLineNum = 126;BA.debugLine="StatusCursor.Close";
Debug.ShouldStop(536870912);
_statuscursor.runVoidMethod ("Close");
 BA.debugLineNum = 127;BA.debugLine="DownloadManager1.UnregisterReceiver";
Debug.ShouldStop(1073741824);
__ref.getField(false,"_downloadmanager1").runVoidMethod ("UnregisterReceiver",__ref.getField(false, "ba"));
 };
 BA.debugLineNum = 131;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _downloadmanager1_notificationclicked(RemoteObject __ref,RemoteObject _downloadids) throws Exception{
try {
		Debug.PushSubsStack("DownloadManager1_NotificationClicked (filedownloadmanager) ","filedownloadmanager",3,__ref.getField(false, "ba"),__ref,133);
if (RapidSub.canDelegate("downloadmanager1_notificationclicked")) { return __ref.runUserSub(false, "filedownloadmanager","downloadmanager1_notificationclicked", __ref, _downloadids);}
Debug.locals.put("DownloadIds", _downloadids);
 BA.debugLineNum = 133;BA.debugLine="Sub DownloadManager1_NotificationClicked(DownloadI";
Debug.ShouldStop(16);
 BA.debugLineNum = 134;BA.debugLine="If IsPaused(my_module) = False Then CallSubDelaye";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("=",filedownloadmanager.__c.runMethod(true,"IsPaused",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_my_module"))),filedownloadmanager.__c.getField(true,"False"))) { 
filedownloadmanager.__c.runVoidMethod ("CallSubDelayed2",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_my_module")),(Object)(RemoteObject.concat(__ref.getField(true,"_my_event").runMethod(true,"toLowerCase"),RemoteObject.createImmutable("_notificationclick"))),(Object)((filedownloadmanager.__c.getField(true,"False"))));};
 BA.debugLineNum = 135;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getreasontext(RemoteObject __ref,RemoteObject _index) throws Exception{
try {
		Debug.PushSubsStack("GetReasonText (filedownloadmanager) ","filedownloadmanager",3,__ref.getField(false, "ba"),__ref,54);
if (RapidSub.canDelegate("getreasontext")) { return __ref.runUserSub(false, "filedownloadmanager","getreasontext", __ref, _index);}
Debug.locals.put("Index", _index);
 BA.debugLineNum = 54;BA.debugLine="Private Sub GetReasonText(Index As Int) As String";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 55;BA.debugLine="Return ReasonTextMap.Get(Index)";
Debug.ShouldStop(4194304);
if (true) return BA.ObjectToString(__ref.getField(false,"_reasontextmap").runMethod(false,"Get",(Object)((_index))));
 BA.debugLineNum = 56;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getstatustext(RemoteObject __ref,RemoteObject _index) throws Exception{
try {
		Debug.PushSubsStack("GetStatusText (filedownloadmanager) ","filedownloadmanager",3,__ref.getField(false, "ba"),__ref,58);
if (RapidSub.canDelegate("getstatustext")) { return __ref.runUserSub(false, "filedownloadmanager","getstatustext", __ref, _index);}
Debug.locals.put("Index", _index);
 BA.debugLineNum = 58;BA.debugLine="Private Sub GetStatusText(Index As Int) As String";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 59;BA.debugLine="Return StatusTextMap.Get(Index)";
Debug.ShouldStop(67108864);
if (true) return BA.ObjectToString(__ref.getField(false,"_statustextmap").runMethod(false,"Get",(Object)((_index))));
 BA.debugLineNum = 60;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _initialize(RemoteObject __ref,RemoteObject _ba,RemoteObject _module,RemoteObject _event,RemoteObject _url) throws Exception{
try {
		Debug.PushSubsStack("Initialize (filedownloadmanager) ","filedownloadmanager",3,__ref.getField(false, "ba"),__ref,18);
if (RapidSub.canDelegate("initialize")) { return __ref.runUserSub(false, "filedownloadmanager","initialize", __ref, _ba, _module, _event, _url);}
__ref.runVoidMethodAndSync("innerInitializeHelper", _ba);
Debug.locals.put("ba", _ba);
Debug.locals.put("Module", _module);
Debug.locals.put("Event", _event);
Debug.locals.put("Url", _url);
 BA.debugLineNum = 18;BA.debugLine="Public Sub Initialize(Module As Object,Event As St";
Debug.ShouldStop(131072);
 BA.debugLineNum = 20;BA.debugLine="DownloadManager1.RegisterReceiver(\"DownloadManage";
Debug.ShouldStop(524288);
__ref.getField(false,"_downloadmanager1").runVoidMethod ("RegisterReceiver",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("DownloadManager1")));
 BA.debugLineNum = 22;BA.debugLine="ReasonTextMap.Initialize";
Debug.ShouldStop(2097152);
__ref.getField(false,"_reasontextmap").runVoidMethod ("Initialize");
 BA.debugLineNum = 23;BA.debugLine="ReasonTextMap.Put(DownloadManager1.ERROR_CANNOT_R";
Debug.ShouldStop(4194304);
__ref.getField(false,"_reasontextmap").runVoidMethod ("Put",(Object)((__ref.getField(false,"_downloadmanager1").getField(true,"ERROR_CANNOT_RESUME"))),(Object)((RemoteObject.createImmutable("ERROR_CANNOT_RESUME"))));
 BA.debugLineNum = 24;BA.debugLine="ReasonTextMap.Put(DownloadManager1.ERROR_DEVICE_N";
Debug.ShouldStop(8388608);
__ref.getField(false,"_reasontextmap").runVoidMethod ("Put",(Object)((__ref.getField(false,"_downloadmanager1").getField(true,"ERROR_DEVICE_NOT_FOUND"))),(Object)((RemoteObject.createImmutable("ERROR_DEVICE_NOT_FOUND"))));
 BA.debugLineNum = 25;BA.debugLine="ReasonTextMap.Put(DownloadManager1.ERROR_FILE_ALR";
Debug.ShouldStop(16777216);
__ref.getField(false,"_reasontextmap").runVoidMethod ("Put",(Object)((__ref.getField(false,"_downloadmanager1").getField(true,"ERROR_FILE_ALREADY_EXISTS"))),(Object)((RemoteObject.createImmutable("ERROR_FILE_ALREADY_EXISTS"))));
 BA.debugLineNum = 26;BA.debugLine="ReasonTextMap.Put(DownloadManager1.ERROR_FILE_ERR";
Debug.ShouldStop(33554432);
__ref.getField(false,"_reasontextmap").runVoidMethod ("Put",(Object)((__ref.getField(false,"_downloadmanager1").getField(true,"ERROR_FILE_ERROR"))),(Object)((RemoteObject.createImmutable("ERROR_FILE_ERROR"))));
 BA.debugLineNum = 27;BA.debugLine="ReasonTextMap.Put(DownloadManager1.ERROR_HTTP_DAT";
Debug.ShouldStop(67108864);
__ref.getField(false,"_reasontextmap").runVoidMethod ("Put",(Object)((__ref.getField(false,"_downloadmanager1").getField(true,"ERROR_HTTP_DATA_ERROR"))),(Object)((RemoteObject.createImmutable("ERROR_HTTP_DATA_ERROR"))));
 BA.debugLineNum = 28;BA.debugLine="ReasonTextMap.Put(DownloadManager1.ERROR_INSUFFIC";
Debug.ShouldStop(134217728);
__ref.getField(false,"_reasontextmap").runVoidMethod ("Put",(Object)((__ref.getField(false,"_downloadmanager1").getField(true,"ERROR_INSUFFICIENT_SPACE"))),(Object)((RemoteObject.createImmutable("ERROR_INSUFFICIENT_SPACE"))));
 BA.debugLineNum = 29;BA.debugLine="ReasonTextMap.Put(DownloadManager1.ERROR_TOO_MANY";
Debug.ShouldStop(268435456);
__ref.getField(false,"_reasontextmap").runVoidMethod ("Put",(Object)((__ref.getField(false,"_downloadmanager1").getField(true,"ERROR_TOO_MANY_REDIRECTS"))),(Object)((RemoteObject.createImmutable("ERROR_TOO_MANY_REDIRECTS"))));
 BA.debugLineNum = 30;BA.debugLine="ReasonTextMap.Put(DownloadManager1.ERROR_UNHANDLE";
Debug.ShouldStop(536870912);
__ref.getField(false,"_reasontextmap").runVoidMethod ("Put",(Object)((__ref.getField(false,"_downloadmanager1").getField(true,"ERROR_UNHANDLED_HTTP_CODE"))),(Object)((RemoteObject.createImmutable("ERROR_UNHANDLED_HTTP_CODE"))));
 BA.debugLineNum = 31;BA.debugLine="ReasonTextMap.Put(DownloadManager1.ERROR_UNKNOWN,";
Debug.ShouldStop(1073741824);
__ref.getField(false,"_reasontextmap").runVoidMethod ("Put",(Object)((__ref.getField(false,"_downloadmanager1").getField(true,"ERROR_UNKNOWN"))),(Object)((RemoteObject.createImmutable("ERROR_UNKNOWN"))));
 BA.debugLineNum = 32;BA.debugLine="ReasonTextMap.Put(DownloadManager1.PAUSED_QUEUED_";
Debug.ShouldStop(-2147483648);
__ref.getField(false,"_reasontextmap").runVoidMethod ("Put",(Object)((__ref.getField(false,"_downloadmanager1").getField(true,"PAUSED_QUEUED_FOR_WIFI"))),(Object)((RemoteObject.createImmutable("PAUSED_QUEUED_FOR_WIFI"))));
 BA.debugLineNum = 33;BA.debugLine="ReasonTextMap.Put(DownloadManager1.PAUSED_UNKNOWN";
Debug.ShouldStop(1);
__ref.getField(false,"_reasontextmap").runVoidMethod ("Put",(Object)((__ref.getField(false,"_downloadmanager1").getField(true,"PAUSED_UNKNOWN"))),(Object)((RemoteObject.createImmutable("PAUSED_UNKNOWN"))));
 BA.debugLineNum = 34;BA.debugLine="ReasonTextMap.Put(DownloadManager1.PAUSED_WAITING";
Debug.ShouldStop(2);
__ref.getField(false,"_reasontextmap").runVoidMethod ("Put",(Object)((__ref.getField(false,"_downloadmanager1").getField(true,"PAUSED_WAITING_FOR_NETWORK"))),(Object)((RemoteObject.createImmutable("PAUSED_WAITING_FOR_NETWORK"))));
 BA.debugLineNum = 35;BA.debugLine="ReasonTextMap.Put(DownloadManager1.PAUSED_WAITING";
Debug.ShouldStop(4);
__ref.getField(false,"_reasontextmap").runVoidMethod ("Put",(Object)((__ref.getField(false,"_downloadmanager1").getField(true,"PAUSED_WAITING_TO_RETRY"))),(Object)((RemoteObject.createImmutable("PAUSED_WAITING_TO_RETRY"))));
 BA.debugLineNum = 37;BA.debugLine="StatusTextMap.Initialize";
Debug.ShouldStop(16);
__ref.getField(false,"_statustextmap").runVoidMethod ("Initialize");
 BA.debugLineNum = 38;BA.debugLine="StatusTextMap.Put(DownloadManager1.STATUS_FAILED,";
Debug.ShouldStop(32);
__ref.getField(false,"_statustextmap").runVoidMethod ("Put",(Object)((__ref.getField(false,"_downloadmanager1").getField(true,"STATUS_FAILED"))),(Object)((RemoteObject.createImmutable("STATUS_FAILED"))));
 BA.debugLineNum = 39;BA.debugLine="StatusTextMap.Put(DownloadManager1.STATUS_PAUSED,";
Debug.ShouldStop(64);
__ref.getField(false,"_statustextmap").runVoidMethod ("Put",(Object)((__ref.getField(false,"_downloadmanager1").getField(true,"STATUS_PAUSED"))),(Object)((RemoteObject.createImmutable("STATUS_PAUSED"))));
 BA.debugLineNum = 40;BA.debugLine="StatusTextMap.Put(DownloadManager1.STATUS_PENDING";
Debug.ShouldStop(128);
__ref.getField(false,"_statustextmap").runVoidMethod ("Put",(Object)((__ref.getField(false,"_downloadmanager1").getField(true,"STATUS_PENDING"))),(Object)((RemoteObject.createImmutable("STATUS_PENDING"))));
 BA.debugLineNum = 41;BA.debugLine="StatusTextMap.Put(DownloadManager1.STATUS_RUNNING";
Debug.ShouldStop(256);
__ref.getField(false,"_statustextmap").runVoidMethod ("Put",(Object)((__ref.getField(false,"_downloadmanager1").getField(true,"STATUS_RUNNING"))),(Object)((RemoteObject.createImmutable("STATUS_RUNNING"))));
 BA.debugLineNum = 42;BA.debugLine="StatusTextMap.Put(DownloadManager1.STATUS_SUCCESS";
Debug.ShouldStop(512);
__ref.getField(false,"_statustextmap").runVoidMethod ("Put",(Object)((__ref.getField(false,"_downloadmanager1").getField(true,"STATUS_SUCCESSFUL"))),(Object)((RemoteObject.createImmutable("STATUS_SUCCESSFUL"))));
 BA.debugLineNum = 44;BA.debugLine="url2		=	Url";
Debug.ShouldStop(2048);
__ref.setField ("_url2",_url);
 BA.debugLineNum = 45;BA.debugLine="my_module	=	Module";
Debug.ShouldStop(4096);
__ref.setField ("_my_module",_module);
 BA.debugLineNum = 46;BA.debugLine="my_event	=	Event";
Debug.ShouldStop(8192);
__ref.setField ("_my_event",_event);
 BA.debugLineNum = 48;BA.debugLine="DownloadManagerRequest1.Initialize(Url)";
Debug.ShouldStop(32768);
__ref.getField(false,"_downloadmanagerrequest1").runVoidMethod ("Initialize",(Object)(_url));
 BA.debugLineNum = 50;BA.debugLine="Return Me";
Debug.ShouldStop(131072);
if (true) return BA.ObjectToString(__ref);
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
public static RemoteObject  _setdescription(RemoteObject __ref,RemoteObject _val) throws Exception{
try {
		Debug.PushSubsStack("SetDescription (filedownloadmanager) ","filedownloadmanager",3,__ref.getField(false, "ba"),__ref,77);
if (RapidSub.canDelegate("setdescription")) { return __ref.runUserSub(false, "filedownloadmanager","setdescription", __ref, _val);}
Debug.locals.put("Val", _val);
 BA.debugLineNum = 77;BA.debugLine="Public Sub SetDescription(Val As String) As FileDo";
Debug.ShouldStop(4096);
 BA.debugLineNum = 78;BA.debugLine="DownloadManagerRequest1.Description	=	Val";
Debug.ShouldStop(8192);
__ref.getField(false,"_downloadmanagerrequest1").runVoidMethod ("setDescription",_val);
 BA.debugLineNum = 79;BA.debugLine="Return Me";
Debug.ShouldStop(16384);
if (true) return (__ref);
 BA.debugLineNum = 80;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _setheader(RemoteObject __ref,RemoteObject _key,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("SetHeader (filedownloadmanager) ","filedownloadmanager",3,__ref.getField(false, "ba"),__ref,82);
if (RapidSub.canDelegate("setheader")) { return __ref.runUserSub(false, "filedownloadmanager","setheader", __ref, _key, _value);}
Debug.locals.put("Key", _key);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 82;BA.debugLine="Public Sub SetHeader(Key As String,Value As String";
Debug.ShouldStop(131072);
 BA.debugLineNum = 83;BA.debugLine="DownloadManagerRequest1.AddRequestHeader(Key,Valu";
Debug.ShouldStop(262144);
__ref.getField(false,"_downloadmanagerrequest1").runVoidMethod ("AddRequestHeader",(Object)(_key),(Object)(_value));
 BA.debugLineNum = 84;BA.debugLine="Return Me";
Debug.ShouldStop(524288);
if (true) return (__ref);
 BA.debugLineNum = 85;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _setmimetype(RemoteObject __ref,RemoteObject _stype) throws Exception{
try {
		Debug.PushSubsStack("SetMimeType (filedownloadmanager) ","filedownloadmanager",3,__ref.getField(false, "ba"),__ref,87);
if (RapidSub.canDelegate("setmimetype")) { return __ref.runUserSub(false, "filedownloadmanager","setmimetype", __ref, _stype);}
Debug.locals.put("sType", _stype);
 BA.debugLineNum = 87;BA.debugLine="Public Sub SetMimeType(sType As String) As FileDow";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 88;BA.debugLine="DownloadManagerRequest1.MimeType	=	sType";
Debug.ShouldStop(8388608);
__ref.getField(false,"_downloadmanagerrequest1").runVoidMethod ("setMimeType",_stype);
 BA.debugLineNum = 89;BA.debugLine="Return Me";
Debug.ShouldStop(16777216);
if (true) return (__ref);
 BA.debugLineNum = 90;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _setoutputfilename(RemoteObject __ref,RemoteObject _dir,RemoteObject _filename) throws Exception{
try {
		Debug.PushSubsStack("SetOutputFilename (filedownloadmanager) ","filedownloadmanager",3,__ref.getField(false, "ba"),__ref,67);
if (RapidSub.canDelegate("setoutputfilename")) { return __ref.runUserSub(false, "filedownloadmanager","setoutputfilename", __ref, _dir, _filename);}
Debug.locals.put("Dir", _dir);
Debug.locals.put("Filename", _filename);
 BA.debugLineNum = 67;BA.debugLine="Public Sub SetOutputFilename(Dir As String,Filenam";
Debug.ShouldStop(4);
 BA.debugLineNum = 68;BA.debugLine="DownloadManagerRequest1.DestinationUri	=	\"file://";
Debug.ShouldStop(8);
__ref.getField(false,"_downloadmanagerrequest1").runVoidMethod ("setDestinationUri",RemoteObject.concat(RemoteObject.createImmutable("file://"),filedownloadmanager.__c.getField(false,"File").runMethod(true,"Combine",(Object)(_dir),(Object)(_filename))));
 BA.debugLineNum = 69;BA.debugLine="Return Me";
Debug.ShouldStop(16);
if (true) return (__ref);
 BA.debugLineNum = 70;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _setshowui(RemoteObject __ref,RemoteObject _val) throws Exception{
try {
		Debug.PushSubsStack("SetShowUI (filedownloadmanager) ","filedownloadmanager",3,__ref.getField(false, "ba"),__ref,62);
if (RapidSub.canDelegate("setshowui")) { return __ref.runUserSub(false, "filedownloadmanager","setshowui", __ref, _val);}
Debug.locals.put("Val", _val);
 BA.debugLineNum = 62;BA.debugLine="Public Sub SetShowUI(Val As Boolean) As FileDownlo";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 63;BA.debugLine="DownloadManagerRequest1.VisibleInDownloadsUi	=	Va";
Debug.ShouldStop(1073741824);
__ref.getField(false,"_downloadmanagerrequest1").runVoidMethod ("setVisibleInDownloadsUi",_val);
 BA.debugLineNum = 64;BA.debugLine="Return Me";
Debug.ShouldStop(-2147483648);
if (true) return (__ref);
 BA.debugLineNum = 65;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _settitle(RemoteObject __ref,RemoteObject _val) throws Exception{
try {
		Debug.PushSubsStack("SetTitle (filedownloadmanager) ","filedownloadmanager",3,__ref.getField(false, "ba"),__ref,72);
if (RapidSub.canDelegate("settitle")) { return __ref.runUserSub(false, "filedownloadmanager","settitle", __ref, _val);}
Debug.locals.put("Val", _val);
 BA.debugLineNum = 72;BA.debugLine="Public Sub SetTitle(Val As String) As FileDownload";
Debug.ShouldStop(128);
 BA.debugLineNum = 73;BA.debugLine="DownloadManagerRequest1.Title	=	Val";
Debug.ShouldStop(256);
__ref.getField(false,"_downloadmanagerrequest1").runVoidMethod ("setTitle",_val);
 BA.debugLineNum = 74;BA.debugLine="Return Me";
Debug.ShouldStop(512);
if (true) return (__ref);
 BA.debugLineNum = 75;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}