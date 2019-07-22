package com.leosanqing.wxorder.VO;

import lombok.Data;

@Data
public class ResultVO <T>{
    private Integer code;
    private String mag;

    private T data;
}
