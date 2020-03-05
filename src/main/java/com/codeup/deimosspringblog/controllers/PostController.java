package com.codeup.deimosspringblog.controllers;

import com.codeup.deimosspringblog.models.Post;
import com.codeup.deimosspringblog.models.UserWithRoles;
import com.codeup.deimosspringblog.repositories.Posts;
import com.codeup.deimosspringblog.models.User;
import com.codeup.deimosspringblog.repositories.Users;
import com.codeup.deimosspringblog.services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final Posts postDao;
    private final Users userDao;
    private final EmailService emailService;
//    UserWithRoles user = new UserWithRoles((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());



    public PostController(Posts postDao, Users userDao, EmailService emailService) {
        this.userDao = userDao;
        this.postDao = postDao;
        this.emailService = emailService;
    }

    @GetMapping("/home")
    public String homePage(Model model){
        if (!SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")) {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            user = userDao.findById(user.getId());
            model.addAttribute("user", user);

            return "home";
        } else {
            return "home";
        }
    }

    @GetMapping("/posts")
    public String index(Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
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
    public String submitPost(@ModelAttribute Post post, Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(user);
        post.setUser(user);
        postDao.save(post);
//        user.setPosts(post);
//        emailService.prepareAndSend(post, "Subject", "Body");

        return "redirect:/home";
    }

    @GetMapping("/posts/edit")
    public String showEditView(@RequestParam long id, Model model){
        model.addAttribute("post", postDao.findById(id));
        return "posts/edit";

    }

    @PostMapping("/posts/edit")
    public String editPost(@ModelAttribute Post post){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(user);
        postDao.save(post);
        return "redirect:/home";
    }

    @GetMapping("/posts/delete")
    public String showDeleteView(@RequestParam long id, Model model){
        model.addAttribute("post", postDao.findById(id));
        return "posts/delete";
    }

    @PostMapping("/posts/delete")
    public String deletePost(@RequestParam long id){
        postDao.delete(postDao.findById(id));
        return "redirect:/home";
    };



}
