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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_logo_screen);

        try{
            Thread.sleep(2000);
            prefManager = new PrefManager(this);
            if(!prefManager.isFirstTimeLaunch()){
                intent = new Intent(app_logo_screen.this,login_activity.class);
            }else{
                intent = new Intent(app_logo_screen.this,IntroActivity.class);
            }

            startActivity(intent);

        }catch (Exception e){
            Log.e("Error_In_Logo_Screen","error is :",e);
        }

    }
}
