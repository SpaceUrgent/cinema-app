package org.cinema.service;

import org.cinema.model.Role;

public interface RoleService {
    Role add(Role role);

    Role getByName(String roleName);
}
