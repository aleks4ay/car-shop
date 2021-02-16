package ua.aser.carshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.aser.carshop.model.Role;
import ua.aser.carshop.model.User;
import ua.aser.carshop.repository.UserReposetories;

import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserReposetories userRepo;

/*    @GetMapping("/newUser")
    public String newCustomer(Map<String, Object> model) {
        model.put("user", new User("", "", ""));
        return "user_new";
    }
    @PostMapping("/newUser")
    public String newClient(@ModelAttribute User user, Map<String, Object> model) {
        user.addRole(Role.ROLE_USER);
        System.out.println(user.getRoles());
        userRepo.save(user);
        return "redirect:users";
    }*/
    @GetMapping("/users")
    public String getCustomer(Map<String, Object> model) {
        List<User> users = (List<User>) userRepo.findAll();
        model.put("users", users);
        return "user_list";
    }

    @GetMapping("/user_del")
    public String deleteById (@RequestParam String id, Map<String, Object> model) {
        userRepo.deleteById(Long.valueOf(id));
        return "redirect:users";
    }
}
