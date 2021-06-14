package org.example.repository.impl;

import org.example.entity.Basket;
import org.example.repository.Repo;
import org.example.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class BasketRepoImpl implements Repo<Basket, Long> {
    private Session session;
    private Transaction transaction;
    @Override
    public void add(Basket basket) throws SQLException {
        session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.save(basket);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Basket> getAll() throws SQLException {
        session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        List<Basket> baskets = session.createQuery("FROM Basket").list();
        transaction.commit();
        session.close();
        return baskets;
    }

    @Override
    public Basket getById(Long id) throws SQLException {
        session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        Basket basket = session.get(Basket.class,id);
        transaction.commit();
        session.close();
        return basket;
    }

    @Override
    public Basket update(Basket basket) throws SQLException {
        session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.saveOrUpdate(basket);
        transaction.commit();
        session.close();
        return basket;
    }

    @Override
    public void remove(Long id) throws SQLException {
        session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        Basket basket = session.get(Basket.class,id);
        session.remove(basket);
        transaction.commit();
        session.close();
    }
}
