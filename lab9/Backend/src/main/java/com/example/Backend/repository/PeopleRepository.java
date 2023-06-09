package com.example.Backend.repository;

import com.example.Backend.entity.PeopleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface PeopleRepository extends JpaRepository<PeopleEntity, Long> {
}
