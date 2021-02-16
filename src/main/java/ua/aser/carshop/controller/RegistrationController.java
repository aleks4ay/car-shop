package ua.aser.carshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ua.aser.carshop.model.Role;
import ua.aser.carshop.model.User;
import ua.aser.carshop.repository.UserReposetories;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {

    @Autowired
    private UserReposetories userRepo;

    @GetMapping("/registration")
    public String registration() {
        return "newUser";
    }

/*    @PostMapping("/registration")
    public String addUser (User user, Model model) {
        User userFromDb = userRepo.findByLogin(user.getLogin());
        if (userFromDb != null) {
            model.addAttribute("info", "User exists!");
            return "registration";
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.ROLE_USER));
        userRepo.save(user);
        return "redirect:/login";
    }*/

    @GetMapping("/newUser")
    public String newCustomer(Map<String, Object> model) {
        model.put("user", new User("", "", ""));
        return "user_new";
    }
    @PostMapping("/newUser")
    public String newClient(@ModelAttribute User user, Map<String, Object> model) {
        user.setActive(true);
//        user.setRoles(Collections.singleton(Role.ROLE_USER));
        user.addRole(Role.ROLE_USER);
        userRepo.save(user);
        return "redirect:/login";
    }
}