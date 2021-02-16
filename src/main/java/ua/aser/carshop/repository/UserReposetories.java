package ua.aser.carshop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.aser.carshop.model.User;

import java.util.List;

@Repository
public interface UserReposetories extends CrudRepository<User, Long> {
    List<User> findByLogin (String login);
    List<User> findAllByEnabled (Boolean enabled);

}
