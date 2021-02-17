package ua.aser.carshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import ua.aser.carshop.model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin (String login);
    List<User> findAllByActive (Boolean enabled);

//    UserDetails findByUsername(String username);
}
