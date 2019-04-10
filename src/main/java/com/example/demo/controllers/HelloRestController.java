package com.example.demo.controllers;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.http.HttpEntity;
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
    @RequestMapping(value = "/postName/{name}", method= RequestMethod.POST)
    public ResponseEntity<String> receiveName(@PathVariable String name) {
        System.out.println("in receiveName " + name);
        String result = "works";
        return new ResponseEntity(result,HttpStatus.OK);
        //testcomment
    }
    @PostMapping(value = "/nameUpdate/{name}/{status}")
    public HttpEntity statusChange(@PathVariable String name, @PathVariable String status){
        System.out.println("in statusChange for " + name + " change status to " + status);
        return new HttpEntity(HttpStatus.OK);
    }
}
