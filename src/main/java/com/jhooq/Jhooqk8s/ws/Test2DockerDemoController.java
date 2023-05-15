package com.jhooq.Jhooqk8s.ws;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test2DockerDemoController {

    @GetMapping("/secondo")
    public String secondo() {
        return "Hello test secondo 2 - Jhooq-k8s i Have updated the message";
    }
    
    @GetMapping("/test2")
    public String test2() {
        return "Hello test test2 2 - Jhooq-k8s i Have updated the message";
    }
    
     @GetMapping("/test2/secondo")
    public String testsecondo() {
        return "Hello test test2/secondo 2 - Jhooq-k8s i Have updated the message";
    }
    
    @GetMapping("/")
    public String rroot() {
        return "ROOT 2 - Jhooq-k8s i Have updated the message";
    }
}
