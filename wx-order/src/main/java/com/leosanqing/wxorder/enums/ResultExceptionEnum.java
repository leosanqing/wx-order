package com.leosanqing.wxorder.enums;


import lombok.Getter;

@Getter
public enum ResultExceptionEnum {
    PRODUCT_NOT_EXIT(10,"商品不存在"),
    PRODUCT_STOCK_ERROR(11,"库存不足"),
    ;

    ResultExceptionEnum(Integer code, String mag) {
        this.code = code;
        this.mag = mag;
    }

    private Integer code;
    private String mag;
}
