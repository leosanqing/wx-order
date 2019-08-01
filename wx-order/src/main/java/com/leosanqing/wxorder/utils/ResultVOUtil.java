package com.leosanqing.wxorder.utils;

import com.leosanqing.wxorder.VO.ResultVO;

public class ResultVOUtil {
    public static ResultVO success(Object object){
        ResultVO<Object> objectResultVO = new ResultVO<>();
        objectResultVO.setMsg("成功");
        objectResultVO.setCode(0);
        objectResultVO.setData(object);
        return objectResultVO;
    }


    public static ResultVO success(){
        ResultVO<Object> objectResultVO = new ResultVO<>();
        objectResultVO.setCode(0);
        objectResultVO.setMsg("成功");
        return objectResultVO;
    }


    public static ResultVO error(Integer code ,String msg){
        ResultVO<Object> objectResultVO = new ResultVO<>();
        objectResultVO.setCode(code);
        objectResultVO.setMsg(msg);
        return objectResultVO;
    }
}
