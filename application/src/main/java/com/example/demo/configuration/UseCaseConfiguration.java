package com.example.demo.configuration;

import com.example.demo.drivenadapters.gemini.GeminiService;
import com.example.demo.model.gateway.TextGenerationGateway;
import com.example.demo.usecase.CreateGreetingUseCase;
import com.example.demo.usecase.GenerateTextUseCase;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

/** Composition root for framework-independent application services. */
@Configuration
@EnableConfigurationProperties(GeminiProperties.class)
public class UseCaseConfiguration {

    @Bean
    CreateGreetingUseCase createGreetingUseCase() {
        return new CreateGreetingUseCase();
    }

    @Bean
    TextGenerationGateway textGenerationGateway(GeminiProperties properties) {
        var apiKey = Objects.requireNonNullElse(properties.apiKey(), "").trim();
        if (apiKey.isEmpty()) {
            return (prompt, model) -> {
                throw new IllegalStateException("Text generation is not configured");
            };
        }
        return new GeminiService(apiKey);
    }

    @Bean
    GenerateTextUseCase generateTextUseCase(TextGenerationGateway textGenerationGateway) {
        return new GenerateTextUseCase(textGenerationGateway);
    }
}
