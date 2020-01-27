package com.codeup.deimosspringblog.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String index(){
        return "This is the index page!";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String viewPost(@PathVariable long id){
        return "This is the page for id = " + id;
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
