package com.views.setting;

import java.lang.reflect.Field;

 
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Layout.Alignment;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.style.ImageSpan;
import android.widget.EditText;
import android.widget.TextView;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BA.Version;

@ShortName("ViewSetting")
@Version(1)

public class ViewsSetting {
	
	public static void setCursorDrawableColor(EditText editText, int color) {
	    try {
	        Field fCursorDrawableRes = TextView.class.getDeclaredField("mCursorDrawableRes");
	        fCursorDrawableRes.setAccessible(true);
	        int mCursorDrawableRes = fCursorDrawableRes.getInt(editText);
	        Field fEditor = TextView.class.getDeclaredField("mEditor");
	        fEditor.setAccessible(true);
	        Object editor = fEditor.get(editText);
	        Class<?> clazz = editor.getClass();
	        Field fCursorDrawable = clazz.getDeclaredField("mCursorDrawable");
	        fCursorDrawable.setAccessible(true);
	        Drawable[] drawables = new Drawable[2];
	        drawables[0] = editText.getContext().getResources().getDrawable(mCursorDrawableRes);
	        drawables[1] = editText.getContext().getResources().getDrawable(mCursorDrawableRes);
	        drawables[0].setColorFilter(color, Mode.SRC_IN);
	        drawables[1].setColorFilter(color, Mode.SRC_IN);
	        fCursorDrawable.set(editor, drawables);
	    } catch (final Throwable ignored) {
	    }
	}
	
	public int MeasureMultilineTextHeight(TextView TextView, String Text) {
	      StaticLayout sl = new StaticLayout(Text, TextView.getPaint(), 
	            TextView.getLayoutParams().width - TextView.getPaddingLeft() - TextView.getPaddingRight(),
	            Alignment.ALIGN_NORMAL, 1, 0 , true);
	      return sl.getLineTop(sl.getLineCount());
	   }
	 
	 public void InsertImageIntoEditText2(Bitmap Bitmap,EditText editText,int PositionCursor,String ImageKey) {
	        BitmapDrawable drawable = new BitmapDrawable(BA.applicationContext.getResources(), Bitmap); 
	        drawable.setBounds(0,0,drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
	        
	        int selStart = PositionCursor;
	        
	        SpannableStringBuilder builder = new SpannableStringBuilder(editText.getText());
	        ImageSpan is = new ImageSpan(drawable,ImageSpan.ALIGN_BASELINE);
	       
	        builder.setSpan(is, selStart, selStart + ImageKey.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
	        editText.setText(builder);
	    }
	 
	  public Intent SendMessage2Telegram(String massage,String ChooserTitle)
	    {
	        String appName = "org.telegram.messenger";
	        Intent myIntent = new Intent(Intent.ACTION_SEND);
            myIntent.setType("text/plain");
            myIntent.setPackage(appName);
            myIntent.putExtra(Intent.EXTRA_TEXT, massage);//
            Intent.createChooser(myIntent, ChooserTitle);
            return myIntent;
	    }
	 
}
