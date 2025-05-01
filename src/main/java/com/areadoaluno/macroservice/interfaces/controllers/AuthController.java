package com.areadoaluno.macroservice.interfaces.controllers;

import com.areadoaluno.macroservice.application.services.AuthService;
import com.areadoaluno.macroservice.domain.useCases.UserUseCase;
import com.areadoaluno.macroservice.interfaces.dtos.Auth.LoginRequest;
import com.areadoaluno.macroservice.interfaces.dtos.Auth.LoginResponse;
import com.areadoaluno.macroservice.interfaces.dtos.User.UserResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final UserUseCase userUseCase;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequest loginRequest) {
        String jwt = authService.login(loginRequest.getEmail(), loginRequest.getPassword());

        UserResponse userResponse = new UserResponse(
            userUseCase.findByEmail(loginRequest.getEmail())
        );

        return ResponseEntity.ok(new LoginResponse(
            jwt,
            userResponse
        ));
    }
}
