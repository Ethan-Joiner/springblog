package com.codeup.deimosspringblog.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DeimosController {

    @GetMapping("/deimos/{date}")
    @ResponseBody
    public String date(@PathVariable String date) {
        return date + " days";
    }
}
