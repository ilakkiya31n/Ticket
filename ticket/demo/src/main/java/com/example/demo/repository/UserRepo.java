package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,String>{
    @Query("SELECT u FROM User u ORDER BY u.emailId")
    List<User> findByEmailId();
    @Query("SELECT u FROM User u ORDER BY u.name")
    List<User> findByName();
    }
