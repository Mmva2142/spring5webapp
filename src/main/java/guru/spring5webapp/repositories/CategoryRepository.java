package guru.spring5webapp.repositories;

import guru.spring5webapp.model.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created by shifengyuan.
 * Date: 2018/6/30
 * Time: 7:14
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findByDescription(String description);
}
