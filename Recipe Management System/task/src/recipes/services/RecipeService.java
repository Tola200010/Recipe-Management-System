package recipes.services;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import recipes.dto.RecipeRequestDto;
import recipes.dto.RecipeResponseDto;
import recipes.exceiption.ActionNotAllowException;
import recipes.exceiption.NotFoundException;
import recipes.models.AppUser;
import recipes.models.Recipe;
import recipes.repositories.RecipeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class RecipeService {
    private final RecipeRepository recipeRepository;
    private final UserService userService;
    public RecipeResponseDto getRecipeById(Long recipeId){
        Recipe recipe = recipeRepository.findById(recipeId).orElseThrow(() -> new NotFoundException("Recipe not found"));
        return new RecipeResponseDto(
                recipe.getName(),
                recipe.getDescription(),
                recipe.getCategory(),
                recipe.getDate(),
                recipe.getIngredients(),
                recipe.getDirections()
        );
    }

    public long createNewRecipe(RecipeRequestDto requestDto){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AppUser user = userService.findByEmail(authentication.getName());
        Recipe recipe = new Recipe();
        recipe.setUser(user);
        recipe.setName(requestDto.getName());
        recipe.setCategory(requestDto.getCategory());
        recipe.setDescription(requestDto.getDescription());
        recipe.setDirections(requestDto.getDirections());
        recipe.setIngredients(requestDto.getIngredients());
        recipeRepository.save(recipe);
        return recipe.getId();
    }

    public void deleteRecipe(Long recipeId){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AppUser user = userService.findByEmail(authentication.getName());
        Recipe recipe = recipeRepository.findById(recipeId).orElseThrow(() -> new NotFoundException("Recipe not found"));
        if(!recipe.getUser().equals(user)){
            throw new ActionNotAllowException();
        }
        recipeRepository.delete(recipe);
    }

    public void updateRecipeById(Long recipeId,RecipeRequestDto requestDto){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AppUser user = userService.findByEmail(authentication.getName());
        Recipe recipe = recipeRepository.findById(recipeId).orElseThrow(() -> new NotFoundException("Recipe not found"));
        if(!recipe.getUser().equals(user)){
            throw new ActionNotAllowException();
        }
        recipe.setName(requestDto.getName());
        recipe.setCategory(requestDto.getCategory());
        recipe.setDescription(requestDto.getDescription());
        recipe.setDirections(requestDto.getDirections());
        recipe.setIngredients(requestDto.getIngredients());
        recipeRepository.save(recipe);
    }

    public List<RecipeResponseDto> getAllRecipeByCategory(String category){
        return recipeRepository.findByCategoryIgnoreCaseOrderByDateDesc(category).stream()
                .map(x -> new RecipeResponseDto(
                        x.getName(),
                        x.getDescription(),
                        x.getCategory(),
                        x.getDate(),
                        x.getIngredients(),
                        x.getDirections()
                )).toList();
    }

    public List<RecipeResponseDto> getAllRecipeByName(String name){
        return recipeRepository.findByNameIgnoreCaseContainsOrderByDateDesc(name).stream()
                .map(x -> new RecipeResponseDto(
                        x.getName(),
                        x.getDescription(),
                        x.getCategory(),
                        x.getDate(),
                        x.getIngredients(),
                        x.getDirections()
                )).toList();
    }
    public List<RecipeResponseDto> getAll(){
        return recipeRepository.findAll(Sort.by("date").descending()).stream()
                .map(x -> new RecipeResponseDto(
                        x.getName(),
                        x.getDescription(),
                        x.getCategory(),
                        x.getDate(),
                        x.getIngredients(),
                        x.getDirections()
                )).toList();
    }
}
