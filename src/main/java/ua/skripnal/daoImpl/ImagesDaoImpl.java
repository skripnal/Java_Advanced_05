package ua.skripnal.daoImpl;

import ua.skripnal.dao.ImagesDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ImagesDaoImpl implements ImagesDao {
    private final String INSERT = "insert into images(img_name) values(?)";

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    public ImagesDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(String imgName) {
        try {
            preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1,imgName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
