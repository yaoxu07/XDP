package com.yx.registerMain;/*
 * @program: Redis-Register
 *
 * @description:用于向redis中注册消费方的信息   JavaAPI的接入方式
 *
 * @author:yaoxu
 *
 * @create: 2018-08-20 18:07
 **/
import com.nantian.dtp.registry.IRegistryClient;
import com.nantian.dtp.registry.RegistryConnection;
import com.yx.bean.Consumer;
import com.yx.bean.CountRegister;
import com.yx.inter.XmlInterface;
import com.yx.util.PropertiesUtil;
import com.yx.util.XmlDomUtil;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;
import java.io.*;
import java.util.List;

public class ConsumerRegister {
    public static final Logger logger = org.apache.log4j.Logger.getLogger(ConsumerRegister.class);
   /* private XmlDomUtil xmlDomUtil;
    private int countConsumer;
    private int countProvider;

    public int getCountConsumer() {
        return countConsumer;
    }

    public void setCountConsumer(int countConsumer) {
        this.countConsumer = countConsumer;
    }

    public int getCountProvider() {
        return countProvider;
    }

    public void setCountProvider(int countConsumer) {
        xmlDomUtil = new XmlDomUtil(countConsumer) ;
        this.countProvider = countProvider;
    }
*/
    public static void startConsumerRegister() throws IOException, SAXException {
        String host = PropertiesUtil.getValue("redis-host");
        logger.info("redis host is:"+host);
        XmlInterface xmlInterface = new XmlDomUtil();
//        CountRegister countRegister = new CountRegister();
        logger.info("=========Consumer Info 开始注册！=============");
        RegistryConnection registryConnection = new RegistryConnection(host);
        IRegistryClient iRegistryClient = registryConnection.createClient();

        com.nantian.dtp.registry.dto.Consumer c = new com.nantian.dtp.registry.dto.Consumer();
        String xmlPath = "src/main/resources/redis-register-info.xml";
        logger.info("redis-register-info.xml文件的路径，xmlPath=" + xmlPath);
        List<Consumer> list = xmlInterface.xmlDocument(xmlPath);

        for (Consumer consumer : list) {
            logger.info("注册system：" + consumer.getConsumerName());
            c.setName(consumer.getConsumerName());
            logger.info("注册agent：" + consumer.getCAgentName());
            c.setAgentName(consumer.getCAgentName());
            logger.info("注册地址：" + consumer.getAddress() + "&" + consumer.getAddress1());
            c.setAddress(consumer.getAddress() + "&" + consumer.getAddress1());
            iRegistryClient.setResource(c);
        }
        logger.info("==============Consumer 注册完成！================");
    }

    public static void main(String[] args) {
        try {
            startConsumerRegister();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
