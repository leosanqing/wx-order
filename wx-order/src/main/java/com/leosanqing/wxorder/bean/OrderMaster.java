package com.leosanqing.wxorder.bean;

import com.leosanqing.wxorder.enums.OrderStatusEnum;
import com.leosanqing.wxorder.enums.PayStatusEnum;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class OrderMaster {
    //
    @Id
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
}
