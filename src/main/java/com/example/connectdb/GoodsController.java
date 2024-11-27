package com.example.connectdb;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.connectdb.dto.GoodsDto;
import com.example.connectdb.entity.Goods;
import com.example.connectdb.entity.Shop;
import com.example.connectdb.repository.GoodsRepository;

@RestController
public class GoodsController {

        @Autowired
        private GoodsRepository goodsRepository;

        @GetMapping("/goods/{id}")
        public GoodsDto getGoodsDto(
                        @PathVariable("id") String id) {

                Goods goods = goodsRepository.findById(id).orElseThrow();

                return new GoodsDto()
                                .setGoodsId(goods.getGoodsId())
                                .setGoodsName(goods.getGoodsName())
                                .setGoodsPrice(goods.getGoodsPrice())
                                .setShopId(goods.getShop().getShopId())
                                .setShopName(goods.getShop().getShopName());
        }

        @PostMapping("/goods/insert")
        public GoodsDto insertGoodsDto(
                        @RequestBody GoodsDto insertGoodsDto) {

                Goods goods = new Goods();
                goods.setGoodsId(insertGoodsDto.getGoodsId())
                                .setGoodsName(insertGoodsDto.getGoodsName())
                                .setGoodsPrice(insertGoodsDto.getGoodsPrice())
                                .setShop(new Shop().setShopId(insertGoodsDto.getShopId()));

                goods = goodsRepository.save(goods);

                return new GoodsDto()
                                .setGoodsId(goods.getGoodsId())
                                .setGoodsName(goods.getGoodsName())
                                .setGoodsPrice(goods.getGoodsPrice())
                                .setShopId(goods.getShop().getShopId())
                                .setShopName(goods.getShop().getShopName());
        }

        @GetMapping("/goods")
        public List<GoodsDto> searchByShopId(
                        @RequestParam("shopId") String shopId) {

                return goodsRepository.findByShopShopId(shopId).stream().map(goods -> {
                        return new GoodsDto()
                                        .setGoodsId(goods.getGoodsId())
                                        .setGoodsName(goods.getGoodsName())
                                        .setGoodsPrice(goods.getGoodsPrice())
                                        .setShopId(goods.getShop().getShopId())
                                        .setShopName(goods.getShop().getShopName());
                }).collect(Collectors.toList());

        }

        
        @GetMapping("/jpql/goods")
        public List<GoodsDto> searchByShopIdJpql(
                        @RequestParam("shopId") String shopId) {

                return goodsRepository.findByShopIdJpql(shopId).stream().map(goods -> {
                        return new GoodsDto()
                                        .setGoodsId(goods.getGoodsId())
                                        .setGoodsName(goods.getGoodsName())
                                        .setGoodsPrice(goods.getGoodsPrice())
                                        .setShopId(goods.getShop().getShopId())
                                        .setShopName(goods.getShop().getShopName());
                }).collect(Collectors.toList());

        }

        @GetMapping("/jpql/goodsDto")
        public List<GoodsDto> searchGoodsDto(
                        @RequestParam("shopId") String shopId) {

                return goodsRepository.findGoodsDtoByShopId(shopId);

        }

}
