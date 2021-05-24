package ua.aser.carshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.aser.carshop.model.*;
import ua.aser.carshop.service.OrderItemService;
import ua.aser.carshop.service.OrderService;
import ua.aser.carshop.service.ProductService;
import ua.aser.carshop.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class OrderController {

    @Autowired
    private ProductService productService;
    @Autowired
    private OrderItemService orderItemService;
//    @Autowired
//    private OrderService orderService;
    @Autowired
    private UserService userService;

    @GetMapping("/shop")
    public String getProduct(Map<String, Object> model) {
        List<Product> products = productService.getAll();
        model.put("products", products);
        return "shop";
    }

    @GetMapping("/cart")
    public String getCart(HttpServletRequest httpServletRequest,
                          HttpSession httpSession,
                          Map<String, Object> model) {
        User user = userService.getOne(httpServletRequest.getRemoteUser());
        List<OrderItem> orderItems = (List<OrderItem>) httpSession.getAttribute("orderItems");
        model.put("orderItems", orderItems);
        System.out.println("");
        return "cart";
    }

    @PostMapping("/cart/save")
    public String newOrder(HttpServletRequest httpServletRequest,
                           HttpSession httpSession,
                           Map<String, Object> model,
                           @ModelAttribute(name = "newOrder") Order orderFromView) {


        List<OrderItem> orderItems = orderFromView.getOrderItems();
        if (orderItems == null){
            return "redirect:/shop";
        }
        String login = httpServletRequest.getRemoteUser();
        User user = null;
        if (login != null) {
            user = userService.getOne(login);
        }
        Order order = new Order();
        user.addOrder(order);
//        order.setOrderItems(orderItems);
        for (OrderItem item : orderItems){
            Product p1 = productService.getOne(item.getProduct().getId());
            item.setProduct(p1);
            order.addOrderItem(item);
            orderItemService.save(item);
        }
        httpSession.setAttribute("orderItems", null);
        return "redirect:/cart";
    }

    @GetMapping("/shop/add")
    public String newOrderItem(@RequestParam(name = "id") String id,
                               HttpServletRequest httpServletRequest,
                               HttpSession httpSession,
                               Map<String, Object> model) {
//        boolean isRoleUser = httpServletRequest.isUserInRole("USER");
//        boolean isRoleAdmin = httpServletRequest.isUserInRole("ADMIN");
        List<OrderItem> orderItems = (List<OrderItem>) httpSession.getAttribute("orderItems");
        if (orderItems == null) {
            orderItems = new ArrayList<>();
        }
        Product product = productService.getOne(Long.valueOf(id));
        addProduct(orderItems, product);
        httpSession.setAttribute("orderItems", orderItems);
        return "redirect:/shop";
    }

    @GetMapping("/admin/product")
    public String listProductAdmin(Map<String, Object> model) {
        List<Product> products = productService.getAll();
        model.put("products", products);
        return "product";
    }

    @PostMapping("/admin/product/new")
    public String newClient(@ModelAttribute Product product, Map<String, Object> model) {
        productService.save(product);
        return "redirect:/admin/product";
    }

    @GetMapping("/admin/product/change")
    public String changeProduct(@RequestParam(name = "id") String id,
                                Map<String, Object> model) {
        Product product = productService.getOne(Long.valueOf(id));
        model.put("product", product);
        return "product_change";
    }

    @PostMapping("/admin/product/change")
    public String changeProduct(@ModelAttribute Product product, Map<String, Object> model) {
        productService.save(product);
        return "redirect:/admin/product";
    }

    @GetMapping("admin/product/del")
    public String deleteProduct (@RequestParam String id, Map<String, Object> model) {
        productService.deleteById(Long.valueOf(id));
        return "redirect:/admin/product";
    }

    private void addProduct(List<OrderItem> orderItems, Product product) {
        if (orderItems.size() > 0) {
            for (OrderItem item : orderItems) {
                if (item.getProduct().equals(product)) {
                    item.setQuantity(item.getQuantity() + 1);
                    return;
                }
            }
        }
        orderItems.add(new OrderItem(1, product.getPrice(), product));
    }
}
