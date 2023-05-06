package com.example.turistamobileapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class turista_fun_facts_portal extends AppCompatActivity {

    VideoView videoVw_facts;
    ImageButton btn_menu;
    TextView textVw_facts;
    Button btn_prev,btn_next;
    ImageSwitcher imgsw_facts;
    private final int[ ]facts={R.drawable.facts_image_thirty_two,R.drawable.facts_image_nine,R.drawable.facts_image_eleven,
            R.drawable.facts_image_eighteen,R.drawable.facts_image_sixteen,R.drawable.facts_image_twelve,
            R.drawable.facts_image_ten,R.drawable.facts_image_twenty_six,R.drawable.facts_image_six,
            R.drawable.facts_twenty,R.drawable.facts_fourteen,R.drawable.facts_image_seven,
            R.drawable.facts_image_twenty_nine,R.drawable.facts_eighteen,R.drawable.facts_image_twenty_eight,
            R.drawable.facts_image_five,R.drawable.facts_twenty_five,R.drawable.facts_nineteen,
            R.drawable.facts_image_nineteen,R.drawable.facts_image_thirty_three,R.drawable.facts_image_twenty,
            R.drawable.facts_image_seventeen,R.drawable.facts_image_thirty_one,R.drawable.facts_one,
            R.drawable.facts_image_fourteen,R.drawable.facts_sixteen,R.drawable.facts_ten,
            R.drawable.facts_thirteen,R.drawable.facts_twenty_two,R.drawable.facts_seventeen,
            R.drawable.facts_seven,R.drawable.facts_image_three,R.drawable.facts_twelve,
            R.drawable.facts_image_thirteen,R.drawable.facts_image_thirty,R.drawable.facts_three,
            R.drawable.facts_image_thirty_four,R.drawable.facts_twenty_one,R.drawable.facts_image_twenty_one,
            R.drawable.facts_image_thirty_five,R.drawable.facts_image_fifteen,R.drawable.facts_image_twenty_three,
            R.drawable.facts_twenty_four,R.drawable.facts_image_twenty_five,R.drawable.facts_image_twenty_two,
            R.drawable.facts_image_twenty_seven,R.drawable.facts_image_twenty_four,R.drawable.facts_twenty_seven,
            R.drawable.facts_image_two,R.drawable.facts_four,R.drawable.facts_eleven,
            R.drawable.facts_nine,R.drawable.facts_eight,R.drawable.facts_twenty_nine,
            R.drawable.facts_five,R.drawable.facts_twenty_six,R.drawable.facts_thirty,
            R.drawable.facts_thirty_three,R.drawable.facts_thirty_four,R.drawable.facts_thirty_five,
            R.drawable.facts_two,R.drawable.facts_image_four,R.drawable.facts_six,
            R.drawable.facts_thirty_two,R.drawable.facts_twenty_three,R.drawable.facts_thirty_one,
            R.drawable.facts_twenty_eight,R.drawable.facts_image_eight,R.drawable.facts_image_one,
            R.drawable.facts_fifteen};

    private int position_facts=0;

    @Override
    protected void onPostResume() {
        videoVw_facts.resume();
        super.onPostResume();
    }

    @Override
    protected void onRestart(){
        videoVw_facts.start();
        super.onRestart();
    }

    @Override
    protected void onPause(){
        videoVw_facts.suspend();
        super.onPause();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        videoVw_facts.stopPlayback();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turista_fun_facts_portal);

        videoVw_facts = findViewById(R.id.video_facts);
        btn_menu =findViewById(R.id.img_btn_menu);
        textVw_facts = findViewById(R.id.textVw_facts);
        btn_prev =findViewById(R.id.btn_facts_prev);
        btn_next =findViewById(R.id.btn_facts_next);
        imgsw_facts = findViewById(R.id.imgsw_facts);

        Uri uri = Uri.parse("android.resource://" + getPackageName()+"/"+R.raw.video_turista);
        videoVw_facts.setVideoURI(uri);
        videoVw_facts.start();
        videoVw_facts.setOnPreparedListener(mp -> mp.setLooping(true));

        btn_menu.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"TURISTA MENU PORTAL",Toast.LENGTH_LONG).show();
            startActivity(new Intent(turista_fun_facts_portal.this,turista_main_menu_portal.class));
        });

        imgsw_facts.setFactory(() -> {
            ImageView imgVw_facts=new ImageView(turista_fun_facts_portal.this);
            imgVw_facts.setImageResource(facts[position_facts]);
            return imgVw_facts;
        });

        imgsw_facts.setInAnimation(this,android.R.anim.fade_in);
        imgsw_facts.setOutAnimation(this, android.R.anim.fade_out);

        btn_prev.setOnClickListener(v -> {
            if(position_facts>0)
                position_facts--;
            else if(position_facts<0)
                position_facts=0;
            imgsw_facts.setImageResource(facts[position_facts]);
        });

        btn_next.setOnClickListener(v -> {
            if(position_facts<facts.length)
                position_facts++;
            if(position_facts>=facts.length)
                position_facts=facts.length-1;
            imgsw_facts.setImageResource(facts[position_facts]);
        });
    }
}
