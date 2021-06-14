package org.example.controller;

import org.example.entity.Customer;
import org.example.repository.Repo;
import org.example.repository.impl.CustomerRepoImpl;

import java.sql.SQLException;
import java.util.List;

public class CustomerController {
    private Repo repo = new CustomerRepoImpl();

    public Customer editCustomer(Customer customer) throws SQLException {
        return (Customer) repo.update(customer);
    }

    public List<Customer> getAllCustomer() throws SQLException {
        return repo.getAll();
    }

    public void saveCustomer(Customer customer) throws SQLException {
        repo.add(customer);
    }

    public void deleteCustomer(Long id) throws SQLException {
        repo.remove(id);
    }

    public Customer getCustomerById(Long id) throws SQLException {
        return (Customer) repo.getById(id);
    }
}
