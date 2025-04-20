package com.devbarun.blog.controllers;

import com.devbarun.blog.domian.CreatePostRequest;
import com.devbarun.blog.domian.dtos.CreatePostRequestDto;
import com.devbarun.blog.domian.dtos.PostDto;
import com.devbarun.blog.domian.entities.Post;
import com.devbarun.blog.domian.entities.User;
import com.devbarun.blog.mappers.PostMapper;
import com.devbarun.blog.services.PostService;
import com.devbarun.blog.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    private final PostMapper postMapper;

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<PostDto>> getAllPosts(
            @RequestParam(required = false) UUID categoryId,
            @RequestParam(required = false) UUID tagId) {

        List<Post> posts = postService.getAllPosts(categoryId, tagId);
        List<PostDto> postDtos = posts.stream().map(postMapper::toDto).toList();
        return ResponseEntity.ok(postDtos);
    }


    @GetMapping(path = "/drafts")
    public ResponseEntity<List<PostDto>> getDrafts(@RequestAttribute UUID userId) {
        User loggnedInUser = userService.getUserById(userId);
        List<Post> draftPosts = postService.getDraftPosts(loggnedInUser);
        List<PostDto> postDtos = draftPosts.stream().map(postMapper::toDto).toList();
        return ResponseEntity.ok(postDtos);
    }

    @PostMapping
    public ResponseEntity<PostDto> createPost(
            @RequestBody CreatePostRequestDto createPostRequestDto,
            @RequestAttribute UUID userId) {
        User loggnedInUser = userService.getUserById(userId);
        CreatePostRequest createPostRequest = postMapper.toCreatePostRequest(createPostRequestDto);
        Post createdPost = postService.createPost(loggnedInUser, createPostRequest);
        PostDto createdPostDto = postMapper.toDto(createdPost);
        return new ResponseEntity<>(createdPostDto, HttpStatus.CREATED);
    }



}
