package com.api.springrest;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringRestApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(SpringRestApplication.class);
        application.setAdditionalProfiles("ssl");
        application.run(args);
    }

    @GetMapping
    @Operation(summary = "Returns Hello World")
    public String index(){
        return "Hello World!";
    }

}
