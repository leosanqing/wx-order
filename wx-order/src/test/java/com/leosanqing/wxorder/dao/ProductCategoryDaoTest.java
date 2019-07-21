package com.leosanqing.wxorder.dao;

import com.leosanqing.wxorder.bean.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductCategoryDaoTest {

    @Autowired
    private ProductCategoryDao repository;

    @Test
    public void findOne(){
        Optional<ProductCategory> byId = repository.findById(1);
        System.out.println(byId.toString());
    }
}