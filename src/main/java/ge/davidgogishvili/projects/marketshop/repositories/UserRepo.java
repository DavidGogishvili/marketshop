package ge.davidgogishvili.projects.marketshop.repositories;

import ge.davidgogishvili.projects.marketshop.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepo extends JpaRepository <User, Integer> {


    Optional <User> findAllByUsername(String username);
}
