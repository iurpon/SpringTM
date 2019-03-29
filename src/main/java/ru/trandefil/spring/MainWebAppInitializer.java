package ru.trandefil.spring;

import com.sun.faces.config.FacesInitializer;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

@Configuration
@ComponentScan({"ru.trandefil.spring"})
public class MainWebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext sc) throws ServletException {
        AnnotationConfigWebApplicationContext root =
                new AnnotationConfigWebApplicationContext();
/*
        root.scan("ru.trandefil.spring");*/
        sc.addListener(new ContextLoaderListener(root));
//        sc.addListener(new RequestContextListener());
        root.refresh();

         ServletRegistration.Dynamic appServlet =
                sc.addServlet("mvc", new DispatcherServlet(new GenericWebApplicationContext()));
          appServlet.setLoadOnStartup(2);
        appServlet.addMapping("/");

        String[] beanDefinitionNames = root.getBeanDefinitionNames();
        for (String names : beanDefinitionNames) {
            System.out.println(names);
        }

        ServletRegistration.Dynamic dispatcher
                = sc.addServlet("dispatcher", new CXFServlet());
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/services");

    }

}
