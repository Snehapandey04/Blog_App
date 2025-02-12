package com.telusko.BlogApp.repository;

import com.telusko.BlogApp.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment,Integer> {
}
