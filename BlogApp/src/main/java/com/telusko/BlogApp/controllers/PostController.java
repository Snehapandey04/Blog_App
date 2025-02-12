package com.telusko.BlogApp.controllers;


import com.telusko.BlogApp.config.AppConstant;
import com.telusko.BlogApp.payloads.ApiResponse;
import com.telusko.BlogApp.payloads.PostDto;
import com.telusko.BlogApp.payloads.PostResponse;
import com.telusko.BlogApp.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class PostController {
    @Autowired
    private PostService postService;


    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto ,@PathVariable Integer userId, @PathVariable Integer categoryId){
         PostDto createPost = this.postService.createPost(postDto,userId,categoryId);
        return new ResponseEntity<PostDto>(createPost, HttpStatus.CREATED);

    }

    // Get by user
    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDto>> getPostsByUser(@PathVariable Integer userId){
       List<PostDto> posts =  this.postService.getPostsByUser(userId);
       return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);

    }

    // Get by category
    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable Integer categoryId){
        List<PostDto> posts =  this.postService.getPostsByCategory(categoryId);
        return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);

    }


    // for update a post
   @PutMapping("/posts/{postId}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto , @PathVariable Integer postId) {
        PostDto updatePost = this.postService.updatePost(postDto,postId);
        return  new ResponseEntity<PostDto>(updatePost,HttpStatus.OK);
    }

  // for delete a post
    @DeleteMapping("/posts/{postId}")
    public ApiResponse deletePost(@PathVariable Integer postId){
        this.postService.deletePost(postId);
        return new   ApiResponse("Post deleted Successfully" , true);

    }

// Get all Posts
    @GetMapping("/posts")
    public ResponseEntity<PostResponse> getAllPost(@RequestParam(value="pageNumber",defaultValue = AppConstant.PAGE_NUMBER,required = false) Integer pageNumber,
                                                   @RequestParam(value="pageSize",defaultValue = AppConstant.PAGE_SIZE,required = false) Integer pageSize,
                                                   @RequestParam(value="sortBy", defaultValue= AppConstant.SORT_BY,required = false) String sortBy,
                                                   @RequestParam(value="sortDir", defaultValue= AppConstant.SORT_DIR,required = false) String sortDir){
       PostResponse postResponse =  this.postService.getAllPost(pageNumber,pageSize,sortBy,sortDir);
        return new ResponseEntity<PostResponse>(postResponse,HttpStatus.OK);

    }
 // Get Single Post
    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId){

         PostDto postDto=this.postService.getPostById(postId);
         return new ResponseEntity<PostDto>(postDto,HttpStatus.OK);

    }

    // for search
    @GetMapping("/posts/search/{keywords}")
    public ResponseEntity<List<PostDto>> searchPostByTitle(@PathVariable("keywords") String keywords){
      List<PostDto> result =   this.postService.searchPosts(keywords);
      return new ResponseEntity<List<PostDto>>(result,HttpStatus.OK);
    }

}
