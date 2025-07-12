package com.airline.pages;

import com.airline.models.DataStore;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;

public class FlightRescheduleOverviewPage {

    public static void display() {
        Stage window = new Stage();
        window.setTitle("Rescheduling Overview");

        TextArea output = new TextArea();
        output.setEditable(false);

        StringBuilder sb = new StringBuilder();
        sb.append("Flight Times:\n");
        DataStore.flightTimes.forEach((flight, time) ->
                sb.append("  ").append(flight).append(" → ").append(time).append("\n"));

        sb.append("\nUser Flight Assignments with Time:\n");
        DataStore.users.forEach((user, flight) -> {
            String time = DataStore.flightTimes.getOrDefault(flight, "N/A");
            sb.append("  ").append(user).append(" → ").append(flight).append(" @ ").append(time).append("\n");
        });

        output.setText(sb.toString());

        VBox layout = new VBox(10, output);
        layout.setAlignment(Pos.CENTER);
        layout.setMinSize(400, 300);

        window.setScene(new Scene(layout));
        window.show();
    }
}

