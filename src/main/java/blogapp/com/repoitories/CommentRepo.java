package blogapp.com.repoitories;

import org.springframework.data.jpa.repository.JpaRepository;

import blogapp.com.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer> {

    
}
