package ru.trandefil.spring.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.trandefil.spring.api.UserService;
import ru.trandefil.spring.model.User;

import java.util.List;
import java.util.logging.Logger;

@Controller
public class UserListController {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String userList(ModelMap model){
        logger.info("================================= user list GET");
        final List<User> all = userService.getAll();
        model.addAttribute("users",all);
        return "user-list";
    }

}
