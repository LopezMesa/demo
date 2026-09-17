package com.example.demo.usecase;

import com.example.demo.model.Greeting;

/** Creates the greeting requested by an external client. */
public class CreateGreetingUseCase {

    public Greeting create(String recipient) {
        return new Greeting(recipient);
    }
}
