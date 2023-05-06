package com.example.turistamobileapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

public class turista_gallery_menu_portal extends AppCompatActivity {

    Button gallery_one,gallery_two,turista_menu;
    VideoView gallery_video;

    @Override
    protected void onPostResume() {
        gallery_video.resume();
        super.onPostResume();
    }

    @Override
    protected void onRestart(){
        gallery_video.start();
        super.onRestart();
    }

    @Override
    protected void onPause(){
        gallery_video.suspend();
        super.onPause();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        gallery_video.stopPlayback();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turista_gallery_menu_portal);

        gallery_video = findViewById(R.id.video_admin_turista_users);
        gallery_one = findViewById(R.id.button_photo_gallery);
        gallery_two = findViewById(R.id.button_video_gallery);
        turista_menu = findViewById(R.id.button_main_menu);
        Uri uri = Uri.parse("android.resource://" + getPackageName()+"/"+R.raw.video_turista);
        gallery_video.setVideoURI(uri);
        gallery_video.start();
        gallery_video.setOnPreparedListener(mp -> mp.setLooping(true));

        gallery_one.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"PHOTO GALLERY",Toast.LENGTH_LONG).show();
            startActivity(new Intent(turista_gallery_menu_portal.this,turista_photo_gallery_portal.class));
        });

        gallery_two.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"VIDEO GALLERY",Toast.LENGTH_LONG).show();
            startActivity(new Intent(turista_gallery_menu_portal.this,turista_video_gallery_portal.class));
        });

       turista_menu.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"TURISTA MAIN MENU PORTAL",Toast.LENGTH_LONG).show();
            startActivity(new Intent(turista_gallery_menu_portal.this,turista_main_menu_portal.class));
        });
    }
}