package com.example.final_project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class Rider_list_cell extends ListCell<Rider_class> {

    @FXML
    private Label no;
    @FXML
    private Label Raddress;

    @FXML
    private Label Rcontact;

    @FXML
    private Label Remail;

    @FXML
    private AnchorPane rgrid;
    @FXML
    private Label rider_available;

    @FXML
    private Label assign_for;

    private FXMLLoader mLLoader;

    protected void updateItem(Rider_class rdc, boolean empty) {
        super.updateItem(rdc, empty);
        if(empty || rdc == null) {
            setText(null);
           setGraphic(null);
        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(HelloApplication.class.getResource("Rider_list.fxml"));
                mLLoader.setController(this);
                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            no.setText(rdc.getNo());
            Remail.setText(rdc.getRemail());
            Raddress.setText(rdc.getRaddress());
            Rcontact.setText(rdc.getRcontact());
            rider_available.setText(rdc.getRider_available());
            assign_for.setText(rdc.getRider_status());

            setText(null);
            setGraphic(rgrid);
        }

    }




}
