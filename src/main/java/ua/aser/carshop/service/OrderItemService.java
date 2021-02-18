package ua.aser.carshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.aser.carshop.model.OrderItem;
import ua.aser.carshop.repository.OrderItemRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    public List<OrderItem> getAll() {
        return (List<OrderItem>) orderItemRepository.findAll();
    }

    public OrderItem getOne(Long id) {
        return orderItemRepository.findById(id).orElse(null);
    }

    @Transactional
    public void save(OrderItem orderItem) {
        orderItemRepository.save(orderItem);
    }

    @Transactional
    public void deleteById(Long id) {
        orderItemRepository.deleteById(Long.valueOf(id));
    }
}