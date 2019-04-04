package com.example.demo.controllers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
public class HelloRestController {

    @PostMapping(value = "/helloWorld/{id}")
    public HttpEntity receiveName(@PathVariable Long id) {
        System.out.println("in receiveName " + id);
        return new HttpEntity(HttpStatus.OK);
        //testcomment
    }
}
