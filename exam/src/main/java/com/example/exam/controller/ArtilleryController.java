package com.example.exam.controller;

import com.example.exam.entity.ArtilleryEntity;
import com.example.exam.repository.ArtilleryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/artillery")
@Slf4j
public class ArtilleryController {
    @Autowired
    ArtilleryRepository artilleryRepository;

    @GetMapping("/get")
    public List<ArtilleryEntity> getEntities(){
        List<ArtilleryEntity> list;
        log.info("[ART CONTROLLER] Before GET");
        list = artilleryRepository.findAll();
        log.info("[ART CONTROLLER] After GET Found {}", list.size());
        return artilleryRepository.findAll();
    }

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public ArtilleryEntity postEntity(@RequestBody ArtilleryEntity guitarEntity){
        log.info("[ART CONTROLLER] After POST Found new {} ", guitarEntity);
        return artilleryRepository.save(guitarEntity);
    }

    @PutMapping("/put/{id}")
    public ArtilleryEntity putEntity(@PathVariable long id, @RequestBody ArtilleryEntity newEntity){
        ArtilleryEntity updatedEntity = artilleryRepository.findById(id)
                .orElseThrow(()-> new ResourceAccessException("Not found ArtilleryEntity with id: "+id));
        updatedEntity.setName(newEntity.getName());
        updatedEntity.setPhoto(newEntity.getPhoto());
        updatedEntity.setPower(newEntity.getPower());
        updatedEntity.setPrice(newEntity.getPrice());
        log.info("[ART CONTROLLER] After PUT Found updated {} ", updatedEntity);
        return artilleryRepository.save(updatedEntity);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEntity(@PathVariable long id){
        ArtilleryEntity deletedEntity = artilleryRepository.findById(id)
                .orElseThrow(()-> new ResourceAccessException("Not found ArtilleryEntity with id: "+id));
        log.info("[ART CONTROLLER] After DELETE Found deleted {} ", deletedEntity);
        artilleryRepository.deleteById(id);
    }
}
