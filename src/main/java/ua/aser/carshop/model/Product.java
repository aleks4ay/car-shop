package ua.aser.carshop.model;

import org.thymeleaf.expression.Dates;
import org.thymeleaf.util.DateUtils;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Locale;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String color;
    private double price;
    private LocalDateTime registred = LocalDateTime.now();

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    private Collection<OrderItem> orderItems;

    public Product() {
    }

    public Product(String name, String color, double price) {
        this.name = name;
        this.color = color;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDateTime getRegistred() {
        return registred;
    }

    public void setRegistred(LocalDateTime registred) {
        this.registred = registred;
    }

    public Collection<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Collection<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public String getThymeleafDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy, HH:mm");
        return registred.format(formatter);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", registred=" + registred +
                ", orderItems=" + orderItems +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (Double.compare(product.getPrice(), getPrice()) != 0) return false;
        if (getId() != null ? !getId().equals(product.getId()) : product.getId() != null) return false;
        if (getName() != null ? !getName().equals(product.getName()) : product.getName() != null) return false;
        if (getColor() != null ? !getColor().equals(product.getColor()) : product.getColor() != null) return false;
        return getRegistred() != null ? getRegistred().equals(product.getRegistred()) : product.getRegistred() == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getColor() != null ? getColor().hashCode() : 0);
        temp = Double.doubleToLongBits(getPrice());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (getRegistred() != null ? getRegistred().hashCode() : 0);
        return result;
    }
}
