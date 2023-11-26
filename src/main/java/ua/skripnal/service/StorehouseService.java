package ua.skripnal.service;

import ua.skripnal.model.Storehouse;

import java.util.List;
import java.util.Optional;

public interface StorehouseService {

    void readProductById(int productId);
    void readAll();
    void insertProduct(int productId, int count);
    void updateByProductId(int productId, int count);
    void deleteProductById(int productId);
}
