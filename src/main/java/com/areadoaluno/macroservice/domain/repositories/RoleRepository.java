package com.areadoaluno.macroservice.domain.repositories;

import com.areadoaluno.macroservice.domain.models.Role;

public interface RoleRepository {
    Role findByName(String name);
    Role save(Role role);
}
