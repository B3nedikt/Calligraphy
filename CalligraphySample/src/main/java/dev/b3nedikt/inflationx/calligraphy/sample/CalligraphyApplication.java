package dev.b3nedikt.inflationx.calligraphy.sample;

import android.app.Application;

import dev.b3nedikt.viewpump.ViewPump;
import dev.b3nedikt.calligraphy.CalligraphyConfig;
import dev.b3nedikt.calligraphy.CalligraphyInterceptor;
import dev.b3nedikt.calligraphy.FontMapper;

/**
 * Created by chris on 06/05/2014.
 * For Calligraphy.
 */
public class CalligraphyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ViewPump.init(new CalligraphyInterceptor(
                        new CalligraphyConfig.Builder()
                                .setDefaultFontPath("fonts/Roboto-ThinItalic.ttf")
                                .setFontAttrId(R.attr.fontPath)
                                .setFontMapper(new FontMapper() {
                                    @Override
                                    public String map(String font) {
                                        return font;
                                    }
                                })
                                .addCustomViewWithSetTypeface(CustomViewWithTypefaceSupport.class)
                                .addCustomStyle(TextField.class, R.attr.textFieldStyle)
                                .build()));
    }
}
