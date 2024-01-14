package com.example.restapi_nerzon.repa;

import com.example.restapi_nerzon.entity.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepa extends JpaRepository<Cat,Integer> {

}
