package com.codeup.deimosspringblog.controllers;

import com.codeup.deimosspringblog.models.Post;
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
    public String index(Model model){
        ArrayList<Post> posts = new ArrayList<>();
        posts.add(new Post("Post 1", "Post Description 1"));
        posts.add(new Post("Post 2", "Post Description 2"));
        model.addAttribute("posts", posts);
        return "posts/index";

    }

    @GetMapping("/posts/{id}")
    public String viewPost(@PathVariable long id, Model model){
//        Post post =
        model.addAttribute("post", new Post(id, "Post " + id, "Post Body " + id));

        return "posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String createPostForm(){
        return "Here is the create page!";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String submitPost(){
        return "Create a post!";
    }
}
