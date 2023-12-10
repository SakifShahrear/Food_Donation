package com.example.final_project;

public class log_in
{

    String user;
    String password;

    public log_in(String user,String password)
    {
        this.user=user;
        this.password=password;

    }
    public  log_in()
    {
        this.user="";
        this.password="";
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
