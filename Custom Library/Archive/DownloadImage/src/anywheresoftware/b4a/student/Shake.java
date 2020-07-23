package anywheresoftware.b4a.student;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Events;
import anywheresoftware.b4a.BA.ShortName;

@ShortName("Shake")
@Events (values={"OnShake(Direction as Boolean)"})

public class Shake {
	
	private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private ShakeEventListener mShakeDetector;

/**
 *Initialize Shake Class
 */
 public void Initialize(final BA ba)
 {
	 mSensorManager.registerListener(mShakeDetector, mAccelerometer,	SensorManager.SENSOR_DELAY_UI);
 }
 
 /**
  <code>
  *Sub Globals
  * Dim shake1 As Shake
  *End Sub
  *
  *Sub Activity_Create(FirstTime As Boolean)
  * shake1.StartListenShake("StudentShake")
  *End Sub
  *
  *Sub StudentShake_OnShake(Direction As Boolean)
  *If Direction = True Then
  * ToastMessageShow("happen horizontal shake",False)
  *Else
  * ToastMessageShow("happen vertical shake",False)
  *End if
  *End Sub
  *
  *Sub Activity_Resume
  * shake1.Initialize
  *End Sub
  </code>
  */
 public void StartListenerShake(final BA ba,String EventName)
 {
        // ShakeDetector initialization
        mSensorManager = (SensorManager) ba.context.getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager
                .getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mShakeDetector = new ShakeEventListener();
        final String eventName1 = EventName.toLowerCase(BA.cul) + "_onshake";
        mShakeDetector.setOnShakeListener(new ShakeEventListener.OnShakeListener() {
 
            public void onShake(boolean motionDirect) {
            	ba.raiseEvent(this, eventName1,motionDirect);
            }
        });
 }
}
