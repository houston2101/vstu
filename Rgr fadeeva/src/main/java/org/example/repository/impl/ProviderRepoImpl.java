package org.example.repository.impl;
import org.example.entity.Provider;
import org.example.repository.Repo;
import org.example.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class ProviderRepoImpl implements Repo<Provider,Long> {
    private Session session;
    private Transaction transaction;
    @Override
    public void add(Provider provider) throws SQLException {
        session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.save(provider);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Provider> getAll() throws SQLException {
        session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        List<Provider> providers = session.createQuery("FROM SProvider").list();
        transaction.commit();
        session.close();
        return providers;
    }

    @Override
    public Provider getById(Long id) throws SQLException {
        session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        Provider provider = session.get(Provider.class,id);
        transaction.commit();
        session.close();
        return provider;
    }

    @Override
    public Provider update(Provider provider) throws SQLException {
        session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.saveOrUpdate(provider);
        transaction.commit();
        session.close();
        return provider;
    }

    @Override
    public void remove(Long id) throws SQLException {
        session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        Provider provider = session.get(Provider.class,id);
        session.remove(provider);
        transaction.commit();
        session.close();
    }
}
