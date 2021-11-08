package edu.cs.birziet.amalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText mNameEt,mEmailEt;
    CheckBox mRemember;
    Button mbtn;
    SharedPreferences sharedPreferences;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNameEt =findViewById(R.id.edtName);
        mEmailEt=findViewById(R.id.edtEmail);
        mRemember=findViewById(R.id.checkBox);
        mbtn=findViewById(R.id.btnSave);

        sharedPreferences=getSharedPreferences("SHARED_PREF",MODE_PRIVATE);

        mbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mNameEt.getText().toString();
                String email=mEmailEt.getText().toString();
                boolean checked = mRemember.isChecked();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("NAME",name);
                editor.putString("EMAIL",email);
                editor.putBoolean("CHECKBOX",checked);
                editor.apply();
                 Intent intent =new Intent(MainActivity.this,HomeActivity.class);
                 startActivity(intent);
                 finish();
            }
        });






        }







}