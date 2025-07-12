package com.airline.pages;

import com.airline.models.DataStore;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;

public class UpdateFlightStatusPage {

    public static void display() {
        Stage window = new Stage();
        window.setTitle("Update Flight Status");

        ComboBox<String> flightCombo = new ComboBox<>();
        flightCombo.getItems().addAll(DataStore.flights.keySet());

        ComboBox<String> statusField = new ComboBox<>();
        statusField.getItems().addAll(DataStore.newStatus.keySet());

        Button updateButton = new Button("Update Status");
        Label feedback = new Label();

        updateButton.setOnAction(e -> {
            String flight = flightCombo.getValue();
            String newStatus = statusField.getValue();
            if (flight != null && !newStatus.isBlank()) {
                DataStore.flights.put(flight, newStatus);
                feedback.setText("Updated " + flight + " to " + newStatus);
            } else {
                feedback.setText("Please select a flight and enter a status.");
            }
        });

        VBox layout = new VBox(10, new Label("Select Flight:"), flightCombo,
                new Label("New Status:"), statusField, updateButton, feedback);
        layout.setAlignment(Pos.CENTER);
        layout.setMinSize(350, 250);

        window.setScene(new Scene(layout));
        window.show();
    }
}

