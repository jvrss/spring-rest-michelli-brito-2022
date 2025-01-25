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
    @Operation(summary = "Returns Github page as iframe")
    public String index() {
        return "<iframe src=\"https://github.com/jvrss/spring-rest-michelli-brito-2022\" width=\"100%\" height=\"100%\"></iframe>";
    }

}
