package guru.spring5webapp.repositories;

import guru.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by shifengyuan.
 * Date: 2018/6/21
 * Time: 22:11
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
