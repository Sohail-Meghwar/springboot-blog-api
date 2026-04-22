package blogapp.com.repoitories;

import org.springframework.data.jpa.repository.JpaRepository;

import blogapp.com.entities.User;

public interface UserRepo extends JpaRepository<User,Integer> {
    
    
}
