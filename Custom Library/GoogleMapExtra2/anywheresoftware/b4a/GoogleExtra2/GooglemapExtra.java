package anywheresoftware.b4a.GoogleExtra2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnCameraChangeListener;
import com.google.android.gms.maps.GoogleMap.SnapshotReadyCallback;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.location.Location;
import android.location.LocationManager;
import android.os.Handler;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.Html;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Toast;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.Events;
import anywheresoftware.b4a.BA.Permissions;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BA.Version;
import anywheresoftware.b4a.objects.drawable.BitmapDrawable;

@ShortName("GoogleMapExtra2")
@Author("www.iranapp.org")
@Permissions(values={"android.permission.ACCESS_FINE_LOCATION"})
@Events(values={"EndAnimationMarker (Marker As Marker)","ChangeCamera","GetSnapshot (Bitmap1 As Object)","CameraChangeEnd (Latitude As Double,Longitude As Double,Zoom As Float)"})
@Version(5f)

public class GooglemapExtra {
	
	GoogleMap Map;
	int widthline,colorline;
	boolean geodesic;
	public String MAPTYPE_SATELLITE = "satellite";
	public String MAPTYPE_TERRAIN	= "terrain";
	public String MAPTYPE_HYBIRD	= "hybrid";
	public String MAPTYPE_NORMAL	= "normal";
	private CoordinateConversion convert = new CoordinateConversion();
	private LatLng sw;
	private LatLng ne;
	private Timer t;
	private double ne1,ne2,sw1,sw2;
	
	public String MARKERCOLOR_AZURE = "azure";
	public String MARKERCOLOR_BLUE = "blue";
	public String MARKERCOLOR_CYAN = "cyan";
	public String MARKERCOLOR_GREEN = "green";
	public String MARKERCOLOR_MAGENTA = "magenta";
	public String MARKERCOLOR_ORANGE = "orange";
	public String MARKERCOLOR_RED = "red";
	public String MARKERCOLOR_ROSE = "rose";
	public String MARKERCOLOR_VIOLET = "violet";
	public String MARKERCOLOR_YELLOW = "yellow";
	
	public String MODE_DRIVING = "driving";
	public String MODE_WALKING = "walking";
	public String MODE_BICYCLING = "bicycling";
	public String MODE_TRANSIT = "transit";
	
	public String AVOID_HIGHWAYS = "highways";
	public String AVOID_TOLLS = "tolls";
	public String AVOID_FERRIES = "ferries";
	
	/**
     * Define googlemap view
     *Aurgument can be null
     *Author : www.iranapp.org
     *
     *If you get error when use thi library so use below function (need to java object)
     *<code>
     *Sub DisableStrictMode
     * Dim jo As JavaObject
     * jo.InitializeStatic("android.os.Build.VERSION")
     * If jo.GetField("SDK_INT") > 9 Then
     *   Dim policy As JavaObject
     *   policy = policy.InitializeNewInstance("android.os.StrictMode.ThreadPolicy.Builder", Null)
     *   policy = policy.RunMethodJO("permitAll", Null).RunMethodJO("build", Null)
     *   Dim sm As JavaObject
     *   sm.InitializeStatic("android.os.StrictMode").RunMethod("setThreadPolicy", Array(policy))
     * End If
     *End Sub
     *</code>
     */
	public void Initilize(final BA b4a,Object map){
		
		if (map == null) return;
		Map = (GoogleMap) map;
		
	}

	/**
	 * Check location exist in zoomed map region
	 */
	public boolean CheckLocationInBound(double Latitude,double Longitude) {
		
		LatLngBounds bounds = Map.getProjection().getVisibleRegion().latLngBounds;  
		if(bounds.contains(new LatLng(Latitude, Longitude)))
			return true;
		else
			return false;

	}
	
	/*Get Valid user location
	*MinDistance is Minimum meter for get location
	*/
	public Location GetMyLocation(final BA ba,int MinDistance)
		  {
		
			  GPSTracker gps = new GPSTracker(ba.context);
	          gps.setMIN_DISTANCE_CHANGE_FOR_UPDATES(MinDistance);
	          
	          // check if GPS enabled     
	          if(gps.canGetLocation()){
	              return gps.getLocation();
	          }else{
	              return null;
	          }
	          
		  }
	
	/**
	 * 
	 * Detect direction of user on map and return rotated bitmap or angle value
	 */
	public Object DetectLocationDirection(Location StartLocation,Location EndLocation,Bitmap Icon,boolean OnlyDirection) {
		
		float angle=(float)finalBearing(StartLocation.getLatitude(), StartLocation.getLongitude(), EndLocation.getLatitude(), EndLocation.getLongitude());
		
		if (OnlyDirection) return angle;
		
		Bitmap sprite = Icon;
		
		Matrix mat = new Matrix();
		mat.preRotate(angle);///in degree
		Bitmap mBitmap = Bitmap.createBitmap(sprite, 0, 0, sprite.getWidth(), sprite.getHeight(), mat, true);
		return mBitmap;
		
	}
	
