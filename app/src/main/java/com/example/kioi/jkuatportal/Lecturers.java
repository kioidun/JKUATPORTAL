package com.example.kioi.jkuatportal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Lecturers extends AppCompatActivity {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturers);
        mListView = (ListView) findViewById(R.id.listLecturers);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ArrayList<String> courses = new ArrayList<String>();
        courses.add("Lecturers 1");
        courses.add("Lecturers 2");
        courses.add("Lecturers 3");
        courses.add("Lecturers 4");
        courses.add("Lecturers 5");
        courses.add("Lecturers 6");
        courses.add("Lecturers 7");
        courses.add("Lecturers 8");
        courses.add("Lecturers 9");
        courses.add("Lecturers10");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, courses);
        mListView.setAdapter(arrayAdapter);
    }
}
