package com.example.connectdb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.connectdb.dto.GoodsDto;
import com.example.connectdb.entity.Goods;

public interface GoodsRepository extends JpaRepository<Goods, String> {

    // JPA Query Methods
    List<Goods> findByShopShopId(String shopId);

    // JPQL
    @Query("SELECT g FROM Goods AS g WHERE g.shop.shopId = :inputShopId")
    List<Goods> findByShopIdJpql(@Param("inputShopId") String shopId);

    // JPQL Projection
    @Query("SELECT new com.example.connectdb.dto.GoodsDto(g.goodsId , g.goodsName , g.goodsPrice , g.shop.shopId , g.shop.shopName) FROM Goods AS g WHERE g.shop.shopId = :inputShopId")
    List<GoodsDto> findGoodsDtoByShopId(@Param("inputShopId") String shopId);

}
