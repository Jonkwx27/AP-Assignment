package com.airline.pages;

import com.airline.models.DataStore;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;

public class FlightOverviewPage {

    public static void display() {
        Stage window = new Stage();
        window.setTitle("Flight Overview");

        TextArea overview = new TextArea();
        overview.setEditable(false);

        StringBuilder content = new StringBuilder();
        content.append("Flights:\n");
        DataStore.flights.forEach((id, status) ->
                content.append("  ").append(id).append(" - ").append(status).append("\n"));

        content.append("\nUser Assignments:\n");
        DataStore.users.forEach((user, flight) ->
                content.append("  ").append(user).append(" → ").append(flight)
                        .append(" (").append(DataStore.flights.getOrDefault(flight, "Unknown")).append(")\n"));

        overview.setText(content.toString());

        VBox layout = new VBox(10, overview);
        layout.setAlignment(Pos.CENTER);
        layout.setMinSize(400, 300);

        window.setScene(new Scene(layout));
        window.show();
    }
}

