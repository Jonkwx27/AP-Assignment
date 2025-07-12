package com.airline.controllers;

import com.airline.models.EmailQuestion;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AgentDashboardController {

    private final Map<String, String> customerQuestions = new HashMap<>();
    private final List<EmailQuestion> emailQuestionList = new ArrayList<>();

    public static void launchDashboard() {
        new AgentDashboardController().start(new Stage());
    }

    public void start(Stage primaryStage) {
        customerQuestions.put("Alice Chee", "Hi, how do I reset my password?");
        customerQuestions.put("Bobby Foo", "What is the refund policy?");
        customerQuestions.put("Carol Hamilton", "Can I change my shipping address?");

        emailQuestionList.add(new EmailQuestion("Order Delay", "Hello, my order #1234 is delayed. Any update?", "lewis@example.com"));
        emailQuestionList.add(new EmailQuestion("Invoice Request", "Please send me the invoice for my last purchase.", "verstappen@example.com"));
        emailQuestionList.add(new EmailQuestion("Account Issue", "I can't log into my account since yesterday.", "caroline@example.com"));

        ImageView logo = new ImageView(new Image("file:logo.png")); // Replace if needed
        logo.setFitHeight(40);
        logo.setPreserveRatio(true);

        Button logoutButton = new Button("Log Out");
        logoutButton.setOnAction(e -> {
            LoginController.launchLogin();
            primaryStage.close();
        });

        HBox topBar = new HBox();
        topBar.setPadding(new Insets(10));
        topBar.setSpacing(10);
        topBar.setAlignment(Pos.CENTER_LEFT);
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        topBar.getChildren().addAll(logo, spacer, logoutButton);
        topBar.setStyle("-fx-background-color: #f0f0f0;");

        ListView<String> leftList = new ListView<>();
        leftList.getItems().addAll(customerQuestions.keySet());
        leftList.setCellFactory(param -> new CustomActionCell("Reply", true, null, customerQuestions));

        ListView<EmailQuestion> rightList = new ListView<>();
        rightList.getItems().addAll(emailQuestionList);
        rightList.setCellFactory(param -> new ListCell<>() {
            private final HBox content;
            private final Label label = new Label();
            private final Button replyBtn = new Button("Reply");

            {
                Region spacer1 = new Region();
                HBox.setHgrow(spacer1, Priority.ALWAYS);
                content = new HBox(label, spacer1, replyBtn);
                content.setSpacing(10);
                content.setAlignment(Pos.CENTER_LEFT);
                content.setPadding(new Insets(5));

                replyBtn.setOnAction(e -> {
                    EmailQuestion eq = getItem();
                    if (eq != null) {
                        ReplyDialog.show(eq.getSubject(), eq.getMessage(), false, eq.getEmail());
                    }
                });
            }

            @Override
            protected void updateItem(EmailQuestion item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setGraphic(null);
                } else {
                    label.setText(item.getSubject());
                    setGraphic(content);
                }
            }
        });

        HBox listsBox = new HBox(20, leftList, rightList);
        listsBox.setPadding(new Insets(20));
        listsBox.setAlignment(Pos.CENTER);

        BorderPane root = new BorderPane();
        root.setTop(topBar);
        root.setCenter(listsBox);

        Scene scene = new Scene(root, 900, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Customer Service Dashboard");
        primaryStage.show();
    }
}


