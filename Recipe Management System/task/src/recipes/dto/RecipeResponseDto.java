package recipes.dto;

import java.time.LocalDateTime;
import java.util.List;

public record RecipeResponseDto (
         String name,
         String description,
         String category,
         LocalDateTime date,
         List<String> ingredients,
         List<String> directions
){}
