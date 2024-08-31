package recipes.services;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import recipes.models.AppUser;
import recipes.repositories.UserRepository;

@Service
@AllArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        username = username.toLowerCase();
        AppUser user = userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Not found"));
        return new UserAdapter(user);
    }
}
