package com.myblog.post.service;


import com.myblog.post.entity.Post;
import com.myblog.post.payload.PostDto;
import org.springframework.stereotype.Service;

@Service
public interface PostService {


    Post getPostById(String postId);

    PostDto getAllCommentsForParticularPost(String postId);

    PostDto createPost(PostDto postdto);
}
