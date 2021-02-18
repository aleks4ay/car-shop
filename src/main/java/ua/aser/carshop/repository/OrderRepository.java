package ua.aser.carshop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.aser.carshop.model.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
    Order findBySessionId (String sessionId);
}
