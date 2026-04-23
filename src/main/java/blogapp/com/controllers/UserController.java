package blogapp.com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import blogapp.com.payloads.ApiResponse;
import blogapp.com.payloads.UserDto;
import blogapp.com.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;


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
    
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable Integer userId){

this.userService.updateUser(userDto, userId);
return ResponseEntity.ok(userDto);

}

    // delete delete user
@DeleteMapping("/{userId}")    
public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId){

  this.userService.deleteUser(userId);
   return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted successfully", true), org.springframework.http.HttpStatus.OK);

}
    //Get get user by id
        @GetMapping("/{userId}")
        public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId){
        return ResponseEntity.ok(this.userService.getUserById(userId));

     }

  // get get all users
  @GetMapping("/")
  public ResponseEntity<List<UserDto>> getAllUsers(){
    return ResponseEntity.ok(this.userService.getAllUsers());
  }


}
