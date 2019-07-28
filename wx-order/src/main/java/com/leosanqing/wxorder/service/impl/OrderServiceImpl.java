package com.leosanqing.wxorder.service.impl;

import com.leosanqing.wxorder.bean.OrderDetail;
import com.leosanqing.wxorder.bean.OrderMaster;
import com.leosanqing.wxorder.bean.ProductInfo;
import com.leosanqing.wxorder.converter.OrderMaster2OrderDTO;
import com.leosanqing.wxorder.dao.OrderDetailRepository;
import com.leosanqing.wxorder.dao.OrderMasterRepository;
import com.leosanqing.wxorder.dto.CartDTO;
import com.leosanqing.wxorder.dto.OrderDTO;
import com.leosanqing.wxorder.enums.OrderStatusEnum;
import com.leosanqing.wxorder.enums.ResultExceptionEnum;
import com.leosanqing.wxorder.exception.SellException;
import com.leosanqing.wxorder.service.OrderService;
import com.leosanqing.wxorder.service.ProductService;
import com.leosanqing.wxorder.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    private ProductService productService;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;


    @Override
    public OrderDTO create(OrderDTO orderDTO) {

        String orderId = KeyUtil.genUniqueKey();

        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
        // 查询商品信息
        for (OrderDetail orderDetail: orderDTO.getOrderDetailList()) {
            ProductInfo productInfo = productService.findOne(orderDetail.getProductId());
            if(null == productInfo )
                throw new SellException(ResultExceptionEnum.PRODUCT_NOT_EXIT);
            // 计算总价
            orderAmount = productInfo.getProductPrice()
                    .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                    .add(orderAmount);

            // 将商品详情存入数据库
            BeanUtils.copyProperties(productInfo,orderDetail);
            // 注意这些要写在 BeanUtils的后面，不然会被他覆盖
            orderDetail.setDetailId(KeyUtil.genUniqueKey());
            orderDetail.setOrderId(orderId);

            orderDetailRepository.save(orderDetail);

        }

        // 写入订单数据库
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO,orderMaster);
        // 这个要写在BeanUtils后面，不然会被覆盖
        orderMaster.setOrderId(orderId);
        orderMaster.setOrderAmount(orderAmount);

        orderMasterRepository.save(orderMaster);


        // 减库存
        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream()
                .map(e -> new CartDTO(e.getProductId(), e.getProductQuantity()))
                .collect(Collectors.toList());
        productService.decrease(cartDTOList);

        return orderDTO;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        OrderMaster orderMaster = orderMasterRepository.findOne(orderId);
        if(null == orderMaster)
            throw new SellException(ResultExceptionEnum.ORDER_NOT_EXIT);
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);

        List<OrderDetail> orderDetailList = orderDetailRepository.findByOrderId(orderId);
        if(CollectionUtils.isEmpty(orderDetailList))
            throw new SellException(ResultExceptionEnum.ORDER_DETAIL_NOT_EXIT);
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenid, Pageable pageable) {
        Page<OrderMaster> orderMasterPage = orderMasterRepository.findByBuyerOpenid(buyerOpenid, pageable);
        List<OrderMaster> masterList = orderMasterPage.getContent();
        List<OrderDTO> orderDTOList = OrderMaster2OrderDTO.convert(masterList);

        return new PageImpl<>(orderDTOList, pageable, orderMasterPage.getTotalElements());


    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO,orderMaster);
        // 判断订单的状态
        if(!orderDTO.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())){
            log.error("[取消订单]，订单状态不正确，orderId={},orderStatus={}",orderDTO.getOrderId(),orderDTO.getOrderStatus());
            throw new SellException(ResultExceptionEnum.ORDER_STATUS_ERROR);
        }

        // 修改订单状态
        orderMaster.setOrderStatus(OrderStatusEnum.CANCEL.getCode());
        OrderMaster updateResult = orderMasterRepository.save(orderMaster);
        if (null ==updateResult) {
            log.error("[取消订单]更新订单失败，orderMaster={}", orderMaster);
            throw new SellException(ResultExceptionEnum.ORDER_UPDATE_ERROR);
        }

        // 返回库存
        if(CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            
        }

        // 如果已支付，退款
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }
}
