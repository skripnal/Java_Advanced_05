package ua.skripnal.dao;

import ua.skripnal.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDao {

    Optional<Product> readById(int id);
    List<Product> readAll();
    void insert(String name, String description, double price);
    void updateById(int id, Product product);
    void deleteById(int id);
}
