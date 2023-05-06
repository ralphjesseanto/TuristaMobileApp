package com.example.turistamobileapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class turista_list_of_barangay extends AppCompatActivity {
    ImageButton turista_menu;
    ExpandableListViewBarangay listViewBarangay;
    ExpandableListView expandableListView;
    List<String> list_barangay;
    HashMap<String,List<String>> list_barangay_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turista_list_of_barangay);
        turista_menu = findViewById(R.id.img_btn_menu);
        expandableListView = findViewById(R.id.expanded_list_barangay);
        turista_menu.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"HISTORY MENU PORTAL",Toast.LENGTH_LONG).show();
            startActivity(new Intent(turista_list_of_barangay.this,turista_history_menu_portal.class));
        });
        show_list();
        listViewBarangay = new ExpandableListViewBarangay(this,list_barangay,list_barangay_name);
        expandableListView.setAdapter(listViewBarangay);
    }

    private void show_list() {
        list_barangay = new ArrayList<>();
        list_barangay_name = new HashMap<>();

        list_barangay.add("DUMAGUETE CITY");
        list_barangay.add("MUNICIPALITY OF SIBULAN");
        list_barangay.add("MUNICIPALITY OF BACONG");
        list_barangay.add("MUNICIPALITY OF VALENCIA");

        List<String> name_barangay_one = new ArrayList<>();
        name_barangay_one.add("Barangay One: Tinago");
        name_barangay_one.add("Barangay Two: Upper Luke Wright");
        name_barangay_one.add("Barangay Three:Colon Extension");
        name_barangay_one.add("Barangay Four:Rizal Boulevard");
        name_barangay_one.add("Barangay Five:Silliman Avenue");
        name_barangay_one.add("Barangay Six:Cambagroy");
        name_barangay_one.add("Barangay Seven:Mangga");
        name_barangay_one.add("Barangay Eight:Cervantes Street");
        name_barangay_one.add("Bagacay");
        name_barangay_one.add("Bajumpandan");
        name_barangay_one.add("Balugo");
        name_barangay_one.add("Banilad");
        name_barangay_one.add("Bantayan");
        name_barangay_one.add("Batinguel");
        name_barangay_one.add("Bunao");
        name_barangay_one.add("Cadawinonan");
        name_barangay_one.add("Calindagan");
        name_barangay_one.add("Camanjac");
        name_barangay_one.add("Candau-ay");
        name_barangay_one.add("Cantil-e");
        name_barangay_one.add("Daro");
        name_barangay_one.add("Junob");
        name_barangay_one.add("Looc");
        name_barangay_one.add("Mangnao Canal");
        name_barangay_one.add("Motong");
        name_barangay_one.add("Piapi");
        name_barangay_one.add("Pulantubig");
        name_barangay_one.add("Tabuc-Tubig");
        name_barangay_one.add("Taclobo");
        name_barangay_one.add("Talay");

        List<String> name_barangay_two = new ArrayList<>();
        name_barangay_two.add("Agan-an");
        name_barangay_two.add("Ajong");
        name_barangay_two.add("Balugo");
        name_barangay_two.add("Boloc-boloc");
        name_barangay_two.add("Calabnugan");
        name_barangay_two.add("Cangmating");
        name_barangay_two.add("Enrique Villanueva");
        name_barangay_two.add("Looc");
        name_barangay_two.add("Magatas");
        name_barangay_two.add("Maningcao");
        name_barangay_two.add("Maslog");
        name_barangay_two.add("Poblacion");
        name_barangay_two.add("San Antonio");
        name_barangay_two.add("Tubigon");
        name_barangay_two.add("Tubtubon");

        List<String> name_barangay_three = new ArrayList<>();
        name_barangay_three.add("Balayagmanok");
        name_barangay_three.add("Banilad");
        name_barangay_three.add("Buntis");
        name_barangay_three.add("Buntod");
        name_barangay_three.add("Calangag");
        name_barangay_three.add("Combado");
        name_barangay_three.add("Doldol");
        name_barangay_three.add("Isugan");
        name_barangay_three.add("Liptong");
        name_barangay_three.add("Lutao");
        name_barangay_three.add("Magsuhot");
        name_barangay_three.add("Malabago");
        name_barangay_three.add("Mampas");
        name_barangay_three.add("North Poblacion");
        name_barangay_three.add("Sacsac");
        name_barangay_three.add("San Miguel");
        name_barangay_three.add("South Poblacion");
        name_barangay_three.add("Sulodpan");
        name_barangay_three.add("Timbanga");
        name_barangay_three.add("Timbao");
        name_barangay_three.add("Tubod");
        name_barangay_three.add("West Poblacion");

        List<String> name_barangay_four = new ArrayList<>();
        name_barangay_four.add("Apolong");
        name_barangay_four.add("East Balabag");
        name_barangay_four.add("West Balabag");
        name_barangay_four.add("Balayagmanok");
        name_barangay_four.add("Balili");
        name_barangay_four.add("Balugo");
        name_barangay_four.add("Bongbong");
        name_barangay_four.add("Bong-ao");
        name_barangay_four.add("Calayugan");
        name_barangay_four.add("Cambucad");
        name_barangay_four.add("Dobdob");
        name_barangay_four.add("Jawa");
        name_barangay_four.add("Caidiocan");
        name_barangay_four.add("Liptong");
        name_barangay_four.add("Lunga");
        name_barangay_four.add("Malabo");
        name_barangay_four.add("Malaunay");
        name_barangay_four.add("Mampas");
        name_barangay_four.add("Palinpinon");
        name_barangay_four.add("North Poblacion");
        name_barangay_four.add("South Poblacion");
        name_barangay_four.add("Puhagan");
        name_barangay_four.add("Pulangbato");
        name_barangay_four.add("Sagbang");

        list_barangay_name.put(list_barangay.get(0),name_barangay_one);
        list_barangay_name.put(list_barangay.get(1),name_barangay_two);
        list_barangay_name.put(list_barangay.get(2),name_barangay_three);
        list_barangay_name.put(list_barangay.get(3),name_barangay_four);
    }
}