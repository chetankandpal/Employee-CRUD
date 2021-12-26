package com.example.academic_erp_employee.controller;

import com.example.academic_erp_employee.Service.EmployeeService;
import com.example.academic_erp_employee.bean.Employee;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.List;

@Path("employee")
public class EmployeeController {

    @POST
    @Path("/add")
    @Produces(MediaType.TEXT_PLAIN)//return type
    @Consumes(MediaType.APPLICATION_JSON)//parameter
    public Response addEmployee(Employee employee) throws URISyntaxException{
        boolean val = new EmployeeService().addEmployee_details(employee);
        if (val)
            return Response.ok().build();
        else
            return Response.status(203).build();
    }

    @POST
    @Path("/show")
    @Produces(MediaType.APPLICATION_JSON)//return type
    @Consumes(MediaType.APPLICATION_JSON)//parameter
     public Response showEmployee(Employee employee) throws  URISyntaxException{
        List<Employee> val=new EmployeeService().showEmployee(employee);

            return Response.ok().entity(val).build();


    }
}
