package com.leosanqing.wxorder.dao;

import com.leosanqing.wxorder.bean.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {
    @Autowired
    private ProductInfoRepository productInfo;

    @Test
    public void save(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("1234");
        productInfo.setProductName("震动棒");
        productInfo.setProductDescription("非一般的感觉");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStatus(0);
        productInfo.setProductStock(1);
        productInfo.setProductIcon("http://");
        this.productInfo.save(productInfo);
    }

    @Test
    public void findProductByStatus(){
        List<ProductInfo> byProductStatus = productInfo.findByProductStatus(0);
        System.out.println(byProductStatus.toString());
    }

}