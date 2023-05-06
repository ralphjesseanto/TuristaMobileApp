package com.example.turistamobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    VideoView video_one;
    Button welcome_button;

    @Override
    protected void onPostResume() {
        video_one.resume();
        super.onPostResume();
    }

    @Override
    protected void onRestart(){
        video_one.start();
        super.onRestart();
    }

    @Override
    protected void onPause(){
        video_one.suspend();
        super.onPause();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        video_one.stopPlayback();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        video_one = findViewById(R.id.video_welcome_portal);
        welcome_button = findViewById(R.id.button_welcome);

        Uri uri = Uri.parse("android.resource://" + getPackageName()+"/"+R.raw.video_turista);
        video_one.setVideoURI(uri);
        video_one.start();
        video_one.setOnPreparedListener(mp -> mp.setLooping(true));

        welcome_button.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"TURISTA LOGIN FORM PORTAL",Toast.LENGTH_LONG).show();
            startActivity(new Intent(MainActivity.this,admin_turista_user_menu.class));
        });
    }
}
