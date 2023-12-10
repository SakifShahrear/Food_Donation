package com.example.final_project;

import java.io.File;
import java.io.FileNotFoundException;

public class User_donation_code_find {

    public String U_Doner(String r) throws FileNotFoundException {

        String directoryPath = "D:/Java/Project File/USERS";
        File directory = new File(directoryPath);

        // Check if the directory exists
        if (directory.exists() && directory.isDirectory()) {
            // List the files and subdirectories in the directory
            File[] file_array = directory.listFiles();

            if (file_array != null) {
                for (File i : file_array) {
                    if (i.isDirectory()) {

                        String e = i.getName();
                        if(r.equals(set_item_Donation_1( e,r ))) {

                            // System.out.println("ee1  -->" +e);
                            return e;
                        }
                    }
                }
            }
        }
        return directoryPath;
    }
    public String set_item_Donation_1(String file_name,String ucode) throws FileNotFoundException {

        String directoryPat = "D:/Java/Project File/USERS/"+file_name+"/User_Donation";
        System.out.println("Filee name "+file_name);
        System.out.println("uccode "+ucode);

        File directory = new File(directoryPat);
        // Check if the directory exists
        if (directory.exists() && directory.isDirectory()) {
            // List the files and subdirectories in the directory
            File[] file_array = directory.listFiles();

            if (file_array  != null) {
                for (File j : file_array ) {
                    if (j.isDirectory()) {

                        String fii= j.getName();
                        // System.out.println("fiiii-->" +fii);
                        if( fii.equals(ucode) ) {
                            // System.out.println("SET___code -->"+ fii);
                            return fii;
                        }
                    }
                }
            }
        }
        return directoryPat;
    }




}


