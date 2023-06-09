package com.example.exam.repository;

import com.example.exam.entity.ArtilleryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "artillery", path = "artillery")
public interface ArtilleryRepository extends JpaRepository<ArtilleryEntity, Long> {
}
