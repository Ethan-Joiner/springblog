package com.codeup.deimosspringblog.controllers;

import com.codeup.deimosspringblog.models.Post;
import com.codeup.deimosspringblog.models.Posts;
import com.codeup.deimosspringblog.models.Tag;
import com.codeup.deimosspringblog.models.Tags;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private final Posts postDao;
    private final Tags tagDao;


    public PostController(Posts postDao, Tags tagDao) {
        this.tagDao = tagDao;
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String index(Model model){

        model.addAttribute("posts", postDao.findAll());

        return "posts/index";

    }

    @GetMapping("/posts/{id}")
    public String viewPost(@PathVariable long id, Model model){
        model.addAttribute("post", new Post(id, "Post " + id, "Post Body " + id));

        return "posts/show";
    }

    @GetMapping("/tags")
    public String showTagTest(Model model){

//        List<Post> posts = postDao.findAll();
//        List<Post> funny = new ArrayList<>();
//
//        for (Post post: posts ) {
//                for (int i = 0; i < post.getTags().size() - 1; i++){
//                if (post.getTags().get(i).getName().equals("funny")){
//                    funny.add(post);
//            }
//                }
//            }
//        model.addAttribute("posts", funny);
//        return "posts/tag";
        List<Tag> tags = tagDao.findAll();
        Tag funny = new Tag();

        for (Tag tag: tags){
            if (tag.getName().equals("funny")){
                funny = tag;
                break;
            }
        }
//        Tag funny = tagDao.findById(2L);
        model.addAttribute("tag", funny);
        return "posts/tag";
        }



    @GetMapping("/posts/{id}/details")
    public String viewDetails(@PathVariable long id, Model model){
        model.addAttribute("post", postDao.findById(id));
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

    @GetMapping("/cats")
    public String cats(Model model){
        model.addAttribute("post", postDao.findById(1L));
        return "posts/cat";
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
