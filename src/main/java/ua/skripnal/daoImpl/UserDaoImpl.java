package ua.skripnal.daoImpl;

import org.apache.log4j.Logger;
import ua.skripnal.dao.UserDao;
import ua.skripnal.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {

    private final String READBYID = "select * from user where id=?";
    private final String READBYEMAIL = "select * from user where email=?";
    private final String INSERT = "insert into user(first_name, last_name, email, password, role) values (?,?,?,?,?)";
    private final String READALL = "select * from user";
    private final String UPDATEBYID = "update user set first_name=?,last_name=?,email=?,password=?,role=? where id=?";
    private final String DELETEBYID = "delete from user where id=?";

    private static Logger LOGGER = Logger.getLogger(UserDaoImpl.class);

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public UserDaoImpl(Connection connection) {
        LOGGER.info("UserDaoImpl -> constructor");
        this.connection = connection;
    }

    @Override
    public Optional<User> readById(int id) {
        try {
            LOGGER.info("UserDaoImpl -> readById");
            preparedStatement = connection.prepareStatement(READBYID);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return Optional.of(new User(resultSet.getInt("id"),
                                resultSet.getString("first_name"),
                                resultSet.getString("last_name"),
                                resultSet.getString("email"),
                                resultSet.getString("password"),
                                resultSet.getString("role"),
                                resultSet.getTimestamp("create_date").toLocalDateTime()));
            }
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> readByEmail(String email) {
        try {
            LOGGER.info("UserDaoImpl -> readByEmail");
            preparedStatement = connection.prepareStatement(READBYEMAIL);
            preparedStatement.setString(1,email);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return Optional.of(new User(resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("role"),
                        resultSet.getTimestamp("create_date").toLocalDateTime()));
            }
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public List<User> readAll() {
        try {
            LOGGER.info("UserDaoImpl -> readAll");
            preparedStatement = connection.prepareStatement(READALL);
            List<User> userList = new ArrayList<>();
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                userList.add(new User(resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("role"),
                        resultSet.getTimestamp("create_date").toLocalDateTime()));
            }
            return userList;
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insert(String firstName, String lastName, String email, String password, String role) {
        try {
            LOGGER.info("UserDaoImpl -> insert");
            preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1,firstName);
            preparedStatement.setString(2,lastName);
            preparedStatement.setString(3,email);
            preparedStatement.setString(4,password);
            preparedStatement.setString(5,role);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updateById(int id, User user) {
        try {
            LOGGER.info("UserDaoImpl -> updateById");
            preparedStatement = connection.prepareStatement(UPDATEBYID);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getRole());
            preparedStatement.setInt(6,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(int id) {
        try {
            LOGGER.info("UserDaoImpl -> deleteById");
            preparedStatement = connection.prepareStatement(DELETEBYID);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new RuntimeException(e);
        }
    }
}
