package com.leosanqing.wxorder.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
public class ProductInfo {
    // 商品ID
    @Id
    private String productId;
    // 商品名称
    private String productName;
    // 商品价格
    private BigDecimal productPrice;
    // 商品库存
    private int productStock;
    // 商品描述
    private String productDescription;
    // 商品图片路径
    private String productIcon;
    // 商品类目
    private int categoryType;

    // 商品状态，默认 0
    private int productStatus;

    private Date createTime;
    private Date updateTime;
}
