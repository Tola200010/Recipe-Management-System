package recipes.services;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import recipes.dto.UserRegisterRequestDto;
import recipes.exceiption.BadRequestException;
import recipes.exceiption.NotFoundException;
import recipes.models.AppUser;
import recipes.repositories.UserRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void register(UserRegisterRequestDto requestDto) {
        requestDto.setEmail(requestDto.getEmail().toLowerCase());
        Optional<AppUser> checkExistUser = userRepository.findByEmail(requestDto.getEmail());
        if (checkExistUser.isPresent()) {
            throw new BadRequestException("Email already exists.");
        }
        String passwordEncoded = passwordEncoder.encode(requestDto.getPassword());
        AppUser appUser = new AppUser();
        appUser.setEmail(requestDto.getEmail());
        appUser.setPassword(passwordEncoded);
        userRepository.save(appUser);
    }

    public AppUser findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new NotFoundException("User not found."));
    }
}
