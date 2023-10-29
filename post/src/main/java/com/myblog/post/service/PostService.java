package com.myblog.post.service;

import com.myblog.post.config.RestTemplateConfig;
import com.myblog.post.entity.Post;
import com.myblog.post.payload.PostDto;
import com.myblog.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Service
public interface PostService {


    Post getPostById(String postId);

    PostDto getAllCommentsForParticularPost(String postId);

    PostDto createPost(PostDto postdto);
}
