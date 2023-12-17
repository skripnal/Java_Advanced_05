package ua.skripnal.serviceImpl;

import org.apache.log4j.Logger;
import ua.skripnal.dao.ProductDao;
import ua.skripnal.model.CustomProductBucket;
import ua.skripnal.model.Product;
import ua.skripnal.service.ProductService;

import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {
    ProductDao productDao;
    private static Logger LOGGER = Logger.getLogger(ProductServiceImpl.class);

    public ProductServiceImpl(ProductDao productDao) {
        LOGGER.info("ProductServiceImpl -> constructor");
        this.productDao = productDao;
    }

    @Override
    public List<CustomProductBucket> readALLProductBucket(int userId) {
        return productDao.readALLProductBucket(userId);
    }

    @Override
    public Product readById(int id) {
        LOGGER.info("ProductServiceImpl -> readById");
        Optional<Product> optional = productDao.readById(id);
        if (optional.isPresent()){
            return optional.get();
        }else throw new NullPointerException();
    }

    @Override
    public List<Product> readByCategory(String category, String subCategory) {
        return productDao.readByCategory(category,subCategory);
    }

    @Override
    public List<Product> readAll() {
        LOGGER.info("ProductServiceImpl -> readAll");
        return productDao.readAll();
    }

    @Override
    public void insert(String name, String description, double price, String category, String subCategory, String imagePath) {
        LOGGER.info("ProductServiceImpl -> insert");
        productDao.insert(name, description,price, category, subCategory, imagePath);
    }

    @Override
    public void deleteById(int id) {
        LOGGER.info("ProductServiceImpl -> deleteById");
        productDao.deleteById(id);
    }

    @Override
    public void updateProductById(int id, String name, String description, double price, String category, String subCategory) {
        LOGGER.info("ProductServiceImpl -> updateProductById");
        productDao.updateById(id, new Product(name,description,price, category, subCategory));
    }

    @Override
    public void updateProductNameById(int id, String name) {
        LOGGER.info("ProductServiceImpl -> updateProductNameById");
        Optional<Product> optional = productDao.readById(id);
        if (optional.isPresent()){
            Product product = optional.get();
            product.setName(name);
            productDao.updateById(id, product);
        }else System.out.println("Товару під таким ID не існує");
    }

    @Override
    public void updateProductDescriptionById(int id, String description) {
        LOGGER.info("ProductServiceImpl -> updateProductDescriptionById");
        Optional<Product> optional = productDao.readById(id);
        if (optional.isPresent()){
            Product product = optional.get();
            product.setDescription(description);
            productDao.updateById(id, product);
        }else System.out.println("Товару під таким ID не існує");
    }

    @Override
    public void updateProductPriceById(int id, double price) {
        LOGGER.info("ProductServiceImpl -> updateProductPriceById");
        Optional<Product> optional = productDao.readById(id);
        if (optional.isPresent()){
            Product product = optional.get();
            product.setPrice(price);
            productDao.updateById(id, product);
        }else System.out.println("Товару під таким ID не існує");
    }

    @Override
    public String joinImageNameById(int productId) {
        return productDao.joinImageNameById(productId);
    }
}
