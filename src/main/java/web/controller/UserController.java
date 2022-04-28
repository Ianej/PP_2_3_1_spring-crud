package web.controller;

import hiber.config.HiberConfig;
import hiber.model.User;
import hiber.service.UserService;
import hiber.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    //@Qualifier("userServiceImpl")/**/
    private UserService userService;

    @GetMapping(value = "/")
    public String printUsers(ModelMap modelMap) {
        modelMap.addAttribute("users", userService.listUsers());
        return "index";
    }

    @GetMapping(value = "/newUser")
    public String newUser(ModelMap modelMap) {
        modelMap.addAttribute("user", new User());
        return "newUser";
    }

    @PostMapping(value = "/newUser")
    public String newUser(String name, String lastName, int age) {
        userService.addUser(name, lastName, age);
        return "redirect:/";
    }

    @GetMapping(value = "/edit")
    public String editUser (long id, ModelMap modelMap) {
        modelMap.addAttribute("user", userService.getUser(id) );
        return "edit";
    }

    @PostMapping(value = "/edit")
    public String editUser (long id, String name, String lastName, int age) {
        userService.updateUser(id, name, lastName, age);
        return "redirect:/";
    }

    @GetMapping(value = "/delete")
    public String deleteUser(long id) {
        userService.removeUser(id);
        return "redirect:/";
    }
}
