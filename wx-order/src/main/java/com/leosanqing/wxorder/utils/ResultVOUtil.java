package com.leosanqing.wxorder.utils;

import com.leosanqing.wxorder.VO.ProductVO;
import com.leosanqing.wxorder.VO.ResultVO;

public class ResultVOUtil {
    public static ResultVO success(Object object){
        ResultVO<Object> objectResultVO = new ResultVO<>();
        objectResultVO.setMag("成功");
        objectResultVO.setCode(0);
        objectResultVO.setData(object);
        return objectResultVO;
    }


    public ResultVO success(){
        ResultVO<Object> objectResultVO = new ResultVO<>();
        objectResultVO.setCode(0);
        objectResultVO.setMag("成功");
        return objectResultVO;
    }


    public ResultVO error(Integer code ,String msg){
        ResultVO<Object> objectResultVO = new ResultVO<>();
        objectResultVO.setCode(code);
        objectResultVO.setMag(msg);
        return objectResultVO;
    }
}
