package com.leosanqing.wxorder.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @Author: leosanqing
 * @Date: 2019-07-30 07:05
 */
@Data
public class OrderForm {
    //买家姓名
    @NotEmpty(message = "姓名不能为空")
    private String name;
    // 买家电话
    @NotEmpty(message = "电话不能为空")
    private String phone;

    // 买家地址
    @NotEmpty(message = "地址不能为空")
    private String address;

    //买家微信openid
    @NotEmpty(message = "openid不能为空")
    private String openid;

    // 购物车
    @NotEmpty(message = "购物车不能为空")
    private String item;

}
