package blogapp.com.services.Impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import blogapp.com.entities.Comment;
import blogapp.com.entities.Post;
import blogapp.com.exception.ResourceNotFoundException;
import blogapp.com.payloads.CommentDto;
import blogapp.com.repoitories.PostRepo;
import blogapp.com.services.CommentService;
@Service
public class CommentServiceImp implements CommentService {
    @Autowired
    private CrudRepository<Comment, Integer> commentRepo;
    @Autowired
    private PostRepo postRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CommentDto createComment(CommentDto commentDto, Integer postId) {
       Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
         Comment comment = this.modelMapper.map(commentDto, Comment.class);
            comment.setPost(post);
            Comment savedComment = this.commentRepo.save(comment);
            return this.modelMapper.map(savedComment, CommentDto.class);
            


    }

    @Override
    public void deleteComment(Integer commentId) {
         Comment comment = this.commentRepo.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("Comment", "id", commentId));
            this.commentRepo.delete(comment);


    }
}