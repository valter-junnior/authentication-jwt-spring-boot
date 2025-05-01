package com.areadoaluno.macroservice.interfaces.dtos.User;

import com.areadoaluno.macroservice.domain.models.User;
import lombok.Getter;

import java.util.UUID;

@Getter
public class UserResponse {
    private final UUID uuid;
    private final String name;
    private final String email;

    public UserResponse(User user) {
        this.uuid = user.getUuid();
        this.name = user.getName();
        this.email = user.getEmail();
    }
}
