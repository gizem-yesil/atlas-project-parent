package com.atlas.management.repository;

import com.atlas.management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Query("select u from User u where u.userName = :username")
    User findByUserName2(@Param("username") String username);

    User findByUserName(String userName);

    Optional<User> findByUserEmailIgnoreCase(String userEmail);
}


