package ua.skripnal.service;

import ua.skripnal.model.Product;

import java.util.List;

public interface ProductService {

    Product readById(int id);
    List<Product> readAll();
    void insert(String name, String description, double price);
    void deleteById(int id);
    void updateProductById(int id, String name, String description, double price);
    void updateProductNameById(int id, String name);
    void updateProductDescriptionById(int id, String description);
    void updateProductPriceById(int id, double price);

}
