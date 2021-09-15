package com.apps.first_app.repository.inter;

import com.apps.first_app.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
     List<Employee> findAllByIdIn(List<Long> id);
}
