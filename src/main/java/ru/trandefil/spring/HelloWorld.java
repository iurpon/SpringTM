package ru.trandefil.spring;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HelloWorld {

    private String name;

    public void printHello() {
        System.out.println("Spring : Hello ! " + name);
    }

}
