package com.airline.pages;

import com.airline.models.DataStore;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;

public class UpdateUserFlightPage {

    public static void display() {
        Stage window = new Stage();
        window.setTitle("Update User Flight");

        ComboBox<String> userCombo = new ComboBox<>();
        userCombo.getItems().addAll(DataStore.users.keySet());

        ComboBox<String> flightCombo = new ComboBox<>();
        flightCombo.getItems().addAll(DataStore.flights.keySet());

        Button updateButton = new Button("Update Flight");
        Label feedback = new Label();

        updateButton.setOnAction(e -> {
            String user = userCombo.getValue();
            String newFlight = flightCombo.getValue();
            if (user != null && newFlight != null) {
                DataStore.users.put(user, newFlight);
                feedback.setText("Updated " + user + " to flight " + newFlight);
            } else {
                feedback.setText("Please select a user and a flight.");
            }
        });

        VBox layout = new VBox(10,
                new Label("Select User:"), userCombo,
                new Label("Assign New Flight:"), flightCombo,
                updateButton, feedback);

        layout.setAlignment(Pos.CENTER);
        layout.setMinSize(350, 250);

        window.setScene(new Scene(layout));
        window.show();
    }
}

