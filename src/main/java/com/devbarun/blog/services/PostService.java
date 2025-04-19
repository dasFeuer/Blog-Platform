package com.devbarun.blog.services;

import com.devbarun.blog.domian.entities.Post;
import com.devbarun.blog.domian.entities.User;

import java.util.List;
import java.util.UUID;

public interface PostService {
    List<Post> getAllPosts(UUID categoryId, UUID tagId);
    List<Post> getDraftPosts(User user);
}
