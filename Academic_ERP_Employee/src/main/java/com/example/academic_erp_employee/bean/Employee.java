package com.example.academic_erp_employee.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;

//JSON is a format that encodes objects in a string
//Serialization means to convert an object into that string,
// and deserialization is its inverse operation (convert string -> object)
@Entity
@Table(name="Employee")
public class Employee implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employee_id;

    @Column(nullable = false)
    private String fname;

    private String lname;


    @Column(unique = true,nullable = false)
    private String email;

    private String title;

    private String photograph_path;


    @ManyToOne
    @JoinColumn(name="department_id")
    private Department department;


    @OneToOne(mappedBy = "employee_id")
    private Employee_salary empsal;

    public Employee_salary getEmpsal() {
        return empsal;
    }

    public void setEmpsal(Employee_salary empsal) {
        this.empsal = empsal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhotograph_path() {
        return photograph_path;
    }

    public void setPhotograph_path(String photograph_path) {
        this.photograph_path = photograph_path;
    }







    public Employee(){

    }

    public Employee(String fname, String lname, Department department)
    {
        super();
        this.fname=fname;
        this.lname=lname;
        this.department=department;
    }


    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }


    public Integer getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }


}
