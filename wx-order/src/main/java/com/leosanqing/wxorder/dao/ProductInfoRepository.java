package com.leosanqing.wxorder.dao;

import com.leosanqing.wxorder.bean.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {
    List<ProductInfo> findByProductStatus (Integer productStatusList);
}
