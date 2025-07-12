package com.airline.pages;

import com.airline.models.DataStore;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;

public class CancelUserFlightPage {

    public static void display() {
        Stage window = new Stage();
        window.setTitle("Cancel User Flight");

        ComboBox<String> userCombo = new ComboBox<>();
        userCombo.getItems().addAll(DataStore.users.keySet());

        Button cancelButton = new Button("Cancel User's Flight");
        Label feedback = new Label();

        cancelButton.setOnAction(e -> {
            String user = userCombo.getValue();
            if (user != null) {
                DataStore.cancelledUsers.add(user);
                DataStore.users.remove(user);
                feedback.setText("User " + user + "'s flight has been cancelled.");
            } else {
                feedback.setText("Please select a user to cancel.");
            }
        });

        VBox layout = new VBox(10,
                new Label("Select User to Cancel Flight:"), userCombo,
                cancelButton, feedback);
        layout.setAlignment(Pos.CENTER);
        layout.setMinSize(350, 200);

        window.setScene(new Scene(layout));
        window.show();
    }
}


