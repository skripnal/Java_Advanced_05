package ua.skripnal.servlet;

import ua.skripnal.dao.BucketDao;
import ua.skripnal.daoImpl.BucketDaoImpl;
import ua.skripnal.model.User;
import ua.skripnal.service.BucketService;
import ua.skripnal.serviceImpl.BucketServiceImpl;
import ua.skripnal.utils.ConnectionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/buyProduct")
public class BuyProductServlet extends HttpServlet {

    private Connection connection;
    private BucketDao bucketDao;
    private BucketService bucketService;
    @Override
    public void init() throws ServletException {
        connection = ConnectionUtils.openConnection();
        bucketDao = new BucketDaoImpl(connection);
        bucketService = new BucketServiceImpl(bucketDao);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null){
            bucketService.insertProductByUserId(user.getId(), Integer.parseInt(req.getParameter("productIdAdd")));
            resp.getWriter().write("success");
        }else {
            resp.getWriter().write("null");
        }
    }
}
