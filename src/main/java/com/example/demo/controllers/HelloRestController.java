package com.example.demo.controllers;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class HelloRestController {

    @RequestMapping(value = "/helloWorld/{id}", method= RequestMethod.POST)
    public ResponseEntity<String> receiveName(@PathVariable Long id) {
        System.out.println("in receiveName " + id);
        String result = "works";
        return new ResponseEntity(result,HttpStatus.OK);
        //testcomment
    }
    @GetMapping(value = "/hello/{id}")
    public ResponseEntity<String> receiveGet(@PathVariable Long id) {
        System.out.println("in receiveName " + id);
        String result = "works";
        return new ResponseEntity(result,HttpStatus.OK);
        //testcomment
    }
}
