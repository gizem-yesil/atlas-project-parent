package com.atlas.management.api;

import com.atlas.management.entity.Role;
import com.atlas.management.entity.University;
import com.atlas.management.entity.User;
import com.atlas.management.service.UniversityService;
import com.atlas.management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/admin")
public class AdminRestController {

    @Autowired
    private UniversityService universityService;

    @Autowired
    private UserService userService;

    @PreAuthorize("hasRole('ADMIN')")



    @GetMapping("/dashboard")
    public String adminDashboard() {
        return "Burası sadece adminlere açık bir panel.";
    }

    @GetMapping("/")
    public List<University> getAll() {
        return universityService.getAllUniversities();
    }

    @GetMapping("/{id}")
    public University getById(@PathVariable String id) {
        return universityService.getUniversityById(id);
    }

    @PostMapping("/uniekle")
    public University create(@RequestBody University university) {
        return universityService.createUniversity(university);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        universityService.deleteUniversity(id);
        return ResponseEntity.ok("kayıt silindi");
    }









}

