package com.apps.first_app.service;

import com.apps.first_app.model.Department;
import javassist.NotFoundException;

import java.util.List;

public interface DepartmentService {

    List<Department> getAllDepartments();

    void add(Department department);

    Department getById(Long id);

    void update (Department department);

    void delete(Long id);

}