	/**
	 * Add marker on map
	 *Set icon for marker with bitmap
	 *Set null for Icon if you use color for marker
	 *Use Constant Color that start with MARKERCOLOR_
	 */
	public Marker AddMarker(final BA b4a,double Latitude,double Longitude,String Title,boolean Draggable,boolean ShowInfoWindow,Bitmap Icon,String Color) {
		
		Marker m1 = Map.addMarker(new MarkerOptions().position(new LatLng(Latitude,Longitude)).title(Title).draggable(Draggable));
		
		if (ShowInfoWindow) m1.showInfoWindow();
		
		if (Icon != null)
			m1.setIcon(BitmapDescriptorFactory.fromBitmap(Icon));
		else
			SetMarkerDefaultIcon(b4a,m1,Color);
		
		return m1;
		
	}
	
	/**
	 * Set icon for marker base of googlemap marker
	 *Use Constant Color that start with MARKERCOLOR_
	 */
	public void SetMarkerDefaultIcon(final BA b4a,Marker Marker,String Color) {
		
		float color;
		String colors = Color.toLowerCase(BA.cul).toString();

		if (colors == "azure") 
				color = BitmapDescriptorFactory.HUE_AZURE;
		else if (colors == "blue")
				color = BitmapDescriptorFactory.HUE_BLUE;
		else if (colors == "cyan")
				color = BitmapDescriptorFactory.HUE_CYAN;
		else if (colors == "green")
				color = BitmapDescriptorFactory.HUE_GREEN;
		else if (colors == "magenta")
				color = BitmapDescriptorFactory.HUE_MAGENTA;
		else if (colors == "orange")
				color = BitmapDescriptorFactory.HUE_ORANGE;
		else if (colors == "red")
				color = BitmapDescriptorFactory.HUE_RED;
		else if (colors == "rose")
				color = BitmapDescriptorFactory.HUE_ROSE;
		else if (colors == "violet")
				color = BitmapDescriptorFactory.HUE_VIOLET;
		else if (colors == "yellow")
				color = BitmapDescriptorFactory.HUE_YELLOW;
		else
				color = BitmapDescriptorFactory.HUE_RED;
		
		Marker.setIcon(BitmapDescriptorFactory.defaultMarker(color));
		
	}
	
	/**
	 * Get snapshot from googlemap
	 *Return bitmap in GetSnapshot subroutine
	 *Example<code>
	 *
	 *Sub Button1_Click
	 *	Dim g As GoogleMapExtra2
	 *	g.Initilize(gmap)
	 *	g.GetSnapshot("Snapshot")
	 *End Sub
	 *
	 *Sub Snapshot_GetSnapshot (Bitmap1 As Object)
	 *	Activity.SetBackgroundImage(Bitmap1)
	 *End Sub</code>
	 */
	public void GetSnapshot(final BA b4a,String Event) {
		
		final String evt = Event.toLowerCase(BA.cul) + "_getsnapshot";
		
		Map.snapshot(new SnapshotReadyCallback() {

			@Override
			public void onSnapshotReady(Bitmap arg0) {
				if (b4a.subExists(evt)) {
	            	b4a.raiseEvent(this,evt,arg0);
	            }
	            else
	            	BA.Log("no exist subroutine");
			}
			
		});
		
	}
	
	/**
	 *Zoom out or in map for show all markers in map
	 *Add all markers position in list Example:
	 *Padding argument is padding of map in show markers
	 *<code>
	 *Dim extra As GoogleMapExtra2
	 *extra.Initilize(googlemap1)
	 *
	 *Dim ls As List
	 *ls.Initialize
	 *ls.Add(StartMarker.Position)
	 *ls.Add(EndMarker.Position)
	 *extra.FitZoomTwoMarker(ls,True,100)
	 *</code>
	 */
	public void ZoomToShowMarkers(ArrayList MarkerLatLng,boolean WithAnimation,int Padding) {
		
		LatLngBounds.Builder builder = new LatLngBounds.Builder();
		
		for (int i = 0 ; i < MarkerLatLng.size() ; i++) {
		    builder.include((LatLng)MarkerLatLng.get(i));
		}
		
		LatLngBounds bounds = builder.build();
		
		CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, Padding);
		
