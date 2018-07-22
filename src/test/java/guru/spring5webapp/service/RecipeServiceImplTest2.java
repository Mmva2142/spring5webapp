package guru.spring5webapp.service;

import com.google.gson.Gson;
import guru.spring5webapp.model.Recipe;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * Created by shifengyuan.
 * Date: 2018/7/1
 * Time: 11:31
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class RecipeServiceImplTest2 {

    @Autowired
    RecipeService recipeService;

    Gson gson;

    @Before
    public void initSth(){
        gson = new Gson();
    }

    @Test
    public void serviceTest(){
        Set<Recipe> recipeSet = recipeService.getRecipes();
        recipeSet.forEach(recipe -> System.out.println(recipe.getDescription()));
    }
}
