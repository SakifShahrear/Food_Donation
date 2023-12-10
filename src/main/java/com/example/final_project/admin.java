package com.example.final_project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class admin extends function_work implements Initializable  {

    ////kkk
    static donation_class dc = new donation_class();
    @FXML
    private ListView<donation_class> Adonation_view;
    private ObservableList<donation_class> observableList;

    public void view_history() throws FileNotFoundException {


          observableList = FXCollections.observableArrayList();

          set_items();

           Adonation_view.setItems(observableList);
           Adonation_view.setCellFactory(donation_view -> new donation_list_cell());

    }

    public void set_items()  {

        String directoryPath = "D:/Java/Project File/USERS";
        File directory = new File(directoryPath);
    try {
        // Check if the directory exists
        if (directory.exists() && directory.isDirectory()) {
            // List the files and subdirectories in the directory
            File[] file_array = directory.listFiles();

            if (file_array != null) {
                for (File i : file_array) {
                    if (i.isDirectory()) {

                        String e = i.getName();
                        set_item_Donation(e);
                        //  System.out.println(e);

                        // get_item(e);

                        //observableList.add(dc);
                    }
                }
            }
        }
    }catch (FileNotFoundException e){
        System.out.println("File Not Exists");
    }


    }

    ////--->>>| get the file info
    public void set_item_Donation(String file_name) throws FileNotFoundException {

        System.out.println(file_name);

        String directoryPat = "D:/Java/Project File/USERS/"+ file_name +"/User_Donation";
        File directory = new File(directoryPat);

        // Check if the directory exists
        if (directory.exists() && directory.isDirectory()) {
            // List the files and subdirectories in the directory
            File[] file_array = directory.listFiles();

            if (file_array  != null) {
                for (File j : file_array ) {
                    if (j.isDirectory()) {

                        String fi= j.getName();
                       // System.out.println(fi);

                        //get_item(fi);
                        File infoFile2 = new File("D:/Java/Project File/USERS/"+file_name+"/User_Donation/" + fi + "/info.txt");
                        if (infoFile2.exists()) {

                            Scanner sc = new Scanner(infoFile2);
                            sc.useDelimiter("\n");

                            // donation_class dc = new donation_class();
                            String l1 = sc.next();
                           // System.out.println("l1: " + l1);
                            // dc.setName(l1);
                            String l2 = sc.next();
                           // System.out.println("l2: " + l2);
                            //dc.setFoodname(l2);
                            String l3 = sc.next();
                           // System.out.println("l3: " + l3);
                            //dc.setQuantity(l3);
                            String l4= sc.next();
                          //  System.out.println("l4: " + l4);
                            // dc.setAddress(l4);
                            String l5= sc.next();
                            //System.out.println("l5: " + l5);
                            //dc.setContact(l5);
                            String l6 = sc.next();
                          //  System.out.println("l6: " + l6);
                            //dc.setPicker_date(l6);
                            String l7= sc.next() ;
                           // System.out.println("l7: " + l7);
                            // dc.setProcess(l7);
                            String l8= sc.next() ;
                            String l9= sc.next() ;
                            String l10= sc.next() ;

                            dc = new donation_class(l1,l2,l3,l4,l5,l6,l7,l8,l9,l10);
                            sc.close();
                        }


                        observableList.add(dc);
                    }
                }
            }
        }
    }


    ///----<<<

    void get_item(String e) throws FileNotFoundException {

    }


////2222222
//Rider_List-->>>

    static Rider_class rdc = new Rider_class();

    @FXML
    private ListView<Rider_class> rAdonation_view;
    private ObservableList<Rider_class> robservableList;

    public void view_history1() throws FileNotFoundException {


        robservableList = FXCollections.observableArrayList();
        rset_items();
        rAdonation_view.setItems(robservableList);
        rAdonation_view.setCellFactory(Rider_view -> new Rider_list_cell());

    }



    public void rset_items() throws FileNotFoundException {

        String directoryPath = "D:/Java/Project File/DELIVARY";
        File directory = new File(directoryPath);

        // Check if the directory exists
        if (directory.exists() && directory.isDirectory()) {
            // List the files and subdirectories in the directory
            File[] file_array = directory.listFiles();

            if (file_array  != null) {
                for (File j : file_array ) {
                    if (j.isDirectory()) {
                        String re = j.getName();

                        rget_item(re);

                        robservableList.add(rdc);
                    }
                }
            }
        }
    }


    void rget_item(String re) throws FileNotFoundException {
        System.out.println(re);
        File rinfoFile2 = new File("D:/Java/Project File/DELIVARY/" + re + "/info.txt");
        if (rinfoFile2.exists()) {
            Scanner rsc = new Scanner(rinfoFile2);
            rsc.useDelimiter("\n");

            String rl0 = rsc.next();
            System.out.println(rl0);
            String rl1 = rsc.next();
            String rl2 = rsc.next();
            String rl3 = rsc.next();
            String rl4 = rsc.next();
            String rl5 = rsc.next();
            String rl6 = rsc.next();

            rdc = new Rider_class(rl0,rl1,rl2,rl3,rl4,rl5,rl6);
            rsc.close();
        }

    }







    @FXML
    public void back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("admin_login.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


////-->>>User to Donation File Find-->>  classsssss

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





////---->>>>

    ///-->
    static donation_class_1 dc1= new donation_class_1();
    static Rider_class rcs =new Rider_class();
    @FXML
    private TextField Donar_name;
    @FXML
    private TextField Rider_ID;
     @FXML
     private  Label ad_label;
    public void click(ActionEvent event) throws IOException {


        String tdonar = Donar_name.getText();
        String trider = Rider_ID.getText();

      //  File infoFile1 = new File("D:/Java/Project File/User_donation_request/" + tdonar + "/info.txt");

       // System.out.println("U Func " +U_Doner(tdonar) );
          File infoFile1 = new File("D:/Java/Project File/USERS/"+ U_Doner(tdonar)  +"/User_Donation/" + tdonar+"/info.txt");
       // System.out.println("path in01 --> "+infoFile1.getAbsoluteFile());
           File infoFile2 = new File("D:/Java/Project File/DELIVARY/" + trider+ "/info.txt");

             //  File infoFile  = new File("D:/Java/Project File/USERS/" + temail + "/info.txt");
        if (infoFile1.exists() && infoFile2.exists() ) {

           ///scan donation
            Scanner sc = new Scanner(infoFile1);
            sc.useDelimiter("\n");


            String lu1 = sc.next();   //ucode
            String lu2 = sc.next();    //name
            String lu3 = sc.next();     //food name
            String lu4 = sc.next();    //quantity
            String lu5 = sc.next();    //location
            String lu6= sc.next();    //contact
            String lu7=sc.next();     //date
            String lu8=sc.next();       //status-->pending or assigned or Rider_picked or Success
            String lu9=sc.next();        //rider_ id or name
            String lu10=sc.next();         //User_gmail


            dc1= new donation_class_1(lu1,lu2,lu3,lu4,lu5,lu6,lu7,lu8,lu9,lu10);

           // String a = dc1.getProcess();
            String b = "Pending";
            String c = "Assigned";
            String d = "Succesfull";
            String ppp = "1";
            String fff = "1";
             ///scan rider
            Scanner s = new Scanner(infoFile2);
            s.useDelimiter("\n");
            String k = s.next();
            rcs.setNo(k);
            k = s.next();
            rcs.setRemail(k);
            k = s.next();
            rcs.setRcontact(k);
            k = s.next();
            rcs.setRaddress(k);
            k = s.next();
            rcs.setRider_pass(k);
            k = s.next();
            rcs.setRider_available(k);
            k = s.next();
            rcs.setRider_status(k);

           // String aa = rcs.getRider_available();
           // String rider_statuss = rcs.getRider_status();
            String ab = "Available";
            String un = "Unavailable";
            String bc = "None";

            ///donation write -->
            FileWriter writer = new FileWriter(infoFile1);
            writer.write(dc1.getCode() + "\n");
            writer.write(dc1.getName() + "\n");
            writer.write(dc1.getFoodname() + "\n");
            writer.write(dc1.getQuantity() + "\n");
            writer.write(dc1.getAddress() + "\n");
            writer.write(dc1.getContact() + "\n");
            writer.write(dc1.getPicker_date() + "\n");



            ///rider write-->
            FileWriter Rwriter = new FileWriter(infoFile2);
            Rwriter.write(rcs.getNo() + "\n");
            Rwriter.write(rcs.getRemail() + "\n");
            Rwriter.write(rcs.getRcontact() + "\n");
            Rwriter.write(rcs.getRaddress() + "\n");
            Rwriter.write(rcs.getRider_pass() + "\n");


            if ( dc1.getProcess().matches("Pending")  && rcs.getRider_available().matches("Available")) {
                //scan write
                writer.write(c + "\n");   //c = "Assigned";
                writer.write(rcs.getNo()+"\n");
                writer.write(dc1.getUser_gmail());


                 //rider write
                Rwriter.write(un + "\n");    //un = "Unavailable";
                Rwriter.write(tdonar + "\n");    //doner name write in rider file

                ad_label.setText("Assiged Succesfull");
                Timeline timeline = new Timeline(new KeyFrame(Duration.millis(3000), actionEvent -> ad_label.setText("")));
                timeline.play();

            }else if(!dc1.getProcess().matches(b) && rcs.getRider_available().matches(ab) )
            {
                writer.write(dc1.getProcess() + "\n");      //  a = dc1.getProcess(); already file e jete ase --
                writer.write(dc1.getRider_Id()+"\n");
                writer.write(dc1.getUser_gmail());                           // b = "Pending";
                //   writer.write(rr + "\n");

                Rwriter.write(rcs.getRider_available() + "\n");
                Rwriter.write(rcs.getRider_status() + "\n");

                ad_label.setText("Donar Already Assigned ");
                Timeline timeline = new Timeline(new KeyFrame(Duration.millis(3000), actionEvent -> ad_label.setText("")));
                timeline.play();


            }
            else if(dc1.getProcess().matches(b) && ! rcs.getRider_available().matches(ab))
            {
                //jodi rider unavailable thake then -->
                writer.write(dc1.getProcess() + "\n");
                writer.write(dc1.getRider_Id()+"\n");
                writer.write(dc1.getUser_gmail());
                //   writer.write(rr + "\n");

                Rwriter.write(rcs.getRider_available() + "\n");
                Rwriter.write(rcs.getRider_status() + "\n");

                ad_label.setText("Rider Unabvailable");
                Timeline timeline = new Timeline(new KeyFrame(Duration.millis(3000), actionEvent -> ad_label.setText("")));
                timeline.play();
            }

            else {
                //jodi duitai assiged & unavailable thake --> then
                writer.write(dc1.getProcess() + "\n");
                writer.write(dc1.getRider_Id()+"\n");
                writer.write(dc1.getUser_gmail());
                //   writer.write(rr + "\n");

                Rwriter.write(rcs.getRider_available() + "\n");
                Rwriter.write(rcs.getRider_status() + "\n");

                ad_label.setText("Check Donar & Rider ");
                Timeline timeline = new Timeline(new KeyFrame(Duration.millis(3000), actionEvent -> ad_label.setText("")));
                timeline.play();

            }
            writer.close();
            Rwriter.close();
            view_history();
            view_history1();

                //   Parent root = FXMLLoader.load(getClass().getResource("Admin_Dashboard.fxml"));
                //  Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                // Scene scene = new Scene(root);
                // stage.setScene(scene);
                //  stage.show();


        }
        else
        {
            ad_label.setText("Donar File / Rider File is not exists ");
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(3000), actionEvent -> ad_label.setText("")));
            timeline.play();

        }



    }


////-------->>>>>>>>>>

    ////file information to get file name
    public String function(String tuser) {

        String directoryPath = "D:/Java/Project File/DELIVARY";
        String searchEmail = tuser;

        File directory = new File(directoryPath);
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    System.out.println("a");
                    File infoFile = new File("D:/Java/Project File/DELIVARY/" + file.getName() + "/info.txt");

                    System.out.println("b");

                    if (containsEmail(infoFile, searchEmail)) {
                        System.out.println("File containing email found: " + file.getName());
                        // You can perform additional actions here
                        return file.getName();
                        // If you want to stop searching after finding the first occurrence
                    }
                }
            }
        }
        System.out.println("Invalid directory path");
        return directoryPath;
    }

    private static boolean containsEmail(File file, String searchEmail) {
        try (Scanner sc = new Scanner(file)) {

            sc.useDelimiter("\n");
            String o = sc.next();
            String p = sc.next();
            System.out.println(p);
            if (p.matches(searchEmail)) {
                return true;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {

            view_history();

            view_history1();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }



}