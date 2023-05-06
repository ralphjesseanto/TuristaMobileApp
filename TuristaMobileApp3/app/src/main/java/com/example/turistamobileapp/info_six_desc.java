package com.example.turistamobileapp;

public class info_six_desc {
    private String mall_name,mall_address,mall_phone,mall_page;
    private int img_mall,img_map;

    public info_six_desc(String mall_name, String mall_address, String mall_phone, String mall_page, int img_mall, int img_map) {
        this.mall_name = mall_name;
        this.mall_address = mall_address;
        this.mall_phone = mall_phone;
        this.mall_page = mall_page;
        this.img_mall = img_mall;
        this.img_map = img_map;
    }

    public String getMall_name() {
        return mall_name;
    }

    public void setMall_name(String mall_name) {
        this.mall_name = mall_name;
    }

    public String getMall_address() {
        return mall_address;
    }

    public void setMall_address(String mall_address) {
        this.mall_address = mall_address;
    }

    public String getMall_phone() {
        return mall_phone;
    }

    public void setMall_phone(String mall_phone) {
        this.mall_phone = mall_phone;
    }

    public String getMall_page() {
        return mall_page;
    }

    public void setMall_page(String mall_page) {
        this.mall_page = mall_page;
    }

    public int getImg_mall() {
        return img_mall;
    }

    public void setImg_mall(int img_mall) {
        this.img_mall = img_mall;
    }

    public int getImg_map() {
        return img_map;
    }

    public void setImg_map(int img_map) {
        this.img_map = img_map;
    }
}
