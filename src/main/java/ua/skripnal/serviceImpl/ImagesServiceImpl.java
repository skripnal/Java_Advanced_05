package ua.skripnal.serviceImpl;

import ua.skripnal.dao.ImagesDao;
import ua.skripnal.service.ImagesService;

public class ImagesServiceImpl implements ImagesService {
    private ImagesDao imagesDao;

    public ImagesServiceImpl(ImagesDao imagesDao) {
        this.imagesDao = imagesDao;
    }

    @Override
    public void insert(String imgName) {
        imagesDao.insert(imgName);
    }
}
