package ua.aser.carshop.model;

import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
public class Client {

    @Id
    @GeneratedValue
    private Long id;

    private String login;

    private String password;
    private String email;
    private boolean enabled = true;
    private LocalDateTime registred = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "client_roles", joinColumns = @JoinColumn(name = "client_id"))
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER) //    @Fetch(FetchMode.SUBSELECT)
    private Set<Role> roles = new HashSet<>();

//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<ClientRole> roles = new ArrayList<>();

//    private List<Offer> offers = new ArrayList<>();

    public Client() {
    }

    public Client(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.roles.add(Role.ROLE_USER);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public LocalDateTime getRegistred() {
        return registred;
    }

    public void setRegistred(LocalDateTime registred) {
        this.registred = registred;
    }

    public Set<Role> getRoles() {
        return roles;
    }

/*    public void setRoles(List<ClientRole> roles) {
        this.roles = roles;
    }*/

    public void setRoles(Set<Role> roles) {
        this.roles = roles.isEmpty() ? EnumSet.noneOf(Role.class) : EnumSet.copyOf(roles);
    }

    /*public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }*/
}
