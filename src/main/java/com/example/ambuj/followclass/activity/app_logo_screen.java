package com.example.ambuj.followclass.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.ambuj.followclass.classes.PrefManager;
import com.example.ambuj.followclass.R;

public class app_logo_screen extends AppCompatActivity {

    private PrefManager prefManager;
    private Intent intent;
    private Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_logo_screen);

        thread = new Thread(){
            @Override
            public void run() {
                try{
                    sleep(2000);
                    prefManager = new PrefManager(getApplicationContext());
                    if(!prefManager.isFirstTimeLaunch()){
                        intent = new Intent(app_logo_screen.this,login_activity.class);
                    }else{
                        intent = new Intent(app_logo_screen.this,IntroActivity.class);
                    }

                    startActivity(intent);
                    finish();

                }catch (Exception e){
                    Log.e("Error_In_Logo_Screen","error is :",e);
                }
            }
        };
        thread.start();



    }
}
