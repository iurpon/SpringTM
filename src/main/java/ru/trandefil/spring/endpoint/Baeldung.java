package ru.trandefil.spring.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface Baeldung {

    @WebMethod
    String hello(@WebParam String name);
//    String register(Student student);
}