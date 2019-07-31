package com.leosanqing.wxorder.controller;

import com.leosanqing.wxorder.VO.ResultVO;
import com.leosanqing.wxorder.converter.OrderForm2OrderDTO;
import com.leosanqing.wxorder.dto.OrderDTO;
import com.leosanqing.wxorder.enums.ResultExceptionEnum;
import com.leosanqing.wxorder.exception.SellException;
import com.leosanqing.wxorder.form.OrderForm;
import com.leosanqing.wxorder.service.OrderService;
import com.leosanqing.wxorder.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: leosanqing
 * @Date: 2019-07-30 06:57
 */

@RequestMapping("/buyer/order")
@Controller
@Slf4j
public class BuyerOrderController {
    @Autowired
    private OrderService orderService;

    // 创建订单
    @PostMapping("/create")
    public ResultVO<Map<String,String>> create(@Valid OrderForm orderForm,
                                               BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            log.error("[创建订单] 参数不正确，orderForm ={}",orderForm);
            throw new SellException(ResultExceptionEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDTO orderDTO = OrderForm2OrderDTO.convert(orderForm);


        if(CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("[转换异常] 购物车为空");
            throw new SellException(ResultExceptionEnum.CART_EMPTY);
        }
        OrderDTO orderResult = orderService.create(orderDTO);
        Map<String,String> hash = new HashMap<>();
        hash.put("orderId",orderResult.getOrderId());
        ResultVO success = ResultVOUtil.success(hash);
        return success;
    }


    //订单列表

    // 订单详情

    // 取消订单
}
