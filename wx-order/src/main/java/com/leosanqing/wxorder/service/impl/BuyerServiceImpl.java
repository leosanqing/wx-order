package com.leosanqing.wxorder.service.impl;

import com.leosanqing.wxorder.dto.OrderDTO;
import com.leosanqing.wxorder.enums.ResultExceptionEnum;
import com.leosanqing.wxorder.exception.SellException;
import com.leosanqing.wxorder.service.BuyerService;
import com.leosanqing.wxorder.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.xml.ws.Action;
import javax.xml.ws.ServiceMode;

/**
 * @Author: leosanqing
 * @Date: 2019-08-01 07:46
 */
@Slf4j
@Service
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private OrderService orderService;
    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {
        return checkOrder(openid, orderId);
    }

    @Override
    public OrderDTO cancelOrder(String openid, String orderId) {
        OrderDTO orderDTO = checkOrder(openid, orderId);
        if(null == orderDTO){
            log.error("[取消失败] 没有该订单，orderId={}",orderId);
            throw new SellException(ResultExceptionEnum.ORDER_NOT_EXIT);
        }
        return orderService.cancel(orderDTO);
    }

    private OrderDTO checkOrder(String openid, String orderId){
        if(StringUtils.isEmpty(openid)){
            log.error("[订单详情查询] openid为空");
            throw new SellException(ResultExceptionEnum.PARAM_ERROR);
        }

        if(StringUtils.isEmpty(orderId)){
            log.error("[订单详情查询],orderId为空");
            throw new SellException(ResultExceptionEnum.PARAM_ERROR);
        }

        OrderDTO orderDTO = orderService.findOne(orderId);
        if(null == orderDTO)
            return null;
        if(!orderDTO.getBuyerOpenid().equalsIgnoreCase(openid)){
            log.error("[订单查询失败]，订单不属于该用户");
            throw new SellException(ResultExceptionEnum.ORDER_OWNER_ERROR);
        }
        return orderDTO;
    }
}
