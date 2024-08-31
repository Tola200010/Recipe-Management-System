package recipes.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import recipes.utils.ValidEmail;

@Data
public class UserRegisterRequestDto {
    @NotBlank
    @ValidEmail
    private String email;
    @NotBlank
    @Size(min = 8)
    private String password;
}
