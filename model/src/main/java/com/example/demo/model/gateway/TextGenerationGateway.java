package com.example.demo.model.gateway;

/** Outbound port for generating text through an external provider. */
public interface TextGenerationGateway {

    String generateText(String prompt, String model);
}
