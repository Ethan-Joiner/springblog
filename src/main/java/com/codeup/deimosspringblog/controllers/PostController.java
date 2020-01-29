package com.codeup.deimosspringblog.controllers;

import com.codeup.deimosspringblog.models.Post;
import com.codeup.deimosspringblog.models.Posts;
import com.codeup.deimosspringblog.models.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PostController {

    private final Posts postDao;
    private final Users userDao;



    public PostController(Posts postDao, Users userDao) {
        this.userDao = userDao;
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String index(Model model){

        model.addAttribute("posts", postDao.findAll());

        return "posts/index";

    }

    @GetMapping("/posts/{id}")
    public String viewPost(@PathVariable long id, Model model){

        String username = postDao.findById(id).getUser().getUsername();
        model.addAttribute("post", postDao.findById(id));
        System.out.println(username);
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

    @GetMapping("/posts/edit")
    public String showEditView(@RequestParam long id, Model model){
        model.addAttribute("post", postDao.findById(id));
        return "posts/edit";

    }

    @PostMapping("/posts/edit")
    public String editPost(@RequestParam long id, @RequestParam String title, @RequestParam String body){
        Post post = new Post(id, title, body);
        postDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/delete")
    public String showDeleteView(@RequestParam long id, Model model){
        model.addAttribute("post", postDao.findById(id));
        return "posts/delete";
    }

    @PostMapping("/posts/delete")
    public String deletePost(@RequestParam long id){
        postDao.delete(postDao.findById(id));
        return "redirect:/posts";
    };



}
