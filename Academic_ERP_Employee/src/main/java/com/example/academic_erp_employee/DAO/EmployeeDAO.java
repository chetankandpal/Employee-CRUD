package com.example.academic_erp_employee.DAO;

import com.example.academic_erp_employee.bean.Employee;

import java.util.List;

public interface EmployeeDAO {
    boolean addEmployee(Employee employee);
    List<Employee> showEmployee(Employee employee);
}
