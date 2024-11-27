package com.example.connectdb.dto;

import java.math.BigDecimal;
import lombok.*;
import lombok.experimental.Accessors;

@AllArgsConstructor     //สร้าง Constructure
@NoArgsConstructor      //สร้าง Constructure
@Accessors(chain = true)
@Data
public class GoodsDto {
 
    private String goodsId;
    private String goodsName;
    private BigDecimal goodsPrice;
    //สามารถ return เป็น entity ออกไปได้ แต่ในทางปฎิบัติไม่นิยม เนื่องจากจะเห็นวิธีการ Map Data หรือเหตุผลอื่นๆ
    private String shopId;
    private String shopName;

}
