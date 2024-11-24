package com.example.connectdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.connectdb.entity.Shop;


@Repository
// JpaRepository<Shop, String>  String มาจากว่า Id เป็น type อะไร
// เป็นการสสืบทอด class
public interface ShopRepository extends JpaRepository<Shop, String> {

}
