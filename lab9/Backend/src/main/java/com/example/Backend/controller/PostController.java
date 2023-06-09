package com.example.Backend.controller;

import com.example.Backend.entity.PostEntity;
import com.example.Backend.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/post")
@Slf4j
public class PostController {
    @Autowired
    PostRepository postRepository;

    @GetMapping("/get")
    public List<PostEntity> getEntities(){
        List<PostEntity> list;
        log.info("[ART CONTROLLER] Before GET");
        list = postRepository.findAll();
        log.info("[ART CONTROLLER] After GET Found {}", list.size());
        return postRepository.findAll();
    }

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public PostEntity postEntity(@RequestBody PostEntity postEntity){
        log.info("[ART CONTROLLER] After POST Found new {} ", postEntity);
        return postRepository.save(postEntity);
    }

    @PutMapping("/put/{id}")
    public PostEntity putEntity(@PathVariable long id, @RequestBody PostEntity newEntity){
        PostEntity updatedEntity = postRepository.findById(id)
                .orElseThrow(()-> new ResourceAccessException("Not found ArtilleryEntity with id: "+id));
        updatedEntity.setName(newEntity.getName());
        updatedEntity.setStart(newEntity.getStart());
        updatedEntity.setEndd(newEntity.getEndd());
        updatedEntity.setStatus(newEntity.getStatus());
        log.info("[ART CONTROLLER] After PUT Found updated {} ", updatedEntity);
        return postRepository.save(updatedEntity);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEntity(@PathVariable long id){
        PostEntity deletedEntity = postRepository.findById(id)
                .orElseThrow(()-> new ResourceAccessException("Not found ArtilleryEntity with id: "+id));
        log.info("[ART CONTROLLER] After DELETE Found deleted {} ", deletedEntity);
        postRepository.deleteById(id);
    }
}
