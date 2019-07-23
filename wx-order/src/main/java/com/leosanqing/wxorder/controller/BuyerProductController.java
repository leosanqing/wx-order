package com.leosanqing.wxorder.controller;


import com.leosanqing.wxorder.VO.ProductInfoVO;
import com.leosanqing.wxorder.VO.ProductVO;
import com.leosanqing.wxorder.VO.ResultVO;
import com.leosanqing.wxorder.bean.ProductCategory;
import com.leosanqing.wxorder.bean.ProductInfo;
import com.leosanqing.wxorder.service.CategoryService;
import com.leosanqing.wxorder.service.ProductService;
import com.leosanqing.wxorder.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list() {

        // 查询所有上架的商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        // 查询所有类目
        List<Integer> categoryList = productInfoList.stream().
                map(ProductInfo::getCategoryType).
                collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryList);
        // 数据拼装

        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productCategory.getCategoryType().equals(productInfo.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }


            productVO.setProductInfoVOList(productInfoVOList);

            productVOList.add(productVO);
        }


        return ResultVOUtil.success(productVOList);
    }

}
