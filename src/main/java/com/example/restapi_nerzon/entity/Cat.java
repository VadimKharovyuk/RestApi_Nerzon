package com.example.restapi_nerzon.entity;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cat {
    private String name ;
    private int age;
    private int weight ;
}
