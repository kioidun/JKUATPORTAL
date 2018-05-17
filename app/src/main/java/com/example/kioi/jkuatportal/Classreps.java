package com.example.kioi.jkuatportal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Classreps extends AppCompatActivity {
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classreps);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mListView=(ListView)findViewById(R.id.listClassreps);

        ArrayList<String> courses=new ArrayList<String>();
        courses.add("Classrep 1");
        courses.add("Classrep 2");
        courses.add("Classrep 3");
        courses.add("Classrep 4");
        courses.add("Classrep 5");
        courses.add("Classrep 6");
        courses.add("Classrep 7");
        courses.add("Classrep 8");
        courses.add("Classrep 9");
        courses.add("Classrep 10");

        ArrayAdapter<String > arrayAdapter =new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,courses);
        mListView.setAdapter(arrayAdapter);
    }
}
