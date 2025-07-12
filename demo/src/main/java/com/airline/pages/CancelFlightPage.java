package com.airline.pages;

import com.airline.models.DataStore;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;

public class CancelFlightPage {

    public static void display() {
        Stage window = new Stage();
        window.setTitle("Cancel Flight");

        ComboBox<String> flightCombo = new ComboBox<>();
        flightCombo.getItems().addAll(DataStore.flights.keySet());

        Button cancelButton = new Button("Cancel Flight");
        Label feedback = new Label();

        cancelButton.setOnAction(e -> {
            String flight = flightCombo.getValue();
            if (flight != null) {
                DataStore.cancelledFlights.add(flight);
                DataStore.flights.put(flight, "Cancelled");
                feedback.setText("Flight " + flight + " has been cancelled.");
            } else {
                feedback.setText("Please select a flight to cancel.");
            }
        });

        VBox layout = new VBox(10,
                new Label("Select Flight to Cancel:"), flightCombo,
                cancelButton, feedback);
        layout.setAlignment(Pos.CENTER);
        layout.setMinSize(350, 200);

        window.setScene(new Scene(layout));
        window.show();
    }
}

