package com.example.Backend.controller;


import com.example.Backend.entity.DeviceEntity;
import com.example.Backend.repository.DeviceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/device_entity")
@Slf4j
public class DeviceController {
    @Autowired
    DeviceRepository deviceRepository;

    @GetMapping("/retrieve")
    public List<DeviceEntity> getEntities(){
        List<DeviceEntity> list;
        log.info("[DEVICE CONTROLLER] Before GET");
        list = deviceRepository.findAll();
        log.info("[DEVICE CONTROLLER] After GET Found {} devices", list.size());
        return deviceRepository.findAll();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public DeviceEntity postEntity(@RequestBody DeviceEntity deviceEntity){
        log.info("[DEVICE CONTROLLER] After POST Found new device {} ", deviceEntity);
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
        log.info("[DEVICE CONTROLLER] After PUT Found updated device {} ", updatedEntity);
        return deviceRepository.save(updatedEntity);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEntity(@PathVariable long id){
        DeviceEntity deletedEntity = deviceRepository.findById(id)
                .orElseThrow(()-> new ResourceAccessException("Not found device with id: "+id));
        log.info("[DEVICE CONTROLLER] After DELETE Found deleted device {} ", deletedEntity);
        deviceRepository.deleteById(id);
    }
}
