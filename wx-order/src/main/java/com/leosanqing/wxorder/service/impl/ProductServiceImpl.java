package com.leosanqing.wxorder.service.impl;

import com.leosanqing.wxorder.bean.ProductInfo;
import com.leosanqing.wxorder.dao.ProductInfoRepository;
import com.leosanqing.wxorder.dto.CartDTO;
import com.leosanqing.wxorder.enums.ProductStatusEnum;
import com.leosanqing.wxorder.enums.ResultExceptionEnum;
import com.leosanqing.wxorder.exception.SellException;
import com.leosanqing.wxorder.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductInfoRepository productInfoRepository;
    @Override
    public ProductInfo findOne(String productId) {
        return productInfoRepository.findOne(productId);
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productInfoRepository.findAll(pageable);
    }


    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoRepository.save(productInfo);
    }

    @Override
    public void decrease(List<CartDTO> cartDTOList) {
        for(CartDTO cartDTO : cartDTOList){
            ProductInfo productInfo = productInfoRepository.findOne(cartDTO.getProductId());
            if (null == productInfo){
                throw new SellException(ResultExceptionEnum.PRODUCT_NOT_EXIT);
            }
            Integer result = productInfo.getProductStock() - cartDTO.getStock();
            if(result<0){
                throw new SellException(ResultExceptionEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);
        }
    }
}
