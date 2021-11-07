package edu.cs.birziet.amalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;



import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ListView listView = findViewById(R.id.listview);
        List<String> list = new ArrayList();


        list.add("Calculate BMI");
        list.add("Workout");

        list.add("Profile");

        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, list);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (position == 0) {//BMI is clicked
                    startActivity(new Intent(HomeActivity.this,BMI.class));


                } else if (position == 1) {
                   //Bworkout is clicked
                        startActivity(new Intent(HomeActivity.this,workout.class));


                } else if (position == 2) {

                } else if (position == 3) {

                }
            }
        });
    }}