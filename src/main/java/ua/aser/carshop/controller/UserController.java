package ua.aser.carshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.aser.carshop.model.Role;
import ua.aser.carshop.model.User;
import ua.aser.carshop.repository.UserRepository;
import ua.aser.carshop.service.UserService;

import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration(Map<String, Object> model ) {
        return "registration";
    }

    @PostMapping("/registration")
    public String newClient(@ModelAttribute User user, Map<String, Object> model) {
        user.setActive(true);
//        user.setRoles(Collections.singleton(Role.ROLE_USER));
        user.addRole(Role.ROLE_USER);
        userService.save(user);
        return "redirect:/login";
    }

    @GetMapping("admin/users")
    public String getCustomer(Map<String, Object> model) {
        List<User> users = userService.getAll();
        model.put("users", users);
        return "user_list";
    }

    @GetMapping("admin/user_carts")
    public String getUserCarts(Map<String, Object> model) {
        List<User> users = userService.getAll();
        model.put("users", users);
        return "user_cart_list";
    }

    @GetMapping("admin/users/active")
    public String changeActive (@RequestParam String id, @RequestParam String active, Map<String, Object> model) {
        User user = userService.getById(Long.valueOf(id));
        user.setActive(!user.isActive());
        userService.save(user);
        return "redirect:/admin/users";
    }
}
