package com.apps.first_app.service.inter;

import com.apps.first_app.model.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> getAllDepartments();

    void add(Department department);

    Department getById(Long id);

    void update (Department department);

    void delete(Long id);

}
