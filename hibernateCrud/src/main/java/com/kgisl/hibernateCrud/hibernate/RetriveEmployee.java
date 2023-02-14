package com.kgisl.hibernateCrud.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.kgisl.hibernateCrud.model.Employee;

public class RetriveEmployee {
    public static void main(String[] args){
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
        .configure("hibernate.cfg.xml")
        .build();
        SessionFactory factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        Session session=factory.openSession();
          
        System.out.println("Fetching object using get:");
        Employee s1=session.get(Employee.class, 1);
        System.out.println(s1);
        System.out.println("Fetching object using load:");
        Employee s2=session.load(Employee.class,5);
        System.out.println(s2);
          
        factory.close();
    }
}
