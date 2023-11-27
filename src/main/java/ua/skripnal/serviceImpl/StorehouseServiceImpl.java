package ua.skripnal.serviceImpl;

import org.apache.log4j.Logger;
import ua.skripnal.dao.StorehouseDao;
import ua.skripnal.model.Storehouse;
import ua.skripnal.service.StorehouseService;

import java.util.Optional;

public class StorehouseServiceImpl implements StorehouseService {
    StorehouseDao storehouseDao;
    private static Logger LOGGER = Logger.getLogger(StorehouseServiceImpl.class);

    public StorehouseServiceImpl(StorehouseDao storehouseDao) {
        LOGGER.info("StorehouseServiceImpl -> constructor");
        this.storehouseDao = storehouseDao;
    }

    @Override
    public void readProductById(int productId) {
        LOGGER.info("StorehouseServiceImpl -> readProductById");
        Optional<Storehouse> optional = storehouseDao.readProductById(productId);
        if (optional.isPresent()){
            System.out.println(optional.get());
        }else System.out.println("Продукту під данним id не існує");
    }

    @Override
    public void readAll() {
        LOGGER.info("StorehouseServiceImpl -> readAll");
        for (Storehouse storehouse : storehouseDao.readAll()){
            System.out.println(storehouse);
        }
    }

    @Override
    public void insertProduct(int productId, int count) {
        LOGGER.info("StorehouseServiceImpl -> insertProduct");
        storehouseDao.insertProduct(productId,count);
    }

    @Override
    public void updateByProductId(int productId, int count) {
        LOGGER.info("StorehouseServiceImpl -> updateByProductId");
        storehouseDao.updateByProductId(productId,count);
    }

    @Override
    public void deleteProductById(int productId) {
        LOGGER.info("StorehouseServiceImpl -> deleteProductById");
        storehouseDao.deleteProductById(productId);
    }
}
