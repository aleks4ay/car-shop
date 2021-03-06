package ua.aser.carshop.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ordr")
public class Order {

    @Id
    @GeneratedValue
    private Long id;

//    private String sessionId;

    private LocalDateTime registred = LocalDateTime.now();

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    private List<OrderItem> orderItems = new ArrayList<>();

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getRegistred() {
        return registred;
    }

    public void setRegistred(LocalDateTime registred) {
        this.registred = registred;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        if (orderItems != null) {
            for (OrderItem item : orderItems) {
                item.setOrder(this);
            }
            this.orderItems = orderItems;
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

//    public String getSessionId() {
//        return sessionId;
//    }

//    public void setSessionId(String sessionId) {
//        this.sessionId = sessionId;
//    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
//                ", sessionId='" + sessionId + '\'' +
                ", registred=" + registred +
                ", orderItems=" + orderItems +
                ", user=" + user +
                '}';
    }
}
