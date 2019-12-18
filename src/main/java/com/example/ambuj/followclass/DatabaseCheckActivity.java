package com.example.ambuj.followclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ambuj.followclass.activity.MyDBHandler;

public class DatabaseCheckActivity extends AppCompatActivity {

    EditText editText1,editText2;

    Button btn_load,btn_add;
    TextView textView;
    MyDBHandler myDBHandler = new MyDBHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_check);

        editText1 = (EditText)findViewById(R.id.editText_1);
        editText2 = (EditText)findViewById(R.id.editText_2);

        btn_load = (Button)findViewById(R.id.btnload);
        btn_add = (Button)findViewById(R.id.btnadd);

        textView = (TextView)findViewById(R.id.database_textview);



        btn_load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(myDBHandler.loadHandler());
                Toast.makeText(getApplicationContext(),"Loading datta",Toast.LENGTH_LONG).show();
            }
        });
    }


    public void addStudent(View view){
        int student_id = Integer.parseInt(editText1.getText().toString().trim());
        String student_name = editText2.getText().toString().trim();

        LoginEntry loginEntry = new LoginEntry(student_id,student_name);


        myDBHandler.addHandler(loginEntry);
        Toast.makeText(this,"data Added",Toast.LENGTH_LONG).show();


    }

}
