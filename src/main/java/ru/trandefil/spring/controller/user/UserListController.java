package ru.trandefil.spring.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserListController {

    @GetMapping("/users")
    public String userList(){
        return "user-list";
    }

}
