package com.example.ambuj.followclass.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ambuj.followclass.R;
import com.example.ambuj.followclass.classes.Transition_Class;

public class signup_activity extends AppCompatActivity {

    private EditText username;
    private EditText email_id;
    private EditText password;
    private EditText mobile_number;
    private Spinner role_spinner;
    private Button signup;
    private TextView login_link;

    private String userName,passWord,email_Id,role_Spinner,mobile_Number;

    private String[] role = {"Admin/Principle","Others"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_activity);


        username = (EditText) findViewById(R.id.input_username);
        email_id = (EditText) findViewById(R.id.input_email);
        password = (EditText) findViewById(R.id.input_password);
        mobile_number = (EditText) findViewById(R.id.input_mobileNumber);
        role_spinner = (Spinner) findViewById(R.id.input_roleSpinner);
        signup = (Button) findViewById(R.id.btn_signup);
        login_link = (TextView) findViewById(R.id.link_signup);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,role);
        role_spinner.setAdapter(adapter);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signup();
            }
        });

        initAnimation();


    }

    public void exit(View view){
        startActivity(new Intent(signup_activity.this,login_activity.class));
    }

    private void initAnimation() {
        Transition_Class transition_class = new Transition_Class(this);
        transition_class.SlideAnimation("left");
    }

    private void signup() {
         userName = username.getText().toString().trim();
         email_Id = email_id.getText().toString().trim();
         passWord = password.getText().toString().trim();
         mobile_Number = mobile_number.getText().toString().trim();
         role_Spinner = role_spinner.getSelectedItem().toString();

        if(!checkValidation()){
            onSignUpFailed();
            return;
        }

        signup.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(signup_activity.this,R.style.Base_Theme_AppCompat_Light_Dialog_Alert);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creating Account...");
        progressDialog.show();

        //Database code for signup entry

        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onSignupSuccess();
                progressDialog.dismiss();
            }
        },3000);
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    private void onSignupSuccess() {
        Toast.makeText(this, "Signup success", Toast.LENGTH_SHORT).show();
        signup.setEnabled(true);
        finish();
        startActivity(new Intent(signup_activity.this,login_activity.class));
    }

    private boolean checkValidation() {
        boolean valid = true;
        if(userName.isEmpty()){
            username.setError("Enter Username");
            valid = false;
        }else{
            username.setError(null);
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email_Id).matches()){
            email_id.setError("Enter Valid Email");
            valid = false;
        }else{
            email_id.setError(null);
        }

        if(passWord.isEmpty() || passWord.length() < 6){
            password.setError("Enter Password");
            valid = false;
        }else{
            password.setError(null);
        }

        if(!Patterns.PHONE.matcher(mobile_Number).matches()){
            mobile_number.setError("Enter Correct Mobile Number");
        //    mobileVerification();
            valid = false;
        }else{
            mobile_number.setError(null);
        }


        return valid;
    }

    private void onSignUpFailed() {
        Toast.makeText(this,"Something wrong.",Toast.LENGTH_LONG).show();
        username.setText("");
        email_id.setText("");
        password.setText("");
        mobile_number.setText("");
        role_spinner.setSelection(0);
        signup.setEnabled(true);
    }
}
