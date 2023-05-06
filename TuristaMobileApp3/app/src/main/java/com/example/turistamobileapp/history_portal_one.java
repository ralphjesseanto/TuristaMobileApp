package com.example.turistamobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

public class history_portal_one extends AppCompatActivity {

    ImageButton menu_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_portal_one);
        menu_button = findViewById(R.id.img_btn_menu);
        menu_button.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"TURISTA HISTORY MENU PORTAL",Toast.LENGTH_LONG).show();
            startActivity(new Intent(history_portal_one.this,turista_history_menu_portal.class));
        });
    }
}