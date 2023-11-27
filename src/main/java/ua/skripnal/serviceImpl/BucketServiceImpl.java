package ua.skripnal.serviceImpl;

import org.apache.log4j.Logger;
import ua.skripnal.dao.BucketDao;
import ua.skripnal.daoImpl.UserDaoImpl;
import ua.skripnal.model.Bucket;
import ua.skripnal.service.BucketService;

public class BucketServiceImpl implements BucketService {
    BucketDao bucketDao;
    private static Logger LOGGER = Logger.getLogger(BucketServiceImpl.class);

    public BucketServiceImpl(BucketDao bucketDao) {
        LOGGER.info("BucketServiceImpl -> constructor");
        this.bucketDao = bucketDao;
    }

    @Override
    public void readAllByUserId(int userId) {
        LOGGER.info("BucketServiceImpl -> readAllByUserId");
        for (Bucket bucket : bucketDao.readAllByUserId(userId)){
            System.out.println(bucket);
        }
    }

    @Override
    public void readAll() {
        LOGGER.info("BucketServiceImpl -> readAll");
        for (Bucket bucket : bucketDao.readAll()){
            System.out.println(bucket);
        }
    }

    @Override
    public void insertProductByUserId(int userId, int productId) {
        LOGGER.info("BucketServiceImpl -> insertProductByUserId");
        bucketDao.insertProductByUserId(userId, productId);
    }

    @Override
    public void deleteProductByUserId(int userId, int productId) {
        LOGGER.info("BucketServiceImpl -> deleteProductByUserId");
        bucketDao.deleteProductByUserId(userId,productId);
    }
}
