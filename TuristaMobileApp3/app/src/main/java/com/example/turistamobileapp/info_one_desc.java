package com.example.turistamobileapp;

public class info_one_desc {
    private String name_hotel,hotel_address,hotel_contact_number,hotel_url_link;
    private int img_photo_hotel,img_map_hotel;

    public info_one_desc(String name_hotel, String hotel_address, String hotel_contact_number, String hotel_url_link, int img_photo_hotel, int img_map_hotel) {
        this.name_hotel = name_hotel;
        this.hotel_address = hotel_address;
        this.hotel_contact_number = hotel_contact_number;
        this.hotel_url_link = hotel_url_link;
        this.img_photo_hotel = img_photo_hotel;
        this.img_map_hotel = img_map_hotel;
    }

    public String getName_hotel() {
        return name_hotel;
    }

    public void setName_hotel(String name_hotel) {
        this.name_hotel = name_hotel;
    }

    public String getHotel_address() {
        return hotel_address;
    }

    public void setHotel_address(String hotel_address) {
        this.hotel_address = hotel_address;
    }

    public String getHotel_contact_number() {
        return hotel_contact_number;
    }

    public void setHotel_contact_number(String hotel_contact_number) {
        this.hotel_contact_number = hotel_contact_number;
    }

    public String getHotel_url_link() {
        return hotel_url_link;
    }

    public void setHotel_url_link(String hotel_url_link) {
        this.hotel_url_link = hotel_url_link;
    }

    public int getImg_photo_hotel() {
        return img_photo_hotel;
    }

    public void setImg_photo_hotel(int img_photo_hotel) {
        this.img_photo_hotel = img_photo_hotel;
    }

    public int getImg_map_hotel() {
        return img_map_hotel;
    }

    public void setImg_map_hotel(int img_map_hotel) {
        this.img_map_hotel = img_map_hotel;
    }
}
