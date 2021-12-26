package com.example.academic_erp_employee.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="Department")
public class Department implements  Serializable {

    @Id
    private int department_id;

    @Column(nullable = false)
    private String department_name;

    @Column(nullable = false)
    private Integer capacity;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER ,mappedBy="department")
    private Set<Employee> employee_id;

    public Set<Employee> getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Set<Employee> employee_id) {
        this.employee_id = employee_id;
    }


    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }



    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public Department() {

    }

    public Department(int department_id, String department_name,Integer capacity) {
        super();
        this.department_id = department_id;
        this.department_name = department_name;
        this.capacity=capacity;
    }


}
