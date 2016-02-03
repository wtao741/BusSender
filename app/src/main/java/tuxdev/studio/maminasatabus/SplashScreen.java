package tuxdev.studio.maminasatabus;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by ukietux on 02/02/16.
 */
public class SplashScreen extends AppCompatActivity {
    //waktu splash screen
    private static int splashInterval = 3000;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {

                                      @Override
                                      public void run() {
                                          Intent i = new Intent(SplashScreen.this, LoginActivity.class);
                                          startActivity(i);
                                          SplashScreen.this.finish();
                                      }
                                  },
                splashInterval);
    }
}