package com.example.turistamobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

public class admin_turista_user_menu extends AppCompatActivity {

    VideoView video_two;
    Button btn_menu_one,btn_menu_two;

    @Override
    protected void onPostResume() {
        video_two.resume();
        super.onPostResume();
    }

    @Override
    protected void onRestart(){
        video_two.start();
        super.onRestart();
    }

    @Override
    protected void onPause(){
        video_two.suspend();
        super.onPause();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        video_two.stopPlayback();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_turista_user_menu);

        video_two = findViewById(R.id.video_admin_turista_users);
        btn_menu_one = findViewById(R.id.button_admin_user);
        btn_menu_two = findViewById(R.id.button_turista_user);

        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video_turista);
        video_two.setVideoURI(uri);
        video_two.start();
        video_two.setOnPreparedListener(mp -> mp.setLooping(true));

        btn_menu_one.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"ADMIN LOGIN PORTAL",Toast.LENGTH_LONG).show();
            startActivity(new Intent(admin_turista_user_menu.this,admin_login_portal.class));
        });

        btn_menu_two.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"TURISTA/LOCAL USERS LOGIN PORTAL",Toast.LENGTH_LONG).show();
            startActivity(new Intent(admin_turista_user_menu.this,turista_login_portal.class));
        });
    }
}
