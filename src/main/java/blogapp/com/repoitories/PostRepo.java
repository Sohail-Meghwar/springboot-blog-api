package blogapp.com.repoitories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import blogapp.com.entities.Post;
import blogapp.com.entities.User;

public interface PostRepo extends JpaRepository<blogapp.com.entities.Post, Integer> {

    List<Post> findByUser(User user);
    List<Post> findByCategory(blogapp.com.entities.Category cat);
    List<Post> findByTitleContaining(String keyword);
    

} 