-injars 'C:\Program Files\Basic4android\Libraries+\SteeringBehaviors.jar'
-outjars 'C:\Program Files\Basic4android\Libraries+\SteeringBehaviors+.jar'

-libraryjars 'C:\Android\android-sdk\platforms\android-8\android.jar'
-libraryjars 'C:\Program Files\Basic4android\Libraries\B4AShared.jar'
-libraryjars 'C:\Program Files\Basic4android\Libraries\Core.jar'

-target 1.7
-optimizations !code/allocation/variable
-optimizationpasses 3
-allowaccessmodification
-keepattributes Exceptions,InnerClasses,Signature,Deprecated,SourceFile,LineNumberTable,EnclosingMethod,*Annotation*
-keepparameternames
-renamesourcefileattribute SourceFile
-dontpreverify
-dontnote com.android.vending.licensing.ILicensingService
-dontwarn android.support.**


# Preserve all fundamental application classes.
-keep public class * extends android.app.Activity

-keep public class * extends android.app.Application

-keep public class * extends android.app.Service

-keep public class * extends android.content.BroadcastReceiver

-keep public class * extends android.content.ContentProvider

# Preserve all View implementations, their special context constructors, and
# their setters.
-keep public class * extends android.view.View {
    public <init>(android.content.Context);
    public <init>(android.content.Context,android.util.AttributeSet);
    public <init>(android.content.Context,android.util.AttributeSet,int);
    public void set*(...);
}

# Preserve all classes that have special context constructors, and the
# constructors themselves.
-keepclasseswithmembers class * {
    public <init>(android.content.Context,android.util.AttributeSet);
}

# Preserve all classes that have special context constructors, and the
# constructors themselves.
-keepclasseswithmembers class * {
    public <init>(android.content.Context,android.util.AttributeSet,int);
}

# Preserve all possible onClick handlers.
-keepclassmembers class * extends android.content.Context {
    public void *(android.view.View);
    public void *(android.view.MenuItem);
}

# Preserve the special fields of all Parcelable implementations.
-keepclassmembers class * extends android.os.Parcelable {
    static android.os.Parcelable$Creator CREATOR;
}

# Preserve static fields of inner classes of R classes that might be accessed
# through introspection.
-keepclassmembers class **.R$* {
    public static <fields>;
}

# Preserve the required interface from the License Verification Library
# (but don't nag the developer if the library is not used at all).
-keep public interface  com.android.vending.licensing.ILicensingService

# Preserve the special static methods that are required in all enumeration
# classes.
-keepclassmembers,allowoptimization enum  * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

# Keep - Library. Keep all public and protected classes, fields, and methods.
-keep public class * {
    public <fields>;
    public <methods>;
}

# Also keep - Serialization code. Keep all fields and methods that are used for
# serialization.
-keepclassmembers class * extends java.io.Serializable {
    static final long serialVersionUID;
    static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}
