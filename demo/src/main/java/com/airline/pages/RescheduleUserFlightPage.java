package com.airline.pages;

import com.airline.models.DataStore;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;

public class RescheduleUserFlightPage {

    public static void display() {
        Stage window = new Stage();
        window.setTitle("Reschedule User Flight Time");

        ComboBox<String> userCombo = new ComboBox<>();
        userCombo.getItems().addAll(DataStore.users.keySet());

        TextField newTimeField = new TextField();
        newTimeField.setPromptText("Enter custom time");

        Button updateBtn = new Button("Reschedule");
        Label feedback = new Label();

        updateBtn.setOnAction(e -> {
            String user = userCombo.getValue();
            String time = newTimeField.getText();

            if (user != null && !time.isBlank()) {
                String flight = DataStore.users.get(user);
                DataStore.flightTimes.put(flight, time);
                feedback.setText("User " + user + "'s flight rescheduled to " + time);
            } else {
                feedback.setText("Select user and enter new time.");
            }
        });

        VBox layout = new VBox(10,
                new Label("Select User:"), userCombo,
                new Label("New Flight Time:"), newTimeField,
                updateBtn, feedback);
        layout.setAlignment(Pos.CENTER);
        layout.setMinSize(350, 250);

        window.setScene(new Scene(layout));
        window.show();
    }
}

