package com.codeup.deimosspringblog.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/string/both/{string}")
    @ResponseBody
    public String both(@PathVariable String string){
        return upperCase(reverse(string));
    }

    @GetMapping("/string/{word}")
    @ResponseBody
    public String either (@PathVariable String word,
                          @RequestParam(value="reverse", required=false) boolean reverse,
                          @RequestParam(value="caps", required=false) boolean caps){
        if (reverse && caps) {
            return both(word);
        } else if (reverse) {
            return reverse(word);
        } else if (caps) {
            return upperCase(word);
        } else {
            return word;
        }
    }
}



