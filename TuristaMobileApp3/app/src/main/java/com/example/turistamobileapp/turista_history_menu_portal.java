package com.example.turistamobileapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

public class turista_history_menu_portal extends AppCompatActivity {

    Button history_one,history_two,history_three,history_four,list_barangay,turista_menu;
    VideoView video_history_menu;

    @Override
    protected void onPostResume() {
        video_history_menu.resume();
        super.onPostResume();
    }

    @Override
    protected void onRestart(){
        video_history_menu.start();
        super.onRestart();
    }

    @Override
    protected void onPause(){
        video_history_menu.suspend();
        super.onPause();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        video_history_menu.stopPlayback();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turista_history_menu_portal);
        video_history_menu = findViewById(R.id.video_turista_main_menu);
        history_one = findViewById(R.id.history_one);
        history_two = findViewById(R.id.history_two);
        history_three = findViewById(R.id.history_three);
        history_four = findViewById(R.id.history_four);
        list_barangay = findViewById(R.id.barangay);
        turista_menu= findViewById(R.id.menu);

        Uri uri = Uri.parse("android.resource://" + getPackageName()+"/"+R.raw.video_turista);
        video_history_menu.setVideoURI(uri);
        video_history_menu.start();
        video_history_menu.setOnPreparedListener(mp -> mp.setLooping(true));

        history_one.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"WELCOME TO DUMAGUETE CITY",Toast.LENGTH_LONG).show();
            startActivity(new Intent(turista_history_menu_portal.this,history_portal_one.class));
        });

        history_two.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"WELCOME TO THE MUNICIPALITY OF SIBULAN",Toast.LENGTH_LONG).show();
            startActivity(new Intent(turista_history_menu_portal.this,history_portal_two.class));
        });

        history_three.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"WELCOME TO THE MUNICIPALITY OF BACONG",Toast.LENGTH_LONG).show();
            startActivity(new Intent(turista_history_menu_portal.this,history_portal_three.class));
        });

        history_four.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"WELCOME TO THE MUNICIPALITY OF VALENCIA",Toast.LENGTH_LONG).show();
            startActivity(new Intent(turista_history_menu_portal.this,history_portal_four.class));
        });

        list_barangay.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"LIST OF BARANGAY",Toast.LENGTH_LONG).show();
            startActivity(new Intent(turista_history_menu_portal.this,turista_list_of_barangay.class));
        });

        turista_menu.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"TURISTA MAIN MENU",Toast.LENGTH_LONG).show();
            startActivity(new Intent(turista_history_menu_portal.this,turista_main_menu_portal.class));
        });
    }
}