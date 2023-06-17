package pe.edu.pe.onlinebooks.services;

import jakarta.annotation.Nullable;
import org.springframework.stereotype.Service;
import pe.edu.pe.onlinebooks.models.User;
import pe.edu.pe.onlinebooks.repositories.UserRepository;

import java.util.Optional;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    public AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public @Nullable User login(String username, String password) {
        Optional<User> user = this.userRepository.findByUsername(username);
        if(user.isPresent()) {
            if(user.get().password.equals(password)) {
                return user.get();
            }
        }
        return null;
    }
}
