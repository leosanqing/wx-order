package com.leosanqing.wxorder.converter;

import com.leosanqing.wxorder.dto.OrderDTO;
import com.leosanqing.wxorder.form.OrderForm;

/**
 * @Author: leosanqing
 * @Date: 2019-07-30 07:31
 */
public class OrderForm2OrderDTO {
    public static OrderDTO convert(OrderForm orderForm){
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());
        orderDTO.setOrderDetailList();

    }
}
