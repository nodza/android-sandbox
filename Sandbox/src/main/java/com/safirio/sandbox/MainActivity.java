package com.safirio.sandbox;

import android.R.*;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Nodza on 10/30/13.
 */
public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Intent i = new Intent("com.safirio.Activity2");
//        startActivity(i);
    }

    public void onButtonClick(View view)
    {
        Intent intent = new Intent(MainActivity.this, JSONActivity.class);
        startActivity(intent);
    }

    public void onPresButtonClick(View view)
    {
        Intent intent = new Intent(MainActivity.this, ActivityList.class);
        startActivity(intent);
    }

    public void onYtButtonClick(View view)
    {
        Intent videoIntent = new Intent(MainActivity.this, YoutubeActivityList.class);
        startActivity(videoIntent);
    }

//    public void onJsonClick(View view)
//    {
//        Intent intent = new Intent(MainActivity.this, JSONActivity.class);
//        startActivity(intent);
//    }
}
