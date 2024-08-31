package recipes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import recipes.models.Recipe;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe,Long> {
    List<Recipe> findByCategoryIgnoreCaseOrderByDateDesc(String category);
    List<Recipe> findByNameIgnoreCaseContainsOrderByDateDesc(String name);
}
