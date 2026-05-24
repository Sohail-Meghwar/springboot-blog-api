package blogapp.com.services.Impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blogapp.com.entities.Category;
import blogapp.com.entities.Post;
import blogapp.com.entities.User;
import blogapp.com.exception.ResourceNotFoundException;
import blogapp.com.payloads.PostDto;
import blogapp.com.repoitories.CategoryRepo;
import blogapp.com.repoitories.PostRepo;
import blogapp.com.repoitories.UserRepo;
import blogapp.com.services.PostService;
@Service
public class PostServiceImp implements PostService  {
@Autowired
private PostRepo postRepo;
@Autowired
private ModelMapper modelMapper;
@Autowired
private UserRepo userRepo;
@Autowired
private CategoryRepo categoryRepo;

    @Override
    public Post createPost(PostDto postDto,Integer userId, Integer categoryId) {
        User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId));
        Category category=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","id",categoryId));

        Post post=this.modelMapper.map(postDto, Post.class);
        post.setImageName("default.png");
        post.setAddedDate(new java.sql.Date(new java.util.Date().getTime()));
        post.setCategory(category);
        post.setUser(user);
        Post newPost=this.postRepo.save(post);
        return this.modelMapper.map(newPost, Post.class);
        
         

        

    }

    public PostRepo getPostRepo() {
        return postRepo;
    }

    public void setPostRepo(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    @Override
    public Post updatePost(PostDto postDto, Integer postId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatePost'");
    }

    @Override
    public void deletePost(Integer postId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletePost'");
    }

    @Override
    public List<Post> getAllPosts() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllPosts'");
    }

    @Override
    public Post getPostById(Integer postId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPostById'");
    }

    @Override
    public List<Post> getPostsByCategory(Integer categoryId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPostsByCategory'");
    }

    @Override
    public List<Post> getPostsByUser(Integer userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPostsByUser'");
    }

    @Override
    public List<Post> searchPosts(String keyword) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchPosts'");
    }


}

  