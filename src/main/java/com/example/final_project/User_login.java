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
        import java.io.FileNotFoundException;
        import java.io.FileWriter;
        import java.io.IOException;
        import java.text.BreakIterator;
        import java.time.LocalDate;
        import java.util.Random;
        import java.util.Scanner;

public class User_login {

    public Label labelShow ;
    static String img;
    public TextField Ulocation;
    public PasswordField UconfirmPass;
    public TextField Uemail;
    public TextField Unumber;
    public PasswordField Upass;

    public TextField user_name;


    public void IMG(String i) {
        img = i;
    }




    public boolean create_user() throws IOException {

        String temail = Uemail.getText();
        String tnumber = Unumber.getText();
        String tlocation = Ulocation.getText();
        String tpass = Upass.getText();
        String tname =user_name.getText();

        File user_folder = new File("D:/Java/Project File/USERS/");
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

    File userFile = new File("D:/Java/Project File/USERS/" + temail);
    boolean is_user_file_created = userFile.mkdir();


    ///--->>> // Create a File object for the directory
    String directoryPath = "D:/Java/Project File/USERS/" + temail + "/User_Donation";
    File directory = new File(directoryPath);
    if (directory.mkdirs()) {
        System.out.println("Directory created successfully: " + directory.getAbsolutePath());
    } else {
        System.out.println("Failed to create directory.");
    }
    //--->>>>>>>>>

    File infoFile = new File("D:/Java/Project File/USERS/" + temail + "/info.txt");
    infoFile.createNewFile();

    FileWriter writer = new FileWriter(infoFile);

    writer.write(tname + "\n");
    writer.write(temail + "\n");
    writer.write(tnumber + "\n");
    writer.write(tlocation + "\n");
    writer.write(tpass + "\n");
    writer.close();



        return true;
    }



    public void login(ActionEvent event) throws IOException {
        String u_name= user_name.getText();
        String a = Uemail.getText();
        String b = Unumber.getText();
        String c = Ulocation.getText();
        String d = Upass.getText();
        String e =UconfirmPass.getText();

        String emailPattern = "^[A-Za-z0-9+_.-]+@(.+)$";
        String phoneNumberPattern = "\\d{11}";

         if (u_name.isBlank()== true ||a.isBlank() == true || b.isBlank() == true || c.isBlank() == true || d.isBlank() == true || e.isBlank()==true) {
            ul_loginlavel.setText("Please fill all required fields!");

        } else if (!a.matches(emailPattern)) {
            ul_loginlavel.setText("Invalid Email!");

        } else if (!b.matches(phoneNumberPattern)) {
            ul_loginlavel.setText(" Invalid Phone Number!(e.g 01xxxxxxxxx).");

        } else if (!d.matches(e)) {
            ul_loginlavel.setText("password don't match");
        } else
        {

            boolean isUserCreate = create_user();   ///File Created-->
            if (!isUserCreate) return;

            Parent root = FXMLLoader.load(HelloApplication.class.getResource("user_login.fxml"));
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

    public void forgot(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("forgot_pas.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void user_login(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("user_login.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }




    public void donation_req(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("Donation_req.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    public void user_signup(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(HelloApplication.class.getResource("sign_up.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }




    //// login button set messege
    @FXML
    private Label ul_loginlavel;
    @FXML
    private PasswordField ulpass;
    @FXML
    private TextField ultext;

    @FXML
     Label nameLabel;

    private Stage stage;
    private Scene scene;
    private Parent root;


   //checkUp email & password
  //class person-->

 public static class person{
     private  String t_name;
     private String temail ;
   private   String tnumber ;
    private String tlocation ;
    private  String tpass;
    person(){
        this.t_name="";
        this.temail="";
        this.tnumber="";
        this.tlocation="";
        this.tpass="";
    }
     public void sett_name(String t_name) {
         this.t_name = t_name;
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
     public String gett_name() {
         return t_name;
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

        String tuser = ultext.getText();
        String tpass = ulpass.getText();

          log = new log_in(tuser, tpass);


        if (log.getUser().isBlank() || log.getPassword().isBlank())
        {
            ul_loginlavel.setText("  Fill out all the fields to proceed");
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(3000), ae -> ul_loginlavel.setText("")));
            timeline.play();
        }

        if (log.getUser().length() > 0 && log.getPassword().length() > 0) {

            File infoFile2 = new File("D:/Java/Project File/USERS/" + log.getUser() + "/info.txt");

            if (infoFile2.exists()) {

                Scanner sc = new Scanner(infoFile2);
                sc.useDelimiter("\n");

                 person person =new person();

                 String a=sc.next();
                 person.sett_name(a);
                String gmail = sc.next();
                person.setTemail(gmail);
                String p= sc.next();
                person.setTnumber(p);
                p = sc.next();
                person.setTlocation(p);
                p = sc.next();
                person.setTpass(p);

                System.out.println(person.getTpass().length());
                System.out.println(log.getPassword().length());

                if (person.getTpass().equals(log.getPassword())) {

                    String username =  person.gett_name();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("doantion.fxml"));
                    Parent root;
                    root = loader.load();

                    user_donation_req scene2 = loader.getController();
                    scene2.displayName(username);
                    scene2.set_gmail(gmail);

                    //root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
                    Stage stage;
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();


                  //  root = FXMLLoader.load(getClass().getResource("doantion.fxml"));
                  //  Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                  //  Scene scene = new Scene(root);
                  //  stage.setScene(scene);
                   // stage.show();

                } else {
                    ul_loginlavel.setText("  Password doesn't match");
                    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(3000), ae -> ul_loginlavel.setText("")));
                    timeline.play();
                }

            } else {
                ul_loginlavel.setText("Please check username/password");
                Timeline timeline = new Timeline(new KeyFrame(Duration.millis(3000), ae -> ul_loginlavel.setText("")));
                timeline.play();
            }
        }

    }




}