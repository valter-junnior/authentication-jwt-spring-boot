package com.areadoaluno.macroservice.interfaces.dtos.Auth;

import com.areadoaluno.macroservice.interfaces.dtos.User.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {
    private String token;
    private UserResponse user;
}

