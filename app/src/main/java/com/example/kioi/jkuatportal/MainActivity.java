package com.example.kioi.jkuatportal;

import android.app.FragmentManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Button mCourses;
    private Button mLecturers;
    private Button mTimetable;
    private Button mJkusa;
    private Button mClassrep;
    private Button mMap;
    private DatabaseReference mDatabaseReference;
    private String mDisplayName;
    private TextView mName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Menu");

        //setting up the display name and get the FIREBASE reference
        // a database reference represents a particular location in the cloud database. databasereference is used for reading and writing data to that location in the db.
        if(sharedPreference.getUserName(MainActivity.this).length() == 0)
        {
            // call Login Activ
        }
        else
        {
            // Stay at the current activity.
        }
        mName = (TextView) findViewById(R.id.Name);
        setupDisplayName();
        mDatabaseReference = FirebaseDatabase.getInstance().getReference();
        mCourses = (Button) findViewById(R.id.courses);
        mLecturers = (Button) findViewById(R.id.lecturers);
        mTimetable = (Button) findViewById(R.id.Timetable);
        mJkusa = (Button) findViewById(R.id.jkusa);
        mClassrep = (Button) findViewById(R.id.Classreps);
        mMap = (Button) findViewById(R.id.maps);


        mCourses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent courses = new Intent(MainActivity.this, com.example.kioi.jkuatportal.courses.class);
                startActivity(courses);
                finish();
            }
        });

        mLecturers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lecturers = new Intent(MainActivity.this, Lecturers.class);
                startActivity(lecturers);
                finish();
            }
        });
        mTimetable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Timetable = new Intent(MainActivity.this, com.example.kioi.jkuatportal.Timetable.class);
                startActivity(Timetable);
                finish();
            }
        });
        mJkusa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent jkusa = new Intent(MainActivity.this, Jkusa.class);
                startActivity(jkusa);
                finish();
            }
        });
        mClassrep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent classrep = new Intent(MainActivity.this, Classreps.class);
                startActivity(classrep);
                finish();
            }
        });
        mMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent map = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(map);
                finish();
            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, chat.class);
                startActivity(intent);
                finish();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //set username
        View headerView= navigationView.getHeaderView(0);
        TextView navUsername = headerView.findViewById(R.id.Name);
        navUsername.setText(SaveSharedPreference.getUserName(this));

    }

    private void setupDisplayName() {
        SharedPreferences prefs = getSharedPreferences(RegisterActivity.CHAT_PREFS, MODE_PRIVATE);

        mDisplayName = prefs.getString(RegisterActivity.DISPLAY_NAME_KEY, null);

        if (mDisplayName == null) mDisplayName = "anonymous";


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();

        }
        //else if (id == R.id.nav_gallery) {

        // } else if (id == R.id.nav_slideshow) {


        //} else if (id == R.id.nav_manage) {

        // } else if (id == R.id.nav_share) {

        // } else if (id == R.id.nav_send) {

        // }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
