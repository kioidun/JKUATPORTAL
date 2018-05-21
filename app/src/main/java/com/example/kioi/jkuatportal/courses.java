package com.example.kioi.jkuatportal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class courses extends AppCompatActivity {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Courses");

        mListView = (ListView) findViewById(R.id.listCourses);

        ArrayList<String> courses = new ArrayList<String>();
        courses.add("course 1");
        courses.add("course 2");
        courses.add("course 3");
        courses.add("course 4");
        courses.add("course 5");
        courses.add("course 6");
        courses.add("course 7");
        courses.add("course 8");
        courses.add("course 9");
        courses.add("course 10");
        courses.add("course 11");
        courses.add("course 12");
        courses.add("course 13");
        courses.add("course 14");
        courses.add("course 15");
        courses.add("course 16");
        courses.add("course 17");
        courses.add("course 18");
        courses.add("course 19");
        courses.add("course 20");



        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, courses);
        mListView.setAdapter(arrayAdapter);

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
