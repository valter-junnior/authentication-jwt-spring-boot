package com.areadoaluno.macroservice.infrastructure.persistence.seeders;

import com.areadoaluno.macroservice.domain.models.Role;
import com.areadoaluno.macroservice.domain.repositories.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RoleSeeder implements CommandLineRunner {

    private final RoleRepository roleRepository;

    @Override
    public void run(String... args) {
        createRoleIfNotExists("ROLE_ADMIN");
        createRoleIfNotExists("ROLE_EMPLOYEE");
        createRoleIfNotExists("ROLE_STUDENT");
    }

    private void createRoleIfNotExists(String name) {
        Role role = roleRepository.findByName(name);

        if (role == null) {
            roleRepository.save(Role.builder().name(name).build());
        }
    }
}