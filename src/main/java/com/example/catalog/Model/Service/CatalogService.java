package com.example.catalog.Model.Service;

import com.example.catalog.Model.entity.Catalog;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CatalogService {
    public List<Catalog> getAll();
    public  Catalog getById(int catalogId);
    public boolean save(Catalog catalog);
    public boolean update(Catalog catalog);
    public boolean delete(int catalogId);
    public List<Catalog> search(String search);
}
