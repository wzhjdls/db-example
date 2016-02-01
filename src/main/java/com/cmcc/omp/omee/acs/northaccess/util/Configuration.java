package com.cmcc.omp.omee.acs.northaccess.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.HashMap;
import java.util.Properties;

/**
 * Created by wzhjdls on 2016/2/1.
 */
public class Configuration extends PropertyPlaceholderConfigurer {
    static HashMap propertiesMap = new HashMap();

    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) throws BeansException {
        super.processProperties(beanFactoryToProcess, props);
        for (Object key : props.keySet()) {
            String keyStr = key.toString();
            String value = props.getProperty(keyStr);
            propertiesMap.put(keyStr, value);
        }
    }

    public static Object getContextProperty(String name) {
        return propertiesMap.get(name);
    }


}
