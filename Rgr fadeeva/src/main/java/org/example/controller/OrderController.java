package org.example.controller;

import org.example.entity.Order;
import org.example.repository.Repo;
import org.example.repository.impl.OrderRepoImpl;

import java.sql.SQLException;
import java.util.List;

public class OrderController {
    private Repo repo = new OrderRepoImpl();

    public Order editProduct(Order order) throws SQLException {
        return (Order) repo.update(order);
    }

    public List<Order> getAllOrders() throws SQLException {
        return repo.getAll();
    }

    public void saveOrder(Order order) throws SQLException {
        repo.add(order);
    }

    public void deleteOrder(Long id) throws SQLException {
        repo.remove(id);
    }
    public Order getOrderById(Long id) throws SQLException {
        return (Order) repo.getById(id);
    }
}
