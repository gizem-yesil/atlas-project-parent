package com.atlas.management.api;
import com.atlas.management.entity.Role;
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

    @PostMapping ("/login")
    public ResponseEntity<?> login(@RequestBody User loginRequest) {
        User user = userService.getUserByEmail(loginRequest.getUserEmail());

        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Kullanıcı bulunamadı!");
        }
        if (!passwordEncoder.matches(loginRequest.getUserPassword(), user.getUserPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Şifre hatalı!");
        }

        String token = jwtTokenUtil.generateToken(user.getUserEmail(), user.getRole().name());

        return ResponseEntity.ok().body(token);
    }
    @PostMapping("/login/make-admin/{id}")
    public String makeAdmin(@PathVariable String id) {
        User user = userService.getUserById(id);
        user.setRole(Role.ADMIN);
        userService.updateUser(user);
        return "Kullanıcı artık admin.";
    }

    @GetMapping("/validate")
    public ResponseEntity<?> validateToken(@RequestHeader("Authorization") String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Token gerekli");
        }

        String token = authHeader.substring(7);

        if (jwtTokenUtil.validateToken(token)) {
            String email = jwtTokenUtil.getEmailFromToken(token);
            return ResponseEntity.ok("Token geçerli. Kullanıcı: " + email);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token geçersiz veya süresi dolmuş");
        }
    }

}
