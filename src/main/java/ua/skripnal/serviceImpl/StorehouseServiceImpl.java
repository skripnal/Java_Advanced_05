package ua.skripnal.serviceImpl;

import ua.skripnal.dao.StorehouseDao;
import ua.skripnal.model.Storehouse;
import ua.skripnal.service.StorehouseService;

import java.util.Optional;

public class StorehouseServiceImpl implements StorehouseService {
    StorehouseDao storehouseDao;

    public StorehouseServiceImpl(StorehouseDao storehouseDao) {
        this.storehouseDao = storehouseDao;
    }

    @Override
    public void readProductById(int productId) {
        Optional<Storehouse> optional = storehouseDao.readProductById(productId);
        if (optional.isPresent()){
            System.out.println(optional.get());
        }else System.out.println("Продукту під данним id не існує");
    }

    @Override
    public void readAll() {
        for (Storehouse storehouse : storehouseDao.readAll()){
            System.out.println(storehouse);
        }
    }

    @Override
    public void insertProduct(int productId, int count) {
        storehouseDao.insertProduct(productId,count);
    }

    @Override
    public void updateByProductId(int productId, int count) {
        storehouseDao.updateByProductId(productId,count);
    }

    @Override
    public void deleteProductById(int productId) {
        storehouseDao.deleteProductById(productId);
    }
}
