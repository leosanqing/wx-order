package com.leosanqing.wxorder.enums;


import lombok.Getter;

@Getter
public enum ResultExceptionEnum {
    PRODUCT_NOT_EXIT(10,"商品不存在"),
    PRODUCT_STOCK_ERROR(11,"库存不足"),
    ORDER_NOT_EXIT(12,"订单不存在"),
    ORDER_DETAIL_NOT_EXIT(13,"订单详情不存在"),
    ORDER_STATUS_ERROR(14,"订单状态不正确"),
    ORDER_UPDATE_ERROR(15,"订单更新失败"),
    ORDER_DETAIL_EMPTY(16,"订单详情为空"),
    ;

    ResultExceptionEnum(Integer code, String mag) {
        this.code = code;
        this.mag = mag;
    }

    private Integer code;
    private String mag;
}
