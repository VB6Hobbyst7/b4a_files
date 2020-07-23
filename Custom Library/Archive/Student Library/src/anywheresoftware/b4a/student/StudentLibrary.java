package anywheresoftware.b4a.student;

import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Locale;

import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.Uri;
import android.telephony.TelephonyManager;
import android.text.ClipboardManager;
import android.view.View;
import android.widget.ImageView;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Permissions;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BA.Version;
import anywheresoftware.b4a.source.ZoomFunctionality;

@ShortName("StudentLibrary")
@Version(1f)
@Permissions(values={"android.permission.CAMERA","android.permission.SET_WALLPAPER","android.permission.READ_PHONE_STATE","android.permission.INTERNET","android.permission.ACCESS_FINE_LOCATION"})
public class StudentLibrary {
/**
 *Send Text to Clipboard
 */
	public void setTextClipboard(final BA ba,String sText)
	{
		ClipboardManager clipboard = (ClipboardManager) ba.context.getSystemService(Context.CLIPBOARD_SERVICE); 
		clipboard.setText(sText);
	}
	
/**
 *get Clipboard text
 */
	public String getTextClipBoard(final BA ba)
	{
		ClipboardManager clipboard = (ClipboardManager) ba.context.getSystemService(Context.CLIPBOARD_SERVICE); 
		return (String) clipboard.getText();		
	}
	
/**
 *Share Your Subject
 <code>
 *StartActivity(Share("اشتراک گذاری مطلب دانشجو","Share"))
 </code> 	
 */
   public Intent Share(String ShareMessage,String Subject)
   {
	   Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND); 
	    sharingIntent.setType("text/plain");
	    String shareBody = ShareMessage;
	    sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, Subject);
	    sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
	    return Intent.createChooser(sharingIntent, "اشتراک با");	   
   }

   
/**
*Convert Gregorian Date to Persian Date
<code>
*getPersianDate(0,0,0,"/") => get Current Date Convert
</code>
*I love you Persian Language (From Student Team www.iranapp.org)
	 */
	public String getPersianDate(int year, int month, int day,String Separator)
	{
		Main m1;
		 if (year == 0 && month == 0 && day == 0)
		   m1 = new Main();	 
		 else
		   m1 = new Main(year,month,day);
		 
		return m1.getIranianYear() + Separator + m1.getIranianMonth() + Separator + m1.getIranianDay();
	}
	
/**
*Convert Persian Date to Gregorian Date
<code>
*getGregorianDate(0,0,0,"/") => get Current Date Convert
</code>
*/	
	public String getGregorianDate(int year, int month, int day,String Separator)
	{
		Main m1;
		 if (year == 0 && month == 0 && day == 0)
		   m1 = new Main();	 
		 else
		   m1 = new Main(year,month,day);
		 
		return m1.getGregorianYear() + Separator + m1.getGregorianMonth() + Separator + m1.getGregorianDay();		
	}
	
/**
*get Screenshot from app
*for save output picture,set sPath Argument to filename(png)
*if sPath set null,function return bitmap
*/
	public Bitmap getScreenShot(View view1,String sPath)
	{
		    Bitmap bitmap = Bitmap.createBitmap(view1.getWidth(),
		            view1.getHeight(), Config.ARGB_8888);
		    Canvas canvas = new Canvas(bitmap);
		    view1.draw(canvas);
		    if (sPath == "")
		     return bitmap;
		    else {
		    	try {
		    	FileOutputStream fOut = new FileOutputStream(sPath);
		    	bitmap.compress(Bitmap.CompressFormat.PNG, 85, fOut);
		    	fOut.flush();
		    	return null;
		    	}
		    	catch(Exception e1)
		    	{
		    		return null;
		    	}
		    }
	}
	
