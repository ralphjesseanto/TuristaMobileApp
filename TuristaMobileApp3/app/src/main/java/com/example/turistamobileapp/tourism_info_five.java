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

public class tourism_info_five extends AppCompatActivity {

    VideoView videoVw_hospital;
    ImageButton imgbtn_menu;
    RecyclerView recyclerVw_hospital;
    SearchView search_hospital;
    info_fiveAdapter info_fiveAdapter;
    List<info_five_desc> info_five_descList;

    @Override
    protected void onPostResume() {
        videoVw_hospital.resume();
        super.onPostResume();
    }

    @Override
    protected void onRestart(){
        videoVw_hospital.start();
        super.onRestart();
    }

    @Override
    protected void onPause(){
        videoVw_hospital.suspend();
        super.onPause();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        videoVw_hospital.stopPlayback();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourism_info_five);
        videoVw_hospital = findViewById(R.id.video_hospital);
        imgbtn_menu = findViewById(R.id.img_btn_menu);
        search_hospital = findViewById(R.id.searchVw_hospital);
        recyclerVw_hospital = findViewById(R.id.recyclerView_hospital);

        Uri uri = Uri.parse("android.resource://" + getPackageName()+"/"+R.raw.hospital_portal);
        videoVw_hospital.setVideoURI(uri);
        videoVw_hospital.start();
        videoVw_hospital.setOnPreparedListener(mp -> mp.setLooping(true));

        imgbtn_menu.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"TOURIST INFORMATION PORTAL",Toast.LENGTH_LONG).show();
            startActivity(new Intent(tourism_info_five.this,turista_information_menu_portal.class));
        });

        search_hospital.clearFocus();
        search_hospital.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return false;
            }
        });
        initData();
        setRecyclerView();
    }

    private void filter(String newText) {
        List<info_five_desc> filteredList = new ArrayList<>();
        for(info_five_desc item_hospital: info_five_descList) {
            if (item_hospital.getHospital_name().toLowerCase().contains(newText.toLowerCase())) {
                filteredList.add(item_hospital);
            }
        }
        info_fiveAdapter.filterList(filteredList);
    }

    private void setRecyclerView() {
        info_fiveAdapter info_fiveAdapter = new info_fiveAdapter(info_five_descList);
        recyclerVw_hospital.setAdapter(info_fiveAdapter);
        recyclerVw_hospital.setHasFixedSize(true);
    }

    private void initData() {
        info_five_descList = new ArrayList<>();
        info_five_descList.add(new info_five_desc("Holy Child Hospital","Legaspi Street,E.Surban,Dumaguete City","421-0991","none",R.drawable.hospital_one,R.drawable.hospital_map_one));
        info_five_descList.add(new info_five_desc("Negros Oriental Provincial Hospital","North National Highway,Real Street,Dumaguete City","225-0950","none",R.drawable.hospital_two,R.drawable.hospital_map_two));
        info_five_descList.add(new info_five_desc("Silliman University Medical Center","Aldeoca Drive, Dumaguete City","420-2000"," https://www.facebook.com/SUMCFI/",R.drawable.hospital_three,R.drawable.hospital_map_three));
        info_five_descList.add(new info_five_desc("Negros Polymedic Hospital","Purok Yakal, North Tubtubon, North National Highway, Sibulan,Negros Oriental","0908-815-2899","https://www.facebook.com/ENHANEGROSPOLYMEDIC/",R.drawable.hospital_four,R.drawable.hospital_map_four));
        info_five_descList.add(new info_five_desc("Ace Doctors Hospital Dumaguete","Claytown Road, Daro, Dumaguete City","0923-116-6464","https://www.acedumaguetedoctors.com/",R.drawable.hospital_five,R.drawable.hospital_map_five));
    }
}
