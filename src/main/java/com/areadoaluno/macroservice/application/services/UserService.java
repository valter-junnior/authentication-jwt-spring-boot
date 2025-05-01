package com.areadoaluno.macroservice.application.services;

import com.areadoaluno.macroservice.domain.exceptions.UserNotFoundException;
import com.areadoaluno.macroservice.domain.models.User;
import com.areadoaluno.macroservice.domain.repositories.UserRepository;
import com.areadoaluno.macroservice.domain.useCases.UserUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserUseCase {
    private final UserRepository userRepository;

    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(UserNotFoundException::new);
    }
}
