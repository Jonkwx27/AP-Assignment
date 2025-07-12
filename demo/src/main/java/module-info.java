module com.airline.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.airline to javafx.fxml;
    exports com.airline;
    exports com.airline.controllers;
    opens com.airline.controllers to javafx.fxml;
}