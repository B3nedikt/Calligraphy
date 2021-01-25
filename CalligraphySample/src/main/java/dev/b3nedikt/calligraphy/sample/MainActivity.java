package dev.b3nedikt.calligraphy.sample;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.app.ViewPumpAppCompatDelegate;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private AppCompatDelegate appCompatDelegate = null;

    @NonNull
    @Override
    public AppCompatDelegate getDelegate() {
        if (appCompatDelegate == null) {
            appCompatDelegate = new ViewPumpAppCompatDelegate(
                    super.getDelegate(),
                    this
            );
        }
        return appCompatDelegate;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Inject pragmatically
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, PlaceholderFragment.getInstance())
                .commit();


        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
//                toolbar.setTitle("Calligraphy Added");
                toolbar.setSubtitle("Added subtitle");
            }
        }, 1000);

        handler.postDelayed(new Runnable() {
            @Override public void run() {
                toolbar.setTitle(null);
                toolbar.setSubtitle("Added subtitle");
            }
        }, 2000);

        handler.postDelayed(new Runnable() {
            @Override public void run() {
                toolbar.setTitle("Calligraphy added back");
                toolbar.setSubtitle("Added subtitle");
            }
        }, 3000);
    }
}
