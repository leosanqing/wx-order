package com.leosanqing.wxorder.service.impl;

import com.leosanqing.wxorder.bean.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;
    @Test
    public void indOne() {
        System.out.println(productService.findOne("1"));
    }

    @Test
    public void findAll() {
        PageRequest pageRequest = new PageRequest(0, 2);

        Page<ProductInfo> all = productService.findAll(pageRequest);
        System.out.println(all.getTotalElements());

    }

    @Test
    public void findUpAll() {
        List<ProductInfo> upAll = productService.findUpAll();
        System.out.println(upAll.toString());
    }

    @Test
    public void save() {

    }
}