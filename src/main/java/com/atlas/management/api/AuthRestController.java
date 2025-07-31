package com.atlas.management.api;
import com.atlas.management.entity.User;
import com.atlas.management.service.UserService;
import com.atlas.management.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")

public class AuthRestController {

    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;




    @PostMapping("/register")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);

    }

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginRequest) {
        User user = userService.getUserByEmail(loginRequest.getUserEmail());

        if (!passwordEncoder.matches(loginRequest.getUserPassword(), user.getUserPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Şifre hatalı!");
        }

        String token = jwtTokenUtil.generateToken(user.getUserEmail());

        return ResponseEntity.ok().body(token);
    }
}
