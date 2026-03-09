package org.example.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hobbies")
public class HobbyController {

    @Autowired
    private HobbyRepository hobbyRepository;

    @GetMapping
    public String listHobbies(Model model) {
        model.addAttribute("hobbies", hobbyRepository.findAll());
        return "hobbies";
    }

    @GetMapping("/{id}")
    public String getHobby(@PathVariable Long id, Model model) {
        model.addAttribute("hobby", hobbyRepository.findById(id).orElse(null));
        return "hobbyinfo";
    }

    @GetMapping("/new")
    public String newHobbyForm(Model model) {
        model.addAttribute("hobby", new Hobby());
        return "newhobby";
    }

    @GetMapping("/{id}/edit")
    public String editHobbyForm(@PathVariable Long id, Model model) {
        model.addAttribute("hobby", hobbyRepository.findById(id).orElse(null));
        return "newhobby";
    }

    @PostMapping
    public String createHobby(@ModelAttribute Hobby hobby) {
        hobbyRepository.save(hobby);
        return "redirect:/hobbies";
    }

    @PostMapping("/{id}/edit")
    public String updateHobby(@PathVariable Long id, @ModelAttribute Hobby hobby) {
        hobby.setId(id);
        hobbyRepository.save(hobby);
        return "redirect:/hobbies";
    }

    @PostMapping("/{id}/delete")
    public String deleteHobby(@PathVariable Long id) {
        hobbyRepository.deleteById(id);
        return "redirect:/hobbies";
    }
}