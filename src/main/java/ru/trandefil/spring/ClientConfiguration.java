package ru.trandefil.spring;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.trandefil.spring.endpoint.Baeldung;

@Configuration
public class ClientConfiguration {

    @Bean(name = "client")
    public Object generateProxy() {
        return proxyFactoryBean().create();
    }

    @Bean
    public JaxWsProxyFactoryBean proxyFactoryBean() {
        JaxWsProxyFactoryBean proxyFactory = new JaxWsProxyFactoryBean();
        proxyFactory.setServiceClass(Baeldung.class);
        proxyFactory.setAddress("http://localhost:8080/services/baeldung");
        return proxyFactory;
    }

}

