B4A=true
Group=Libraries
ModulesStructureVersion=1
Type=Class
Version=7.3
@EndOfDesignText@
Private Sub Class_Globals
	Private phone As Phone
End Sub

'Initializes the object. You can add parameters to this method if needed.
Public Sub Initialize

End Sub

Sub GetMacAddress As String
	
	Dim jo As JavaObject = Me
	Return jo.RunMethod("getWifiMacAddress", Null)
	
	#if JAVA
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;
public static String getWifiMacAddress() {
  try {
  String interfaceName = "wlan0";
  List<NetworkInterface> interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
  for (NetworkInterface intf : interfaces) {
  if (!intf.getName().equalsIgnoreCase(interfaceName)){
  continue;
  }

  byte[] mac = intf.getHardwareAddress();
  if (mac==null){
  return "";
  }

  StringBuilder buf = new StringBuilder();
  for (byte aMac : mac) {
  buf.append(String.format("%02X:", aMac));
  }
  if (buf.length()>0) {
  buf.deleteCharAt(buf.length() - 1);
  }
  return buf.toString();
  }
  } catch (Exception ex) {
     ex.printStackTrace();
  }
  return "";
   }
#end if

End Sub

'get device info omid
Public Sub getDeviceID As String

	Dim id2 As String
	Dim p As Phone
	id2	=	p.GetSettings("android_id")
	Return id2

End Sub

Public Sub getCellularData As String
	Return phone.GetDataState
End Sub

Public Sub getNetworkOperatorName As String
	Return phone.GetNetworkOperatorName
End Sub

Public Sub getNetworkType As String
	Return phone.GetNetworkType
End Sub

Public Sub getPhoneType As String
	Return phone.GetPhoneType
End Sub

Public Sub getSimOperator As String
	Return phone.GetSimOperator
End Sub

Public Sub getAirplaceMode As Boolean
	Return phone.IsAirplaneModeOn
End Sub

Public Sub getRoamingNetwork As Boolean
	Return phone.IsNetworkRoaming
End Sub

Public Sub getManufacture As String
	Return phone.Manufacturer
End Sub

Public Sub getModel As String
	Return phone.Model
End Sub

Public Sub getProduct As String
	Return phone.Product
End Sub

Public Sub getSdkVersion As Int
	Return phone.SdkVersion
End Sub

Public Sub getCurrentLanguage As String
	Dim Obj1 As Reflector
	Dim args(0) As Object
	Dim types(0) As String
	Return Obj1.RunStaticMethod("java.util.Locale", "getDefault", args, types)
End Sub

Public Sub getDisplayInch As Int
	Dim lv As LayoutValues 
    lv = GetDeviceLayoutValues 
    Return Sqrt(Power(lv.Height / lv.Scale / 160, 2) + Power(lv.Width / lv.Scale / 160, 2)) 
End Sub

Public Sub getDensity As Int
	Return Density
End Sub

Public Sub getLocation As ResumableSub
'	
'	Dim loc As LocationManagerEx
'	loc.Initialize("loc")
'	loc.requestMobileLocation
'	Wait for loc_locationchanged(locArg As Location)
'		Return locArg
	
End Sub