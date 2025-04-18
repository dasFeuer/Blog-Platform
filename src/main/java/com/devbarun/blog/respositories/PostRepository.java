package com.devbarun.blog.respositories;

import com.devbarun.blog.domian.PostStatus;
import com.devbarun.blog.domian.entities.Category;
import com.devbarun.blog.domian.entities.Post;
import com.devbarun.blog.domian.entities.Tag;
import com.devbarun.blog.domian.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PostRepository extends JpaRepository<Post, UUID> {
    List<Post> findAllByStatusAndCategoryAndTagsContaining(PostStatus status, Category category, Tag tag);
    List<Post> findAllByStatusAndCategory(PostStatus status, Category category);
    List<Post> findAllByStatusAndTagsContaining(PostStatus status, Tag tag);
    List<Post> findAllByStatus(PostStatus status);
    List<Post> findAllByAuthorAndStatus(User author, PostStatus status);

}
