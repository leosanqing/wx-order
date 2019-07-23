package com.leosanqing.wxorder.service.impl;

import com.leosanqing.wxorder.bean.ProductCategory;
import com.leosanqing.wxorder.dao.ProductCategoryRepository;
import com.leosanqing.wxorder.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private ProductCategoryRepository product;
    @Override
    public ProductCategory findOne(Integer categoryId) {

        return product.findOne(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return product.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return product.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return product.save(productCategory);
    }
}
