package ua.aser.carshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ua.aser.carshop.model.OrderItem;
import ua.aser.carshop.model.Order;
import ua.aser.carshop.model.Product;
import ua.aser.carshop.model.User;
import ua.aser.carshop.repository.OrderItemReposetories;
import ua.aser.carshop.repository.ProductReposetories;
import ua.aser.carshop.repository.UserReposetories;

import java.util.List;
import java.util.Map;

@Controller
public class OrderController {
    @Autowired
    private OrderItemReposetories orderItemRepo;
    @Autowired
    private ProductReposetories productRepo;
    @Autowired
    private UserReposetories userRepo;

    @GetMapping("/order/newItem")
    public String newClient(Map<String, Object> model) {
        Product product = new Product();
        OrderItem orderItem = new OrderItem(0, 0d, product);
        model.put("orderItem", orderItem);
        return "order_new";
    }
    @PostMapping("/order/newItem")
    public String newClient(@ModelAttribute OrderItem orderItem, Map<String, Object> model) {
        orderItem.getProduct().setPrice(orderItem.getCorrectPrice());
        Order order = new Order();
        order.addDescriptions(orderItem);
        orderItem.setOrder(order);
        orderItemRepo.save(orderItem);
        return "redirect:users";
    }

    @GetMapping("/cc")
    public String testС(Map<String, Object> model) {
        User user = ((List<User>)userRepo.findAll()).get(0);
        Order order = new Order();
        user.addOrder(order);
        Product p1 = new Product("носки", "красные", 45);
        Product p2 = new Product("платок", "Оренбуржский", 145);
        OrderItem i1 = new OrderItem(1, 234, p1);
        OrderItem i2 = new OrderItem(1, 1234, p2);
        order.addOrderItem(i1);
        order.addOrderItem(i2);
        orderItemRepo.save(i1);
        orderItemRepo.save(i2);
        return "redirect:users";
    }

    @GetMapping("/bb")
    public String testB(Map<String, Object> model) {
        User user = ((List<User>)userRepo.findAll()).get(0);
        Order order = new Order();
        user.addOrder(order);
        Product p1 = productRepo.findById(19L).orElse(null);
        Product p2 = productRepo.findById(21L).orElse(null);
        OrderItem i1 = new OrderItem(3, 45, p1);
        OrderItem i2 = new OrderItem(2, 145, p2);
        order.addOrderItem(i1);
        order.addOrderItem(i2);
        orderItemRepo.save(i1);
        orderItemRepo.save(i2);
        return "redirect:users";
    }

    @GetMapping("/aa")
    public String testA(Map<String, Object> model) {
        User user = userRepo.findById(13L).orElse(null);
        user.getOrders().get(0).getOrderItems().get(0).setQuantity(444);
        userRepo.save(user);
        return "redirect:users";
    }
}
