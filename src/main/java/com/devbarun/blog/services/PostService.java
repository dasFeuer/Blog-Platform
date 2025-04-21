package com.devbarun.blog.services;

import com.devbarun.blog.domian.CreatePostRequest;
import com.devbarun.blog.domian.UpdatePostRequest;
import com.devbarun.blog.domian.entities.Post;
import com.devbarun.blog.domian.entities.User;

import java.util.List;
import java.util.UUID;

public interface PostService {
    Post getPostById(UUID id);
    List<Post> getAllPosts(UUID categoryId, UUID tagId);
    List<Post> getDraftPosts(User user);
    Post createPost(User user, CreatePostRequest createPostRequest);
    Post updatePost(UUID id, UpdatePostRequest updatePostRequest);
    void deletePost(UUID id);
}
