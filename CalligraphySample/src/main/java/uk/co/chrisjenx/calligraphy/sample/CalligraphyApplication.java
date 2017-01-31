package uk.co.chrisjenx.calligraphy.sample;

import android.app.Application;

import io.github.inflationx.viewpump.ViewPump;
import uk.co.chrisjenx.calligraphy3.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy3.CalligraphyInterceptor;

/**
 * Created by chris on 06/05/2014.
 * For Calligraphy.
 */
public class CalligraphyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ViewPump.init(ViewPump.builder()
                .addInterceptor(new CalligraphyInterceptor(
                        new CalligraphyConfig.Builder()
                                .setDefaultFontPath("fonts/Roboto-ThinItalic.ttf")
                                .setFontAttrId(R.attr.fontPath)
                                .addCustomViewWithSetTypeface(CustomViewWithTypefaceSupport.class)
                                .addCustomStyle(TextField.class, R.attr.textFieldStyle)
                                .build()))
                .build());
    }
}
