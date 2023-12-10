package com.example.final_project;

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
import java.time.LocalDate;
import java.util.Scanner;

public class agent_login {

    static String img;
    public TextField Ulocation;
    public PasswordField UconfirmPass;
    public TextField Uemail;
    public TextField Unumber;
    public PasswordField Upass;
    @FXML
    private DatePicker DATE;


    public void IMG(String i) {
        img = i;
    }

    public boolean create_user() throws IOException {
        String temail = Uemail.getText();
        String tnumber = Unumber.getText();
        String tlocation = Ulocation.getText();
        String tpass = Upass.getText();

        File user_folder = new File("D:/Java/Project File/AGENT/");
        boolean is_user_folder_created = user_folder.mkdir();

        File[] files = user_folder.listFiles();

        assert files != null;
        for (File file : files) {
            if (file.getName().equals(Uemail)) {
                // System.out.println("Account already exists");
                loginlavel.setText("Account already exists.");
                Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000), actionEvent -> loginlavel.setText("")));
                timeline.play();
            }
        }

        File userFile = new File("D:/Java/Project File/AGENT/" + temail);
        boolean is_user_file_created = userFile.mkdir();

        File infoFile = new File("D:/Java/Project File/AGENT/" + temail + "/info.txt");
        infoFile.createNewFile();

        FileWriter writer = new FileWriter(infoFile);
        writer.write(temail + "\n");
        writer.write(tnumber + "\n");
        writer.write(tlocation + "\n");
        writer.write(tpass + "\n");
        writer.close();

        return true;
    }

    public void sign_up(ActionEvent event) throws IOException {
        String a = Uemail.getText();
        String b = Unumber.getText();
        String c = Ulocation.getText();
        String d = Upass.getText();
        String e =UconfirmPass.getText();
        String emailPattern = "^[A-Za-z0-9+_.-]+@(.+)$";
        String phoneNumberPattern = "\\d{11}";

        if (a.isBlank() == true || b.isBlank() == true || c.isBlank() == true || d.isBlank() == true || e.isBlank()==true) {
            loginlavel.setText("Please fil all required fields!");

        } else if (!a.matches(emailPattern)) {
            loginlavel.setText("Invalid Email!");

        } else if (!b.matches(phoneNumberPattern)) {
            loginlavel.setText(" Invalid Phone Number!(e.g 01xxxxxxxxx).");

        } else if (!d.matches(e)) {
            loginlavel.setText("password don't match");
        }
        else {

            boolean isUserCreate = create_user();
            if (!isUserCreate) return;


            Parent root = FXMLLoader.load(HelloApplication.class.getResource("agent_login.fxml"));
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

    public void agent_signup(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("agent_signup.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void agent_signin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("agent_login.fxml"));
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






    ///check pass & gmail for login

    //checkUp email & password
    //class person-->

    public static class person{
        private String temail ;
        private   String tnumber ;
        private String tlocation ;
        private  String tpass;
        person(){
            this.temail="";
            this.tnumber="";
            this.tlocation="";
            this.tpass="";
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
        String tpass = apass.getText();

        log = new log_in(tuser, tpass);


        if (log.getUser().isBlank() || log.getPassword().isBlank())
        {
            loginlavel.setText("  Fill out all the fields to proceed");
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(3000), ae -> loginlavel.setText("")));
            timeline.play();
        }

        if (log.getUser().length() > 0 && log.getPassword().length() > 0) {
            File infoFile2 = new File("D:/Java/Project File/AGENT/" + log.getUser() + "/info.txt");

            if (infoFile2.exists()) {
                Scanner sc = new Scanner(infoFile2);

                sc.useDelimiter("\n");

                User_login.person person =new User_login.person();

                String p = sc.next();
                person.setTemail(p);
                p = sc.next();
                person.setTnumber(p);
                p = sc.next();
                person.setTlocation(p);
                p = sc.next();
                person.setTpass(p);

                System.out.println(person.getTpass().length());
                System.out.println(log.getPassword().length());

                if (person.getTpass().equals(log.getPassword())) {

                    Parent root = FXMLLoader.load(getClass().getResource("agent_page.fxml"));
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
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



}