package b4a.exampleaa;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class filedownloadmanager extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new anywheresoftware.b4a.ShellBA(_ba, this, htSubs, "b4a.exampleaa.filedownloadmanager");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", b4a.exampleaa.filedownloadmanager.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 
    public void  innerInitializeHelper(anywheresoftware.b4a.BA _ba) throws Exception{
        innerInitialize(_ba);
    }
    public Object callSub(String sub, Object sender, Object[] args) throws Exception {
        return BA.SubDelegator.SubNotFound;
    }
public anywheresoftware.b4a.keywords.Common __c = null;
public uk.co.martinpearman.b4a.downloadmanager.B4ADownloadManager _downloadmanager1 = null;
public anywheresoftware.b4a.objects.collections.Map _reasontextmap = null;
public anywheresoftware.b4a.objects.collections.Map _statustextmap = null;
public boolean _isinitialized = false;
public String _url2 = "";
public long _downloadid = 0L;
public uk.co.martinpearman.b4a.downloadmanager.RequestWrapper _downloadmanagerrequest1 = null;
public Object _my_module = null;
public String _my_event = "";
public b4a.exampleaa.main _main = null;
public b4a.exampleaa.lib _lib = null;
public b4a.exampleaa.lib2 _lib2 = null;
public String  _initialize(b4a.exampleaa.filedownloadmanager __ref,anywheresoftware.b4a.BA _ba,Object _module,String _event,String _url) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="filedownloadmanager";
if (Debug.shouldDelegate(ba, "initialize"))
	 {return ((String) Debug.delegate(ba, "initialize", new Object[] {_ba,_module,_event,_url}));}
RDebugUtils.currentLine=786432;
 //BA.debugLineNum = 786432;BA.debugLine="Public Sub Initialize(Module As Object,Event As St";
RDebugUtils.currentLine=786434;
 //BA.debugLineNum = 786434;BA.debugLine="DownloadManager1.RegisterReceiver(\"DownloadManage";
__ref._downloadmanager1.RegisterReceiver(ba,"DownloadManager1");
RDebugUtils.currentLine=786436;
 //BA.debugLineNum = 786436;BA.debugLine="ReasonTextMap.Initialize";
__ref._reasontextmap.Initialize();
RDebugUtils.currentLine=786437;
 //BA.debugLineNum = 786437;BA.debugLine="ReasonTextMap.Put(DownloadManager1.ERROR_CANNOT_R";
__ref._reasontextmap.Put((Object)(__ref._downloadmanager1.ERROR_CANNOT_RESUME),(Object)("ERROR_CANNOT_RESUME"));
RDebugUtils.currentLine=786438;
 //BA.debugLineNum = 786438;BA.debugLine="ReasonTextMap.Put(DownloadManager1.ERROR_DEVICE_N";
__ref._reasontextmap.Put((Object)(__ref._downloadmanager1.ERROR_DEVICE_NOT_FOUND),(Object)("ERROR_DEVICE_NOT_FOUND"));
RDebugUtils.currentLine=786439;
 //BA.debugLineNum = 786439;BA.debugLine="ReasonTextMap.Put(DownloadManager1.ERROR_FILE_ALR";
__ref._reasontextmap.Put((Object)(__ref._downloadmanager1.ERROR_FILE_ALREADY_EXISTS),(Object)("ERROR_FILE_ALREADY_EXISTS"));
RDebugUtils.currentLine=786440;
 //BA.debugLineNum = 786440;BA.debugLine="ReasonTextMap.Put(DownloadManager1.ERROR_FILE_ERR";
__ref._reasontextmap.Put((Object)(__ref._downloadmanager1.ERROR_FILE_ERROR),(Object)("ERROR_FILE_ERROR"));
RDebugUtils.currentLine=786441;
 //BA.debugLineNum = 786441;BA.debugLine="ReasonTextMap.Put(DownloadManager1.ERROR_HTTP_DAT";
