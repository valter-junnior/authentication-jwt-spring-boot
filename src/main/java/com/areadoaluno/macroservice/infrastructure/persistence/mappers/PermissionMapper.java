package com.areadoaluno.macroservice.infrastructure.persistence.mappers;

import com.areadoaluno.macroservice.domain.models.Permission;
import com.areadoaluno.macroservice.infrastructure.persistence.entities.PermissionEntity;
import org.springframework.stereotype.Component;

@Component
public class PermissionMapper {
    public Permission toDomain(PermissionEntity entity) {
        if (entity == null) {
            return null;
        }

        return Permission.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    public PermissionEntity toEntity(Permission domain) {
        if (domain == null) {
            return null;
        }

        return PermissionEntity.builder()
                .id(domain.getId())
                .name(domain.getName())
                .build();
    }
}
