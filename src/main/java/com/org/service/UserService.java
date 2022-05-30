package com.org.service;

import java.util.Optional;

import com.org.model.Role;
import com.org.model.User;

public interface UserService {
	User saveUser(User user);

    Optional<User> findByUsername(String username);

    void changeRole(Role newRole, String username);
}
