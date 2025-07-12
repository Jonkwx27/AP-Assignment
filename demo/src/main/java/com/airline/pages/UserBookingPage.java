package com.airline.pages;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class UserBookingPage {

    public void showBookingWindow() {
        Stage stage = new Stage();
        stage.setTitle("My Booking");

        VBox mainLayout = new VBox(25);
        mainLayout.setAlignment(Pos.TOP_CENTER);
        mainLayout.setPadding(new Insets(40));
        mainLayout.setStyle("-fx-background-color: #f8f9fa;");

        Label title = new Label("Manage Your Booking");
        title.setFont(Font.font("Arial", 22));
        title.setTextFill(Color.web("#0077B6"));

        VBox buttonBox = new VBox(15);
        buttonBox.setAlignment(Pos.CENTER);

        String[] buttonLabels = {
                "View Boarding Pass",
                "Guest Detail",
                "Flight Summary",
                "Manage Booking",
                "Payment Summary"
        };

        for (String label : buttonLabels) {
            Button btn = new Button(label);
            btn.setFont(Font.font("Arial", 14));
            btn.setPrefWidth(220);
            btn.setStyle(
                    "-fx-background-color: #0077B6; " +
                            "-fx-text-fill: white; " +
                            "-fx-background-radius: 10px;"
            );
            btn.setOnMouseEntered(e -> btn.setStyle("-fx-background-color: #005F8E; -fx-text-fill: white; -fx-background-radius: 10px;"));
            btn.setOnMouseExited(e -> btn.setStyle("-fx-background-color: #0077B6; -fx-text-fill: white; -fx-background-radius: 10px;"));
            buttonBox.getChildren().add(btn);
        }

        mainLayout.getChildren().addAll(title, buttonBox);

        Scene scene = new Scene(mainLayout, 400, 450);
        stage.setScene(scene);
        stage.show();
    }
}
