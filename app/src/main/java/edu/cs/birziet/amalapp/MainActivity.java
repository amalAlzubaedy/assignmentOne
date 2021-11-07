package edu.cs.birziet.amalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edt_Name,edt_Email;
    Button btnSave;
    SharedPreferences sharedPrefrences ;
    //creat a shared prefrences name and creat ket name
    private static final String SHARED_PREF_NAME="mypref";
    private static final String KEY_NAME="name";
    private static final String KEY_EMAIL="email";






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_Name = findViewById(R.id.edtName);
        edt_Email = findViewById(R.id.edtEmail);
        btnSave= findViewById(R.id.btnSave);

       // SharedPreferences=getSharedPreferences(name:"",MODE_PRIVATE);
        sharedPrefrences= getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        //when open activity first check shared prefrences data available or not
        String name = sharedPrefrences.getString(KEY_NAME,null);
        if(name != null){
            //if data is available so dirictly call on HomeActivity
            Intent intent= new Intent( MainActivity.this,HomeActivity.class);
           startActivity(intent);


        }


        btnSave .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  when click on butt put data on shared prefrances
               SharedPreferences.Editor editor = sharedPrefrences.edit();
                editor.putString(KEY_NAME,edt_Name.getText().toString());
                editor.putString(KEY_EMAIL,edt_Email.getText().toString());
                editor.apply();
               Intent intent = new Intent (MainActivity.this,HomeActivity.class);
                startActivity(intent);

            }
        });



    }
}