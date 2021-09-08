package com.apps.first_app.service.impl;

import com.apps.first_app.model.Department;
import com.apps.first_app.model.Work;
import com.apps.first_app.repository.DepartmentRepository;
import com.apps.first_app.service.DepartmentService;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<Department> getAllDepartments() {
        List<Department> deps = new ArrayList<>();
        Iterable<Department> iterableDeps = departmentRepository.findAll();

        iterableDeps.forEach(dep -> {
            deps.add(dep);
        });

        return deps;
    }

    @Override
    public void add(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public Department getById(Long id) {
        Department department = null;

        try {
            department = departmentRepository.findById(id).get();
        } catch(Exception exception) {
            exception.printStackTrace();
        }

        return department;
    }

    @Override
    public void update(Department department) {
        Department oldDep = departmentRepository.findById(department.getId()).get();
        oldDep.setId(department.getId());
        oldDep.setName(department.getName());

        departmentRepository.save(oldDep);
    }

    @Override
    public void delete(Long id) {
        departmentRepository.deleteById(id);
    }

}
