package com.example.catalog.Model.ServiceImp;

import com.example.catalog.Model.Dao.CatalogDao;
import com.example.catalog.Model.Service.CatalogService;
import com.example.catalog.Model.entity.Catalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CatalogServiceImp implements CatalogService {
    @Autowired
    private CatalogDao catalogDao;
    @Override
    public List<Catalog> getAll() {
        return catalogDao.getAll();
    }

    @Override
    public Catalog getById(int catalogId) {
        return catalogDao.getById(catalogId);
    }

    @Override
    public boolean save(Catalog catalog) {
        return catalogDao.save(catalog);
    }

    @Override
    public boolean update(Catalog catalog) {
        return catalogDao.update(catalog);
    }

    @Override
    public boolean delete(int catalogId) {
        return catalogDao.delete(catalogId);
    }

    @Override
    public List<Catalog> search(String search) {
        return catalogDao.search(search);
    }
}
