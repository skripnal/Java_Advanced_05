package ua.skripnal.daoImpl;

import ua.skripnal.dao.ProductDao;
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
    private final String INSERT = "insert into product(name, description, price) values (?,?,?)";
    private final String READALL = "select * from product";
    private final String UPDATEBYID = "update product set name=?,description=?,price=? where id=?";
    private final String DELETEBYID = "delete from product where id=?";
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public ProductDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Optional<Product> readById(int id) {
        try {
            preparedStatement = connection.prepareStatement(READBYID);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return Optional.of(new Product(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getDouble("price"),
                        resultSet.getTimestamp("create_date").toLocalDateTime()));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public List<Product> readAll() {
        try {
            preparedStatement = connection.prepareStatement(READALL);
            resultSet = preparedStatement.executeQuery();
            List<Product> productList = new ArrayList<>();
            while (resultSet.next()){
                productList.add(new Product(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getDouble("price"),
                        resultSet.getTimestamp("create_date").toLocalDateTime()));
            }
            return productList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insert(String name, String description, double price) {
        try {
            preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, description);
            preparedStatement.setDouble(3, price);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateById(int id, Product product) {
        try {
            preparedStatement = connection.prepareStatement(UPDATEBYID);
            preparedStatement.setString(1,product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setDouble(3,product.getPrice());
            preparedStatement.setInt(4,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(int id) {
        try {
            preparedStatement = connection.prepareStatement(DELETEBYID);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
