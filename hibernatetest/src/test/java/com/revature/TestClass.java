package com.revature;

import java.util.Date;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.model.Employee;

public class TestClass{
    public static void main(String[] args) {
        Employee e1 = new Employee(1, "Tom", "SDET", new Date(), "Kev");
        Employee e2 = new Employee(1, "Tom", "SDET", new Date(), "Kev");
        Employee e3 = new Employee(1, "Tom", "SDET", new Date(), "Kev");
        Employee e4 = new Employee(1, "Tom", "SDET", new Date(), "Kev");

        EmployeeDao dao = new EmployeeDaoImpl();

        dao.insertEmployee(e1);
    }
}