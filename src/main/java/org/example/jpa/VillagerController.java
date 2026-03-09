package org.example.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/villagers")
public class VillagerController {

    @Autowired
    private VillagerRepository villagerRepository;

    @Autowired
    private IslandRepository islandRepository;

    @Autowired
    private HobbyRepository hobbyRepository;

    @GetMapping
    public String listVillagers(Model model) {
        model.addAttribute("villagers", villagerRepository.findAll());
        return "villagers";
    }

    @GetMapping("/{id}")
    public String getVillager(@PathVariable Long id, Model model) {
        model.addAttribute("villager", villagerRepository.findById(id).orElse(null));
        return "villagerinfo";
    }

    @GetMapping("/new")
    public String newVillagerForm(Model model) {
        model.addAttribute("villager", new Villager());
        model.addAttribute("islands", islandRepository.findAll());
        model.addAttribute("hobbies", hobbyRepository.findAll());
        return "newvillager";
    }

    @GetMapping("/{id}/edit")
    public String editVillagerForm(@PathVariable Long id, Model model) {
        model.addAttribute("villager", villagerRepository.findById(id).orElse(null));
        model.addAttribute("islands", islandRepository.findAll());
        model.addAttribute("hobbies", hobbyRepository.findAll());
        return "newvillager";
    }

    @PostMapping
    public String createVillager(@ModelAttribute Villager villager) {
        villagerRepository.save(villager);
        return "redirect:/villagers";
    }

    @PostMapping("/{id}/edit")
    public String updateVillager(@PathVariable Long id, @ModelAttribute Villager villager) {
        villager.setId(id);
        villagerRepository.save(villager);
        return "redirect:/villagers";
    }

    @PostMapping("/{id}/delete")
    public String deleteVillager(@PathVariable Long id) {
        villagerRepository.deleteById(id);
        return "redirect:/villagers";
    }
}