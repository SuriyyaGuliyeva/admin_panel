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



    @GetMapping(value = "/addOrEdit", params = "action=Add a new job")
    public String add(Model model) {
        model.addAttribute("newJob", new Work());
        return "works/newJob";
    }

    @PostMapping("/newWork")
    public String add(@ModelAttribute Work work) {
        workService.add(work);
        return "redirect:/jobs/list";
    }

//    @GetMapping(value = "/addOrEdit", params = "action=Edit a job")
//    public String update(Model model) {
//        model.addAttribute("search", new Work());
//        return "works/search";
//    }


    @GetMapping("/edit")
    public String edit(Model model, @RequestParam("id") Long id) throws NotFoundException {
        Work work = workService.getById(id);

        if (work == null) {
            return "commonPages/notFoundPage";
        } else {
            model.addAttribute("editedWork", work);
            return "works/editedWork";
        }
    }

    @PostMapping(value = "/newEditedWork", params = "action=Update")
    public String edit(@ModelAttribute Work work) {
        workService.update(work);
        return "redirect:/jobs/list";
    }

    @PostMapping(value = "/newEditedWork", params = "action=Delete")
    public String delete(@ModelAttribute Work work) {
        workService.delete(work.getId());
        return "redirect:/jobs/list";
    }

//    @GetMapping("/search")
//    public String search(Model model) {
//        model.addAttribute("search", new Work());
//        return "search";
//    }

}