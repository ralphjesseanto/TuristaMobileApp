package com.example.turistamobileapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.List;

public class tourism_info_eleven extends AppCompatActivity {

    VideoView videoVw_hub;
    ImageButton imgbtn_menu;
    RecyclerView recyclerVw_hub;
    List<info_eleven_desc> info_eleven_descList;

    @Override
    protected void onPostResume() {
        videoVw_hub.resume();
        super.onPostResume();
    }

    @Override
    protected void onRestart(){
        videoVw_hub.start();
        super.onRestart();
    }

    @Override
    protected void onPause(){
        videoVw_hub.suspend();
        super.onPause();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        videoVw_hub.stopPlayback();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourism_info_eleven);

        videoVw_hub = findViewById(R.id.video_hub);
        imgbtn_menu = findViewById(R.id.img_btn_menu);
        recyclerVw_hub = findViewById(R.id.recyclerView_tourism_hub);

        imgbtn_menu.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"TURISTA INFORMATION PORTAL",Toast.LENGTH_LONG).show();
            startActivity(new Intent(tourism_info_eleven.this,turista_information_menu_portal.class));
        });

        initData();
        setRecyclerView();
    }

    private void setRecyclerView() {
        info_elevenAdapter info_elevenAdapter = new info_elevenAdapter(info_eleven_descList);
        recyclerVw_hub.setAdapter(info_elevenAdapter);
        recyclerVw_hub.setHasFixedSize(true);
    }

    private void initData() {
        info_eleven_descList = new ArrayList<>();
        info_eleven_descList.add(new info_eleven_desc("DUMAGUETE TOURISM OFFICE", "COLON STREET, DUMAGUETE CITY","2250549","https://www.facebook.com/dgte.tourism/"));
        info_eleven_descList.add(new info_eleven_desc("NEGROS ORIENTAL PROVINCIAL TOURISM OFFICE", "E.J. BLANCO DRIVE, PIAPI, DUMAGUETE CITY","0935-708-3189","https://visitnegrosoriental.com/"));
    }
}
