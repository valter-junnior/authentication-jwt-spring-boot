package com.areadoaluno.macroservice.domain.repositories;

import com.areadoaluno.macroservice.domain.models.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<User> paginate(int offset, int limit);
    User save(User user);
    User delete(User user);
    Optional<User> findByEmail(String email);
}

