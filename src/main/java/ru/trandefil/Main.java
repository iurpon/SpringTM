package ru.trandefil;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.trandefil.spring.ServiceConfiguration;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext config =
                new AnnotationConfigApplicationContext(ServiceConfiguration.class);
        String[] beanDefinitionNames = config.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }
}
