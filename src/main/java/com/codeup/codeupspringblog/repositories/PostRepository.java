package com.codeup.codeupspringblog.repositories;

import com.codeup.codeupspringblog.models.Ad;
import com.codeup.codeupspringblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    Post findPostByTitle(String title);
    Post findPostById(long id);
}
