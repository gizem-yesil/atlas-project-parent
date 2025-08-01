package com.atlas.management.api;

import com.atlas.management.entity.University;
import com.atlas.management.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/universities")
    @CrossOrigin(origins = "*")
    public class UniversityRestController {

        @Autowired
        private UniversityService universityService;

        @GetMapping
        public List<University> getAll() {
            return universityService.getAllUniversities();
        }

        @GetMapping("/{id}")
        public University getById(@PathVariable String id) {
            return universityService.getUniversityById(id);
        }



}
