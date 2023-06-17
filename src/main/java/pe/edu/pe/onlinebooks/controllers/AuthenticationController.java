package pe.edu.pe.onlinebooks.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pe.edu.pe.onlinebooks.controllers.dto.LoginRequest;
import pe.edu.pe.onlinebooks.controllers.dto.SimpleUserDTO;
import pe.edu.pe.onlinebooks.models.Book;
import pe.edu.pe.onlinebooks.models.User;
import pe.edu.pe.onlinebooks.services.AuthenticationService;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("login")
    public ResponseEntity<SimpleUserDTO> login(@RequestBody LoginRequest loginRequest) {
        User user = authenticationService.login(loginRequest.getUsername(), loginRequest.getPassword());
        if (user == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(new SimpleUserDTO(user.username, user.name));
        }
    }
}
