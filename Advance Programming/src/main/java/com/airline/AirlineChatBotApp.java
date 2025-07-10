package com.airline;

import dev.langchain4j.model.openai.OpenAiChatModel;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.Objects;

public class AirlineChatBotApp extends Application {

    private VBox chatContainer;
    private TextField inputField;
    private OpenAiChatModel model;

    @Override
    public void start(Stage primaryStage) {
        // 1) Build your OpenAI-backed chat model once
        model = OpenAiChatModel.builder()
                .apiKey(System.getenv("OPENAI_API_KEY"))  // or hard-code your key here
                .build();

        // 2) Header bar (avatar + title)
        ImageView avatar = new ImageView(new Image(
                Objects.requireNonNull(
                        getClass().getResourceAsStream("/avatar.png")
                )
        ));
        avatar.setFitWidth(40);
        avatar.setFitHeight(40);

        // **make it round:**
        Circle clip = new Circle(20, 20, 20);
        avatar.setClip(clip);

        // build header
        Label title = new Label("Chat with Jonathan");
        HBox header = new HBox(10, avatar, title);
        header.getStyleClass().add("header-bar");


        header.getStyleClass().add("header-bar");
        header.setPadding(new Insets(10));
        header.setAlignment(Pos.CENTER_LEFT);

        // 3) Chat area (VBox inside a ScrollPane)
        chatContainer = new VBox(10);
        chatContainer.setPadding(new Insets(10));
        chatContainer.getStyleClass().add("chat-area");
        // an optional greeting bubble
        chatContainer.getChildren().add(new ChatBubble("Hello! How can I help you today?", false));

        ScrollPane scrollPane = new ScrollPane(chatContainer);
        scrollPane.setFitToWidth(true);

        // 4) Input bar
        inputField = new TextField();
        inputField.setPromptText("Ask about flights, bookings, cancellations…");
        inputField.getStyleClass().add("input-field");

        Button sendButton = new Button("Send");
        sendButton.getStyleClass().add("send-button");
        sendButton.setOnAction(e -> handleUserInput());

        HBox inputBar = new HBox(10, inputField, sendButton);
        inputBar.getStyleClass().add("input-bar");
        inputBar.setPadding(new Insets(10));
        inputBar.setAlignment(Pos.CENTER);

        // 5) Main layout
        BorderPane root = new BorderPane();
        root.setTop(header);
        root.setCenter(scrollPane);
        root.setBottom(inputBar);

        // 6) Scene + CSS
        Scene scene = new Scene(root, 500, 600);
        scene.getStylesheets().add(
                Objects.requireNonNull(getClass().getResource("/style.css"))
                        .toExternalForm()
        );

        primaryStage.setTitle("Airline Ticketing Chatbot");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleUserInput() {
        String userText = inputField.getText().trim();
        if (userText.isEmpty()) return;

        // show user bubble
        chatContainer.getChildren().add(new ChatBubble(userText, true));
        inputField.clear();

        // call OpenAI in a background thread
        new Thread(() -> {
            String botReply;
            try {
                botReply = model.generate(userText);
            } catch (Exception ex) {
                botReply = "⚠️ Error: " + ex.getMessage();
            }
            final String reply = botReply;
            Platform.runLater(() ->
                    chatContainer.getChildren().add(new ChatBubble(reply, false))
            );
        }).start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
