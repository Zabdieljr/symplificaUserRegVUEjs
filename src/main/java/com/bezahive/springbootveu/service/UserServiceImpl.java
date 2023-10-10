package com.bezahive.springbootveu.service;

import com.bezahive.springbootveu.dao.Role;
import com.bezahive.springbootveu.dao.User;
import com.bezahive.springbootveu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public User saveUser(User user)
    {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreateDate(LocalDateTime.now());
        user.setRole(Role.ROLE_USER);
        return userRepository.save(user);
    }
    @Override
    public User changeRole(Role newRole, String username)
    {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException());
        user.setRole(newRole);
        return userRepository.save(user);
    }
    @Override
    public User findByUsername(String username){

        return userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException());
    }

    @Override
    public User deleteUser(Long userId){
        User user=userRepository.findById(userId).orElseThrow(() -> new RuntimeException());
        userRepository.delete(user);
        return user;
    }
    @Override
    public List<User> findAllUsers(){

        return userRepository.findAll();
    }

}
