package com.example.turistamobileapp;

public class info_five_desc {
    private String hospital_name,hospital_address,hospital_contact_number,hospital_page;
    private int img_hospital_photo,img_hospital_map;

    public info_five_desc(String hospital_name, String hospital_address, String hospital_contact_number, String hospital_page, int img_hospital_photo, int img_hospital_map) {
        this.hospital_name = hospital_name;
        this.hospital_address = hospital_address;
        this.hospital_contact_number = hospital_contact_number;
        this.hospital_page = hospital_page;
        this.img_hospital_photo = img_hospital_photo;
        this.img_hospital_map = img_hospital_map;
    }

    public String getHospital_name() {
        return hospital_name;
    }

    public void setHospital_name(String hospital_name) {
        this.hospital_name = hospital_name;
    }

    public String getHospital_address() {
        return hospital_address;
    }

    public void setHospital_address(String hospital_address) {
        this.hospital_address = hospital_address;
    }

    public String getHospital_contact_number() {
        return hospital_contact_number;
    }

    public void setHospital_contact_number(String hospital_contact_number) {
        this.hospital_contact_number = hospital_contact_number;
    }

    public String getHospital_page() {
        return hospital_page;
    }

    public void setHospital_page(String hospital_page) {
        this.hospital_page = hospital_page;
    }

    public int getImg_hospital_photo() {
        return img_hospital_photo;
    }

    public void setImg_hospital_photo(int img_hospital_photo) {
        this.img_hospital_photo = img_hospital_photo;
    }

    public int getImg_hospital_map() {
        return img_hospital_map;
    }

    public void setImg_hospital_map(int img_hospital_map) {
        this.img_hospital_map = img_hospital_map;
    }
}
