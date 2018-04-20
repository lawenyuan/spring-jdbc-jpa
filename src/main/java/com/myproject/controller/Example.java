package com.myproject.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Example {
    @Value("${content}")
    private String content;
    @RequestMapping(value = "/hello", produces = "text/html; charset=UTF-8")
    String home(){
        return content;
    }
}
