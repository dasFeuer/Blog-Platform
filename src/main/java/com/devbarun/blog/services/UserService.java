package com.devbarun.blog.services;

import com.devbarun.blog.domian.entities.User;

import java.util.UUID;

public interface UserService {
    User getUserById(UUID id);
}
