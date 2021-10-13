package com.apps.first_app.controller;

import com.apps.first_app.model.Department;
import com.apps.first_app.model.Employee;
import com.apps.first_app.model.Work;
import com.apps.first_app.service.inter.DepartmentService;
import com.apps.first_app.service.inter.EmployeeService;
import com.apps.first_app.service.inter.WorkService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final WorkService workService;
    private final DepartmentService departmentService;

    public EmployeeController(EmployeeService employeeService, WorkService workService, DepartmentService departmentService) {
        this.employeeService = employeeService;
        this.workService = workService;
        this.departmentService = departmentService;
    }

    @GetMapping("/list")
    public String allEmployees(Model model) {
        List<Employee> employees = employeeService.allEmployees();
        model.addAttribute("employees", employees);
        return "employees/employees";
    }

    @GetMapping(value = "/add")
    public String addEmployeeFrom(Model model) {
        List<Work> works = workService.allWorks();
        List<Department> departments = departmentService.getAllDepartments();

        model.addAttribute("addEmp", new Employee());
        model.addAttribute("works", works);
        model.addAttribute("departments", departments);
        return "employees/addEmp";
    }

    @PostMapping("/newEmployee")
    public String addNewEmployee(@ModelAttribute Employee employee) {
        employeeService.add(employee);
        return "redirect:/employees/list";
    }

    @GetMapping("/edit")
    public String editEmp(Model model, @RequestParam("id") Long id) {
        Employee employee = employeeService.getById(id);
        List<Work> works = workService.allWorks();
        List<Department> departments = departmentService.getAllDepartments();

        model.addAttribute("updatedEmp", employee);
        model.addAttribute("works", works);
        model.addAttribute("departments", departments);
        return "employees/updatedEmp";
    }

    @PostMapping(value = "/update")
    public String updateEmp(@ModelAttribute Employee employee) {
        employeeService.update(employee);
        return "redirect:/employees/list";
    }

    @PostMapping("/deleteEmp")
    public String delete(@ModelAttribute Employee employee, @RequestParam("id") Long id) {
        employeeService.delete(employee.getId());
        return "redirect:/employees/list";
    }
}