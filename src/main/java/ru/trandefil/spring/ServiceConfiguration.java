package ru.trandefil.spring;

import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.trandefil.spring.endpoint.BaeldungImpl;

import javax.xml.ws.Endpoint;

//@EnableWs
@Configuration
@ComponentScan({"ru.trandefil.spring"})
public class ServiceConfiguration {

    @Bean
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), new BaeldungImpl());
        endpoint.publish("http://localhost:8080/services/baeldung");
        return endpoint;
    }

}
