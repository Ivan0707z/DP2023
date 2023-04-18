package com.example.Backend.controller;


import com.example.Backend.entity.DeviceEntity;
import com.example.Backend.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/device_entity")
public class DeviceController {
    @Autowired
    DeviceRepository deviceRepository;

    @GetMapping("/retrieve")
    public List<DeviceEntity> getEntities(){
        return deviceRepository.findAll();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public DeviceEntity postEntity(@RequestBody DeviceEntity deviceEntity){
        return deviceRepository.save(deviceEntity);
    }

    @PutMapping("/update/{id}")
    public DeviceEntity putEntity(@PathVariable long id, @RequestBody DeviceEntity newEntity){
        DeviceEntity updatedEntity = deviceRepository.findById(id)
                .orElseThrow(()-> new ResourceAccessException("Not found guitarEntity with id: "+id));
        updatedEntity.setName(newEntity.getName());
        updatedEntity.setImage(newEntity.getImage());
        updatedEntity.setAmount(newEntity.getAmount());
        updatedEntity.setType(newEntity.getType());
        updatedEntity.setDescription(newEntity.getDescription());
        updatedEntity.setPrice(newEntity.getPrice());
        return deviceRepository.save(updatedEntity);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEntity(@PathVariable long id){
        deviceRepository.deleteById(id);
    }
}
