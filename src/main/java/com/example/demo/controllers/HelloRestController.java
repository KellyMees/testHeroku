package com.example.demo.controllers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.google.api.services.dialogflow.v2.model.*;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;
import com.google.api.client.json.JsonGenerator;
import com.google.api.client.json.jackson2.JacksonFactory;

@RestController
public class HelloRestController {
    private static JacksonFactory jacksonFactory = JacksonFactory.getDefaultInstance();


  /*  @RequestMapping(value = "/helloWorld/{id}", method= RequestMethod.POST)
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
    }*/

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/dialogFlow", method = RequestMethod.POST)
    public ResponseEntity<String> webhookCall(@RequestBody String msg) throws IOException{
        System.out.println(msg);
        System.out.println("##############################");
        GoogleCloudDialogflowV2WebhookRequest request = jacksonFactory.createJsonParser(msg)
                .parse(GoogleCloudDialogflowV2WebhookRequest.class);
        for(Map.Entry<String,Object> entry:  request.getQueryResult().getOutputContexts().get(0).getParameters().entrySet()){
            System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
        }
        for(Map.Entry<String,Object> e :request.getOriginalDetectIntentRequest().getPayload().entrySet()){
            if(e.getKey().equals("user")){
                System.out.println(e.getValue());
            }
           // System.out.println("key: " + e.getKey() + " value: " + e.getValue().toString());
        }

       StringWriter stringWriter = new StringWriter();
        JsonGenerator jsonGenerator = jacksonFactory.createJsonGenerator(stringWriter);
        GoogleCloudDialogflowV2WebhookResponse response = new GoogleCloudDialogflowV2WebhookResponse();
        response.setFulfillmentText("Het is gelukt!");

        jsonGenerator.serialize(response);
        jsonGenerator.flush();


        return new ResponseEntity(response, HttpStatus.OK);
    }
}
