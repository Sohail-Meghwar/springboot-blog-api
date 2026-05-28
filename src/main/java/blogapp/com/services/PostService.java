package blogapp.com.services;

import blogapp.com.entities.Post;
import blogapp.com.payloads.PostDto;

public interface PostService {
    // create
    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    // update
    PostDto updatePost(PostDto postDto, Integer postId);

    // delete
    void deletePost(Integer postId);

    // get all posts
    java.util.List<Post> getAllPosts();

    // get single post
    Post getPostById(Integer postId);

    // get all posts by category
    java.util.List<PostDto> getPostsByCategory(Integer categoryId);

    // get all posts by user
    java.util.List<PostDto> getPostsByUser(Integer userId);

    // search posts

    java.util.List<Post> searchPosts(String keyword);



    
}
