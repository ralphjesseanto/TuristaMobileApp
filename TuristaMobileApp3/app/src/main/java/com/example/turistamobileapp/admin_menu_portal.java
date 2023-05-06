package com.example.turistamobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

public class admin_menu_portal extends AppCompatActivity {

    Button admin_one,admin_logout;
    VideoView video_admin_menu;

    @Override
    protected void onPostResume() {
        video_admin_menu.resume();
        super.onPostResume();
    }

    @Override
    protected void onRestart(){
        video_admin_menu.start();
        super.onRestart();
    }

    @Override
    protected void onPause(){
        video_admin_menu.suspend();
        super.onPause();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        video_admin_menu.stopPlayback();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu_portal);

        video_admin_menu = findViewById(R.id.video_admin_menu_portal);
        admin_one = findViewById(R.id.btn_admin_list_of_tourist);
        admin_logout = findViewById(R.id.btn_admin_logout);
        Uri uri = Uri.parse("android.resource://" + getPackageName()+"/"+R.raw.video_turista);
        video_admin_menu.setVideoURI(uri);
        video_admin_menu.start();
        video_admin_menu.setOnPreparedListener(mp -> mp.setLooping(true));
        admin_one.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"LIST OF TOURISTS REGISTERED",Toast.LENGTH_LONG).show();
            startActivity(new Intent(admin_menu_portal.this,list_of_tourist_registered_portal.class));
        });
        admin_logout.setOnClickListener(v -> {
            Intent intent = new Intent (admin_menu_portal.this,admin_login_portal.class);
            startActivity(intent);
            finish();
            Toast.makeText(admin_menu_portal.this,"SUCCESSFULLY LOG-OUT",Toast.LENGTH_SHORT).show();
        });
    }
    }
