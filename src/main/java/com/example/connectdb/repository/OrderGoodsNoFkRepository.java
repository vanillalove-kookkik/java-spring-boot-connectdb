package com.example.connectdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.connectdb.entity.OrderGoodsNoFk;
import com.example.connectdb.entity.OrderGoodsPk;

public interface OrderGoodsNoFkRepository extends JpaRepository <OrderGoodsNoFk,OrderGoodsPk>{
    
}
