package org.example.repository;

import java.sql.SQLException;
import java.util.List;

public interface Repo<T,t> {
    void add(T t) throws SQLException;

    List<T> getAll() throws SQLException;

    T getById(Long id) throws SQLException;

    T update(T t) throws SQLException;

    void remove(Long id) throws SQLException;
}
