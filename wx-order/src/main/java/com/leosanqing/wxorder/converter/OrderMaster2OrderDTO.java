package com.leosanqing.wxorder.converter;

import com.leosanqing.wxorder.bean.OrderMaster;
import com.leosanqing.wxorder.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: leosanqing
 * @Date: 2019-07-26 07:55
 */
public class OrderMaster2OrderDTO {
    public static OrderDTO convert(OrderMaster orderMaster){
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList){
        return orderMasterList.stream()
                .map(e-> convert(e))
                .collect(Collectors.toList());
    }
}