/**
 *Encrypt string and return it
 *use sha1 for encrypt
 */
	public String EncrtyptString(String s) {
        MessageDigest digest = null;
                try {
                        digest = MessageDigest.getInstance("SHA-1");
                } catch (NoSuchAlgorithmException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
        digest.reset();
        byte[] data = digest.digest(s.getBytes());
        return String.format("%0" + (data.length*2) + "X", new BigInteger(1, data));
   }
	
	
/**
 *return Phone Number
 */
	public String getMyPhoneNumber(final BA ba){
        TelephonyManager mTelephonyMgr;
        mTelephonyMgr = (TelephonyManager)
                ba.context.getSystemService(Context.TELEPHONY_SERVICE); 
        return mTelephonyMgr.getLine1Number();
        }
	
/**
 *get distance between two location
 *unit (M for Mile and K for Kilometer
 */
	public double DistanceLocation(double Latitude1, double Longitude1, double Latitude2, double Longitude2, char Unit) {
		  double theta = Longitude1 - Longitude2;
		  double dist = Math.sin(deg2rad(Latitude1)) * Math.sin(deg2rad(Latitude2)) + Math.cos(deg2rad(Latitude1)) * Math.cos(deg2rad(Latitude2)) * Math.cos(deg2rad(theta));
		  dist = Math.acos(dist);
		  dist = rad2deg(dist);
		  dist = dist * 60 * 1.1515;
		  if (Unit == 'K') {
		    dist = dist * 1.609344;
		  } else if (Unit == 'N') {
		    dist = dist * 0.8684;
		    }
		  return (dist);
		}
		 
		private double deg2rad(double deg) {
		  return (deg * Math.PI / 180.0);
		}
		 
		private double rad2deg(double rad) {
		  return (rad * 180.0 / Math.PI);
		}
		
/**
 *set Picture to Wallpaper Android
 */
	public boolean setWallpaper(final BA ba,Bitmap bitmap1)
	{
		WallpaperManager myWallpaperManager = WallpaperManager.getInstance(ba.context);
		try {
		        myWallpaperManager.setBitmap(bitmap1);
		        return true;
		} catch (IOException e) {
		        e.printStackTrace();
		        return false;
		}			
	}
		
/**
 *get Wallpaper Picture Android
 */
	public Bitmap getWallpaper(final BA ba)
	{
		WallpaperManager myWallpaperManager = WallpaperManager.getInstance(ba.context);
		try {
		        Drawable d1 = myWallpaperManager.getDrawable();
		        Bitmap bitmap = Bitmap.createBitmap(d1.getIntrinsicWidth(), d1.getIntrinsicHeight(), Config.ARGB_8888);
		        Canvas canvas = new Canvas(bitmap); 
		        d1.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
		        d1.draw(canvas);
		        return bitmap;
		} catch (Exception e) {
		        e.printStackTrace();
		        return null;
		}			
	}		
  
/**
 *Load Image From Url And Set in ImageView
 */
	  public void LoadImageFromUrl(final BA ba,String URL,ImageView image)
		   {       
		  ImageLoader imgLoader = new ImageLoader(ba.context);
		  imgLoader.DisplayImage(URL, image);
		  }
	  
/**
*Get Valid and Complete GPS Location User
*MinDistance is Minimum Distance Change for Update
*/
	  public Location getGPSLocation(final BA ba,int MinDistance)
	  {
		  GPSTracker gps = new GPSTracker(ba.context);
          gps.setMIN_DISTANCE_CHANGE_FOR_UPDATES(MinDistance);
          // check if GPS enabled     
          if(gps.canGetLocation()){
              return gps.getLocation();
          }else{
              // can't get location
              // GPS or Network is not enabled
              // Ask user to enable GPS/network in settings
              gps.showSettingsAlert();
              return null;
          }
	  }
	  
/**
 *Play Stream Online Video
 *Argument Video Url and Package Name (Player Package Name)
 *Set Package Name to null for run with other package
 <code>
 Dim sl As StudentLibrary
 StartActivity(sl.PlayStreamVideo("http://www.iranapp.org/clip/b4a.mp4",""))
 </code>
 */
	  public static Intent PlayStreamVideo(String UrlVideo,String PackageName)
	  {
	   Uri uri = Uri.parse(UrlVideo.toString());
	   Intent i = new Intent("android.intent.action.VIEW");
	   if (PackageName != "")
	    i.setPackage(PackageName);
	   i.setDataAndType(uri, "video/*");
	   return i;       
	  }
	  
/**
 *Turn On FlashLight Camera
 *For TurnOff,Finish Activity
 */
	  public static Boolean TurnOnFlashLight(final BA ba)
	  {
		  if (ba.context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH) == false) return false;
		  Camera cam = Camera.open();     
		  Parameters p = cam.getParameters();
    	  p.setFlashMode(Parameters.FLASH_MODE_TORCH);
		  cam.setParameters(p);
		  cam.startPreview();
		  return true;		  
	  }
	  
/**
*Zoom ImageView With Multitouch
*Return ImageView
*Example Usage :
<code>
*Dim stuLib As StudentLibrary
*Activity.AddView(stuLib.MultiTouchImageView(File.Combine(File.DirRootExternal,"picture.jpg")),0,0,100%x,100%y)
</code>
*/
	  public static ImageView ZoomImageView(final BA b4a,String filename)
	  {
		  BitmapFactory.Options options = new BitmapFactory.Options();
		  options.inSampleSize = 2;
		  Bitmap bmp = BitmapFactory.decodeFile(filename, options);


		  ZoomFunctionality img = new ZoomFunctionality(b4a.context);
		  img.setImageBitmap(bmp);
		  img.setMaxZoom(4f);
		  return (ImageView)img;
	  }
	  
	  public static String getLocationName(final BA b4a,Location locations)
	  {               
		  double longitude = locations.getLongitude();
		  double latitude = locations.getLatitude();
		  Geocoder geocoder = new Geocoder(b4a.context, Locale.getDefault());                 
		  try {
		      List<Address> listAddresses = geocoder.getFromLocation(latitude, longitude, 1);
		      if(null!=listAddresses&&listAddresses.size()>0){
		          String _Location = listAddresses.get(0).getAddressLine(0);
		          return _Location;
		      }
		  } catch (IOException e) {
		      e.printStackTrace();
		      return e.getMessage();
		  }
		  return "";
	  }
	  
}
	 
