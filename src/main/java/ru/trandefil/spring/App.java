package ru.trandefil.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
/*        ApplicationContext context = new ClassPathXmlApplicationContext("app.xml");
        HelloWorld helloWorld = context.getBean("helloBean",HelloWorld.class);*/
        ApplicationContext context = new AnnotationConfigWebApplicationContext();
        ((AnnotationConfigWebApplicationContext) context).register(AppConfig.class);
        ((AnnotationConfigWebApplicationContext) context).refresh();
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames).forEach(System.out::println);
        HelloWorld helloWorld = context.getBean("helloWorld",HelloWorld.class);
        helloWorld.printHello();
    }
}
