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

public class tourism_info_eight extends AppCompatActivity {

    VideoView videoVw_banks;
    ImageButton imgbtn_menu;
    RecyclerView recyclerVw_banks;
    SearchView search_banks;
    info_eightAdapter info_eightAdapter;
    List<info_eight_desc> info_eight_descList;

    @Override
    protected void onPostResume() {
        videoVw_banks.resume();
        super.onPostResume();
    }

    @Override
    protected void onRestart(){
        videoVw_banks.start();
        super.onRestart();
    }

    @Override
    protected void onPause(){
        videoVw_banks.suspend();
        super.onPause();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        videoVw_banks.stopPlayback();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourism_info_eight);
        videoVw_banks = findViewById(R.id.video_banks);
        imgbtn_menu = findViewById(R.id.img_btn_menu);
        search_banks = findViewById(R.id.searchVw_banks);
        recyclerVw_banks = findViewById(R.id.recyclerView_bank);

        Uri uri = Uri.parse("android.resource://" + getPackageName()+"/"+R.raw.banks_portal);
        videoVw_banks.setVideoURI(uri);
        videoVw_banks.start();
        videoVw_banks.setOnPreparedListener(mp -> mp.setLooping(true));

        imgbtn_menu.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"TOURIST INFORMATION PORTAL",Toast.LENGTH_LONG).show();
            startActivity(new Intent(tourism_info_eight.this,turista_information_menu_portal.class));
        });

        search_banks.clearFocus();
        search_banks.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
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
        List<info_eight_desc> filteredList = new ArrayList<>();
        for(info_eight_desc item_bank: info_eight_descList) {
            if (item_bank.getName_bank().toLowerCase().contains(newText.toLowerCase())) {
                filteredList.add(item_bank);
            }
        }
        info_eightAdapter.filterList(filteredList);
    }

    private void setRecyclerView() {
        info_eightAdapter info_eightAdapter = new info_eightAdapter(info_eight_descList);
        recyclerVw_banks.setAdapter(info_eightAdapter);
        recyclerVw_banks.setHasFixedSize(true);
    }

    private void initData() {
        info_eight_descList = new ArrayList<>();
        info_eight_descList.add(new info_eight_desc("Unionbank of the Philippines","San Juan Street corner Real Street,Dumaguete City", "422-5038|4224036","https://www.facebook.com/ubp.dumaguete/",R.drawable.bank_one,R.drawable.bank_map_one));
        info_eight_descList.add(new info_eight_desc("Dumaguete City Development Bank","Dr.V.Locsin Street corner Cervantes Street,Dumaguete City","422-9223|422-9224|225-3891","https://dumaguetebank.com/", R.drawable.bank_two,R.drawable.bank_map_two));
        info_eight_descList.add(new info_eight_desc("BPI-E.Surban Street Branch","Gov.M.Perdices Street corner Epifanio Surban Street,Dumaguete City","225-4816","none", R.drawable.bank_three,R.drawable.bank_map_branch_one));
        info_eight_descList.add(new info_eight_desc("BPI-San Jose Street Branch","San Jose Street,Dumaguete City","225-1234","none",R.drawable.bank_three,R.drawable.bank_map_branch_two));
        info_eight_descList.add(new info_eight_desc("BPI-Real Street Branch","Real Street,North Road,Dumaguete City","225-6884","none",R.drawable.bank_three,R.drawable.bank_map_branch_three));
        info_eight_descList.add(new info_eight_desc("Asia United Bank","Dr.V.Locsin Street,Dumaguete City", "420-9097|420-9086","none",R.drawable.bank_four,R.drawable.bank_map_four));
        info_eight_descList.add(new info_eight_desc("Bank of Commerce","Real Street,Dumaguete City","225-7668","none",R.drawable.bank_five,R.drawable.bank_map_five));
        info_eight_descList.add(new info_eight_desc("Bangko Sentral ng Pilipinas","North Road,Daro,Dumaguete City","422-9326","none",R.drawable.bank_six,R.drawable.bank_map_six));
        info_eight_descList.add(new info_eight_desc("First Consolidated Bank","Highway Junob,Jose Romero Road,Junob,Dumaguete City", "4211272","none",R.drawable.bank_seven,R.drawable.bank_map_seven));
        info_eight_descList.add(new info_eight_desc("RCBC Savings Bank","Real Street corner San Juan Street,Dumaguete City","225-6848|422-8452","none",R.drawable.bank_eight,R.drawable.bank_map_eight_branch_two));
        info_eight_descList.add(new info_eight_desc("RCBC Savings Bank","Dr.V.Locsin Street,Dumaguete City", "225-1349","none",R.drawable.bank_eight,R.drawable.bank_map_eight_branch_one));
        info_eight_descList.add(new info_eight_desc("Security Bank-Dumaguete","Portal West Building,Silliman Avenue,Dumaguete City", "422-0001|0922-872-2372","none",R.drawable.bank_nine,R.drawable.bank_map_nine_branch_one));
        info_eight_descList.add(new info_eight_desc("Metrobank Main Branch","Dr.V.Locsin Street,Dumaguete City", "422-7551","none",R.drawable.bank_ten,R.drawable.bank_map_ten_branch_three));
        info_eight_descList.add(new info_eight_desc("Metrobank Capitol Area Branch","Victoria Residence Condominium Building, Capitol Front,North National Highway,Dumaguete City", "420-9168","none",R.drawable.bank_ten,R.drawable.bank_map_ten_branch_two));
        info_eight_descList.add(new info_eight_desc("Metrobank Real Street Branch","Real Street,Dumaguete City", "225-4556","none",R.drawable.bank_ten,R.drawable.bank_map_ten_branch_one));
        info_eight_descList.add(new info_eight_desc("BDO Robinsons Place Dumaguete","Robinsons Place Dumaguete,South Road,Calindagan,Dumaguete City", "421-1714|421-1728","none",R.drawable.bank_eleven,R.drawable.bank_map_eleven_branch_four));
        info_eight_descList.add(new info_eight_desc("BDO Silliman Area","Silliman Area,Dumaguete City", "420-9353","none",R.drawable.bank_eleven,R.drawable.bank_map_eleven_branch_one));
        info_eight_descList.add(new info_eight_desc("BDO CityMall Branch","CityMall Dumaguete,First Street,Dumaguete City", "420-5057","none",R.drawable.bank_eleven,R.drawable.bank_map_eleven_branch_three));
        info_eight_descList.add(new info_eight_desc("BDO Colon Branch","Colon Street,Dumaguete City","2254462","none",R.drawable.bank_eleven,R.drawable.bank_map_eleven_branch_two));
        info_eight_descList.add(new info_eight_desc("PS Bank","G/F Hotel Palwa,Dr.V.Locsin Street,Dumaguete City", "226-1582|422-0152|422-0200","none",R.drawable.bank_twelve,R.drawable.bank_map_twelve));
        info_eight_descList.add(new info_eight_desc("City Savings-Dumaguete","EROS Building,Dr.V.Locsin Street,Dumaguete City", "4210690","none",R.drawable.bank_thirteen,R.drawable.bank_map_thirteen));
        info_eight_descList.add(new info_eight_desc("PNB Locsin Street Branch","Dr.V.Locsin Street,Dumaguete City", "421-6181|225-3909|225-0520","none",R.drawable.bank_fourteen,R.drawable.bank_map_fourteen_branch_two));
        info_eight_descList.add(new info_eight_desc("PNB Silliman Avenue Branch","Silliman Avenue corner Real Street,Dumaguete City","422-9176|422-9658","none",R.drawable.bank_fourteen,R.drawable.bank_map_fourteen_branch_one));
        info_eight_descList.add(new info_eight_desc("PNB Calindagan Branch","South Road,Calindagan,Dumaguete City", "420-5017|420-5018","none",R.drawable.bank_fourteen,R.drawable.bank_map_fourteen_branch_three));
        info_eight_descList.add(new info_eight_desc("Chinabank","CBC Building,Real Street,Dumaguete City","422-8058|225-5441|422-5442","none",R.drawable.bank_fifteen,R.drawable.bank_map_fifteen));
        info_eight_descList.add(new info_eight_desc("Wealthbank","Perdices Street, South Road, Calindagan,Dumaguete City", "0917-870-7393","none",R.drawable.bank_sixteen,R.drawable.bank_map_sixteen));
        info_eight_descList.add(new info_eight_desc("Veterans Bank","PVB Building,Perdices Street corner San Juan Street,Dumaguete City","225-2032","none",R.drawable.bank_seventeen,R.drawable.bank_map_seventeen));
        info_eight_descList.add(new info_eight_desc("1st Valley Bank","Martinez Building,Daan Taytayan Road,Calindagan,Dumaguete City","0906-174-2811","none",R.drawable.bank_eighteen,R.drawable.bank_map_eighteen));
        info_eight_descList.add(new info_eight_desc("SG Bank","Real Street,Dumaguete City","225-4304","none",R.drawable.bank_nineteen,R.drawable.bank_map_nineteen));
        info_eight_descList.add(new info_eight_desc("Philtrust Bank","Foundation Avenue,Dr.Meciano Road,Taclobo,Dumaguete City","522-3233","none",R.drawable.bank_twenty,R.drawable.bank_map_twenty));
        info_eight_descList.add(new info_eight_desc("EastWest Bank","Don Joaquin T.Villegas Building,Colon Street,Dumaguete City","226-3797","none",R.drawable.bank_twenty_one,R.drawable.bank_map_twenty_one_branch_one));
        info_eight_descList.add(new info_eight_desc("Robinsons Bank","Robinsons Place Dumaguete,South Road,Calindagan,Dumaguete City","421-1748","none",R.drawable.bank_twenty_two,R.drawable.bank_map_twenty_two));
        info_eight_descList.add(new info_eight_desc("Landbank","NORECO II Building,Real Street,Dumaguete City", "225-7568|225-4688|420-9055","none",R.drawable.bank_twenty_three,R.drawable.bank_map_twenty_three));
        info_eight_descList.add(new info_eight_desc("Development Bank of the Philippines","Rizal Boulevard,Dumaguete City", "225-4723|225-4338|225-4339|422-9057","none",R.drawable.bank_twenty_four,R.drawable.bank_map_twenty_four));
        info_eight_descList.add(new info_eight_desc("Producer's Bank","Pinili Street,Dumaguete City", "420-9233","none",R.drawable.bank_twenty_five,R.drawable.bank_map_twenty_five));
    }
}