package com.airline;

import com.airline.controllers.LoginController;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        LoginController.launchLogin(); // This method now only shows a window, no launch() call inside
    }

    public static void main(String[] args) {
        launch(args);
    }
}





