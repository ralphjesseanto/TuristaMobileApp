package com.example.turistamobileapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class list_of_tourist_registered_portal extends AppCompatActivity {

    SearchView search_tourist_info;
    ListView list_tourist_info;
    Button admin_button;
    List<TouristRegisteredArrayModel> touristRegisteredArrayModelList;
    ArrayAdapter<TouristInfoAdapter> touristInfoAdapterArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_tourist_registered_portal);

        search_tourist_info = findViewById(R.id.search_list_of_tourist);
        list_tourist_info = findViewById(R.id.listVw_tourist_info);
        admin_button = findViewById(R.id.btn_admin_menu);

        admin_button.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(), "ADMIN MENU PORTAL", Toast.LENGTH_LONG).show();
            startActivity(new Intent(list_of_tourist_registered_portal.this, admin_menu_portal.class));
        });

        touristRegisteredArrayModelList = new ArrayList<>();
        touristRegisteredArrayModelList.add(new TouristRegisteredArrayModel("Ralph Jesse","Anto", "Piapi,Dumaguete City","BOHOL","29","Male","jesseantoralp74@gmail.com",
                "librajchow656ASD@","librajchow656ASD@"));

        touristInfoAdapterArrayAdapter = new ArrayAdapter<>(list_of_tourist_registered_portal.this,android.R.layout.simple_list_item_1);
        list_tourist_info.setAdapter(touristInfoAdapterArrayAdapter);

        search_tourist_info.clearFocus();
        search_tourist_info.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                list_of_tourist_registered_portal.this.touristInfoAdapterArrayAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                touristInfoAdapterArrayAdapter.getFilter().filter(newText);
                return false;
            }
        });
    }
}