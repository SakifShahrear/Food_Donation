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

import java.io.*;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;

public class delivary_login  implements Initializable{
    public PasswordField pass;
    public Label labelShow;
    static String img;
    public TextField Ulocation;
    public PasswordField UconfirmPass;
    public TextField Uemail;
    public TextField Unumber;
    public PasswordField Upass;


    public String generate() {

        Random rand = new Random();
        int randomNum = rand.nextInt(100) + 9999; // Generates a random number between 100 and 999 (inclusive)
        return String.valueOf(randomNum);

    }


    public void IMG(String i) {
        img = i;
    }

    public boolean create_user() throws IOException {

        String no = generate();
        String temail = Uemail.getText();
        String tnumber = Unumber.getText();
        String tlocation = Ulocation.getText();
        String tpass = Upass.getText();

        File user_folder = new File("D:/Java/Project File/DELIVARY/");
        boolean is_user_folder_created = user_folder.mkdir();

        File[] files = user_folder.listFiles();

        assert files != null;
        for (File file : files) {
            if (file.getName().equals(Uemail)) {
                // System.out.println("Account already exists");
                labelShow.setText("Account already exists.");
                Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000), actionEvent -> labelShow.setText("")));
                timeline.play();
            }
        }



        File userFile = new File("D:/Java/Project File/DELIVARY/R" + no);
        boolean is_user_file_created = userFile.mkdir();

        ////--->>>>>
        String directoryPath = "D:/Java/Project File/DELIVARY/R" + no + "/Success";
        File directory = new File(directoryPath);
        if (directory.mkdirs()) {
            System.out.println("Directory created successfully: " + directory.getAbsolutePath());
        } else {
            System.out.println("Failed to create directory.");
        }

        ///----<<<<

        File infoFile = new File("D:/Java/Project File/DELIVARY/R" + no + "/info.txt");
        infoFile.createNewFile();

        FileWriter writer = new FileWriter(infoFile);
        writer.write("R"+no + "\n");
        writer.write(temail + "\n");
        writer.write(tnumber + "\n");
        writer.write(tlocation + "\n");
        writer.write(tpass + "\n");
        writer.write("Available" + "\n");   ///status--
        writer.write("None" + "\n");              //donarid
        writer.close();


        return true;
    }

    public void login(ActionEvent event) throws IOException {

        String a = Uemail.getText();
        String b = Unumber.getText();
        String c = Ulocation.getText();
        String d = Upass.getText();
        String e = UconfirmPass.getText();
        String emailPattern = "^[A-Za-z0-9+_.-]+@(.+)$";
        String phoneNumberPattern = "\\d{11}";

        if (a.isBlank() == true || b.isBlank() == true || c.isBlank() == true || d.isBlank() == true || e.isBlank() == true) {
            loginlavel.setText("Please fil all required fields!");

        } else if (!a.matches(emailPattern)) {
            loginlavel.setText("Invalid Email!");

        } else if (!b.matches(phoneNumberPattern)) {
            loginlavel.setText(" Invalid Phone Number!(e.g 01xxxxxxxxx).");

        } else if (!d.matches(e)) {
            loginlavel.setText("password don't match");
        } else {

            boolean isUserCreate = create_user();
            if (!isUserCreate) return;


            Parent root = FXMLLoader.load(HelloApplication.class.getResource("delivary_login.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }


    }

    public void home(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("hello-view.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void delivary_signup(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(HelloApplication.class.getResource("delivary_signup.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void delivary_signin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("delivary_login.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void forgot(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("forgot_pas.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //// login button set messege
    @FXML
    private Label loginlavel;
    @FXML
    private PasswordField apass;
    @FXML
    private TextField text;

    public void label(ActionEvent event) throws IOException {

        if (text.getText().isBlank() == false && apass.getText().isBlank() == false) {
            // loginlavel.setText("sign in ");


        } else {
            loginlavel.setText("you try to sign in!");

        }


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }


    ///check pass & gmail for login

    //checkUp email & password
    //class person-->

    public static class person {
        private String temail;
        private String tnumber;
        private String tlocation;
        private String tpass;

        person() {
            this.temail = "";
            this.tnumber = "";
            this.tlocation = "";
            this.tpass = "";
        }

        public void setTemail(String temail) {
            this.temail = temail;
        }

        public void setTnumber(String tnumber) {
            this.tnumber = tnumber;
        }

        public void setTlocation(String tlocation) {
            this.tlocation = tlocation;
        }

        public void setTpass(String tpass) {
            this.tpass = tpass;
        }

        public String getTemail() {
            return temail;
        }

        public String getTnumber() {
            return tnumber;
        }

        public String getTlocation() {
            return tlocation;
        }

        public String getTpass() {
            return tpass;
        }
    }

    ///login--check user & pass

    static log_in log = new log_in();

    //  static person person = new person();


    public void logge(ActionEvent event) throws IOException {

        String tuser = text.getText();
        String tpass = pass.getText();

        log = new log_in(tuser, tpass);


        if (log.getUser().isBlank() || log.getPassword().isBlank()) {
            loginlavel.setText("  Fill out all the fields to proceed");
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(3000), ae -> loginlavel.setText("")));
            timeline.play();
        }

        if (log.getUser().length() > 0 && log.getPassword().length() > 0) {

            File infoFile2 = new File("D:/Java/Project File/DELIVARY/" + function(tuser) + "/info.txt");

            String E = function(tuser);    ///Rider_ID

            if (infoFile2.exists()) {
                Scanner sc = new Scanner(infoFile2);

                sc.useDelimiter("\n");

                User_login.person person = new User_login.person();

                String o = sc.next();    ///Rider_Code
                String p = sc.next();   ///Rider_gmail
                person.setTemail(p);
                p = sc.next();          ///Rider contact
                person.setTnumber(p);
                p = sc.next();            //Rider _Location
                person.setTlocation(p);
                p = sc.next();             //Rider Pass
                System.out.println(p);
                person.setTpass(p);

                System.out.println(person.getTpass().length());
                System.out.println(log.getPassword().length());

                if (person.getTpass().equals(log.getPassword())) {

                    System.out.println("E-->"+E);

                    new_request rq = new new_request();
                    rq.display_Rider_Code(E);
                    rq.set_new_req(E);

                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("delivary_page.fxml"));
                    Parent root;
                    root = fxmlLoader.load();
                 //   new_request rq = fxmlLoader.getController();
                    //rq.display_Rider_Code(E);
                  //  rq.set_new_req(E);
                    Stage stage;
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();

                } else {
                    loginlavel.setText("  Password doesn't match");
                    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(3000), ae -> loginlavel.setText("")));
                    timeline.play();
                }

            } else {
                loginlavel.setText("Please check username/password");
                Timeline timeline = new Timeline(new KeyFrame(Duration.millis(3000), ae -> loginlavel.setText("")));
                timeline.play();
            }


        }

    }



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


    ///




    @FXML
    private Label helllo;





    public void back(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(HelloApplication.class.getResource("delivary_login.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }




}