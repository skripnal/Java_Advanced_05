package ua.skripnal.dao;

import ua.skripnal.model.CustomProductBucket;
import ua.skripnal.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDao {

    Optional<Product> readById(int id);
    List<Product> readAll();
    List<Product> readByCategory(String category, String subCategory);
    void insert(String name, String description, double price, String category, String subCategory, String imagePath);
    void updateById(int id, Product product);
    void deleteById(int id);
    String joinImageNameById(int productId);

    List<CustomProductBucket> readALLProductBucket(int userId);
}
