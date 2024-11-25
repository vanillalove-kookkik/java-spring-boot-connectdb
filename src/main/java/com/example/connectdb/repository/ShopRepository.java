package com.example.connectdb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.connectdb.entity.Shop;

@Repository
// JpaRepository<Shop, String> String มาจากว่า Id เป็น type อะไร
// เป็นการสืบทอด class
public interface ShopRepository extends JpaRepository<Shop, String> {

    // JPA
    List<Shop> findByShopName(String shopName);

    List<Shop> findByShopNameNotLike(String shopName);

    // JPQL
    @Query(
    "SELECT t FROM Shop AS t WHERE t.shopName = :inputShopName"
    )
    List<Shop> findByJpqlShopName(@Param("inputShopName")String shopName);

}
