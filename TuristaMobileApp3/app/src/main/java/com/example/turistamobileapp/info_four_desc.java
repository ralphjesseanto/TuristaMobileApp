package com.example.turistamobileapp;

public class info_four_desc {
    private String school_name,school_address,school_contact_number,school_page_link_one,school_page_link_two;
    private int img_school_photo,img_school_map;

    public info_four_desc(String school_name, String school_address, String school_contact_number, String school_page_link_one, String school_page_link_two, int img_school_photo, int img_school_map) {
        this.school_name = school_name;
        this.school_address = school_address;
        this.school_contact_number = school_contact_number;
        this.school_page_link_one = school_page_link_one;
        this.school_page_link_two = school_page_link_two;
        this.img_school_photo = img_school_photo;
        this.img_school_map = img_school_map;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public String getSchool_address() {
        return school_address;
    }

    public void setSchool_address(String school_address) {
        this.school_address = school_address;
    }

    public String getSchool_contact_number() {
        return school_contact_number;
    }

    public void setSchool_contact_number(String school_contact_number) {
        this.school_contact_number = school_contact_number;
    }

    public String getSchool_page_link_one() {
        return school_page_link_one;
    }

    public void setSchool_page_link_one(String school_page_link_one) {
        this.school_page_link_one = school_page_link_one;
    }

    public String getSchool_page_link_two() {
        return school_page_link_two;
    }

    public void setSchool_page_link_two(String school_page_link_two) {
        this.school_page_link_two = school_page_link_two;
    }

    public int getImg_school_photo() {
        return img_school_photo;
    }

    public void setImg_school_photo(int img_school_photo) {
        this.img_school_photo = img_school_photo;
    }

    public int getImg_school_map() {
        return img_school_map;
    }

    public void setImg_school_map(int img_school_map) {
        this.img_school_map = img_school_map;
    }
}
