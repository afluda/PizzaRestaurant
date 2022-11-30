package com.example.pizzeramorebackend.repository;

import com.example.pizzeramorebackend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Query(nativeQuery = true, value = "Select * from users where name=?1 and last_name=?2 and street=?3 and city=?4 and email=?5")
    Optional<User> findExact(String name, String secondName, String street, String city, String email);

    Optional<User> findByEmail(String email);

    Optional<User> findByName(String name);

    boolean existsByEmail(String email);


}
