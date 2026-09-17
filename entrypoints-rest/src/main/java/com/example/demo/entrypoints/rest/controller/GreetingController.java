package com.example.demo.entrypoints.rest.controller;

import com.example.demo.entrypoints.rest.dto.GreetingRequest;
import com.example.demo.entrypoints.rest.dto.GreetingResponse;
import com.example.demo.model.gateway.TextGenerationGateway;
import com.example.demo.usecase.CreateGreetingUseCase;
import com.example.demo.usecase.GenerateTextUseCase;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/greetings")
public class GreetingController {

    private final GenerateTextUseCase generateTextUseCase;
    private final CreateGreetingUseCase createGreetingUseCase;

    public GreetingController(GenerateTextUseCase generateTextUseCase, CreateGreetingUseCase createGreetingUseCase) {
        this.generateTextUseCase = generateTextUseCase;
        this.createGreetingUseCase = createGreetingUseCase;
    }

    @PostMapping
    public ResponseEntity<GreetingResponse> create(@Valid @RequestBody GreetingRequest request) {
        var greeting = createGreetingUseCase.create(request.name());
        return ResponseEntity.ok(new GreetingResponse(greeting.recipient(), greeting.message()));
    }


    @PostMapping("/generate")
    public ResponseEntity<Map<String, String>> generate(@RequestBody Map<String, String> request) {
        String prompt = request.get("prompt");
        String model = request.get("model");

        if (prompt == null || prompt.isBlank()) {
            return ResponseEntity.badRequest().body(Map.of("error", "El parámetro 'prompt' es obligatorio."));
        }

        String resultado = generateTextUseCase.generate(prompt, model);
        return ResponseEntity.ok(Map.of("respuesta", resultado));
    }

}
