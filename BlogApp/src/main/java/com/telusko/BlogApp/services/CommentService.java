package com.telusko.BlogApp.services;

import com.telusko.BlogApp.payloads.CommentDto;

public interface CommentService {

     CommentDto createComment(CommentDto commentDto,Integer postId);

     void deleteComment(Integer commentId);

}
