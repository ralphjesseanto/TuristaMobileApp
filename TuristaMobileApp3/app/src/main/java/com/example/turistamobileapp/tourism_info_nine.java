package com.example.turistamobileapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.VideoView;
import java.util.ArrayList;
import java.util.List;

public class tourism_info_nine extends AppCompatActivity {

    VideoView videoVw_ports;
    ImageButton imgbtn_menu;
    SearchView search_ports;
    RecyclerView recyclerVw_ports;
    info_nineAdapter info_nineAdapter;
    List<info_nine_desc> info_nine_descList;

    @Override
    protected void onPostResume() {
        videoVw_ports.resume();
        super.onPostResume();
    }

    @Override
    protected void onRestart(){
        videoVw_ports.start();
        super.onRestart();
    }

    @Override
    protected void onPause(){
        videoVw_ports.suspend();
        super.onPause();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        videoVw_ports.stopPlayback();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourism_info_nine);
        videoVw_ports = findViewById(R.id.video_ports);
        imgbtn_menu = findViewById(R.id.img_btn_menu);
        recyclerVw_ports = findViewById(R.id.recyclerView_port);

        Uri uri = Uri.parse("android.resource://" + getPackageName()+"/"+R.raw.ports_portal);
        videoVw_ports.setVideoURI(uri);
        videoVw_ports.start();
        videoVw_ports.setOnPreparedListener(mp -> mp.setLooping(true));

        imgbtn_menu.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"TOURIST INFO PORTAL",Toast.LENGTH_LONG).show();
            startActivity(new Intent(tourism_info_nine.this,turista_information_menu_portal.class));
        });

        search_ports.clearFocus();
        search_ports.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return true;
            }
        });

        initData();
        setRecyclerView();
    }

    private void filter(String newText) {
        List<info_nine_desc> filteredList = new ArrayList<>();
        for(info_nine_desc item_ports: info_nine_descList){
            if(item_ports.getPort_name().toLowerCase().contains(newText.toLowerCase())){
                filteredList.add(item_ports);
            }
        }
        info_nineAdapter.filterList(filteredList);
    }

    private void setRecyclerView() {
        info_nineAdapter info_nineAdapter = new info_nineAdapter(info_nine_descList);
        recyclerVw_ports.setAdapter(info_nineAdapter);
        recyclerVw_ports.setHasFixedSize(true);
    }

    private void initData() {
        info_nine_descList = new ArrayList<>();
        info_nine_descList.add(new info_nine_desc("Port of Dumaguete","Port Area, Looc, Dumaguete City","225-0973",R.drawable.seaport,R.drawable.map_seaport));
        info_nine_descList.add(new info_nine_desc("Dumaguete-Sibulan Airport","Boloc-boloc, Sibulan,Negros Oriental","225-0900",R.drawable.airport,R.drawable.map_airport));
        info_nine_descList.add(new info_nine_desc("Ceres Terminal Airport","Calindagan Road, Dumaguete City","0917-890-2327",R.drawable.landport,R.drawable.map_landport));
    }
}
