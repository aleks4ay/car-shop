package ua.aser.carshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.aser.carshop.model.OrderItem;
import ua.aser.carshop.model.Order;
import ua.aser.carshop.model.Product;
import ua.aser.carshop.model.User;
import ua.aser.carshop.service.OrderItemService;
import ua.aser.carshop.service.OrderService;
import ua.aser.carshop.service.ProductService;
import ua.aser.carshop.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class OrderController {

    @Autowired
    private ProductService productService;
    @Autowired
    private OrderItemService orderItemService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;

    @GetMapping("/shop")
    public String getProduct(Map<String, Object> model) {
        List<Product> products = productService.getAll();
        model.put("products", products);
        return "shop";
    }

    @GetMapping("/order/newItem")
    public String newClient(Map<String, Object> model) {
        Product product = new Product();
        OrderItem orderItem = new OrderItem(0, 0d, product);
        model.put("orderItem", orderItem);
        return "order_new";
    }
    @GetMapping("/shop/add")
    public String newOrderItem(@RequestParam(name = "id") String id,
                               HttpServletRequest httpServletRequest,
                               HttpSession httpSession,
                               Map<String, Object> model) {
        boolean isRoleUser = httpServletRequest.isUserInRole("USER");
        boolean isRoleAdmin = httpServletRequest.isUserInRole("ADMIN");
//        User user = (User) httpSession.getAttribute("owner");
        String sesseonId = httpSession.getId();
//        Order order = orderService.getBySessionId(sesseonId);
        Order order = (Order)httpSession.getAttribute("order");
        if (order == null) {
            order = new Order();
            order.setSessionId(sesseonId);
        }
        Product product = productService.getOne(Long.valueOf(id));
        OrderItem orderItem = new OrderItem(1, product.getPrice(), product);
        order.addOrderItem(orderItem);
//        String login = httpServletRequest.getRemoteUser();
        /*User user = null;
        if (login!=null) {
            user = userService.getOne(login);
        }
        user.addOrder(order);*/
//            orderItemService.save(orderItem);
        httpSession.setAttribute("order", order);
        return "redirect:/shop";
    }

    @GetMapping("/shopAdmin")
    public String listProductAdmin(Map<String, Object> model) {
        List<Product> products = productService.getAll();
        model.put("products", products);
        return "shop_admin";
    }

    @PostMapping("/shopAdmin/new")
    public String newClient(@ModelAttribute Product product, Map<String, Object> model) {
        productService.save(product);
        return "redirect:/shopAdmin";
    }

    @GetMapping("/shopAdmin/change")
    public String changeProduct(@RequestParam(name = "id") String id,
                                HttpServletRequest httpServletRequest,
                                HttpSession httpSession,
                                Map<String, Object> model) {
        Product product = productService.getOne(Long.valueOf(id));
        model.put("product", product);
        return "product_change";
    }

    @GetMapping("/cc")
    public String testС(Map<String, Object> model) {
        User user = ((List<User>)userService.getAll()).get(0);
        Order order = new Order();
        user.addOrder(order);
        Product p1 = new Product("носки", "красные", 45);
        Product p2 = new Product("платок", "Оренбуржский", 145);
        OrderItem i1 = new OrderItem(1, 234, p1);
        OrderItem i2 = new OrderItem(1, 1234, p2);
        order.addOrderItem(i1);
        order.addOrderItem(i2);
        orderItemService.save(i1);
        orderItemService.save(i2);
        return "redirect:users";
    }

    @GetMapping("/bb")
    public String testB(Map<String, Object> model) {
        User user = ((List<User>)userService.getAll()).get(0);
        Order order = new Order();
        user.addOrder(order);
        Product p1 = productService.getOne(19L);
        Product p2 = productService.getOne(21L);
        OrderItem i1 = new OrderItem(3, 45, p1);
        OrderItem i2 = new OrderItem(2, 145, p2);
        order.addOrderItem(i1);
        order.addOrderItem(i2);
        orderItemService.save(i1);
        orderItemService.save(i2);
        return "redirect:users";
    }

    @GetMapping("/aa")
    public String testA(Map<String, Object> model) {
        User user = ((List<User>)userService.getAll()).get(1);
        user.getOrders().get(0).getOrderItems().get(0).setQuantity(444);
        userService.save(user);
        return "redirect:users";
    }
}