__ref._reasontextmap.Put((Object)(__ref._downloadmanager1.ERROR_HTTP_DATA_ERROR),(Object)("ERROR_HTTP_DATA_ERROR"));
RDebugUtils.currentLine=786442;
 //BA.debugLineNum = 786442;BA.debugLine="ReasonTextMap.Put(DownloadManager1.ERROR_INSUFFIC";
__ref._reasontextmap.Put((Object)(__ref._downloadmanager1.ERROR_INSUFFICIENT_SPACE),(Object)("ERROR_INSUFFICIENT_SPACE"));
RDebugUtils.currentLine=786443;
 //BA.debugLineNum = 786443;BA.debugLine="ReasonTextMap.Put(DownloadManager1.ERROR_TOO_MANY";
__ref._reasontextmap.Put((Object)(__ref._downloadmanager1.ERROR_TOO_MANY_REDIRECTS),(Object)("ERROR_TOO_MANY_REDIRECTS"));
RDebugUtils.currentLine=786444;
 //BA.debugLineNum = 786444;BA.debugLine="ReasonTextMap.Put(DownloadManager1.ERROR_UNHANDLE";
__ref._reasontextmap.Put((Object)(__ref._downloadmanager1.ERROR_UNHANDLED_HTTP_CODE),(Object)("ERROR_UNHANDLED_HTTP_CODE"));
RDebugUtils.currentLine=786445;
 //BA.debugLineNum = 786445;BA.debugLine="ReasonTextMap.Put(DownloadManager1.ERROR_UNKNOWN,";
__ref._reasontextmap.Put((Object)(__ref._downloadmanager1.ERROR_UNKNOWN),(Object)("ERROR_UNKNOWN"));
RDebugUtils.currentLine=786446;
 //BA.debugLineNum = 786446;BA.debugLine="ReasonTextMap.Put(DownloadManager1.PAUSED_QUEUED_";
__ref._reasontextmap.Put((Object)(__ref._downloadmanager1.PAUSED_QUEUED_FOR_WIFI),(Object)("PAUSED_QUEUED_FOR_WIFI"));
RDebugUtils.currentLine=786447;
 //BA.debugLineNum = 786447;BA.debugLine="ReasonTextMap.Put(DownloadManager1.PAUSED_UNKNOWN";
__ref._reasontextmap.Put((Object)(__ref._downloadmanager1.PAUSED_UNKNOWN),(Object)("PAUSED_UNKNOWN"));
RDebugUtils.currentLine=786448;
 //BA.debugLineNum = 786448;BA.debugLine="ReasonTextMap.Put(DownloadManager1.PAUSED_WAITING";
__ref._reasontextmap.Put((Object)(__ref._downloadmanager1.PAUSED_WAITING_FOR_NETWORK),(Object)("PAUSED_WAITING_FOR_NETWORK"));
RDebugUtils.currentLine=786449;
 //BA.debugLineNum = 786449;BA.debugLine="ReasonTextMap.Put(DownloadManager1.PAUSED_WAITING";
__ref._reasontextmap.Put((Object)(__ref._downloadmanager1.PAUSED_WAITING_TO_RETRY),(Object)("PAUSED_WAITING_TO_RETRY"));
RDebugUtils.currentLine=786451;
 //BA.debugLineNum = 786451;BA.debugLine="StatusTextMap.Initialize";
__ref._statustextmap.Initialize();
RDebugUtils.currentLine=786452;
 //BA.debugLineNum = 786452;BA.debugLine="StatusTextMap.Put(DownloadManager1.STATUS_FAILED,";
__ref._statustextmap.Put((Object)(__ref._downloadmanager1.STATUS_FAILED),(Object)("STATUS_FAILED"));
RDebugUtils.currentLine=786453;
 //BA.debugLineNum = 786453;BA.debugLine="StatusTextMap.Put(DownloadManager1.STATUS_PAUSED,";
__ref._statustextmap.Put((Object)(__ref._downloadmanager1.STATUS_PAUSED),(Object)("STATUS_PAUSED"));
RDebugUtils.currentLine=786454;
 //BA.debugLineNum = 786454;BA.debugLine="StatusTextMap.Put(DownloadManager1.STATUS_PENDING";
