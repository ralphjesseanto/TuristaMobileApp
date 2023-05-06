package com.example.turistamobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class turista_main_menu_portal extends AppCompatActivity {

    Button menu_one,menu_two,menu_three,menu_four,menu_five;
    VideoView video_turista_main_menu;
    TextView turista_fname;

    @Override
    protected void onPostResume() {
        video_turista_main_menu.resume();
        super.onPostResume();
    }

    @Override
    protected void onRestart(){
        video_turista_main_menu.start();
        super.onRestart();
    }

    @Override
    protected void onPause(){
        video_turista_main_menu.suspend();
        super.onPause();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        video_turista_main_menu.stopPlayback();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turista_main_menu_portal);

        video_turista_main_menu = findViewById(R.id.video_turista_main_menu);
        menu_one = findViewById(R.id.btn_menu_one);
        menu_two = findViewById(R.id.btn_menu_two);
        menu_three = findViewById(R.id.btn_menu_three);
        menu_four = findViewById(R.id.btn_menu_four);
        menu_five = findViewById(R.id.btn_menu_five);
        turista_fname = findViewById(R.id.textVw_firstname);

        Uri uri = Uri.parse("android.resource://" + getPackageName()+"/"+R.raw.video_turista);
        video_turista_main_menu.setVideoURI(uri);
        video_turista_main_menu.start();
        video_turista_main_menu.setOnPreparedListener(mp -> mp.setLooping(true));
        turista_fname.setText(GlobalVariables.firstname);

        menu_one.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"History Portal",Toast.LENGTH_LONG).show();
            startActivity(new Intent(turista_main_menu_portal.this,turista_history_menu_portal.class));
        });

        menu_two.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"Facts Portal",Toast.LENGTH_LONG).show();
            startActivity(new Intent(turista_main_menu_portal.this,turista_fun_facts_portal.class));
        });

        menu_three.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"Gallery Portal",Toast.LENGTH_LONG).show();
            startActivity(new Intent(turista_main_menu_portal.this,turista_gallery_menu_portal.class));
        });

        menu_four.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"Tourism Information Portal",Toast.LENGTH_LONG).show();
            startActivity(new Intent(turista_main_menu_portal.this,turista_information_menu_portal.class));
        });

        menu_five.setOnClickListener(v -> backtoWelcome());
    }
    private void backtoWelcome() {
        Toast.makeText(getApplicationContext(),"TURISTA LOG-OUT",Toast.LENGTH_LONG).show();
        Intent backtoWelcome = new Intent(turista_main_menu_portal.this,MainActivity.class);
        startActivity(backtoWelcome);
    }
}
