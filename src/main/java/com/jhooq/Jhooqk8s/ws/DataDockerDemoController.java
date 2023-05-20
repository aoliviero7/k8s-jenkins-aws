package com.jhooq.Jhooqk8s.ws;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataDockerDemoController {

    @GetMapping("/data")
    public String hello() {
        return "Hello data manager- Jhooq-k8s i Have updated the message";
    }
    
    @GetMapping("/")
    public String root() {
        return "ROOT";
    }
}
