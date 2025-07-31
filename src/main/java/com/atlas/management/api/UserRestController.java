package com.atlas.management.api;

import com.atlas.management.entity.User;
import com.atlas.management.entity.UserDto;
import com.atlas.management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*") // Frontend erişimi için CORS ayarı (gerekirse sınırlandırabiliriz)

public class UserRestController {

    @Autowired
    private UserService userService;



   @GetMapping("/")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable String id) {
        return userService.getUserDtoById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }
}
