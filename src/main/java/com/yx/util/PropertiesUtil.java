package com.yx.util;



import com.yx.DemoUtil.DemoProperties;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @program: Redis-Register
 * @description: Properties  配置文件处理工具类
 * @author: yaoxu
 * @create: 2018-08-21 11:06
 **/
public class PropertiesUtil {
    public static final Logger logger = Logger.getLogger(DemoProperties.class);
    //静态块中不能有非静态属性，所以加static
    private static Properties properties = null ;
    static{

        properties = new Properties() ;
        try {
            properties.load(PropertiesUtil.class.getClassLoader().getResourceAsStream("properties.properties"));
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    //静态方法可以被类名直接调用
    public static String getValue(String key){
        return properties.getProperty(key) ;
    }
}
