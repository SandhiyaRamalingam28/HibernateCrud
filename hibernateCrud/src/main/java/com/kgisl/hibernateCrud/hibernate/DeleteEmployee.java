package com.kgisl.hibernateCrud.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.kgisl.hibernateCrud.model.Employee;

public class DeleteEmployee {
    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();
        SessionFactory factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a persistent object
            Employee emp = session.get(Employee.class, 7);
            if (emp != null) {
                session.delete(emp);
                System.out.println("student 1 is deleted");
            }

            // Delete a transient object
            Employee emp1 = new Employee();
            emp1.setId(2);
            session.delete(emp1);
            System.out.println("Student 2 is deleted");

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
