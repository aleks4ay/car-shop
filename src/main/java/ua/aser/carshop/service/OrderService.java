package ua.aser.carshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.aser.carshop.model.Order;
import ua.aser.carshop.repository.OrderRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAll() {
        return (List<Order>) orderRepository.findAll();
    }

    public Order getOne(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

   /* public Order getBySessionId(String sessionId) {
        return orderRepository.findBySessionId(sessionId);
    }
*/
    @Transactional
    public void save(Order orderItem) {
        orderRepository.save(orderItem);
    }
}