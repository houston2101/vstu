package org.example.controller;

import org.example.entity.Provider;
import org.example.repository.Repo;
import org.example.repository.impl.ProviderRepoImpl;

import java.sql.SQLException;
import java.util.List;

public class ProviderController {
    private Repo repo = new ProviderRepoImpl();

    public Provider editProvider(Provider provider) throws SQLException {
        return (Provider) repo.update(provider);
    }

    public List<Provider> getAllProviders() throws SQLException {
        return repo.getAll();
    }

    public void saveProvider(Provider provider) throws SQLException {
        repo.add(provider);
    }

    public void deleteProvider(Long id) throws SQLException {
        repo.remove(id);
    }

    public Provider getProviderById(Long id) throws SQLException {
        return (Provider) repo.getById(id);
    }
}
