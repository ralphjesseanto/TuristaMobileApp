package com.example.turistamobileapp;

public class info_eleven_desc {
    private String tourism_hub_name,address,contact_number,page;

    public info_eleven_desc(String tourism_hub_name, String address, String contact_number, String page) {
        this.tourism_hub_name = tourism_hub_name;
        this.address = address;
        this.contact_number = contact_number;
        this.page = page;
    }

    public String getTourism_hub_name() {
        return tourism_hub_name;
    }

    public void setTourism_hub_name(String tourism_hub_name) {
        this.tourism_hub_name = tourism_hub_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
}
