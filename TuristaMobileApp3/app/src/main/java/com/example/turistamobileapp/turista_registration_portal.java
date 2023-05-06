package com.example.turistamobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.VideoView;

public class turista_registration_portal extends AppCompatActivity {

    VideoView video_turista_registration;
    EditText fname,lname,address,place_of_origin,age,gender,username,password,cpassword;
    Button turista_cancel,turista_submit;

    @Override
    protected void onPostResume() {
        video_turista_registration.resume();
        super.onPostResume();
    }

    @Override
    protected void onRestart(){
        video_turista_registration.start();
        super.onRestart();
    }

    @Override
    protected void onPause(){
        video_turista_registration.suspend();
        super.onPause();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        video_turista_registration.stopPlayback();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turista_registration_portal);

        fname = findViewById(R.id.edit_firstname);
        lname = findViewById(R.id.edit_lastname);
        address = findViewById(R.id.edit_address);
        place_of_origin = findViewById(R.id.edit_place_of_origin);
        age = findViewById(R.id.edit_age);
        gender = findViewById(R.id.edit_gender);
        username = findViewById(R.id.edit_turista_username);
        password = findViewById(R.id.edit_turista_password);
        cpassword = findViewById(R.id.edit_turista_cpassword);

        turista_cancel = findViewById(R.id.btn_cancel);
        turista_submit = findViewById(R.id.btn_submit);

        Uri uri = Uri.parse("android.resource://" + getPackageName()+"/"+R.raw.video_turista);
        video_turista_registration.setVideoURI(uri);
        video_turista_registration.start();
        video_turista_registration.setOnPreparedListener(mp -> mp.setLooping(true));

        turista_cancel.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"TURISTA CANCEL",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(turista_registration_portal.this,turista_login_portal.class));
        });

        turista_submit.setOnClickListener(v -> {
            GlobalVariables.firstname = fname.getText().toString();
            GlobalVariables.lastname  = lname.getText().toString();
            GlobalVariables.address   = address.getText().toString();
            GlobalVariables.place_of_origin = place_of_origin.getText().toString();
            GlobalVariables.age = age.getText().toString();
            GlobalVariables.gender = gender.getText().toString();
            GlobalVariables.username = username.getText().toString();
            GlobalVariables.password = password.getText().toString();
            GlobalVariables.cpassword = cpassword.getText().toString();
            Toast.makeText(getApplicationContext(),"TURISTA INFORMATION REGISTERED",Toast.LENGTH_LONG).show();
            Intent gotoTuristaInfo = new Intent(turista_registration_portal.this,list_of_tourist_registered_portal.class);
            startActivity(gotoTuristaInfo);
        });
    }
}