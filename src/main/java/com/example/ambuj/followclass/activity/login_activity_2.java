package com.example.ambuj.followclass.activity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ambuj.followclass.R;

public class login_activity_2 extends AppCompatActivity {
    String mobile_number;
    String password;

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_2);

        Intent intent = getIntent();
        mobile_number = intent.getStringExtra("login_mobile_number");
        password = intent.getStringExtra("login_password");

        editText = (EditText)findViewById(R.id.login_username_editText);


    }

    public void proceed(View view){

        MyDBHelper myDBHelper = new MyDBHelper(this);
        Log.e("DATABASE_VALL",editText.getText().toString().trim());
        if(myDBHelper.findHandler2(editText.getText().toString().trim(),mobile_number,password)){
            startActivity(new Intent(login_activity_2.this,HomeScreen.class));
            finish();
        }
        else{
            editText.setText(" ");
            Toast.makeText(this,"Invalid Details",Toast.LENGTH_LONG).show();
            startActivity(new Intent(login_activity_2.this,login_activity.class));
            finish();
        }

    }



}