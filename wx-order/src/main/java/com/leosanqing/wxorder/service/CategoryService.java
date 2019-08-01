package com.leosanqing.wxorder.service;

import com.leosanqing.wxorder.bean.ProductCategory;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryService {
    ProductCategory findOne(Integer categoryId);
    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
    ProductCategory save(ProductCategory productCategory);
}
