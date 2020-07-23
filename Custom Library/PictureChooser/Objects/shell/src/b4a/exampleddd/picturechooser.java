
package b4a.exampleddd;

import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RemoteObject;

public class picturechooser {
    public static RemoteObject myClass;
	public picturechooser() {
	}
    public static PCBA staticBA = new PCBA(null, picturechooser.class);

public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _ion = RemoteObject.declareNull("Object");
public static RemoteObject _imagefolder = RemoteObject.createImmutable("");
public static RemoteObject _isfrontcamera = RemoteObject.createImmutable(false);
public static RemoteObject _tempimagefile = RemoteObject.createImmutable("");
public static RemoteObject _chooser = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone.ContentChooser");
public static RemoteObject _modue = RemoteObject.declareNull("Object");
public static RemoteObject _evt = RemoteObject.createImmutable("");
public static RemoteObject _sdir = RemoteObject.createImmutable("");
public static RemoteObject _sfilename = RemoteObject.createImmutable("");
public static RemoteObject _is_crop = RemoteObject.createImmutable(false);
public static RemoteObject _p2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _cv = RemoteObject.declareNull("de.donmanfred.CropImageViewWrapper");
public static RemoteObject _btnrotate = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _rotate_title = RemoteObject.createImmutable("");
public static RemoteObject _crop_title = RemoteObject.createImmutable("");
public static RemoteObject _cancel_title = RemoteObject.createImmutable("");
public static RemoteObject _b = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _quality2 = RemoteObject.createImmutable(0);
public static RemoteObject _cancel = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _chooser_title = RemoteObject.createImmutable("");
public static RemoteObject _currentuserbitmap = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
public static RemoteObject _rp = RemoteObject.declareNull("anywheresoftware.b4a.objects.RuntimePermissions");
public static RemoteObject _currentdircrop = RemoteObject.createImmutable("");
public static RemoteObject _currentfilenamecrop = RemoteObject.createImmutable("");
public static RemoteObject _aspectratiowidth = RemoteObject.createImmutable(0);
public static RemoteObject _aspectratioheight = RemoteObject.createImmutable(0);
public static RemoteObject _isscale = RemoteObject.createImmutable(false);
public static b4a.exampleddd.main _main = null;
public static b4a.exampleddd.starter _starter = null;
public static Object[] GetGlobals(RemoteObject _ref) throws Exception {
		return new Object[] {"AspectRatioHeight",_ref.getField(false, "_aspectratioheight"),"AspectRatioWidth",_ref.getField(false, "_aspectratiowidth"),"b",_ref.getField(false, "_b"),"btnrotate",_ref.getField(false, "_btnrotate"),"cancel",_ref.getField(false, "_cancel"),"cancel_title",_ref.getField(false, "_cancel_title"),"chooser",_ref.getField(false, "_chooser"),"Chooser_Title",_ref.getField(false, "_chooser_title"),"crop_title",_ref.getField(false, "_crop_title"),"CurrentDirCrop",_ref.getField(false, "_currentdircrop"),"CurrentFilenameCrop",_ref.getField(false, "_currentfilenamecrop"),"CurrentUserBitmap",_ref.getField(false, "_currentuserbitmap"),"CV",_ref.getField(false, "_cv"),"evt",_ref.getField(false, "_evt"),"imageFolder",_ref.getField(false, "_imagefolder"),"ion",_ref.getField(false, "_ion"),"is_crop",_ref.getField(false, "_is_crop"),"IsFrontCamera",_ref.getField(false, "_isfrontcamera"),"IsScale",_ref.getField(false, "_isscale"),"modue",_ref.getField(false, "_modue"),"p2",_ref.getField(false, "_p2"),"quality2",_ref.getField(false, "_quality2"),"rotate_title",_ref.getField(false, "_rotate_title"),"rp",_ref.getField(false, "_rp"),"sDir",_ref.getField(false, "_sdir"),"sFilename",_ref.getField(false, "_sfilename"),"tempImageFile",_ref.getField(false, "_tempimagefile")};
}
}