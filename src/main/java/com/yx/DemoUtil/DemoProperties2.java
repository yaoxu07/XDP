package com.yx.DemoUtil;

import com.yx.util.PropertiesUtil;
import com.yx.util.PropertiesUtil2;
import org.apache.log4j.Logger;


/**
 * @program: Redis-Register
 * @description: 测试 工具类
 * @author: yaoxu
 * @create: 2018-08-21 11:14
 **/
public class DemoProperties2 {
    public static final Logger logger = Logger.getLogger(DemoProperties2.class);
    public static void main(String[] args) {
        logger.info("name="+PropertiesUtil2.getProperties("name"));
        logger.info("age="+PropertiesUtil2.getProperties("age","18"));
        logger.info("key="+PropertiesUtil2.getProperties("k3"));

    }
}
