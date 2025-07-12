package com.airline.pages;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class UserProfilePage {

    public void showProfileWindow() {
        Stage stage = new Stage();
        stage.setTitle("User Profile");

        VBox mainLayout = new VBox(20);
        mainLayout.setAlignment(Pos.TOP_CENTER);
        mainLayout.setPadding(new Insets(40));
        mainLayout.setStyle("-fx-background-color: #f8f9fa;");

        Label titleLabel = new Label("Personal Info");
        titleLabel.setFont(Font.font("Arial", 24));
        titleLabel.setTextFill(Color.web("#0077B6"));

        GridPane infoGrid = new GridPane();
        infoGrid.setHgap(20);
        infoGrid.setVgap(15);
        infoGrid.setPadding(new Insets(20));
        infoGrid.setStyle("-fx-background-color: white; -fx-border-color: #dee2e6; -fx-border-radius: 8px; -fx-background-radius: 8px;");
        infoGrid.setAlignment(Pos.CENTER);

        String[][] profileData = {
                {"Title", "Mr"},
                {"First Name", "Adam"},
                {"Last Name", "Khoo Dun Yao"},
                {"Gender", "Male"},
                {"Date of Birth", "05/05/2005"},
                {"NRIC", "050505-05-0505"},
                {"Nationality", "Malaysia"},
                {"Address", "Jalan Klang, 13/1"}
        };

        for (int i = 0; i < profileData.length; i++) {
            Label label = new Label(profileData[i][0] + ":");
            label.setFont(Font.font("Arial", 14));
            Label value = new Label(profileData[i][1]);
            value.setFont(Font.font("Arial", 14));
            infoGrid.add(label, 0, i);
            infoGrid.add(value, 1, i);
        }

        mainLayout.getChildren().addAll(titleLabel, infoGrid);
        Scene scene = new Scene(mainLayout, 450, 500);
        stage.setScene(scene);
        stage.show();
    }
}

