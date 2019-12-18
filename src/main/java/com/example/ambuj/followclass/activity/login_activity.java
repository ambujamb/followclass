package com.example.ambuj.followclass.activity;

import android.app.ActivityOptions;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ambuj.followclass.R;
import com.example.ambuj.followclass.SignupEntry;

public class login_activity extends AppCompatActivity {

    private Animation animation;

    //Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move_left);

    Handler handler=new Handler();

    Runnable runnable_animation = new Runnable() {
        @Override
        public void run() {
            imageView.startAnimation(animation);
            //relativeLayout.setVisibility(View.VISIBLE);
        }
    };

     Runnable runnable = new Runnable() {
         @Override
         public void run() {
             linearLayout.setVisibility(View.VISIBLE);
             relativeLayout.setVisibility(View.VISIBLE);

         }
     };
    RelativeLayout relativeLayout;
    LinearLayout linearLayout;

    private EditText emailText, passwordText;
    private Button login_button;
    private TextView signup_textView;
    private ImageView imageView;

    MyDBHelper myDBHelper = new MyDBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);

       animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move_up);
       imageView = (ImageView)findViewById(R.id.rel_1_img);
       handler.postDelayed(runnable_animation,1000);



        emailText = (EditText) findViewById(R.id.input_mobile_number);
        passwordText = (EditText) findViewById(R.id.input_password);
        login_button = (Button) findViewById(R.id.btn_login);
        signup_textView = (TextView) findViewById(R.id.link_signup);


        linearLayout = (LinearLayout)findViewById(R.id.rel_2);
        relativeLayout = (RelativeLayout)findViewById(R.id.rel_1);
        handler.postDelayed(runnable,3000);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });


    }

    public void explodeTransitionByCodeLogin(View view){
        ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(this);
        Intent i = new Intent(login_activity.this,signup_activity.class);
        startActivity(i,activityOptions.toBundle());
    }

    private void login() {
        Log.d("LOGIN_STATUS","login");

        if(!checkValidation()){
            onLoginFailed();
            return;
        }

        login_button.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(login_activity.this,R.style.Base_Theme_AppCompat_Light_Dialog_Alert);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
       // progressDialog.setIndeterminateDrawable(getResources().getDrawable(R.drawable.abc_btn_radio_to_on_mtrl_015));
        progressDialog.show();

        final String email = emailText.getText().toString().trim();
        final String password = passwordText.getText().toString().trim();

        //Database logic for login code
        Toast.makeText(this, ""+email+""+password, Toast.LENGTH_SHORT).show();


        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if(myDBHelper.findHandler(email,password)){
                    onLoginSuccess();
                }else{
                    onLoginFailed();
                }
                progressDialog.dismiss();
            }
        },3000);
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    private void onLoginSuccess() {
        Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
        login_button.setEnabled(true);
        //startActivity(new Intent(login_activity.this,HomeScreen.class));
        finish();
    }

    private void onLoginFailed() {
        Toast.makeText(this, "Incorrect Email ID And Password", Toast.LENGTH_SHORT).show();
        emailText.setText("");
        passwordText.setText("");
        login_button.setEnabled(true);
    }

    private boolean checkValidation() {

        boolean valid = true;

        String email = emailText.getText().toString();
        String password = passwordText.getText().toString().trim();

        if(email.isEmpty() || !Patterns.PHONE.matcher(email).matches()){
            emailText.setError("Enter Valid Content");
            valid = false;
        }else{
            emailText.setError(null);
        }


        if(password.isEmpty()){
            passwordText.setError("Enter Password");
            valid =  false;
        }else{
            passwordText.setError(null);
        }

        return valid;
    }


    public void adddata(View view){
        SignupEntry signupEntry = new SignupEntry();
        myDBHelper.addHandler(signupEntry);
        Toast.makeText(this,"Succesfully added data",Toast.LENGTH_LONG).show();
    }

    public void upload_data(View view){

        Toast.makeText(this,""+myDBHelper.loadHandler(),Toast.LENGTH_LONG).show();
    }

    public  void check_krraha_hu(View view){
        startActivity(new Intent(login_activity.this,HomeScreen.class));

    }
}
