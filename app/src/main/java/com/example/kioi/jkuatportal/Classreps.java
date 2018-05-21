package com.example.kioi.jkuatportal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
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

        mListView = (ListView) findViewById(R.id.listClassreps);

        ArrayList<String> classrep = new ArrayList<String>();
        classrep.add("Classrep 1");
        classrep.add("Classrep 2");
        classrep.add("Classrep 3");
        classrep.add("Classrep 4");
        classrep.add("Classrep 5");
        classrep.add("Classrep 6");
        classrep.add("Classrep 7");
        classrep.add("Classrep 8");
        classrep.add("Classrep 9");
        classrep.add("Classrep 10");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, classrep);
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
