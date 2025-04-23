package com.opentelemetry.javaopentelemetry;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/v1")
@Slf4j
@RequiredArgsConstructor
public class RestController {

    private final UserRepository userRepository;

    private final MeterRegistry registry;

    @GetMapping(value = "/api")
    public ResponseEntity<Object> api() throws InterruptedException {
        log.info("API endpoint called", java.util.Map.of(
            "endpoint", "/api",
            "method", "GET",
            "timestamp", System.currentTimeMillis()
        ));
        registry.counter("greetings.total", "name", "api").increment();
        return ResponseEntity.ok().body(userRepository.findAll());
    }


    @GetMapping(value = "/api/v2")
    public ResponseEntity<Object> api1() throws InterruptedException {
        log.info("API v2 endpoint called", java.util.Map.of(
            "endpoint", "/api/v2",
            "method", "GET",
            "timestamp", System.currentTimeMillis()
        ));
        registry.counter("greetings.total", "name", "api2").increment();
        return ResponseEntity.ok().body(userRepository.findAll());
    }

    @GetMapping(value = "/api/v3")
    public ResponseEntity<Object> api3() throws InterruptedException {
        try {
            log.info("API v3 endpoint called", java.util.Map.of(
                "endpoint", "/api/v3",
                "method", "GET",
                "timestamp", System.currentTimeMillis()
            ));
            registry.counter("greetings.total", "name", "api3").increment();
            throw new RuntimeException("Error");
        } catch (RuntimeException e) {
            log.error("Error in API v3 endpoint", e, java.util.Map.of(
                "endpoint", "/api/v3",
                "error", e.getMessage(),
                "timestamp", System.currentTimeMillis()
            ));
            throw e;
        }
    }
}
