package ua.aser.carshop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.aser.carshop.model.Client;

import java.util.List;

@Repository
public interface ClientReposetories extends CrudRepository<Client, Long> {
    List<Client> findByLogin (String login);
    List<Client> findAllByEnabled (Boolean enabled);

}
