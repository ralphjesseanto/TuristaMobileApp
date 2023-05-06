package com.example.turistamobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.VideoView;

public class turista_login_portal extends AppCompatActivity {

    VideoView video_login_portal;
    EditText turista_username,turista_password;
    Button turista_cancel,turista_new_register,turista_submit;

    @Override
    protected void onPostResume() {
        video_login_portal.resume();
        super.onPostResume();
    }

    @Override
    protected void onRestart(){
        video_login_portal.start();
        super.onRestart();
    }

    @Override
    protected void onPause(){
        video_login_portal.suspend();
        super.onPause();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        video_login_portal.stopPlayback();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turista_login_portal);

        video_login_portal =findViewById(R.id.videoVw_turista_login);
        turista_username = findViewById(R.id.edit_username);
        turista_password = findViewById(R.id.edit_password);
        turista_cancel = findViewById(R.id.btn_cancel);
        turista_new_register = findViewById(R.id.btn_new_register);
        turista_submit = findViewById(R.id.btn_submit);

        Uri uri = Uri.parse("android.resource://" + getPackageName()+"/"+R.raw.video_turista);
        video_login_portal.setVideoURI(uri);
        video_login_portal.start();
        video_login_portal.setOnPreparedListener(mp -> mp.setLooping(true));

        turista_cancel.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"TURISTA CANCEL",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(turista_login_portal.this,MainActivity.class));
        });

        turista_new_register.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"NEW TURISTA REGISTRATION",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(turista_login_portal.this,turista_registration_portal.class));
        });

        turista_submit.setOnClickListener(v -> {
            if(turista_username.getText().toString().equals(GlobalVariables.username) && turista_password.getText().toString().equals(GlobalVariables.password)){
                Toast.makeText(getApplicationContext(),"LOGIN SUCCESSFULLY",Toast.LENGTH_LONG).show();
                openTuristaMenu();
            }else{
                Toast.makeText(getApplicationContext(),"TURISTA USERNAME AND PASSWORD INVALID",Toast.LENGTH_LONG).show();
            }

        });
    }
    private void openTuristaMenu() {
        Intent gotoTuristaMenu = new Intent(turista_login_portal.this,turista_main_menu_portal.class);
        startActivity(gotoTuristaMenu);
    }
}
