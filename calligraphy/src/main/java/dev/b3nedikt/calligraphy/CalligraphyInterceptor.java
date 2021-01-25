package dev.b3nedikt.calligraphy;

import android.view.View;

import org.jetbrains.annotations.NotNull;

import dev.b3nedikt.viewpump.InflateResult;
import dev.b3nedikt.viewpump.Interceptor;

public class CalligraphyInterceptor implements Interceptor {

    private final Calligraphy calligraphy;

    public CalligraphyInterceptor(CalligraphyConfig calligraphyConfig) {
        this.calligraphy = new Calligraphy(calligraphyConfig);
    }

    @NotNull
    @Override
    public InflateResult intercept(Chain chain) {
        InflateResult result = chain.proceed(chain.request());

        View viewWithTypeface = calligraphy.onViewCreated(
                result.getView(), result.getContext(), result.getAttrs()
        );

        return new InflateResult(
                viewWithTypeface,
                result.getName(),
                result.getContext(),
                result.getAttrs()
        );
    }
}
