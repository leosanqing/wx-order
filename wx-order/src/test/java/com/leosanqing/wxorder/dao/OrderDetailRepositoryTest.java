package com.leosanqing.wxorder.dao;

import com.leosanqing.wxorder.bean.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void save(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("12343");
        orderDetail.setOrderId("21343");
        orderDetail.setProductIcon("http://ZXXXX.jpg");
        orderDetail.setProductId("123213213");
        orderDetail.setProductName("皮皮虾");
        orderDetail.setProductQuantity(123);
        orderDetail.setProductPrice(new BigDecimal(33.4));

        OrderDetail save = orderDetailRepository.save(orderDetail);
        Assert.assertNotNull(save);
    }


    @Test
    public void findByOrderId() {
        List<OrderDetail> orderDetailList = orderDetailRepository.findByOrderId("21343");
        Assert.assertEquals(0,orderDetailList.size());


    }
}