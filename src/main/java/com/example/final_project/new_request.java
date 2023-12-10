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
import java.nio.channels.Pipe;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;
import java.util.Scanner;

public class new_request implements Initializable {


    public donation_class r_new_dc = new donation_class();
    public donation_class r_tt_dc = new donation_class();
    public Rider_class  r_rr_pc = new Rider_class();

    @FXML
    private ListView<donation_class> r_new_Adonation_view = new ListView<>();
    private ObservableList<donation_class> r_new_observableList = FXCollections.observableArrayList();

    @FXML
    private Label R_ID;
    static String R_code = null;
    static String T = null;


    public void display_Rider_Code(String username) throws FileNotFoundException {
    try {
        System.out.println(username);
        R_ID.setText(username);
       }catch (NullPointerException e){
       // System.out.println("NULL");
    }
    }
    public void set_new_req( String d ) throws FileNotFoundException {
        System.out.println(" d-->>>"+d);

           //  R_ID.setText(d);
               Success=d;
           //  Donation_Status D_S =new Donation_Status();
           //  String Satus = D_S.D_Status( d ); ///
          ///   System.out.println("Rider Status -->"+Satus );
           //  if (Satus.equals("Rider Picked")) {
                // s = d;
               //  R_code = null;
          //  } else  {
                R_code = d;
               System.out.println("Rider Status -->"+Success );
               System.out.println("R code -->"+R_code );

        //  }

    }
///--->>>>>> Donation Request Search


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
      //  System.out.println("Filee name "+file_name);
      //  System.out.println("uccode "+ucode);

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
    ///----->>>


    public void rider_page() throws IOException {



    File info = new File("D:/Java/Project File/DELIVARY/" + R_code + "/info.txt");


        if (info.exists()) {

            Scanner scc = new Scanner(info);
            scc.useDelimiter("\n");

            String a1 = scc.next();
            String a2 = scc.next();
            String a3 = scc.next();
            String a4 = scc.next();
            String a5 = scc.next();
            String a6 = scc.next();
            String a7 = scc.next();   ///doner_id
            scc.close();

            System.out.println("a7-->" + a7);

            if (a6.matches("Unavailable")) {


                // User_donation_code_find gmail =new User_donation_code_find();

                File info1 = new File("D:/Java/Project File/USERS/" + U_Doner(a7) + "/User_Donation/" + a7 + "/info.txt");
                System.out.println("gmaaaaill--->> " + U_Doner(a7));

                // File info1 = new File("D:/Java/Project File/User_donation_request/" + a7 + "/info.txt");

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

                r_new_dc = new donation_class(b1, b2, b3, b4, b5, b6, b7, b8, b9, b10);
                soc.close();

                if (r_new_dc.getProcess().matches("Assigned")) {

                    r_new_observableList.add(r_new_dc);

                    r_new_Adonation_view.setItems(r_new_observableList);

                    r_new_Adonation_view.setCellFactory(donation_view -> new donation_list_cell());

                    r_new_label.setText("Hey ,  You have a new Request ");
                    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(6000), actionEvent -> r_new_label.setText("")));
                    timeline.play();


                    FileWriter writer = new FileWriter(info1);

                    writer.write(r_new_dc.getCode() + "\n");
                    writer.write(r_new_dc.getName() + "\n");
                    writer.write(r_new_dc.getFoodname() + "\n");
                    writer.write(r_new_dc.getQuantity() + "\n");
                    writer.write(r_new_dc.getAddress() + "\n");
                    writer.write(r_new_dc.getContact() + "\n");
                    writer.write(r_new_dc.getPicker_date() + "\n");
                    /////-->>picked
                     // r_pen_dc.setProcess("Rider Picked");
                    writer.write("Rider Picked"+ "\n");
                    writer.write(r_new_dc.getRider_Id() + "\n");
                    writer.write(r_new_dc.getUser_gmail() + "\n");
                     writer.close();


                }
            }

        }


    }


    ///Pending _Start
    @FXML
    private TextField app_text;
    @FXML
    private Label helllo;
    @FXML
    private TextField pen_text;

    public donation_class r_pen_dc = new donation_class();
    @FXML
    private ListView<donation_class> r_pen_Adonation_view = new ListView<>();
    private ObservableList<donation_class> r_pen_observableList = FXCollections.observableArrayList();
    @FXML
    private Label r_new_label;

    public void rider_page_01() throws IOException {



        File info = new File("D:/Java/Project File/DELIVARY/" + T + "/info.txt");
        if (info.exists()) {
            Scanner scc = new Scanner(info);
            scc.useDelimiter("\n");
            String a1 = scc.next();
            String a2 = scc.next();
            String a3 = scc.next();
            String a4 = scc.next();
            String a5 = scc.next();
            String a6 = scc.next();
            String a7 = scc.next();   ///doner_id
            scc.close();
            if (a6.matches("Unavailable")) {

                File info11 = new File("D:/Java/Project File/USERS/" + U_Doner(a7) + "/User_Donation/" + a7 + "/info.txt");
                System.out.println("gmaaaaill--->> " + U_Doner(a7));

                Scanner src = new Scanner(info11);

                src.useDelimiter("\n");

                String b1 = src.next();
                String b2 = src.next();
                String b3 = src.next();
                String b4 = src.next();
                String b5 = src.next();
                String b6 = src.next();
                String b7 = src.next();
                String b8 = src.next();
                String b9 = src.next();
                String b10 = src.next();

                r_pen_dc = new donation_class(b1, b2, b3, b4, b5, b6, b7, b8, b9, b10);
                src.close();

                if (r_pen_dc.getProcess().matches("Rider Picked")) {

                    r_pen_observableList.add(r_pen_dc);
                    r_pen_Adonation_view.setItems(r_pen_observableList);
                    r_pen_Adonation_view.setCellFactory(donation_view -> new donation_list_cell());

                    r_new_label.setText("  Rider Picked ");
                    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(6000), actionEvent -> r_new_label.setText("")));
                    timeline.play();

                }

            }

        }

    }
    @FXML
    public void approve(ActionEvent event) throws IOException{

         //if(R_code!=null) { set_pen_req(R_code);}
        if(R_code!=null)
        {
            T = R_code;
            R_code = null;
        }

        rider_page_01();

      // Parent root = FXMLLoader.load(HelloApplication.class.getResource("delivary_page.fxml"));
      // Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
     //  Scene scene = new Scene(root);
      //  stage.setScene(scene);
     //  stage.show();



        r_new_label.setText("Donation Picked ");
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(3000), actionEvent -> r_new_label.setText("")));
        timeline.play();

    }


