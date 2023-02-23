package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Ad;
import com.codeup.codeupspringblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class PostController {
    @GetMapping("/posts")
    public String showAll(Model model) {
        ArrayList<Post> posts = new ArrayList<>();
        Post post1 = new Post(1, "title1", "body1");
        Post post2 = new Post(2, "title2", "body2");
        posts.add(post1);
        posts.add(post2);
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String showSpecific(@PathVariable long id, Model model) {
        ArrayList<Post> posts = new ArrayList<>();
        Post post1 = new Post(1, "title1", "body1");
        Post post2 = new Post(2, "title2", "body2");
        Post post3 = new Post(3, "title3", "body3");
        posts.add(post1);
        posts.add(post2);
        posts.add(post3);
        model.addAttribute("post", posts);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String createPostForm() {
        return "view the form for creating a post";
    }
}
