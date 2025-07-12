package com.airline.pages;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class FaqPage {

    public void showFAQWindow() {
        Stage faqStage = new Stage();

        // === Logo ===
        ImageView logo = new ImageView(new Image("file:logo.png")); // Optional: use getResourceAsStream if stored in resources
        logo.setFitHeight(40);
        logo.setPreserveRatio(true);

        // === Back Button ===
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> faqStage.close());

        // === Title ===
        Label titleLabel = new Label("FAQ");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        // === Top Bar ===
        HBox topBar = new HBox();
        topBar.setPadding(new Insets(10));
        topBar.setAlignment(Pos.CENTER_LEFT);
        topBar.setSpacing(10);
        Region leftSpacer = new Region();
        Region rightSpacer = new Region();
        HBox.setHgrow(leftSpacer, Priority.ALWAYS);
        HBox.setHgrow(rightSpacer, Priority.ALWAYS);
        topBar.getChildren().addAll(logo, leftSpacer, titleLabel, rightSpacer, backButton);
        topBar.setStyle("-fx-background-color: #f0f0f0;");

        // === FAQ List ===
        VBox faqBox = new VBox(15);
        faqBox.setPadding(new Insets(20));
        faqBox.setStyle("-fx-background-color: white;");

        // Add questions and answers
        faqBox.getChildren().addAll(
                createFAQItem("How do I reset my password?", "Click 'Forgot Password' on the login page."),
                createFAQItem("How to contact support?", "Email us at support@example.com."),
                createFAQItem("Where can I find my receipts?", "You can find them under 'My Account' > 'Billing'."),
                createFAQItem("How to delete my account?", "Please contact our support team directly.")
        );

        ScrollPane scrollPane = new ScrollPane(faqBox);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background-color:transparent;");

        // === Layout ===
        BorderPane root = new BorderPane();
        root.setTop(topBar);
        root.setCenter(scrollPane);

        Scene scene = new Scene(root, 800, 600);
        faqStage.setScene(scene);
        faqStage.setTitle("FAQ Page");
        faqStage.show();
    }

    private VBox createFAQItem(String question, String answer) {
        Label qLabel = new Label("Q: " + question);
        qLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");
        Label aLabel = new Label("A: " + answer);
        aLabel.setStyle("-fx-font-size: 14px;");
        VBox faqItem = new VBox(5, qLabel, aLabel);
        faqItem.setPadding(new Insets(10));
        faqItem.setStyle("-fx-background-color: #f9f9f9; -fx-border-color: #ddd;");
        return faqItem;
    }
}
