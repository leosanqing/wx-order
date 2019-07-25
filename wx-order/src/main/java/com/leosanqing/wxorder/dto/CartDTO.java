package com.leosanqing.wxorder.dto;

import lombok.Data;

import javax.persistence.Entity;

/**
 * 2 * @Author: leosanqing
 * 3 * @Date: 2019-07-24 21:23
 * 4
 */
@Data
public class CartDTO {
    private String productId;
    private Integer stock;


    public CartDTO(String productId, Integer stock) {
        this.productId = productId;
        this.stock = stock;
    }
}
