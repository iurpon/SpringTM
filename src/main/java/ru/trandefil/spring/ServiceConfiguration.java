package ru.trandefil.spring;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.trandefil.spring.endpoint.BaeldungImpl;

import javax.xml.ws.Endpoint;

//@EnableWs
@Configuration
@ComponentScan({"ru.trandefil.spring"})
public class ServiceConfiguration {

    @Autowired
    private ApplicationContext context;

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Bean
    public Endpoint endpoint() {
        Bus bus = (Bus) context.getBean(Bus.DEFAULT_BUS_ID);
        EndpointImpl endpoint = new EndpointImpl(bus, new BaeldungImpl());
        endpoint.publish("http://localhost:8080/services/baeldung");
        return endpoint;
    }

}
