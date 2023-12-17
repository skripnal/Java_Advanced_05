package ua.skripnal.daoImpl;

import org.apache.log4j.Logger;
import ua.skripnal.Main;
import ua.skripnal.dao.BucketDao;
import ua.skripnal.model.Bucket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BucketDaoImpl implements BucketDao {

    private final String READBYUSERID = "select * from bucket where user_id=?";
    private final String READALL = "select * from bucket";
    private final String INSERT = "insert into bucket(user_id, product_id) values(?,?)";
    private final String DELETEBYUSERID = "delete from bucket where user_id=? and product_id=?";
    private final String DELETE = "delete from bucket where id = ?";

    private static Logger LOGGER = Logger.getLogger(BucketDaoImpl.class);
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public BucketDaoImpl(Connection connection) {
        LOGGER.info("BucketDaoImpl -> constructor");
        this.connection = connection;
    }

    @Override
    public void deleteProduct(int id) {
        try {
            preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Bucket> readAllByUserId(int userId) {
        try {
            LOGGER.info("BucketDaoImpl -> readAllByUserId");
            preparedStatement = connection.prepareStatement(READBYUSERID);
            List<Bucket> list = new ArrayList<>();
            preparedStatement.setInt(1,userId);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                list.add(new Bucket(resultSet.getInt("id"),
                        resultSet.getInt("user_id"),
                        resultSet.getInt("product_id"),
                        resultSet.getTimestamp("added_date").toLocalDateTime()));
            }
            return list;
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Bucket> readAll() {
        try {
            LOGGER.info("BucketDaoImpl -> readAll");
            preparedStatement = connection.prepareStatement(READALL);
            List<Bucket> list = new ArrayList<>();
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                list.add(new Bucket(resultSet.getInt("id"),
                        resultSet.getInt("user_id"),
                        resultSet.getInt("product_id"),
                        resultSet.getTimestamp("added_date").toLocalDateTime()));
            }
            return list;
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insertProductByUserId(int userId, int productId) {
        try {
            LOGGER.info("BucketDaoImpl -> insertProductByUserId");
            preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2,productId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteProductByUserId(int userId, int productId) {
        try {
            LOGGER.info("BucketDaoImpl -> deleteProductByUserId");
            preparedStatement = connection.prepareStatement(DELETEBYUSERID);
            preparedStatement.setInt(1,userId);
            preparedStatement.setInt(2,productId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new RuntimeException(e);
        }
    }
}
