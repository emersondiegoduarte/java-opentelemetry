package com.opentelemetry.javaopentelemetry;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/v1")
@Log4j2
@RequiredArgsConstructor
public class RestController {

    private final UserRepository userRepository;

    private final MeterRegistry registry;

    @GetMapping(value = "/api")
    public ResponseEntity<Object> api() throws InterruptedException {
        log.info("api");
        registry.counter("greetings.total", "name", "api").increment();
        return ResponseEntity.ok().body(userRepository.findAll());
    }


    @GetMapping(value = "/api/v2")
    public ResponseEntity<Object> api1() throws InterruptedException {
        log.info("api 2");
        registry.counter("greetings.total", "name", "api2").increment();
        return ResponseEntity.ok().body(userRepository.findAll());
    }

    @GetMapping(value = "/api/v3")
    public ResponseEntity<Object> api3() throws InterruptedException {
        log.info("api 3");
        registry.counter("greetings.total", "name", "api3").increment();
        throw new RuntimeException("Error");
    }
}
