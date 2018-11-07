package com.aasa.tluspring.Hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    @GetMapping
    public String sayHello(String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello.say();
    }
}
