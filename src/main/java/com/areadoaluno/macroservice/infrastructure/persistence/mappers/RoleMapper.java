package com.areadoaluno.macroservice.infrastructure.persistence.mappers;

import com.areadoaluno.macroservice.domain.models.Role;
import com.areadoaluno.macroservice.infrastructure.persistence.entities.RoleEntity;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {
    public Role toDomain(RoleEntity entity) {
        if (entity == null) {
            return null;
        }

        return Role.builder()
                .id(entity.getId())
                .uuid(entity.getUuid())
                .name(entity.getName())
                .build();
    }

    public RoleEntity toEntity(Role domain) {
        if (domain == null) {
            return null;
        }

        return RoleEntity.builder()
                .id(domain.getId())
                .uuid(domain.getUuid())
                .name(domain.getName())
                .build();
    }
}
