package com.example.connectdb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.connectdb.entity.Shop;
import com.example.connectdb.repository.ShopRepository;

import jakarta.persistence.Tuple;

@RestController
public class TestJpaController {

    @Autowired
    private ShopRepository shopRepository;

    @GetMapping("jpa/getById")
    public Shop getById(
            @RequestParam("id") String id) {

        return shopRepository.findById(id).orElse(null);

    }

}
