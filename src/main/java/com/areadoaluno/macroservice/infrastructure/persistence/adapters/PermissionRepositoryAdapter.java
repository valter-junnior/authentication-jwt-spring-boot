package com.areadoaluno.macroservice.infrastructure.persistence.adapters;

import com.areadoaluno.macroservice.domain.models.Permission;
import com.areadoaluno.macroservice.domain.repositories.PermissionRepository;
import com.areadoaluno.macroservice.infrastructure.persistence.entities.PermissionEntity;
import com.areadoaluno.macroservice.infrastructure.persistence.mappers.PermissionMapper;
import com.areadoaluno.macroservice.infrastructure.persistence.repositories.JpaPermissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PermissionRepositoryAdapter implements PermissionRepository {
    private final JpaPermissionRepository jpaPermissionRepository;
    private final PermissionMapper roleMapper;

    @Override
    public Permission findByName(String name) {
        return jpaPermissionRepository.findByName(name).map(roleMapper::toDomain).orElse(null);
    }

    @Override
    public Permission save(Permission role) {
        PermissionEntity roleEntity = roleMapper.toEntity(role);
        PermissionEntity savedEntity = jpaPermissionRepository.save(roleEntity);
        return roleMapper.toDomain(savedEntity);
    }
}
