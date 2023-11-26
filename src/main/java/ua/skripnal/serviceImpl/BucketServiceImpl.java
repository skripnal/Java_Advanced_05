package ua.skripnal.serviceImpl;

import ua.skripnal.dao.BucketDao;
import ua.skripnal.model.Bucket;
import ua.skripnal.service.BucketService;

public class BucketServiceImpl implements BucketService {
    BucketDao bucketDao;

    public BucketServiceImpl(BucketDao bucketDao) {
        this.bucketDao = bucketDao;
    }

    @Override
    public void readAllByUserId(int userId) {
        for (Bucket bucket : bucketDao.readAllByUserId(userId)){
            System.out.println(bucket);
        }
    }

    @Override
    public void readAll() {
        for (Bucket bucket : bucketDao.readAll()){
            System.out.println(bucket);
        }
    }

    @Override
    public void insertProductByUserId(int userId, int productId) {
        bucketDao.insertProductByUserId(userId, productId);
    }

    @Override
    public void deleteProductByUserId(int userId, int productId) {
        bucketDao.deleteProductByUserId(userId,productId);
    }
}
