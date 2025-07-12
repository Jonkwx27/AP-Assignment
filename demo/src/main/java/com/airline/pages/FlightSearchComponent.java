package com.airline.pages;

import com.airline.models.Flight;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FlightSearchComponent {

    private final ObservableList<Flight> flights = FXCollections.observableArrayList();
    private final TableView<Flight> table = new TableView<>();

    public void showSearchWindow() {
        // Dummy data
        flights.addAll(
                new Flight("AA001", "Tokyo", "2025-07-15", 500.0, "Kuala Lumpur", "One-way"),
                new Flight("AA002", "London", "2025-07-16", 750.0, "Penang", "Round-trip"),
                new Flight("AA003", "Tokyo", "2025-07-15", 450.0, "Johor Bahru", "One-way"),
                new Flight("AA004", "Paris", "2025-07-17", 600.0, "Kuala Lumpur", "One-way"),
                new Flight("AA005", "Paris", "2025-07-15", 700.0, "Kota Kinabalu", "Round-trip")
        );

        // Search fields
        TextField destinationField = new TextField();
        destinationField.setPromptText("Destination");

        TextField dateField = new TextField();
        dateField.setPromptText("Date (YYYY-MM-DD)");

        TextField priceField = new TextField();
        priceField.setPromptText("Max Price");

        Button searchButton = new Button("Search");

        // Table columns
        TableColumn<Flight, String> flightCol = new TableColumn<>("Flight #");
        flightCol.setCellValueFactory(data -> data.getValue().flightNumberProperty());

        TableColumn<Flight, String> destCol = new TableColumn<>("Destination");
        destCol.setCellValueFactory(data -> data.getValue().destinationProperty());

        TableColumn<Flight, String> dateCol = new TableColumn<>("Date");
        dateCol.setCellValueFactory(data -> data.getValue().dateProperty());

        TableColumn<Flight, Number> priceCol = new TableColumn<>("Price");
        priceCol.setCellValueFactory(data -> data.getValue().priceProperty());

        TableColumn<Flight, String> departCol = new TableColumn<>("Depart Location");
        departCol.setCellValueFactory(data -> data.getValue().departLocationProperty());

        TableColumn<Flight, String> journeyCol = new TableColumn<>("Journey Type");
        journeyCol.setCellValueFactory(data -> data.getValue().journeyTypeProperty());

        table.getColumns().setAll(flightCol, destCol, dateCol, priceCol, departCol, journeyCol);

        // Search action
        searchButton.setOnAction(e -> {
            String dest = destinationField.getText().trim().toLowerCase();
            String date = dateField.getText().trim();
            String priceText = priceField.getText().trim();
            Double maxPrice = null;

            if (!priceText.isEmpty()) {
                try {
                    maxPrice = Double.parseDouble(priceText);
                } catch (NumberFormatException ex) {
                    new Alert(Alert.AlertType.ERROR, "Invalid price!").show();
                    return;
                }
            }

            ObservableList<Flight> filtered = FXCollections.observableArrayList();
            for (Flight f : flights) {
                boolean match = true;
                if (!dest.isEmpty() && !f.getDestination().toLowerCase().contains(dest)) match = false;
                if (!date.isEmpty() && !f.getDate().equals(date)) match = false;
                if (maxPrice != null && f.getPrice() > maxPrice) match = false;
                if (match) filtered.add(f);
            }
            table.setItems(filtered);
        });

        VBox layout = new VBox(10, destinationField, dateField, priceField, searchButton, table);
        layout.setPadding(new Insets(15));

        Stage stage = new Stage();
        stage.setScene(new Scene(layout, 700, 500));
        stage.setTitle("Flight Search");
        stage.show();
    }
}



