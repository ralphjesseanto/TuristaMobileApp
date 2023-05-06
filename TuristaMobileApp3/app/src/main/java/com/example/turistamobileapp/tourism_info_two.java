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

public class tourism_info_two extends AppCompatActivity {

    List<info_two_desc> info_two_descList;
    VideoView videoVw_resorts;
    ImageButton imgbtn_menu;
    SearchView search_resorts;
    RecyclerView recyclerVw_resorts;
    info_twoAdapter info_twoAdapter;

    @Override
    protected void onPostResume() {
        videoVw_resorts.resume();
        super.onPostResume();
    }

    @Override
    protected void onRestart(){
        videoVw_resorts.start();
        super.onRestart();
    }

    @Override
    protected void onPause(){
        videoVw_resorts.suspend();
        super.onPause();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        videoVw_resorts.stopPlayback();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourism_info_two);
        videoVw_resorts = findViewById(R.id.video_beach_resort);
        imgbtn_menu = findViewById(R.id.img_btn_menu);
        search_resorts = findViewById(R.id.searchVw_resorts);
        recyclerVw_resorts = findViewById(R.id.recyclerView_resorts);

        Uri uri = Uri.parse("android.resource://" + getPackageName()+"/"+R.raw.resorts);
        videoVw_resorts.setVideoURI(uri);
        videoVw_resorts.start();
        videoVw_resorts.setOnPreparedListener(mp -> mp.setLooping(true));

        imgbtn_menu.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"TOURIST INFORMATION MENU PORTAL",Toast.LENGTH_LONG).show();
            startActivity(new Intent(tourism_info_two.this,turista_information_menu_portal.class));
        });

        search_resorts.clearFocus();
        search_resorts.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
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
        List<info_two_desc> filteredList = new ArrayList<>();
        for(info_two_desc item_resorts: info_two_descList){
            if(item_resorts.getResort_name().toLowerCase().contains(newText.toLowerCase())){
                filteredList.add(item_resorts);
            }
        }
        info_twoAdapter.filterList(filteredList);
    }

    private void setRecyclerView() {
        info_twoAdapter info_twoAdapter = new info_twoAdapter(info_two_descList);
        recyclerVw_resorts.setAdapter(info_twoAdapter);
        recyclerVw_resorts.setHasFixedSize(true);
    }

    private void initData() {
        info_two_descList = new ArrayList<>();
        info_two_descList.add(new info_two_desc("71% Diving Resort","Marterese Street,Buntis,Bacong,Negros Oriental","0945-159-6072","none",R.drawable.resort_one,R.drawable.resort_map_one));
        info_two_descList.add(new info_two_desc("Essencia Upland Resort","Timbanga,Bacong,Negros Oriental","422-1137 loc.8006/0917-504-2140/0915-566-3342","none",R.drawable.resort_two,R.drawable.resort_map_two));
        info_two_descList.add(new info_two_desc("Sta.Monica Beach Club","Banilad,Dumaguete City","0906-478-9018/0919-469-4880","www.stamonicabeachclub.com",R.drawable.resort_three,R.drawable.resort_map_three));
        info_two_descList.add(new info_two_desc("The Wilson's Shangrila","Ajong Beach,Ajong,Sibulan,Negros Oriental","0915-024-8366","none",R.drawable.resort_four,R.drawable.resort_map_four));
        info_two_descList.add(new info_two_desc("The Forest Camp Nature Resort","Taft Street,Valencia,Negros Oriental","522-7304/0917-658-5112","www.forestcamp.biz",R.drawable.resort_five,R.drawable.resort_map_five));
        info_two_descList.add(new info_two_desc("Bambulo Resort","Bacong-Valencia Road, Sulodpan,Bacong,Negros Oriental","0999-797-3318","https://www.bambulo.com",R.drawable.resort_six,R.drawable.resort_map_six));
        info_two_descList.add(new info_two_desc("Kakisa Dive Resort","Marterese Street,South Poblacion,Bacong,Negros Oriental", "4248642","none",R.drawable.resort_seven,R.drawable.resort_map_seven));
        info_two_descList.add(new info_two_desc("D and D Family Beach House","Melrose Road, Purok St. John,Calindagan,Dumaguete City","420-9374","none",R.drawable.resort_eight,R.drawable.resort_map_eight));
        info_two_descList.add(new info_two_desc("Coco Cubano Beach Resort","Martisan Beach,Banilad,Negros Oriental","0917-163-4351","https://www.cococubanobeachresort.com",R.drawable.resort_nine,R.drawable.resort_map_nine));
        info_two_descList.add(new info_two_desc("Eden Garden Valencia","Purok 3,Jawa,Valencia,Negros Oriental","0977-428-9861","https://www.edenhotelph.com",R.drawable.resort_ten,R.drawable.resort_map_ten));
        info_two_descList.add(new info_two_desc("Sea Forest Resort","Ajong,Sibulan,Negros Oriental","226-6151/226-6386/0922-822-3931","none",R.drawable.resort_eleven,R.drawable.resort_map_eleven));
    }
}
