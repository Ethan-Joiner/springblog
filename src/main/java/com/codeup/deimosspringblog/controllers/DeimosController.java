package com.codeup.deimosspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DeimosController {

    @GetMapping("/deimos/{days}")

    public String date(@PathVariable int days, Model model) {
        model.addAttribute("days", days);
        return "days";
    }
}
