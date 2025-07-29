package com.atlas.management.service;

import com.atlas.management.entity.User;
import com.atlas.management.exception.UserNotFoundException;
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
        return userRepository.findById(id)
             .orElseThrow(() -> new UserNotFoundException("Kullanıcı bulunamadı: " + id));

    }


    public void deleteUser(String id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException("Silinmek istenen kullanıcı bulunamadı: " + id);
        }
        userRepository.deleteById(id);
    }

    public User getUserByEmail(String userEmail) {
        return userRepository.findByUserEmail(userEmail)
            .orElseThrow(() -> new UserNotFoundException("Bu e-posta adresiyle kayıtlı kullanıcı yok: " + userEmail));
    }
}
