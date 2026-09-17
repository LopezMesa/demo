package com.example.demo.model;

import java.util.Objects;

/** Immutable business representation of a greeting. */
public record Greeting(String recipient) {

    public Greeting {
        recipient = requireRecipient(recipient);
    }

    public String message() {
        return "Hola, %s!".formatted(recipient);
    }

    private static String requireRecipient(String recipient) {
        var normalizedRecipient = Objects.requireNonNull(recipient, "recipient must not be null").trim();
        if (normalizedRecipient.isEmpty()) {
            throw new IllegalArgumentException("recipient must not be blank");
        }
        return normalizedRecipient;
    }
}
