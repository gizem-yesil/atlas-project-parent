package com.atlas.management.repository;

import com.atlas.management.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

    @Repository
    public interface UniversityRepository extends JpaRepository<University,String> {


}
