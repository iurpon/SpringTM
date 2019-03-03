package ru.trandefil.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
/*        ApplicationContext context = new ClassPathXmlApplicationContext("app.xml");
        HelloWorld helloWorld = context.getBean("helloBean",HelloWorld.class);*/
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        HelloWorld helloWorld = context.getBean("helloWorld",HelloWorld.class);
        helloWorld.printHello();
    }
}
