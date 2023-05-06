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

public class tourism_info_six extends AppCompatActivity {

    VideoView videoVw_mall;
    ImageButton imgbtn_menu;
    SearchView search_mall;
    RecyclerView recyclerVw_malls;
    info_sixAdapter info_sixAdapter;
    List<info_six_desc> info_six_descList;

    @Override
    protected void onPostResume() {
        videoVw_mall.resume();
        super.onPostResume();
    }

    @Override
    protected void onRestart(){
        videoVw_mall.start();
        super.onRestart();
    }

    @Override
    protected void onPause(){
        videoVw_mall.suspend();
        super.onPause();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        videoVw_mall.stopPlayback();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourism_info_six);
        videoVw_mall = findViewById(R.id.video_mall);
        imgbtn_menu = findViewById(R.id.img_btn_menu);
        search_mall = findViewById(R.id.searchVw_malls);
        recyclerVw_malls = findViewById(R.id.recyclerView_malls);

        Uri uri = Uri.parse("android.resource://" + getPackageName()+"/"+R.raw.mall_portal);
        videoVw_mall.setVideoURI(uri);
        videoVw_mall.start();
        videoVw_mall.setOnPreparedListener(mp -> mp.setLooping(true));
        imgbtn_menu.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"TOURIST INFORMATION PORTAL",Toast.LENGTH_LONG).show();
            startActivity(new Intent(tourism_info_six.this,turista_information_menu_portal.class));
        });

        search_mall.clearFocus();
        search_mall.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
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
        List<info_six_desc> filteredList = new ArrayList<>();
        for(info_six_desc item_mall: info_six_descList){
            if(item_mall.getMall_name().toLowerCase().contains(newText.toLowerCase())){
                filteredList.add(item_mall);
            }
        }
        info_sixAdapter.filterList(filteredList);
    }

    private void setRecyclerView() {
        info_sixAdapter info_sixAdapter = new info_sixAdapter(info_six_descList);
        recyclerVw_malls.setAdapter(info_sixAdapter);
        recyclerVw_malls.setHasFixedSize(true);
    }

    private void initData() {
        info_six_descList = new ArrayList<>();
        info_six_descList.add(new info_six_desc("UNITOP DUMAGUETE","Perdices Street, Dumaguete City","0917-657-6638","https://www.facebook.com/Unitop21DumagueteCity",R.drawable.mall_one,R.drawable.mall_map_one));
        info_six_descList.add(new info_six_desc("Cang's Daro","North Road, Daro, Dumaguete City","0917-314-0997","https://www.facebook.com/cangsinc2013",R.drawable.mall_two,R.drawable.mall_map_two));
        info_six_descList.add(new info_six_desc("Lee Super Plaza Dumaguete","Perdices Street corner San Jose Street, Dumaguete City", "4222000","http://www.leeplazashopping.com/",R.drawable.mall_three,R.drawable.mall_map_three));
        info_six_descList.add(new info_six_desc("City Mall Dumaguete","Veterans Avenue along National Highway, Dumaguete City", "420-9602","https://www.facebook.com/CityMallDumagueteOfficial/",R.drawable.mall_four,R.drawable.mall_map_four));
        info_six_descList.add(new info_six_desc("Robinsons Place Dumaguete","Dumaguete Business Park, Calindagan,Dumaguete City","421-1690","https://www.robinsonsmalls.com/mall-info/robinsons-place-dumaguete",R.drawable.mall_five,R.drawable.mall_map_five));
        info_six_descList.add(new info_six_desc("Robinsons Supermarket","Perdices Street","522-1563","https://www.robinsonssupermarket.com.ph/",R.drawable.mall_six,R.drawable.mall_map_six));
    }
}
