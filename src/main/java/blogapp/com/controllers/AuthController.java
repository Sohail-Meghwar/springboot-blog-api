package blogapp.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import blogapp.com.payloads.JwtAuthRequest;
import blogapp.com.payloads.JwtAuthResponse;
import blogapp.com.security.JwtTokenHelper;

@RestController 
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private  JwtTokenHelper jwtTokenHelper;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> createToken(@RequestBody JwtAuthRequest request) {

this.authenticate(request.getUsername(), request.getPassword());
UserDetails userDetails=this.userDetailsService.loadUserByUsername(request.getUsername());
String token=this.jwtTokenHelper.generateToken(userDetails);
JwtAuthResponse response=new JwtAuthResponse();
response.setToken(token);
return ResponseEntity.ok(response);

         
    }


    private void authenticate(String username, String password) {

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);

        try{
       this.authenticationManager.authenticate(authenticationToken);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
