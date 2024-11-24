package com.example.connectdb;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.connectdb.dto.Shop;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Tuple;
import jakarta.transaction.Transactional;

import java.util.List;

@RestController
public class TestController {

    @PersistenceContext
    private EntityManager entityManager;
    private Tuple tuple;

    @GetMapping("/test-db")
    public void testDb() {

        List<Tuple> ListShop = entityManager.createNativeQuery("SELECT * FROM shop", Tuple.class).getResultList(); /*
                                                                                                                    * Tuple
                                                                                                                    * =
                                                                                                                    * Ropws
                                                                                                                    */

        for (Tuple tuple : ListShop) {

            String shopId = tuple.get("shop_id", String.class);
            String shopName = tuple.get("shop_name", String.class);

            System.out.println(shopId);
            System.out.println(shopName);
        }

    }

    @GetMapping("/getById")
    public Shop getById(
            @RequestParam("id") String id) {

        List<Tuple> listShopById = entityManager
                .createNativeQuery("SELECT * FROM shop WHERE shop_id = :input_shop_id ", Tuple.class)
                .setParameter("input_shop_id", id)
                .getResultList();

        if (listShopById.isEmpty()) {

            return null;

        } else {
            Tuple tuple = listShopById.get(0);
            Shop shop = new Shop();

            shop.setShopId(tuple.get("shop_id", String.class));
            shop.setShopName(tuple.get("shop_name", String.class));
            

            return shop;
        }

    }

    @Transactional
    @PostMapping("/insert")
    public boolean insert(
        @RequestBody Shop shop
    ){

        int rowEffect  = entityManager.createNativeQuery(" INSERT INTO shop ( 'shop_id' , 'shop_name' ) VALUES ( :shop_id , :shop_name )")
        .setParameter("shop_id", shop.getShopId())
        .setParameter("shop_name", shop.getShopName())
        .executeUpdate();

        return rowEffect > 0 ;
    }

    @Transactional
    @PostMapping("/update")
    public boolean update(
        @RequestBody Shop shop
    ){

        int rowEffect  = entityManager.createNativeQuery("UPDATE shop SET shop_name = :shop_name WHERE shop_id = :shop_id ")
        .setParameter("shop_id", shop.getShopId())
        .setParameter("shop_name", shop.getShopName())
        .executeUpdate();

        return rowEffect > 0 ;
    }

    @Transactional
    @GetMapping("/delete")
    public boolean delete(
        @RequestParam ("id") String id
    ){

        int rowEffect  = entityManager.createNativeQuery("DELETE FROM shop WHERE shop_id = :shop_id ")
        .setParameter("shop_id", id)
        .executeUpdate();

        return rowEffect > 0 ;
    }

}
