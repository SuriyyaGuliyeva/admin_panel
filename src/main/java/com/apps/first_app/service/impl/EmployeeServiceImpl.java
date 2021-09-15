package com.apps.first_app.service.impl;

import com.apps.first_app.model.Employee;
import com.apps.first_app.repository.inter.EmployeeRepository;
import com.apps.first_app.service.inter.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> allEmployees() {
        List<Employee> employees = new ArrayList<>();
        Iterable<Employee> iterable = employeeRepository.findAll();

        iterable.forEach(employee -> {
            employees.add(employee);
        });

        return employees;
    }

    @Override
    public void add(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee getById(long id) {
        Employee employee = null;

        try {
            employee = employeeRepository.findById(id).get();
        } catch (Exception exception) {
            exception.getMessage();
        }

        return employee;
    }

    @Override
    public void update(Employee employee) {
        Employee oldEmployee = employeeRepository.findById(employee.getId()).get();

        oldEmployee.setFirstName(employee.getFirstName());
        oldEmployee.setLastName(employee.getLastName());
        oldEmployee.setPhone(employee.getPhone());
        oldEmployee.setAddress(employee.getAddress());
        oldEmployee.setDepartment(employee.getDepartment());
        oldEmployee.setWork(employee.getWork());

        employeeRepository.save(oldEmployee);
    }

    @Override
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

//    @Override
//    public List<Employee> getAllByIds(List<Long> ids) {
//        return employeeRepository.findAllByIdIn(ids);
//    }
}













