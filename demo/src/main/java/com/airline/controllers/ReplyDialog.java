package com.airline.controllers;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ReplyDialog {

    public static void show(String subject, String question, boolean isLiveChat, String email) {
        Stage dialog = new Stage();
        dialog.setTitle("Reply - " + subject);

        Label emailLabel = null;
        if (!isLiveChat && email != null) {
            emailLabel = new Label("From: " + email);
        }

        Label questionLabel = new Label("Question:");
        TextArea questionArea = new TextArea(question);
        questionArea.setEditable(false);
        questionArea.setWrapText(true);

        Label replyLabel = new Label("Your Reply:");
        TextArea replyArea = new TextArea();
        replyArea.setPromptText("Type your reply here...");
        replyArea.setWrapText(true);

        Button sendButton = new Button("Send");
        sendButton.setOnAction(e -> {
            String replyText = replyArea.getText().trim();
            if (!replyText.isEmpty()) {
                if (isLiveChat) {
                    System.out.println("[LIVE CHAT REPLY] To " + subject + ": " + replyText);
                } else {
                    System.out.println("[EMAIL REPLY] To: " + email + " | Subject: " + subject + " | Message: " + replyText);
                }
                dialog.close();
                showAlert("Reply sent!", "Your reply was successfully sent.");
            } else {
                showAlert("Empty Reply", "Please enter a message before sending.");
            }
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(15));
        layout.setPrefWidth(400);

        if (emailLabel != null) layout.getChildren().add(emailLabel);
        layout.getChildren().addAll(questionLabel, questionArea, replyLabel, replyArea, sendButton);

        Scene scene = new Scene(layout);
        dialog.setScene(scene);
        dialog.show();
    }

    private static void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
