package com.yx.util;
import com.sun.org.apache.xalan.internal.xsltc.compiler.SourceLoader;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.Properties;
/**
 * @program: Redis-Register
 * @description: Properties  配置文件处理工具类
 * @author: yaoxu
 * @create: 2018-08-21 11:06
 **/

public class PropertiesUtil2 {
    public static final Logger logger = Logger.getLogger(PropertiesUtil2.class);
    //静态块中不能有非静态属性，所以加static
    private static Properties properties  ;
    private PropertiesUtil2(){

    }
    /*
    *
    *   读配置文件
    *
    * */
    static{
//        String fileName = "properties.properties" ;
        String fileName = "E:/properties.properties";
//        fileName = PropertyConfigurator.configure( "E:\\6、CTP-project\\log4j.properties" );
        properties = new Properties() ;
        try {
            //1、加载项目外部配置文件
            properties.load(new FileInputStream(new File(fileName)));
            //2、相对路径
//            =======
            InputStream is = ClassLoader.getSystemResourceAsStream("1.properties");
//            	InputStream is = SourceLoader.class.getClassLoader().getSystemResourceAsStream("db.properties");
//            InputStream inputStream = Thread.currentThread().getContextClassLoader().getSystemResourceAsStream("db.properties");
//            //相对路径 properties文件盒java放在一起
//            InputStream is = SourceLoader.class.getResourceAsStream("db.properties");
            properties.load(is);
//            =======
//            properties.load(new InputStreamReader(PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName),"UTF-8"));

            //3、
        }
        catch (IOException e)
        {
            logger.error("配置文件读取失败!", e);
        }
    }
   /* //静态方法可以被类名直接调用
    public static String getValue(String key){
        return properties.getProperty(key) ;
    }*/
    /**
     * 根据key来获取value
     * @param key
     * @return
     */
    public static String getProperties(String key)
    {
        String value = properties.getProperty(key.trim());
        if (value==null)return null;
        return value.trim();
    }

    /**
     * 如果key获取到的值是空的话则Value则为默认值defaultValue
     * @param key
     * @param defaultValue
     * @return
     */
    public static String getProperties(String key , String defaultValue)
    {
        String value = properties.getProperty(key.trim());
        if (value==null)value=defaultValue.trim();
        return value.trim();
    }
}

