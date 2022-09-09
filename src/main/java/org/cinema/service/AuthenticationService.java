package org.cinema.service;

import org.cinema.model.User;

public interface AuthenticationService {
    User register(String email, String password);
}
