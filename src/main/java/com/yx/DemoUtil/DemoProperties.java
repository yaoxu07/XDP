package com.yx.DemoUtil;

import com.yx.util.PropertiesUtil;
import org.apache.log4j.Logger;


/**
 * @program: Redis-Register
 * @description: 测试 工具类
 * @author: yaoxu
 * @create: 2018-08-21 11:14
 **/
public class DemoProperties {
    public static final Logger logger = Logger.getLogger(DemoProperties.class);
    public static void main(String[] args) {
        logger.info("name="+PropertiesUtil.getValue("name"));
        logger.info("age="+PropertiesUtil.getValue("age"));

    }
}
