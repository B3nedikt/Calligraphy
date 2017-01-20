package uk.co.chrisjenx.calligraphy3;

import android.view.View;

import io.github.inflationx.viewpump.InflateResult;
import io.github.inflationx.viewpump.Interceptor;

public class CalligraphyInterceptor implements Interceptor {

    private final CalligraphyFactory calligraphyFactory;

    public CalligraphyInterceptor(CalligraphyConfig calligraphyConfig) {
        this.calligraphyFactory = new CalligraphyFactory(calligraphyConfig);
    }

    @Override
    public InflateResult intercept(Chain chain) {
        InflateResult result = chain.proceed(chain.request());
        View viewWithTypeface = calligraphyFactory.onViewCreated(result.view(), result.context(), result.attrs());
        return result.toBuilder().view(viewWithTypeface).build();
    }
}
