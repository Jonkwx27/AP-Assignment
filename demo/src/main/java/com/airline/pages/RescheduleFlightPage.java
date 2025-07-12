package com.airline.pages;

import com.airline.models.DataStore;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;

public class RescheduleFlightPage {

    public static void display() {
        Stage window = new Stage();
        window.setTitle("Reschedule Flight");

        ComboBox<String> flightCombo = new ComboBox<>();
        flightCombo.getItems().addAll(DataStore.flights.keySet());

        TextField timeField = new TextField();
        timeField.setPromptText("New Time (e.g., 10:15 AM)");

        Button updateBtn = new Button("Reschedule");
        Label feedback = new Label();

        updateBtn.setOnAction(e -> {
            String flight = flightCombo.getValue();
            String newTime = timeField.getText();

            if (flight != null && !newTime.isBlank()) {
                DataStore.flightTimes.put(flight, newTime);
                feedback.setText("Flight " + flight + " rescheduled to " + newTime);
            } else {
                feedback.setText("Select flight and enter new time.");
            }
        });

        VBox layout = new VBox(10,
                new Label("Select Flight:"), flightCombo,
                new Label("New Time:"), timeField,
                updateBtn, feedback);
        layout.setAlignment(Pos.CENTER);
        layout.setMinSize(350, 250);

        window.setScene(new Scene(layout));
        window.show();
    }
}

