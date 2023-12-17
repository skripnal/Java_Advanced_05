package ua.skripnal.servlet;

import org.apache.log4j.Logger;
import ua.skripnal.dao.UserDao;
import ua.skripnal.daoImpl.BucketDaoImpl;
import ua.skripnal.daoImpl.UserDaoImpl;
import ua.skripnal.eEnum.UserRole;
import ua.skripnal.service.UserService;
import ua.skripnal.serviceImpl.UserServiceImpl;
import ua.skripnal.utils.ConnectionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/registrationServlet")
public class RegistrationServlet extends HttpServlet {
    private static Logger LOGGER = Logger.getLogger(BucketDaoImpl.class);
    private Connection connection;
    private UserDao userDao;
    private UserService userService;

    @Override
    public void init() throws ServletException {
        this.connection = ConnectionUtils.openConnection();
        LOGGER.info("RegistrationServlet -> init");

        userDao = new UserDaoImpl(connection);
        userService = new UserServiceImpl(userDao);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("registrationServlet -> doPost");

        req.setCharacterEncoding("UTF-8");
        userService.insert(req.getParameter("firstName"), req.getParameter("lastName"), req.getParameter("email"), req.getParameter("password"), UserRole.USER.toString());
        resp.getWriter().write("success");
    }
}
