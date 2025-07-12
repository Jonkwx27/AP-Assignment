package com.airline.pages;

import com.airline.models.DataStore;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;

public class FlightCancellationOverviewPage {

    public static void display() {
        Stage window = new Stage();
        window.setTitle("Flight Cancellation Overview");

        TextArea output = new TextArea();
        output.setEditable(false);

        StringBuilder sb = new StringBuilder();

        sb.append("Cancelled Flights:\n");
        if (DataStore.cancelledFlights.isEmpty()) {
            sb.append("  None\n");
        } else {
            for (String f : DataStore.cancelledFlights) {
                sb.append("  ").append(f).append("\n");
            }
        }

        sb.append("\nUsers Removed from Flights:\n");
        if (DataStore.cancelledUsers.isEmpty()) {
            sb.append("  None\n");
        } else {
            for (String u : DataStore.cancelledUsers) {
                sb.append("  ").append(u).append("\n");
            }
        }

        output.setText(sb.toString());

        VBox layout = new VBox(10, output);
        layout.setAlignment(Pos.CENTER);
        layout.setMinSize(400, 300);

        window.setScene(new Scene(layout));
        window.show();
    }
}
