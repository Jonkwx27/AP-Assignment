package com.airline.pages;

import com.airline.controllers.UserDashboardController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ClassSelectionView {

    public VBox createClassSelection(Stage stage, UserDashboardController dashboardController) {
        VBox layout = new VBox(20);
        layout.setPadding(new Insets(30));
        layout.setAlignment(Pos.CENTER);

        Button economyBtn = createClassButton("Economy Class", stage, dashboardController);
        Button businessBtn = createClassButton("Business Class", stage, dashboardController);
        Button firstClassBtn = createClassButton("First Class", stage, dashboardController);

        layout.getChildren().addAll(economyBtn, businessBtn, firstClassBtn);
        return layout;
    }

    private Button createClassButton(String className, Stage stage, UserDashboardController dashboardController) {
        Button btn = new Button(className);
        btn.setPrefSize(250, 60);

        btn.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Class Selection");
            alert.setHeaderText(null);
            alert.setContentText("You have selected: " + className);
            alert.showAndWait();

            dashboardController.setClassSelectionText(className);
            dashboardController.start(stage);
        });

        return btn;
    }
}
