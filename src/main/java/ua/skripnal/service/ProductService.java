package ua.skripnal.service;

import ua.skripnal.model.CustomProductBucket;
import ua.skripnal.model.Product;

import java.util.List;

public interface ProductService {

    Product readById(int id);
    List<Product> readAll();
    List<Product> readByCategory(String category, String subCategory);
    void insert(String name, String description, double price, String category, String subCategory, String imagePath);
    void deleteById(int id);
    void updateProductById(int id, String name, String description, double price, String category, String subCategory);
    void updateProductNameById(int id, String name);
    void updateProductDescriptionById(int id, String description);
    void updateProductPriceById(int id, double price);

    String joinImageNameById(int productId);

    List<CustomProductBucket> readALLProductBucket(int userId);

}
