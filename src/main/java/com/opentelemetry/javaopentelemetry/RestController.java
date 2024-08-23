package com.opentelemetry.javaopentelemetry;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/v1")
@Log4j2
@RequiredArgsConstructor
public class RestController {

    private final UserRepository userRepository;

    @GetMapping(value = "/api")
    public String api() throws InterruptedException {
        log.info("api");
        userRepository.findAll().forEach(System.out::println);
        log.info("api 2");
        return "Hello World!";
    }
}
