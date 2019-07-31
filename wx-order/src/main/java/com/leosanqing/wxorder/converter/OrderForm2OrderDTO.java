package com.leosanqing.wxorder.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.leosanqing.wxorder.bean.OrderDetail;
import com.leosanqing.wxorder.dto.OrderDTO;
import com.leosanqing.wxorder.enums.ResultExceptionEnum;
import com.leosanqing.wxorder.exception.SellException;
import com.leosanqing.wxorder.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: leosanqing
 * @Date: 2019-07-30 07:31
 */
@Slf4j
public class OrderForm2OrderDTO {
    public static OrderDTO convert(OrderForm orderForm){
        ArrayList<OrderDetail> arrayList = new ArrayList<>();

        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        try {
            arrayList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>() {
                    }.getType());
        }catch (Exception e){
            log.error("[对象转换]错误，string = {}",orderForm.getItems());
            throw new SellException(ResultExceptionEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(arrayList);
        return orderDTO;

    }
}
