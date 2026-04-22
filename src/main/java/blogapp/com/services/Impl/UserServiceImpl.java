package blogapp.com.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blogapp.com.entities.User;
import blogapp.com.payloads.UserDto;
import blogapp.com.repoitories.UserRepo;
import blogapp.com.services.UserService;
import blogapp.com.exception.*;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    UserDto userDto;


    @Override
    public UserDto createUser(UserDto userDto) {
       User user=this.dtoToUser(userDto);
        
        User savedUser= this.userRepo.save(user);
        return this.userToDto(savedUser);

    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        
       User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());
        User updatedUser= this.userRepo.save(user);
        UserDto userDto1 = this.userToDto(updatedUser);
        
          



       return userDto1;
    }

    @Override
    public UserDto getUserById(Integer userId) {
         
User user = this.userRepo.findById(userId)
.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

return this.userToDto(user);

    }

    @Override
    public List<UserDto> getAllUsers() {
         
List<User> users=this.userRepo.findAll();
List<UserDto> userDtos= users.stream().map(user -> this.userToDto(user)).toList();
return userDtos;
    }
    @Override
    public void deleteUser(Integer userId) {
     User user=this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));
     this.userRepo.delete(user);


    }
    public User dtoToUser(UserDto userDto){
        
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());
        return user;

    }
        
public UserDto userToDto(User user){
    UserDto userDto = new UserDto();
    userDto.setId(user.getId());
    userDto.setName(user.getName());
    userDto.setEmail(user.getEmail());
    userDto.setPassword(user.getPassword());
    userDto.setAbout(user.getAbout());
    return userDto;


    

}  
}
