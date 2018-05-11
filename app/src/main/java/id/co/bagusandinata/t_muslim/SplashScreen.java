package id.co.bagusandinata.t_muslim;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

public class SplashScreen extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Thread mySplash = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(2000);
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                    finish();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        mySplash.start();
    }
}
