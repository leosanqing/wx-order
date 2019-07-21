package com.leosanqing.wxorder;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class WxOrderApplicationTests {


    String name = "root";
    String password  = "root";
    @Test
    public void test1() {
        log.error("error");
        log.warn("warn..");
        log.debug("debug..");
        log.info("name:{} ,password:{}",name,password);

    }

}
