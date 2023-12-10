package com.example.final_project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Donation_Status {


    static User_donation_code_find  po = new User_donation_code_find();
    public String D_Status(String User_code) throws FileNotFoundException {

        File info1 = new File("D:/Java/Project File/USERS/" + po.U_Doner(User_code) + "/User_Donation/" + User_code+ "/info.txt");

        // File info1 = new File("D:/Java/Project File/User_donation_request/" + a7 + "/info.txt");
        if (info1.exists()) {
            Scanner soc = new Scanner(info1);

            soc.useDelimiter("\n");

            String b1 = soc.next();
            String b2 = soc.next();
            String b3 = soc.next();
            String b4 = soc.next();
            String b5 = soc.next();
            String b6 = soc.next();
            String b7 = soc.next();
            String b8 = soc.next();
            String b9 = soc.next();
            String b10 = soc.next();


            //   System.out.println(b2);
            //  System.out.println(b3);
            // System.out.println(b4);

            soc.close();
            return b9;
        }


        return "File Not Exist";

    }






}
