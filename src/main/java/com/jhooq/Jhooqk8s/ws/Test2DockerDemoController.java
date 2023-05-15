package com.jhooq.Jhooqk8s.ws;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test2DockerDemoController {

    @GetMapping("/secondo")
    public String test2() {
        return "Hello test 2 - Jhooq-k8s i Have updated the message";
    }
    
    @GetMapping("/")
    public String rroot() {
        return "ROOT 2 - Jhooq-k8s i Have updated the message";
    }
}
