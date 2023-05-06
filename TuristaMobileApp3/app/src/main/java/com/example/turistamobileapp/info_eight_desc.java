package com.example.turistamobileapp;

public class info_eight_desc {
    private  String name_bank,bank_address,bank_contact_number,bank_page;
    private  int photo_bank,img_bank_map;

    public info_eight_desc(String name_bank, String bank_address, String bank_contact_number, String bank_page, int photo_bank, int img_bank_map) {
        this.name_bank = name_bank;
        this.bank_address = bank_address;
        this.bank_contact_number = bank_contact_number;
        this.bank_page = bank_page;
        this.photo_bank = photo_bank;
        this.img_bank_map = img_bank_map;
    }

    public String getName_bank() {
        return name_bank;
    }

    public void setName_bank(String name_bank) {
        this.name_bank = name_bank;
    }

    public String getBank_address() {
        return bank_address;
    }

    public void setBank_address(String bank_address) {
        this.bank_address = bank_address;
    }

    public String getBank_contact_number() {
        return bank_contact_number;
    }

    public void setBank_contact_number(String bank_contact_number) {
        this.bank_contact_number = bank_contact_number;
    }

    public String getBank_page() {
        return bank_page;
    }

    public void setBank_page(String bank_page) {
        this.bank_page = bank_page;
    }

    public int getPhoto_bank() {
        return photo_bank;
    }

    public void setPhoto_bank(int photo_bank) {
        this.photo_bank = photo_bank;
    }

    public int getImg_bank_map() {
        return img_bank_map;
    }

    public void setImg_bank_map(int img_bank_map) {
        this.img_bank_map = img_bank_map;
    }
}
