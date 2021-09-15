package com.apps.first_app.modelView.Employee;

public class EmployeeDTO {
    public EmployeeDTO(Long id, String firstName, String lastName, String address, String phone, String departmentName, String workName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.departmentName = departmentName;
        workName = workName;
    }

    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private String departmentName;
    private String workName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDepartment() {
        return departmentName;
    }

    public void setDepartment(String department) {
        this.departmentName = department;
    }

    public String getWork() {
        return workName;
    }

    public void setWork(String work) {
        work = work;
    }
}
