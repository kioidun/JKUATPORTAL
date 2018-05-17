package com.example.kioi.jkuatportal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class courses extends AppCompatActivity {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mListView=(ListView)findViewById(R.id.listCourses);

        ArrayList<String> courses=new ArrayList<String>();
        courses.add("lecturer 1");
        courses.add("lecturer 2");
        courses.add("lecturer 3");
        courses.add("lecturer 4");
        courses.add("lecturer 5");
        courses.add("lecturer 6");
        courses.add("lecturer 7");
        courses.add("lecturer 8");
        courses.add("lecturer 9");
        courses.add("lecturer 10");
        courses.add("lecturer 11");
        courses.add("lecturer 12");
        courses.add("lecturer 13");
        courses.add("lecturer 14");
        courses.add("lecturer 15");
        courses.add("lecturer 16");
        courses.add("lecturer 17");
        courses.add("lecturer 18");
        courses.add("lecturer 19");
        courses.add("lecturer 20");

        ArrayAdapter<String > arrayAdapter =new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,courses);
        mListView.setAdapter(arrayAdapter);

    }
}
