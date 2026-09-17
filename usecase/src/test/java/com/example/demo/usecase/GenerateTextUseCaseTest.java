package com.example.demo.usecase;

import com.example.demo.model.gateway.TextGenerationGateway;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GenerateTextUseCaseTest {

    @Test
    void shouldDelegateTextGenerationToTheConfiguredGateway() {
        // Given
        TextGenerationGateway gateway = (prompt, model) -> "%s:%s".formatted(model, prompt);
        var useCase = new GenerateTextUseCase(gateway);

        // When
        var generatedText = useCase.generate("Hola", "gemini-test");

        // Then
        assertThat(generatedText).isEqualTo("gemini-test:Hola");
    }
}
