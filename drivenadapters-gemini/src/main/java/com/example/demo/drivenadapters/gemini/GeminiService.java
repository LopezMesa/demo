package com.example.demo.drivenadapters.gemini;

import com.example.demo.model.gateway.TextGenerationGateway;
import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

import java.util.Objects;

/** Gemini implementation of the text-generation outbound port. */
public class GeminiService implements TextGenerationGateway {

    private static final String DEFAULT_MODEL = "gemini-2.5-flash";

    private final Client client;

    public GeminiService(String apiKey) {
        var normalizedApiKey = Objects.requireNonNull(apiKey, "apiKey must not be null").trim();
        if (normalizedApiKey.isEmpty()) {
            throw new IllegalArgumentException("Gemini API key must not be blank");
        }
        this.client = Client.builder().apiKey(normalizedApiKey).build();
    }

    @Override
    public String generateText(String prompt, String model) {
        var selectedModel = model == null || model.isBlank() ? DEFAULT_MODEL : model;
        GenerateContentResponse response = client.models.generateContent(selectedModel, prompt, null);
        return response.text();
    }
}
