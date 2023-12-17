package ua.skripnal.servlet;

import org.apache.log4j.Logger;
import ua.skripnal.dao.UserDao;
import ua.skripnal.daoImpl.BucketDaoImpl;
import ua.skripnal.daoImpl.UserDaoImpl;
import ua.skripnal.eEnum.UserRole;
import ua.skripnal.model.User;
import ua.skripnal.service.UserService;
import ua.skripnal.serviceImpl.UserServiceImpl;
import ua.skripnal.utils.ConnectionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.util.Optional;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private static Logger LOGGER = Logger.getLogger(BucketDaoImpl.class);
    private Connection connection;
    private UserDao userDao;
    private UserService userService;
    @Override
    public void init() throws ServletException {
        this.connection = ConnectionUtils.openConnection();
        LOGGER.info("LoginServlet -> init");

        userDao = new UserDaoImpl(connection);
        userService = new UserServiceImpl(userDao);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("LoginServlet -> doPost");
        Optional<User> optionalUser = userService.readByEmail(req.getParameter("email"));

        if (optionalUser.isPresent()){
            User user = optionalUser.get();
            if (user.getPassword().equals(req.getParameter("password"))){
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                session.setAttribute("status" , "log");
                if (user.getRole().equals(UserRole.USER.toString())){
                    resp.getWriter().write("user");
                }else if (user.getRole().equals(UserRole.ADMIN.toString())){
                    resp.getWriter().write("admin");
                }

            }
        }else resp.getWriter().write("error");

    }
}
