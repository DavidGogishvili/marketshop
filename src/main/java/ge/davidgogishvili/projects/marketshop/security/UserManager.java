package ge.davidgogishvili.projects.marketshop.security;

import ge.davidgogishvili.projects.marketshop.entities.User;
import ge.davidgogishvili.projects.marketshop.repositories.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

@RequiredArgsConstructor
public class UserManager implements UserDetailsService {

    private final UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Optional <User> users =  userRepo.findAllByUsername(username);
       if (users.isEmpty()) {
           throw new RuntimeException("user %s not found".formatted(username));
       }
       return users.get();

    }
}
