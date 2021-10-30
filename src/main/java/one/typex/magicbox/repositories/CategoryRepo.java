package one.typex.magicbox.repositories;

import one.typex.magicbox.entities.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Long> {
    List<Category> findAll();

    Optional<Category> findByName(String name);
}
