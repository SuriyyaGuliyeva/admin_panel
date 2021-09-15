package com.apps.first_app.service.inter;

import com.apps.first_app.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> allEmployees();

    void add(Employee employee);

    Employee getById(long id);

    void update(Employee employee);

    void delete(Long id);

//    List<Employee> getAllByIds(List<Long> ids);
}
