package com.example.ambuj.followclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.ambuj.followclass.classes.Constants;
import com.example.ambuj.followclass.classes.Transition_Class;

public class TransitionActivity extends AppCompatActivity {

    Constants.TransitionType type;
    String toolbarTitle;
    Button btnExit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);
        btnExit = (Button) findViewById(R.id.exit_button);

        initPage();

        initAnimation();
    }

    private void initAnimation() {

        switch(type){
            case ExplodeJava:{
                Transition_Class transition_class = new Transition_Class(this);
                transition_class.ExplodeAnimation();
                break;
            }

            case SLideJava:
                Transition_Class transition_class = new Transition_Class(this);
                transition_class.SlideAnimation("up");
                break;
        }
    }

    private void initPage() {

        type = (Constants.TransitionType) getIntent().getSerializableExtra(Constants.KEY_ANIM_TYPE);
        toolbarTitle = getIntent().getExtras().getString(Constants.KEY_TITLE);

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAfterTransition();
            }
        });

        getSupportActionBar().setTitle(toolbarTitle);

    }

    @Override
    public boolean onSupportNavigateUp() {
        finishAfterTransition();
        return true;
    }
}
