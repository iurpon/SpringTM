package ru.trandefil.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Logger;

@Controller
public class MainController {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @GetMapping("/")
    public String showForm() {
        logger.info("============================  /  GET");
        return "redirect:/wellcome";
    }

    @GetMapping("/wellcome")
    public String welcome() {
        logger.info("==================================== wellcome GET");
        return "hello";
    }

}
