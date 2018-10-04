package com.mappala.kenneth.mappalakennethlab4;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        snackbar = Snackbar.make(coordinatorLayout, "Please Wait New Page Open", Snackbar.LENGTH_LONG);
        snackbar.show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(MainActivity.this, YourActivity.class);
                startActivity(intent);
            }
        }, 2000);
    }
}

    private boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onResume() {
        super.onResume();
        // .... other stuff in my onResume ....
        this.doubleBackToExitPressedOnce = false;
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, R.string.exit_press_back_twice_message, Toast.LENGTH_SHORT).show();
    }

    registerActivityLifecycleCallbacks(new MyActivityLifecycleCallbacks());

    private static final class MyActivityLifecycleCallbacks implements ActivityLifecycleCallbacks {

    public void onActivityCreated(Activity activity, Bundle bundle) {
        Log.d("","onActivityCreated:" + activity.getLocalClassName());
    }

    public void onActivityDestroyed(Activity activity) {
        Log.d("","onActivityDestroyed:" + activity.getLocalClassName());
    }

    public void onActivityPaused(Activity activity) {
        Log.d("","onActivityPaused:" + activity.getLocalClassName());
    }

    public void onActivityResumed(Activity activity) {
        Log.d("","onActivityResumed:" + activity.getLocalClassName());
    }

    public void onActivitySaveInstanceState(Activity activity,
                                            Bundle outState) {
        Log.d("","onActivitySaveInstanceState:" + activity.getLocalClassName());
    }

    public void onActivityStarted(Activity activity) {
        Log.d("","onActivityStarted:" + activity.getLocalClassName());
    }

    public void onActivityStopped(Activity activity) {
        Log.d("","onActivityStopped:" + activity.getLocalClassName());
    }
}