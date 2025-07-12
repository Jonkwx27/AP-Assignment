package com.airline.models;

import javafx.beans.property.*;

public class Flight {
    private final StringProperty flightNumber;
    private final StringProperty destination;
    private final StringProperty date;
    private final DoubleProperty price;
    private final StringProperty departLocation;
    private final StringProperty journeyType;

    public Flight(String flightNumber, String destination, String date, double price, String departLocation, String journeyType) {
        this.flightNumber = new SimpleStringProperty(flightNumber);
        this.destination = new SimpleStringProperty(destination);
        this.date = new SimpleStringProperty(date);
        this.price = new SimpleDoubleProperty(price);
        this.departLocation = new SimpleStringProperty(departLocation);
        this.journeyType = new SimpleStringProperty(journeyType);
    }

    public String getFlightNumber() { return flightNumber.get(); }
    public String getDestination() { return destination.get(); }
    public String getDate() { return date.get(); }
    public double getPrice() { return price.get(); }
    public String getDepartLocation() { return departLocation.get(); }
    public String getJourneyType() { return journeyType.get(); }

    public StringProperty flightNumberProperty() { return flightNumber; }
    public StringProperty destinationProperty() { return destination; }
    public StringProperty dateProperty() { return date; }
    public DoubleProperty priceProperty() { return price; }
    public StringProperty departLocationProperty() { return departLocation; }
    public StringProperty journeyTypeProperty() { return journeyType; }
}


