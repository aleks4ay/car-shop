package ua.aser.carshop.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Offer {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime registred = LocalDateTime.now();

    @OneToMany(mappedBy = "offer", fetch = FetchType.EAGER)
    private List<Description> descriptions = new ArrayList<>();

//    private Client client;

    public Offer() {
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

    public List<Description> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<Description> descriptions) {
        this.descriptions = descriptions;
    }

    public void addDescriptions(Description descriptions) {
        this.descriptions.add(descriptions);
    }

    @Override
    public String toString() {
        return "Offer{" +
                "id=" + id +
                ", registred=" + registred +
                ", descriptions=" + descriptions +
                '}';
    }
}
