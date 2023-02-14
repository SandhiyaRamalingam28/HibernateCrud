package com.kgisl.hibernateCrud.EmployeeDao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.kgisl.hibernateCrud.model.Employee;

public class EmployeeDao {
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
    .configure("hibernate.cfg.xml")
    .build();
    SessionFactory factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

    public void getStudent(int id) {
       
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // get Student entity using get() method
            Employee employee = session.get(Employee.class, id);
            System.out.println(employee.getId());
            System.out.println(employee.getFirstname());
            System.out.println(employee.getLastname());
            System.out.println(employee.getEmail());
            System.out.println(employee.getSalary());
            System.out.println(employee.getDesignation());

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void loadStudent(int id) {
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // get Student entity using load() method
            Employee employee = session.load(Employee.class, id);
            System.out.println(employee.getId());
            System.out.println(employee.getFirstname());
            System.out.println(employee.getLastname());
            System.out.println(employee.getEmail());
            System.out.println(employee.getSalary());
            System.out.println(employee.getDesignation());

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void getStudentById(int id) {
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Obtain an entity using byId() method
            Employee employee = session.byId(Employee.class).getReference(id);
            System.out.println(employee.getId()); 
            System.out.println(employee.getFirstname());
            System.out.println(employee.getLastname());
            System.out.println(employee.getEmail());
            System.out.println(employee.getSalary());
            System.out.println(employee.getDesignation());

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void saveStudent(Employee employee) {
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(employee);
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
