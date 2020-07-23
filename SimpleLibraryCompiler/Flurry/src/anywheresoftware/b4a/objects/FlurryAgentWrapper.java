package anywheresoftware.b4a.objects;

import com.flurry.android.FlurryAgent;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ActivityObject;
import anywheresoftware.b4a.BA.DependsOn;
import anywheresoftware.b4a.BA.Permissions;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BA.Version;

@Version(1.0f)
@Permissions(values={"android.permission.INTERNET"})
@ShortName("FlurryAgent")
@DependsOn(values={"FlurryAgent"})
@ActivityObject
public class FlurryAgentWrapper {
	public void setCaptureUncaughtExceptions(boolean v) {
		FlurryAgent.setCaptureUncaughtExceptions(v);
	}
	public void StartSession(BA ba, String ApiKey) {
		FlurryAgent.onStartSession(ba.context, ApiKey);
	}
	public void EndSession(BA ba) {
		FlurryAgent.onEndSession(ba.context);
	}
	public void LogEvent(String EventId) {
		FlurryAgent.logEvent(EventId);
	}
}
