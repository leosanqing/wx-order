package com.leosanqing.wxorder.exception;

import com.leosanqing.wxorder.enums.ResultExceptionEnum;

public class SellException extends RuntimeException {
    private Integer code;

    public SellException(ResultExceptionEnum resultExceptionEnum) {
        super(resultExceptionEnum.getMag());
        this.code = resultExceptionEnum.getCode();
    }

    public SellException(Integer code, String defaultMessage) {
        super(defaultMessage);
        this.code = code;
    }
}
