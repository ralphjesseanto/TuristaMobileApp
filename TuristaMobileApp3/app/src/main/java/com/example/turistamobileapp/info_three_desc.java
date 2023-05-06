package com.example.turistamobileapp;

public class info_three_desc {
    private String resto_name,resto_address,resto_contact_number,resto_page_link;
    private int img_resto,img_map_resto;

    public info_three_desc(String resto_name, String resto_address, String resto_contact_number, String resto_page_link, int img_resto, int img_map_resto) {
        this.resto_name = resto_name;
        this.resto_address = resto_address;
        this.resto_contact_number = resto_contact_number;
        this.resto_page_link = resto_page_link;
        this.img_resto = img_resto;
        this.img_map_resto = img_map_resto;
    }

    public String getResto_name() {
        return resto_name;
    }

    public void setResto_name(String resto_name) {
        this.resto_name = resto_name;
    }

    public String getResto_address() {
        return resto_address;
    }

    public void setResto_address(String resto_address) {
        this.resto_address = resto_address;
    }

    public String getResto_contact_number() {
        return resto_contact_number;
    }

    public void setResto_contact_number(String resto_contact_number) {
        this.resto_contact_number = resto_contact_number;
    }

    public String getResto_page_link() {
        return resto_page_link;
    }

    public void setResto_page_link(String resto_page_link) {
        this.resto_page_link = resto_page_link;
    }

    public int getImg_resto() {
        return img_resto;
    }

    public void setImg_resto(int img_resto) {
        this.img_resto = img_resto;
    }

    public int getImg_map_resto() {
        return img_map_resto;
    }

    public void setImg_map_resto(int img_map_resto) {
        this.img_map_resto = img_map_resto;
    }
}
