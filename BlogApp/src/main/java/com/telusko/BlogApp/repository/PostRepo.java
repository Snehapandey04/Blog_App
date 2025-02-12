package com.telusko.BlogApp.repository;

import com.telusko.BlogApp.Entity.Category;
import com.telusko.BlogApp.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.telusko.BlogApp.Entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostRepo extends JpaRepository<Post,Integer> {

    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);
   @Query("select p from Post p where p.title like :key")
    List<Post> findByTitleContaining(@Param("key" ) String title);



}
