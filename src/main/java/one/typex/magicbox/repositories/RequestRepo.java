package one.typex.magicbox.repositories;

import one.typex.magicbox.entities.Request;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RequestRepo extends CrudRepository<Request, Long> {

    Optional<Request> findById(long id);

    List<Request> findAll();

    List<Request> findByCategoryId(long categoryId);
}
