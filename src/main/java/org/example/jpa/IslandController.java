package org.example.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/islands")
public class IslandController {

    @Autowired
    private IslandRepository islandRepository;

    @GetMapping
    public String listIslands(Model model) {
        model.addAttribute("islands", islandRepository.findAll());
        return "islands";
    }

    @GetMapping("/{id}")
    public String getIsland(@PathVariable Long id, Model model) {
        model.addAttribute("island", islandRepository.findById(id).orElse(null));
        return "islandinfo";
    }

    @GetMapping("/new")
    public String newIslandForm(Model model) {
        model.addAttribute("island", new Island());
        return "newisland";
    }

    @GetMapping("/{id}/edit")
    public String editIslandForm(@PathVariable Long id, Model model) {
        model.addAttribute("island", islandRepository.findById(id).orElse(null));
        return "newisland";
    }

    @PostMapping
    public String createIsland(@ModelAttribute Island island) {
        islandRepository.save(island);
        return "redirect:/islands";
    }

    @PostMapping("/{id}/edit")
    public String updateIsland(@PathVariable Long id, @ModelAttribute Island island) {
        island.setId(id);
        islandRepository.save(island);
        return "redirect:/islands";
    }

    @PostMapping("/{id}/delete")
    public String deleteIsland(@PathVariable Long id) {
        islandRepository.deleteById(id);
        return "redirect:/islands";
    }
}