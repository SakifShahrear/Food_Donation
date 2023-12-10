package com.example.final_project;

public class person {

        private  String tname;
        private String temail ;
        private   String tnumber ;
        private String tlocation ;
        private  String tpass;

        person(){

            this.tname="";
            this.temail="";
            this.tnumber="";
            this.tlocation="";
            this.tpass="";
        }

    public person(String tname, String temail, String tnumber, String tlocation, String tpass) {
        this.tname = tname;
        this.temail = temail;
        this.tnumber = tnumber;
        this.tlocation = tlocation;
        this.tpass = tpass;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTemail() {
        return temail;
    }

    public void setTemail(String temail) {
        this.temail = temail;
    }

    public String getTnumber() {
        return tnumber;
    }

    public void setTnumber(String tnumber) {
        this.tnumber = tnumber;
    }

    public String getTlocation() {
        return tlocation;
    }

    public void setTlocation(String tlocation) {
        this.tlocation = tlocation;
    }

    public String getTpass() {
        return tpass;
    }

    public void setTpass(String tpass) {
        this.tpass = tpass;
    }


}
