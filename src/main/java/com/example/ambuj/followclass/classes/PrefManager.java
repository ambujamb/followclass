package com.example.ambuj.followclass.classes;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefManager {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context _context;

    int PRIVATE_MODE = 0;


    private static final String FILE_NAME = "Intro_Slider";
    private static final String IS_FIRST_LAUNCH = "IS_FIRST_LAUNCH";

    public PrefManager(Context context){
        this._context = context;

        sharedPreferences = _context.getSharedPreferences(FILE_NAME,PRIVATE_MODE);

        editor = sharedPreferences.edit();
        }

        public void setFirstTimeLaunch(boolean isFirstTimeValue){
        editor.putBoolean(IS_FIRST_LAUNCH,isFirstTimeValue);
        editor.commit();
    }

        public boolean isFirstTimeLaunch(){
        return sharedPreferences.getBoolean(IS_FIRST_LAUNCH,true);
        }





}
