package org.example.repository.impl;

import org.example.entity.Customer;
import org.example.repository.Repo;
import org.example.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class CustomerRepoImpl implements Repo<Customer,Long> {
    private Session session;
    private Transaction transaction;
    @Override
    public void add(Customer customer) throws SQLException {
        session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.save(customer);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Customer> getAll() throws SQLException {
        session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        List<Customer> customers = session.createQuery("FROM Customer ").list();
        transaction.commit();
        session.close();
        return customers;
    }

    @Override
    public Customer getById(Long id) throws SQLException {
        session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        Customer customer = session.get(Customer.class,id);
        transaction.commit();
        session.close();
        return customer;
    }

    @Override
    public Customer update(Customer customer) throws SQLException {
        session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.saveOrUpdate(customer);
        transaction.commit();
        session.close();
        return customer;
    }

    @Override
    public void remove(Long id) throws SQLException {
        session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        Customer customer = session.get(Customer.class,id);
        session.remove(customer);
        transaction.commit();
        session.close();
    }
}
