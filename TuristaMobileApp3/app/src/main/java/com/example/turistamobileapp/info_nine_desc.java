package com.example.turistamobileapp;

public class info_nine_desc {
    private String port_name,port_address,port_phone;
    private int img_port,img_map;

    public info_nine_desc(String port_name, String port_address, String port_phone, int img_port, int img_map) {
        this.port_name = port_name;
        this.port_address = port_address;
        this.port_phone = port_phone;
        this.img_port = img_port;
        this.img_map = img_map;
    }

    public String getPort_name() {
        return port_name;
    }

    public void setPort_name(String port_name) {
        this.port_name = port_name;
    }

    public String getPort_address() {
        return port_address;
    }

    public void setPort_address(String port_address) {
        this.port_address = port_address;
    }

    public String getPort_phone() {
        return port_phone;
    }

    public void setPort_phone(String port_phone) {
        this.port_phone = port_phone;
    }

    public int getImg_port() {
        return img_port;
    }

    public void setImg_port(int img_port) {
        this.img_port = img_port;
    }

    public int getImg_map() {
        return img_map;
    }

    public void setImg_map(int img_map) {
        this.img_map = img_map;
    }
}
