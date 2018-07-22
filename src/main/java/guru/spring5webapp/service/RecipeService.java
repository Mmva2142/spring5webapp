package guru.spring5webapp.service;

import guru.spring5webapp.commands.RecipeCommand;
import guru.spring5webapp.model.Recipe;

import java.util.Set;

/**
 * Created by shifengyuan.
 * Date: 2018/6/30
 * Time: 15:19
 */
public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long id);

    RecipeCommand findCommandById(Long id);

    RecipeCommand saveRecipeCommand(RecipeCommand command);

    void deleteById(Long id);
}
