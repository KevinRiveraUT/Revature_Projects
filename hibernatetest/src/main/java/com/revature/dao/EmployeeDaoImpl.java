package com.revature.dao;

import com.revature.model.Employee;
import com.revature.util.HibernateUtil;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public void insertEmployee(Employee emp) {
        Session session = HibernateUtil.getSession().openSession();
        
        Transaction t1 = null;

        try {
            t1 = session.beginTransaction();
            session.save(emp);
            t1.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
	}

}