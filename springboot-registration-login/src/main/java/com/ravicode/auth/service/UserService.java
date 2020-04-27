package com.ravicode.auth.service;

import com.ravicode.auth.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
