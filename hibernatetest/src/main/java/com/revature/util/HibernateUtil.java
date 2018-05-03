package com.revature.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil{

    private static SessionFactory mysession;

    public HibernateUtil(){

    }

    public static SessionFactory getSession(){
        try {
            mysession = new Configuration().configure().buildSessionFactory();
            return mysession;
        } catch (HibernateException e) {
            //TODO: handle exception
        }
		return null;
    }    
}