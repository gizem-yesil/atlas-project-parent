package com.atlas.management.service;

import org.springframework.stereotype.Service;
import com.atlas.management.entity.University;
import com.atlas.management.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

    @Service
    public class UniversityService {

        @Autowired
        private UniversityRepository universityRepository;

        public University createUniversity(University university) {
            return universityRepository.save(university);
        }

        public List<University> getAllUniversities() {
            return universityRepository.findAll();
        }

        public University getUniversityById(String id) {
            return universityRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("University not found: " + id));
        }

        public void deleteUniversity(String id) {
            universityRepository.deleteById(id);

    }

}
