package com.leosanqing.wxorder.enums;

import lombok.Getter;

@Getter
public enum OrderStatusEnum {
    NEW(0,"新下订单"),
    FINISH(1,"订单完成"),
    CANCEL(1,"订单取消"),
    ;

    private Integer code;
    private String msg;

    OrderStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
