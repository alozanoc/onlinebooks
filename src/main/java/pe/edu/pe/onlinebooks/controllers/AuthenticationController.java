package pe.edu.pe.onlinebooks.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.pe.onlinebooks.controllers.dto.LoginRequest;
import pe.edu.pe.onlinebooks.controllers.dto.SimpleUserDTO;
import pe.edu.pe.onlinebooks.models.User;
import pe.edu.pe.onlinebooks.services.AuthenticationService;
import pe.edu.pe.onlinebooks.util.EncryptionUtil;
import pe.edu.pe.onlinebooks.util.JwtTokenUtil;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserDetailsService userDetailsService;

    public AuthenticationController(AuthenticationService authenticationService, AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, UserDetailsService userDetailsService) {
        this.authenticationService = authenticationService;
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("login")
    public ResponseEntity<SimpleUserDTO> login(@RequestBody LoginRequest loginRequest) throws Exception {
        User user = authenticationService.login(loginRequest.getUsername(), loginRequest.getPassword());

        authenticate(loginRequest.getUsername(), loginRequest.getPassword());

        final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);


        if (user == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(new SimpleUserDTO(user.username, user.name, EncryptionUtil.encrypt(token)));
        }
    }


    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("INVALID_CREDENTIALS", e);
        }
    }
}
