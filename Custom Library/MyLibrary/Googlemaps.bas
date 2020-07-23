B4A=true
Group=Libraries
ModulesStructureVersion=1
Type=Class
Version=7.8
@EndOfDesignText@
Private Sub Class_Globals
	Private googlemap2 As GoogleMap
	Private mo As Object
	Private evt As String
End Sub

'Initializes the object. You can add parameters to this method if needed.
Public Sub Initialize(Googlemap As GoogleMap,Module As Object,Event As String)
	If Googlemap <> Null Then	googlemap2	=	Googlemap
	mo			=	Module
	evt			=	Event
End Sub

Public Sub AddListenerCamera
	
	Dim jo As JavaObject
	jo = googlemap2
	
	Try
		
		Dim jo As JavaObject
		jo = googlemap2
		
		Dim e As Object = jo.CreateEvent("com.google.android.gms.maps.GoogleMap.OnCameraMoveStartedListener", "CameraMoveStarted", False)
		jo.RunMethod("setOnCameraMoveStartedListener", Array As Object(e))
		
		Dim e As Object = jo.CreateEvent("com.google.android.gms.maps.GoogleMap.OnCameraIdleListener", "CameraMoveEnd", False)
		jo.RunMethod("setOnCameraIdleListener", Array As Object(e))

	Catch
	End Try
	
End Sub

Sub ChangeMapPosition(Lat As Double,Lon As Double,X As Int,Y As Int)
	
	Dim Projection As Projection
	Dim GoogleMapsExtras1 As GoogleMapsExtras
	Dim Point1 As Point
	Dim LatLng1 As LatLng
       
	LatLng1.Initialize(Lat,Lon)
       
	Projection = GoogleMapsExtras1.GetProjection(googlemap2)
	Point1 = Projection.ToScreenLocation(LatLng1)
	
	Point1.Set(Point1.X + x, Point1.Y +  y)
	LatLng1 = Projection.FromScreenLocation(Point1)
   
	Dim CameraPosition1 As CameraPosition
	CameraPosition1.Initialize(LatLng1.Latitude, LatLng1.Longitude, googlemap2.CameraPosition.Zoom)
	googlemap2.AnimateCamera(CameraPosition1)
	
End Sub

Sub OpenIntent(Latitude As String,Longitude As String)
	Dim MapIntent As Intent
	Dim location As String
	location = "geo:0,0?q=" & Latitude & "," & Longitude
	Try
		MapIntent.Initialize(MapIntent.ACTION_VIEW, location)
		MapIntent.SetComponent("com.navitel")
		StartActivity(MapIntent)
	Catch
	End Try
End Sub

Sub ApplyStyle(Style As String)
	Dim jo As JavaObject = googlemap2
	Dim style2 As JavaObject
	style2.InitializeNewInstance("com.google.android.gms.maps.model.MapStyleOptions", Array(Style))
	jo.RunMethod("setMapStyle", Array(style2))
End Sub

Private Sub CameraMoveStarted_Event (MethodName As String, Args() As Object) As Object
	If SubExists(mo,evt.ToLowerCase & "_cameramovestarted") Then
		CallSubDelayed(mo,evt.ToLowerCase & "_cameramovestarted")
	End If
	Return Null
End Sub

Private Sub CameraMoveEnd_Event(MethodName As String, Args() As Object) As Object
	If SubExists(mo,evt.ToLowerCase & "_cameramoveend") Then
		CallSubDelayed(mo,evt.ToLowerCase & "_cameramoveend")
	End If
End Sub

'Add below to Project Attribute
'#AdditionalJar: com.google.android.gms:play-services-maps
'
''Add below to manifest
''************ Google Play Services Base ************
'AddApplicationText(
'   <activity android:name="com.google.android.gms.common.api.GoogleApiActivity"
'  android:theme="@android:style/Theme.Translucent.NoTitleBar"
'  android:exported="false"/>
'    <meta-data
'  android:name="com.google.android.gms.version"
'  android:value="@integer/google_play_services_version" />
')
''************ Google Play Services Base (end) ************
''************ Googlemap ************
'AddApplicationText(
'<meta-data
'  android:name="com.google.android.geo.API_KEY"
'  android:value="APIKEY"/>
')
''************ Googlemap ************
'
''Add below to file integers.xml in res/values folder
'<?xml version="1.0" encoding="utf-8"?>
'<resources>
'    <integer name="google_play_services_version">9683000</integer>
'</resources>
Sub AddToAPP
	
End Sub

