package com.cross.bookmanager.service;

import com.cross.bookmanager.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
