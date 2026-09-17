package com.example.demo.usecase;

import com.example.demo.model.gateway.TextGenerationGateway;

import java.util.Objects;

/** Generates text by delegating to the configured external text-generation provider. */
public class GenerateTextUseCase {

    private final TextGenerationGateway textGenerationGateway;

    public GenerateTextUseCase(TextGenerationGateway textGenerationGateway) {
        this.textGenerationGateway = Objects.requireNonNull(textGenerationGateway, "textGenerationGateway must not be null");
    }

    public String generate(String prompt, String model) {
        String response = "";
        try {
         response =  textGenerationGateway.generateText(prompt, model);
        }catch (Exception e){
            System.out.println(e.getMessage());

        }
        return response;
    }
}
