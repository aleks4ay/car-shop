package ua.aser.carshop.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Description {

    @Id
    @GeneratedValue
    private Long id;

    private int quantity;
    private double correctPrice;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "offer_id")
    private Offer offer;

    public Description() {
    }

    public Description(int quantity, double correctPrice, Product product) {
        this.quantity = quantity;
        this.correctPrice = correctPrice;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getCorrectPrice() {
        return correctPrice;
    }

    public void setCorrectPrice(double correctPrice) {
        this.correctPrice = correctPrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }
    @Override
    public String toString() {
        return "Description{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", correctPrice=" + correctPrice +
                ", product_id=" + product.getId() +
                ", offer_id=" + offer.getId() +
                '}';
    }
}
