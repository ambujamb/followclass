package com.example.ambuj.followclass.classes;

import android.app.Activity;
import android.content.Context;
import android.transition.Explode;
import android.transition.Slide;
import android.view.Gravity;

import com.example.ambuj.followclass.R;


public class Transition_Class {
    Context _context;


    public Transition_Class(Context context){
        this._context = context;

    }

    public void ExplodeAnimation(){
        Explode explode = new Explode();
        explode.setDuration(_context.getResources().getInteger(R.integer.anim_duration_long));
        ((Activity) _context).getWindow().setEnterTransition(explode);

    }


    public void SlideAnimation(String slideDirection){
        Slide slide = new Slide();
        int dir = 0;
        switch (slideDirection){
            case "top": dir = Gravity.TOP;
                        break;
            case "bottom":dir = Gravity.BOTTOM;
                        break;
            case "left":dir = Gravity.LEFT;
                        break;
            case "right": dir = Gravity.RIGHT;
                        break;

        }
        slide.setSlideEdge(dir);
        slide.setDuration(1000);
        ((Activity) _context).getWindow().setEnterTransition(slide);

    }


}
