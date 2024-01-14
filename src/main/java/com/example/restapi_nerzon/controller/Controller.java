package com.example.restapi_nerzon.controller;

import com.example.restapi_nerzon.entity.Cat;
import com.example.restapi_nerzon.repa.CatRepa;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class Controller {

 private  final CatRepa catRepa ;
 private final ObjectMapper objectMapper ;
   @PostMapping("/api/add")
    public  void addCat(@RequestBody Cat cat){
      log.info("Новая запись + " , catRepa.save(cat));

   }
   @GetMapping("/api/all")
   @SneakyThrows
    public List<Cat> getAll()  {
       return catRepa.findAll();
   }
   @GetMapping("api")
    public Cat  getCat(@RequestParam int id){
       return catRepa.findById(id).orElseThrow();
   }
   @DeleteMapping("/api")
    public void   deleteCat (@RequestParam int id){
       catRepa.deleteById(id);
   }


}
