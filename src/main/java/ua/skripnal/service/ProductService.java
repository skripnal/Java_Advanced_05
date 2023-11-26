package ua.skripnal.service;

public interface ProductService {

    void readById(int id);
    void readAll();
    void insert(String name, String description, double price);
    void deleteById(int id);
    void updateProductById(int id, String name, String description, double price);
    void updateProductNameById(int id, String name);
    void updateProductDescriptionById(int id, String description);
    void updateProductPriceById(int id, double price);

}
