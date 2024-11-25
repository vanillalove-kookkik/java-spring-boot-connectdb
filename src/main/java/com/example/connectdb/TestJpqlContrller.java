package com.example.connectdb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.connectdb.entity.Shop;
import com.example.connectdb.repository.ShopRepository;

@RestController
public class TestJpqlContrller {

    @Autowired
    private ShopRepository shopRepository;

    @GetMapping("jpql/find-by-shop-name")
    public List<Shop> findByShopName(
            @RequestParam("shop_name") String shop_name) {
        List<Shop> shopInDb = shopRepository.findByJpqlShopName(shop_name);
        return shopInDb;

    }

}