		if (WithAnimation)
			Map.animateCamera(cu);
		else
			Map.moveCamera(cu);
		
	}
	
	/**
	 * Change googemap type
	 * @param Type {Satellite or Terrain or Hybrid or Normal}
	 */
	public void SetMapType(final BA ba,String Type) {
		
		String type = Type.toLowerCase(BA.cul);
		
		if (type == "satellite")
				Map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
		else if (type == "terrain")
				Map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
		else if (type == "hybrid")
				Map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
		else if (type == "road map" || type == "normal")
				Map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		else
				Map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		
	}
	
	/**
	 * Raise event when googlemap's camera changing
	 *Example
	 *<code>
	 *Sub Button1_Click
	 *	Dim g As GoogleMapExtra2
	 *	g.Initilize(gmap)
	 *	g.ListenToChangeCamera("change")
	 *End Sub
	 *
	 *Sub change_ChangeCamera
	 *	log("change camera")
	 *End Sub
	 *</code>
	 */
	public void ListenToChangeCamera(final BA b4a,String Event) {
		
		final String evt = Event.toLowerCase(BA.cul) + "_changecamera";
		Map.setOnCameraChangeListener(new OnCameraChangeListener() {
		    @Override
		    public void onCameraChange(CameraPosition cameraPosition) {
		    	if (b4a.subExists(evt)) {
	            	b4a.raiseEvent(this,evt);
	            }
	            else
	            	BA.Log("no exist subroutine");
		    }
		});
	}
	
	/**
	 * Raise event when user change map camera in end
	 *Example
	 *<code>
	 *Sub Button1_Click
	 *	Dim g As GoogleMapExtra2
	 *	g.Initilize(gmap)
	 *	g.ListenToEndCameraChange("endchange")
	 *End Sub
	 *
	 *Sub endchange_CameraChangeEnd (Latitude As Double,Longitude As Double,Zoom As Float)
	 *	log("end camera change")
	 *End Sub
	 *</code>
	 */
	public void ListenToEndCameraChange(final BA b4a,final String Event) {
		
		final String evt = Event.toLowerCase(BA.cul) + "_camerachangeend";
		
		Map.setOnCameraChangeListener(new GoogleMap.OnCameraChangeListener() {
            @Override
            public void onCameraChange(final CameraPosition position) {
                LatLngBounds bounds = Map.getProjection().getVisibleRegion().latLngBounds;
                ne = bounds.northeast;
                sw = bounds.southwest;
                if(t!=null){
                    t.purge();
                    t.cancel();
                }
                t = new Timer();
                t.schedule(new TimerTask() {
                    public void run() {
                        if(ne1 != ne.latitude && ne2 != ne.longitude && sw1 != sw.latitude && sw2 != sw.longitude){
                            ne1 = ne.latitude;
                            ne2 = ne.longitude;
                            sw1 = sw.latitude;
                            sw2 = sw.longitude;
                            
                            if (b4a.subExists(evt)) {
            	            	b4a.raiseEvent(this,evt,position.target.latitude,position.target.longitude,position.zoom);
            	            }
            	            else
            	            	BA.Log("no exist subroutine " + Event);
                            
                            t.cancel();
                        }
                        else{
                        ne1 = ne.latitude;
                        ne2 = ne.longitude;
                        sw1 = sw.latitude;
                        sw2 = sw.longitude;}
                        t.cancel(); // also just top the timer thread, otherwise, you may receive a crash report
                    }
                }, 400);
            }
        });
	}
	
    /**
     * return location setting intent
     *Example:
     *<code>StartActivity(ShowLocationSettings)</code>
     */
    public Intent ShowLocationSettings() {
        Intent viewIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        return viewIntent;
    }
    
    /**
     * Check location is enable
     *If disble so return false
     */
    public boolean CheckLocationState(final BA ba)
    {
        final LocationManager manager = (LocationManager) ba.context.getSystemService( Context.LOCATION_SERVICE );

        if ( !manager.isProviderEnabled( LocationManager.GPS_PROVIDER ))
            return false;
        else
        	return true;

    }
    
    /**
     *Set googlemap language to persian
     *Note: you have to use this method in main activity
     */
    public void SetPersianLanguage(final BA ba) {
    	Locale locale = new Locale("fa","IRAN");
    	Locale.setDefault(locale);
    	Configuration config = new Configuration();
    	config.locale = locale;
    	ba.context.getResources().updateConfiguration(config,ba.context.getResources().getDisplayMetrics());
    }
    
    /**
     *Set googlemap language to english
     *Note: you have to use this method in main activity
     */
    public void SetEnglishLanguage(final BA ba) {
    	Locale locale = new Locale("en");
    	Locale.setDefault(locale);
    	Configuration config = new Configuration();
    	config.locale = locale;
    	ba.context.getResources().updateConfiguration(config,ba.context.getResources().getDisplayMetrics());
    }
    
    /**
     * Move marker from current location to new location with animation
     *ToLocation argument is new location for move
     *Duration is according to millsecond
     *After end of animation,calling event that you enter it in EndEnimationEvent argument
     */
    public void AnimateMarker(final BA b4a,final Location AnimateTo,final Marker Marker,final int Duration,final String EndEnimationEvent) {

    	final long duration = Duration;
    	final Handler handler = new Handler();
    	final long start = SystemClock.uptimeMillis();
    	final Projection proj = Map.getProjection();
    	final LatLng target = new LatLng(AnimateTo.getLatitude(), AnimateTo.getLongitude());
    	final String evt = EndEnimationEvent.toLowerCase(BA.cul) + "_endanimationmarker";
    			
    	Point startPoint = proj.toScreenLocation(Marker.getPosition());
    	final LatLng startLatLng = proj.fromScreenLocation(startPoint);

    	final Interpolator interpolator = new LinearInterpolator();
    	handler.post(new Runnable() {
    	    @Override
    	    public void run() {
    	        long elapsed = SystemClock.uptimeMillis() - start;
    	        if (elapsed > duration) {
    	            elapsed = duration;
    	        }
    	        float t = interpolator.getInterpolation((float) elapsed / duration);
    	        double lng = t * target.longitude + (1 - t) * startLatLng.longitude;
    	        double lat = t * target.latitude + (1 - t) * startLatLng.latitude;
    	        Marker.setPosition(new LatLng(lat, lng));
    	        if (t < 1.0) {
    	            // Post again 10ms later.
    	            handler.postDelayed(this, 10);
    	        } else {
    	            if (b4a.subExists(evt)) {
    	            	b4a.raiseEvent(this,evt,Marker);
    	            }
    	            else
    	            	BA.Log("no exist subrotine");
    	        }
    	    }
    	});
    	
    }
    
	/**
     * Get only route points between two location
     *Index is route number in routes list (example maybe exist two route for locations so you have to use 0 or 1 position
     *
     *Mode is type of direction
     **Set empty if not use it
     *Mode list: driving,walking,bicycling,transit
     *
     *Avoid is restrict direction type
     **Set empty if not use it
     *Avoid list: highways,tolls,ferries
     *
     *Return Type is List
     */
	public List<LatLng> GetRoutes(Location From,Location To,int Index,String Mode,String Avoid) {
		
		double SourceLat = From.getLatitude();
		double SourceLog = From.getLongitude();
		double DestLat   = To.getLatitude();
		double DestLog   = To.getLongitude();
		
		String url = makeURL(SourceLat,SourceLog,DestLat,DestLog);
		if (Mode.length() > 0) url = url + "&mode=" + Mode;
		if (Avoid.length() > 0) url = url + "&avoid=" + Avoid;
		
		JSONParser jParser = new JSONParser();
		String json = jParser.getJSONFromUrl(url);
		return drawPath(json,true,Index);
		
	}
	
	/**
     * Get route count(position) exist in google map
     *Mode is type of direction
     **Set empty if not use it
     *Mode list: driving,walking,bicycling,transit
     *
     *Avoid is restrict direction type
     **Set empty if not use it
     *Avoid list: highways,tolls,ferries
     *
     *Return Type is int
     */
	public int GetRoutesCount(Location From,Location To,String Mode,String Avoid) {
		
		double SourceLat = From.getLatitude();
		double SourceLog = From.getLongitude();
		double DestLat   = To.getLatitude();
		double DestLog   = To.getLongitude();
		
		String url = makeURL(SourceLat,SourceLog,DestLat,DestLog);
		if (Mode.length() > 0) url = url + "&mode=" + Mode;
		if (Avoid.length() > 0) url = url + "&avoid=" + Avoid;
		
		JSONParser jParser = new JSONParser();
		String json2 = jParser.getJSONFromUrl(url);
		

	    try {
	           final JSONObject json = new JSONObject(json2);
	           JSONArray routeArray = json.getJSONArray("routes");
	           return routeArray.length();

	    } 
	    catch (JSONException e) {
	    	return 0;
	    }
		
	}
	
	/**
     * Get only route points between two location
     *Only Server and Browser api keys are currently supported
     *Return Type is List
     *<code>
     *Dim res As String
     *Dim extra As GoogleMapExtra2
     *
     *extra.Initialize(Null)
     *res = extra.GetPlaceDetails(placeID.Get(index1),"AIza_")
     *
     *Dim js As JSONParser
	 *js.Initialize(res)
	 *
	 *Dim data,desc,geom,loc2 As Map
				
	 *data = js.NextObject
	 *desc = data.Get("result")
	 *geom = desc.Get("geometry")
	 *loc2 = geom.Get("location")
	 *
	 *Log(loc2.Get("lat"))  'Get latitude
	 *Log(loc2.Get("lng"))  'Get Longitude
	 *Log(desc.Get("name")) 'Get Place name
     *</code>
	 * @throws JSONException 
     */
	public Object GetPlaceDetails(String PlaceID,String ApiKey) throws JSONException {
		
		String url			= "https://maps.googleapis.com/maps/api/place/details/json?placeid=" + PlaceID + "&key=" + ApiKey + "&language=fa";
		JSONParser jParser	= new JSONParser();
		String json1		= jParser.getJSONFromUrl(url);
		
		JSONObject jsonObject		= new JSONObject(json1);
        
	    return jsonObject;
	    
	}
	
	/**
	 * Add place on googlemap service
	 * DataJson is json data with below format
	 * {
	 *   "location": {"lat": -33.8669710,"lng": 151.1958750},
	 *   "accuracy": 50,"name": "Iranapp.org",
	 *   "phone_number": "(0912) 495 2735","address": "Iranapp.org site خخخخخ","types": ["shoe_store"],
	 *    "website": "https://www.iranapp.org","language": "fa-IR"
	 *}
	 *    
	 *Method return json object
	 */
	public Object AddPlaceInGoogleMap(String DataJson,String ApiKey) throws JSONException {
		
		String url			= "https://maps.googleapis.com/maps/api/place/add/json?key=" + ApiKey + "&language=fa";
		JSONParser jParser	= new JSONParser();
		String json1		= jParser.getJSONFromUrl(url);
		
		JSONObject jsonObject		= new JSONObject(json1);
        
	    return jsonObject;
	    
	}
	
	/**
	 * Get location time zone
	 *Method return map object example below
	 *{
	 *  "dstOffset" : 3600,
	 *  "rawOffset" : -18000,
	 *  "status" : "OK",
	 *  "timeZoneId" : "America/New_York",
	 *  "timeZoneName" : "Eastern Daylight Time"
	 *}
	 */
	public Object GetTimeZoneLocation(Location Location1,String ApiKey) throws JSONException {
		
		Long tsLong = System.currentTimeMillis()/1000;
		String ts = tsLong.toString();
		
		String url			= "https://maps.googleapis.com/maps/api/timezone/json?location=" + Location1.getLatitude() + "," + Location1.getLongitude() + "&timestamp=" +  ts + "&key=" + ApiKey + "&language=fa";
		JSONParser jParser	= new JSONParser();
		String json1		= jParser.getJSONFromUrl(url);
		
		JSONObject jsonObject		= new JSONObject(json1);
        
	    return jsonObject;
	    
	}
	
	/**
     * Get all route's step
     *Index is route number in routes list (example maybe exist two route for locations so you have to use 0 or 1 position
     
     *Mode is type of direction
     **Set empty if not use it
     *Mode list: driving,walking,bicycling,transit
     *
     *Avoid is restrict direction type
     **Set empty if not use it
     *Avoid list: highways,tolls,ferries
     *
     *Return Type is List
     *Each row of list is Map data
     *
     *Example
     *<code>
     *Dim g As GoogleMapExtra2
     *g.Initilize(Null)
     *
     *Dim l1,l2 As Location
     *l1.Initialize2(35.3427674,50.2891123)
     *l2.Initialize2(35.0514153,49.0747723)
     *
     *Dim steps As List
     *steps = g.GetRouteSteps(l1,l2)
     *
     *For i = 0 To steps.Size - 1
     *
     *  Dim d As JSONParser
     *  d.Initialize(steps.Get(i))
     *
     *  Dim m As Map
     *  m = d.NextObject
     *  Log(m.Get("html_instructions"))
     *
     *Next</code>
	 * @throws JSONException 
     */
	public ArrayList<Object> GetRouteSteps(Location From,Location To,int Index,String Mode,String Avoid) throws JSONException {
		
		double SourceLat = From.getLatitude();
		double SourceLog = From.getLongitude();
		double DestLat   = To.getLatitude();
		double DestLog   = To.getLongitude();
		
		String url = makeURL(SourceLat,SourceLog,DestLat,DestLog);
		if (Mode.length() > 0) url = url + "&mode=" + Mode;
		if (Avoid.length() > 0) url = url + "&avoid=" + Avoid;
		
		JSONParser jParser = new JSONParser();
		String json1 = jParser.getJSONFromUrl(url);
		
		JSONObject json = new JSONObject(json1);
        JSONArray routeArray = json.getJSONArray("routes");
        JSONObject routes = routeArray.getJSONObject(Index);
        JSONArray legs = routes.getJSONArray("legs");
        JSONObject steps = (JSONObject) legs.get(0);
        JSONArray data = steps.getJSONArray("steps");
        
        ArrayList<Object> arr = new ArrayList<Object>();
        
        for (int i = 0 ; i < data.length() ; i++) {
        	arr.add(data.get(i));
        }
        
        return arr;
        
	}
	
	/**
	 *Get all step instruction between two location
     *Index is route number in routes list (example maybe exist two route for locations so you have to use 0 or 1 position
     
     *Mode is type of direction
     **Set empty if not use it
     *Mode list: driving,walking,bicycling,transit
     *
     *Avoid is restrict direction type
     **Set empty if not use it
     *Avoid list: highways,tolls,ferries

	 *
	 *for remove html tag from string use below function
	 *<code>
	 *Sub RemoveTags(Text As String) As String
	 *  Dim Pattern, Replacement As String
	 *  Dim m As Matcher
	 *  Pattern = "<[^>]*>"
	 *  Replacement = " "
	 *  m = Regex.Matcher2(Pattern, Regex.CASE_INSENSITIVE, Text.Replace("&nbsp;"," "))
	 *  Dim r As Reflector
	 *  r.Target = m
	 *  Return r.RunMethod2("replaceAll", Replacement, "java.lang.String")
	 *End Sub
	 *</code>
	 */
	public ArrayList<Object> GetRouteStepsInstruction(Location From,Location To,int Index,String Mode,String Avoid,boolean IsHtml) throws JSONException {
		
		double SourceLat = From.getLatitude();
		double SourceLog = From.getLongitude();
		double DestLat   = To.getLatitude();
		double DestLog   = To.getLongitude();
		
		String url = makeURL(SourceLat,SourceLog,DestLat,DestLog);
		if (Mode.length() > 0) url = url + "&mode=" + Mode;
		if (Avoid.length() > 0) url = url + "&avoid=" + Avoid;
		
		JSONParser jParser = new JSONParser();
		String json1 = jParser.getJSONFromUrl(url);
		
		JSONObject json = new JSONObject(json1);
        JSONArray routeArray = json.getJSONArray("routes");
        JSONObject routes = routeArray.getJSONObject(Index);
        JSONArray legs = routes.getJSONArray("legs");
        JSONObject steps = (JSONObject) legs.get(0);
        JSONArray data = steps.getJSONArray("steps");
        
        ArrayList<Object> arr = new ArrayList<Object>();
        
        for (int i = 0 ; i < data.length() ; i++) {
        	JSONObject ks = (JSONObject) data.get(i);
        	if (IsHtml)
        		arr.add(ks.get("html_instructions"));
        	else
        		arr.add(stripHtml(ks.get("html_instructions").toString()));
        }
        
        return arr;
        
	}
	
	/**
     * Search place in google map and return details
     *Only Server and Browser api keys are currently supported
     *Radius argument is meter unit,get result that exist in radius zone
     *Return Type is list
     *<code>
     *Dim ls As List
     *Dim extra As GoogleMapExtra2
     *
     *extra.Initialize(Null)
     *ls = extra.SearchPlace(inp.Input,"AIza_")
	 *			
     *	For i = 0 To ls.Size - 1
	 *			
     *		Dim js As JSONParser
     *		js.Initialize(ls.Get(i))
	 *			
     *		Dim data As Map
     *		data = js.NextObject
	 *			
     *		Log(data.Get("place_id"))
     *		Log(data.Get("description"))
	 *				
     *	Next
     *</code>
	 * @throws JSONException 
    */
	public ArrayList<Object> SearchPlace(String Place,String ApiKey) throws JSONException {
		
		String url			= "https://maps.googleapis.com/maps/api/place/autocomplete/json?sensor=false&input=" + Place + "&types=geocode&key=" + ApiKey + "&language=fa";
		
		JSONParser jParser	= new JSONParser();
		String json1		= jParser.getJSONFromUrl(url);
		
		JSONObject json		= new JSONObject(json1);
        JSONArray routeArray = json.getJSONArray("predictions");
        
        ArrayList<Object> arr = new ArrayList<Object>();
        
        for (int i = 0 ; i < routeArray.length() ; i++) {
        	arr.add(routeArray.get(i));
        }
        
        return arr;
        
	}
	
	/**
     * Get distance between two location
     *Index is route number in routes list (example maybe exist two route for locations so you have to use 0 or 1 position
     *Mode is type of direction
     **Set empty if not use it
     *Mode list: driving,walking,bicycling,transit
     *
     *Avoid is restrict direction type
     **Set empty if not use it
     *Avoid list: highways,tolls,ferries
     *
     *Return Type is string
	 * @throws JSONException 
    */
	public String GetRoutesDistance(Location From,Location To,int Index,String Mode,String Avoid) throws JSONException {
		
		double SourceLat = From.getLatitude();
		double SourceLog = From.getLongitude();
		double DestLat   = To.getLatitude();
		double DestLog   = To.getLongitude();
		
		String url = makeURL(SourceLat,SourceLog,DestLat,DestLog);
		if (Mode.length() > 0) url = url + "&mode=" + Mode;
		if (Avoid.length() > 0) url = url + "&avoid=" + Avoid;
		
		JSONParser jParser = new JSONParser();
		String json1 = jParser.getJSONFromUrl(url);
		
		JSONObject json = new JSONObject(json1);
        JSONArray routeArray = json.getJSONArray("routes");
        JSONObject routes = routeArray.getJSONObject(Index);
        JSONArray legs = routes.getJSONArray("legs");
        JSONObject data = legs.getJSONObject(0);
        JSONObject data1 = data.getJSONObject("distance");
        
        return data1.getString("text");
		
	}
	
	/**
     * Get duration route between two location
     *Index is route number in routes list (example maybe exist two route for locations so you have to use 0 or 1 position
     *Mode is type of direction
     **Set empty if not use it
     *Mode list: driving,walking,bicycling,transit
     *
     *Avoid is restrict direction type
     **Set empty if not use it
     *Avoid list: highways,tolls,ferries
     *
     *Return Type is string
	 * @throws JSONException 
    */
	public String GetRoutesDuration(Location From,Location To,int Index,String Mode,String Avoid) throws JSONException {
		
		double SourceLat = From.getLatitude();
		double SourceLog = From.getLongitude();
		double DestLat   = To.getLatitude();
		double DestLog   = To.getLongitude();
		
		String url = makeURL(SourceLat,SourceLog,DestLat,DestLog);
		if (Mode.length() > 0) url = url + "&mode=" + Mode;
		if (Avoid.length() > 0) url = url + "&avoid=" + Avoid;
		
		JSONParser jParser = new JSONParser();
		String json1 = jParser.getJSONFromUrl(url);
		
		JSONObject json = new JSONObject(json1);
        JSONArray routeArray = json.getJSONArray("routes");
        JSONObject routes = routeArray.getJSONObject(Index);
        JSONArray legs = routes.getJSONArray("legs");
        JSONObject data = legs.getJSONObject(0);
        JSONObject data1 = data.getJSONObject("duration");
        
        return data1.getString("text");
		
	}
	
	/**
     * Draw route points on googlemap view
     *Index is route number in routes list (example maybe exist two route for locations so you have to use 0 or 1 position
     *You can change line color or with
     *Index is route position
     *
     *Mode is type of direction
     **Set empty if not use it
     *Mode list: driving,walking,bicycling,transit
     *
     *Avoid is restrict direction type
     **Set empty if not use it
     *Avoid list: highways,tolls,ferries
     *
     */
	public void DrawRoutes(Location From,Location To,int LineWidth,int LineColor,boolean Geodesic,int Index,String Mode,String Avoid) {
		
		double SourceLat = From.getLatitude();
		double SourceLog = From.getLongitude();
		double DestLat   = To.getLatitude();
		double DestLog   = To.getLongitude();
		
		widthline = LineWidth;
		colorline = LineColor;
		geodesic  = Geodesic;
		
		String url = makeURL(SourceLat,SourceLog,DestLat,DestLog);
		if (Mode.length() > 0) url = url + "&mode=" + Mode;
		if (Avoid.length() > 0) url = url + "&avoid=" + Avoid;
		
		//BA.Log(url);
		
		JSONParser jParser = new JSONParser();
		String json = jParser.getJSONFromUrl(url);
		drawPath(json,false,Index);
		
	}
	
	/**
     * Get information from location
     *Return type is map
     *If you send true to FullAddress argument,function return full address string
     *And if FullAddress argument is false,so it return map type
	 * @throws JSONException 
	 * @throws UnsupportedEncodingException 
     */
	public Object GetLocationInformation(double Latitude,double Longitude,boolean FullAddress) throws JSONException, UnsupportedEncodingException {

	    HttpGet httpGet = new HttpGet("https://maps.google.com/maps/api/geocode/json?latlng=" + Latitude +"," + Longitude +"&sensor=False&language=fa");
	    HttpClient client = new DefaultHttpClient();
	    HttpResponse response;
	    StringBuilder stringBuilder = new StringBuilder();

	    try {
	        response = client.execute(httpGet);
	        HttpEntity entity = response.getEntity();
	        InputStream stream = entity.getContent();
	        int b;
	        while ((b = stream.read()) != -1) {
	            stringBuilder.append((char) b);
	        }
	    } catch (ClientProtocolException e) {
	    } catch (IOException e) {
	    }

	    JSONObject jsonObject = new JSONObject();
	    try {
	        jsonObject = new JSONObject(new String(stringBuilder.toString().getBytes("ISO-8859-1"), "UTF-8"));
	    } catch (JSONException e) {
	        e.printStackTrace();
	    }
	    
	    JSONArray results = jsonObject.getJSONArray("results");
	    JSONObject js = (JSONObject) results.get(0);
	    
	    if (FullAddress == true)
	    	return js.get("formatted_address");
	    else
	    	return jsonObject;
	    
	}
	
	/**
     * Get any places nearby to location
     *Only Server and Browser api keys are currently supported
     *Return type is list
     *PlaceType example : hotel or food or resturant,Complete list in www.iranapp.org/asset/upload/placetype.txt
     *<code>
     *Dim ls As List
     *Dim extra As GoogleMapExtra2
     *
     *extra.Initialize(Null)
     *ls = extra.GetNearbyPlace(43.232323,54.123123123,"hotel","AIz_")
     *
     *For i = 0 To ls.Size - 1
	 *
     *	Dim js As JSONParser
     *	js.Initialize(ls.Get(i))
	 *
     *	Dim data,geo,loc1 As Map
     *	Dim icon As String
     *	data = js.NextObject
	 *
     *	geo = data.Get("geometry")
     *	loc1 = geo.Get("location")
     *
     *	Log(data.Get("icon"))
     *	Log(data.Get("name"))
     *	Log(loc1.Get("lat"))
     *	Log(loc1.Get("lng"))
     *
     *Next
     *</code>
	 * @throws JSONException 
	 * @throws UnsupportedEncodingException 
     */
	public ArrayList<Object> GetNearbyPlace(double Latitude,double Longitude,String PlaceType,String Radius,String ApiKey) throws JSONException, UnsupportedEncodingException {
		
		if (Radius == "") Radius = "0";
		
	    HttpGet httpGet = new HttpGet("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=" + Latitude +"," + Longitude +"&radius=" + Radius + "&type=" + PlaceType + "&language=fa&key=" + ApiKey);
	    HttpClient client = new DefaultHttpClient();
	    HttpResponse response;
	    StringBuilder stringBuilder = new StringBuilder();

	    try {
	        response = client.execute(httpGet);
	        HttpEntity entity = response.getEntity();
	        InputStream stream = entity.getContent();
	        int b;
	        while ((b = stream.read()) != -1) {
	            stringBuilder.append((char) b);
	        }
	    } catch (ClientProtocolException e) {
	    } catch (IOException e) {
	    }

	    JSONObject jsonObject = new JSONObject();
	    try {
	        jsonObject = new JSONObject(new String(stringBuilder.toString().getBytes("ISO-8859-1"), "UTF-8"));
	    } catch (JSONException e) {
	        e.printStackTrace();
	    }
	    
	    JSONArray results = jsonObject.getJSONArray("results");
	    
	    ArrayList<Object> arr = new ArrayList<Object>();
        
        for (int i = 0 ; i < results.length() ; i++) {
        	arr.add(results.get(i));
        }
        
	    return arr;
	    
	}
	
	/**
	 * Get center location of map area
	 */
	public LatLng GetMapCenterLocation() {
		
		return Map.getCameraPosition().target;
	}
	
	/**
	 * Create datatype Location and return it
	 */
	public Location GetNewLocationType(double Latitude,double Longitude) {
		
		Location loc = new Location("");
		loc.setLatitude(Latitude);
		loc.setLongitude(Longitude);
		return loc;
		
	}
	
	/**
	 * Create datatype LatLng and return it
	 */
	public LatLng GetNewLatLngType(double Latitude,double Longitude) {
		
		LatLng l1 = new LatLng(Latitude, Longitude);
		return l1;
		
	}
	
	/**
	 * Get center of two location in googemap
	 */
	public Location GetLocationsMiddle(Location From,Location To){

		double lat1,lon1,lat2,lon2;
		lat1 = From.getLatitude();
		lat2 = To.getLatitude();
		
		lon1 = From.getLongitude();
		lon2 = To.getLongitude();
		
	    double dLon = Math.toRadians(lon2 - lon1);


	    lat1 = Math.toRadians(lat1);
	    lat2 = Math.toRadians(lat2);
	    lon1 = Math.toRadians(lon1);

	    double Bx = Math.cos(lat2) * Math.cos(dLon);
	    double By = Math.cos(lat2) * Math.sin(dLon);
	    double lat3 = Math.atan2(Math.sin(lat1) + Math.sin(lat2), Math.sqrt((Math.cos(lat1) + Bx) * (Math.cos(lat1) + Bx) + By * By));
	    double lon3 = lon1 + Math.atan2(By, Math.cos(lat1) + Bx);
	    
	    Location loc = new Location("");
		loc.setLatitude(Math.toDegrees(lat3));
		loc.setLongitude(Math.toDegrees(lon3));
		return loc;

	}
	
	/**
	 * Convert Latitude and Longitude to Universal Transverse Mercator unit (UTM)
	 */
	public String ConvertLatLonToUTM(double Latitude,double Longitude) {
		return convert.LatLon2UTM(Latitude, Longitude);
	}
	
	public String ConvertLatLonToMGRUTM(double Latitude, double Longitude) {
	    return convert.LatLon2MGRUTM(Latitude, Longitude);
	}
	
	public double[] ConvertMGRUTMToLatLon(String MGRUTM) {
	    return convert.MGRUTM2LatLon(MGRUTM);
	}
	
	/**
	 * Convert Universal Transverse Mercator unit (UTM) to Latitude and Longitude 
	 *<code>
	 *Dim res() As Double
	 *Dim extra As GoogleMapExtra2
	 *
	 *extra.Initilaize(Null)
	 *res = extra.ConvertUTMToLatLon("23 P 1231212312321")
	 *Log(res)
	 *</code>
	 */
	public double[] ConvertUTMToLatLon(String UTM) {
	    return convert.UTM2LatLon(UTM);
	  }
	  
	public double ConvertDegreeToRadian(double Degree) {
	    return Degree * Math.PI / 180;
	}

	public double ConvertRadianToDegree(double Radian) {
	    return Radian * 180 / Math.PI;
	}
	
	private List<LatLng> drawPath(String result,boolean getList,int Index) {

	    try {
	           final JSONObject json = new JSONObject(result);
	           JSONArray routeArray = json.getJSONArray("routes");
	           JSONObject routes = routeArray.getJSONObject(Index);
	           JSONObject overviewPolylines = routes.getJSONObject("overview_polyline");
	           String encodedString = overviewPolylines.getString("points");
	           List<LatLng> list = decodePoly(encodedString);
	           
	           if (getList == true)
	        	   return list;
	           else {
	        	   Map.addPolyline(new PolylineOptions()
	                                    .addAll(list)
	                                    .width(widthline)
	                                    .color(colorline)
	                                    .geodesic(geodesic)
	                    );
	           }

	    } 
	    catch (JSONException e) {
	    	return null;
	    }
	    
	    return null;
	    
	}
	
	private String makeURL (double sourcelat, double sourcelog, double destlat, double destlog ){
        StringBuilder urlString = new StringBuilder();
        urlString.append("https://maps.googleapis.com/maps/api/directions/json");
        urlString.append("?origin=");
        urlString.append(Double.toString(sourcelat));
        urlString.append(",");
        urlString
                .append(Double.toString( sourcelog));
        urlString.append("&destination=");
        urlString
                .append(Double.toString( destlat));
        urlString.append(",");
        urlString.append(Double.toString( destlog));
        urlString.append("&sensor=false&alternatives=true&language=fa");

        return urlString.toString();
 }
	private List<LatLng> decodePoly(String encoded) {

	    List<LatLng> poly = new ArrayList<LatLng>();
	    
	    int index = 0, len = encoded.length();
	    int lat = 0, lng = 0;

	    while (index < len) {
	        int b, shift = 0, result = 0;
	        do {
	            b = encoded.charAt(index++) - 63;
	            result |= (b & 0x1f) << shift;
	            shift += 5;
	        } while (b >= 0x20);
	        int dlat = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
	        lat += dlat;

	        shift = 0;
	        result = 0;
	        do {
	            b = encoded.charAt(index++) - 63;
	            result |= (b & 0x1f) << shift;
	            shift += 5;
	        } while (b >= 0x20);
	        int dlng = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
	        lng += dlng;

	        LatLng p = new LatLng( (((double) lat / 1E5)),
	                 (((double) lng / 1E5) ));
	        poly.add(p);
	    }

	    return poly;
	}
	
	static private double initialBearing (double lat1, double long1, double lat2, double long2)
	{
	    return (_bearing(lat1, long1, lat2, long2) + 360.0) % 360;
	}

	static private double finalBearing(double lat1, double long1, double lat2, double long2)
	{
	    return (_bearing(lat2, long2, lat1, long1) + 180.0) % 360;
	}

	static private double _bearing(double lat1, double long1, double lat2, double long2)
	{
	    double degToRad = Math.PI / 180.0;
	    double phi1 = lat1 * degToRad;
	    double phi2 = lat2 * degToRad;
	    double lam1 = long1 * degToRad;
	    double lam2 = long2 * degToRad;

	    return Math.atan2(Math.sin(lam2-lam1)*Math.cos(phi2),
	        Math.cos(phi1)*Math.sin(phi2) - Math.sin(phi1)*Math.cos(phi2)*Math.cos(lam2-lam1)
	    ) * 180/Math.PI;
	}
	
	private String stripHtml(String html) {
		return Html.fromHtml(html).toString();
	}
	
}