package com.areadoaluno.macroservice.domain.useCases;

import com.areadoaluno.macroservice.domain.models.User;

public interface UserUseCase {
    User create(User user);
    User findByEmail(String email);
}
