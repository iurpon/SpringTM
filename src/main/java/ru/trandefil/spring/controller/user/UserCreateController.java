package ru.trandefil.spring.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.trandefil.spring.api.UserService;
import ru.trandefil.spring.model.User;

@Controller
public class UserCreateController {

    @Autowired
    private UserService userService;

    @GetMapping("/addUser")
    public String goToAddForm(Model model) {
        model.addAttribute("user", new User());
        return "editUserForm";
    }

    @PostMapping("/addUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/users";
    }

}
