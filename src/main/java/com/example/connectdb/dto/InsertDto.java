package com.example.connectdb.dto;

import java.math.BigDecimal;
import lombok.*;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class InsertDto {

    private String goodsId;
    private String goodsName;
    private BigDecimal goodsPrice;
    private String shopId;

}
