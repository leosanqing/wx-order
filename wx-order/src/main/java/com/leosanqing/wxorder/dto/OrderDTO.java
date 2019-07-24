package com.leosanqing.wxorder.dto;

import com.leosanqing.wxorder.bean.OrderDetail;
import com.leosanqing.wxorder.enums.OrderStatusEnum;
import com.leosanqing.wxorder.enums.PayStatusEnum;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class OrderDTO {
    private String orderId;
    private String buyerName;
    private String buyerPhone;
    private String buyerAddress;
    private String buyerOpenid;
    private BigDecimal orderAmount;
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    private Date createTime;
    private Date updateTime;

    List<OrderDetail> orderDetailList;
}
