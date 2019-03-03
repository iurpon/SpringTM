package ru.trandefil.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean(name = "helloWorld")
    public HelloWorld helloWorld(){
        final HelloWorld helloWorld =  new HelloWorld();
        helloWorld.setName("Trandefil");
        return helloWorld;
    }
}
