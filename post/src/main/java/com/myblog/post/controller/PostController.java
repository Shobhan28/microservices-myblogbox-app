package com.myblog.post.controller;


import com.myblog.post.entity.Post;
import com.myblog.post.payload.PostDto;
import com.myblog.post.repository.PostRepository;
import com.myblog.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private PostRepository postRepository;

//  http://localhost:8081/api/post/create
    @PostMapping("/create")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postdto) {

        PostDto savedPost = postService.createPost(postdto);
        return new ResponseEntity<>(savedPost, HttpStatus.CREATED);

    }

    //    http://localhost:8081/api/post/getpost/{id}
    @GetMapping("/getpost/{postId}")
    public PostDto getPostById(@PathVariable String postId) {
        PostDto postdto = postService.getPostById(postId);
        return postdto;
    }


    //  Get your comments along with the post
    //   http://localhost:8081/api/post/getpost/{id}/comments
    @GetMapping("/getpost/{postId}/comments")
    public ResponseEntity<PostDto> getAllCommentsForParticularPost(@PathVariable String postId) {

        PostDto postDto = postService.getAllCommentsForParticularPost(postId);

        return new ResponseEntity<>(postDto, HttpStatus.OK);
    }

    // Update an existing post by ID
    // http://localhost:8081/api/post/update/{postId}
    @PutMapping("/update/{postId}")
    public ResponseEntity<PostDto> updatePost(@PathVariable String postId, @RequestBody PostDto updatedPostDto) {
        PostDto updatedPost = postService.updatePost(postId, updatedPostDto);
            return new ResponseEntity<>(updatedPost, HttpStatus.OK);

    }

    // Delete a post by ID
    // http://localhost:8081/api/post/delete/{postId}
    @DeleteMapping("/delete/{postId}")
    public ResponseEntity<String> deletePostById(@PathVariable String postId) {
        boolean deleted = postService.deletePostById(postId);
        return new ResponseEntity<>("Post is Deleted :" +postId,  HttpStatus.OK);
    }
}

