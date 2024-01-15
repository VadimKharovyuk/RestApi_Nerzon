package com.example.restapi_nerzon.controller;

import com.example.restapi_nerzon.dto.CatDto;
import com.example.restapi_nerzon.entity.Cat;
import com.example.restapi_nerzon.repa.CatRepa;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "main_methods")

@RestController
@Slf4j
@RequiredArgsConstructor
public class Controller {

 private  final CatRepa catRepa ;
 @Operation(
         summary = "Кладет  нового котика в  базу",
         description = "Получает ДТО кота  и билдером  сохраняет кота в базу"
 )
   @PostMapping("/api/add")
    public  void addCat(@RequestBody CatDto catDto){

      log.info("Новая запись + " , catRepa.save(
              Cat.builder()
                      .age(catDto.getAge())
                      .weight(catDto.getWeight())
                      .name(catDto.getName())
              .build()));

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
