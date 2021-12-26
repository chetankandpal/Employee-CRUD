package com.example.academic_erp_employee.Service;

import com.example.academic_erp_employee.DAO.Implementation.EmployeeDAOImpl;
import com.example.academic_erp_employee.bean.Employee;

import java.util.List;

public class EmployeeService {

    EmployeeDAOImpl employeeDAO= new EmployeeDAOImpl();

    public boolean addEmployee_details(Employee employee)
    {
        return employeeDAO.addEmployee(employee);
    }

    public List<Employee> showEmployee(Employee employee)
    {
        return employeeDAO.showEmployee(employee);
    }
}
