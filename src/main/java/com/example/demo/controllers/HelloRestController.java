package com.example.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class HelloRestController {

    @PostMapping(value = "/helloWorld/{id}")
    public ResponseEntity receiveName(@PathVariable Long id) {
        System.out.println("in receiveName " + id);
        String result = "works";
        return new ResponseEntity(result,HttpStatus.OK);
        //testcomment
    }
    @GetMapping(value = "/hello/{id}")
    public ResponseEntity receiveGet(@PathVariable Long id) {
        System.out.println("in receiveName " + id);
        String result = "works";
        return new ResponseEntity(result,HttpStatus.OK);
        //testcomment
    }
}
