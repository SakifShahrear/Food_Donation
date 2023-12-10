package com.example.final_project;

public class donation_class {

    String code;
    String Name;
    String Foodname;
    String Quantity;
    String Address;
    String Contact;
    String Picker_date;
     String Process;
     String Rider_Id;
     String User_gmail;



    public donation_class() {

        code="";
        Name = "";
        Foodname = "";
        Quantity = "";
        Address = "";
        Contact = "";
        Picker_date = "";
        Process = "";
        Rider_Id="";
        User_gmail="";

    }

    public donation_class(String code, String name, String foodname, String quantity, String address, String contact, String picker_date, String process, String rider_Id, String user_gmail) {
        this.code = code;
        Name = name;
        Foodname = foodname;
        Quantity = quantity;
        Address = address;
        Contact = contact;
        Picker_date = picker_date;
        Process = process;
        Rider_Id = rider_Id;
        User_gmail = user_gmail;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getFoodname() {
        return Foodname;
    }

    public void setFoodname(String foodname) {
        Foodname = foodname;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getPicker_date() {
        return Picker_date;
    }

    public void setPicker_date(String picker_date) {
        Picker_date = picker_date;
    }

    public String getProcess() {
        return Process;
    }

    public void setProcess(String process) {
        Process = process;
    }

    public String getRider_Id() {
        return Rider_Id;
    }

    public void setRider_Id(String rider_Id) {
        Rider_Id = rider_Id;
    }

    public String getUser_gmail() {
        return User_gmail;
    }

    public void setUser_gmail(String user_gmail) {
        User_gmail = user_gmail;
    }



}
