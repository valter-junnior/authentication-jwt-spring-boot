package com.areadoaluno.macroservice.interfaces.dtos.Auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
    @NotBlank(message = "required")
    @Email(message = "email")
    private String email;

    @NotBlank(message = "required")
    private String password;
}
