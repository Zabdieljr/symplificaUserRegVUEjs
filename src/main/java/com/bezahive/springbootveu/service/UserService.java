package com.bezahive.springbootveu.service;

import com.bezahive.springbootveu.dao.Role;
import com.bezahive.springbootveu.dao.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    User changeRole(Role newRole, String username);

    User findByUsername(String username);

    User deleteUser(Long userId);

    List<User> findAllUsers();
}
