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

public class tourism_info_one extends AppCompatActivity {

    SearchView search_hotels;
    RecyclerView recyclerVw_hotels;
    List<info_one_desc> info_one_descList;
    info_oneAdapter info_oneAdapter;
    VideoView videoVw_hotel;
    ImageButton imgbtn_menu;

    @Override
    protected void onPostResume() {
        videoVw_hotel.resume();
        super.onPostResume();
    }

    @Override
    protected void onRestart() {
        videoVw_hotel.start();
        super.onRestart();
    }

    @Override
    protected void onPause() {
        videoVw_hotel.suspend();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        videoVw_hotel.stopPlayback();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourism_info_one);
        search_hotels = findViewById(R.id.searchVw_hotels);
        recyclerVw_hotels = findViewById(R.id.recyclerView_hotel);
        videoVw_hotel = findViewById(R.id.video_hotel);
        imgbtn_menu = findViewById(R.id.img_btn_menu);

        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.hotel_portal);
        videoVw_hotel.setVideoURI(uri);
        videoVw_hotel.start();
        videoVw_hotel.setOnPreparedListener(mp -> mp.setLooping(true));

        imgbtn_menu.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(), "TOURIST INFORMATION PORTAL MENU", Toast.LENGTH_LONG).show();
            startActivity(new Intent(tourism_info_one.this, turista_information_menu_portal.class));
        });

        search_hotels.clearFocus();
        search_hotels.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
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
        List<info_one_desc> filteredList = new ArrayList<>();
        for (info_one_desc item_hotel : info_one_descList) {
            if (item_hotel.getName_hotel().toLowerCase().contains(newText.toLowerCase())) {
                filteredList.add(item_hotel);
            }
        }
        info_oneAdapter.filterList(filteredList);
    }

    private void setRecyclerView() {
        info_oneAdapter info_oneAdapter = new info_oneAdapter(info_one_descList);
        recyclerVw_hotels.setAdapter(info_oneAdapter);
        recyclerVw_hotels.setHasFixedSize(true);
    }

    private void initData() {
        info_one_descList = new ArrayList<>();
        info_one_descList.add(new info_one_desc("Fiesole Residence Inn", "San Juan Street,Dumaguete City", "0917-116-1706", "https://www.fiesole.com.ph", R.drawable.eight_hotel, R.drawable.eight_map_hotel));
        info_one_descList.add(new info_one_desc("Marina Residences", "Seaside Homes, E.J. Blanco Drive,Piapi,Dumaguete City", "0917-722-3006|0917-587-2418", "https://www.marinaresidences.com.ph", R.drawable.eighteen_hotel, R.drawable.eighteen_map_hotel));
        info_one_descList.add(new info_one_desc("Hotel Nicanor", "San Jose Street,Dumaguete City", "226-3330|421-0787|0922-889-4911", "https://www.hotelnicanor.com", R.drawable.eighty_eight_hotel, R.drawable.eighty_eight_map_hotel));
        info_one_descList.add(new info_one_desc("32 Rovira Residences", "L.Rovira Road,Bantayan,Dumaguete City", "421-1698|0918-933-1019", "none", R.drawable.eighty_four_hotel, R.drawable.eighty_four_map_hotel));
        info_one_descList.add(new info_one_desc("Hotel La Casona", "E.J.Blanco Drive,Dumaguete City", "0917-707-0090|422-8688", "none", R.drawable.eighty_hotel, R.drawable.eighty_map_hotel));
        info_one_descList.add(new info_one_desc("AMRU Gateway Residences", "E.J.Blanco Extension,Daro,Dumaguete City", "422-5889|226-4073", "https://www.amrugateway.com", R.drawable.eighty_one_hotel, R.drawable.eighty_one_map_hotel));
        info_one_descList.add(new info_one_desc("Sunshine Villa", "Bunao Road,Dumaguete City", "0916-385-1128", "none", R.drawable.eighty_seven_hotel, R.drawable.eighty_seven_map_hotel));
        info_one_descList.add(new info_one_desc("SouthView Hotel", "National Highway Lamberto Macias Road,Dumaguete City", "421-5678|421-1010|421-2020|0915-725-5085|0933-801-8868", "none", R.drawable.eighty_three_hotel, R.drawable.eighty_three_map_hotel));
        info_one_descList.add(new info_one_desc("Tip Top Tower", "South National Highway,Calindagan,Dumaguete City", "226-3838|0918-926-6332|0923-690-0738", "https://www.tiptoptower.com", R.drawable.eighty_two_hotel, R.drawable.eighty_two_map_hotel));
        info_one_descList.add(new info_one_desc("Emman Hotel", "Tubod,Hibbard Avenue,Dumaguete City", "422-3886|0995-101-1670", "https://www.emmanhotel.com", R.drawable.eleven_hotel, R.drawable.eleven_map_hotel));
        info_one_descList.add(new info_one_desc("Coco Grande Hotel", "Hibbard Avenue,Dumaguete City", "225-0833|422-0746", "https://www.cocograndehotel.com", R.drawable.fifteen_hotel, R.drawable.fifteen_map_hotel));
        info_one_descList.add(new info_one_desc("The U Pension", "Silliman Avenue,Dumaguete City", "422-6794|0925-862-3795", "none", R.drawable.fifty_five_hotel, R.drawable.fifty_five_map_hotel));
        info_one_descList.add(new info_one_desc("Casa Bianca", "Bunao,Dumaguete City", "0918-933-1019|0917-504-3606", "none", R.drawable.fifty_four_hotel, R.drawable.fifty_four_map_hotel));
        info_one_descList.add(new info_one_desc("Heart Hotel", "Perdices Street corner Luke Wright Street,Dumaguete City", "0920-948-1525", "none", R.drawable.fifty_hotel, R.drawable.fifty_map_hotel));
        info_one_descList.add(new info_one_desc("Charo's Dormitel", "E.J.Blanco Extension,Daro,Dumaguete City", "422-6136|0945-436-7968", "https://www.charosdormitel.business.site", R.drawable.fifty_nine_hotel, R.drawable.fifty_nine_map_hotel));
        info_one_descList.add(new info_one_desc("Check Inn Pension Arcade", "POS Marketing Building,Dr.V.Locsin Street,Dumaguete City", "422-9000|0928-613-2595", "https://www.checkinn.com.ph/checkinndumaguete.php", R.drawable.fifty_one_hotel, R.drawable.fifty_one_map_hotel));
        info_one_descList.add(new info_one_desc("Henia Hotel", "LEU Building,corner E.Surban and Real Streets,Dumaguete City", "421-2375|0917-839-3253", "https://www.heniahoteldumaguete.com", R.drawable.fifty_seven_hotel, R.drawable.fifty_seven_map_hotel));
        info_one_descList.add(new info_one_desc("Sulit Budget Hotel", "71 East Rovira Drive,Dumaguete City", "0936-390-3173", "https://www.sulitdormitel.com.ph", R.drawable.fifty_six_hotel, R.drawable.fifty_six_map_hotel));
        info_one_descList.add(new info_one_desc("Antwet Backpacker's Inn", "Capitol Area,Dumaguete City", "0922-297-4134", "none", R.drawable.fifty_two_hotel, R.drawable.fifty_two_map_hotel));
        info_one_descList.add(new info_one_desc("Gazebo Pensionne", "Jose Pro Teves Street", "2250579", "https://www.gazebopensionnehouse.com",R.drawable.five_hotel, R.drawable.five_map_hotel));
        info_one_descList.add(new info_one_desc("The Flying Fish Hostel", "32 Bantayan,Hibbard Avenue,Dumaguete City", "422-0167", "https://www.flyingfishph.wixsite.com/hostel", R.drawable.forty_eight_hotel, R.drawable.forty_eight_map_hotel));
        info_one_descList.add(new info_one_desc("C and L Suites Inn", "485 Perdices Street corner Pinili Street,Dumaguete City", "4229671", "none", R.drawable.forty_five_hotel, R.drawable.forty_five_map_hotel));
        info_one_descList.add(new info_one_desc("Go Hotel Dumaguete", "Calindagan Road corner South Road,Dumaguete City", "522-1102|522-1100", "https://www.gohotels.ph", R.drawable.forty_four_hotel, R.drawable.forty_four_map_hotel));
        info_one_descList.add(new info_one_desc("Villa Prescilla", "24 E.J. Blanco Drive,Dumaguete City", "0906-221-7631", "https://www.villaprescilla.com", R.drawable.forty_hotel, R.drawable.forty_map_hotel));
        info_one_descList.add(new info_one_desc("Grand Pensionne Plaza", "San Jose Street, Dumaguete City", "0932-777-0601|522-1728|422-6876|225-1577", "none", R.drawable.forty_nine_hotel, R.drawable.forty_nine_map_hotel));
        info_one_descList.add(new info_one_desc("Housereef", "Silveria Drive,Bantayan,Dumaguete City", "422-8056|0927-686-3690|0932-886-7716", "https://www.housereef.ph", R.drawable.forty_one_hotel, R.drawable.forty_one_map_hotel));
        info_one_descList.add(new info_one_desc("Plaza Maria Luisa Suites Inn", "Locsin Building,Legaspi Street,Dumaguete City", "522-1003", "none", R.drawable.forty_seven_hotel, R.drawable.forty_seven_map_hotel));
        info_one_descList.add(new info_one_desc("Dumaguete Dormitel", "B.T. Locsin Building,Silliman Avenue,Dumaguete City", "421-0337", "none", R.drawable.forty_six_hotel, R.drawable.forty_six_map_hotel));
        info_one_descList.add(new info_one_desc("Hotel Palwa", "Dr.V.Locsin Street corner Real Street,Dumaguete City", "422-1492|422-8995|226-7775", "https://www.hotelpalwa.com", R.drawable.forty_three_hotel, R.drawable.forty_three_map_hotel));
        info_one_descList.add(new info_one_desc("Aberrise Pension Hotel", "St.Raymund Street,Ma.Asuncion Village,Daro,Dumaguete City", "422-8428|0956-762-2156|0943-534-3509", "https://www.aberrise.com", R.drawable.forty_two_hotel, R.drawable.forty_two_map_hotel));
        info_one_descList.add(new info_one_desc("Dumaguete Royal Suite Inn", "L.Rovira Road,Bantayan,Dumaguete City", "225-2197", "https://www.dgteroyalsuiteinn.wixsite.com/home", R.drawable.four_hotel, R.drawable.four_map_hotel));
        info_one_descList.add(new info_one_desc("Yoo C Apartment", "La Sola Drive, Piapi,Dumaguete City", "0935-756-4894", "none", R.drawable.fourteen_hotel, R.drawable.fourteen_map_hotel));
        info_one_descList.add(new info_one_desc("Sierra Hotel", "E.J.Blanco Drive,Dumaguete City", "420-9621|0917-502-3407", "https://www.sierrahotelandresort.com", R.drawable.nine_hotel, R.drawable.nine_map_hotel));
        info_one_descList.add(new info_one_desc("Seis Hostel", "585 San Jose Extension,Dumaguete City", "0956-398-2627", "none", R.drawable.nineteen_hotel, R.drawable.nineteen_map_hotel));
        info_one_descList.add(new info_one_desc("Sam's Bed and Breakfast", "Mayflower House,Neorunco Road,Kalubihan,Dumaguete City", "0977-620-5513", "none", R.drawable.one_hotel, R.drawable.one_map_hotel));
        info_one_descList.add(new info_one_desc("C and L Bayview Inn", "Sen. Lorenzo G. Teves Street,Dumaguete City", "226-3648|421-0696", "https://www.clhotel.com.ph", R.drawable.seven_hotel, R.drawable.seven_map_hotel));
        info_one_descList.add(new info_one_desc("The Pattern Lodge", "Pinero Subdivision,Hibbard Avenue,Dumaguete City", "0917-300-2746|0998-555-9019", "none", R.drawable.seventeen_hotel, R.drawable.seventeen_map_hotel));
        info_one_descList.add(new info_one_desc("Bravo Hotel", "Pancil,Looc,Sibulan,Negros Oriental", "0917-300-5574", "https://www.bravohotelph.com", R.drawable.seventy_eight_hotel, R.drawable.seventy_eight_map_hotel));
        info_one_descList.add(new info_one_desc("Vintage Inn", "E & J Limquiaco Building,Bishop Epifanio Surban Street,Dumaguete City", "225-1076|422-9106|4228822", "none", R.drawable.seventy_four_hotel, R.drawable.seventy_four_map_hotel));
        info_one_descList.add(new info_one_desc("Hermogina Apartments", "National Highway,South Road,Calindagan,Dumaguete City", "0917-329-3479|420-9375", "https://www.ehikarus.com", R.drawable.seventy_hotel, R.drawable.seventy_map_hotel));
        info_one_descList.add(new info_one_desc("O.K. Pensionne House", "Santa Rosa Street,Dumaguete City", "225-5702|422-7731", "none", R.drawable.seventy_nine_hotel, R.drawable.seventy_nine_map_hotel));
        info_one_descList.add(new info_one_desc("Obdulia's Business Inn", "Gov.Perdices Street corner Pinili and Colon Streets, Dumaguete City", "226-3291", "https://www.obduliashotel.com", R.drawable.seventy_one_hotel, R.drawable.seventy_one_map_hotel));
        info_one_descList.add(new info_one_desc("RM Guest House", "2/F RM Building,North National Highway corner East Rovira Road,Bantayan,Dumaguete City", "422-4000|226-4000|0936-711-5201|0910-227-5446", "none", R.drawable.seventy_seven_hotel, R.drawable.seventy_seven_map_hotel));
        info_one_descList.add(new info_one_desc("Camlann Cottages", "Kilometer 6,Jose Romero Road,Talay,Dumaguete City", "522-2343", "none", R.drawable.seventy_six_hotel, R.drawable.seventy_six_map_hotel));
        info_one_descList.add(new info_one_desc("Bethel Guest House", "Rizal Avenue,Dumaguete City", "225-2000|422-8000|0917-320-1484", "https://www.bethelguesthouse.com", R.drawable.seventy_three_hotel, R.drawable.seventy_three_map_hotel));
        info_one_descList.add(new info_one_desc("Florentina Homes", "East Rovira Drive,Bantayan,Dumaguete City", "422-0827|0929-796-9653", "https://www.florentinahomes.com", R.drawable.seventy_two_hotel, R.drawable.seventy_two_map_hotel));
        info_one_descList.add(new info_one_desc("Casa Rubin", "Perdices Street,Daan Taytayan,Calindagan,Dumaguete City", "422-5896", "https://www.casarubin.com", R.drawable.six_hotel, R.drawable.six_map_hotel));
        info_one_descList.add(new info_one_desc("Honey Suites Inn", "40-A Hibbard Avenue,Dumaguete City", "0935-951-6802", "none", R.drawable.sixteen_hotel, R.drawable.sixteen_map_hotel));
        info_one_descList.add(new info_one_desc("WorldView Pension Plaza", "Perdices Street,Dumaguete City", "225-4110|422-8369|0926-122-8436|0918-408-9444", "none", R.drawable.sixty_eight_hotel, R.drawable.sixty_eight_map_hotel));
        info_one_descList.add(new info_one_desc("Kingswick Residences and Lodge", "Purok Cebasca,Bagacay,Dumaguete City", "0905-938-8531", "https://www.kingswick.net", R.drawable.sixty_four_hotel, R.drawable.sixty_four_map_hotel));
        info_one_descList.add(new info_one_desc("Opena's Hotel", "18 Katada Street,Dumaguete City", "421-0048|225-0595|225-5214", "none", R.drawable.sixty_nine_hotel, R.drawable.sixty_nine_map_hotel));
        info_one_descList.add(new info_one_desc("Golden Gates Suites", "Dr.V.Locsin Street,Dumaguete City", "226-4088|0917-304-1012", "https://www.goldengatesuites.com", R.drawable.sixty_one_hotel, R.drawable.sixty_one_map_hotel));
        info_one_descList.add(new info_one_desc("One Bethany Place", "E.J.Blanco Drive,Dumaguete City", "0922-829-7737", "https://www.onebethanyplace.com", R.drawable.sixty_seven_hotel, R.drawable.sixty_seven_map_hotel));
        info_one_descList.add(new info_one_desc("Pamela's Pension House", "Hibbard Avenue,Tubod,Dumaguete City", "421-0783", "none", R.drawable.sixty_six_hotel, R.drawable.sixty_six_map_hotel));
        info_one_descList.add(new info_one_desc("Harold's Mansion", "205 Hibbard Avenue,Dumaguete City", "522-0144|422-3477|0917-302-4455|0939-925-6322", "https://www.haroldsmansion.com", R.drawable.sixty_three_hotel, R.drawable.sixty_three_map_hotel));
        info_one_descList.add(new info_one_desc("The Pethouse Dumaguete", "Lot.14-15,Block 19,Sto.Rosario Heights,Junob,Dumaguete City", "0917-310-4900", "none", R.drawable.sixty_two_hotel, R.drawable.sixty_two_map_hotel));
        info_one_descList.add(new info_one_desc("Hassaram Courtyard", "Amigo Road,Dumaguete City", "0917-825-2946", "https://www.hassaramproperties.com", R.drawable.thirteen_hotel, R.drawable.thirteen_map_hotel));
        info_one_descList.add(new info_one_desc("Dumaguete Springs Apartel", "Valencia Road,Lower Bagacay,Dumaguete City", "422-4284|0935-601-8946", "https://www.dumaguetesprings.com", R.drawable.thirty_eight_hotel, R.drawable.thirty_eight_map_hotel));
        info_one_descList.add(new info_one_desc("PHCCI Hostel", "San Jose Extension,Taclobo,Dumaguete City", "422-1454", "https://www.phcci.coop", R.drawable.thirty_five_hotel, R.drawable.thirty_five_map_hotel));
        info_one_descList.add(new info_one_desc("Rovira Suites", "L.Rovira Road,Dumaguete City", "420-6041", "https://www.rovirasuites.com", R.drawable.thirty_four_hotel, R.drawable.thirty_four_map_hotel));
        info_one_descList.add(new info_one_desc("Casa Arrieta", "142 Hibbard Avenue,Dumaguete City", "0917-532-4543", "https://www.casaarrietahostel.wordpress.com", R.drawable.thirty_hotel, R.drawable.thirty_map_hotel));
        info_one_descList.add(new info_one_desc("Hotel Essencia", "#39 Mayor Ramon T. Pastor Sr.Street,Dumaguete City", "422-1376|422-1137|0917-700-7735", "https://www.hotel-essencia.com", R.drawable.thirty_nine_hotel, R.drawable.thirty_nine_map_hotel));
        info_one_descList.add(new info_one_desc("The Henry Resort", "Flores Avenue,Bantayan,Dumaguete City", "522-5070", "https://www.dumaguete.thehenryhotel.com", R.drawable.thirty_one_hotel, R.drawable.thirty_one_map_hotel));
        info_one_descList.add(new info_one_desc("WOW Hotel", "Hibbard Avenue,Dumaguete City", "420-9214|0915-349-1132", "none", R.drawable.thirty_seven_hotel, R.drawable.thirty_seven_map_hotel));
        info_one_descList.add(new info_one_desc("Dastraum Guest House", "No.130 San Jose Extension,Taclobo,Dumaguete City", "0917-429-0299", "none", R.drawable.thirty_three_hotel, R.drawable.thirty_three_map_hotel));
        info_one_descList.add(new info_one_desc("Ese House", "House no.18,Bayanihan Village,Motong,Larena Drive,Dumaguete City", "0927-970-7806", "none", R.drawable.thirty_two_hotel, R.drawable.thirty_two_map_hotel));
        info_one_descList.add(new info_one_desc("Honeycomb Tourist Inn", "Rizal Boulevard corner Dr.V.Locsin Street,Dumaguete City", "225-1181|225-1182" + "422-3184|0905-341-5634", "https://www.honeycombtouristinn.com", R.drawable.three_hotel, R.drawable.three_map_hotel));
        info_one_descList.add(new info_one_desc("Anabelle Residence", "Taclobo,Dumaguete City", "0936-731-4303", "none", R.drawable.twelve_hotel, R.drawable.twelve_map_hotel));
        info_one_descList.add(new info_one_desc("Marpas Apartments", "Tejero Road,West Balabag,Valencia,Negros Oriental", "0927-673-2272", "https://www.dumagueteapartmentrentals.com", R.drawable.twenty_eight_hotel, R.drawable.twenty_eight_map_hotel));
        info_one_descList.add(new info_one_desc("Circumnavigation Century Inn", "Sta.Rosa Street,Dumaguete City", "0927-816-6669", "none", R.drawable.twenty_five_hotel, R.drawable.twenty_five_map_hotel));
        info_one_descList.add(new info_one_desc("Z Pension", "Sta.Rosa Street,Dumaguete City", "421-5110", "none", R.drawable.twenty_four_hotel, R.drawable.twenty_four_map_hotel));
        info_one_descList.add(new info_one_desc("Gabby's Bed and Breakfast", "Cimafranca Subdivision,Claytown,Daro,Dumaguete City", "522-2203|0906-328-3374", "none", R.drawable.twenty_hotel, R.drawable.twenty_map_hotel));
        info_one_descList.add(new info_one_desc("Dino Residences", "North Road corner Silveria Drive,Bantayan,Dumaguete City", "522-7490", "https://www.dinoresidences@gmail.com", R.drawable.twenty_nine_hotel, R.drawable.twenty_nine_map_hotel));
        info_one_descList.add(new info_one_desc("Blue Horizon", "West Aldecoa Drive,Daro,Dumaguete City", "421-0441|0997-711-7775|0942-316-7755", "https://www.bluehorizonhostel.com", R.drawable.twenty_one_hotel, R.drawable.twenty_one_map_hotel));
        info_one_descList.add(new info_one_desc("Amazi Homestay", "South National Highway,Tabuc-Tubig,Dumaguete City", "0956-170-7362", "none", R.drawable.twenty_seven_hotel, R.drawable.twenty_seven_map_hotel));
        info_one_descList.add(new info_one_desc("The Bricks Hotel", "Rizal Boulevard,Dumaguete City", "422-6215|0917-192-5189|0936-927-0638", "https://www.thebrickshotel.ph", R.drawable.twenty_six_hotel, R.drawable.twenty_six_map_hotel));
        info_one_descList.add(new info_one_desc("Harimariz Dormitel", "Purok Sto.Nino,Bunao,Dumaguete City", "0905-737-8070|0933-070-8102", "none", R.drawable.twenty_three_hotel, R.drawable.twenty_three_map_hotel));
        info_one_descList.add(new info_one_desc("Casa Florencia", "Luke Wright Street,Dumaguete City", "0917-781-1086", "https://www.casaflorencia.com", R.drawable.twenty_two_hotel, R.drawable.twenty_two_map_hotel));
        info_one_descList.add(new info_one_desc("Mission Inn", "Pinero Village,Hibbard Avenue,Dumaguete City", "0917-551-1818", "https://www.missioninndumaguete.com", R.drawable.two_hotel, R.drawable.two_map_hotel));
    }
}
