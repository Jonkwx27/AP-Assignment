package com.airline.controllers;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.util.Map;

public class CustomActionCell extends ListCell<String> {
    private final HBox content;
    private final Label label;
    private final Button replyButton;

    public CustomActionCell(String buttonText, boolean isCustomer, String unused, Map<String, String> customerData) {
        label = new Label();
        replyButton = new Button(buttonText);

        replyButton.setOnAction(e -> {
            String item = getItem();
            if (item != null) {
                String question = customerData.get(item);
                ReplyDialog.show(item, question, true, null);
            }
        });

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        content = new HBox(label, spacer, replyButton);
        content.setAlignment(Pos.CENTER_LEFT);
        content.setSpacing(10);
        content.setPadding(new Insets(5));
    }

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if (empty || item == null) {
            setGraphic(null);
        } else {
            label.setText(item);
            setGraphic(content);
        }
    }
}

