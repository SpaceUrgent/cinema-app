package org.cinema.dao;

import java.util.Optional;
import org.cinema.model.Role;

public interface RoleDao {
    Role add(Role role);

    Optional<Role> getByName(Role.RoleName roleName);
}
