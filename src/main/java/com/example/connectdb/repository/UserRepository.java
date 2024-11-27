package com.example.connectdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.connectdb.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

}