Sub ZoomToMarkerBounds(LatLngs As List,Padding As Int)

	Dim GoogleMapsExtras1 As GoogleMapsExtras
			
	Dim LatLngBoundsBuilder1 As LatLngBoundsBuilder
	LatLngBoundsBuilder1.Initialize

	For i = 0 To LatLngs.Size - 1
		LatLngBoundsBuilder1.Include(LatLngs.Get(i))
	Next

	Dim MarkerBounds As LatLngBounds=LatLngBoundsBuilder1.Build
	GoogleMapsExtras1.AnimateToBounds(googlemap2, MarkerBounds,Padding)

End Sub

Sub GetLocationAddress(Latitude As String,Longitude As String,Language As String) As ResumableSub
	
	Dim ht As HttpJob
	ht.Initialize("location",Me)
	ht.Download("https://maps.google.com/maps/api/geocode/json?latlng=" & Latitude & "," & Longitude & "&sensor=False&language=" & Language)
	Wait For JobDone(Job As HttpJob)
		If Job.Success Then
			Dim data As Map
			Dim js As JSONParser
			js.Initialize(Job.GetString)
			data	=	js.NextObject
			
			Dim ls As List
			ls		=	data.Get("results")
			
			If ls.Size = 0 Then
				Return ""
			End If
			
			data	=	ls.Get(0)
			Return data.Get("formatted_address")
		
		End If

End Sub

Sub ZoomPosition(Lat As Double,Lon As Double,Zoom As Float)
	Dim cp As CameraPosition
	cp.Initialize(Lat,Lon,Zoom)
	googlemap2.AnimateCamera(cp)
End Sub

Sub GetLatLng(Latitude As Double,Longitude As Double) As LatLng
	Dim lt As LatLng
	lt.Initialize(Latitude,Longitude)
	Return lt
End Sub

Sub Distance(sStart As LatLng,sEnd As LatLng) As Double
	
	Dim Start,Finish As Location
	Start.Initialize2(sStart.Latitude,sStart.Longitude)
	Finish.Initialize2(sEnd.Latitude,sEnd.Longitude)
	
	Return Start.DistanceTo(Finish)
	
End Sub

Sub ContainPosition(SE As LatLng,NE As LatLng,YourPoint As LatLng)
	
	Dim NewDelhi As JavaObject
	NewDelhi.InitializeNewInstance("com.google.android.gms.maps.model.LatLngBounds", Array(SE, NE)) 'SE and NE are LatLng objects

	If NewDelhi.RunMethod("contains", Array(YourPoint)) Then
		
	End If
End Sub

Sub GetDirectionLocation(StartLocation As LatLng,EndLocation As LatLng) As Float
	
	Dim angle As Float
	angle	=	finalBearing(StartLocation.Latitude, StartLocation.Longitude, EndLocation.Latitude, EndLocation.Longitude)
	Return angle
	
End Sub

Private Sub finalBearing(lat1 As Double,long1 As Double,lat2 As Double,long2 As Double) As Double
	Return (bearing(lat2, long2, lat1, long1) + 180.0) Mod 360
End Sub

Private Sub bearing(lat1 As Double,long1 As Double,lat2 As Double,long2 As Double) As Double
	
	Dim degToRad,phi1,phi2,lam1,lam2 As Double
	degToRad = cPI / 180.0
    phi1 = lat1 * degToRad
    phi2 = lat2 * degToRad
    lam1 = long1 * degToRad
    lam2 = long2 * degToRad
 
	Return ATan2(Sin(lam2-lam1)*Cos(phi2),Cos(phi1)*Sin(phi2) - Sin(phi1)*Cos(phi2)*Cos(lam2-lam1)) * 180/cPI
		
End Sub

Sub GetAddressFromLocation(Lat As Double,Lon As Double) As String
	
	Dim r As Reflector
	Dim J As JavaObject
	Dim Str As String = _
    J.InitializeContext.RunMethod("getCompleteAddressString", Array(r.GetActivityBA,Lat,Lon))
	Return Str
	
	#if java
	import android.location.Geocoder;
	import java.util.Locale;
	import java.util.List;
	import android.location.Address;
	import java.lang.StringBuilder;
	import java.lang.Exception;
	public String getCompleteAddressString(BA ba,double LATITUDE, double LONGITUDE) {
	    String strAdd = "";
	    Geocoder geocoder = new Geocoder(ba.context, new Locale("en","UK"));
	    try {
	        List<Address> addresses = geocoder.getFromLocation(LATITUDE, LONGITUDE, 1);
	        if (addresses != null) {
	            Address returnedAddress = addresses.get(0);
	            StringBuilder strReturnedAddress = new StringBuilder("");
	            for (int i = 0; i <= returnedAddress.getMaxAddressLineIndex(); i++) {
	                strReturnedAddress.append(returnedAddress.getAddressLine(i)).append("\n");
	            }
	            strAdd = strReturnedAddress.toString();
	        } else {}
	    } catch (Exception e) { }
	    return strAdd;
	}
	#End If

End Sub