package com.example.ambuj.followclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class PhoneNumberScreen extends AppCompatActivity {

    private EditText editText;
    String mobile_number;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_number_screen);

        editText = (EditText)findViewById(R.id.ph_no);
    }

    public void sendNumber(View view)
    {
        mobile_number = editText.getText().toString().trim();

        if(mobile_number.isEmpty() || mobile_number.length() < 10){
            editText.setError("Enter a valid mobile");
           // editText.requestFocus();
            return;
        }

        Intent intent = new Intent(PhoneNumberScreen.this, VerifyPhoneNumberScreen.class);
        intent.putExtra("mobile", mobile_number);
        startActivity(intent);
    }
}
