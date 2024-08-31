package recipes.controllers;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import recipes.dto.RecipeRequestDto;
import recipes.dto.RecipeResponseDto;
import recipes.models.Recipe;
import recipes.services.RecipeService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/recipe")
public class RecipesController {
    private Recipe recipe = new Recipe();
    private final RecipeService recipeService;

    public RecipesController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public ResponseEntity<Recipe> getRecipes() {
        return new ResponseEntity<>(recipe, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createNewRecipe(@RequestBody Recipe recipe) {
        this.recipe = recipe;
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<?> registerNewRecipe(@RequestBody @Valid RecipeRequestDto requestDto) {
        long idCreated = recipeService.createNewRecipe(requestDto);
        Map<String,Long> response = new HashMap<>();
        response.put("id",idCreated);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecipeResponseDto> getRecipe(@PathVariable Long id) {
        RecipeResponseDto recipe = recipeService.getRecipeById(id);
        return ResponseEntity.ok(recipe);
    }

    @GetMapping("/search/")
    public ResponseEntity<List<RecipeResponseDto>> getByCategoryOrName(
            @RequestParam(value = "category",required = false,defaultValue = "") String category,
            @RequestParam(value = "name",required = false,defaultValue = "") String name
    ) {
        if(!category.isEmpty() && !name.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        if(category.isEmpty() && name.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        List<RecipeResponseDto> categoryDtoList;
        if(!category.isEmpty()){
            categoryDtoList = recipeService.getAllRecipeByCategory(category);
        }else{
            categoryDtoList = recipeService.getAllRecipeByName(name);
        }
        return ResponseEntity.ok(categoryDtoList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RecipeResponseDto> deleteRecipe(@PathVariable Long id) {
        recipeService.deleteRecipe(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecipeResponseDto> updateRecipeById(@PathVariable Long id, @RequestBody @Valid RecipeRequestDto requestDto) {
        recipeService.updateRecipeById(id,requestDto);
        return ResponseEntity.noContent().build();
    }
}
