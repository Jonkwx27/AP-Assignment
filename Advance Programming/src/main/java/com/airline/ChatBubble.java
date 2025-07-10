package com.airline;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class ChatBubble extends HBox {

    public ChatBubble(String text, boolean fromUser) {
        Label bubble = new Label(text);
        bubble.getStyleClass().addAll("bubble", fromUser ? "user" : "bot");
        bubble.setMaxWidth(300);
        bubble.setWrapText(true);

        setPadding(new Insets(5));
        if (fromUser) {
            setStyle("-fx-alignment: center-right;");
            getChildren().add(bubble);
        } else {
            setStyle("-fx-alignment: center-left;");
            getChildren().add(bubble);
        }
    }

    public static ChatBubble user(String text) {
        return new ChatBubble(text, true);
    }

    public static ChatBubble bot(String text) {
        return new ChatBubble(text, false);
    }
}
