package org.cinema.security;

import java.util.Optional;
import org.cinema.model.User;
import org.cinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Optional<User> user = userService.findByEmail(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("There is no user with email " + username);
        }
        UserBuilder userBuilder =
                org.springframework.security.core.userdetails.User.withUsername(username);
        userBuilder.password(user.get().getPassword());
        userBuilder.roles(user.get().getRoles().stream()
                .map(role -> role.getRoleName().name())
                .toArray(String[]::new));
        return userBuilder.build();
    }
}
