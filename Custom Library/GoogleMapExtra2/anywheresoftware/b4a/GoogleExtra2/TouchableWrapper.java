package anywheresoftware.b4a.GoogleExtra2;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class TouchableWrapper extends FrameLayout {

    public TouchableWrapper(Context context) {
        super(context);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {

        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                  GooglemapExtra.TouchState = true;
                  break;

            case MotionEvent.ACTION_UP:
            	  GooglemapExtra.TouchState = false;
                  break;
        }
        return super.dispatchTouchEvent(event);
    }
}