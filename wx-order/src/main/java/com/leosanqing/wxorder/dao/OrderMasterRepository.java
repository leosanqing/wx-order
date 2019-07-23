package com.leosanqing.wxorder.dao;

import com.leosanqing.wxorder.bean.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {
    Page<OrderMaster> findByBuyerOpenId(String openid, Pageable pageable);
}
