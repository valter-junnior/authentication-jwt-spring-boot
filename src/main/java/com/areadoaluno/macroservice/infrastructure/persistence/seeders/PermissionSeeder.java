package com.areadoaluno.macroservice.infrastructure.persistence.seeders;

import com.areadoaluno.macroservice.domain.models.Permission;
import com.areadoaluno.macroservice.domain.repositories.PermissionRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PermissionSeeder implements CommandLineRunner {

    private final PermissionRepository permissionRepository;

    @Override
    public void run(String... args) {
        createPermissionIfNotExists("USER_READ"); // modelo_permissão
        createPermissionIfNotExists("USER_EDIT");
        createPermissionIfNotExists("USER_DELETE");
    }

    private void createPermissionIfNotExists(String name) {
        Permission permission = permissionRepository.findByName(name);

        if (permission == null) {
            permissionRepository.save(Permission.builder().name(name).build());
        }
    }
}
