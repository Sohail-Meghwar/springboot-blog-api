package blogapp.com.repoitories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import blogapp.com.entities.User;

public interface UserRepo extends JpaRepository<User,Integer> {
    
    Optional<User> findByEmail(String email);
    
    
}
