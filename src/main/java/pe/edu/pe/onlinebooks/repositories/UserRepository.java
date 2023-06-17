package pe.edu.pe.onlinebooks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.pe.onlinebooks.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    public Optional<User> findByUsername(String username);

}
