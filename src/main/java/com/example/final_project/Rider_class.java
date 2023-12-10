package com.example.final_project;



public class Rider_class {
    String No;
    String remail;
    String raddress;
    String rcontact;
    String rider_available;
    String rider_status;
    String rider_pass;

    public Rider_class() {
        this.No = "";
        this.remail = "";
        this.raddress = "";
        this.rcontact = "";
        this.rider_pass="";
        rider_status="";
        rider_available="";

    }

    public Rider_class(String no,String remail, String rcontact,String raddress, String pa, String rider_ava , String ride_sta) {
        this.remail = remail;
        this.raddress = raddress;
        this.rcontact = rcontact;
        this.No=no;
        this.rider_pass =pa;
        this.rider_available=rider_ava;
        this.rider_status=ride_sta;

    }

    public String getRider_pass() {
        return rider_pass;
    }

    public void setRider_pass(String rider_pass) {
        this.rider_pass = rider_pass;
    }

    public String getRider_available() {
        return rider_available;
    }

    public void setRider_available(String rider_available) {
        this.rider_available = rider_available;
    }

    public String getRider_status() {
        return rider_status;
    }

    public void setRider_status(String rider_status) {
        this.rider_status = rider_status;
    }

    public String getNo() {
        return No;
    }

    public void setNo(String no) {
        No = no;
    }


    public String getRemail() {
        return remail;
    }

    public void setRemail(String remail) {
        this.remail = remail;
    }

    public String getRaddress() {
        return raddress;
    }

    public void setRaddress(String raddress) {
        this.raddress = raddress;
    }

    public String getRcontact() {
        return rcontact;
    }

    public void setRcontact(String rcontact) {
        this.rcontact = rcontact;
    }
}
