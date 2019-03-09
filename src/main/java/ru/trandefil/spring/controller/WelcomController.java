package ru.trandefil.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomController {

    @GetMapping("")
    public String showForm() {
        return "welcome";
    }

}
