package ua.skripnal.daoImpl;

import org.apache.log4j.Logger;
import ua.skripnal.dao.ProductDao;
import ua.skripnal.model.CustomProductBucket;
import ua.skripnal.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDaoImpl implements ProductDao {
    private final String READBYID = "select * from product where id=?";
    private final String INSERT = "insert into product(name, description, price, category, sub_category, image_path) values (?,?,?,?,?,?)";
    private final String READALL = "select * from product";
    private final String READBYCATEGORY = "select * from product where category = ? and sub_category = ?";
    private final String UPDATEBYID = "update product set name=?,description=?,price=? where id=?";
    private final String DELETEBYID = "delete from product where id=?";
    private final String readALLProductBucket = "SELECT \n" +
            "    bucket.id AS bucket_id,\n" +
            "    product.id AS product_id,\n" +
            "    product.name,\n" +
            "    product.description,\n" +
            "    product.price,\n" +
            "    product.category,\n" +
            "    product.sub_category,\n" +
            "    product.create_date AS product_create_date,\n" +
            "    product.image_path\n" +
            "FROM \n" +
            "    bucket\n" +
            "JOIN \n" +
            "    product ON bucket.product_id = product.id\n" +
            "WHERE bucket.user_id = ?";

    private static Logger LOGGER = Logger.getLogger(ProductDaoImpl.class);

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public ProductDaoImpl(Connection connection) {
        LOGGER.info("ProductDaoImpl -> constructor");
        this.connection = connection;
    }

    @Override
    public List<CustomProductBucket> readALLProductBucket(int userId) {
        try {
            preparedStatement = connection.prepareStatement(readALLProductBucket);
            preparedStatement.setInt(1, userId);
            resultSet = preparedStatement.executeQuery();
            List<CustomProductBucket> customProductBuckets = new ArrayList<>();
            while (resultSet.next()){
                customProductBuckets.add(new CustomProductBucket(resultSet.getInt("product_id"),
                        resultSet.getInt("bucket_id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getDouble("price"),
                        resultSet.getString("category"),
                        resultSet.getString("sub_category"),
                        resultSet.getTimestamp("product_create_date").toLocalDateTime(),
                        resultSet.getString("image_path")));
            }
            return customProductBuckets;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Product> readById(int id) {
        try {
            LOGGER.info("ProductDaoImpl -> readById");
            preparedStatement = connection.prepareStatement(READBYID);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return Optional.of(new Product(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getDouble("price"),
                        resultSet.getString("category"),
                        resultSet.getString("sub_category"),
                        resultSet.getTimestamp("create_date").toLocalDateTime(),
                        resultSet.getString("image_path")));
            }
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public List<Product> readByCategory(String category, String subCategory) {
        try {
            preparedStatement = connection.prepareStatement(READBYCATEGORY);
            preparedStatement.setString(1,category);
            preparedStatement.setString(2, subCategory);
            resultSet = preparedStatement.executeQuery();
            List<Product> productList = new ArrayList<>();
            while (resultSet.next()){
                productList.add(new Product(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getDouble("price"),
                        resultSet.getString("category"),
                        resultSet.getString("sub_category"),
                        resultSet.getTimestamp("create_date").toLocalDateTime(),
                        resultSet.getString("image_path")));
            }
            return productList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> readAll() {
        try {
            LOGGER.info("ProductDaoImpl -> readAll");
            preparedStatement = connection.prepareStatement(READALL);
            resultSet = preparedStatement.executeQuery();
            List<Product> productList = new ArrayList<>();
            while (resultSet.next()){
                productList.add(new Product(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getDouble("price"),
                        resultSet.getString("category"),
                        resultSet.getString("sub_category"),
                        resultSet.getTimestamp("create_date").toLocalDateTime(),
                        resultSet.getString("image_path")));
            }
            return productList;
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insert(String name, String description, double price, String category, String subCategory, String imagePath) {
        try {
            LOGGER.info("ProductDaoImpl -> insert");
            preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, description);
            preparedStatement.setDouble(3, price);
            preparedStatement.setString(4, category);
            preparedStatement.setString(5, subCategory);
            preparedStatement.setString(6, imagePath);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateById(int id, Product product) {
        try {
            LOGGER.info("ProductDaoImpl -> updateById");
            preparedStatement = connection.prepareStatement(UPDATEBYID);
            preparedStatement.setString(1,product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setDouble(3,product.getPrice());
            preparedStatement.setInt(4,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(int id) {
        try {
            LOGGER.info("ProductDaoImpl -> deleteById");
            preparedStatement = connection.prepareStatement(DELETEBYID);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public String joinImageNameById(int productId) {
        return "";
    }
}
