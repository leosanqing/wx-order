package com.leosanqing.wxorder.dao;

import com.leosanqing.wxorder.bean.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository orderMasterRepository;


    @Test
    public void save(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("21343");
        orderMaster.setBuyerAddress("阿里总部");
        orderMaster.setBuyerName("阿里郎");
        orderMaster.setBuyerPhone("15320341091");
        orderMaster.setBuyerOpenid("12231123");
        orderMaster.setOrderAmount(new BigDecimal(33.3));

        OrderMaster result = orderMasterRepository.save(orderMaster);
        Assert.assertNotNull(result);
    }
    @Test
    public void findByBuyerOpenid() {

        PageRequest pageRequest = new PageRequest(0, 3);
        Page<OrderMaster> byBuyerOpenid = orderMasterRepository.findByBuyerOpenid("12231123",pageRequest);
        System.out.println(byBuyerOpenid);

    }
}