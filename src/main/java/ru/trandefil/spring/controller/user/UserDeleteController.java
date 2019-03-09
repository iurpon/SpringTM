package ru.trandefil.spring.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.trandefil.spring.api.UserService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class UserDeleteController {

    @Autowired
    private UserService userService;

    @GetMapping("/deleteUser")
    public void deleteUser(@RequestParam("id") String id, HttpServletResponse response) throws IOException {
        userService.deleteById(id);
        response.sendRedirect("users");
    }

}
