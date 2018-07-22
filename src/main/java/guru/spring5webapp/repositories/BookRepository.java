package guru.spring5webapp.repositories;

import guru.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by shifengyuan.
 * Date: 2018/6/21
 * Time: 21:24
 */
public interface BookRepository extends CrudRepository<Book, Long> {
}
