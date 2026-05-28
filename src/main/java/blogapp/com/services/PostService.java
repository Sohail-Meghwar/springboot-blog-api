package blogapp.com.services;

import blogapp.com.payloads.PostDto;

public interface PostService {
    // create
    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    // update
    PostDto updatePost(PostDto postDto, Integer postId);

    // delete
    void deletePost(Integer postId);

    // get all posts
    java.util.List<PostDto> getAllPosts(Integer pageNumber, Integer pageSize);

    // get single post
    PostDto getPostById(Integer postId);


    // get all posts by category
    java.util.List<PostDto> getPostsByCategory(Integer categoryId);

    // get all posts by user
    java.util.List<PostDto> getPostsByUser(Integer userId);

    // search posts

    java.util.List<PostDto> searchPosts(String keyword);



    
}
