package com.leosanqing.wxorder.service;

import com.leosanqing.wxorder.bean.ProductInfo;
import com.leosanqing.wxorder.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface ProductService {
    ProductInfo findOne(String productId);
    Page<ProductInfo> findAll(Pageable pageable);
    List<ProductInfo> findUpAll();
    ProductInfo save(ProductInfo productInfo);

    void decreaseStock(List<CartDTO> cartDTOList);
    void increaseStock(List<CartDTO> cartDTOList);
}
