package ua.skripnal.service;

public interface BucketService {

    void readAllByUserId(int userId);
    void readAll();
    void insertProductByUserId(int userId, int productId);
    void deleteProductByUserId(int userId, int productId);
}
