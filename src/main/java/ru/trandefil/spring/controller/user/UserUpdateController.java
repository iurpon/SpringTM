package ru.trandefil.spring.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.trandefil.spring.api.UserService;
import ru.trandefil.spring.model.User;

import java.util.logging.Logger;

@Controller
public class UserUpdateController {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    private UserService userService;

    @GetMapping("/updateUser")
    public String getUpdatedUser(@RequestParam("id") String id, Model model) {
        logger.info("======================================UserUpdate  GET");
        final User user = userService.getById(id);
        model.addAttribute("user", user);
        return "editUserForm";
    }

}
