package com.rest.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldBean {
    @Autowired
    private MessageSource messageSource;

    // http://localhost:8080/hello-world-internationalize
    @GetMapping(path="/hello-world-internationalize")
    public  String helloWorldInternationalized(@RequestHeader(name = "Accept-language", required = false)Locale locale){
       return messageSource.getMessage("good.morning.message", null, locale);
    }
}




