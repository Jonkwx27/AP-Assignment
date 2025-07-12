package com.airline.controllers;

import com.airline.controllers.AdminDashboardController;
import com.airline.controllers.AgentDashboardController;
import com.airline.controllers.UserDashboardController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class LoginController {

    public static void launchLogin() {
        Stage loginStage = new Stage();

        // ==== Title Label ====
        Label titleLabel = new Label("Welcome to Astra Airline!");
        titleLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #2a4d9b;");
        titleLabel.setAlignment(Pos.CENTER);

        // ==== UI Components ====
        Label userLabel = new Label("Username:");
        TextField usernameField = new TextField();

        Label passLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();

        Label messageLabel = new Label();
        Button loginButton = new Button("Login");

        // ==== Form Layout ====
        GridPane formGrid = new GridPane();
        formGrid.setAlignment(Pos.CENTER);
        formGrid.setHgap(10);
        formGrid.setVgap(10);
        formGrid.setPadding(new Insets(10, 10, 10, 10));

        formGrid.add(userLabel, 0, 0);
        formGrid.add(usernameField, 1, 0);
        formGrid.add(passLabel, 0, 1);
        formGrid.add(passwordField, 1, 1);
        formGrid.add(loginButton, 1, 2);
        formGrid.add(messageLabel, 1, 3);

        // ==== VBox Layout ====
        VBox root = new VBox(15);
        root.setAlignment(Pos.TOP_CENTER);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(titleLabel, formGrid);

        // ==== Login Logic ====
        loginButton.setOnAction(e -> {
            String username = usernameField.getText().trim();
            String password = passwordField.getText().trim();

            try {
                if (username.equals("admin") && password.equals("admin123")) {
                    AdminDashboardController.launchDashboard();
                    loginStage.close();
                } else if (username.equals("user") && password.equals("user123")) {
                    UserDashboardController.launchDashboard();
                    loginStage.close();
                } else if (username.equals("agent") && password.equals("agent123")) {
                    AgentDashboardController.launchDashboard();
                    loginStage.close();
                } else {
                    messageLabel.setText("Invalid credentials.");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                messageLabel.setText("Error loading dashboard.");
            }
        });

        Scene scene = new Scene(root, 400, 300);
        loginStage.setTitle("Login");
        loginStage.setScene(scene);
        loginStage.show();
    }
}







