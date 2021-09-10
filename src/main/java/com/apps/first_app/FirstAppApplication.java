package com.apps.first_app;

import com.apps.first_app.model.Department;
import com.apps.first_app.model.Employee;
import com.apps.first_app.model.Work;
import com.apps.first_app.repository.DepartmentRepository;
import com.apps.first_app.repository.EmployeeRepository;
import com.apps.first_app.repository.WorkRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class FirstAppApplication implements CommandLineRunner {

	private final WorkRepository workRepository;
	private final DepartmentRepository departmentRepository;
	private final EmployeeRepository employeeRepository;

	public FirstAppApplication(WorkRepository workRepository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
		this.workRepository = workRepository;
		this.departmentRepository = departmentRepository;
		this.employeeRepository = employeeRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(FirstAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Department department = departmentRepository.findById(1L).get();

		Employee employee = employeeRepository.findById(1L).get();
		employee.setDepartment(department);

		List<Employee> employees = new ArrayList<>();
		employees.add(employee);

		department.setEmployees(employees);
		departmentRepository.save(department);
		employeeRepository.save(employee);

        // work
        Work work = workRepository.findById(1L).get();
        employee.setWork(work);

        work.setEmployees(employees);
        workRepository.save(work);
	}
}