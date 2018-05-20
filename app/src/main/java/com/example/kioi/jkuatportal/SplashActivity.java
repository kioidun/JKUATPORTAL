package com.example.kioi.jkuatportal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent activityIntent;

        if (SaveSharedPreference.getUserName(SplashActivity.this).length()==0){
            //call login activity
            activityIntent = new Intent(this,LoginActivity.class);
        }
        else
            {
            //stay at the current activity
                activityIntent = new Intent(this, MainActivity.class);
        }

        startActivity(activityIntent);
        finish();

    }
}
