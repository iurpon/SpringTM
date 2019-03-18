package ru.trandefil.spring.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.trandefil.spring.api.UserService;
import ru.trandefil.spring.model.Role;
import ru.trandefil.spring.model.User;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class UserCreateController {

    @Autowired
    private UserService userService;

    @GetMapping("/addUser")
    public String goToAddForm(Model model) {
        model.addAttribute("user", new User());
        return "editUserForm";
    }

/*    @PostMapping("/addUser")
    public void saveUser(
            @RequestParam("name") String name,
            @RequestParam("password") String password,
            @RequestParam("role") String role,
            HttpServletResponse response
    ) throws IOException {
        userService.save(new User(null,name,password,Enum.valueOf(Role.class,role)));
        response.sendRedirect("users");
    }*/
    @PostMapping("/addUser")
    public String save(@ModelAttribute("user") User user, BindingResult bindingResult, ModelMap modelMap ){
        System.out.println("saving user : " + user);
        userService.save(user);
        return "redirect:/users";
    }

}
