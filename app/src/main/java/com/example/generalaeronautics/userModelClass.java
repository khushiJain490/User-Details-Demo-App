package com.example.generalaeronautics;


public class userModelClass {

    private int id;
    private String name;
    private String username;
    private String email;
    private addressModelClass address;
    private String phone;
    private String website;
    private String bs;
    private CompanyModelClass company;



    public userModelClass(int id, String name, String username, String email, addressModelClass address, String phone, String website, CompanyModelClass company) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.website = website;
        this.company = company;
    }

    public String getBs() {
        return bs;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }

    public userModelClass(String bs) {
        this.bs = bs;
    }

    public int getId() {
        return id;
    }



    public String getName() {
        return name;
    }



    public String getUsername() {
        return username;
    }


    public String getEmail() {
        return email;
    }



    public addressModelClass getAddress() {
        return address;
    }



    public String getPhone() {
        return phone;
    }



    public String getWebsite() {
        return website;
    }



    public CompanyModelClass getCompany() {
        return company;
    }


}
