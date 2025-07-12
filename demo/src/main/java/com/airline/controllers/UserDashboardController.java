package com.airline.controllers;

import com.airline.pages.ClassSelectionView;
import com.airline.pages.FlightSearchComponent;
import com.airline.pages.FaqPage;
import com.airline.pages.UserBookingPage;
import com.airline.pages.UserProfilePage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class UserDashboardController {
    private Button classSelectionBtn;

    public static void launchDashboard() {
        new UserDashboardController().start(new Stage());
    }

    public void start(Stage primaryStage) {
        BorderPane layout = new BorderPane();
        layout.setBackground(new Background(new BackgroundFill(Color.web("#f9fafb"), CornerRadii.EMPTY, Insets.EMPTY)));

        // ---------- TOP BAR ----------
        HBox topMenu = createTopMenu(primaryStage);
        BorderPane topLayout = new BorderPane();
        topLayout.setCenter(topMenu); // Align buttons to center
        topLayout.setPadding(new Insets(15, 40, 15, 40));
        topLayout.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        topLayout.setBorder(new Border(new BorderStroke(Color.web("#dee2e6"), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(0, 0, 1, 0))));
        layout.setTop(topLayout);

        // ---------- CENTER ----------
        VBox centerBox = new VBox(30);
        centerBox.setAlignment(Pos.TOP_CENTER);
        centerBox.setPadding(new Insets(50));

        classSelectionBtn = createPrimaryButton("Class Selections");
        classSelectionBtn.setPrefSize(200, 50);
        classSelectionBtn.setOnAction(e -> {
            ClassSelectionView classSelectionView = new ClassSelectionView();
            Scene classScene = new Scene(classSelectionView.createClassSelection(primaryStage, this), 900, 600);
            primaryStage.setScene(classScene);
        });

        GridPane grid = new GridPane();
        grid.setHgap(25);
        grid.setVgap(25);
        grid.setAlignment(Pos.CENTER);

        grid.add(createSecondaryButton("Depart"), 0, 0);
        grid.add(createSecondaryButton("Return"), 1, 0);
        grid.add(createSecondaryButton("Journey Type"), 2, 0);

        Button searchBtn = createSecondaryButton("Search");
        searchBtn.setOnAction(e -> new FlightSearchComponent().showSearchWindow());
        grid.add(searchBtn, 3, 0);

        centerBox.getChildren().addAll(classSelectionBtn, grid);
        layout.setCenter(centerBox);

        // ---------- CHATBOX ----------
        Button chatboxBtn = createSecondaryButton("Chatbox");
        BorderPane.setMargin(chatboxBtn, new Insets(20));
        layout.setBottom(chatboxBtn);
        BorderPane.setAlignment(chatboxBtn, Pos.CENTER_RIGHT);

        Scene scene = new Scene(layout, 900, 600);
        primaryStage.setTitle("User Dashboard");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void setClassSelectionText(String text) {
        classSelectionBtn.setText(text);
    }

    private HBox createTopMenu(Stage primaryStage) {
        HBox topMenu = new HBox(25);
        topMenu.setAlignment(Pos.CENTER); // Center the button row

        Button bookingBtn = createLinkButton("My Booking");
        Button faqBtn = createLinkButton("FAQ");
        Button profileBtn = createLinkButton("Profile");
        Button logoutBtn = createLinkButton("Log Out");

        // ✅ My Booking action
        bookingBtn.setOnAction(e -> new UserBookingPage().showBookingWindow());

        // ✅ FAQ action
        faqBtn.setOnAction(e -> new FaqPage().showFAQWindow());

        // ✅ Profile action
        profileBtn.setOnAction(e -> new UserProfilePage().showProfileWindow());

        // ✅ Logout action
        logoutBtn.setOnAction(e -> {
            primaryStage.close();
            LoginController.launchLogin();
        });

        topMenu.getChildren().addAll(bookingBtn, faqBtn, profileBtn, logoutBtn);
        return topMenu;
    }

    private Button createPrimaryButton(String text) {
        Button button = new Button(text);
        button.setFont(Font.font("Arial", 15));
        styleButton(button, "#0077B6", "#005F8E", Color.WHITE, Color.WHITE);
        return button;
    }

    private Button createSecondaryButton(String text) {
        Button button = new Button(text);
        button.setFont(Font.font("Arial", 14));
        styleButton(button, "#e9ecef", "#ced4da", Color.web("#343a40"), Color.web("#343a40"));
        return button;
    }

    private Button createLinkButton(String text) {
        Button button = new Button(text);
        button.setFont(Font.font("Arial", 13));
        styleButton(button, "transparent", "#f1f3f5", Color.web("#0077B6"), Color.web("#005F8E"));
        return button;
    }

    private void styleButton(Button button, String normalBg, String hoverBg, Color normalTextColor, Color hoverTextColor) {
        button.setStyle("-fx-background-color: " + normalBg + "; -fx-text-fill: " + toRgbString(normalTextColor) + "; -fx-background-radius: 10px;");
        button.setPrefSize(130, 40);

        button.setOnMouseEntered(e -> button.setStyle("-fx-background-color: " + hoverBg + "; -fx-text-fill: " + toRgbString(hoverTextColor) + "; -fx-background-radius: 10px;"));
        button.setOnMouseExited(e -> button.setStyle("-fx-background-color: " + normalBg + "; -fx-text-fill: " + toRgbString(normalTextColor) + "; -fx-background-radius: 10px;"));
    }

    private String toRgbString(Color c) {
        return "rgb(" + (int) (c.getRed() * 255) + "," + (int) (c.getGreen() * 255) + "," + (int) (c.getBlue() * 255) + ")";
    }
}








