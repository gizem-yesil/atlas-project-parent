package com.atlas.management.api;
import com.atlas.management.entity.User;
import com.atlas.management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")

public class AuthRestController {

    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User loginRequest) {
        User user = userService.getUserByEmail(loginRequest.getUserEmail());
        if (!passwordEncoder.matches(rawPassword, user.getPassword())) {
            throw new IllegalArgumentException("Şifre hatalı!");
        }
}
