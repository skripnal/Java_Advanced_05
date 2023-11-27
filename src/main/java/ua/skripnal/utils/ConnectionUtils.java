package ua.skripnal.utils;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import ua.skripnal.daoImpl.BucketDaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {

    private static final String USER_NAME = "skripnal";
    private static final String USER_PASSWORD = "s1141978u";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/project";

    private static Logger LOGGER = Logger.getLogger(BucketDaoImpl.class);
    public static Connection openConnection()  {
        LOGGER.info("ConnectionUtils -> openConnection");
        try {
            DOMConfigurator.configure("log4j.xml");
            Class.forName ("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection (URL, USER_NAME, USER_PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            LOGGER.error(e);
            throw new RuntimeException(e);
        }
    }
}
