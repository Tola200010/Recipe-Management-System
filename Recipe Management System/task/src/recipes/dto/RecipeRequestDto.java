package recipes.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class RecipeRequestDto {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotEmpty
    @Size(min = 1)
    private List<String> ingredients;
    @NotEmpty
    @Size(min = 1)
    private List<String> directions;
    @NotBlank
    private String category;
}
