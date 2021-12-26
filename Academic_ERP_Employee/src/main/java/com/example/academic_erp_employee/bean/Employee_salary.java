package com.example.academic_erp_employee.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name="Employeesalary")
public class Employee_salary implements  Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name="employee_id")
    private Employee employee_id;


    @Column(nullable = false)
    private Integer amount;


    public Employee_salary(){

    }
    public Employee_salary(Integer id, Employee employee_id, Integer amount) {

        super();
        this.id = id;
        this.employee_id = employee_id;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Employee employee_id) {
        this.employee_id = employee_id;
    }


    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

}
