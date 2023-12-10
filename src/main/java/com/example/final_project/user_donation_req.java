package com.example.final_project;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.Scanner;

public class user_donation_req implements Initializable {



    @FXML
    private Label user_contact;

    @FXML
    private Label user_location;
    @FXML
    private Label label1;

    @FXML
    private Label user_gmail;

    static String p=null;    //gmail Id
    static  String q=null;     ///name

////-------->>>>>>>
    public void set_gmail (String d) throws FileNotFoundException {
         p = d;
         user_gmail.setText(p);
            profile(d);
            view_history();

    }

    public void displayName(String username) throws FileNotFoundException {

        label1.setText(username);
          q = username;
    }

    public void profile(String gm) throws FileNotFoundException {

        File infoFile = new File("D:/Java/Project File/USERS/"+ gm + "/info.txt");
        if (infoFile.exists()) {
            Scanner sc = new Scanner(infoFile);
            sc.useDelimiter("\n");

            String name = sc.next();
            String gmail = sc.next();
            String contact = sc.next();
            String location = sc.next();

            user_contact.setText(contact);
            user_location.setText(location);

               sc.close();

        }
        else
        {
            System.out.println("No File Exists");

        }
    }
////------>>>>>>>><<<<<<<<
    @FXML
    public void don_req(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Donation_req.fxml"));
        Parent root;
        root = loader.load();

        don_new_request scene2 = loader.getController();
        scene2.displayName(q);
        scene2.set_gmail(p);

        //root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        Stage stage;
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

       // Parent root = FXMLLoader.load(HelloApplication.class.getResource("Donation_req.fxml"));
      //  Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
      //  Scene scene = new Scene(root);
      //  stage.setScene(scene);
     //   stage.show();


    }


    @FXML
    public void home(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("hello-view.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    //

////kkk
    static donation_class dc = new donation_class();
    @FXML
    private ListView<donation_class> donation_view;
    private ObservableList<donation_class> observableList;

    public void view_history() throws FileNotFoundException {


        observableList = FXCollections.observableArrayList();
        set_items();
        donation_view.setItems(observableList);
        donation_view.setCellFactory(donation_view -> new donation_list_cell());

    }

    public void set_items() throws FileNotFoundException {

        //File user_folder = new File("D:/Java/Project File/USERS/"+ p +"/User_Donation/");

        //String directoryPath = "D:/Java/Project File/User_donation_request";
        String directoryPath = "D:/Java/Project File/USERS/"+ p +"/User_Donation/";

        File directory = new File(directoryPath);
        // Check if the directory exists
        if (directory.exists() && directory.isDirectory()) {
            // List the files and subdirectories in the directory
            File[] file_array = directory.listFiles();

            if (file_array  != null) {
                for (File i : file_array ) {
                    if (i.isDirectory()) {
                        String e= i.getName();

                        get_item(e);

                        observableList.add(dc);
                    }
                }
            }
        }
    }

    void get_item(String e) throws FileNotFoundException {

        File infoFile2 = new File("D:/Java/Project File/USERS/"+ p +"/User_Donation/" + e + "/info.txt");

        if (infoFile2.exists()) {
            Scanner sc = new Scanner(infoFile2);
            sc.useDelimiter("\n");

            String l1 = sc.next();   //ucode
            String l2 = sc.next();    //name
            String l3 = sc.next();     //food name
            String l4 = sc.next();    //quantity
            String l5 = sc.next();    //location
            String l6=sc.next();    //contact
            String l7=sc.next();     //date
            String l8=sc.next();    //status-->pending or assigned or Rider_picked or Success
            String l9=sc.next();        //rider_ id or name
            String l10=sc.next();      //user gmail--


            dc = new donation_class(l1,l2,l3,l4,l5,l6,l7,l8,l9,l10);
            sc.close();
        }
        else {
            System.out.println("No file Exists");
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            view_history();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }





    ///logout--->

    @FXML
    private Button logoutButton;
    @FXML
    private AnchorPane scenePane;

    Stage stage;

    public void logout(ActionEvent event) throws IOException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You're about to logout!");
        alert.setContentText("Do you want to save before exiting?: ");

        if (alert.showAndWait().get() == ButtonType.OK) {

            Parent root = FXMLLoader.load(HelloApplication.class.getResource("hello-view.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            // stage = (Stage) scenePane.getScene().getWindow();
            System.out.println("You successfully logged out!");
            //  stage.close();
        }

    }



}
