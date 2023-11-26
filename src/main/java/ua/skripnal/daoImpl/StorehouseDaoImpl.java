package ua.skripnal.daoImpl;

import ua.skripnal.dao.StorehouseDao;
import ua.skripnal.model.Storehouse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StorehouseDaoImpl implements StorehouseDao {

    private final String READPRODUCTBYID = "select * from storehouse where product_id=?";
    private final String READALL = "select * from storehouse";
    private final String INSERT = "insert into storehouse(product_id, count) values (?,?)";
    private final String UPDATEBYPRODUCTID = "update storehouse set count=? where product_id=?";
    private final String DELETEPRODUCTBYID = "delete from storehouse where product_id=?";
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public StorehouseDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Optional<Storehouse> readProductById(int productId) {
        try {
            preparedStatement = connection.prepareStatement(READPRODUCTBYID);
            preparedStatement.setInt(1,productId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return Optional.of(new Storehouse(resultSet.getInt("product_id"),
                        resultSet.getInt("count")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public List<Storehouse> readAll() {
        try {
            preparedStatement = connection.prepareStatement(READALL);
            List<Storehouse> storehouseList = new ArrayList<>();
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                storehouseList.add(new Storehouse(resultSet.getInt("product_id"),
                        resultSet.getInt("count")));
            }
            return storehouseList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insertProduct(int productId, int count) {
        try {
            preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setInt(1,productId);
            preparedStatement.setInt(2,count);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateByProductId(int productId, int count) {
        try {
            preparedStatement = connection.prepareStatement(UPDATEBYPRODUCTID);
            preparedStatement.setInt(1, count);
            preparedStatement.setInt(2,productId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteProductById(int productId) {
        try {
            preparedStatement = connection.prepareStatement(DELETEPRODUCTBYID);
            preparedStatement.setInt(1, productId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
