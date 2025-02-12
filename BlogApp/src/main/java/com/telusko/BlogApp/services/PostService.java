package com.telusko.BlogApp.services;

import com.telusko.BlogApp.Entity.Post;
import com.telusko.BlogApp.payloads.PostDto;
import com.telusko.BlogApp.payloads.PostResponse;

import java.util.List;

public interface PostService {


// Create Post
    PostDto createPost(PostDto postDto , Integer userId, Integer categoryId);

 // Update Post
    PostDto updatePost(PostDto postDto, Integer postId);

 // Delete Post
 void deletePost(Integer postId);

  // Get All Posts
    PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);

    // Get Single Post
    PostDto getPostById(Integer postId);

    // get all posts by category
    List<PostDto> getPostsByCategory(Integer categoryId);

    // get all posts by user
    List<PostDto> getPostsByUser(Integer userId);

    List<PostDto> searchPosts(String keyword);

}
