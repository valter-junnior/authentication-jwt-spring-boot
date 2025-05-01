package com.areadoaluno.macroservice.domain.repositories;

import com.areadoaluno.macroservice.domain.models.Permission;

public interface PermissionRepository {
    Permission findByName(String name);
    Permission save(Permission permission);
}
