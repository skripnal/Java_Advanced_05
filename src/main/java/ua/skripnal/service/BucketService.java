package ua.skripnal.service;

import ua.skripnal.model.Bucket;

import java.util.List;

public interface BucketService {

    List<Bucket> readAllByUserId(int userId);
    void readAll();
    void insertProductByUserId(int userId, int productId);
    void deleteProductByUserId(int userId, int productId);
    void deleteProduct(int id);
}
