package com.example.restapi_nerzon.controller;

import com.example.restapi_nerzon.entity.Cat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    @Autowired
    private ObjectMapper objectMapper;
    @GetMapping("/api/main")
    public String name(){
        return "hello" ;
    }
    @GetMapping("/api/cat")
    public String givecat()  {
        Cat cat = new Cat("Barsik",5,10);
        String  jsonData =  null ;
        try {
             jsonData = objectMapper.writeValueAsString(cat) ;
        } catch (JsonProcessingException e) {
            System.out.printf("Error with Cat");
        }
        return jsonData ;
    }
    @PostMapping("/api/s")
    public String giveSpecialCat(@RequestParam String name){
        Cat cat = new Cat(name,5,10);
        String  jsonData =  null ;
        try {
            jsonData = objectMapper.writeValueAsString(cat) ;
        } catch (JsonProcessingException e) {
            System.out.printf("Error with Cat");
        }
        return jsonData ;

    }
}
