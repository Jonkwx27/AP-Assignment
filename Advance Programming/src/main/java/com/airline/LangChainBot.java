package com.airline;

import dev.langchain4j.model.openai.OpenAiChatModel;

public class LangChainBot {
    public static void main(String[] args) {
        OpenAiChatModel model = OpenAiChatModel.builder()
                .apiKey("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")
                .build();

        String response = model.generate("What is the status of my flight?");
        System.out.println("Bot: " + response);
    }
}
