package ru.trandefil.spring;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class InitializingBeanExampleBean implements InitializingBean {

    private static final Logger LOG
            = Logger.getLogger(InitializingBeanExampleBean.class.getName());

    @Autowired
    private Environment environment;

    private int count = 0;

    @Override
    public void afterPropertiesSet() throws Exception {
        LOG.info("==================================count increased : " + count++);
    }
}