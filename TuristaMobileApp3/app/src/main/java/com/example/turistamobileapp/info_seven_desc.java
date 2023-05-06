package com.example.turistamobileapp;

public class info_seven_desc {
    private String church_name,church_address,church_phone,church_page;
    private int img_church_photo,img_church_map;

    public info_seven_desc(String church_name, String church_address, String church_phone, String church_page, int img_church_photo, int img_church_map) {
        this.church_name = church_name;
        this.church_address = church_address;
        this.church_phone = church_phone;
        this.church_page = church_page;
        this.img_church_photo = img_church_photo;
        this.img_church_map = img_church_map;
    }

    public String getChurch_name() {
        return church_name;
    }

    public void setChurch_name(String church_name) {
        this.church_name = church_name;
    }

    public String getChurch_address() {
        return church_address;
    }

    public void setChurch_address(String church_address) {
        this.church_address = church_address;
    }

    public String getChurch_phone() {
        return church_phone;
    }

    public void setChurch_phone(String church_phone) {
        this.church_phone = church_phone;
    }

    public String getChurch_page() {
        return church_page;
    }

    public void setChurch_page(String church_page) {
        this.church_page = church_page;
    }

    public int getImg_church_photo() {
        return img_church_photo;
    }

    public void setImg_church_photo(int img_church_photo) {
        this.img_church_photo = img_church_photo;
    }

    public int getImg_church_map() {
        return img_church_map;
    }

    public void setImg_church_map(int img_church_map) {
        this.img_church_map = img_church_map;
    }
}
