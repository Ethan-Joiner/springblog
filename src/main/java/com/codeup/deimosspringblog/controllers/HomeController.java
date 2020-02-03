package com.codeup.deimosspringblog.controllers;


import com.codeup.deimosspringblog.models.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String homePage(Model model){
        if (!SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")) {
            System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            System.out.println(user.getUsername());
            model.addAttribute("user", user);
            return "home";
        } else {
            return "redirect:/login";
        }
    }


}
