package com.example.turistamobileapp;

public class TouristRegisteredArrayModel {
    private final String firstname,lastname,place_of_origin,age,gender,username,password,confirm_password;
    private final String address;

    public TouristRegisteredArrayModel(String firstname, String lastname, String place_of_origin, String age, String gender, String username, String password, String confirm_password, String address) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.place_of_origin = place_of_origin;
        this.age = age;
        this.gender = gender;
        this.username = username;
        this.password = password;
        this.confirm_password = confirm_password;
        this.address = address;
    }

    public String getFirstname() {
        return firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public String getAddress() {
        return address;
    }
    public String getPlace_of_origin() {
        return place_of_origin;
    }
    public String getGender() {
        return gender;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getConfirm_password() {
        return confirm_password;
    }
    public String getAge() {
        return age;
    }
}
