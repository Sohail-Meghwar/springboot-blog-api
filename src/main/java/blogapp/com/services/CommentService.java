package blogapp.com.services;

import blogapp.com.payloads.CommentDto;

public interface CommentService {

    public CommentDto createComment(CommentDto commentDto, Integer postId);
    void deleteComment(Integer commentId);
    
    
}
