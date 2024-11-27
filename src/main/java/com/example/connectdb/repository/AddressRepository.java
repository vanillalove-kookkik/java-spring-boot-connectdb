package com.example.connectdb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.connectdb.entity.Address;

public interface AddressRepository extends JpaRepository<Address, String> {

    Address findByUserUsername(String username);

    @Query("SELECT a FROM Address a WHERE a.user.username = :username")
    List<Address> findByUsernameByJpql(@Param("username") String username);
    
}
