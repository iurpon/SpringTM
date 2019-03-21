package ru.trandefil.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.trandefil.spring.service.UserService;
import ru.trandefil.spring.model.User;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class UserController {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    private UserService userService;

    @GetMapping("/addUser")
    public String goToAddForm(Model model) {
        model.addAttribute("user", new User());
        return "editUserForm";
    }

    @PostMapping("/addUser")
    public String saveUser(@ModelAttribute("user") User user) {
        logger.info("========================= user create POST. saving user : " + user);
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/users")
    public String userList(ModelMap model) {
        logger.info("================================= user list GET");
        final List<User> all = userService.getAll();
        model.addAttribute("users", all);
        return "user-list";
    }

    @GetMapping("/deleteUser")
    public void deleteUser(@RequestParam("id") String id, HttpServletResponse response) throws IOException {
        logger.info("============================================= delete User GET");
        userService.deleteById(id);
        response.sendRedirect("users");
    }

    @GetMapping("/updateUser")
    public String getUpdatedUser(@RequestParam("id") String id, Model model) {
        logger.info("======================================UserUpdate  GET");
        final User user = userService.getById(id);
        model.addAttribute("user", user);
        return "editUserForm";
    }

}
