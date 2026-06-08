package blogapp.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import blogapp.com.payloads.JwtAuthRequest;
import blogapp.com.payloads.JwtAuthResponse;
import blogapp.com.payloads.UserDto;
import blogapp.com.security.JwtTokenHelper;
import blogapp.com.services.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private JwtTokenHelper jwtTokenHelper;

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> createToken(
            @RequestBody JwtAuthRequest request) {

        // Authenticate user
        authenticate(request.getUsername(), request.getPassword());

        // Load user details
        UserDetails userDetails =
                userDetailsService.loadUserByUsername(request.getUsername());

        // Generate JWT token
        String token = jwtTokenHelper.generateToken(userDetails);

        // Prepare response
        JwtAuthResponse response = new JwtAuthResponse();
        response.setToken(token);

        return ResponseEntity.ok(response);
    }

    private void authenticate(String username, String password) {

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(username, password);

        try {
            authenticationManager.authenticate(authenticationToken);
        } catch (BadCredentialsException ex) {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED,
                    "Invalid username or password"
            );
        }
    }

    // register new user (optional)
    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto) {
        // Implement user registration logic here
        UserDto createdUser = this.userService.registerNewUser(userDto);
        // For example, save the user to the database and return the created user details
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }
} 