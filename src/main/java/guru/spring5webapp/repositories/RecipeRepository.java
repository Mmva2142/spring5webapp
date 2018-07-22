package guru.spring5webapp.repositories;

import guru.spring5webapp.model.Recipe;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by shifengyuan.
 * Date: 2018/6/30
 * Time: 7:13
 */

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
