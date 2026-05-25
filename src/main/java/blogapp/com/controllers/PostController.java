package blogapp.com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import blogapp.com.payloads.PostDto;
import blogapp.com.services.PostService;

@RestController
@RequestMapping("/api/")
public class PostController {
    @Autowired
    private PostService postService;
    // create
    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto,@PathVariable Integer userId,@PathVariable Integer categoryId) {
        PostDto createdPost = postService.createPost(postDto, userId, categoryId);
        return new ResponseEntity<PostDto>(createdPost, org.springframework.http.HttpStatus.CREATED);
    }
    

// get by user
@GetMapping("/user/{userId}/posts")
public ResponseEntity<List<PostDto>> getPostsByUser(@PathVariable Integer userId) {
    List<PostDto> posts = (List<PostDto>) this.getPostsByUser(userId);
    return new ResponseEntity<List<PostDto>>(posts, org.springframework.http.HttpStatus.OK);
}

// get by category
@GetMapping("/category/{categoryId}/posts")
public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable Integer categoryId) {
    List<PostDto> posts = (List<PostDto>) this.getPostsByCategory(categoryId);
    return new ResponseEntity<List<PostDto>>(posts, org.springframework.http.HttpStatus.OK);
}


}
