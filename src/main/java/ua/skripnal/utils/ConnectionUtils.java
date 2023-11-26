package ua.skripnal.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {

    private static final String USER_NAME = "skripnal";
    private static final String USER_PASSWORD = "s1141978u";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/project";

    public static Connection openConnection()  {
        try {
            Class.forName ("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection (URL, USER_NAME, USER_PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
