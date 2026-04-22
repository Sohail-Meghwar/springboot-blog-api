package blogapp.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import blogapp.com.payloads.UserDto;
import blogapp.com.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    // post create user
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){ 

    UserDto createdUser=this.userService.createUser(userDto);
    return new ResponseEntity<>(createdUser, org.springframework.http.HttpStatus.CREATED);

    }
    
     //put update user
    
    // delete delete user

    //Get get user by id
    
}
