package com.areadoaluno.macroservice.infrastructure.persistence.adapters;

import com.areadoaluno.macroservice.domain.models.User;
import com.areadoaluno.macroservice.domain.repositories.UserRepository;
import com.areadoaluno.macroservice.infrastructure.persistence.mappers.UserMapper;
import com.areadoaluno.macroservice.infrastructure.persistence.repositories.JpaUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class UserRepositoryAdapter implements UserRepository {
    private final JpaUserRepository userRepositoryJpa;
    private final UserMapper userMapper;

    public List<User> paginate(int offset, int limit) {
        return null;
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public User delete(User user) {
        return null;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepositoryJpa.findByEmail(email)
                .map(userMapper::toDomain);
    }}
