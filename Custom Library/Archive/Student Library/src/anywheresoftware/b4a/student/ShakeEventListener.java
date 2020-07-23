package anywheresoftware.b4a.student;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
 
public class ShakeEventListener implements SensorEventListener {
    private float mLastX, mLastY, mLastZ;
    private boolean mInitialized;
    private final float NOISE = (float) 8.0;
    private OnShakeListener mListener;
    public void setOnShakeListener(OnShakeListener listener) {
        this.mListener = listener;
    }
 
    public interface OnShakeListener {
        public void onShake(boolean motionDirect);
    }
 
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // ignore
    }
 
    @Override
    public void onSensorChanged(SensorEvent event) {
    	 float x = event.values[0];
         float y = event.values[1];
         float z = event.values[2];
         if (!mInitialized) {
             mLastX = x;
             mLastY = y;
             mLastZ = z;
             mInitialized = true;
         } else {
             float deltaX = Math.abs(mLastX - x);
             float deltaY = Math.abs(mLastY - y);
             float deltaZ = Math.abs(mLastZ - z);
             if (deltaX < NOISE) deltaX = (float)0.0;
             if (deltaY < NOISE) deltaY = (float)0.0;
             if (deltaZ < NOISE) deltaZ = (float)0.0;
             mLastX = x;
             mLastY = y;
             mLastZ = z;
             if (deltaX > deltaY) {
                 mListener.onShake(true);
             } else if (deltaY > deltaX) {
            	 mListener.onShake(false);
             }
         }
    }
}