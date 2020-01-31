package com.codeup.deimosspringblog.controllers;

import com.codeup.deimosspringblog.models.Post;
import com.codeup.deimosspringblog.models.Posts;
import com.codeup.deimosspringblog.models.User;
import com.codeup.deimosspringblog.models.Users;
import com.codeup.deimosspringblog.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PostController {

    private final Posts postDao;
    private final Users userDao;
    private final EmailService emailService;



    public PostController(Posts postDao, Users userDao, EmailService emailService) {
        this.userDao = userDao;
        this.postDao = postDao;
        this.emailService = emailService;
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
    public String createPostForm(Model model){
        model.addAttribute("post", new Post());
        return "/posts/create";
    }

    @PostMapping("/posts/create")
    public String submitPost(@ModelAttribute Post post){
        long random = (long) ((Math.random() * 3) + 1);
        User user = userDao.findById(random);
        post.setUser(user);
        postDao.save(post);
        emailService.prepareAndSend(post, "Subject", "Bawdeh");

        return "redirect:/posts";
    }

    @GetMapping("/posts/edit")
    public String showEditView(@RequestParam long id, Model model){
        model.addAttribute("post", postDao.findById(id));
        return "posts/edit";

    }

    @PostMapping("/posts/edit")
    public String editPost(@ModelAttribute Post post){
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