__ref._statustextmap.Put((Object)(__ref._downloadmanager1.STATUS_PENDING),(Object)("STATUS_PENDING"));
RDebugUtils.currentLine=786455;
 //BA.debugLineNum = 786455;BA.debugLine="StatusTextMap.Put(DownloadManager1.STATUS_RUNNING";
__ref._statustextmap.Put((Object)(__ref._downloadmanager1.STATUS_RUNNING),(Object)("STATUS_RUNNING"));
RDebugUtils.currentLine=786456;
 //BA.debugLineNum = 786456;BA.debugLine="StatusTextMap.Put(DownloadManager1.STATUS_SUCCESS";
__ref._statustextmap.Put((Object)(__ref._downloadmanager1.STATUS_SUCCESSFUL),(Object)("STATUS_SUCCESSFUL"));
RDebugUtils.currentLine=786458;
 //BA.debugLineNum = 786458;BA.debugLine="url2		=	Url";
__ref._url2 = _url;
RDebugUtils.currentLine=786459;
 //BA.debugLineNum = 786459;BA.debugLine="my_module	=	Module";
__ref._my_module = _module;
RDebugUtils.currentLine=786460;
 //BA.debugLineNum = 786460;BA.debugLine="my_event	=	Event";
__ref._my_event = _event;
RDebugUtils.currentLine=786462;
 //BA.debugLineNum = 786462;BA.debugLine="DownloadManagerRequest1.Initialize(Url)";
__ref._downloadmanagerrequest1.Initialize(_url);
RDebugUtils.currentLine=786464;
 //BA.debugLineNum = 786464;BA.debugLine="Return Me";
if (true) return BA.ObjectToString(this);
RDebugUtils.currentLine=786466;
 //BA.debugLineNum = 786466;BA.debugLine="End Sub";
