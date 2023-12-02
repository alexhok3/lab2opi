package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AutoController {
    private final AutoService autoService;

    @Autowired
    public AutoController(AutoService autoService) {
        this.autoService = autoService;
    }

    @GetMapping("/auto")
    public String viewAuto(Model model) {
        // Fetch a list of autos from the service (if needed)
        Iterable<Auto> autos = autoService.listAll();

        // Create a new Auto object (or fetch it from your service)
        Auto auto = new Auto();

        model.addAttribute("autos", autos);
        model.addAttribute("auto", auto);

        return "auto";
    }

    @PostMapping("/save")
    public String saveAuto(@ModelAttribute Auto auto) {
        // Проверка на наличие ID - если ID есть, это обновление существующего элемента
        if (auto.getId() != null && autoService.exists(auto.getId())) {
            // Обновление существующего расписания
            autoService.update(auto);
        } else {
            // Сохранение нового расписания
            autoService.save(auto);
        }
        return "redirect:/auto";
    }

    @GetMapping("/delete/{id}")
    public String deleteAuto(@PathVariable Long id) {
        autoService.delete(id);
        return "redirect:/auto";
    }

    @GetMapping("/edit/{id}")
    public String editAuto(@PathVariable Long id, Model model) {
        Auto auto = autoService.get(id);
        model.addAttribute("auto", auto);
        return "auto";
    }
}
