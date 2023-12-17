package ua.skripnal;


import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import ua.skripnal.dao.*;
import ua.skripnal.daoImpl.*;
import ua.skripnal.service.*;
import ua.skripnal.serviceImpl.*;
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

        ImagesDao imagesDao = new ImagesDaoImpl(connection);
        ImagesService imagesService = new ImagesServiceImpl(imagesDao);

        System.out.println(productService.readALLProductBucket(2));


    }
}
