package com.example.Backend.controller;

import com.example.Backend.entity.PeopleEntity;
import com.example.Backend.entity.PostEntity;
import com.example.Backend.repository.PeopleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/people")
@Slf4j
public class PeopleController {
    @Autowired
    PeopleRepository peopleRepository;

    @GetMapping("/get")
    public List<PeopleEntity> getEntities(){
        List<PeopleEntity> list;
        log.info("[ART CONTROLLER] Before GET");
        list = peopleRepository.findAll();
        log.info("[ART CONTROLLER] After GET Found {}", list.size());
        return peopleRepository.findAll();
    }
}
