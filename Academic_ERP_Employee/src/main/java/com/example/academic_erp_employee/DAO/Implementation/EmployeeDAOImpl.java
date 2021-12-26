package com.example.academic_erp_employee.DAO.Implementation;

import com.example.academic_erp_employee.DAO.EmployeeDAO;
import com.example.academic_erp_employee.Util.HibernateSessionUtil;
import com.example.academic_erp_employee.bean.Department;
import com.example.academic_erp_employee.bean.Employee;
import com.example.academic_erp_employee.bean.Employee_salary;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public boolean addEmployee(Employee employee) {
        try (Session session = HibernateSessionUtil.getSession()) {
            Transaction t = session.beginTransaction();

            String hqls="from Employee e where e.employee_id=:eid";
            Query querys=session.createQuery(hqls);
            querys.setParameter("eid",employee.getEmployee_id());
            List<Employee> emp=querys.getResultList();

            // If query is empty then insert the data else update the data
            if(emp.isEmpty()) {
                String hql1 = " from Department d where d.department_id =:did";
                Query query1 = session.createQuery(hql1);
                query1.setParameter("did", employee.getDepartment().getDepartment_id());

                List<Department> result = query1.getResultList();

                if (result.get(0).getCapacity() == 0) return false;

                //Department data update
                String hql2 = "update Department  set capacity =:capacity where department_id =:did";
                Query query2 = session.createQuery(hql2);
                query2.setParameter("did", employee.getDepartment().getDepartment_id());

                query2.setParameter("capacity", result.get(0).getCapacity() - 1);
                query2.executeUpdate();

                //Employee data
                session.save(employee);

                Employee_salary es = new Employee_salary();

                if (employee.getDepartment().getDepartment_id() == 1)
                    es.setAmount(15000);
                else if(employee.getDepartment().getDepartment_id()== 2)
                    es.setAmount(10000);

                es.setEmployee_id(employee);

                //Employee salary data
                session.save(es);
            }
            else
            {
                String hql4="update Employee set fname =:fname ,lname =:lname,email =:email,photograph_path =:photo where employee_id=:emid";
                Query query4=session.createQuery(hql4);

                query4.setParameter("fname",employee.getFname());
                query4.setParameter("lname",employee.getLname());
                query4.setParameter("email",employee.getEmail());
                query4.setParameter("photo",employee.getPhotograph_path());
                query4.setParameter("emid",employee.getEmployee_id());

                query4.executeUpdate();

            }




            t.commit();
            return true;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public List<Employee> showEmployee(Employee employee) {

        try(Session session=HibernateSessionUtil.getSession())
        {
           Transaction t=session.beginTransaction();

           String hql1="from Employee e  where e.employee_id=:eid ";
           Query query1=session.createQuery(hql1);
           query1.setParameter("eid",employee.getEmployee_id());

           List<Employee> list=query1.getResultList();

            t.commit();
            return  list;
        }
        catch (HibernateException exception){
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
    }
}
