package org.example.repository.impl;

import org.example.entity.Order;
import org.example.repository.Repo;
import org.example.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class OrderRepoImpl implements Repo<Order,Long> {
    private Session session;
    private Transaction transaction;
    @Override
    public void add(Order order) throws SQLException {
        session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.save(order);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Order> getAll() throws SQLException {
        session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        List<Order> orders = session.createQuery("FROM Product").list();
        transaction.commit();
        session.close();
        return orders;
    }

    @Override
    public Order getById(Long id) throws SQLException {
        session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        Order order = session.get(Order.class,id);
        transaction.commit();
        session.close();
        return order;
    }

    @Override
    public Order update(Order order) throws SQLException {
        session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.saveOrUpdate(order);
        transaction.commit();
        session.close();
        return order;
    }

    @Override
    public void remove(Long id) throws SQLException {
        session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        Order order = session.get(Order.class,id);
        session.remove(order);
        transaction.commit();
        session.close();
    }
}
