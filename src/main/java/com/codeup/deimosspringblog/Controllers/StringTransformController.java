package com.codeup.deimosspringblog.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StringTransformController {

    @GetMapping("/string/reverse/{string}")
    @ResponseBody
    public String reverse(@PathVariable String string) {
        String reversed = "";
        for (int i = string.length() - 1; i >= 0; i--) {
            reversed += string.charAt(i);
        }
        return reversed;
    }

    @GetMapping("/string/uppercase/{toUpper}")
    @ResponseBody
    public String upperCase(@PathVariable String toUpper) {

        return toUpper.toUpperCase();
    }
}



