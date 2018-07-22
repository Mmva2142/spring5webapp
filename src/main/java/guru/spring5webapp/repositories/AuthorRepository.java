package guru.spring5webapp.repositories;

import guru.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by shifengyuan.
 * Date: 2018/6/21
 * Time: 21:08
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
