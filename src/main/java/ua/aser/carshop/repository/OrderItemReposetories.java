package ua.aser.carshop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.aser.carshop.model.OrderItem;

@Repository
public interface OrderItemReposetories extends CrudRepository<OrderItem, Long> {
}
