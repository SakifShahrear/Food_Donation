package com.example.final_project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.io.IOException;

public class donation_list_cell extends ListCell<donation_class> {


    @FXML
    private Label U_don_code;

    @FXML
    private Label gmail;
    @FXML
    private Label name;
    @FXML
    private Label f_name;
    @FXML
    private Label quantity;
    @FXML
    private Label address;
    @FXML
    private Label contact;
    @FXML
    private Label date_pick;
    @FXML
    private AnchorPane gridPane;
    @FXML
    private Label Rider_ID;
    @FXML
    private Label Process;


    private FXMLLoader mLLoader;

    public donation_list_cell() {
        super();
    }

    protected void updateItem(donation_class dc, boolean empty) {
        super.updateItem(dc, empty);

        if(empty || dc == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(HelloApplication.class.getResource("don_pan.fxml"));
                mLLoader.setController(this);

                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            U_don_code.setText(dc.getCode());
            gmail.setText(dc.getUser_gmail());
            name.setText(dc.getName());
            f_name.setText(dc.getFoodname());
            quantity.setText(dc.getQuantity());
            address.setText(dc.getAddress());
            contact.setText(dc.getContact());
            date_pick.setText(dc.getPicker_date());
            Process.setText(dc.getProcess());
            Rider_ID.setText(dc.getRider_Id());

            setText(null);
            setGraphic(gridPane);

        }

    }
}