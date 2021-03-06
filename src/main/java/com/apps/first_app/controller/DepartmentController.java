package com.apps.first_app.controller;

import com.apps.first_app.model.Department;
import com.apps.first_app.service.inter.DepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/departments")
@Api(value = "Department Controller", tags = {"Department Controller"})
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/list")
    @ApiOperation(value = "Method for departments' list")
    public String getAllDepartments(Model model) {
        List<Department> departments = departmentService.getAllDepartments();
        model.addAttribute("departments", departments);
        return "departments/departments";
    }

    @GetMapping(value = "/add")
    public String addDep(Model model) {
        model.addAttribute("addDep", new Department());
        return "departments/addDep";
    }

    @PostMapping("/newDep")
    @ApiOperation(value = "Method for add a new department")
    public String addNewDep(@ModelAttribute Department department) {
        departmentService.add(department);
        return "redirect:/departments/list";
    }

    @GetMapping("/edit")
    public String editDep(Model model, @RequestParam("id") Long id) {
        Department department = departmentService.getById(id);

        model.addAttribute("editedDep", department);
        return "departments/editedDep";
    }

    @PostMapping(value = "/update")
    public String updateEmp(@ModelAttribute Department department) {
        departmentService.update(department);
        return "redirect:/departments/list";
    }

    @PostMapping("/deleteDep")
    public String delete(@ModelAttribute Department department, @RequestParam("id") Long id) {
        departmentService.delete(department.getId());
        return "redirect:/departments/list";
    }

}