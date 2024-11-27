package com.example.connectdb.entity;

import java.math.BigDecimal;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
@Entity
@Table(name = "goods")
public class Goods {

    @Id
    @Column(name = "goods_id")
    private String goodsId;

    @Column(name = "goods_name")
    private String goodsName;

    @Column(name = "goods_price")
    private BigDecimal goodsPrice;

    // ถ้าไม่อยากให้ดึงมาให้ set เป็น @ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne(fetch = FetchType.EAGER) // บังคับดึง
    @JoinColumn(name = "shop_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Shop shop;

}
