package guru.spring5webapp.repositories;

import guru.spring5webapp.model.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created by shifengyuan.
 * Date: 2018/6/30
 * Time: 7:17
 */
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

    Optional<UnitOfMeasure> findByDescription(String description);

}
