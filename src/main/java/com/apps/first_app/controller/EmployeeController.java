package com.apps.first_app.controller;

import com.apps.first_app.model.Employee;
import com.apps.first_app.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String allEmployees(Model model) {
        List<Employee> employees = employeeService.allEmployees();
        model.addAttribute("employees", employees);
        return "employees/employees";
    }

    @GetMapping(value = "/addOrEdit", params = "action=Add a new employee")
    public String addEmployeeFrom(Model model) {
        model.addAttribute("addEmp", new Employee());
        return "employees/addEmp";
    }

    @PostMapping("/newEmployee")
    public String addNewEmployee(@ModelAttribute Employee employee) {
        if (employee.getDepartment() == null || employee.getWork() == null) {
            return "commonPages/notFoundDepOrWork";
        } else {
            employeeService.add(employee);
            return "redirect:/employees/list";
        }
    }

//    @GetMapping(value = "/addOrEdit", params = "action=Edit an employee")
//    public String editEmployeeForm(Model model) {
//        model.addAttribute("searchEmp", new Employee());
//        return "employees/searchEmp";
//    }

    @GetMapping("/edit")
    public String editEmp(Model model, @RequestParam("id") Long id) {
        Employee employee = employeeService.getById(id);

        if (employee == null) {
            return "commonPages/notFoundPage";
        } else {
            model.addAttribute("updatedEmp", employee);
            return "employees/updatedEmp";
        }
    }

    @PostMapping(value = "/updateOrDelete", params = "action=Update")
    public String updateEmp(@ModelAttribute Employee employee) {
        if (employee.getDepartment() == null || employee.getWork() == null) {
            return "commonPages/notFoundDepOrWork";
        } else {
            employeeService.update(employee);
            return "redirect:/employees/list";
        }
    }

    @PostMapping(value = "/updateOrDelete", params = "action=Delete")
    public String deleteEmp(@ModelAttribute Employee employee) {
        if (employee.getDepartment() == null || employee.getWork() == null) {
            return "commonPages/notFoundDepOrWork";
        } else {
            employeeService.delete(employee.getId());
            return "redirect:/employees/list";
        }
    }
}