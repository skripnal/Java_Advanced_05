package ua.skripnal.dao;


import ua.skripnal.model.Bucket;

import java.util.List;

public interface BucketDao {
    List<Bucket> readAllByUserId(int userId);
    List<Bucket> readAll();
    void insertProductByUserId(int userId, int productId);
    void deleteProductByUserId(int userId, int productId);

    void deleteProduct(int id);

}
