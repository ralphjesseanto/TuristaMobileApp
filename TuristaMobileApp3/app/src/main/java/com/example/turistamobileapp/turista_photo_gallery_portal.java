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

public class turista_photo_gallery_portal extends AppCompatActivity {

    VideoView videoVw_photo_portal;
    ImageButton btn_menu;
    TextView text_gallery_portal,text_photo_gallery;
    ImageSwitcher imgsw_photo;
    Button photo_prev,photo_next;

    private final int[] photo={R.drawable.old_photo_forty_two,R.drawable.old_photo_forty_one,R.drawable.old_photo_forty,
            R.drawable.old_photo_thirty_nine,R.drawable.old_photo_thirty_eight,R.drawable.old_photo_thirty_seven,
            R.drawable.old_photo_thirty_six,R.drawable.old_photo_thirty_five,R.drawable.old_photo_thirty_four,
            R.drawable.old_photo_thirty_three,R.drawable.old_photo_thirty_two,R.drawable.old_photo_thirty_one,
            R.drawable.old_photo_thirty,R.drawable.old_photo_twenty_nine,R.drawable.old_photo_twenty_eight,
            R.drawable.old_photo_twenty_seven,R.drawable.old_photo_twenty_six,R.drawable.old_photo_twenty_five,
            R.drawable.old_photo_twenty_four,R.drawable.old_photo_twenty_three,R.drawable.old_photo_twenty_three,
            R.drawable.old_photo_twenty_two,R.drawable.old_photo_twenty_one,R.drawable.old_photo_twenty,
            R.drawable.old_photo_nineteen,R.drawable.old_photo_eighteen,R.drawable.old_photo_seventeen,
            R.drawable.old_photo_sixteen,R.drawable.old_photo_fifteen,R.drawable.old_photo_fourteen,
            R.drawable.old_photo_thirteen,R.drawable.old_photo_twelve,R.drawable.old_photo_eleven,
            R.drawable.old_photo_ten,R.drawable.old_photo_nine,R.drawable.old_photo_eight,
            R.drawable.old_photo_seven,R.drawable.old_photo_six,R.drawable.old_photo_five,
            R.drawable.old_photo_four,R.drawable.old_photo_three,R.drawable.old_photo_two,
            R.drawable.old_photo_one};

    private int position_photo=0;

    @Override
    protected void onPostResume() {
        videoVw_photo_portal.resume();
        super.onPostResume();
    }

    @Override
    protected void onRestart(){
        videoVw_photo_portal.start();
        super.onRestart();
    }

    @Override
    protected void onPause(){
        videoVw_photo_portal.suspend();
        super.onPause();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        videoVw_photo_portal.stopPlayback();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turista_photo_gallery_portal);

        videoVw_photo_portal = findViewById(R.id.video_photo_gallery);
        btn_menu = findViewById(R.id.img_btn_menu);
        text_gallery_portal = findViewById(R.id.textVw_gallery_portal);
        text_photo_gallery = findViewById(R.id.textVw_photo_gallery);
        imgsw_photo = findViewById(R.id.imgSw_photo);
        photo_prev = findViewById(R.id.btn_photo_prev);
        photo_next = findViewById(R.id.btn_photo_next);

        Uri uri = Uri.parse("android.resource://" + getPackageName()+"/"+R.raw.video_turista);
        videoVw_photo_portal.setVideoURI(uri);
        videoVw_photo_portal.start();
        videoVw_photo_portal.setOnPreparedListener(mp -> mp.setLooping(true));

        btn_menu.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"TOURIST MENU PORTAL",Toast.LENGTH_LONG).show();
            startActivity(new Intent(turista_photo_gallery_portal.this,turista_gallery_menu_portal.class));
        });

        imgsw_photo.setFactory(() -> {
            ImageView imgVw_photo=new ImageView(turista_photo_gallery_portal.this);
            imgVw_photo.setImageResource(photo[position_photo]);
            return imgVw_photo;
        });

        imgsw_photo.setInAnimation(this,android.R.anim.fade_in);
        imgsw_photo.setOutAnimation(this, android.R.anim.fade_out);

        photo_prev.setOnClickListener(v -> {
            if(position_photo>0)
                position_photo--;
            else if(position_photo<0)
                position_photo=0;
            imgsw_photo.setImageResource(photo[position_photo]);
        });

        photo_next.setOnClickListener(v -> {
            if(position_photo<photo.length)
                position_photo++;
            if(position_photo>=photo.length)
                position_photo=photo.length-1;
            imgsw_photo.setImageResource(photo[position_photo]);
        });
    }
}