package com.example.ambuj.followclass;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.ambuj.followclass.activity.MyDBHelper;

public class DemoActivity2 extends AppCompatActivity {

    private RelativeLayout relativeLayout;
    private LinearLayout linearLayout,basic_information_1,contact_information_1,address_information_1;
    private TextView textView,basic_information,contact_information,address_information;
    Handler handler = new Handler();
    Runnable r = new Runnable() {
        @Override
        public void run() {
            linearLayout.setVisibility(View.VISIBLE);
            relativeLayout.setVisibility(View.VISIBLE);
        }
    };



    private EditText et_principal_name,et_school_name,et_school_moto,et_affilated_by,et_doe,et_email_id,et_mobile_number,et_password,et_website,et_phone_number,et_state,et_district,et_city,et_address,et_pin_code;
    private ImageView imageview_school_logo;
    private Button upload_school_logo;
    private String et_principal_name_1,et_school_name_1,et_school_moto_1,et_affilated_by_1,et_doe_1,et_email_id_1,et_mobile_number_1,et_password_1,et_website_1,et_phone_number_1,et_state_1,et_district_1,et_city_1,et_address_1;
    private int et_pin_code_1;
    private byte[] imageview_school_logo_1;
    private Uri selectedImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo2);

        linearLayout = (LinearLayout)findViewById(R.id.hello_linear);
        relativeLayout = (RelativeLayout)findViewById(R.id.demo_rel_1);
        textView = (TextView)findViewById(R.id.demo_textview_1);
        basic_information = (TextView)findViewById(R.id.basic_information);
        contact_information = (TextView)findViewById(R.id.contact_information);
        address_information = (TextView)findViewById(R.id.address_information);
        basic_information_1 = (LinearLayout) findViewById(R.id.basic_information_1);
        contact_information_1 = (LinearLayout) findViewById(R.id.contact_information_1);
        address_information_1 = (LinearLayout) findViewById(R.id.address_information_1);

        handler.postDelayed(r,3000);

        Animation fade_animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        textView.startAnimation(fade_animation);
        Animation animation_1 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move_right);
        basic_information.startAnimation(animation_1);
        Animation animation_2 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move_left);
        contact_information.startAnimation(animation_2);
        Animation animation_3 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move_right);
        address_information.startAnimation(animation_3);

        //all widgets id's
        et_address = (EditText)findViewById(R.id.address_signup);
        et_affilated_by = (EditText)findViewById(R.id.affilated_by_signup);
        et_city = (EditText)findViewById(R.id.city_signup);
        et_district = (EditText)findViewById(R.id.district_signup);
        et_doe = (EditText)findViewById(R.id.doe_signup);
        et_email_id = (EditText)findViewById(R.id.email_id_signup);
        et_mobile_number = (EditText)findViewById(R.id.mobile_number_signup);
        et_password = (EditText)findViewById(R.id.password_signup);
        et_phone_number = (EditText)findViewById(R.id.phone_number_signup);
        et_pin_code = (EditText)findViewById(R.id.pincode_signup);
        et_principal_name = (EditText)findViewById(R.id.principal_name_signup);
        et_school_moto = (EditText)findViewById(R.id.school_moto_signup);
        et_school_name = (EditText)findViewById(R.id.school_name_signup);
        et_state = (EditText)findViewById(R.id.state_signup);
        et_website = (EditText)findViewById(R.id.website_signup);
        imageview_school_logo = (ImageView)findViewById(R.id.school_logo_signup);
        upload_school_logo = (Button)findViewById(R.id.upload_school_logo_signup);

        upload_school_logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1);

            }
        });


        et_address_1 = et_address.toString().trim();
        et_affilated_by_1 = et_affilated_by.toString().toUpperCase().trim();
        et_city_1 = et_city.toString();
        et_district_1 = et_district.toString();
        et_doe_1 = et_doe.toString();
        et_email_id_1 = et_email_id.toString().toLowerCase().trim();
        et_mobile_number_1 =et_mobile_number.toString().trim();
        et_password_1 = et_password.toString();
        et_phone_number_1 = et_phone_number.toString();
        String et_pin_code_2 = et_pin_code.toString();
        et_principal_name_1 = et_principal_name.toString();
        et_school_moto_1 = et_school_moto.toString();
        et_school_name_1 =et_school_name.toString();
        et_state_1 =et_state.toString();
        et_website_1 = et_website.toString();

        SignupEntry signupEntry = new SignupEntry();
        MyDBHelper myDBHelper = new MyDBHelper(this);
        myDBHelper.addHandler(signupEntry);


        basic_information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              if(basic_information_1.getVisibility() == View.GONE){
                  basic_information_1.setVisibility(View.VISIBLE);
              }
              else{
                  basic_information_1.setVisibility(View.GONE);
              }

            }
        });

        contact_information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(contact_information_1.getVisibility() == View.GONE){
                    contact_information_1.setVisibility(View.VISIBLE);
                }
                else{
                    contact_information_1.setVisibility(View.GONE);
                }

            }
        });

        address_information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(address_information_1.getVisibility() == View.GONE){
                    address_information_1.setVisibility(View.VISIBLE);
                }
                else{
                    address_information_1.setVisibility(View.GONE);
                }
            }
        });
    }

    public void onActivityResult(int requestCode,int resultCode,Intent data) {
        if(resultCode == RESULT_OK){
            if(requestCode == 1){
                selectedImageUri = data.getData();
                if(null != selectedImageUri){
                    imageview_school_logo.setImageURI(selectedImageUri);
                }
            }
        }
    }
}
