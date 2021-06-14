package org.example.controller;

import org.example.entity.Basket;
import org.example.repository.Repo;
import org.example.repository.impl.BasketRepoImpl;

import java.sql.SQLException;
import java.util.List;

public class BasketController {
    private Repo repo = new BasketRepoImpl();

    public Basket editBasket(Basket basket) throws SQLException {
        return (Basket) repo.update(basket);
    }

    public List<Basket> getAllBaskets() throws SQLException {
        return repo.getAll();
    }

    public void saveBasket(Basket basket) throws SQLException {
        repo.add(basket);
    }

    public void deleteBasket(Long id) throws SQLException {
        repo.remove(id);
    }
    public Basket getBasketById(Long id) throws SQLException {
        return (Basket) repo.getById(id);
    }
}
