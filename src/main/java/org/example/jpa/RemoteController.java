package org.example.jpa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class RemoteController {
    @GetMapping("/newpath")
    public String getCustom(Model model) {
        model.addAttribute("message", "Welcome to my site!");
        return "villagerinfo";
    }
}

