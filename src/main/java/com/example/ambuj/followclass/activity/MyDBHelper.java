package com.example.ambuj.followclass.activity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.ambuj.followclass.LoginEntry;
import com.example.ambuj.followclass.SignupEntry;

public class MyDBHelper extends SQLiteOpenHelper {
    Context m_context;


    //database information
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "APPDB.db";
    public static final String TABLE_NAME = "table_login";
    public static final String TABLE_NAME_1 = "table_principal";
    public static final String COLUMN_ID = "LoginID";
    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_MOBILE_NUMBER = "Mobile_Number";
    public static final String COLUMN_PASSWORD = "Password";
    private static final String ROLE = "Principal";

    private static final  String create_table_signup = "CREATE TABLE "+ TABLE_NAME_1+ "( UserID INTEGER PRIMARY KEY AUTOINCREMENT, Principal_Name TEXT, School_Name TEXT, School_Moto TEXT, School_Logo BLOB, Affilated_By TEXT, DOE TEXT, Email_ID TEXT, Mobile_Number TEXT, Password TEXT, Website TEXT, Phone_Number TEXT, State TEXT, District TEXT, City TEXT, Address TEXT, Pin_Code INTEGER)";
    private static final String create_login_table = "CREATE TABLE "+TABLE_NAME+"("+COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+COLUMN_NAME+" TEXT,"+COLUMN_MOBILE_NUMBER+" TEXT,"+COLUMN_PASSWORD+" TEXT, Role TEXT)";

    public MyDBHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        m_context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //method used to create table
        sqLiteDatabase.execSQL(create_table_signup);
        sqLiteDatabase.execSQL(create_login_table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists table_signup");
        sqLiteDatabase.execSQL("drop table if exists "+TABLE_NAME);
    }


    //method to load data from table_login
    public String loadHandler(){
        String result="";
        String query = "SELECT * FROM "+TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);

        while(cursor.moveToNext()){
            int first_column = cursor.getInt(0);
            String second_column = cursor.getString(1);
            String third_column = cursor.getString(2);
            String fourth_column = cursor.getString(3);

            result += String.valueOf(first_column) + " " + second_column + third_column + fourth_column + System.getProperty("line.separator");

        }

        cursor.close();
        db.close();
        return result;

    }


    //method to add record to table_login
    public void addHandler(SignupEntry signupEntry){
        ContentValues contentValues = new ContentValues();
       // Log.e("VALUE",""+candidate.getStudentName()+candidate.getStudentID());
      //  contentValues.put(COLUMN_ID,candidate.getStudentID());
        //contentValues.put(COLUMN_NAME,candidate.getStudentName());

        //HardCoded Value
        contentValues.put(COLUMN_NAME,signupEntry.getPrincipal_name());
        contentValues.put(COLUMN_MOBILE_NUMBER,signupEntry.getMobile_number());
        contentValues.put(COLUMN_PASSWORD,signupEntry.getPassword());
        contentValues.put("ROLE",ROLE);

        ContentValues contentValues1 = new ContentValues();
        contentValues1.put("Principal_Name",signupEntry.getPrincipal_name());
        contentValues1.put("School_Name",signupEntry.getSchool_name());
        contentValues1.put("School_Moto",signupEntry.getSchool_moto());
        contentValues1.put("School_Logo",signupEntry.getSchool_logo());
        contentValues1.put("Affilated_By",signupEntry.getAffilated_by());
        contentValues1.put("DOE",signupEntry.getDoe());
        contentValues1.put("Email_ID",signupEntry.getEmail_id());
        contentValues1.put("Mobile_Number",signupEntry.getMobile_number());
        contentValues1.put("Password",signupEntry.getPassword());
        contentValues1.put("State",signupEntry.getState());
        contentValues1.put("District",signupEntry.getDistrict());
        contentValues1.put("City",signupEntry.getCity());
        contentValues1.put("Address",signupEntry.getAddress());
        contentValues1.put("Pin_Code",signupEntry.getPin_code());


        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME,null,contentValues);
        db.insert(TABLE_NAME_1,null,contentValues1);
        db.close();
    }

    //method to find record from table_login
    public boolean findHandler(String mobile_number,String password){
        boolean login_status = true;
        String count_query = "SELECT COUNT(*) FROM " + TABLE_NAME + " WHERE "+ COLUMN_MOBILE_NUMBER + "=" + "'" + mobile_number + "'";
        String query = "SELECT * FROM "+TABLE_NAME+" WHERE "+ COLUMN_MOBILE_NUMBER + "=" + "'" + mobile_number + "'";
       // Log.e("DATABASE_VALUE",query);
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(query,null);
        Cursor cursor1 = sqLiteDatabase.rawQuery(count_query,null);
        cursor1.moveToFirst();
        int row_count = cursor1.getInt(0);
        Log.e("DATABASE_VALUE", String.valueOf(row_count));
        Log.e("DATABASE_VAL", String.valueOf(m_context));
        if(row_count == 0){
            login_status = false;
        }else{
                //m_context.startActivity();
            if(row_count > 1){
                Intent intent = new Intent(m_context,login_activity_2.class);
                intent.putExtra("login_mobile_number",mobile_number);
                intent.putExtra("login_password",password);
                m_context.startActivity(intent);
            }else{
                if(cursor.moveToFirst()){
                    if(cursor.getString(3).equals(password)){
                        m_context.startActivity(new Intent(m_context,HomeScreen.class));
                        //login_status = true;
                    }
                    else{
                        m_context.startActivity(new Intent(m_context,login_activity.class));
                        //login_status = false;
                    }
                }

            }


            }

        cursor.close();
        sqLiteDatabase.close();
        return login_status;

    }

//method for finding multiple record
    public boolean findHandler2(String login_username,String mobile_number,String password){
        boolean login_status = false;
        String query = "SELECT * FROM "+TABLE_NAME+" WHERE "+ COLUMN_MOBILE_NUMBER + "=" + "'" + mobile_number + "'";
        //Log.e("DATABASE_VALUE",query);
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(query,null);
        //Log.e("DATABASE_VALUE", String.valueOf(cursor.moveToNext()));
//        Log.e("DATABASE_VALUE",cursor.getString(3));
     //   Log.e("DATABASE_VALUE",cursor.getString(1));


            while(cursor.moveToNext()){
                Log.e("DATABASE_VALUE",cursor.getString(3));
                 Log.e("DATABASE_VALUE",cursor.getString(1));
                if(cursor.getString(3).equals(password) && cursor.getString(1).equals(login_username)){
                    login_status = true;
                    break;
                }
                else{
                    login_status = false;

                }
            }


        cursor.close();
        sqLiteDatabase.close();
        return login_status;

    }





}
