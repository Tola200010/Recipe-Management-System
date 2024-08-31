package recipes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import recipes.models.AppUser;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUser,Integer> {
    Optional<AppUser> findByEmail(String email);
}
