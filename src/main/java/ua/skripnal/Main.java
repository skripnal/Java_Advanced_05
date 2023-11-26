package ua.skripnal;

import ua.skripnal.dao.BucketDao;
import ua.skripnal.dao.ProductDao;
import ua.skripnal.dao.StorehouseDao;
import ua.skripnal.dao.UserDao;
import ua.skripnal.daoImpl.BucketDaoImpl;
import ua.skripnal.daoImpl.ProductDaoImpl;
import ua.skripnal.daoImpl.StorehouseDaoImpl;
import ua.skripnal.daoImpl.UserDaoImpl;
import ua.skripnal.model.User;
import ua.skripnal.service.BucketService;
import ua.skripnal.service.ProductService;
import ua.skripnal.service.StorehouseService;
import ua.skripnal.service.UserService;
import ua.skripnal.serviceImpl.BucketServiceImpl;
import ua.skripnal.serviceImpl.ProductServiceImpl;
import ua.skripnal.serviceImpl.StorehouseServiceImpl;
import ua.skripnal.serviceImpl.UserServiceImpl;
import ua.skripnal.utils.ConnectionUtils;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {
        Connection connection = ConnectionUtils.openConnection();

        UserDao userDao = new UserDaoImpl(connection);
        UserService userService = new UserServiceImpl(userDao);

        ProductDao productDao = new ProductDaoImpl(connection);
        ProductService productService = new ProductServiceImpl(productDao);


        BucketDao bucketDao = new BucketDaoImpl(connection);
        BucketService bucketService = new BucketServiceImpl(bucketDao);

        StorehouseDao storehouseDao = new StorehouseDaoImpl(connection);
        StorehouseService storehouseService = new StorehouseServiceImpl(storehouseDao);

    }
}
