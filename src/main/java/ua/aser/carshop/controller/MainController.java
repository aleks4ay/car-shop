package ua.aser.carshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class MainController {
    @RequestMapping("/shopcar")
    public String hello(Map<String, Object> model) {
        model.put("name", "Spring Boot with Thymeleaf  *.html");
        return "hello1";
    }
}
