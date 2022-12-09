package com.example.catalog.Model.Dao;

import com.example.catalog.Model.entity.Catalog;

import java.util.List;

public interface CatalogDao {
   public List<Catalog> getAll();
    public  Catalog getById(int catalogId);
    public boolean save(Catalog catalog);
    public boolean update(Catalog catalog);
    public boolean delete(int catalogId);
    public List<Catalog> search(String search);
}
