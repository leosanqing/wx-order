package com.leosanqing.wxorder.service.impl;

import com.leosanqing.wxorder.dto.OrderDTO;
import com.leosanqing.wxorder.service.OrderService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;


public class OrderServiceImplTest {
    @Autowired
    private OrderService orderService;


    private final String BUYER_OPENID = "110110";

    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("pp");
        orderDTO.setBuyerAddress("阿里");
        orderDTO.setBuyerOpenid(BUYER_OPENID);
        orderDTO.setBuyerPhone("15320341091");
    }

    @Test
    public void findOne() {
    }

    @Test
    public void findList() {
    }

    @Test
    public void cancel() {
    }

    @Test
    public void finish() {
    }

    @Test
    public void paid() {
    }
}