package com.areadoaluno.macroservice.infrastructure.persistence.adapters;

import com.areadoaluno.macroservice.domain.models.Role;
import com.areadoaluno.macroservice.domain.repositories.RoleRepository;
import com.areadoaluno.macroservice.infrastructure.persistence.entities.RoleEntity;
import com.areadoaluno.macroservice.infrastructure.persistence.mappers.RoleMapper;
import com.areadoaluno.macroservice.infrastructure.persistence.repositories.JpaRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoleRepositoryAdapter implements RoleRepository {
    private final JpaRoleRepository jpaRoleRepository;
    private final RoleMapper roleMapper;

    @Override
    public Role findByName(String name) {
        return jpaRoleRepository.findByName(name)
                .map(roleMapper::toDomain)
                .orElse(null);
    }

    @Override
    public Role save(Role role) {
        RoleEntity roleEntity = roleMapper.toEntity(role);
        RoleEntity savedEntity = jpaRoleRepository.save(roleEntity);
        return roleMapper.toDomain(savedEntity);
    }
}
