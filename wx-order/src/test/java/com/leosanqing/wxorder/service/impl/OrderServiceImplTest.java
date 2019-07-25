package com.leosanqing.wxorder.service.impl;

import com.leosanqing.wxorder.bean.OrderDetail;
import com.leosanqing.wxorder.dto.OrderDTO;
import com.leosanqing.wxorder.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

 @Slf4j
 @SpringBootTest
 @RunWith(SpringRunner.class)
public class OrderServiceImplTest {
    @Autowired
    private OrderServiceImpl orderService;


    private final String BUYER_OPENID = "110110";

    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("pp");
        orderDTO.setBuyerAddress("阿里");
        orderDTO.setBuyerOpenid(BUYER_OPENID);
        orderDTO.setBuyerPhone("15320341091");


        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId("3");
        orderDetail.setProductQuantity(10);
        orderDetailList.add(orderDetail);


        orderDTO.setOrderDetailList(orderDetailList);

        orderService.create(orderDTO);

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