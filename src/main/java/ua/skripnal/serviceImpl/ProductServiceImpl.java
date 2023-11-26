package ua.skripnal.serviceImpl;

import ua.skripnal.dao.ProductDao;
import ua.skripnal.model.Product;
import ua.skripnal.service.ProductService;

import java.util.Optional;

public class ProductServiceImpl implements ProductService {
    ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public void readById(int id) {
        Optional<Product> optional = productDao.readById(id);
        if (optional.isPresent()){
            System.out.println(optional.get());
        }else System.out.println("Товару під таким ID не існує");
    }

    @Override
    public void readAll() {
        for (Product product : productDao.readAll()){
            System.out.println(product);
        }
    }

    @Override
    public void insert(String name, String description, double price) {
        productDao.insert(name, description,price);
    }

    @Override
    public void deleteById(int id) {
        productDao.deleteById(id);
    }

    @Override
    public void updateProductById(int id, String name, String description, double price) {
        productDao.updateById(id, new Product(name,description,price));
    }

    @Override
    public void updateProductNameById(int id, String name) {
        Optional<Product> optional = productDao.readById(id);
        if (optional.isPresent()){
            Product product = optional.get();
            product.setName(name);
            productDao.updateById(id, product);
        }else System.out.println("Товару під таким ID не існує");
    }

    @Override
    public void updateProductDescriptionById(int id, String description) {
        Optional<Product> optional = productDao.readById(id);
        if (optional.isPresent()){
            Product product = optional.get();
            product.setDescription(description);
            productDao.updateById(id, product);
        }else System.out.println("Товару під таким ID не існує");
    }

    @Override
    public void updateProductPriceById(int id, double price) {
        Optional<Product> optional = productDao.readById(id);
        if (optional.isPresent()){
            Product product = optional.get();
            product.setPrice(price);
            productDao.updateById(id, product);
        }else System.out.println("Товару під таким ID не існує");
    }
}
