package com.example.ambuj.followclass.activity;

import android.app.ActivityOptions;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ambuj.followclass.R;

public class login_activity extends AppCompatActivity {

    private EditText emailText, passwordText;
    private Button login_button;
    private TextView signup_textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);

        emailText = (EditText) findViewById(R.id.input_email);
        passwordText = (EditText) findViewById(R.id.input_password);
        login_button = (Button) findViewById(R.id.btn_login);
        signup_textView = (TextView) findViewById(R.id.link_signup);

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

        String email = emailText.getText().toString().toLowerCase().trim();
        String password = passwordText.getText().toString().trim();

        //Database logic for login code
        Toast.makeText(this, ""+email+""+password, Toast.LENGTH_SHORT).show();


        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onLoginSuccess();
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

        String email = emailText.getText().toString().trim();
        String password = passwordText.getText().toString().trim();

        if(email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
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
}
