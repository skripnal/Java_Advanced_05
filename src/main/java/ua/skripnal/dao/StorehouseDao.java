package ua.skripnal.dao;


import ua.skripnal.model.Storehouse;

import java.util.List;
import java.util.Optional;

public interface StorehouseDao {

    Optional<Storehouse> readProductById(int productId);
    List<Storehouse> readAll();
    void insertProduct(int productId, int count);
    void updateByProductId(int productId, int count);
    void deleteProductById(int productId);
}
