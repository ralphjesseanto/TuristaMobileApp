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

public class tourism_info_four extends AppCompatActivity {

    VideoView videoVw_school;
    ImageButton imgbtn_menu;
    RecyclerView recyclerVw_school;
    SearchView search_school;
    info_fourAdapter info_fourAdapter;
    List<info_four_desc> info_four_descList;

    @Override
    protected void onPostResume() {
        videoVw_school.resume();
        super.onPostResume();
    }

    @Override
    protected void onRestart(){
        videoVw_school.start();
        super.onRestart();
    }

    @Override
    protected void onPause(){
        videoVw_school.suspend();
        super.onPause();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        videoVw_school.stopPlayback();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourism_info_four);
        videoVw_school = findViewById(R.id.video_school);
        imgbtn_menu = findViewById(R.id.img_btn_menu);
        search_school = findViewById(R.id.searchVw_schools);
        recyclerVw_school = findViewById(R.id.recyclerView_school);

        Uri uri = Uri.parse("android.resource://" + getPackageName()+"/"+R.raw.schools_portal);
        videoVw_school.setVideoURI(uri);
        videoVw_school.start();
        videoVw_school.setOnPreparedListener(mp -> mp.setLooping(true));

        imgbtn_menu.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"TOURIST INFORMATION PORTAL MENU",Toast.LENGTH_LONG).show();
            startActivity(new Intent(tourism_info_four.this,turista_information_menu_portal.class));
        });

        search_school.clearFocus();
        search_school.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
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
        List<info_four_desc> filteredList = new ArrayList<>();
        for(info_four_desc item_school: info_four_descList) {
            if (item_school.getSchool_name().toLowerCase().contains(newText.toLowerCase())) {
                filteredList.add(item_school);
            }
        }
        info_fourAdapter.filterList(filteredList);
    }

    private void setRecyclerView() {
        info_fourAdapter info_fourAdapter = new info_fourAdapter(info_four_descList);
        recyclerVw_school.setAdapter(info_fourAdapter);
        recyclerVw_school.setHasFixedSize(true);
    }

    private void initData() {
        info_four_descList = new ArrayList<>();
        info_four_descList.add(new info_four_desc("ABC Learning Center","Hibbard Avenue,Bantayan, Dumaguete City","0917-419-0541","https://www.facebook.com/abclearningcenterofficial/","https://www.facebook.com/ABC-Learning-Center-902255993142152/",R.drawable.school_one,R.drawable.school_map_one));
        info_four_descList.add(new info_four_desc("Saint Paul University Dumaguete","L.Rovira Road,Bantayan,Dumaguete City","225-1506","https://www.spud.edu.ph/","https://www.facebook.com/stpauluniversitydumaguete/",R.drawable.school_two,R.drawable.school_map_two));
        info_four_descList.add(new info_four_desc("Silliman University","Hibbard Avenue,Dumaguete City","420-1901","https://su.edu.ph/","https://www.facebook.com/SillimanUniversity/",R.drawable.school_three,R.drawable.school_map_three));
        info_four_descList.add(new info_four_desc("Foundation University","Dr.Meciano Road,Dumaguete City","422-9167","https://www.facebook.com/foundationU.eduPHL/","https://www.foundationu.com/",R.drawable.school_four,R.drawable.school_map_four));
        info_four_descList.add(new info_four_desc("Negros Oriental High School","Kagawasan Avenue,Dumaguete City","527-0798 | 522-0038","https://www.facebook.com/1902nohs/","none",R.drawable.school_five,R.drawable.school_map_five));
        info_four_descList.add(new info_four_desc("Negros Oriental State University","Capitol Area,Kagawasan Avenue,Dumaguete City","2250777","http://www.norsu.edu.ph/","none",R.drawable.school_six,R.drawable.school_map_six));
        info_four_descList.add(new info_four_desc("St.Louis Don Bosco","Calindagan Road,Dumaguete City","225-0384","https://www.facebook.com/SLSDBDumaguete/","https://www.facebook.com/SLSDBDumaguete/",R.drawable.school_seven,R.drawable.school_map_seven));
        info_four_descList.add(new info_four_desc("Holy Cross High School","Noblefranca Street,Dumaguete City","422-7601|420-6116|0977-263-8873","https://hchsdgte.edu.ph/","none",R.drawable.school_eight,R.drawable.school_map_eight));
        info_four_descList.add(new info_four_desc("Colegio de Santa Catalina de Alejandria","Bishop Epifanio Surban Street,Dumaguete City","225-4831","https://cosca.edu.ph/","none",R.drawable.school_nine,R.drawable.school_map_nine));
        info_four_descList.add(new info_four_desc("Asian College","Dr.V.Locsin Street,Dumaguete City","225-4714"," https://www.facebook.com/AsianCollegeDumaguete/","https://www.asiancollege.edu.ph/",R.drawable.school_ten,R.drawable.school_map_ten));
        info_four_descList.add(new info_four_desc("STI College Dumaguete","Libertad Street,Dumaguete City","522-9030","https://www.sti.edu/campuses-details.asp?campus_id=DUM","https://www.facebook.com/dumaguete.sti.edu/",R.drawable.school_eleven,R.drawable.school_map_eleven));
    }
}