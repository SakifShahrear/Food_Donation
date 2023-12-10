package com.example.final_project;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Random;

public class don_new_request {

    @FXML
    private TextField dname;
    @FXML
    private TextField dfoodname;
    @FXML
    private TextField dquantity;
    @FXML
    private TextField daddress;
    @FXML
    private TextField dcontact;
    @FXML
    private DatePicker dpickerdate;
    @FXML
    private Button drequest;
    public Label labelShow ;

    static String p=null;    //User gmail_ID
    static  String q=null;    //name

    public void set_gmail (String d)  {
        p = d;
       // user_gmail.setText(p);
    }
    public void displayName(String username) throws FileNotFoundException {
       // label1.setText(username);
        q=username;

    }
////--->>> generate Code
    public String generate() {

        Random rand = new Random();
        int randomNum = rand.nextInt(100) + 9999; // Generates a random number between 100 and 999 (inclusive)
        return String.valueOf(randomNum);

    }
////----->>><<<<<--|
    public void IMG(String i) {
        String img = i;
    }

    public boolean create_user() throws IOException {

        String U_d_code= generate();
        String Urname = dname.getText();
        String Urfood = dfoodname.getText();
        String Urquan = dquantity.getText();
        String Uradd = daddress.getText();
        String Ucon = dcontact.getText();
        LocalDate Urdate = dpickerdate.getValue();


         ///D:\Java\Project File\USERS\arifulkhan7900@gmail.com\User_Donation
         // File user_folder = new File("D:/Java/Project File/User_donation_request/");
        File user_folder = new File("D:/Java/Project File/USERS/"+ p +"/User_Donation/");

        boolean is_user_folder_created = user_folder.mkdir();

        File[] files = user_folder.listFiles();

        assert files != null;
        for (File file : files) {
            if (file.getName().equals(dname)) {
                // System.out.println("Account already exists");
                labelShow.setText("Account already exists.");
                Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000), actionEvent -> labelShow.setText("")));
                timeline.play();
            }
        }


        File userFile = new File("D:/Java/Project File/USERS/"+ p +"/User_Donation/U" +  U_d_code );
       // File userFile = new File("D:/Java/Project File/User_donation_request/" + Urname);
        boolean is_user_file_created = userFile.mkdir();

        File infoFile = new File("D:/Java/Project File/USERS/"+ p +"/User_Donation/U" +  U_d_code + "/info.txt");

       // File infoFile = new File("D:/Java/Project File/User_donation_request/" + Urname + "/info.txt");
        infoFile.createNewFile();

        FileWriter writer = new FileWriter(infoFile);
        writer.write("U"+U_d_code + "\n");
        writer.write(Urname + "\n");
        writer.write(Urfood + "\n");
        writer.write(Urquan + "\n");
        writer.write(Uradd + "\n");
        writer.write(Ucon + "\n");
        writer.write(Urdate + "\n");
        writer.write( "Pending" + "\n");
        writer.write( "None" + "\n");      ///Rider ID
        writer.write(p+"\n");

        writer.close();

        return true;

    }

    public void donation_req(ActionEvent event) throws IOException {

            boolean isUserCreate = create_user();
            if (!isUserCreate) return;

              FXMLLoader loader = new FXMLLoader(getClass().getResource("doantion.fxml"));
         Parent root;
        root = loader.load();
        user_donation_req scene2 = loader.getController();
        scene2.displayName(q);
        scene2.set_gmail(p);

        Stage stage;
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }







   @FXML

    public void home(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("hello-view.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void don_req(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("Donation_req.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void donation(ActionEvent event) throws IOException {


        FXMLLoader loader = new FXMLLoader(getClass().getResource("doantion.fxml"));
        Parent root;
        root = loader.load();
        user_donation_req scene2 = loader.getController();
        scene2.displayName(q);
        scene2.set_gmail(p);

        Stage stage;
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}
