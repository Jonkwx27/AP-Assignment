package com.airline.controllers;

import com.airline.pages.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class AdminDashboardController {

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Admin Dashboard");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(20));
        grid.setHgap(20);
        grid.setVgap(20);

        Button button1 = new Button("Update Flight");
        Button button2 = new Button("Update User Flight");
        Button button3 = new Button("View Flights");
        Button button4 = new Button("Reschedule Flight");
        Button button5 = new Button("Reschedule User Flight");
        Button button6 = new Button("View Reschedules");
        Button button7 = new Button("Cancel Flight");
        Button button8 = new Button("Cancel User Flight");
        Button button9 = new Button("View Cancellations");

        Button[] buttons = { button1, button2, button3, button4, button5, button6, button7, button8, button9 };
        for (Button btn : buttons) {
            btn.setMinSize(200, 150);
        }

        button1.setOnAction(e -> UpdateFlightStatusPage.display());
        button2.setOnAction(e -> UpdateUserFlightPage.display());
        button3.setOnAction(e -> FlightOverviewPage.display());
        button4.setOnAction(e -> RescheduleFlightPage.display());
        button5.setOnAction(e -> RescheduleUserFlightPage.display());
        button6.setOnAction(e -> FlightRescheduleOverviewPage.display());
        button7.setOnAction(e -> CancelFlightPage.display());
        button8.setOnAction(e -> CancelUserFlightPage.display());
        button9.setOnAction(e -> FlightCancellationOverviewPage.display());

        grid.add(button1, 0, 0);
        grid.add(button2, 1, 0);
        grid.add(button3, 2, 0);
        grid.add(button4, 0, 1);
        grid.add(button5, 1, 1);
        grid.add(button6, 2, 1);
        grid.add(button7, 0, 2);
        grid.add(button8, 1, 2);
        grid.add(button9, 2, 2);

        Button logoutButton = new Button("Logout");
        logoutButton.setOnAction(e -> {
            LoginController.launchLogin();
            primaryStage.close();
        });

        ToolBar toolBar = new ToolBar(logoutButton);

        BorderPane root = new BorderPane();
        root.setTop(toolBar);
        root.setCenter(grid);

        Scene scene = new Scene(root, 1000, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void launchDashboard() {
        new AdminDashboardController().start(new Stage());
    }
}






