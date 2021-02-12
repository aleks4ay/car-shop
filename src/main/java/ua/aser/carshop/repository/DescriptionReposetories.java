package ua.aser.carshop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.aser.carshop.model.Description;

@Repository
public interface DescriptionReposetories extends CrudRepository<Description, Long> {
}
