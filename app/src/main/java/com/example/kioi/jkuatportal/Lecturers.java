package com.example.kioi.jkuatportal;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Lecturers extends AppCompatActivity {

    private ListView mListView;
    String [] Lecturers={"Lecturers 1","Lecturers 2","Lecturers 3","Lecturers 4","Lecturers 5"};
     String [] number={"0722","0723","0724","0725","0726"};
     Integer [] pic ={R.drawable.account,R.drawable.account,R.drawable.account,R.drawable.account,R.drawable.account};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturers);
        mListView = (ListView) findViewById(R.id.listLecturers);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //ArrayList<String> Lecturers = new ArrayList<String>();
        //Lecturers.add("Lecturers 1");
        //Lecturers.add("Lecturers 2");
        //Lecturers.add("Lecturers 3");
       // Lecturers.add("Lecturers 4");
        //Lecturers.add("Lecturers 5");
        //Lecturers.add("Lecturers 6");
        //Lecturers.add("Lecturers 7");
       // Lecturers.add("Lecturers 8");
        //Lecturers.add("Lecturers 9");
        //Lecturers.add("Lecturers10");

       // ArrayList<String> number= new ArrayList<>();
       // number.add("0722");
       // number.add("0723");
       // number.add("0724");
       // number.add("0725");
       // number.add("0726");
       // number.add("0727");
       // number.add("0728");
       // number.add("0729");
       // number.add("0730");
       // number.add("0731");

       // ArrayList <Integer> pic = new ArrayList<>();

       // pic.add(R.drawable.user);
        //pic.add(R.drawable.user);
       // pic.add(R.drawable.user);
        //pic.add(R.drawable.user);
        //pic.add(R.drawable.user);
       // pic.add(R.drawable.user);
       // pic.add(R.drawable.user);
       // pic.add(R.drawable.user);
       // pic.add(R.drawable.user);
        //pic.add(R.drawable.user);



        //ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Lecturers);
        customListview CustomListview =new customListview(this,Lecturers,number,pic);
        mListView.setAdapter(CustomListview);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                startActivity(new Intent(this, MainActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