///Succes  Star --->>>

    public void create_user() throws IOException {

        System.out.println("Create Function" + T );

        File info = new File("D:/Java/Project File/DELIVARY/" + T + "/info.txt");
        try {

            if (info.exists()) {

                //delivary file scaan
                Scanner scc = new Scanner(info);
                scc.useDelimiter("\n");
                String aa1 = scc.next();
                String aa2 = scc.next();
                String aa3 = scc.next();
                String aa4 = scc.next();
                String aa5 = scc.next();
                String aa6 = scc.next();
                String aa7 = scc.next();

                r_rr_pc = new Rider_class(aa1, aa2, aa3, aa4, aa5, aa6, aa7);
                scc.close();

                ///-->
                File info1 = new File("D:/Java/Project File/USERS/" + U_Doner(aa7) + "/User_Donation/" + aa7 + "/info.txt");
                ///donation file scan
                Scanner soc = new Scanner(info1);

                soc.useDelimiter("\n");
                String bb1 = soc.next();
                String bb2 = soc.next();
                String bb3 = soc.next();
                String bb4 = soc.next();
                String bb5 = soc.next();
                String bb6 = soc.next();
                String bb7 = soc.next();
                String bb8 = soc.next();
                String bb9 = soc.next();
                String bb10 = soc.next();

                r_tt_dc = new donation_class(bb1, bb2, bb3, bb4, bb5, bb6, bb7, bb8, bb9, bb10);
                soc.close();

                //donation file write--
                // File infonew = new File("D:/Java/Project File/DELIVARY/" + s + "/Success/" + aa7 + "/info.txt");
                //  infonew.createNewFile();

                ///--->>>>>success file create
                String userFile = "D:/Java/Project File/DELIVARY/" + T + "/Success/" + aa7;
                File directory1 = new File(userFile);
                if (directory1.mkdirs()) {
                    System.out.println("Directory created successfully: " + directory1.getAbsolutePath());
                } else {
                    System.out.println("Failed to create directory.");
                }

                File infodel = new File("D:/Java/Project File/DELIVARY/" + T + "/Success/" + aa7 + "/info.txt");
                infodel.createNewFile();

                FileWriter writer = new FileWriter(infodel);

                    r_tt_dc.setProcess("Successfull");
                writer.write(r_tt_dc.getCode() + "\n");
                writer.write(r_tt_dc.getName() + "\n");
                writer.write(r_tt_dc.getFoodname() + "\n");
                writer.write(r_tt_dc.getQuantity() + "\n");
                writer.write(r_tt_dc.getAddress() + "\n");
                writer.write(r_tt_dc.getContact() + "\n");
                writer.write(r_tt_dc.getPicker_date() + "\n");
                writer.write(r_tt_dc.getProcess()+ "\n");
                writer.write(r_tt_dc.getRider_Id() + "\n");
                writer.write(r_tt_dc.getUser_gmail() + "\n");
                writer.close();
                ///-->>>success file create done
                // /-->delivary Status into Normal-->
                FileWriter writer1 = new FileWriter(info);
                writer1.write(r_rr_pc.getNo() + "\n");
                writer1.write(r_rr_pc.getRemail() + "\n");
                writer1.write(r_rr_pc.getRcontact() + "\n");
                writer1.write(r_rr_pc.getRaddress() + "\n");
                writer1.write(r_rr_pc.getRider_pass() + "\n");
                writer1.write("Available" + "\n");        ///status--
                writer1.write("None" + "\n");              //donarid
                writer1.close();

                ///user Donation-->>>

                FileWriter writer2 = new FileWriter(info1);

                writer2.write(r_tt_dc.getCode() + "\n");
                writer2.write(r_tt_dc.getName() + "\n");
                writer2.write(r_tt_dc.getFoodname() + "\n");
                writer2.write(r_tt_dc.getQuantity() + "\n");
                writer2.write(r_tt_dc.getAddress() + "\n");
                writer2.write(r_tt_dc.getContact() + "\n");
                writer2.write(r_tt_dc.getPicker_date() + "\n");
                writer2.write(r_tt_dc.getProcess() + "\n");
                writer2.write(r_tt_dc.getRider_Id() + "\n");
                writer2.write(r_tt_dc.getUser_gmail() + "\n");
                writer2.close();

                 String a = r_tt_dc.getProcess();

                dsuccess = new donation_class(bb1, bb2, bb3, bb4, bb5, bb6, bb7, a, bb9, bb10);

            }
        }  catch (FileNotFoundException e){

             e.printStackTrace();
             System.out.println("Create user  Functio -> No file Exists");
        }

    }

        @FXML
    public void approve_done(ActionEvent event) throws IOException {


            create_user();
            r_suc_Adonation_view.setItems(r_suc_observableList);
            r_suc_Adonation_view.setCellFactory(donation_view -> new donation_list_cell());

                r_new_label.setText("Donation Success");
                Timeline timeline = new Timeline(new KeyFrame(Duration.millis(3000), actionEvent -> r_new_label.setText("")));
                timeline.play();

              Parent root = FXMLLoader.load(HelloApplication.class.getResource("delivary_page.fxml"));
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              Scene scene = new Scene(root);
              stage.setScene(scene);
              stage.show();











    }

    ////kkk
    static donation_class dsuccess = new donation_class();
    @FXML
    private ListView<donation_class> r_suc_Adonation_view = new ListView<>();
    private ObservableList<donation_class> r_suc_observableList = FXCollections.observableArrayList();

    public void view_success_history() throws FileNotFoundException {

        set_suc_items();
        r_suc_Adonation_view.setItems(r_suc_observableList);
        r_suc_Adonation_view.setCellFactory(donation_view -> new donation_list_cell());
    }

    static String Success = null;
    public void set_suc_items() throws FileNotFoundException {

        String directoryPath= "D:/Java/Project File/DELIVARY/" +  Success + "/Success";
        try {
            File directory = new File(directoryPath);
            if (directory.exists() && directory.isDirectory()) {
                File[] file_array = directory.listFiles();
                if (file_array != null) {
                    for (File i : file_array) {
                        if (i.isDirectory()) {

                            String e = i.getName();
                            set_item_Rider(e);

                        }
                    }
                }
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println(" Syccess inside File Not Found");
        }
    }

    ////--->>>| get the file info
    public void set_item_Rider(String file_name) throws FileNotFoundException {

        System.out.println(file_name);

        File infoFile2 = new File("D:/Java/Project File/DELIVARY/" +  Success + "/Success/"+ file_name + "/info.txt");
       try {
           if (infoFile2.exists()) {

               Scanner sc = new Scanner(infoFile2);
               sc.useDelimiter("\n");
               String l1 = sc.next();
               String l2 = sc.next();
               String l3 = sc.next();
               String l4 = sc.next();
               String l5 = sc.next();
               String l6 = sc.next();
               String l7 = sc.next();
               String l8 = sc.next();
               String l9 = sc.next();
               String l10 = sc.next();

               dsuccess = new donation_class(l1, l2, l3, l4, l5, l6, l7, l8, l9, l10);
               sc.close();
           }
           r_suc_observableList.add(dsuccess);

       }catch (FileNotFoundException e){
           System.out.println("File NOt Found");
       }catch (NoSuchElementException e){
           System.out.println("Element Error");
       }

    }

    ///Succes _ Finished






    public void back(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(HelloApplication.class.getResource("delivary_login.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

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
           // System.out.println("You successfully logged out!");
            //  stage.close();
        }

    }






    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            System.out.println("p-->" + R_code);

            rider_page();
            view_success_history();


            System.out.println("T-->" + T);
            System.out.println("p-->" + R_code);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }



}
