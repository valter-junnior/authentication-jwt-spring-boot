package com.areadoaluno.macroservice.infrastructure.persistence.mappers;

import com.areadoaluno.macroservice.domain.models.User;
import com.areadoaluno.macroservice.infrastructure.persistence.entities.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserMapper {
    private final RoleMapper roleMapper;

    public User toDomain(UserEntity entity) {
        if (entity == null) {
            return null;
        }

        return User.builder()
                .id(entity.getId())
                .uuid(entity.getUuid())
                .name(entity.getName())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .roles(entity.getRoles().stream()
                        .map(roleMapper::toDomain)
                        .collect(Collectors.toSet()))
                .build();
    }

    public UserEntity toEntity(User domain) {
        if (domain == null) {
            return null;
        }

        return UserEntity.builder()
                .id(domain.getId())
                .uuid(domain.getUuid())
                .name(domain.getName())
                .email(domain.getEmail())
                .password(domain.getPassword())
                .roles(domain.getRoles() != null ? domain.getRoles().stream()
                        .map(roleMapper::toEntity)
                        .collect(Collectors.toSet()) : null)
                .build();
    }
}
