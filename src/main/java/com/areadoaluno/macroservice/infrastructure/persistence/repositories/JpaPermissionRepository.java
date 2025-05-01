package com.areadoaluno.macroservice.infrastructure.persistence.repositories;

import com.areadoaluno.macroservice.infrastructure.persistence.entities.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaPermissionRepository extends JpaRepository<PermissionEntity, Long> {
    Optional<PermissionEntity> findByName(String name);
}
