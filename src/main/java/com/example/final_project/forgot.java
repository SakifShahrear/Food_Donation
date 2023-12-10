package com.example.final_project;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.*;


public class forgot implements Initializable {

    @FXML
    private PasswordField confirmPass;

    @FXML
    private TextField email;

    @FXML
    private Button login;

    @FXML
    private Label loginlabel;

    @FXML
    private Label loginlavel;

    @FXML
    private TextField otp;

    @FXML
    private PasswordField pass;

    @FXML
    private Button sendMail;

    @FXML
    private Button verify;
    int f = 0;


    @FXML
    void reset(ActionEvent event) throws IOException {
        String temail =email.getText();

        String confirmPassText = confirmPass.getText();
        String passText = pass.getText();
        System.out.println("f: " + f);
        System.out.println("passtext: " + passText);
        System.out.println("Confirm pass: " + confirmPassText);
        if (Objects.equals(confirmPassText, passText)   && function(temail, passText)) {




            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("user_login.fxml")));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } else {
            loginlavel.setText("Password not matched!");
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(3000), actionEvent -> loginlabel.setText("")));
            timeline.play();
        }
    }



    static log_in log = new log_in();
    static person  person = new person();
    public boolean function(String tm , String tpass) throws IOException {

     File infoFile = new File("D:/Java/Project File/USERS/" + tm + "/info.txt");
     try {
         if (infoFile.exists()) {
             Scanner sc = new Scanner(infoFile);

             sc.useDelimiter("\n");

             String a = sc.next();
             person.setTname(a);
             String p = sc.next();
             person.setTemail(p);
             p = sc.next();
             person.setTnumber(p);
             p = sc.next();
             person.setTlocation(p);
             p = sc.next();
             person.setTpass(p);

             FileWriter writer = new FileWriter(infoFile);
             writer.write(person.getTname() + "\n");
             writer.write(person.getTemail() + "\n");
             writer.write(person.getTnumber() + "\n");
             writer.write(person.getTlocation() + "\n");
             writer.write(tpass + "\n");
             writer.close();
             return true;
         }
     }catch (FileNotFoundException e){
         e.printStackTrace();
         System.out.println("Filee NOt Found");
     }

     return  false;


 }

    Random rand = new Random();
    int randomcode = 0;

    void callRand() {
        randomcode = rand.nextInt(999999);
    }
    @FXML
    void sendMailBtn(MouseEvent event) {
        String mail = email.getText();
        callRand();
        String body = "Your reset code is "+ randomcode;
        String subject = "Reset your password";
        SendMail.sendEmail(body,subject,mail,"Tusar");


        loginlabel.setText("Check Your Email ");
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(3000), actionEvent -> loginlabel.setText("")));
        timeline.play();

    }

    @FXML
    void verifyBtn(MouseEvent event) {
        System.out.println("Code: " + randomcode);

        boolean r = false;
        try {
            OTPValidator.checkOTP(Integer.toString(randomcode),otp.getText());
            r=true;
        } catch (OTPMismatchException e) {
            throw new RuntimeException(e);
        }

        if(r){
            f = 1;
            pass.setEditable(true);
            confirmPass.setEditable(true);
            loginlabel.setText("OTP Match");
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(3000), actionEvent -> loginlabel.setText("")));
            timeline.play();
        }
        else{
            loginlabel.setText("OTP is not correct");
        }
    }

    public void IMG(String i) {
        String img = i;
    }



    public void HOME(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("hello-view.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pass.setEditable(false);
        confirmPass.setEditable(false);
    }
}
