package ru.trandefil.spring.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(endpointInterface = "ru.trandefil.spring.endpoint.Baeldung")
public class BaeldungImpl implements Baeldung {

    @WebMethod
    public String hello(@WebParam String name) {
        return "Hello " + name + "!";
    }

/*    public String register(Student student) {
        counter++;
        return student.getName() + " is registered student number " + counter;
    }*/
}
