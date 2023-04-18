package com.example.Backend.repository;

import com.example.Backend.entity.DeviceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(collectionResourceRel = "devices", path = "devices")
public interface DeviceRepository extends JpaRepository<DeviceEntity, Long> {
}
