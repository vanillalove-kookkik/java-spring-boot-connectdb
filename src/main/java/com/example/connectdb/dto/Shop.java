package com.example.connectdb.dto;

import lombok.*;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class Shop {

    private String shopId;
    private String shopName;

}
