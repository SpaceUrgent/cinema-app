package org.cinema.service.impl;

import java.util.HashSet;
import org.cinema.model.User;
import org.cinema.service.AuthenticationService;
import org.cinema.service.RoleService;
import org.cinema.service.ShoppingCartService;
import org.cinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;
    private final RoleService roleService;

    @Autowired
    public AuthenticationServiceImpl(UserService userService,
                                     ShoppingCartService shoppingCartService,
                                     RoleService roleService) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.roleService = roleService;
    }

    @Override
    public User register(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setRoles(new HashSet<>());
        user.getRoles().add(roleService.getByName("USER"));
        userService.add(user);
        shoppingCartService.registerNewShoppingCart(user);
        return user;
    }
}
