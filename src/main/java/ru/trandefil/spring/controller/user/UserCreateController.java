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
public class UserCreateController {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    private UserService userService;

    @GetMapping("/addUser")
    public String goToAddForm(Model model) {
        logger.info("=================================== user create GET");
        model.addAttribute("action", "create");
        return "editUser";
    }

    @PostMapping("/addUser")
    public void saveUser(
            @RequestParam("name") String name,
            @RequestParam("password") String password,
            @RequestParam("role") String role,
            HttpServletResponse response
    ) throws IOException {
        logger.info("============================================ user create POST");
        userService.save(new User(null,name,password,Enum.valueOf(Role.class,role)));
        response.sendRedirect("users");
    }

}
