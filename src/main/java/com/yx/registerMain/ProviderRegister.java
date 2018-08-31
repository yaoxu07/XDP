package com.yx.registerMain;

import com.nantian.dtp.registry.IRegistryClient;
import com.nantian.dtp.registry.RegistryConnection;
import com.yx.bean.CountRegister;
import com.yx.bean.Provider;
import com.yx.inter.XmlInterface;
import com.yx.util.PropertiesUtil;
import com.yx.util.XmlDomUtil;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;

/**
 * @program: redis-register
 * @description: Provider注册
 * @author: yaoxu
 * @create: 2018-08-25 21:54
 **/
public class ProviderRegister {
    public static final Logger logger = org.apache.log4j.Logger.getLogger(ConsumerRegister.class);

    public static void startProviderRegister() throws IOException, SAXException {
        XmlInterface xmlInterface = new XmlDomUtil();
        String host = PropertiesUtil.getValue("redis-host") ;
        logger.info("redis host is:"+host);
        logger.info("=============Provider Info 开始注册！===================");
        RegistryConnection registryConnection = new RegistryConnection(host) ;
        IRegistryClient iRegistryClient = registryConnection.createClient();

        com.nantian.dtp.registry.dto.Provider p = new com.nantian.dtp.registry.dto.Provider();
        String xmlPath = "src/main/resources/redis-register-info.xml";
        logger.info("redis-register-info.xml文件的路径，xmlPath=" + xmlPath);
        List<Provider> list = xmlInterface.xmlDocumentProvider(xmlPath);
        for (Provider provider : list) {
            logger.info("注册system：" + provider.getProviderName());
            p.setName(provider.getProviderName());
            logger.info("注册agent：" + provider.getPagentName());
            p.setAgentName(provider.getPagentName());
            logger.info("注册地址：" + provider.getAddress() + "&" + provider.getAddress1());
            p.setAddress(provider.getAddress()+"&"+provider.getAddress1());
            iRegistryClient.setResource(p);
        }
        logger.info("==========Provider 注册完成！===============");
    }

    public static void main(String[] args) throws IOException, SAXException {
        startProviderRegister();
    }
}
