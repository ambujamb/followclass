package com.example.ambuj.followclass;

import android.app.ActivityOptions;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.ambuj.followclass.classes.Constants;

public class Demo_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_);
    }

    public void explodeTransitionByCode(View view){
        ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(this);
        Intent i = new Intent(Demo_Activity.this,TransitionActivity.class);
        i.putExtra(Constants.KEY_ANIM_TYPE,Constants.TransitionType.ExplodeJava);
        i.putExtra(Constants.KEY_TITLE,"Explode By java");
        startActivity(i,activityOptions.toBundle());
    }

    public void slideTransitionByCode(View view){
        ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(this);
        Intent i = new Intent(Demo_Activity.this,TransitionActivity.class);
        i.putExtra(Constants.KEY_ANIM_TYPE,Constants.TransitionType.SLideJava);
        i.putExtra(Constants.KEY_TITLE,"Slide Java");
        startActivity(i,activityOptions.toBundle());

    }
}
