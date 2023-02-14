package com.kgisl.hibernateCrud.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.kgisl.hibernateCrud.model.Employee;

public class UpdateEmployee {
    final static StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
        .configure("hibernate.cfg.xml")
        .build();
        static SessionFactory factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    

    public static void main(String[] args) {

        Transaction transaction = null;
        try (Session session = factory.openSession()) {          
            transaction = session.beginTransaction();

            Employee emp1 = session.get(Employee.class, 5);
            emp1.setEmail("sandy@gmail.com");
            session.save(emp1);
            transaction.commit();
            
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
}
