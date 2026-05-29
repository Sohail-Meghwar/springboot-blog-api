package blogapp.com.services;

import blogapp.com.payloads.PostDto;
import blogapp.com.payloads.PostResponse;

public interface PostService {
    // create
    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    // update
    PostDto updatePost(PostDto postDto, Integer postId);

    // delete
    void deletePost(Integer postId);

    // get all posts
    PostResponse getAllPosts(Integer pageNumber, Integer pageSize);

    // get single post
    PostDto getPostById(Integer postId);

    // get all posts by category
    PostResponse getPostsByCategory(Integer categoryId, Integer pageNumber, Integer pageSize);

    // get all posts by user
    PostResponse getPostsByUser(Integer userId, Integer pageNumber, Integer pageSize);

    // search posts

    java.util.List<PostDto> searchPosts(String keyword);

}
