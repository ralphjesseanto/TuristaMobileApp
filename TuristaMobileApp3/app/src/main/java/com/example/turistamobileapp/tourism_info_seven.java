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

public class tourism_info_seven extends AppCompatActivity {

    VideoView videoVw_church;
    ImageButton imgbtn_menu;
    SearchView search_church;
    RecyclerView recyclerVw_church;
    info_sevenAdapter info_sevenAdapter;
    List<info_seven_desc> info_seven_descList;

    @Override
    protected void onPostResume() {
        videoVw_church.resume();
        super.onPostResume();
    }

    @Override
    protected void onRestart(){
        videoVw_church.start();
        super.onRestart();
    }

    @Override
    protected void onPause(){
        videoVw_church.suspend();
        super.onPause();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        videoVw_church.stopPlayback();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourism_info_seven);
        videoVw_church = findViewById(R.id.video_church);
        imgbtn_menu = findViewById(R.id.img_btn_menu);
        search_church = findViewById(R.id.searchVw_church);
        recyclerVw_church = findViewById(R.id.recyclerView_church);

        Uri uri = Uri.parse("android.resource://" + getPackageName()+"/"+R.raw.church_portal);
        videoVw_church.setVideoURI(uri);
        videoVw_church.start();
        videoVw_church.setOnPreparedListener(mp -> mp.setLooping(true));

        imgbtn_menu.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"TOURIST INFORMATION PORTAL MENU",Toast.LENGTH_LONG).show();
            startActivity(new Intent(tourism_info_seven.this,turista_information_menu_portal.class));
        });

        search_church.clearFocus();
        search_church.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
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

        setRecyclerView();
        initData();
    }

    private void filter(String newText) {
        List<info_seven_desc> filteredList = new ArrayList<>();
        for(info_seven_desc item_church: info_seven_descList){
            if(item_church.getChurch_name().toLowerCase().contains(newText.toLowerCase())){
                filteredList.add(item_church);
            }
        }
        info_sevenAdapter.filterList(filteredList);
    }

    private void setRecyclerView() {
        info_sevenAdapter info_sevenAdapter = new info_sevenAdapter(info_seven_descList);
        recyclerVw_church.setAdapter(info_sevenAdapter);
        recyclerVw_church.setHasFixedSize(true);
    }

    private void initData() {
        info_seven_descList = new ArrayList<>();
        info_seven_descList.add(new info_seven_desc("Our Mother of Perpetual Help Parish","San Lorenzo Street,San Jose Street, Dumaguete City","2254763","https://www.facebook.com/omphdumaguete/",R.drawable.church_1,R.drawable.church_one));
        info_seven_descList.add(new info_seven_desc("Mary of Immaculate Parish Church","San Jose Street,Dumaguete City","422-8441"," https://www.facebook.com/maryimmaculateparishdumaguete/",R.drawable.church_2,R.drawable.church_two));
        info_seven_descList.add(new info_seven_desc("Saint Catherine of Alexandria Cathedral","Perdices Street,Dumaguete City","225-4649","https://www.facebook.com/DumagueteCathedralParish/",R.drawable.church_3,R.drawable.church_three));
        info_seven_descList.add(new info_seven_desc("San Antonio de Padua Parish Church","San Antonio Street,Poblacion,Sibulan,Negros Oriental","224-5422","https://www.facebook.com/san.antonio.of.sibulan/",R.drawable.church_4,R.drawable.church_four));
        info_seven_descList.add(new info_seven_desc("Our Lady of Abandoned Parish Church","Rizal Street,Valencia,Negros Oriental","2253043","https://www.facebook.com/profile.php?id=100064857188032",R.drawable.church_5,R.drawable.church_five));
        info_seven_descList.add(new info_seven_desc("San Augustine of Hippo Parish Church","Poblacion,Bacong,Negros Oriental","424-8200","https://www.facebook.com/TataUsting49/",R.drawable.church_6,R.drawable.church_six));
    }
}
