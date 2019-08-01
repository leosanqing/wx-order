package com.leosanqing.wxorder.service;

import com.leosanqing.wxorder.dto.OrderDTO;

/**
 * @Author: leosanqing
 * @Date: 2019-08-01 07:44
 */
public interface BuyerService {
    OrderDTO findOrderOne(String openid,String OrderId);

    OrderDTO cancelOrder(String openid, String orderId);
}
