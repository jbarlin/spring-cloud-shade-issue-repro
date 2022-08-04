package com.jbarlin.example.demo;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Mono;

@Controller
public class SimpleController {

    private final SimpleConfig simpleConfig;

    public SimpleController(@NonNull final SimpleConfig simpleConfig) {
        this.simpleConfig = simpleConfig;
    }

    @GetMapping("/yo")
    public Mono<String> retrieveMessage() {
        return Mono.fromSupplier(simpleConfig::message);
    }
}
