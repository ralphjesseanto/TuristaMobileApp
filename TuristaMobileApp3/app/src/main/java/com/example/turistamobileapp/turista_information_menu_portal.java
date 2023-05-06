package com.example.turistamobileapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class turista_information_menu_portal extends AppCompatActivity {

    VideoView videoVw_info_portal;
    Button btn_one,btn_two,btn_three,btn_four,btn_five,btn_six,btn_seven,btn_eight,btn_nine,btn_ten,btn_eleven;
    ImageButton btn_menu;
    TextView text_turista_info_portal;

    @Override
    protected void onPostResume() {
        videoVw_info_portal.resume();
        super.onPostResume();
    }

    @Override
    protected void onRestart(){
        videoVw_info_portal.start();
        super.onRestart();
    }

    @Override
    protected void onPause(){
        videoVw_info_portal.suspend();
        super.onPause();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        videoVw_info_portal.stopPlayback();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turista_information_menu_portal);
        videoVw_info_portal = findViewById(R.id.videoVw_tourism_info);
        text_turista_info_portal = findViewById(R.id.textVw_turista_info_portal);
        btn_one = findViewById(R.id.hotel);
        btn_two = findViewById(R.id.resorts);
        btn_three = findViewById(R.id.resto);
        btn_four = findViewById(R.id.schools);
        btn_five = findViewById(R.id.hospital);
        btn_six = findViewById(R.id.mall);
        btn_seven = findViewById(R.id.church);
        btn_eight = findViewById(R.id.banks);
        btn_nine = findViewById(R.id.port);
        btn_ten = findViewById(R.id.tourist_spot);
        btn_eleven = findViewById(R.id.tourism_hub);

        Uri uri = Uri.parse("android.resource://" + getPackageName()+"/"+R.raw.video_turista);
        videoVw_info_portal.setVideoURI(uri);
        videoVw_info_portal.start();
        videoVw_info_portal.setOnPreparedListener(mp -> mp.setLooping(true));

        btn_menu.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"TOURIST MENU PORTAL",Toast.LENGTH_LONG).show();
            startActivity(new Intent(turista_information_menu_portal.this,turista_main_menu_portal.class));
        });

        btn_one.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"LIST OF HOTELS",Toast.LENGTH_LONG).show();
            startActivity(new Intent(turista_information_menu_portal.this,tourism_info_one.class));
        });

        btn_two.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"LIST OF RESORTS",Toast.LENGTH_LONG).show();
            startActivity(new Intent(turista_information_menu_portal.this,tourism_info_two.class));
        });

        btn_three.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"LIST OF RESTAURANTS",Toast.LENGTH_LONG).show();
            startActivity(new Intent(turista_information_menu_portal.this,tourism_info_three.class));
        });

        btn_four.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"LIST OF SCHOOL",Toast.LENGTH_LONG).show();
            startActivity(new Intent(turista_information_menu_portal.this,tourism_info_four.class));
        });

        btn_five.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"LIST OF HOSPITALS",Toast.LENGTH_LONG).show();
            startActivity(new Intent(turista_information_menu_portal.this,tourism_info_five.class));
        });

        btn_six.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"LIST OF MALLS",Toast.LENGTH_LONG).show();
            startActivity(new Intent(turista_information_menu_portal.this,tourism_info_six.class));
        });

        btn_seven.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"LIST OF CHURCH",Toast.LENGTH_LONG).show();
            startActivity(new Intent(turista_information_menu_portal.this,tourism_info_seven.class));
        });

        btn_eight.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"LIST OF BANK",Toast.LENGTH_LONG).show();
            startActivity(new Intent(turista_information_menu_portal.this,tourism_info_eight.class));
        });

        btn_nine.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"LIST OF PORTS",Toast.LENGTH_LONG).show();
            startActivity(new Intent(turista_information_menu_portal.this,tourism_info_nine.class));
        });

        btn_ten.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"LIST OF TOURIST SPOTS",Toast.LENGTH_LONG).show();
            startActivity(new Intent(turista_information_menu_portal.this,tourism_info_ten.class));
        });

        btn_eleven.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"LIST OF TOURISM INFORMATION HUBS",Toast.LENGTH_LONG).show();
            startActivity(new Intent(turista_information_menu_portal.this,tourism_info_eleven.class));
        });
    }
}
