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

public class tourism_info_three extends AppCompatActivity {

    VideoView video_resto;
    ImageButton imgbtn_menu;
    SearchView search_resto;
    RecyclerView recyclerVw_resto;
    info_threeAdapter info_threeAdapter;
    List<info_three_desc> info_three_descList;

    @Override
    protected void onPostResume() {
        video_resto.resume();
        super.onPostResume();
    }

    @Override
    protected void onRestart(){
        video_resto.start();
        super.onRestart();
    }

    @Override
    protected void onPause(){
        video_resto.suspend();
        super.onPause();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        video_resto.stopPlayback();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourism_info_three);
        video_resto = findViewById(R.id.videoVw_restos);
        imgbtn_menu = findViewById(R.id.img_btn_menu);
        search_resto = findViewById(R.id.searchVw_resto);
        recyclerVw_resto = findViewById(R.id.recyclerView_resto);

        Uri uri = Uri.parse("android.resource://" + getPackageName()+"/"+R.raw.resto_portal);
        video_resto.setVideoURI(uri);
        video_resto.start();
        video_resto.setOnPreparedListener(mp -> mp.setLooping(true));

        imgbtn_menu.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"TURISTA INFORMATION MENU PORTAL",Toast.LENGTH_LONG).show();
            startActivity(new Intent(tourism_info_three.this,turista_information_menu_portal.class));
        });

        search_resto.clearFocus();
        search_resto.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
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
        List<info_three_desc> filteredList = new ArrayList<>();
        for(info_three_desc item_resto: info_three_descList){
            if(item_resto.getResto_name().toLowerCase().contains(newText.toLowerCase())){
                filteredList.add(item_resto);
            }
        }
        info_threeAdapter.filterList(filteredList);
    }

    private void setRecyclerView() {
        info_threeAdapter info_threeAdapter = new info_threeAdapter(info_three_descList);
        recyclerVw_resto.setAdapter(info_threeAdapter);
        recyclerVw_resto.setHasFixedSize(true);
    }

    private void initData() {
        info_three_descList = new ArrayList<>();
        info_three_descList.add(new info_three_desc("Tom N Toms Dumaguete","Rizal Boulevard,Dumaguete City","522-9329","https://www.facebook.com/tomntomsduma/",R.drawable.resto_eight, R.drawable.resto_map_eight));
        info_three_descList.add(new info_three_desc("Neva's Pizza","Hibbard Avenue corner Amigo Subdivision,Piapi,Dumaguete City","0917-722-5560","https://www.facebook.com/NevasPizzaDumaguete/",R.drawable.resto_eighteen, R.drawable.resto_map_eighteen));
        info_three_descList.add(new info_three_desc("Mooon Cafe","Silliman Avenue,Dumaguete City","422-6447|422-5109","https://www.facebook.com/mooondgte/",R.drawable.resto_eleven, R.drawable.resto_map_eleven));
        info_three_descList.add(new info_three_desc("Negrense","Noblefranca Street,Dumaguete City","0998-573-6200"," https://www.facebook.com/negrensemicrobrewery/",R.drawable.resto_fifteen, R.drawable.resto_map_fifteen));
        info_three_descList.add(new info_three_desc("Boy Kanin","North National Highway corner East Rovira Road,Dumaguete City","522-0012","https://www.facebook.com/BoyKaninDumaguete/",R.drawable.resto_fifty,R.drawable.resto_map_fifty));
        info_three_descList.add(new info_three_desc("Gerry's Grill","Rizal Boulevard,Dumaguete City","421-2851"," https://www.facebook.com/GerrysGrill.Dumaguete/",R.drawable.resto_fifty_eight,R.drawable.resto_map_fifty_eight));
        info_three_descList.add(new info_three_desc("Hayahay Treehouse Bar and Viewdeck","Flores Avenue,Dumaguete City","none","https://www.facebook.com/HayahayTreehouseBar/",R.drawable.resto_fifty_five,R.drawable.resto_map_fifty_five));
        info_three_descList.add(new info_three_desc("Gabby's Bistro","E.Rovira Drive,Bantayan,Dumaguete City", "422-0827","https://www.facebook.com/gabbysbistro/",R.drawable.resto_fifty_four,R.drawable.resto_map_fifty_four));
        info_three_descList.add(new info_three_desc("Adamo","Tindalo Street,Dumaguete City","0916-552-1626","https://www.facebook.com/adamodumaguete/",R.drawable.resto_fifty_nine,R.drawable.resto_map_fifty_nine));
        info_three_descList.add(new info_three_desc("Cafe Laguna","San Jose Street,Dumaguete City", "421-0808|0919-066-4381","https://www.instagram.com/cafelagunadumaguete/?hl=en | https://www.facebook.com/cafelagunadumaguete/",R.drawable.resto_fifty_one,R.drawable.resto_map_fifty_one));
        info_three_descList.add(new info_three_desc("Gong Cha Dumaguete","Robinsons Place Dumaguete,South Road,Calindagan,Dumaguete City","0998-869-1697","https://www.facebook.com/gongchadgte/",R.drawable.resto_fifty_seven,R.drawable.resto_map_fifty_seven));
        info_three_descList.add(new info_three_desc("Gravitea","Dr.V.Locsin Street,Dumaguete City","0965-173-2418","https://www.facebook.com/GraviTeaPH/",R.drawable.resto_fifty_three,R.drawable.resto_map_fifty_three));
        info_three_descList.add(new info_three_desc("Foodnet Dumaguete","Santa Catalina Street,Dumaguete City", "0942-800-7012","https://www.facebook.com/foodnetrestaurant/",R.drawable.resto_fifty_two,R.drawable.resto_map_fifty_two));
        info_three_descList.add(new info_three_desc("Why Not?","Rizal Boulevard,Dumaguete City","0919-840-2069|422-9209","https://whynotdumaguete.com/ | https://www.facebook.com/WhyNotDumaguete/",R.drawable.resto_five,R.drawable.resto_map_five));
        info_three_descList.add(new info_three_desc("Ana Maria Bakeshop","Perdices Street,Dumaguete City","422-5071","https://m.facebook.com/ana.m.bakeshop/",R.drawable.resto_forty,R.drawable.resto_map_forty));
        info_three_descList.add(new info_three_desc("The Bean Connection","Silliman Avenue,Dumaguete City","225-5666","https://m.facebook.com/206688759488726/",R.drawable.resto_forty_eight,R.drawable.resto_map_forty_eight));
        info_three_descList.add(new info_three_desc("Silliman University Food Services","Hibbard Avenue,Dumaguete City","0935-584-9098","https://www.facebook.com/SillimanCaf/",R.drawable.resto_forty_five,R.drawable.resto_map_forty_five));
        info_three_descList.add(new info_three_desc("Salt and Pepper PH","145 Hibbard Avenue,Bantayan,Dumaguete City", "0906-287-6799","https://www.facebook.com/saltandpepper035/",R.drawable.resto_forty_four,R.drawable.resto_map_forty_four));
        info_three_descList.add(new info_three_desc("Ryu Sushi","South Wing,Northpoint,Escano Beach,Piapi,Dumaguete City","0915-789-1492","https://www.facebook.com/RyuSushiDumaguete/",R.drawable.resto_forty_nine,R.drawable.resto_map_forty_nine));
        info_three_descList.add(new info_three_desc("The Rollin Pin","24 Katada Street,Dumaguete City","420-5076"," https://www.instagram.com/rollingpinph/?hl=en |\n" +"https://www.facebook.com/RollinPinDumaguete/\n",R.drawable.resto_forty_one,R.drawable.resto_map_forty_one));
        info_three_descList.add(new info_three_desc("Scooby's","Silliman Avenue,Dumaguete City","225-5666","https://www.facebook.com/scoobys.dgte/",R.drawable.resto_forty_seven,R.drawable.resto_map_forty_seven));
        info_three_descList.add(new info_three_desc("Roti Boss","Aldecoa Drive,Dumaguete City","0927-710-7773","https://www.facebook.com/curryhousedumaguete/",R.drawable.resto_forty_six,R.drawable.resto_map_forty_six));
        info_three_descList.add(new info_three_desc("Sans Rival Cakes and Pastries","165 San Jose Street corner Rizal Boulevard,Dumaguete City","0918-943-5989","https://www.instagram.com/sansrivalph/?hl=en | https://www.facebook.com/sansrivalcakesandpastries/", R.drawable.resto_forty_three,R.drawable.resto_map_forty_three));
        info_three_descList.add(new info_three_desc("Si,Senor!","Flores Avenue,Dumaguete City"," 0917-506-2151|0977-815-9288","https://www.facebook.com/sisenordgte/ | https://www.instagram.com/sisenordgte/?hl=en",R.drawable.resto_forty_two,R.drawable.resto_map_forty_two));
        info_three_descList.add(new info_three_desc("Yakiniku Japanese Restaurant","Colon Street,Dumaguete City","531-1075","https://m.facebook.com/people/Yakiniku-Hakusan-Dumaguete-City-YHDC/100063858488741/",R.drawable.resto_four,R.drawable.resto_map_four));
        info_three_descList.add(new info_three_desc("Pasta King Cafe di Roma","South Sea Road,Fatima Village,Dumaguete City", "0917-717-9632","https://www.facebook.com/people/Pasta-King-Dumaguete/100064211762639/",R.drawable.resto_fourteen, R.drawable.resto_map_fourteen));
        info_three_descList.add(new info_three_desc("BTJ FoodHouse","Perdices Street,Dumaguete City","225-4797","https://www.facebook.com/BTJFoodHouse/",R.drawable.resto_nine,R.drawable.resto_map_nine));
        info_three_descList.add(new info_three_desc("Arteasan Handcrafted Beverages","Libertad Street,San Juan Street,Dumaguete City", "0956-057-3535","http://www.arteasan.com/ | https://www.facebook.com/Arteasanhandcraftedbeverages/",R.drawable.resto_one,R.drawable.resto_map_one));
        info_three_descList.add(new info_three_desc("Yellow Cab Pizza Co.","Ground Floor,Paseo Perdices Building,Rizal Boulevard,Dumaguete City","421-1111","https://www.facebook.com/YellowCabDumaguete/",R.drawable.resto_seven,R.drawable.resto_map_seven));
        info_three_descList.add(new info_three_desc("Qyosko","Santa Rosa Street,Dumaguete City","523-5613 | 0915-566-3367","https://www.facebook.com/QyoskoDumaguetePH/ | https://www.instagram.com/qyosko_dgte/?hl=en",R.drawable.resto_seventeen,R.drawable.resto_map_seventeen));
        info_three_descList.add(new info_three_desc("Chowking","Perdices Street,Dumaguete City","0920-911-4926","https://www.facebook.com/ckdumaguete.ph/",R.drawable.resto_seventy,R.drawable.resto_map_seventy));
        info_three_descList.add(new info_three_desc("Tinto Restaurant","La Casona Hotel along E.J. Blanco Drive, Dumaguete City","0916-278-6554","https://www.facebook.com/people/Tinto-Restaurant/100063857387533/",R.drawable.resto_six,R.drawable.resto_map_six));
        info_three_descList.add(new info_three_desc("Rago's","Sta.Rosa Street,Dumaguete City","0916-278-6554","none",R.drawable.resto_sixteen,R.drawable.resto_map_sixteen));
        info_three_descList.add(new info_three_desc("Cafe Filomena","Rizal Boulevard,Dumaguete City","422-8000","none",R.drawable.resto_sixty,R.drawable.resto_map_sixty));
        info_three_descList.add(new info_three_desc("Mang Inasal","Robinsons Place Dumaguete,South Road,Calindagan,Dumaguete City"+"Dr. V. Locsin Street corner Real Street,Dumaguete City", " 421-0265|0923-842-1589","none",R.drawable.resto_sixty_eight,R.drawable.resto_map_sixty_eight));
        info_three_descList.add(new info_three_desc("Don Roberto's Bar and Restaurant","Perdices Street,Dumaguete City", "422-7451|225-3909","https://m.facebook.com/people/Don-Robertos-Bar-and-Restaurant/100064148074374/",R.drawable.resto_sixty_five,R.drawable.resto_map_sixty_five));
        info_three_descList.add(new info_three_desc("Cocina Teria","Daang Taytayan,Calindagan,Dumaguete City","422-5896","https://www.facebook.com/casarubincocinateria/",R.drawable.resto_sixty_four,R.drawable.resto_map_sixty_four));
        info_three_descList.add(new info_three_desc("KFC","Robinsons Place Dumaguete,South Road,Calindagan,Dumaguete City", "887-8888","https://www.facebook.com/pages/category/food-beverage/KFC-Robinsons-Dumaguete-1116269405070563/",R.drawable.resto_sixty_nine,R.drawable.resto_map_sixty_nine));
        info_three_descList.add(new info_three_desc("The City Burger","Real Street,Dumaguete City | E.J. Blanco Drive,Piapi,Dumaguete City","0915-412-7043","https://www.facebook.com/CityBurgerDumagueteOfficial/",R.drawable.resto_sixty_one,R.drawable.resto_map_sixty_one));
        info_three_descList.add(new info_three_desc("Mcdonalds","Perdices Street,Dumaguete City","422-7777","none",R.drawable.resto_sixty_seven,R.drawable.resto_map_sixty_seven));
        info_three_descList.add(new info_three_desc("Jollibee","Perdices Street corner San Jose Street, Dumaguete City","422-8502","none",R.drawable.resto_sixty_six,R.drawable.resto_map_sixty_six));
        info_three_descList.add(new info_three_desc("Esturya Tapas and Bar","172 Hibbard Avenue,Tubod,Piapi,Dumaguete City","0917-314-1448","https://www.facebook.com/esturyabarandrestaurant/ |https://www.instagram.com/esturya/?hl=en",R.drawable.resto_sixty_three,R.drawable.resto_map_sixty_three));
        info_three_descList.add(new info_three_desc("Lorenzo's Steak en Deli","121-90 Hibbard Avenue,Piapi,Dumaguete City","0977-851-7112","https://www.facebook.com/DonAtilanoDgte/",R.drawable.resto_sixty_two,R.drawable.resto_map_sixty_two));
        info_three_descList.add(new info_three_desc("Cafe Racer Diner","E.J.Blanco Drive corner Flores Avenue,Dumaguete City","422-6218","https://www.facebook.com/Caferacerdgte/",R.drawable.resto_ten,R.drawable.resto_map_ten));
        info_three_descList.add(new info_three_desc("Qing Hua Town Cuisine","Northpoint,Piapi,Dumaguete City","0992-586-1588","https://m.facebook.com/100063992762371/",R.drawable.resto_thirteen,R.drawable.resto_map_thirteen));
        info_three_descList.add(new info_three_desc("Chin Loong Restaurant","San Jose Street corner Rizal Boulevard,Dumaguete City"," 0928-776-7213","https://www.facebook.com/chinloong.dgte/",R.drawable.resto_thirty,R.drawable.resto_map_thirty));
        info_three_descList.add(new info_three_desc("Sweet Pantry","North Boulevard,Piapi,Dumaguete City| Jose Building,Negros South Road,Calindagan,Dumaguete City","0917-507-6539","https://www.facebook.com/sweetpantrydgte/|https://www.instagram.com/sweet_pantry/?hl=en",R.drawable.resto_thirty_eight,R.drawable.resto_map_thirty_eight));
        info_three_descList.add(new info_three_desc("Sta.Teresa Resto","Hibbard Avenue,Piapi,Dumaguete City","0917-793-1584","https://www.facebook.com/Stateresaofficial.dgte/",R.drawable.resto_thirty_five,R.drawable.resto_map_thirty_five));
        info_three_descList.add(new info_three_desc("Starbucks","39 Rizal Boulevard corner Burgos Street,Dumaguete City","none","none",R.drawable.resto_thirty_five,R.drawable.resto_map_thirty_five));
        info_three_descList.add(new info_three_desc("Sobremesa Restaurant","E.J.Blanco Extension,Claytown,Daro,Dumaguete City", "0917-500-8451","https://www.facebook.com/sobremesadgt/ | https://www.instagram.com/sobremesadgt/?hl=en",R.drawable.resto_thirty_nine,R.drawable.resto_map_thirty_nine));
        info_three_descList.add(new info_three_desc("2 Story Kitchen","Sta.Catalina Street,Dumaguete City","0917-188-5940|420-6384","https://www.facebook.com/2storykitchen/",R.drawable.resto_thirty_one,R.drawable.resto_map_thirty_one));
        info_three_descList.add(new info_three_desc("Soban Korean Restaurant","North Road Highway,Daro Fronting NOPH,Dumaguete City","420-9512","https://www.facebook.com/soban.resto/",R.drawable.resto_thirty_seven,R.drawable.resto_map_thirty_seven));
        info_three_descList.add(new info_three_desc("The Pub Restobar and KTV","Paya Building,Looc Bypass Road,Dumaguete City", "0906-894-9018","https://www.facebook.com/thepubrestobarktv/",R.drawable.resto_thirty_six,R.drawable.resto_map_thirty_six));
        info_three_descList.add(new info_three_desc("Skewers Restaurant and Bar","Tabuc-Tubig,Dumaguete City","0965-110-0735",  "https://www.facebook.com/SkewersDumaguete/",R.drawable.resto_thirty_three,R.drawable.resto_map_thirty_three));
        info_three_descList.add(new info_three_desc("Casablanca Restaurant","Rizal Boulevard,Dumaguete City","0907-300-9708","https://www.facebook.com/dumaguete.casablanca/",R.drawable.resto_thirty_two,R.drawable.resto_map_thirty_two));
        info_three_descList.add(new info_three_desc("Tiffles at Tip Top Tower","South Road,National Highway,Calindagan,Dumaguete City","226-3838","https://www.facebook.com/tiptoptower/posts/tiffles-milk-tea-coffee-blendsmango-avocado-overloadube-cheese-buns-and-moreavai/3243596542408678/\n",R.drawable.resto_three,R.drawable.resto_map_three));
        info_three_descList.add(new info_three_desc("Rice N Box","Amigo Subdivision,Piapi,Dumaguete City","0968-882-7898","https://www.facebook.com/ricenboxduma/",R.drawable.resto_twelve,R.drawable.resto_map_twelve));
        info_three_descList.add(new info_three_desc("Hukad","Robinsons Place Dumaguete,South Road,Calindagan,Dumaguete City", "421-1232","https://www.facebook.com/hukaddgte/",R.drawable.resto_twenty,R.drawable.resto_map_twenty));
        info_three_descList.add(new info_three_desc("Lantaw Native Restaurant","E.J.Blanco Drive corner Flores Avenue,Dumaguete City","421-0473","https://www.facebook.com/lantawdumaguete/",R.drawable.resto_twenty_five,R.drawable.resto_map_twenty_five));
        info_three_descList.add(new info_three_desc("Mifune Japanese Restaurant","Sta.Catalina Street,Dumaguete City","0921-247-8449","https://www.facebook.com/mifunedumaguete/",R.drawable.resto_twenty_four,R.drawable.resto_map_twenty_four));
        info_three_descList.add(new info_three_desc("Cafe Mafioso","Plaza Escano,Escano Beach,Dumaguete City","0917-167-4514","https://www.facebook.com/CafeMafioso/",R.drawable.resto_twenty_nine,R.drawable.resto_map_twenty_nine));
        info_three_descList.add(new info_three_desc("Chantilly Cakehaus","Cimafranca Subdivision,Claytown,Daro,Dumaguete City","225-8356","https://m.facebook.com/Chantilly-Cake-Haus-102871504874474/?ref=py_c",R.drawable.resto_twenty_one, R.drawable.resto_map_twenty_one));
        info_three_descList.add(new info_three_desc("Ichiraku Japanese Authentic Noodle Restaurant","Mabini Street corner Luke Wright Street,Dumaguete City","none","https://www.facebook.com/Ichiraku.Dumaguete/",R.drawable.resto_twenty_seven,R.drawable.resto_map_twenty_seven));
        info_three_descList.add(new info_three_desc("Jet and Jo's Grill House","Northpoint,Piapi,Dumaguete City","422-6352","https://www.facebook.com/jetandjos/",R.drawable.resto_twenty_six,R.drawable.resto_map_twenty_six));
        info_three_descList.add(new info_three_desc("Jo's Chicken Inato","Silliman Avenue,Dumaguete City | Ajong,Sibulan,Negros Oriental","225-4112","https://m.facebook.com/profile.php?id=164069687011452",R.drawable.resto_twenty_three,R.drawable.resto_map_twenty_three));
        info_three_descList.add(new info_three_desc("Dumaguete KBOB Korean Restaurant","240 Northpoint,North Boulevard,Escano Drive,Dumaguete City", "0977-441-1448","https://www.facebook.com/KBOBRestaurant/",R.drawable.resto_twenty_two,R.drawable.resto_map_twenty_two));
        info_three_descList.add(new info_three_desc("Chachago","Beside Star Oil,Piapi,Dumaguete City","0997-440-6841", "https://www.facebook.com/people/Chachago-%E8%8C%B6%E8%8C%B6GO-Dumaguete/100057090084434/",R.drawable.resto_two,R.drawable.resto_map_two));
    }
}
