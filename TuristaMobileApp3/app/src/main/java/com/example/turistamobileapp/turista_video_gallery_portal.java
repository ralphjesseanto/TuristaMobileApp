package com.example.turistamobileapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import java.util.ArrayList;

public class turista_video_gallery_portal extends AppCompatActivity {

    VideoView videoVw_video_portal;
    TextView text_gallery,text_video_gallery;
    ArrayList<String> video_list;
    ArrayAdapter<String> adapt;
    ImageButton btn_menu;
    ListView videos;
    VideoView viewvideo;

    @Override
    protected void onPostResume() {
        videoVw_video_portal.resume();
        super.onPostResume();
    }

    @Override
    protected void onRestart(){
        videoVw_video_portal.start();
        super.onRestart();
    }

    @Override
    protected void onPause(){
        videoVw_video_portal.suspend();
        super.onPause();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        videoVw_video_portal.stopPlayback();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turista_video_gallery_portal);

        videoVw_video_portal =findViewById(R.id.videoVw_gallery);
        btn_menu = findViewById(R.id.img_btn_menu);
        videos = findViewById(R.id.list_videos);
        text_gallery = findViewById(R.id.textVw_gallery);
        text_video_gallery = findViewById(R.id.textVw_video_gallery);
        viewvideo = findViewById(R.id.videosVw);

        Uri uri = Uri.parse("android.resource://" + getPackageName()+"/"+R.raw.video_turista);
        videoVw_video_portal.setVideoURI(uri);
        videoVw_video_portal.start();
        videoVw_video_portal.setOnPreparedListener(mp -> mp.setLooping(true));

        btn_menu.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"TOURIST MENU PORTAL",Toast.LENGTH_LONG).show();
            startActivity(new Intent(turista_video_gallery_portal.this,turista_gallery_menu_portal.class));
        });

        video_list = new ArrayList<>();
        video_list.add("Terra Cotta Heritage of Dumaguete City");
        video_list.add("Celebrate Life in Dumaguete");
        video_list.add("Everyday Dumaguete");
        video_list.add("Welcome to the City of Everyday Enchantments");
        video_list.add("A Remembrance of a Buzzing Dumaguete by Ned Solis");
        video_list.add("Huanying!");
        video_list.add("Sandurot Festival 2019 Highlights");
        video_list.add("Dug-ab Collective");
        video_list.add("Mag-Kisaw Ta 2019 Video");
        video_list.add("Responsible Travel in Dumaguete");
        video_list.add("A History of Buglasan Festival");
        video_list.add("Welcome to Negros Oriental");
        video_list.add("Dula Ta Bai in Dumaguete");
        video_list.add("Biyahe ni Drew in Negros Oriental");
        video_list.add("Ligiron Racing in Valencia");
        video_list.add("Dumaguete in 64 Seconds");
        video_list.add("iJuander: Dumaguete,The City of Gentle People");
        video_list.add("iJuander: Foodtrip sa Dumaguete");
        video_list.add("iJuander: Mga Pagkaing International, Patok na patok sa Dumaguete");
        video_list.add("Biyahe ni Drew: Mga Pagkain na Matitikman sa Dumaguete City, Alamin");
        video_list.add("Biyahe ni Drew: Dumaguete Then and Now");
        video_list.add("Dumaguete, Philippines");
        video_list.add("Lakwatsero sa Dumaguete");
        video_list.add("Dumaguete Philippines-Where to go in Dumaguete");
        video_list.add("Rizal Boulevard in Dumaguete City");
        video_list.add("Mag-Sandurot Ta!");
        video_list.add("Dumaguete City-Clips from the Rizal Boulevard");
        video_list.add("Silliman University in Dumaguete City");
        video_list.add("Sunday Market in Valencia, Negros Oriental");
        video_list.add("#Dumaguete with the Historical Marker of Panilongon");
        video_list.add("Drive Around Going to Valencia, Negros Oriental");
        video_list.add("Valencia, Negros Oriental");
        video_list.add("Buglasan Festival 2022-Dumaguete City-Sandurot Festival(Showdown)");
        video_list.add("Buglasan Festival 2022-Valencia,Negros Oriental-Puhag Festival 2022(Showdown)");
        video_list.add("Japanese Shrine in Valencia, Negros Oriental");
        video_list.add("Forest Camp in Valencia, Negros Oriental");
        video_list.add("Pulangbato Falls in Valencia, Negros Oriental");
        video_list.add("Casaroro Falls in Valencia, Negros Oriental");
        video_list.add("Dumaguete Cathedral and Belfry");
        video_list.add("Negros Oriental");

        adapt = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, video_list);
        videos.setAdapter(adapt);
        videos.setOnItemClickListener((parent, view, position, id) -> {
            switch (position) {
                case 0:
                    viewvideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_one));
                    break;

                case 1:
                    viewvideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_two));
                    break;

                case 2:
                    viewvideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_three));
                    break;

                case 3:
                    viewvideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_four));
                    break;

                case 4:
                    viewvideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_five));
                    break;

                case 5:
                    viewvideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_six));
                    break;

                case 6:
                    viewvideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_seven));
                    break;

                case 7:
                    viewvideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_eight));
                    break;

                case 8:
                    viewvideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_nine));
                    break;

                case 9:
                    viewvideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_ten));
                    break;

                case 10:
                    viewvideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_eleven));
                    break;

                case 11:
                    viewvideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_twelve));
                    break;

                case 12:
                    viewvideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_thirteen));
                    break;

                case 13:
                    viewvideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_fourteen));
                    break;

                case 14:
                    viewvideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_fifteen));
                    break;

                case 15:
                    viewvideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_sixteen));
                    break;

                case 16:
                    viewvideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_seventeen));
                    break;

                case 17:
                    viewvideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_eighteen));
                    break;

                case 18:
                    viewvideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_nineteen));
                    break;

                case 19:
                    viewvideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_twenty));
                    break;

                case 20:
                    viewvideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_twenty_one));
                    break;

                case 21:
                    viewvideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_twenty_two));
                    break;

                case 22:
                    viewvideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_twenty_three));
                    break;

                case 23:
                    viewvideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_twenty_four));
                    break;

                case 24:
                    viewvideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_twenty_five));
                    break;

                case 25:
                    viewvideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_twenty_six));
                    break;

                case 26:
                    viewvideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_twenty_seven));
                    break;

                case 27:
                    viewvideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_twenty_eight));
                    break;

                case 28:
                    viewvideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_twenty_nine));
                    break;

                case 29:
                    viewvideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_thirty));
                    break;

                case 30:
                    viewvideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_thirty_one));
                    break;

                case 31:
                    viewvideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_thirty_two));
                    break;

                case 32:
                    viewvideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_thirty_three));
                    break;

                case 33:
                    viewvideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_thirty_four));
                    break;

                case 34:
                    viewvideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_thirty_five));
                    break;

                case 35:
                    viewvideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_thirty_six));
                    break;

                case 36:
                    viewvideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_thirty_seven));
                    break;

                case 37:
                    viewvideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_thirty_eight));
                    break;

                case 38:
                    viewvideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_thirty_nine));
                    break;

                case 39:
                    viewvideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_forty));
                    break;

                default:
                    break;
            }
            viewvideo.setMediaController(new MediaController(turista_video_gallery_portal.this));
            viewvideo.requestFocus();
            viewvideo.start();
        });
    }
}
