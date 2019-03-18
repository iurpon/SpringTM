package ru.trandefil.spring.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.trandefil.spring.api.UserService;
import ru.trandefil.spring.model.Role;
import ru.trandefil.spring.model.User;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
        logger.info("===========================================updating " + user);
        model.addAttribute("action", "update");
        model.addAttribute("user", user);
        return "editUserForm";
    }

/*    @PostMapping("/updateUser")
    public void updateUser(
            @RequestParam("id") String id,
            @RequestParam("name") String name,
            @RequestParam("password") String password,
            @RequestParam("role") String role,
            HttpServletResponse response
    ) throws IOException {
        logger.info("======================================UserUpdate  POSt");
        userService.save(new User(id,name,password,Enum.valueOf(Role.class,role)));
        response.sendRedirect("users");
    }*/

}
