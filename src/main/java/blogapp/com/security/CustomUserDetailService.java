package blogapp.com.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import blogapp.com.entities.User;
import blogapp.com.exception.ResourceNotFoundException;
import blogapp.com.repoitories.UserRepo;
@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // loading user from database by username and then return user details
        User user = this.userRepo.findByEmail(username)
        .orElseThrow(()->new ResourceNotFoundException("User", "email: "+username, 0));

            return user;
    }
    
}