return "";
}
public b4a.exampleaa.filedownloadmanager  _setdescription(b4a.exampleaa.filedownloadmanager __ref,String _val) throws Exception{
__ref = this;
RDebugUtils.currentModule="filedownloadmanager";
if (Debug.shouldDelegate(ba, "setdescription"))
	 {return ((b4a.exampleaa.filedownloadmanager) Debug.delegate(ba, "setdescription", new Object[] {_val}));}
RDebugUtils.currentLine=1179648;
 //BA.debugLineNum = 1179648;BA.debugLine="Public Sub SetDescription(Val As String) As FileDo";
RDebugUtils.currentLine=1179649;
 //BA.debugLineNum = 1179649;BA.debugLine="DownloadManagerRequest1.Description	=	Val";
__ref._downloadmanagerrequest1.setDescription(_val);
RDebugUtils.currentLine=1179650;
 //BA.debugLineNum = 1179650;BA.debugLine="Return Me";
if (true) return (b4a.exampleaa.filedownloadmanager)(this);
RDebugUtils.currentLine=1179651;
 //BA.debugLineNum = 1179651;BA.debugLine="End Sub";
return null;
}
public b4a.exampleaa.filedownloadmanager  _setheader(b4a.exampleaa.filedownloadmanager __ref,String _key,String _value) throws Exception{
__ref = this;
RDebugUtils.currentModule="filedownloadmanager";
if (Debug.shouldDelegate(ba, "setheader"))
	 {return ((b4a.exampleaa.filedownloadmanager) Debug.delegate(ba, "setheader", new Object[] {_key,_value}));}
RDebugUtils.currentLine=1245184;
 //BA.debugLineNum = 1245184;BA.debugLine="Public Sub SetHeader(Key As String,Value As String";
RDebugUtils.currentLine=1245185;
 //BA.debugLineNum = 1245185;BA.debugLine="DownloadManagerRequest1.AddRequestHeader(Key,Valu";
__ref._downloadmanagerrequest1.AddRequestHeader(_key,_value);
RDebugUtils.currentLine=1245186;
 //BA.debugLineNum = 1245186;BA.debugLine="Return Me";
if (true) return (b4a.exampleaa.filedownloadmanager)(this);
RDebugUtils.currentLine=1245187;
 //BA.debugLineNum = 1245187;BA.debugLine="End Sub";
return null;
}
public b4a.exampleaa.filedownloadmanager  _setoutputfilename(b4a.exampleaa.filedownloadmanager __ref,String _dir,String _filename) throws Exception{
__ref = this;
RDebugUtils.currentModule="filedownloadmanager";
if (Debug.shouldDelegate(ba, "setoutputfilename"))
	 {return ((b4a.exampleaa.filedownloadmanager) Debug.delegate(ba, "setoutputfilename", new Object[] {_dir,_filename}));}
RDebugUtils.currentLine=1048576;
 //BA.debugLineNum = 1048576;BA.debugLine="Public Sub SetOutputFilename(Dir As String,Filenam";
RDebugUtils.currentLine=1048577;
 //BA.debugLineNum = 1048577;BA.debugLine="DownloadManagerRequest1.DestinationUri	=	\"file://";
__ref._downloadmanagerrequest1.setDestinationUri("file://"+__c.File.Combine(_dir,_filename));
RDebugUtils.currentLine=1048578;
 //BA.debugLineNum = 1048578;BA.debugLine="Return Me";
if (true) return (b4a.exampleaa.filedownloadmanager)(this);
RDebugUtils.currentLine=1048579;
 //BA.debugLineNum = 1048579;BA.debugLine="End Sub";
return null;
}
public b4a.exampleaa.filedownloadmanager  _setshowui(b4a.exampleaa.filedownloadmanager __ref,boolean _val) throws Exception{
__ref = this;
RDebugUtils.currentModule="filedownloadmanager";
if (Debug.shouldDelegate(ba, "setshowui"))
	 {return ((b4a.exampleaa.filedownloadmanager) Debug.delegate(ba, "setshowui", new Object[] {_val}));}
RDebugUtils.currentLine=983040;
 //BA.debugLineNum = 983040;BA.debugLine="Public Sub SetShowUI(Val As Boolean) As FileDownlo";
RDebugUtils.currentLine=983041;
 //BA.debugLineNum = 983041;BA.debugLine="DownloadManagerRequest1.VisibleInDownloadsUi	=	Va";
__ref._downloadmanagerrequest1.setVisibleInDownloadsUi(_val);
RDebugUtils.currentLine=983042;
 //BA.debugLineNum = 983042;BA.debugLine="Return Me";
if (true) return (b4a.exampleaa.filedownloadmanager)(this);
RDebugUtils.currentLine=983043;
 //BA.debugLineNum = 983043;BA.debugLine="End Sub";
return null;
}
public b4a.exampleaa.filedownloadmanager  _settitle(b4a.exampleaa.filedownloadmanager __ref,String _val) throws Exception{
__ref = this;
RDebugUtils.currentModule="filedownloadmanager";
if (Debug.shouldDelegate(ba, "settitle"))
	 {return ((b4a.exampleaa.filedownloadmanager) Debug.delegate(ba, "settitle", new Object[] {_val}));}
RDebugUtils.currentLine=1114112;
 //BA.debugLineNum = 1114112;BA.debugLine="Public Sub SetTitle(Val As String) As FileDownload";
RDebugUtils.currentLine=1114113;
 //BA.debugLineNum = 1114113;BA.debugLine="DownloadManagerRequest1.Title	=	Val";
__ref._downloadmanagerrequest1.setTitle(_val);
RDebugUtils.currentLine=1114114;
 //BA.debugLineNum = 1114114;BA.debugLine="Return Me";
if (true) return (b4a.exampleaa.filedownloadmanager)(this);
RDebugUtils.currentLine=1114115;
 //BA.debugLineNum = 1114115;BA.debugLine="End Sub";
return null;
}
public String  _download(b4a.exampleaa.filedownloadmanager __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="filedownloadmanager";
if (Debug.shouldDelegate(ba, "download"))
	 {return ((String) Debug.delegate(ba, "download", null));}
RDebugUtils.currentLine=1376256;
 //BA.debugLineNum = 1376256;BA.debugLine="Public Sub Download";
RDebugUtils.currentLine=1376257;
 //BA.debugLineNum = 1376257;BA.debugLine="DownloadId	=	DownloadManager1.Enqueue(DownloadMan";
__ref._downloadid = __ref._downloadmanager1.Enqueue(ba,(android.app.DownloadManager.Request)(__ref._downloadmanagerrequest1.getObject()));
RDebugUtils.currentLine=1376258;
 //BA.debugLineNum = 1376258;BA.debugLine="End Sub";
return "";
}
public String  _class_globals(b4a.exampleaa.filedownloadmanager __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="filedownloadmanager";
RDebugUtils.currentLine=720896;
 //BA.debugLineNum = 720896;BA.debugLine="Private Sub Class_Globals";
RDebugUtils.currentLine=720897;
 //BA.debugLineNum = 720897;BA.debugLine="Private DownloadManager1 As DownloadManager";
_downloadmanager1 = new uk.co.martinpearman.b4a.downloadmanager.B4ADownloadManager();
RDebugUtils.currentLine=720898;
 //BA.debugLineNum = 720898;BA.debugLine="Private ReasonTextMap As Map";
_reasontextmap = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=720899;
 //BA.debugLineNum = 720899;BA.debugLine="Private StatusTextMap As Map";
_statustextmap = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=720900;
 //BA.debugLineNum = 720900;BA.debugLine="Private IsInitialized As Boolean=False";
_isinitialized = __c.False;
RDebugUtils.currentLine=720901;
 //BA.debugLineNum = 720901;BA.debugLine="Private url2 As String";
_url2 = "";
RDebugUtils.currentLine=720902;
 //BA.debugLineNum = 720902;BA.debugLine="Private DownloadId As Long";
_downloadid = 0L;
RDebugUtils.currentLine=720903;
 //BA.debugLineNum = 720903;BA.debugLine="Private DownloadManagerRequest1 As DownloadManage";
_downloadmanagerrequest1 = new uk.co.martinpearman.b4a.downloadmanager.RequestWrapper();
RDebugUtils.currentLine=720904;
 //BA.debugLineNum = 720904;BA.debugLine="Private my_module As Object";
_my_module = new Object();
RDebugUtils.currentLine=720905;
 //BA.debugLineNum = 720905;BA.debugLine="Private my_event As String";
_my_event = "";
RDebugUtils.currentLine=720906;
 //BA.debugLineNum = 720906;BA.debugLine="End Sub";
return "";
}
public String  _downloadmanager1_downloadcomplete(b4a.exampleaa.filedownloadmanager __ref,long _downloadid1) throws Exception{
__ref = this;
RDebugUtils.currentModule="filedownloadmanager";
if (Debug.shouldDelegate(ba, "downloadmanager1_downloadcomplete"))
	 {return ((String) Debug.delegate(ba, "downloadmanager1_downloadcomplete", new Object[] {_downloadid1}));}
uk.co.martinpearman.b4a.downloadmanager.QueryWrapper _downloadmanagerquery1 = null;
anywheresoftware.b4a.sql.SQL.CursorWrapper _statuscursor = null;
int _statusint = 0;
RDebugUtils.currentLine=1441792;
 //BA.debugLineNum = 1441792;BA.debugLine="Sub DownloadManager1_DownloadComplete(DownloadId1";
RDebugUtils.currentLine=1441794;
 //BA.debugLineNum = 1441794;BA.debugLine="If DownloadId	=	DownloadId1 Then";
if (__ref._downloadid==_downloadid1) { 
RDebugUtils.currentLine=1441796;
 //BA.debugLineNum = 1441796;BA.debugLine="Dim DownloadManagerQuery1 As DownloadManagerQuer";
_downloadmanagerquery1 = new uk.co.martinpearman.b4a.downloadmanager.QueryWrapper();
RDebugUtils.currentLine=1441797;
 //BA.debugLineNum = 1441797;BA.debugLine="DownloadManagerQuery1.Initialize";
_downloadmanagerquery1.Initialize();
RDebugUtils.currentLine=1441798;
 //BA.debugLineNum = 1441798;BA.debugLine="DownloadManagerQuery1.SetFilterById(DownloadId)";
_downloadmanagerquery1.SetFilterById(__ref._downloadid);
RDebugUtils.currentLine=1441800;
 //BA.debugLineNum = 1441800;BA.debugLine="Dim StatusCursor As Cursor";
_statuscursor = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
RDebugUtils.currentLine=1441801;
 //BA.debugLineNum = 1441801;BA.debugLine="StatusCursor=DownloadManager1.Query(DownloadMana";
_statuscursor = __ref._downloadmanager1.Query(ba,(android.app.DownloadManager.Query)(_downloadmanagerquery1.getObject()));
RDebugUtils.currentLine=1441803;
 //BA.debugLineNum = 1441803;BA.debugLine="If StatusCursor.RowCount > 0 Then";
if (_statuscursor.getRowCount()>0) { 
RDebugUtils.currentLine=1441805;
 //BA.debugLineNum = 1441805;BA.debugLine="StatusCursor.Position=0";
_statuscursor.setPosition((int) (0));
RDebugUtils.currentLine=1441807;
 //BA.debugLineNum = 1441807;BA.debugLine="Dim StatusInt As Int";
_statusint = 0;
RDebugUtils.currentLine=1441808;
 //BA.debugLineNum = 1441808;BA.debugLine="StatusInt=StatusCursor.getInt(DownloadManager1.";
_statusint = _statuscursor.GetInt(__ref._downloadmanager1.COLUMN_STATUS);
RDebugUtils.currentLine=1441810;
 //BA.debugLineNum = 1441810;BA.debugLine="If StatusInt=DownloadManager1.STATUS_FAILED Or";
if (_statusint==__ref._downloadmanager1.STATUS_FAILED || _statusint==__ref._downloadmanager1.STATUS_PAUSED) { 
RDebugUtils.currentLine=1441811;
 //BA.debugLineNum = 1441811;BA.debugLine="If IsPaused(my_module) = False Then CallSubDel";
if (__c.IsPaused(ba,__ref._my_module)==__c.False) { 
__c.CallSubDelayed2(ba,__ref._my_module,__ref._my_event.toLowerCase()+"_complete",(Object)(__c.False));};
 }else {
RDebugUtils.currentLine=1441813;
 //BA.debugLineNum = 1441813;BA.debugLine="If IsPaused(my_module) = False Then CallSubDel";
if (__c.IsPaused(ba,__ref._my_module)==__c.False) { 
__c.CallSubDelayed2(ba,__ref._my_module,__ref._my_event.toLowerCase()+"_complete",(Object)(__c.True));};
 };
 }else {
RDebugUtils.currentLine=1441817;
 //BA.debugLineNum = 1441817;BA.debugLine="If IsPaused(my_module) = False Then CallSubDela";
if (__c.IsPaused(ba,__ref._my_module)==__c.False) { 
__c.CallSubDelayed2(ba,__ref._my_module,__ref._my_event.toLowerCase()+"_complete",(Object)(__c.False));};
RDebugUtils.currentLine=1441818;
 //BA.debugLineNum = 1441818;BA.debugLine="Log(\"The DownloadManager has no trace of our re";
__c.Log("The DownloadManager has no trace of our request, it could have been cancelled by the user using the Android Downloads app or an unknown error has occurred.");
 };
RDebugUtils.currentLine=1441822;
 //BA.debugLineNum = 1441822;BA.debugLine="StatusCursor.Close";
_statuscursor.Close();
RDebugUtils.currentLine=1441823;
 //BA.debugLineNum = 1441823;BA.debugLine="DownloadManager1.UnregisterReceiver";
__ref._downloadmanager1.UnregisterReceiver(ba);
 };
RDebugUtils.currentLine=1441827;
 //BA.debugLineNum = 1441827;BA.debugLine="End Sub";
return "";
}
public String  _downloadmanager1_notificationclicked(b4a.exampleaa.filedownloadmanager __ref,long[] _downloadids) throws Exception{
__ref = this;
RDebugUtils.currentModule="filedownloadmanager";
if (Debug.shouldDelegate(ba, "downloadmanager1_notificationclicked"))
	 {return ((String) Debug.delegate(ba, "downloadmanager1_notificationclicked", new Object[] {_downloadids}));}
RDebugUtils.currentLine=1507328;
 //BA.debugLineNum = 1507328;BA.debugLine="Sub DownloadManager1_NotificationClicked(DownloadI";
RDebugUtils.currentLine=1507329;
 //BA.debugLineNum = 1507329;BA.debugLine="If IsPaused(my_module) = False Then CallSubDelaye";
if (__c.IsPaused(ba,__ref._my_module)==__c.False) { 
__c.CallSubDelayed2(ba,__ref._my_module,__ref._my_event.toLowerCase()+"_notificationclick",(Object)(__c.False));};
RDebugUtils.currentLine=1507330;
 //BA.debugLineNum = 1507330;BA.debugLine="End Sub";
return "";
}
public String  _getreasontext(b4a.exampleaa.filedownloadmanager __ref,int _index) throws Exception{
__ref = this;
RDebugUtils.currentModule="filedownloadmanager";
if (Debug.shouldDelegate(ba, "getreasontext"))
	 {return ((String) Debug.delegate(ba, "getreasontext", new Object[] {_index}));}
RDebugUtils.currentLine=851968;
 //BA.debugLineNum = 851968;BA.debugLine="Private Sub GetReasonText(Index As Int) As String";
RDebugUtils.currentLine=851969;
 //BA.debugLineNum = 851969;BA.debugLine="Return ReasonTextMap.Get(Index)";
if (true) return BA.ObjectToString(__ref._reasontextmap.Get((Object)(_index)));
RDebugUtils.currentLine=851970;
 //BA.debugLineNum = 851970;BA.debugLine="End Sub";
return "";
}
public String  _getstatustext(b4a.exampleaa.filedownloadmanager __ref,int _index) throws Exception{
__ref = this;
RDebugUtils.currentModule="filedownloadmanager";
if (Debug.shouldDelegate(ba, "getstatustext"))
	 {return ((String) Debug.delegate(ba, "getstatustext", new Object[] {_index}));}
RDebugUtils.currentLine=917504;
 //BA.debugLineNum = 917504;BA.debugLine="Private Sub GetStatusText(Index As Int) As String";
RDebugUtils.currentLine=917505;
 //BA.debugLineNum = 917505;BA.debugLine="Return StatusTextMap.Get(Index)";
if (true) return BA.ObjectToString(__ref._statustextmap.Get((Object)(_index)));
RDebugUtils.currentLine=917506;
 //BA.debugLineNum = 917506;BA.debugLine="End Sub";
return "";
}
public b4a.exampleaa.filedownloadmanager  _setmimetype(b4a.exampleaa.filedownloadmanager __ref,String _stype) throws Exception{
__ref = this;
RDebugUtils.currentModule="filedownloadmanager";
if (Debug.shouldDelegate(ba, "setmimetype"))
	 {return ((b4a.exampleaa.filedownloadmanager) Debug.delegate(ba, "setmimetype", new Object[] {_stype}));}
RDebugUtils.currentLine=1310720;
 //BA.debugLineNum = 1310720;BA.debugLine="Public Sub SetMimeType(sType As String) As FileDow";
RDebugUtils.currentLine=1310721;
 //BA.debugLineNum = 1310721;BA.debugLine="DownloadManagerRequest1.MimeType	=	sType";
__ref._downloadmanagerrequest1.setMimeType(_stype);
RDebugUtils.currentLine=1310722;
 //BA.debugLineNum = 1310722;BA.debugLine="Return Me";
if (true) return (b4a.exampleaa.filedownloadmanager)(this);
RDebugUtils.currentLine=1310723;
 //BA.debugLineNum = 1310723;BA.debugLine="End Sub";
return null;
}
}