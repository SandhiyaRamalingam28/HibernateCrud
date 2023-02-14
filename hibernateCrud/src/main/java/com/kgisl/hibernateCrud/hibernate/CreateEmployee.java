package com.kgisl.hibernateCrud.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.kgisl.hibernateCrud.model.Employee;

public class CreateEmployee {
    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
        .configure("hibernate.cfg.xml")
        .build();
        SessionFactory factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    
        Employee emp = new Employee(12,"Ramesh", "Fadatare", "rameshfadatare@javaguides.com","5000","Trainer");
        Employee emp1 = new Employee(13,"John", "Cena", "john@javaguides.com","45000","Junior Assosiate");
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            session.save(emp);
            session.save(emp1);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        try (Session session = factory.openSession()) {
            List < Employee > employee = session.createQuery("from Employee", Employee.class).list();
            // employee.forEach(s - > System.out.println(s.getFirstName()));
            employee.stream().forEach(System.out::println);
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    
}
