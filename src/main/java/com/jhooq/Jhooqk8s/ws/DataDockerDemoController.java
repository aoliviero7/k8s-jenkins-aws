package com.jhooq.Jhooqk8s.ws;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataDockerDemoController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello - Jhooq-k8s i Have updated the message";
    }
    
    @GetMapping("/")
    public String root() {
        return "ROOT";
    }
}
