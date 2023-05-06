package com.example.turistamobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.VideoView;

public class tourism_info_ten extends AppCompatActivity {

    VideoView videoVw_tourist_spot;
    ImageButton btn_menu;
    Button btn_prev,btn_next;
    ImageSwitcher imgsw_spots;
    private final int[] spots={R.drawable.tourist_spot_two,R.drawable.tourist_spot_one,R.drawable.spot_ninety_nine,R.drawable.spot_ninety_eight,
            R.drawable.spot_ninety_seven,R.drawable.spot_ninety_six,R.drawable.spot_ninety_five,R.drawable.spot_ninety_four,
            R.drawable.spot_ninety_three, R.drawable.spot_ninety_two,R.drawable.spot_ninety_one,R.drawable.spot_ninety,
            R.drawable.spot_eighty_nine,R.drawable.spot_eighty_eight,R.drawable.spot_eighty_seven,R.drawable.spot_eighty_six,
            R.drawable.spot_eighty_five,R.drawable.spot_eighty_four,R.drawable.spot_eighty_three,R.drawable.spot_eighty_two,
            R.drawable.spot_eighty_one,R.drawable.spot_eighty,R.drawable.spot_seventy_nine,R.drawable.spot_seventy_eight,
            R.drawable.spot_eighty_seven,R.drawable.spot_eighty_six,R.drawable.spot_seventy_five,R.drawable.spot_seventy_four,
            R.drawable.spot_seventy_three,R.drawable.spot_seventy_two,R.drawable.spot_seventy_one,R.drawable.spot_seventy,
            R.drawable.spot_sixty_nine,R.drawable.spot_sixty_eight,R.drawable.spot_sixty_seven,R.drawable.spot_sixty_six,
            R.drawable.spot_sixty_five,R.drawable.spot_sixty_four,R.drawable.spot_sixty_three,R.drawable.spot_sixty_two,
            R.drawable.spot_sixty_one,R.drawable.spot_sixty,R.drawable.spot_fifty_nine,R.drawable.spot_fifty_eight,
            R.drawable.spot_fifty_seven,R.drawable.spot_fifty_six,R.drawable.spot_fifty_four,R.drawable.spot_fifty_three,
            R.drawable.spot_fifty_two,R.drawable.spot_fifty_one,R.drawable.spot_fifty,R.drawable.spot_forty_nine,
            R.drawable.spot_forty_eight, R.drawable.spot_forty_seven,R.drawable.spot_forty_six,R.drawable.spot_forty_five,
            R.drawable.spot_forty_four,R.drawable.spot_forty_three,R.drawable.spot_forty_two,R.drawable.spot_forty_one,
            R.drawable.spot_forty,R.drawable.spot_thirty_nine,R.drawable.spot_thirty_eight,R.drawable.spot_thirty_seven,
            R.drawable.spot_thirty_six,R.drawable.spot_thirty_five,R.drawable.spot_thirty_four,R.drawable.spot_thirty_three,
            R.drawable.spot_thirty_two,R.drawable.spot_thirty_one,R.drawable.spot_thirty,R.drawable.spot_twenty_nine,
            R.drawable.spot_twenty_eight,R.drawable.spot_twenty_seven,R.drawable.spot_twenty_six,R.drawable.spot_twenty_five,
            R.drawable.spot_twenty_four,R.drawable.spot_twenty_three,R.drawable.spot_twenty_two,R.drawable.spot_twenty_one,
            R.drawable.spot_twenty,R.drawable.spot_nineteen,R.drawable.spot_eighteen,R.drawable.spot_seventeen,
            R.drawable.spot_sixteen,R.drawable.spot_fifteen,R.drawable.spot_fourteen,R.drawable.spot_thirteen,
            R.drawable.spot_twelve,R.drawable.spot_eleven,R.drawable.spot_ten,R.drawable.spot_nine,
            R.drawable.spot_eight,R.drawable.spot_seven,R.drawable.spot_six,R.drawable.spot_five,
            R.drawable.spot_four,R.drawable.spot_three,R.drawable.spot_two,R.drawable.spot_one};

    private int position_tourist=0;

    @Override
    protected void onPostResume() {
        videoVw_tourist_spot.resume();
        super.onPostResume();
    }

    @Override
    protected void onRestart(){
        videoVw_tourist_spot.start();
        super.onRestart();
    }

    @Override
    protected void onPause(){
        videoVw_tourist_spot.suspend();
        super.onPause();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        videoVw_tourist_spot.stopPlayback();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourism_info_ten);
        btn_menu = findViewById(R.id.img_btn_menu);
        btn_prev = findViewById(R.id.btn_prev_spot);
        btn_next = findViewById(R.id.btn_next_spot);
        imgsw_spots = findViewById(R.id.imgSw_tourist_spot);

        Uri uri = Uri.parse("android.resource://" + getPackageName()+"/"+R.raw.tourist_spots);
        videoVw_tourist_spot.setVideoURI(uri);
        videoVw_tourist_spot.start();
        videoVw_tourist_spot.setOnPreparedListener(mp -> mp.setLooping(true));

        btn_menu.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"TOURIST MENU PORTAL",Toast.LENGTH_LONG).show();
            startActivity(new Intent(tourism_info_ten.this,turista_information_menu_portal.class));
        });

        imgsw_spots.setFactory(() -> {
            ImageView imgVw_tourist_spot=new ImageView(tourism_info_ten.this);
            imgVw_tourist_spot.setImageResource(spots[position_tourist]);
            return imgVw_tourist_spot;
        });

        imgsw_spots.setInAnimation(this,android.R.anim.fade_in);
        imgsw_spots.setOutAnimation(this, android.R.anim.fade_out);

        btn_prev.setOnClickListener(v -> {
            if(position_tourist>0)
                position_tourist--;
            else if(position_tourist<0)
                position_tourist=0;
            imgsw_spots.setImageResource(spots[position_tourist]);
        });

        btn_next.setOnClickListener(v -> {
            if(position_tourist<spots.length)
                position_tourist++;
            if(position_tourist>=spots.length)
                position_tourist=spots.length-1;
            imgsw_spots.setImageResource(spots[position_tourist]);
        });
    }
}
