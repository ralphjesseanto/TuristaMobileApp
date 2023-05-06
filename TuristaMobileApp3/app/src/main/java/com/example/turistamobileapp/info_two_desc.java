package com.example.turistamobileapp;

public class info_two_desc {
    private String resort_name,resort_address,resort_phone,resort_page;
    private int img_resort_photo,img_resort_map;

    public info_two_desc(String resort_name, String resort_address, String resort_phone, String resort_page, int img_resort_photo, int img_resort_map) {
        this.resort_name = resort_name;
        this.resort_address = resort_address;
        this.resort_phone = resort_phone;
        this.resort_page = resort_page;
        this.img_resort_photo = img_resort_photo;
        this.img_resort_map = img_resort_map;
    }

    public String getResort_name() {
        return resort_name;
    }

    public void setResort_name(String resort_name) {
        this.resort_name = resort_name;
    }

    public String getResort_address() {
        return resort_address;
    }

    public void setResort_address(String resort_address) {
        this.resort_address = resort_address;
    }

    public String getResort_phone() {
        return resort_phone;
    }

    public void setResort_phone(String resort_phone) {
        this.resort_phone = resort_phone;
    }

    public String getResort_page() {
        return resort_page;
    }

    public void setResort_page(String resort_page) {
        this.resort_page = resort_page;
    }

    public int getImg_resort_photo() {
        return img_resort_photo;
    }

    public void setImg_resort_photo(int img_resort_photo) {
        this.img_resort_photo = img_resort_photo;
    }

    public int getImg_resort_map() {
        return img_resort_map;
    }

    public void setImg_resort_map(int img_resort_map) {
        this.img_resort_map = img_resort_map;
    }
}
