package com.example.connectdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.connectdb.entity.Goods;

public interface OrderRepository extends JpaRepository <Goods,String>{
    
}
