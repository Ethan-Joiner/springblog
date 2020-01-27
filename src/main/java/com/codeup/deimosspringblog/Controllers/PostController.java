package com.codeup.deimosspringblog.Controllers;

import com.codeup.deimosspringblog.Models.Post;
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
        Post post = new Post("Post 1", "Post Body 1");
        model.addAttribute("post", post);

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
