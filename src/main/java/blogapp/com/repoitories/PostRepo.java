package blogapp.com.repoitories;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import blogapp.com.entities.Post;
import blogapp.com.entities.User;

public interface PostRepo extends JpaRepository<blogapp.com.entities.Post, Integer> {

    List<Post> findByUser(User user, PageRequest pageable);
    List<Post> findByCategory(blogapp.com.entities.Category cat, PageRequest pageable);
    List<Post> findByTitleContaining(String keyword);
    

} 