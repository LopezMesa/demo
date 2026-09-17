package com.example.demo.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

/** Configuration required by the Gemini outbound adapter. */
@ConfigurationProperties(prefix = "gemini")
public record GeminiProperties(String apiKey) {
}
