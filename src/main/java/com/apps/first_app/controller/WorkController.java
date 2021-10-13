package com.apps.first_app.controller;

import com.apps.first_app.model.Work;
import com.apps.first_app.service.inter.WorkService;
import javassist.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/jobs")
public class WorkController {

    private final WorkService workService;

    public WorkController(WorkService workService) {
        this.workService = workService;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Work work) {
        workService.create(work);
        return "redirect:/jobs/list";
    }

    @GetMapping("/list")
    public String getAllWorks(Model model) {
        List<Work> works = workService.allWorks();
        model.addAttribute("works", works);
        return "works/works";
    }

    @GetMapping(value = "/add")
    public String add(Model model) {
        model.addAttribute("newJob", new Work());
        return "works/newJob";
    }

    @PostMapping("/newWork")
    public String add(@ModelAttribute Work work) {
        workService.add(work);
        return "redirect:/jobs/list";
    }

    @GetMapping("/edit")
    public String edit(Model model, @RequestParam("id") Long id) throws NotFoundException {
        Work work = workService.getById(id);

        model.addAttribute("editedWork", work);
        return "works/editedWork";
    }

    @PostMapping(value = "/update")
    public String updateEmp(@ModelAttribute Work work) {
        workService.update(work);
        return "redirect:/jobs/list";
    }

    @PostMapping("/deleteJob")
    public String delete(@ModelAttribute Work work, @RequestParam("id") Long id) {
        workService.delete(work.getId());
        return "redirect:/jobs/list";
    }
}