package com.atlas.management.service;

import com.atlas.management.entity.User;
import com.atlas.management.repository.UserRepository;

import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public User getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }


    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

}
