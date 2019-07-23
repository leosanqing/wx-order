package com.leosanqing.wxorder.dao;

import com.leosanqing.wxorder.bean.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {
    List<OrderDetail> findByOrderId(String orderId);
}
