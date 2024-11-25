package com.example.connectdb;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.connectdb.entity.Shop;
import com.example.connectdb.repository.ShopRepository;

@RestController
public class TestJpaController {

    @Autowired
    private ShopRepository shopRepository;

    @GetMapping("jpa/getById")
    public Shop getById(
            @RequestParam("id") String id) {

        return shopRepository.findById(id).orElse(null);

    }

    @PostMapping("jpa/insert")
    public Shop insert(
            @RequestBody Shop shop) {

        return shopRepository.save(shop);

    }

    @GetMapping("jpa/mannual-insert")
    public Shop insertByMannual() {

        Shop shop = new Shop();
        shop.setShopId(UUID.randomUUID().toString());
        shop.setShopName("AAA");

        System.out.println(shop);

        return shopRepository.save(shop);

    }

    @PostMapping("jpa/update")
    public Shop update(
            @RequestBody Shop shop) {

        Shop shopInDb = shopRepository.findById(shop.getShopId()).orElseThrow();

        return shopRepository.save(shop);

        // ถ้ามีอยู่แล้วจะเป็น update แต่ถ้าไม่มีจะเป็นการ insert
        // return shopRepository.save(shop);
    }

    @GetMapping("jpa/delete")
    public String delete(
            @RequestParam("id") String id) {

        Shop shopInDb = shopRepository.findById(id).orElse(null);

        if (shopInDb == null) {
            return "Not Found Data";
        } else {
            shopRepository.deleteById(id);
            return "Delete Succes";
        }

    }

    @GetMapping("jpa/find-by-shop-name")
    public List<Shop> findByShopName(
        @RequestParam("shop_name") String shop_name
    ){
        List<Shop> shopInDb = shopRepository.findByShopName(shop_name);
        return shopInDb;

    }

    @GetMapping("jpa/find-by-shop-name-not-like")
    public List<Shop> findByShopNameNotLike(
        @RequestParam("shop_name") String shop_name
    ){
        List<Shop> shopInDb = shopRepository.findByShopNameNotLike(shop_name);
        return shopInDb;

    }

}
